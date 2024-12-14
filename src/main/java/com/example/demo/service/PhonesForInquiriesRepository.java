package com.example.demo.service;

import com.example.demo.model.PhonesForInquiries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonesForInquiriesRepository extends JpaRepository<PhonesForInquiries, Long> {
}
