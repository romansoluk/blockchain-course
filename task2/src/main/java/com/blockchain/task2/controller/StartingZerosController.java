package com.blockchain.task2.controller;

import com.blockchain.task2.entity.StartingZeros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartingZerosController {


    @Autowired
    StartingZeros zeros;

    @GetMapping(path = "/get-leading-zeros")
    public StartingZeros getZeros(){
        return zeros;
    }

    @PostMapping(path = "/get-leading-zeros")
    public StartingZeros setZeros(@RequestBody StartingZeros zerosResponse){
        zeros.setStartingZerosNumber(zerosResponse.getStartingZerosNumber());
        return zeros;
    }
}
