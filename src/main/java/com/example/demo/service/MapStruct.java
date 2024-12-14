package com.example.demo.service;


import com.example.demo.dto.ManDTO;
import com.example.demo.dto.UsersDTO;
import com.example.demo.dto.WomanDTO;
import com.example.demo.model.Man;
import com.example.demo.model.Users;
import com.example.demo.model.Woman;
import org.mapstruct.Mapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStruct {

    List<UsersDTO> UsersToDto(List<Users> users);
    List<ManDTO> ManToDto(List<Man> man);
    List<WomanDTO> WomanToDto(List<Woman> woman);

    default ManDTO ManToDto(Man man)throws IOException{

        ManDTO manDTO=new ManDTO();
//        manDTO.setId(man.getId());
        manDTO.setEmail(man.getEmail());
        manDTO.setName(man.getName());
        manDTO.setPassword(man.getPassword());
        manDTO.setGender(man.getGender());
        manDTO.setPhon(man.getPhon());
        manDTO.setDateOfBirth(man.getDateOfBirth());
        manDTO.setBudget(man.getBudget());
        manDTO.setCity(man.getCity());
        manDTO.setCountryOfOrigin(man.getCountryOfOrigin());
        manDTO.setFather_name(man.getFather_name());
        manDTO.setMother_name(man.getMother_name());
        manDTO.setHeight(man.getHeight());
        manDTO.setLanguages(man.getLanguages()); // מיפוי רשימת שפות
        manDTO.setLicense(man.getLicense()); // אם יש לך שדה License
        manDTO.setStatus(man.getStatus()); // מיפוי סטטוס
        manDTO.setResidence(man.getResidence()); // מיפוי מגורים
        manDTO.setSector(man.getSector()); // מיפוי רשימת תחומים
        manDTO.setType_phon(man.getType_phon()); // מיפוי סוג טלפון
        manDTO.setParents_status(man.getParents_status()); // מיפוי סטטוס הורים
        manDTO.setLand(man.getLand());
        manDTO.setSiblings(man.getSiblings());
        manDTO.setPhonesForInquiries(man.getPhonesForInquiries());
        manDTO.setBeard(man.getBeard());
        manDTO.setFuture(man.getFuture());
        manDTO.setHis(man.getHis());
        manDTO.setId(man.getId());
        manDTO.setRequirements(man.getRequirements());
        manDTO.setSmoking(man.getSmoking());
        manDTO.setStudies(man.getStudies());
        boolean isImage=isImageFile(man.getImagePath());
        if (isImage){
            Path filePath= Paths.get(man.getImagePath());
            byte[] fileBytes= Files.readAllBytes(filePath);
            String base64Img= Base64.getEncoder().encodeToString(fileBytes);
            manDTO.setPhoto(base64Img);
        }
        else {
            manDTO.setPhoto(null);
        }
        return manDTO;
    }

    default WomanDTO WomanToDto(Woman woman)throws IOException{
        WomanDTO womanDTO=new WomanDTO();
        womanDTO.setCover(woman.getCover());
        womanDTO.setId(woman.getId());
        womanDTO.setRequirements(woman.getRequirements());
        womanDTO.setStudies(woman.getStudies());
        womanDTO.setHer(woman.getHer());
//        womanDTO.setId(woman.getId());
        womanDTO.setEmail(woman.getEmail());
        womanDTO.setName(woman.getName());
        womanDTO.setPassword(woman.getPassword());
        womanDTO.setGender(woman.getGender());
        womanDTO.setPhon(woman.getPhon());
        womanDTO.setDateOfBirth(woman.getDateOfBirth());
        womanDTO.setBudget(woman.getBudget());
        womanDTO.setCity(woman.getCity());
        womanDTO.setCountryOfOrigin(woman.getCountryOfOrigin());
        womanDTO.setFather_name(woman.getFather_name());
        womanDTO.setMother_name(woman.getMother_name());
        womanDTO.setHeight(woman.getHeight());
        womanDTO.setLanguages(woman.getLanguages()); // מיפוי רשימת שפות
        womanDTO.setLicense(woman.getLicense()); // אם יש לך שדה License
        womanDTO.setStatus(woman.getStatus()); // מיפוי סטטוס
        womanDTO.setResidence(woman.getResidence()); // מיפוי מגורים
        womanDTO.setSector(woman.getSector()); // מיפוי רשימת תחומים
        womanDTO.setType_phon(woman.getType_phon()); // מיפוי סוג טלפון
        womanDTO.setParents_status(woman.getParents_status()); // מיפוי סטטוס הורים
        womanDTO.setLand(woman.getLand());
        womanDTO.setSiblings(woman.getSiblings());
        womanDTO.setPhonesForInquiries(woman.getPhonesForInquiries());

        boolean isImage = isImageFile(woman.getImagePath());
        if (isImage) {
            Path filePath = Paths.get(woman.getImagePath());
            byte[] fileBytes = Files.readAllBytes(filePath);
            String base64Img = Base64.getEncoder().encodeToString(fileBytes);
            womanDTO.setPhoto(base64Img);
        } else {
            womanDTO.setPhoto(null);
        }


        return womanDTO;
    }

    default UsersDTO UsersToDto(Users user)
        throws IOException{
            UsersDTO userDTO=new UsersDTO();
            userDTO.setId(user.getId());
            userDTO.setEmail(user.getEmail());
            userDTO.setName(user.getName());
            userDTO.setPassword(user.getPassword());
            userDTO.setGender(user.getGender());
            userDTO.setPhon(user.getPhon());
            userDTO.setDateOfBirth(user.getDateOfBirth());
            userDTO.setBudget(user.getBudget());
            userDTO.setCity(user.getCity());
            userDTO.setCountryOfOrigin(user.getCountryOfOrigin());
            userDTO.setFather_name(user.getFather_name());
            userDTO.setMother_name(user.getMother_name());
            userDTO.setHeight(user.getHeight());
            userDTO.setLanguages(user.getLanguages()); // מיפוי רשימת שפות
            userDTO.setLicense(user.getLicense()); // אם יש לך שדה License
            userDTO.setStatus(user.getStatus()); // מיפוי סטטוס
            userDTO.setResidence(user.getResidence()); // מיפוי מגורים
            userDTO.setSector(user.getSector()); // מיפוי רשימת תחומים
            userDTO.setType_phon(user.getType_phon()); // מיפוי סוג טלפון
            userDTO.setParents_status(user.getParents_status()); // מיפוי סטטוס הורים
            userDTO.setLand(user.getLand());
            userDTO.setSiblings(user.getSiblings());
            userDTO.setPhonesForInquiries(user.getPhonesForInquiries());

            boolean isImage=isImageFile(user.getImagePath());
            if (isImage){
                Path filePath= Paths.get(user.getImagePath());
                byte[] fileBytes= Files.readAllBytes(filePath);
                String base64Img= Base64.getEncoder().encodeToString(fileBytes);
                userDTO.setPhoto(base64Img);
            }
            else {
                userDTO.setPhoto(null);
            }
            return userDTO;
        }

        default boolean isImageFile(String fileName){
            if(fileName!=null&&fileName.endsWith(".jpg")|| fileName.endsWith(".jpeg")||
            fileName.endsWith(".png")){
                return true;
            }
            return false;
        }
    }

