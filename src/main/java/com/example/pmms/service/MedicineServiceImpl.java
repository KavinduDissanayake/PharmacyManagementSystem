package com.example.pmms.service;

import com.example.pmms.model.Medicine;
import com.example.pmms.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class MedicineServiceImpl  implements MedicineService{

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

//    @Override
//    public void saveMedicine(Medicine medicine) {
//        this.medicineRepository.save(medicine);
//    }
}
