package bj.ifri.tpbanque23.repositories;

import bj.ifri.tpbanque23.entities.Banque;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BanqueRepository extends JpaRepository<Banque, Long> {
}
