package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.demo.dto.GitSearchUserDTO;
import com.example.demo.entity.Search;
import com.example.demo.service.SearchService;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SearchServiceTest {
  
	private final SearchService searchservice ;

  @Test  
    public void search_create(){  
		try {
			log.info("Starting execution of search_create");
Search expectedValue = null; 
  String q=""; 
 
Search actualValue=searchservice.search_create( q);
	  log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
	  System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-"+exception,exception);
			exception.printStackTrace();
			assertFalse(false);
		}
    }  
 
  @Test  
    public void findById(){  
		try {
			log.info("Starting execution of findById");
Search expectedValue = null; 
  long id=0; 
 
  
 
Search actualValue=searchservice.findById( id);
	  log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
	  System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-"+exception,exception);
			exception.printStackTrace();
			assertFalse(false);
		}
    }  
 
  @Test  
    public void findAll(){  
		try {
			log.info("Starting execution of findAll");
List<String> expectedValue = null; 
   
  
List<String> actualValue=searchservice.findAll();
	  log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
	  System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-"+exception,exception);
			exception.printStackTrace();
			assertFalse(false);
		}
    }  
 
  @Test  
    public void insertTextToPdf(){  
		try {
			log.info("Starting execution of insertTextToPdf");
PdfWriter expectedValue = null; 
  ByteArrayOutputStream baos = null; 
List<GitSearchUserDTO> gitSearchUserDTO = null; 
 
  
PdfWriter actualValue=searchservice.insertTextToPdf( baos ,gitSearchUserDTO);
	  log.info("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
	  System.out.println("Expected Value="+ expectedValue +" . Actual Value="+actualValue);
assertEquals(expectedValue, actualValue);
		} catch (Exception exception) {
			log.error("Exception in execution of execute1GetAllLogFromFirstMovF-"+exception,exception);
			exception.printStackTrace();
			assertFalse(false);
		}
    }  
 
  @Test  
    public void addDataToTable(){  
		try {
			log.info("Starting execution of addDataToTable");
 GitSearchUserDTO user = null; 
PdfPTable table = null; 
 
  
searchservice.addDataToTable( user ,table);
assertTrue(true);
		} catch (Exception exception) {
			log.error("Exception in execution ofaddDataToTable-"+exception,exception);
			exception.printStackTrace();
			assertFalse(false);
		}
    }  
}

