package com.demo.patient.control;

import com.demo.patient.entity.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> findAll() {
        System.out.println("Find all patients!");
        return patientService.getAllPatients();
    }

    @PostMapping
    public Patient createStudent(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping(value = "/{id}")
    public Patient findById(@PathVariable("id") String id) {
        return patientService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePatient(@PathVariable("id") String id) {
        patientService.deleteById(id);
    }

}
