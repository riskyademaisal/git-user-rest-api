package com.example.demo.client;

import org.springframework.stereotype.Component;

import com.example.demo.dto.GitSearchUserRespDTO;
//import com.github.ethancommitpush.feign.annotation.FeignClient;

@Component
public class GitSearchUsersClientFallback  {

    public GitSearchUserRespDTO getGitUsers(String q){
        return new GitSearchUserRespDTO();
    }

}