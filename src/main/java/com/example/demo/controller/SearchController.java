package com.example.demo.controller;

import com.example.demo.payload.SearchModel;
import com.example.demo.service.SearchService;
import com.example.demo.entity.Search;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    
    SearchService service;

    public SearchController(SearchService service ) {
        this.service = service;
    }


    @GetMapping("/{q}")
    public ResponseEntity<byte[]>  getOneSearch(@PathVariable("q") String q) {
        Search  result = service.search_create(q);
        return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + result.getKeywordByUsername() + result.getCreatedAt()+ ".pdf"+ "\"")
        .body(result.getData());
    }

    @GetMapping("/history")
    public ResponseEntity<List<String>> getAllHistory() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<byte[]> getAllSearchs(@PathVariable("id") Long id) {
        Search result = service.findById(id);
        return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + result.getKeywordByUsername() + result.getCreatedAt()+ ".pdf"+ "\"")
        .body(result.getData());
    }

    

}
