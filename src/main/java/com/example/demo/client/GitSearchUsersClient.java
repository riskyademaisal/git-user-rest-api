package com.example.demo.client;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.GitSearchUserRespDTO;
import com.github.ethancommitpush.feign.annotation.FeignClient;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
@FeignClient(url = "${git-api.domain}")
public interface GitSearchUsersClient {

    @RequestLine("GET /search/users?q={q}&per_page=100")
    GitSearchUserRespDTO getGitUsers(@Param("q") String q);

}