package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessStatusService {
    @Autowired
    private ProcessStatusRepository repository;

    public List<ProcessStatus> findAll() {
        return repository.findAll();
    }

    public ProcessStatus findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProcessStatus create(ProcessStatus entity) {
        return repository.save(entity);
    }

    public ProcessStatus update(Long id, ProcessStatus entity) {
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
