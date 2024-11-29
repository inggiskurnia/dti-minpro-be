package com.miniproject.eventure.usecase.geography;

import com.miniproject.eventure.entity.geography.Province;

import java.util.List;

public interface GetProvinceUseCase {
    List<Province> getAllProvince();
    Province getProvince(String name);
}
