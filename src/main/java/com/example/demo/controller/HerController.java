package com.example.demo.controller;

import com.example.demo.model.Her;
import com.example.demo.service.HerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/her")
@CrossOrigin
public class HerController {
    private HerRepository herRepository;


    public HerController(HerRepository herRepository) {
        this.herRepository = herRepository;
    }
    @GetMapping("/her")
    public ResponseEntity<List<Her>> getHer(){
        return new ResponseEntity<>(herRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/herById/{id}")
    public ResponseEntity<Her> getHerById(@PathVariable long id){
        Her her=herRepository.findById(id).orElse(null);
        if(her==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(her,HttpStatus.OK);
    }

    @PostMapping("/addHer")
    public ResponseEntity<Her> addHer(@RequestBody Her her){
        Her newHer=herRepository.save(her);
        return new ResponseEntity<>(newHer,HttpStatus.CREATED);
    }

    @PutMapping("/updateHer/{id}")
    public ResponseEntity<Her> updateHer(@RequestBody Her her,@PathVariable Long id){
        Her newHer=herRepository.findById(id).orElse(null);
        if(newHer==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        if(her.getId()!=id){
            return new ResponseEntity<>(her,HttpStatus.CONFLICT);
        }
        newHer=herRepository.save(her);
        return new ResponseEntity<>(newHer, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteHer/{id}")
    public ResponseEntity deleteHer(@PathVariable Long id){
        Her her=herRepository.findById(id).orElse(null);
        if(her==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        herRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
