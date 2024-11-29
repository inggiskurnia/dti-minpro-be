package com.miniproject.eventure.infrastructure.geography.dto;

import com.miniproject.eventure.entity.geography.Province;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProvinceRequestDTO {
    @NotEmpty(message = "Name cannot be empty")
    String name;

    public Province toEntity(){
        Province province = new Province();
        province.setName(name);
        return province;
    }
}

