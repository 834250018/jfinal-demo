package com.ywy.jfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnnotationTestDTO {

    private String strArray;

    private String notNullTest;

//    @Valid
    private UserCreateDTO createDTO;
}
