package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Equipment;
import pl.coderslab.model.Rental;
import pl.coderslab.service.EquipmentService;
import pl.coderslab.service.RentalService;

import java.time.LocalDate;

@Controller
public class RentalController {

    private RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }


    @GetMapping("/add-rental/{equipmentId}/{rentalDate}")
    public String addRental(@PathVariable("equipmentId") Long equipmentId, @PathVariable("rentalDate") LocalDate rentalDate) {
        Equipment equipment
        Rental rental = new Rental();

        rentalService.saveRental(rental);
        return "redirect:/";
    }

    @GetMapping("/all-rentals/{equipmentId}")
    public String getAllRentalsByEquipmentId(@PathVariable("equipmentId") Long equipmentId, Model model) {
        model.addAttribute("rentalsByEquipmentId", rentalService.getAllRentalsByEquipmentId(equipmentId));
        return "all-rentals";
    }

    @GetMapping("/all-rentals")
    public String getAllRentals(Model model) {
        model.addAttribute("rentals", rentalService.getAllRentals());
        return "all-rentals";
    }

    @PostMapping("/rental/{equipmentId}")
    public String getRentalsByEquipmentId(@PathVariable("equipmentId") Long equipmentId, Model model) {
        model.addAttribute("rentalsByEquipmentId", rentalService.getRentalsByEquipmentIdWithin30Days(equipmentId));
//        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("equipmentId", equipmentId);
        return "rental";
    }

//    @GetMapping("/rental/{equipmentName}")
//    public String getRentalsByEquipmentId(@PathVariable("equipmentName") String equipmentName, Model model) {
//
//        Equipment equipment = null;
//        equipment.setName(equipmentName);
//        Long equipmentId = equipment.getId();
//        model.addAttribute("rentalsByEquipmentId", rentalService.getRentalsByEquipmentIdWithin30Days(equipmentId));
//        return "rental";
//    }

}
