package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prodemge.DORA.model.Opinion;
import br.com.prodemge.DORA.repository.OpinionRepository;

@Service
public class OpinionService {
    @Autowired
    private OpinionRepository repository;

    public List<Opinion> findAll() {
        return repository.findAll();
    }

    public Opinion findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Opinion create(Opinion entity) {
        return repository.save(entity);
    }

    public Opinion update(Long id, Opinion entity) {
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
