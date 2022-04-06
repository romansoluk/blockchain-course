package com.blockchain.task2.service;

import com.blockchain.task2.entity.BlockData;
import com.blockchain.task2.repository.BlockDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BlockDataService {

    @Autowired
    private BlockDataRepository blockDataRepository;
    @Autowired
    private BlockService blockService;

    /**
     * get record by id
     * @param id - record id
     * @return record data
     */
    public BlockData getRecord(Long id){
        return blockDataRepository.findById(id).get();
    }

    /**
     * add new record to current block (current block - not minted block)
     * @param blockData
     * @return record data
     */
    public BlockData addRecord(BlockData blockData){
        blockData.setBlock(blockService.createBlock());
        blockDataRepository.save(blockData);
        return blockData;
    }

    /**
     * transfer records from previous block to current one
     * @param records
     * @return records
     */
    public List<BlockData> transferRecords(List<BlockData> records){
        for (BlockData record: records) {
            addRecord(record);
        }
        return records;
    }


    //todo
    public BlockData deleteRecord(){
        return null;
    }
    //todo
    public List<BlockData> getAllRecords(){
        return new ArrayList<>();
    }
}
