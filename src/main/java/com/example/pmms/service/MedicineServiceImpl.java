package com.example.pmms.service;

import com.example.pmms.model.Medicine;
import com.example.pmms.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class MedicineServiceImpl  implements MedicineService{

    @Autowired
    private MedicineRepository medicineRepository;


    @Override
    public void saveMedicine(Medicine medicine) {
        this.medicineRepository.save(medicine);
    }



	@Override
	public Page<Medicine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, @Param("keyword") String keyword) {

		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();

        //to handle pagination error
        if (pageNo < 1){
            pageNo = 1;
        }
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);


        //search handel
        if (keyword != null) {
         return    this.medicineRepository.search(keyword,pageable);
        }


		return this.medicineRepository.findAll(pageable);
	}
}
