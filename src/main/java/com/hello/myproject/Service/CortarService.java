package com.hello.myproject.Service;

import com.hello.myproject.entity.Article;
import com.hello.myproject.entity.ComplexDto;
import com.hello.myproject.entity.ComplexResponseDto;
import com.hello.myproject.entity.ComplexResponseRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CortarService {
    private final RestTemplate restTemplate;
    private final UriBuilderService uriBuilderService;
    private static final String GET_BUILDING_LIST = "https://m.land.naver.com/complex/ajax/complexListByCortarNo";

    public List<ComplexDto> findBuildingList(String code) {
        if(!StringUtils.hasText(code)) return null;

        URI uri = uriBuilderService.buildUriGetBuildingList(code);
        
        ComplexResponseDto allBuildingList = restTemplate.exchange(uri, HttpMethod.GET, getHttpEntityHeader(), ComplexResponseDto.class).getBody();

        return allBuildingList.getResult()
                .stream().filter(ComplexDto -> ComplexDto.getHscpTypeNm().equals("아파트"))
                .collect(Collectors.toList());
    }

    public Integer findArticleList(String code) {
        if(!StringUtils.hasText(code)) return null;
        String nextExist = "Y";
        int page = 1;
        while (nextExist.equals("Y")) {
            URI uri = uriBuilderService.buildArticleListUri(code, page);
            ComplexResponseRes result = restTemplate.exchange(uri, HttpMethod.GET, getHttpEntityHeader(), ComplexResponseRes.class).getBody();
            log.info("uri = {}", uri);
            page++;
            nextExist = result.getResult().getNextPage();
        }
        return page;
    }

    private static HttpEntity<Object> getHttpEntityHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        return httpEntity;
    }

}
