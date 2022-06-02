package com.example.pmms.repository;

import com.example.pmms.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long>{

    @Query("SELECT p FROM Medicine p WHERE CONCAT(p.name, ' ', p.purpose, ' ', p.expiredDate, ' ', p.price) LIKE %?1%")
    Page<Medicine> search(String keyword, Pageable pageable);


}
