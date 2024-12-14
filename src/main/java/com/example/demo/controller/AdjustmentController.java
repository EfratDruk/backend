package com.example.demo.controller;

import com.example.demo.model.Adjustment;
import com.example.demo.service.AdjustmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/adjustment")
@CrossOrigin
public class AdjustmentController {
private AdjustmentRepository adjustmentRepository;
public AdjustmentController(AdjustmentRepository adjustmentRepository) {
    this.adjustmentRepository = adjustmentRepository;
}
@GetMapping("/adjustments")
public ResponseEntity<List<Adjustment>> getAdjustments(){
    return new ResponseEntity<>(adjustmentRepository.findAll(), HttpStatus.OK);
}
@GetMapping("/adjustmentById/{id}")
    public ResponseEntity<Adjustment> getAdjustmentById(@PathVariable long id){
    Adjustment adjustment=adjustmentRepository.findById(id).orElse(null);
    if(adjustment==null){
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(adjustment,HttpStatus.OK);
}

@PostMapping("/addAdjustment")
    public ResponseEntity<Adjustment> addAdjustment(@RequestBody Adjustment adjustment){
    Adjustment newAdjustment=adjustmentRepository.save(adjustment);
    return new ResponseEntity<>(newAdjustment,HttpStatus.CREATED);
}

@PutMapping("/updateAdjustment/{id}")
    public ResponseEntity<Adjustment> updateAdjustment(@RequestBody Adjustment adjustment,@PathVariable Long id){
       Adjustment newAdjustment=adjustmentRepository.findById(id).orElse(null);
       if(newAdjustment==null){
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
       if(adjustment.getId()!=id){
           return new ResponseEntity<>(adjustment,HttpStatus.CONFLICT);
       }
       newAdjustment=adjustmentRepository.save(adjustment);
       return new ResponseEntity<>(newAdjustment, HttpStatus.CREATED);
}

@DeleteMapping("/deleteAdjustment/{id}")
    public ResponseEntity deleteAdjustment(@PathVariable Long id){
    Adjustment adjustment=adjustmentRepository.findById(id).orElse(null);
    if(adjustment==null){
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    adjustmentRepository.deleteById(id);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
}


}
