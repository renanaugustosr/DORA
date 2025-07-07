package br.com.prodemge.DORA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prodemge.DORA.model.Document;
import br.com.prodemge.DORA.service.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Document> listAll() {
        return documentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getById(@PathVariable Long id) {
        Document document = documentService.findById(id);
        if (document == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(document);
    }

    @PostMapping
    public ResponseEntity<Document> create(@RequestBody Document document) {
        Document created = documentService.create(document);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> update(@PathVariable Long id, @RequestBody Document document) {
        Document updated = documentService.update(id, document);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        documentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
