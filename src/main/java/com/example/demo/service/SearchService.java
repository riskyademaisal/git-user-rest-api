package com.example.demo.service;

import com.example.demo.client.GitSearchUsersClient;
import com.example.demo.dto.GitSearchUserDTO;
import com.example.demo.dto.GitSearchUserRespDTO;
import com.example.demo.entity.Search;
import com.example.demo.repository.SearchRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.persistence.EntityNotFoundException;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository repository;
    private final PdfService pdfService;
	private final GitSearchUsersClient gitSearchUsersClient;

    @CircuitBreaker(name = "CircuitBreakerService")
    public Search search_create(String q) {
        try {
            GitSearchUserRespDTO respGit = gitSearchUsersClient.getGitUsers(q);
         var searchToSave = Search.builder()
                .total(respGit.getTotalCount())
                .keywordByUsername(q)
                .build();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
            this.insertTextToPdf(baos, respGit.getItems()).flush();
            byte[] pdfAsBytes = baos.toByteArray();
            
            searchToSave = Search.builder()
                .total(respGit.getTotalCount())
                .keywordByUsername(q)
                .type("pdf")
                .data(pdfAsBytes)
                .build();

                //release memory used
                pdfAsBytes = null;

                try {
                    baos.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }

               return repository.save(searchToSave);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            
        }
    
        return null;
    }

    public Search findById(long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Value("${server.url}")
    private String serverUrl;

    @Value("${server.port}")
    private String serverPort;

    public List<String> findAll() {
        List <Search> dataList = repository.findAll().stream().sorted(Comparator.comparing(Search::getId)).toList();
        List <String> outputList = dataList.stream()
        .map(i -> "History your download ["+i.getCreatedAt()+"]:"+ this.serverUrl.concat(":").concat(this.serverPort).concat("/search/history/"+i.getId())).collect(Collectors.toList());

        return outputList;
    }


    public PdfWriter  insertTextToPdf(ByteArrayOutputStream baos, List<GitSearchUserDTO> gitSearchUserDTO) throws FileNotFoundException, DocumentException{
        Document document = new Document();
        
        PdfPTable table = new PdfPTable(3);
        pdfService.addTableHeader(table);

        gitSearchUserDTO.forEach( user ->
            this.addDataToTable(user,table)
        );
        
        PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);
        document.open();
        document.add(table);
        document.close();

        return pdfWriter;
    }


    public void addDataToTable(GitSearchUserDTO user, PdfPTable table){
        List<String> values = new ArrayList<String>();
        values.add(user.getLogin());
        values.add(user.getAvatar());
        values.add(user.getUrl());
        pdfService.addRows(table, values);
    }

    
}
