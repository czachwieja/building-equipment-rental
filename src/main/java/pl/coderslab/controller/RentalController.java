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


    @PostMapping("/add-rental")
    public String addRental(@ModelAttribute Rental rental) {
        rental = new Rental();
        rentalService.saveRental(rental);
        return "redirect:/";
    }

    @GetMapping("/all-rental/{equipmentId}")
    public String getAllRentalsByEquipmentId(@PathVariable("equipmentId") Long equipmentId, Model model) {
        model.addAttribute("rentalsByEquipmentId", rentalService.getAllRentalsByEquipmentId(equipmentId));
        return "allrental";
    }

    @PostMapping("/rental/{equipmentId}")
    public String getRentalsByEquipmentId(@PathVariable("equipmentId") Long equipmentId, Model model) {
        model.addAttribute("rentalsByEquipmentId", rentalService.getRentalsByEquipmentIdWithin30Days(equipmentId));
        model.addAttribute("localDate", LocalDate.now());
//        model.addAttribute("")
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
