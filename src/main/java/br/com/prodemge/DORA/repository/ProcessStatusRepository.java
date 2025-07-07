package br.com.prodemge.DORA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prodemge.DORA.model.ProcessStatus;

@Repository
public interface ProcessStatusRepository extends JpaRepository<ProcessStatus, Long> {
}
