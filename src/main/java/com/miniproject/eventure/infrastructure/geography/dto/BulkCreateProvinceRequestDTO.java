package com.miniproject.eventure.infrastructure.geography.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulkCreateProvinceRequestDTO {
    private List<CreateProvinceRequestDTO> provinces;
}
