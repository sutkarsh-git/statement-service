package com.taxapp.statementservice.services;

import com.taxapp.statementservice.model.PdfFile;
import org.springframework.web.multipart.MultipartFile;

public interface PdfService {

    void savePdfFile(PdfFile pdf);
}
