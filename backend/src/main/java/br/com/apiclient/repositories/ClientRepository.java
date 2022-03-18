package br.com.apiclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apiclient.entities.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
