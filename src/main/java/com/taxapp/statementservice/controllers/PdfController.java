package com.taxapp.statementservice.controllers;

import com.taxapp.statementservice.model.PdfFile;
import com.taxapp.statementservice.services.PdfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class PdfController {
    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @RequestMapping({"", "/", "/index"})
    public String home() {
        System.out.println("Enter the home() method");
        return "index";
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        System.out.println("Inside showUploadForm method");
        model.addAttribute("pdfFile", new PdfFile());
        return "uploadform";
    }

    @PostMapping("/pdf-file")
    public String handleFileUpload(@ModelAttribute("pdfFile") PdfFile pdfFile, RedirectAttributes redirectAttributes) throws IOException {
        pdfService.savePdfFile(pdfFile);
        redirectAttributes.addFlashAttribute("message", "The PDF file has been uploaded successfully.");
        return "redirect:/upload";
    }

}
