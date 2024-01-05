package bj.ifri.tpbanque23.repositories;

import bj.ifri.tpbanque23.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
