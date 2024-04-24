package com.hello.myproject.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

@Service
@Slf4j
public class UriBuilderService {
    private static final String GET_BUILDING_LIST = "https://m.land.naver.com/complex/ajax/complexListByCortarNo";
    private static final String GET_ARTICLE_LIST = "https://m.land.naver.com/complex/getComplexArticleList";

    public URI buildUriGetBuildingList(String code) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(GET_BUILDING_LIST);
        builder.queryParam("cortarNo", code);

        URI uri = builder.build().encode().toUri();
        log.info("URI = {}",uri);

        return uri;
    }

    public URI buildArticleListUri(String building, Integer page) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(GET_ARTICLE_LIST);
        builder.queryParam("hscpNo", building);
        builder.queryParam("tradTpCd", "A1");
        builder.queryParam("order", "prc");
        builder.queryParam("showR0", "N");
        builder.queryParam("page", page);

        URI uri = builder.build().encode().toUri();

        return uri;
    }
}
