package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository repository;

    public List<UserRole> findAll() {
        return repository.findAll();
    }

    public UserRole findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UserRole create(UserRole entity) {
        return repository.save(entity);
    }

    public UserRole update(Long id, UserRole entity) {
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
