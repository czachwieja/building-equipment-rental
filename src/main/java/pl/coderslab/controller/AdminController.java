package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.EquipmentService;
import pl.coderslab.service.RentalService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    EquipmentService equipmentService;
    RentalService rentalService;

    public AdminController(EquipmentService equipmentService, RentalService rentalService) {
        this.equipmentService = equipmentService;
        this.rentalService = rentalService;
    }

    @GetMapping("/")
    public String homeAdmin(Model model){
        model.addAttribute("allEquipment", equipmentService.getAllEquipment());
        return "admin";
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

}
