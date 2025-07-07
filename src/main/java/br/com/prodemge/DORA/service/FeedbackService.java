package br.com.prodemge.DORA.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prodemge.DORA.model.Feedback;
import br.com.prodemge.DORA.repository.FeedbackRepository;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository repository;

    public List<Feedback> findAll() {
        return repository.findAll();
    }

    public Feedback findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Feedback create(Feedback entity) {
        return repository.save(entity);
    }

    public Feedback update(Long id, Feedback entity) {
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
