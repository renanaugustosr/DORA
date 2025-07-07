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

import br.com.prodemge.DORA.model.TermAcceptance;
import br.com.prodemge.DORA.service.TermAcceptanceService;

@RestController
@RequestMapping("/terms-acceptance")
public class TermAcceptanceController {

    @Autowired
    private TermAcceptanceService service;

    @GetMapping
    public List<TermAcceptance> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TermAcceptance> getById(@PathVariable Long id) {
        TermAcceptance entity = service.findById(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<TermAcceptance> create(@RequestBody TermAcceptance entity) {
        TermAcceptance created = service.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TermAcceptance> update(@PathVariable Long id, @RequestBody TermAcceptance entity) {
        TermAcceptance updated = service.update(id, entity);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
