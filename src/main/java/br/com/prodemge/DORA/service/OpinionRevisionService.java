package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prodemge.DORA.model.OpinionRevision;
import br.com.prodemge.DORA.repository.OpinionRevisionRepository;

@Service
public class OpinionRevisionService {
    @Autowired
    private OpinionRevisionRepository repository;

    public List<OpinionRevision> findAll() {
        return repository.findAll();
    }

    public OpinionRevision findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public OpinionRevision create(OpinionRevision entity) {
        return repository.save(entity);
    }

    public OpinionRevision update(Long id, OpinionRevision entity) {
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
