package com.blockchain.task2.controller;

import com.blockchain.task2.entity.Block;
import com.blockchain.task2.entity.StartingZeros;
import com.blockchain.task2.service.BlockDataService;
import com.blockchain.task2.service.BlockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;


@RestController
public class BlockController {

    @Autowired
    private BlockService blockService;

    @Autowired
    private BlockDataService blockDataService;

    @GetMapping("/get-block/{id}")
    public Block getBlock(@PathVariable("id") Long id){
        return blockService.getBlock(id);
    }

    @GetMapping("/get-new-block")
    public Block getNewBlock(){
        Block block = blockService.createBlock();
        blockDataService.transferRecords(block.getBlockData());
        return block;
    }

    @PostMapping("/get-new-block")
    public Block createNewBlock(){

        HashMap<String, String> uriVar = new HashMap<>();

        ResponseEntity<StartingZeros> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8080/get-leading-zeros", StartingZeros.class, uriVar);

        Block block = blockService.createBlock();
        return blockService.saveBlock(block, responseEntity.getBody().getStartingZerosNumber());
    }

   @GetMapping("/blocks")
    public List<Block> getAllBlocks(){
        return blockService.getBlocks();
   }

}
