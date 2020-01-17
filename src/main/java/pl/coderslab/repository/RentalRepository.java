package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Rental;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Override
    <S extends Rental> S save(S s);

    List<Rental> findAllByEquipmentId(Long id);

    List<Rental> findFirst5ByEquipmentIdAndRentalDateGreaterThan(Long id, LocalDate todayDate);

}
