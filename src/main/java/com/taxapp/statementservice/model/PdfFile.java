package com.taxapp.statementservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pdf_files")
public class PdfFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "content")
    private byte[] content;

    public PdfFile() {
    }

    public PdfFile(Long id, String name, byte[] content) {
        Id = id;
        this.name = name;
        this.content = content;
    }
}
