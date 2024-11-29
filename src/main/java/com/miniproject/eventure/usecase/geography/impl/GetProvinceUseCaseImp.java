package com.miniproject.eventure.usecase.geography.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.geography.Province;
import com.miniproject.eventure.infrastructure.geography.repository.ProvinceRepository;
import com.miniproject.eventure.usecase.geography.GetProvinceUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetProvinceUseCaseImp implements GetProvinceUseCase {
    private final ProvinceRepository provinceRepository;

    public GetProvinceUseCaseImp(final ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    @Override
    public List<Province> getAllProvince() {
        return provinceRepository.findAll();
    }

    @Override
    public Province getProvince(String name) {
        return provinceRepository.findByName(name).orElseThrow(()-> new DataNotFoundException("Province name not found !"));
    }
}
