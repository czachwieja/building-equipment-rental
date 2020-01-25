package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.model.Equipment;
import pl.coderslab.model.Rental;
import pl.coderslab.model.User;
import pl.coderslab.service.CurrentUser;
import pl.coderslab.service.EquipmentService;
import pl.coderslab.service.RentalService;

import java.time.LocalDate;

@Controller
public class RentalController {

    private RentalService rentalService;
    private EquipmentService equipmentService;

    public RentalController(RentalService rentalService, EquipmentService equipmentService) {
        this.rentalService = rentalService;
        this.equipmentService = equipmentService;
    }

    @GetMapping("/rental/add/{equipmentId}/{rentalDate}")
    public String addRental(@PathVariable("equipmentId") Long equipmentId,
                            @PathVariable("rentalDate") String stringRentalDate,
                            @AuthenticationPrincipal CurrentUser currentUser) {
        Equipment equipment = equipmentService.getEquipmentById(equipmentId);
        LocalDate rentalDate = LocalDate.parse(stringRentalDate);
        rentalService.saveRental(new Rental(equipment, rentalDate, currentUser.getUser()));
        return "redirect:/";
    }

    @PostMapping("/rental/{equipmentId}")
    public String getRentalsByEquipmentId(@PathVariable("equipmentId") Long equipmentId, Model model) {
        model.addAttribute("isRentedByEquipmentId", rentalService.isRentedByEquipmentId(equipmentId));
        model.addAttribute("equipmentId", equipmentId);
        Equipment equipment = equipmentService.getEquipmentById(equipmentId);
        model.addAttribute("equipmentName", equipment.getName());
        return "rental";
    }

//    @GetMapping("/rental/{equipmentName}")
//    public String getRentalsByEquipmentId(@PathVariable("equipmentName") String equipmentName, Model model) {
//
//        Equipment equipment = equipmentService.getEquipmentByName(equipmentName);
//        Long equipmentId = equipment.getId();
//        model.addAttribute("rentalsByEquipmentId", rentalService.isRentedByEquipmentId(equipmentId));
//        return "rental";
//    }

}
