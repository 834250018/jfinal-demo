package com.ywy.jfinal.dto;

import com.ywy.jfinal.annotation.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRemoveDTO {

    @NotBlank
    private String id;
}
