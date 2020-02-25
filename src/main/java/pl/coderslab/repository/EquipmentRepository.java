package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    Equipment findEquipmentById(Long equipmentId);
}
