package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GitSearchUserRespDTO {
    @JsonProperty("total_count")
    Integer totalCount;

    @JsonProperty("incomplete_results")
    Boolean incompleteResults;

    List<GitSearchUserDTO> items;
}
