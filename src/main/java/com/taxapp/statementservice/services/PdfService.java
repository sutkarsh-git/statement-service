package com.taxapp.statementservice.services;

import org.springframework.web.multipart.MultipartFile;

public interface PdfService {

    void savePdfFile(MultipartFile file);
}
