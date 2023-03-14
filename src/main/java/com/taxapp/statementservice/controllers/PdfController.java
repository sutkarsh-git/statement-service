package com.taxapp.statementservice.controllers;

import com.taxapp.statementservice.model.PdfFile;
import com.taxapp.statementservice.repositories.PdfRepository;
import com.taxapp.statementservice.services.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PdfController {
    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("pdfFile", new PdfFile());
        return "uploadform";
    }

    @PostMapping("/pdf-file")
    public String handleFileUpload(@ModelAttribute("pdfFile") PdfFile pdfFile) throws IOException {
        pdfService.savePdfFile(pdfFile);
        return "uploadform";
    }

}
