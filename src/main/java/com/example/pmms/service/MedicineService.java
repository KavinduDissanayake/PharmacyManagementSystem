package com.example.pmms.service;

import com.example.pmms.model.Medicine;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MedicineService {
    List<Medicine> getAllMedicines();
    void saveMedicine(Medicine medicine);

    Page<Medicine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
