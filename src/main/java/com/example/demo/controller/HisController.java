package com.example.demo.controller;

import com.example.demo.model.His;
import com.example.demo.service.HisRepository;
import com.example.demo.service.HisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/his")
@CrossOrigin
public class HisController {

    private HisRepository hisRepository;


    public HisController(HisRepository hisRepository) {
        this.hisRepository = hisRepository;
    }
    @GetMapping("/his")
    public ResponseEntity<List<His>> getHis(){
        return new ResponseEntity<>(hisRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/hisById/{id}")
    public ResponseEntity<His> getHisById(@PathVariable long id){
        His his=hisRepository.findById(id).orElse(null);
        if(his==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(his,HttpStatus.OK);
    }

    @PostMapping("/addHis")
    public ResponseEntity<His> addHis(@RequestBody His his){
        His newHis=hisRepository.save(his);
        return new ResponseEntity<>(newHis,HttpStatus.CREATED);
    }

    @PutMapping("/updateHis/{id}")
    public ResponseEntity<His> updateHis(@RequestBody His his,@PathVariable Long id){
        His newHis=hisRepository.findById(id).orElse(null);
        if(newHis==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        if(his.getId()!=id){
            return new ResponseEntity<>(his,HttpStatus.CONFLICT);
        }
        newHis=hisRepository.save(his);
        return new ResponseEntity<>(newHis, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteHis/{id}")
    public ResponseEntity deleteHis(@PathVariable Long id){
        His his=hisRepository.findById(id).orElse(null);
        if(his==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        hisRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}

