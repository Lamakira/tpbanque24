package bj.ifri.tpbanque23.repositories;

import bj.ifri.tpbanque23.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
