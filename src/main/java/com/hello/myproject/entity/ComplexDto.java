package com.hello.myproject.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ComplexDto {
    private String hscpNo;
    private String hscpNm;
    private String hscpTypeCd;
    private String hscpTypeNm;
    private String lat;
    private String lng;
    private String cortarNo;
    private Integer dealCnt;
    private Integer leaseCnt;
    private Integer rentCnt;
    private Integer strmRentCnt;
    private Integer hasBookMark;
}
