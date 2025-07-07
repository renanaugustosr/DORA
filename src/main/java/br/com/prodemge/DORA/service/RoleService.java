package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Role findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Role create(Role entity) {
        return repository.save(entity);
    }

    public Role update(Long id, Role entity) {
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
