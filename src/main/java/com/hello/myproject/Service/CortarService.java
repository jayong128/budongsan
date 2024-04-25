package com.hello.myproject.Service;

import com.hello.myproject.config.RandomUserAgent;
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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CortarService {
    private final RestTemplate restTemplate;
    private final UriBuilderService uriBuilderService;
    private final RandomUserAgent randomUserAgent;

    public List<ComplexDto> findBuildingList(String code) {
        if(!StringUtils.hasText(code)) return null;

        URI uri = uriBuilderService.buildUriGetBuildingList(code);
        
        ComplexResponseDto allBuildingList = restTemplate.exchange(uri, HttpMethod.GET, getHttpEntityHeader(), ComplexResponseDto.class).getBody();

        return allBuildingList.getResult()
                .stream().filter(ComplexDto -> ComplexDto.getHscpTypeNm().equals("아파트"))
                .collect(Collectors.toList());
    }

    public List<Article> findArticleList(String code) {
        if(!StringUtils.hasText(code)) return null;
        List<Article> res = new ArrayList<>();
        URI totalUri = uriBuilderService.buildArticleListUri(code, 0);
        Integer total = restTemplate.exchange(totalUri, HttpMethod.GET, getHttpEntityHeader(), ComplexResponseRes.class).getBody()
                .getResult().getTotal();
        int endPage = total/20+1;
        try {
            for (int page=1; page<=endPage; page++){
                URI uri = uriBuilderService.buildArticleListUri(code, page);
                ComplexResponseRes result = restTemplate.exchange(uri, HttpMethod.GET, getHttpEntityHeader(), ComplexResponseRes.class).getBody();
                res.addAll(result.getResult().getList());
            }
            log.info("res size = {}",res.size());
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Article> findArticleListByArea(String code) throws InterruptedException {
        if(!StringUtils.hasText(code)) return null;
        List<Article> result = new ArrayList<>();
        List<ComplexDto> buildingList = findBuildingList(code);

        for (ComplexDto complexDto : buildingList) {
            Thread.sleep(randomUserAgent.getRandomDelayTime());
            List<Article> articleList = findArticleList(complexDto.getHscpNo());
            result.addAll(articleList);
        }
        return result;
    }
    private HttpEntity<Object> getHttpEntityHeader() {
        HttpHeaders headers = new HttpHeaders();
        String userAgent = randomUserAgent.getRandomUserAgent();
        headers.set(HttpHeaders.USER_AGENT, userAgent);
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        return httpEntity;
    }

}
