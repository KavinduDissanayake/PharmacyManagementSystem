package com.example.pmms.controller;

import com.example.pmms.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listMedicines",medicineService.getAllMedicines());

        return "index";
    }


}
