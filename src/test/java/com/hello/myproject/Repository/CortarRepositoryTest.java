package com.hello.myproject.Repository;

import com.hello.myproject.entity.Cortar;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CortarRepositoryTest {
    @Autowired
    private CortarRepository cortarRepository;

    @Test
    public void test_find() {
        Cortar cortar = cortarRepository.findById("4100000000").get();
        Assertions.assertThat(cortar.getCortarName()).isEqualTo("경기도");
    }
}