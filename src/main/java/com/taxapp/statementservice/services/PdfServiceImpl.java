package com.taxapp.statementservice.services;

import com.taxapp.statementservice.model.PdfFile;
import com.taxapp.statementservice.repositories.PdfRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class PdfServiceImpl implements PdfService {

    private PdfRepository pdfRepository;

    public PdfServiceImpl(PdfRepository pdfRepository) {
        this.pdfRepository = pdfRepository;
    }

    @Override
    @Transactional
    public void savePdfFile(PdfFile pdf) {

        try {
            // Setting parameters into PDF object
            // Setting the name
            pdf.setName(pdf.getMultipartFile().getName());

            // Setting the array of Bytes
            Byte[] byteObjects = new Byte[pdf.getMultipartFile().getBytes().length];

            int i = 0;

            for (byte b : pdf.getMultipartFile().getBytes()) {
                byteObjects[i++] = b;
            }

            pdf.setContent(byteObjects);

        } catch (IOException e) {
            log.error("An error ocurred while loading the file!", e);

            e.printStackTrace();
        }


    }
}
