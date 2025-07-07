package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prodemge.DORA.model.Document;
import br.com.prodemge.DORA.repository.DocumentRepository;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    public Document findById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    public Document create(Document document) {
        return documentRepository.save(document);
    }

    public Document update(Long id, Document document) {
        return documentRepository.findById(id)
                .map(existing -> {
                    existing.setFileName(document.getFileName());
                    existing.setStoragePath(document.getStoragePath());
                    return documentRepository.save(existing);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        documentRepository.deleteById(id);
    }
}
