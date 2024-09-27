package Oncredit.BackendApp.Infraestructure.Persistence.Repository;

import Oncredit.BackendApp.Domain.Model.Corral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorralRepository extends JpaRepository<Corral, Long> {
}
