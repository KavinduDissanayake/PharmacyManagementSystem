package com.example.pmms.service;

import com.example.pmms.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicineService {

    void saveMedicine(Medicine medicine);
    Page<Medicine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection,@Param("keyword") String keyword);



    void deleteMedicineById(long id);
}
