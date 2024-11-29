package com.miniproject.eventure.usecase.geography.impl;

import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.exeptions.EmptyRequestDataException;
import com.miniproject.eventure.entity.geography.Province;
import com.miniproject.eventure.infrastructure.geography.dto.BulkCreateProvinceRequestDTO;
import com.miniproject.eventure.infrastructure.geography.dto.CreateProvinceRequestDTO;
import com.miniproject.eventure.infrastructure.geography.repository.ProvinceRepository;
import com.miniproject.eventure.usecase.geography.CreateProvinceUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateProvinceUseCaseImpl implements CreateProvinceUseCase {
    private final ProvinceRepository provinceRepository;

    public CreateProvinceUseCaseImpl(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Province createProvince(CreateProvinceRequestDTO req) {
        Optional<Province> resultProvince = provinceRepository.findByName(req.getName());
        if (resultProvince.isPresent()){
            throw new DuplicateRequestDataException("Province already exist");
        }
        Province newProvince = req.toEntity();
        return provinceRepository.save(newProvince);
    }

    @Override
    public List<Province> bulkCreateProvince(BulkCreateProvinceRequestDTO req) {
        // Check if the request list is null or empty
        if (req.getProvinces() == null || req.getProvinces().isEmpty()) {
            throw new EmptyRequestDataException("Provinces list cannot be null or empty");
        }

        // Extract names from the request
        List<String> reqProvinceNames = req.getProvinces().stream()
                .map(CreateProvinceRequestDTO::getName)
                .toList();

        // Find existing provinces by name in the database
        List<Province> existingProvinces = provinceRepository.findByNameIn(reqProvinceNames);

        // Extract names of existing provinces
        List<String> existingProvinceNames = existingProvinces.stream()
                .map(Province::getName)
                .toList();

        // Check for duplicates
        List<String> duplicateProvinceNames = reqProvinceNames.stream()
                .filter(existingProvinceNames::contains)
                .toList();

        if (!duplicateProvinceNames.isEmpty()) {
            throw new DuplicateRequestDataException("Duplicate province name(s): " + duplicateProvinceNames);
        }

        // Filter out the duplicates and convert to entities
        List<Province> provinceList = req.getProvinces().stream()
                .filter(dto -> !existingProvinceNames.contains(dto.getName()))
                .map(CreateProvinceRequestDTO::toEntity)
                .toList();

        // Save the new provinces to the repository
        provinceRepository.saveAll(provinceList);

        return provinceList;
    }

}
