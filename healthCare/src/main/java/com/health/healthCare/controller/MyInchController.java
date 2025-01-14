package com.health.healthCare.controller;

import com.health.healthCare.entity.MyInch;
import com.health.healthCare.service.MyInchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myinch")
@CrossOrigin(origins = "http://localhost:5173") // React 앱의 주소
public class MyInchController {

    @Autowired
    private MyInchService myInchService;

    // Create
    @PostMapping
    public ResponseEntity<MyInch> createMyInch(@RequestBody MyInch myInch) {
        MyInch createdMyInch = myInchService.createMyInch(myInch);
        return new ResponseEntity<>(createdMyInch, HttpStatus.CREATED);
    }

    // Read
    @GetMapping
    public ResponseEntity<List<MyInch>> getAllMyInches() {
        List<MyInch> myInches = myInchService.getAllMyInches();
        return new ResponseEntity<>(myInches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyInch> getMyInchById(@PathVariable Long id) {
        return myInchService.getMyInchById(id)
                .map(myInch -> new ResponseEntity<>(myInch, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<MyInch> updateMyInch(@PathVariable Long id, @RequestBody MyInch myInch) {
        return new ResponseEntity<>(myInchService.updateMyInch(id, myInch), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMyInch(@PathVariable Long id) {
        myInchService.deleteMyInch(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

