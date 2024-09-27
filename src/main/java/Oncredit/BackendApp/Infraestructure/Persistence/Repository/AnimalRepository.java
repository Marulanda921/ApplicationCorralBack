package Oncredit.BackendApp.Infraestructure.Persistence.Repository;

import Oncredit.BackendApp.Domain.Model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findAllById(Iterable<Long> ids);
    List<Animal> findByCorralId(Long corralId);
    List<Animal> findByDangerous(boolean dangerous);
}
