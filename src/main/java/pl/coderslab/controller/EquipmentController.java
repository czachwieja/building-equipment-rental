package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.model.Rental;
import pl.coderslab.service.EquipmentService;

@Controller
public class EquipmentController {

    private EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("allEquipment", equipmentService.getAllEquipment());
//        model.addAttribute("newRental", new Rental());
        return "index";
    }

}
