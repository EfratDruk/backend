package com.example.demo.controller;

import com.example.demo.model.Matchmaker;
import com.example.demo.service.MatchmakerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/matchmaker")
@CrossOrigin
public class MatchmakerController {

        private MatchmakerRepository matchmakerRepository;


        public MatchmakerController(MatchmakerRepository matchmakerRepository) {
            this.matchmakerRepository = matchmakerRepository;
        }
        @GetMapping("/matchmaker")
        public ResponseEntity<List<Matchmaker>> getMatchmaker(){
            return new ResponseEntity<>(matchmakerRepository.findAll(), HttpStatus.OK);
        }
        @GetMapping("/matchmakerById/{id}")
        public ResponseEntity<Matchmaker> getMatchmakerById(@PathVariable long id){
            Matchmaker matchmaker=matchmakerRepository.findById(id).orElse(null);
            if(matchmaker==null){
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(matchmaker,HttpStatus.OK);
        }

        @PostMapping("/addMatchmaker")
        public ResponseEntity<Matchmaker> addMatchmaker(@RequestBody Matchmaker matchmaker){
            Matchmaker newMatchmaker=matchmakerRepository.save(matchmaker);
            return new ResponseEntity<>(newMatchmaker,HttpStatus.CREATED);
        }

        @PutMapping("/updateMatchmaker/{id}")
        public ResponseEntity<Matchmaker> updateMatchmaker(@RequestBody Matchmaker matchmaker,@PathVariable Long id){
            Matchmaker newMatchmaker=matchmakerRepository.findById(id).orElse(null);
            if(newMatchmaker==null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            if(matchmaker.getId()!=id){
                return new ResponseEntity<>(matchmaker,HttpStatus.CONFLICT);
            }
            newMatchmaker=matchmakerRepository.save(matchmaker);
            return new ResponseEntity<>(newMatchmaker, HttpStatus.CREATED);
        }

        @DeleteMapping("/deleteMatchmaker/{id}")
        public ResponseEntity deleteMatchmaker(@PathVariable Long id){
            Matchmaker matchmaker=matchmakerRepository.findById(id).orElse(null);
            if(matchmaker==null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            matchmakerRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }


    }


