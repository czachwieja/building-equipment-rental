package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Rental;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findAllByEquipmentId(Long id);

    List<Rental> findFirst30ByEquipmentIdAndRentalDateGreaterThanEqual(Long id, LocalDate todayDate);

    Rental findRentalById(Long id);

    Long countRentalByEquipmentIdAndRentalDate(Long equipmentId, LocalDate rentalDate);
}
