package com.pharmacie.pharmacie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PharmacieController {
@Autowired
private PharmacieService service;

@GetMapping("/pharmacies")
public List<Pharmacie> list() {
	return service.listAll();
}

 

}
