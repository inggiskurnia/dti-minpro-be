package com.miniproject.eventure.usecase.geography;

import com.miniproject.eventure.entity.geography.Province;
import com.miniproject.eventure.infrastructure.geography.dto.BulkCreateProvinceRequestDTO;
import com.miniproject.eventure.infrastructure.geography.dto.CreateProvinceRequestDTO;

import java.util.List;

public interface CreateProvinceUseCase {
    Province createProvince(CreateProvinceRequestDTO req);
    List<Province> bulkCreateProvince(BulkCreateProvinceRequestDTO req);
}
