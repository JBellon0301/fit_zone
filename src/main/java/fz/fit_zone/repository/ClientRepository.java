package fz.fit_zone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fz.fit_zone.model.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
