package com.miniproject.eventure.usecase.geography.impl;

import com.miniproject.eventure.entity.geography.Province;
import com.miniproject.eventure.infrastructure.geography.dto.CreateProvinceRequestDTO;
import com.miniproject.eventure.infrastructure.geography.repository.ProvinceRepository;
import com.miniproject.eventure.usecase.geography.CreateProvinceUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateProvinceUseCaseImpl implements CreateProvinceUseCase {
    private final ProvinceRepository provinceRepository;

    public CreateProvinceUseCaseImpl(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Province createProvince(CreateProvinceRequestDTO req) {
        Province newProvince = req.toEntity();
        return provinceRepository.save(newProvince);
    }
}
