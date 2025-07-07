package br.com.prodemge.DORA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prodemge.DORA.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
