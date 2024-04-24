package com.hello.myproject.Service;

import org.junit.jupiter.api.Test;

import java.net.URI;
class UriBuilderServiceTest {

    private UriBuilderService service;
    @Test
    void buildArticleListUri() {
        service = new UriBuilderService();
        URI uri = service.buildArticleListUri("4145010900", 1);

        System.out.println("uri = " + uri);
    }
}