package com.hello.myproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ComplexArticleResponseDto {
    @JsonProperty("totAtclCnt")
    private Integer total;

    @JsonProperty("moreDataYn")
    private String nextPage;

    @JsonProperty("list")
    private List<Article> list;
}
