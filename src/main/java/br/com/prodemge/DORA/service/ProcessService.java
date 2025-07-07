package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prodemge.DORA.repository.ProcessRepository;
import br.com.prodemge.DORA.model.Process;

@Service
public class ProcessService {
    @Autowired
    private ProcessRepository repository;

    public List<Process> findAll() {
        return repository.findAll();
    }

    public Process findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Process create(Process entity) {
        return repository.save(entity);
    }

    public Process update(Long id, Process entity) {
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
