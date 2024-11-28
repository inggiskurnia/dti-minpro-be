package com.miniproject.eventure.infrastructure.geography.dto;

import com.miniproject.eventure.entity.geography.Province;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProvinceRequestDTO {
    String name;

    public Province toEntity(){
        Province province = new Province();
        province.setName(name);
        return province;
    }
}

