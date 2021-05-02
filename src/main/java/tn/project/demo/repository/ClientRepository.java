package tn.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.project.demo.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
