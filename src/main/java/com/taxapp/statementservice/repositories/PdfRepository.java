package com.taxapp.statementservice.repositories;

import com.taxapp.statementservice.model.PdfFile;
import org.springframework.data.repository.CrudRepository;

public interface PdfRepository extends CrudRepository<PdfFile, Long> {

}
