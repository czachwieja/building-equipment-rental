package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Rental;
import pl.coderslab.repository.RentalRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {

    private RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }


    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public List<Rental> getAllRentalsByEquipmentId(Long equipmentId) {
        return rentalRepository.findAllByEquipmentId(equipmentId);
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public void deleteRental(Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }


//    public List<Rental> getRentalsByEquipmentIdWithin30Days(Long equipmentId) {
//        return rentalRepository.findFirst3ByEquipmentIdAndRentalDateGreaterThan(equipmentId, LocalDate.now());
//    }

    public LinkedHashMap<LocalDate, Boolean> isRentedByEquipmentId(Long equipmentId) {

        LinkedHashMap<LocalDate, Boolean> isRentedByDay = new LinkedHashMap<>();
        List<Rental> rentalList = rentalRepository.findFirst30ByEquipmentIdAndRentalDateGreaterThanEqual(equipmentId, LocalDate.now());

        List<LocalDate> rentalLocalDates = rentalList.stream()
                .map(Rental::getRentalDate)
                .collect(Collectors.toList());

        for (LocalDate localDate = LocalDate.now(); localDate.isBefore(LocalDate.now().plusDays(10)); localDate = localDate.plusDays(1)) {
            if (rentalLocalDates.contains(localDate)) {
                isRentedByDay.put(localDate, true);
            } else {
                isRentedByDay.put(localDate, false);
            }
        }

//        Set<LocalDate> keys = isRentedByDay.keySet();
//        for(LocalDate k:keys){
//            System.out.println(k+" "+isRentedByDay.get(k));
//        }

        return isRentedByDay;
    }

}
