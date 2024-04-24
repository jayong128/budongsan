package com.hello.myproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
public class ComplexResponseDto {

    @JsonProperty("result")
    private List<ComplexDto> result;

    @JsonProperty("secInfo")
    private CortarResponseDto secInfo;

    @JsonProperty("dvsnInfo")
    private CortarResponseDto dvsnInfo;

    @JsonProperty("cityInfo")
    private CortarResponseDto cityInfo;

    @JsonProperty("loginYN")
    private String loginYN;
}
