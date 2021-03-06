package com.example.pmms.controller;

import com.example.pmms.model.Medicine;
import com.example.pmms.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        return findPaginated(1, "id", "asc", model,keyword);
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model, @Param("keyword") String keyword) {


        int pageSize = 5;

        Page<Medicine> page = medicineService.findPaginated(pageNo, pageSize, sortField, sortDir,keyword);
        List<Medicine> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listMedicines",listEmployees);

        return "index";
    }

    @GetMapping("/showNewMedicineForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Medicine medicine = new Medicine();
        model.addAttribute("medicine", medicine);
        return "add_medicine";
    }

    @PostMapping("/saveMedicine")
    public String saveMedicine(@ModelAttribute("medicine") Medicine medicine) {
        // save employee to database
        medicineService.saveMedicine(medicine);

        return "redirect:/";
    }

    @GetMapping("/deleteMedicine/{id}")
	public String deleteMedicine(@PathVariable (value = "id") long id) {
		// call delete employee method
		this.medicineService.deleteMedicineById(id);
		return "redirect:/";
	}



    @GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

		// get employee from the service
		Medicine medicine = medicineService.getMedicineById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("medicine", medicine);
		return "update_medicine";
	}

}
