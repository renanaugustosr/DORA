package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessTypeService {
    @Autowired
    private ProcessTypeRepository repository;

    public List<ProcessType> findAll() {
        return repository.findAll();
    }

    public ProcessType findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProcessType create(ProcessType entity) {
        return repository.save(entity);
    }

    public ProcessType update(Long id, ProcessType entity) {
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
