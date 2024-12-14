package com.example.demo.controller;

import com.example.demo.model.Siblings;
import com.example.demo.service.SiblingsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/siblings")
@CrossOrigin
public class SiblingsController {
        private SiblingsRepository siblingsRepository;


        public SiblingsController(SiblingsRepository siblingsRepository) {
            this.siblingsRepository = siblingsRepository;
        }
        @GetMapping("/siblings")
        public ResponseEntity<List<Siblings>> getSiblings(){
            return new ResponseEntity<>(siblingsRepository.findAll(), HttpStatus.OK);
        }
        @GetMapping("/siblingsById/{id}")
        public ResponseEntity<Siblings> getSiblingsById(@PathVariable long id){
            Siblings siblings=siblingsRepository.findById(id).orElse(null);
            if(siblings==null){
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(siblings,HttpStatus.OK);
        }

        @PostMapping("/addSiblings")
        public ResponseEntity<Siblings> addSiblings(@RequestBody Siblings siblings){
            Siblings newSiblings=siblingsRepository.save(siblings);
            return new ResponseEntity<>(newSiblings,HttpStatus.CREATED);
        }

        @PutMapping("/updateSiblings/{id}")
        public ResponseEntity<Siblings> updateSiblings(@RequestBody Siblings siblings,@PathVariable Long id){
            Siblings newSiblings=siblingsRepository.findById(id).orElse(null);
            if(newSiblings==null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            if(siblings.getId()!=id){
                return new ResponseEntity<>(siblings,HttpStatus.CONFLICT);
            }
            newSiblings=siblingsRepository.save(siblings);
            return new ResponseEntity<>(newSiblings, HttpStatus.CREATED);
        }

        @DeleteMapping("/deleteSiblings/{id}")
        public ResponseEntity deleteSiblings(@PathVariable Long id){
            Siblings siblings=siblingsRepository.findById(id).orElse(null);
            if(siblings==null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            siblingsRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }


    }



