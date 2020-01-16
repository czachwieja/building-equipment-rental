package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Rental;
import pl.coderslab.repository.RentalRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
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

//    public List<Rental> getRentalsByEquipmentIdWithin30Days(Long equipmentId) {
//        return rentalRepository.findFirst3ByEquipmentIdAndRentalDateGreaterThan(equipmentId, LocalDate.now());
//    }

    public LinkedHashMap<LocalDate, String> getRentalsByEquipmentIdWithin30Days(Long equipmentId) {
//        List<RentalUtil> rentalUtilList = new ArrayList<>();
        LinkedHashMap<LocalDate, String> localDateStringLinkedHashMap = new LinkedHashMap<>();
        List<Rental> rentalList = rentalRepository.findFirst3ByEquipmentIdAndRentalDateGreaterThan(equipmentId, LocalDate.now());
//        for (int i = 0; i < rentalList.size(); i++) {
//            LocalDate localDate;
//            for (int j=0; j<=)
//        }
        List<LocalDate> rentalLocalDates = rentalList.stream()
                .map(Rental::getRentalDate)
                .collect(Collectors.toList());
//        LocalDate localDate2 = LocalDate.now()
//        for (int i = 0; i < 30; i++) {
//            if (rentalLocalDates.contains(localDate2)) {
//
//            } else {
//
//            }
//        }
        for (LocalDate localDate = LocalDate.now(); localDate.isBefore(LocalDate.now().plusDays(10)); localDate = localDate.plusDays(1)) {
            if (rentalLocalDates.contains(localDate)) {
                localDateStringLinkedHashMap.put(localDate, "red");
            } else {
                localDateStringLinkedHashMap.put(localDate, "green");
            }
        }

        Set<LocalDate> keys = localDateStringLinkedHashMap.keySet();
        for(LocalDate k:keys){
            System.out.println(k+" "+localDateStringLinkedHashMap.get(k));
        }
        return localDateStringLinkedHashMap;
    }

}
