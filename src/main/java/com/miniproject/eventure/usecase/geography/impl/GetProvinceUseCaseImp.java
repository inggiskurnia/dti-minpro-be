package com.miniproject.eventure.usecase.geography.impl;

import com.miniproject.eventure.entity.geography.Province;
import com.miniproject.eventure.infrastructure.geography.repository.ProvinceRepository;
import com.miniproject.eventure.usecase.geography.GetProvinceUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
