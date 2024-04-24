package com.hello.myproject.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Article {
    private String atclNo;
    private String atclNm;
    private String bildNm;
    private String tradTpNm;
    private String rletTpNm;
    private String spc1;
    private String spc2;
    private String flrInfo;
    private String cfmYmd;
    private String sameAddrHash;
    private String sameAddrMaxPrc;
    private String sameAddrMinPrc;
}
