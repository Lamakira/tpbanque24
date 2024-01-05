package bj.ifri.tpbanque23.repositories;

import bj.ifri.tpbanque23.entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long>  {
}
