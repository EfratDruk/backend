//package com.example.demo.controller;
//
//import com.example.demo.model.PhonesForInquiries;
//import com.example.demo.service.PhonesForInquiriesRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@RestController
//@RequestMapping("api/requirements")
//@CrossOrigin
//public class RequirementsController {
//
//    private RequirementsRepository RequirementsRepository ;
//
//
//    public PhonesForInquiriesController(PhonesForInquiriesRepository phonesForInquiriesRepository) {
//        this.phonesForInquiriesRepository = phonesForInquiriesRepository;
//    }
//    @GetMapping("/phonesForInquiries")
//    public ResponseEntity<List<PhonesForInquiries>> getPhonesForInquiries(){
//        return new ResponseEntity<>(phonesForInquiriesRepository.findAll(), HttpStatus.OK);
//    }
//    @GetMapping("/phonesForInquiriesById/{id}")
//    public ResponseEntity<PhonesForInquiries> getPhonesForInquiriesById(@PathVariable long id){
//        PhonesForInquiries phonesForInquiries=phonesForInquiriesRepository.findById(id).orElse(null);
//        if(phonesForInquiries==null){
//            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(phonesForInquiries,HttpStatus.OK);
//    }
//
//    @PostMapping("/addPhonesForInquiries")
//    public ResponseEntity<PhonesForInquiries> addPhonesForInquiries(@RequestBody PhonesForInquiries phonesForInquiries){
//        PhonesForInquiries newPhonesForInquiries=phonesForInquiriesRepository.save(phonesForInquiries);
//        return new ResponseEntity<>(newPhonesForInquiries,HttpStatus.CREATED);
//    }
//
//    @PutMapping("/updatePhonesForInquiries/{id}")
//    public ResponseEntity<PhonesForInquiries> updatePhonesForInquiries(@RequestBody PhonesForInquiries phonesForInquiries,@PathVariable Long id){
//        PhonesForInquiries newPhonesForInquiries=phonesForInquiriesRepository.findById(id).orElse(null);
//        if(newPhonesForInquiries==null){
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//        if(phonesForInquiries.getId()!=id){
//            return new ResponseEntity<>(phonesForInquiries,HttpStatus.CONFLICT);
//        }
//        newPhonesForInquiries=phonesForInquiriesRepository.save(phonesForInquiries);
//        return new ResponseEntity<>(newPhonesForInquiries, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/deletePhonesForInquiries/{id}")
//    public ResponseEntity deletePhonesForInquiries(@PathVariable Long id){
//        PhonesForInquiries phonesForInquiries=phonesForInquiriesRepository.findById(id).orElse(null);
//        if(phonesForInquiries==null){
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//        phonesForInquiriesRepository.deleteById(id);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
//
//
//}
//
//
//
