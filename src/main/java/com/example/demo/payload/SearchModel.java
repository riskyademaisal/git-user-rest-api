package com.example.demo.payload;

import lombok.Data;

@Data
public class SearchModel {
    private String keywordByUsername;
    private Integer totalCount;
    private Boolean incomplete_results; 
    private User items;
}
