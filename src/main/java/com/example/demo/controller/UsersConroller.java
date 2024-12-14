package com.example.demo.controller;
import com.example.demo.dto.ManDTO;
import com.example.demo.dto.UsersDTO;
import com.example.demo.dto.WomanDTO;
import com.example.demo.model.*;
import com.example.demo.model.enums.Gender;
import com.example.demo.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*")
public class UsersConroller {
    private final MapStruct mapper;

    private  MatchmakerRepository matchmakerRepository;
    private ManRepository manRepository;
    private WomanRepository womanRepository;

    private UserRepository userRepository;

    private static String DIRECTORY_URL=System.getProperty("user.dir")+"\\images\\";

    public UsersConroller(MapStruct mapper, ManRepository manRepository, WomanRepository womanRepository, MatchmakerRepository matchmakerRepository, UserRepository userRepository) {
        this.mapper = mapper;
        this.manRepository = manRepository;
        this.womanRepository = womanRepository;
        this.matchmakerRepository = matchmakerRepository;
        this.userRepository = userRepository;
    }

@PostMapping("/findByEmail")
    public  ResponseEntity<Object> findByEmail(@RequestBody Users user) {
    //String email = payload.get("email");
    System.out.println(user.getEmail());
    String email = user.getEmail();
    String password = user.getPassword();
        Man man=manRepository.findByEmail(email);
        if(man!=null){
            if(man.getPassword().equals(password)){
                return new ResponseEntity<>(man, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(man, HttpStatus.CONFLICT);
            }
    }
        Woman woman=womanRepository.findByEmail(email);
        if(woman!=null){
            if(woman.getPassword().equals(password)){
                return new ResponseEntity<>(woman, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(woman, HttpStatus.CONFLICT);
            }
        }
        Matchmaker matchmaker=matchmakerRepository.findByEmail(email);
        if(matchmaker!=null){
            if(matchmaker.getPassword().equals(password)){
            return new ResponseEntity<>(matchmaker, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(matchmaker, HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
}


@PostMapping("createNewUser")
    public ResponseEntity<Users> createNewUser(@RequestBody Users user) {
        //check uniqe password
    String password = user.getPassword();
    System.out.println(user);
    Man manP=manRepository.findByPassword(password);
    Woman womanP=womanRepository.findByPassword(password);
    Matchmaker matchmakerP=matchmakerRepository.findByPassword(password);
    if(matchmakerP!=null){
        return new ResponseEntity<>(manP, HttpStatus.CONFLICT);
    }
    if(womanP==null&&manP==null){
     if (user.getGender()== Gender.MAN) {
         Man man = new Man(user.getName(), user.getEmail(), user.getPassword(), user.getGender());
         man=manRepository.save(man);
         return new ResponseEntity<>(man,HttpStatus.CREATED);
     }
     else{
         Woman woman =new Woman(user.getName(), user.getEmail(), user.getPassword(), user.getGender());
         woman=womanRepository.save(woman);
         return new ResponseEntity<>(woman,HttpStatus.CREATED);
     }
    }
    return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }

    @PostMapping("/upload")
    public ResponseEntity<UsersDTO> upload(@RequestPart("user") String userJson,
                                        @RequestPart("image") MultipartFile image)throws IOException
    {
        String imageUrl=DIRECTORY_URL+image.getOriginalFilename();
        System.out.println("----------------------------------");
        Path filePath = Paths.get(imageUrl);
        Files.write(filePath,image.getBytes());
        System.out.println("-----------------------------------"+imageUrl);
        System.out.println("-----------------------------------"+image.getBytes());
        ObjectMapper objectMapper=new ObjectMapper();
        boolean contains = userJson.contains("his");
//לבדוק אם יש לי MAN במחרוזת
        if (contains){
            Man man=objectMapper.readValue(userJson,Man.class);
            man.setImagePath(imageUrl);
            Man newUser = manRepository.save(man);
            ManDTO newUserDTO = mapper.ManToDto(newUser);
            return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
        }
        Woman woman=objectMapper.readValue(userJson, Woman.class);
        woman.setImagePath(imageUrl);
        Woman newUser = womanRepository.save(woman);
        WomanDTO newUserDTO = mapper.WomanToDto(newUser);
        return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);


      //  Users user=objectMapper.readValue(userJson,Users.class);

        //save in h2
//        user.setImagePath(imageUrl);
//        if (user.getGender()== Gender.MAN) {

//                Man newUser = manRepository.save((Man) user);
//                UsersDTO newUserDTO = mapper.UsersToDto(user);
//                return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);

//        }else{
//            if (user instanceof Woman){
//            Woman newUser = womanRepository.save((Woman) user);
//            UsersDTO newUserDTO = mapper.UsersToDto(newUser);
//            return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
//        }
//        }
//            Users newUser=userRepository.save(user);
//            UsersDTO newUserDTO=mapper.UsersToDto(user);
//            return new ResponseEntity<>(newUserDTO,HttpStatus.CREATED);
    }




    @GetMapping("/getDTO/{id}")
    public ResponseEntity<UsersDTO>getUserDto(@PathVariable long id) throws IOException {
        Users user = manRepository.findById(id).orElse(null);
        if (user == null) {
            user=womanRepository.findById(id).orElse(null);
        }
        UsersDTO userDTO=mapper.UsersToDto(user);
//        userDTO.setId(id);
//        userDTO.setEmail(user.getEmail());
//        userDTO.setName(user.getName());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setGender(user.getGender());
//        userDTO.setPhon(user.getPhon());
//        userDTO.setDateOfBirth(user.getDateOfBirth());
//        userDTO.setBudget(user.getBudget());
//        userDTO.setCity(user.getCity());
//        userDTO.setCountryOfOrigin(user.getCountryOfOrigin());
//        userDTO.setFather_name(user.getFather_name());
//        userDTO.setMother_name(user.getMother_name());
//        userDTO.setHight(user.getHight());
//        userDTO.setLanguages(user.getLanguages()); // מיפוי רשימת שפות
//        userDTO.setLicense(user.getLicense()); // אם יש לך שדה License
//        userDTO.setStatus(user.getStatus()); // מיפוי סטטוס
//        userDTO.setResidence(user.getResidence()); // מיפוי מגורים
//        userDTO.setSector(user.getSector()); // מיפוי רשימת תחומים
//        userDTO.setType_phon(user.getType_phon()); // מיפוי סוג טלפון
//        userDTO.setParents_status(user.getParents_status()); // מיפוי סטטוס הורים
//        userDTO.setLand(user.getLand());
//        userDTO.setSiblings(user.getSiblings());
//        userDTO.setPhonesForInquiries(user.getPhonesForInquiries());
//

return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }


}
