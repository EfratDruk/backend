package com.example.demo.controller;

import com.example.demo.model.Man;
import com.example.demo.service.ManRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/man")
@CrossOrigin
public class ManController {
        private ManRepository manRepository;


        public ManController(ManRepository manRepository) {
            this.manRepository = manRepository;
        }
        @GetMapping("/man")
        public ResponseEntity<List<Man>> getMan(){
            return new ResponseEntity<>(manRepository.findAll(), HttpStatus.OK);
        }
        @GetMapping("/manById/{id}")
        public ResponseEntity<Man> getManById(@PathVariable long id){
            Man man=manRepository.findById(id).orElse(null);
            if(man==null){
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(man,HttpStatus.OK);
        }

        @PostMapping("/addMan")
        public ResponseEntity<Man> addMan(@RequestBody Man man){
            Man newMan=manRepository.save(man);
            return new ResponseEntity<>(newMan,HttpStatus.CREATED);
        }

        @PutMapping("/updateMan/{id}")
        public ResponseEntity<Man> updateMan(@PathVariable Long id,@RequestBody Man man){
            System.out.println("im in update--------------------------------------------------");
            Man newMan=manRepository.findById(id).orElse(null);
            if(newMan==null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            if(!man.getId().equals(id)){
                return new ResponseEntity<>(man,HttpStatus.CONFLICT);
            }
            newMan=manRepository.save(man);
            return new ResponseEntity<>(newMan, HttpStatus.CREATED);
        }

        @DeleteMapping("/deleteMan/{id}")
        public ResponseEntity deleteMan(@PathVariable Long id){
            Man man=manRepository.findById(id).orElse(null);
            if(man==null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            manRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }


    }



