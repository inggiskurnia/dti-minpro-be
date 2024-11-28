package com.miniproject.eventure.usecase.geography;

import com.miniproject.eventure.entity.geography.Province;
import com.miniproject.eventure.infrastructure.geography.dto.CreateProvinceRequestDTO;

public interface CreateProvinceUseCase {
    Province createProvince(CreateProvinceRequestDTO req);
}
