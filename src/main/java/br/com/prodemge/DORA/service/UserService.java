package br.com.prodemge.DORA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prodemge.DORA.model.User;
import br.com.prodemge.DORA.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User create(User entity) {
        return repository.save(entity);
    }

    public User update(Long id, User entity) {
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

    public boolean authenticate(String email, String password) {
        return repository.findByEmailAndPassword(email, password).isPresent();
    }
}
