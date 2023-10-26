package com.hcl.curd.controller;

import com.hcl.curd.modal.Employe;
import com.hcl.curd.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    private EmployeRepository repository;


    @PostMapping("/v2/saveEmployee")
    public ResponseEntity saveEmploye(@RequestBody Employe emp) {
        if (emp != null) {
            Employe employe = repository.save(emp);
            return new ResponseEntity<>(employe, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Not valid request body", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/v1/saveEmployee")
    public ResponseEntity<String> saveEmploye(@RequestParam Integer id, @RequestParam String name) {
        if (id != null && !name.isEmpty()) {
            Employe emp = repository.save(new Employe(id, name));
            return new ResponseEntity<>("Created Employe with Id : " + emp.getId() + " " + emp.getName(), HttpStatus.CREATED);
        } else return new ResponseEntity<>("Pass valid Id and Name", HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/v1/findAllEmployee")
    public Optional<List<Employe>> findAllEmploee() {
        return Optional.of(repository.findAll());
    }
    @GetMapping("/v1/findEmployee")
    public Employe findEmploee(@RequestParam Integer id) {
        return repository.findById(id).get();
    }

}
