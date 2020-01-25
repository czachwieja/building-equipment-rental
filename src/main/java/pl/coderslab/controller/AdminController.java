package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Equipment;
import pl.coderslab.model.Rental;
import pl.coderslab.service.CurrentUser;
import pl.coderslab.service.EquipmentService;
import pl.coderslab.service.RentalService;

import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class AdminController {

    EquipmentService equipmentService;
    RentalService rentalService;

    public AdminController(EquipmentService equipmentService, RentalService rentalService) {
        this.equipmentService = equipmentService;
        this.rentalService = rentalService;
    }

//    @GetMapping("/")
//    public String homeAdmin(Model model) {
//        model.addAttribute("allEquipment", equipmentService.getAllEquipment());
//        return "admin";
//    }

    @GetMapping("/home")
    public String homeAdmin() {
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

    @GetMapping("/rental/delete/{rentalId}")
    public String deleteRental(@PathVariable("rentalId") Long rentalId) {
        rentalService.deleteRental(rentalId);
        return "redirect:/admin/all-rentals";
    }

    @GetMapping("/rental/edit/{rentalId}")
    public String editRental(@PathVariable("rentalId") Long rentalId, Model model) {
        model.addAttribute("rentalToEdit", rentalService.getRentalById(rentalId));
        return "edit-rental";
    }

    @PostMapping("/update-rental/{rentalId}")
    public String updateRental(@PathVariable Long rentalId, Rental rental, Model model) {

        LocalDate dateToUpdate = rental.getRentalDate();
//        System.out.println(dateToUpdate);
        Rental rentalToUpdate = rentalService.getRentalById(rentalId);


        Long equipmentId = rental.getEquipment().getId();
//        System.out.println("eID: " + equipmentId);

//        System.out.println("COUNT: "+rentalService.countRentalByEquipmentIdAndRentalDate(equipmentId, dateToUpdate));
        Long count = rentalService.countRentalByEquipmentIdAndRentalDate(equipmentId, dateToUpdate);

        if (count == 0) {
            rentalToUpdate.setRentalDate(dateToUpdate);
            rentalService.saveRental(rentalToUpdate);
            model.addAttribute("rentals", rentalService.getAllRentals());
            return "all-rentals";
        } else {
            return "redirect:/admin/rental/edit/" + rentalId;
        }
    }

}
