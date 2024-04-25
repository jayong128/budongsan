package com.hello.myproject.Service;

import com.hello.myproject.entity.Article;
import com.hello.myproject.entity.ComplexDto;
import com.hello.myproject.entity.ComplexResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest
@Slf4j
class CortarServiceTest {

    @Autowired
    CortarService cortarService;
    @Test
    void findBuildingList() {
        List<ComplexDto> buildingList = cortarService.findBuildingList("4145010900");
        for (ComplexDto complexDto : buildingList) {
            log.info("name = {}, dealcnt = {}, code = {}", complexDto.getHscpNm(), complexDto.getDealCnt(), complexDto.getHscpNo());
        }
    }

    @Test
    void findArticleList() {
        List<Article> articleList = cortarService.findArticleList("105286");
        log.info("size = {}",articleList.size());
    }

    @Test
    void findBuildingAndArticle() throws InterruptedException {
        List<Article> articleListByArea = cortarService.findArticleListByArea("4145010900");
    }
}