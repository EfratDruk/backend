package com.example.demo.controller;

import com.example.demo.model.Woman;
import com.example.demo.service.WomanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/woman")
@CrossOrigin
public class WomanController {
        private WomanRepository womanRepository;


        public WomanController(WomanRepository womanRepository) {
            this.womanRepository = womanRepository;
        }
        @GetMapping("/woman")
        public ResponseEntity<List<Woman>> getWoman(){
            return new ResponseEntity<>(womanRepository.findAll(), HttpStatus.OK);
        }
        @GetMapping("/womanById/{id}")
        public ResponseEntity<Woman> getWomanById(@PathVariable long id){
            Woman woman=womanRepository.findById(id).orElse(null);
            if(woman==null){
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(woman,HttpStatus.OK);
        }

        @PostMapping("/addWoman")
        public ResponseEntity<Woman> addWoman(@RequestBody Woman woman){
            Woman newWoman=womanRepository.save(woman);
            return new ResponseEntity<>(newWoman,HttpStatus.CREATED);
        }

        @PutMapping("/updateWoman/{id}")
        public ResponseEntity<Woman> updateWoman(@PathVariable Long id,@RequestBody Woman woman){
            System.out.println("id--------"+id);
            System.out.println("woman.id--------"+woman.getId());
            Woman newWoman=womanRepository.findById(id).orElse(null);
            System.out.println("new woman.id---------------"+newWoman.getId());
            if(newWoman==null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            if(!woman.getId().equals(id)) {
                return new ResponseEntity<>(woman, HttpStatus.CONFLICT);
            }
            newWoman=womanRepository.save(woman);
            return new ResponseEntity<>(newWoman, HttpStatus.CREATED);
        }

        @DeleteMapping("/deleteWoman/{id}")
        public ResponseEntity deleteWoman(@PathVariable Long id){
            Woman woman=womanRepository.findById(id).orElse(null);
            if(woman==null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            womanRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }


    }





