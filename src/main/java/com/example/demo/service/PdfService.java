package com.example.demo.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

@Service
public class PdfService {

    public void addTableHeader(PdfPTable table) {
        Stream.of("Login", "Avatar", "URL")
          .forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });
    }

    public void addRows(PdfPTable table, List<String> values) {
        for (String value : values) {
            table.addCell(value);
        }
    }
}