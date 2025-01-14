package com.health.healthCare.service;


import com.health.healthCare.entity.MyInch;
import com.health.healthCare.repository.MyInchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyInchService {

    @Autowired
    private MyInchRepository myInchRepository;

    // Create
    public MyInch createMyInch(MyInch myInch) {
        return myInchRepository.save(myInch);
    }

    // Read
    public List<MyInch> getAllMyInches() {
        return myInchRepository.findAll();
    }

    public Optional<MyInch> getMyInchById(Long id) {
        return myInchRepository.findById(id);
    }

    // Update
    public MyInch updateMyInch(Long id, MyInch myInch) {
        myInch.setInchNo(id);
        return myInchRepository.save(myInch);
    }

    // Delete
    public void deleteMyInch(Long id) {
        myInchRepository.deleteById(id);
    }
}



