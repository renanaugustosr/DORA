package br.com.prodemge.DORA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prodemge.DORA.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
