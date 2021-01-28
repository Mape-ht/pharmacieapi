package com.pharmacie.pharmacie;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PharmacieController {
	@Autowired
	private PharmacieService service;

	@GetMapping("/pharmacies")
	public List<Pharmacie> list() {
		return service.listAll();
	}

	@GetMapping("/pharmacies/{id}")
	public ResponseEntity<Pharmacie> get(@PathVariable Integer id) {
		try {
			Pharmacie pharmacie = service.get(id);
			return new ResponseEntity<Pharmacie>(pharmacie, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pharmacie>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/pharmacies/")
	public void add(@RequestBody Pharmacie pharmacie) {
		service.save(pharmacie);
	}

	@PutMapping("/pharmacies/{id}")
	public ResponseEntity<?> update(@RequestBody Pharmacie pharmacie, @PathVariable Integer id)  {
		try {
		Pharmacie existPharmacie = service.get(id);
		service.save(pharmacie);

		return new ResponseEntity<>(HttpStatus.OK);
	
		}catch(NoSuchElementException e){
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
	
	@DeleteMapping("/pharmacies/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
