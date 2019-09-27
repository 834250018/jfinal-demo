package com.ywy.jfinal.dto;

import com.ywy.jfinal.annotation.Email;
import com.ywy.jfinal.annotation.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnnotationTestDTO {

    @Pattern(regexp = "^1[0-9]{10}$", message = "手机号码不正确")
    private String phoneReg;

    @Email
    private String email;

//    @Valid
    private UserCreateDTO createDTO;
}
