package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prodemge.DORA.model.TermAcceptance;
import br.com.prodemge.DORA.repository.TermAcceptanceRepository;

@Service
public class TermAcceptanceService {
    @Autowired
    private TermAcceptanceRepository repository;

    public List<TermAcceptance> findAll() {
        return repository.findAll();
    }

    public TermAcceptance findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public TermAcceptance create(TermAcceptance entity) {
        return repository.save(entity);
    }

    public TermAcceptance update(Long id, TermAcceptance entity) {
        return repository.findById(id)
                .map(existing -> {
                    BeanUtils.copyProperties(entity, existing, "id");
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
