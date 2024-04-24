package com.hello.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CortarResponseDto {
    private String CortarNo;
    private String CortarNm;
    private String MaxXCrdn;
    private String MapYCrdn;
    private String CortarType;
}
