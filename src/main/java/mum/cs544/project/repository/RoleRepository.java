package mum.cs544.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.project.domain.Role;

public interface RoleRepository extends JpaRepository<Role	, Integer>{

}
