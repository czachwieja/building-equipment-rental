package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Rental;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findAllByEquipmentId(Long id);

//    @Query("select r from Rental r where r.equipment.id :id% ")
//    List<Rental> findRentalsByEquipmentIdWithin30Days(Long id);
    List<Rental> findFirst3ByEquipmentIdAndRentalDateGreaterThan(Long id, LocalDate todayDate);
}
