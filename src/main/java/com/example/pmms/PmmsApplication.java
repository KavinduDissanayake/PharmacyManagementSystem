package com.example.pmms;

import com.example.pmms.model.Medicine;
import com.example.pmms.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PmmsApplication  {
	public static void main(String[] args) {
		SpringApplication.run(PmmsApplication.class, args);
	}

}
