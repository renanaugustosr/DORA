package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository repository;

    public List<Notification> findAll() {
        return repository.findAll();
    }

    public Notification findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Notification create(Notification entity) {
        return repository.save(entity);
    }

    public Notification update(Long id, Notification entity) {
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
