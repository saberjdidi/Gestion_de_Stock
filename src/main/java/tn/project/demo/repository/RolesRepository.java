package tn.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.project.demo.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
