package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Equipment;
import pl.coderslab.repository.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentService {

    private EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

}
