package com.blockchain.task2.controller;

import com.blockchain.task2.entity.BlockData;
import com.blockchain.task2.service.BlockDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BlockDataController {

    @Autowired
    public BlockDataService blockDataService;

    @PostMapping("/add-new-record")
    public BlockData createNewRecord(@Valid @RequestBody BlockData blockData){
        return blockDataService.addRecord(blockData);
    }

    @GetMapping("/get-record/{id}")
    public BlockData getRecord(@PathVariable Long id){
        return blockDataService.getRecord(id);
    }
}
