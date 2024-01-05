package bj.ifri.tpbanque23.repositories;

import bj.ifri.tpbanque23.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface ClientRepository extends JpaRepository<Client, Long> {
    //Méthode permettant tous les clients d'une agence
    List<Client> findByAgenceId(Long agencyId);

    // Search clients by last name and first name
    List<Client> findByNomAndPrenom(String nom, String prenom);

    @Query(value = "SELECT * FROM client c, compte_bancaire cb WHERE c.id = cb.client_id and cb.solde < 0", nativeQuery = true)
    public List<Client> findClientDecouvert();// les clients à découvert
}
