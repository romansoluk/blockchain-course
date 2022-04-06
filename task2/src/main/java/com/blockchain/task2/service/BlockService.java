package com.blockchain.task2.service;

import com.blockchain.task2.entity.Block;
import com.blockchain.task2.repository.BlockRepository;
import com.blockchain.task2.utils.HashUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BlockService {

    @Autowired
    private BlockRepository blockRepository;

    /**
     * get block by id
     * @param id
     * @return block
     */
    public Block getBlock(Long id) {
        return blockRepository.findById(id).get();
    }

    /**
     * If block is minted (current hash, timestamp are generated)
     * then @isBlocked value is equal to 1
     * Basically, this method returns not minted block.
     * @return created block
     */
    public Block createBlock() {
        //if latest block is saved(added to blockchain) - new one is created
        if(getBlock(blockRepository.getLastBlock()).getIsBlocked()==1L){
            Block block = new Block();
            //todo: probably replace with Builder
            block.setBlockId(blockRepository.getLastBlock()+1L);
            block.setPreviousHash(blockRepository.getPreviousHash());
            block.setBlockData(getBlock(blockRepository.getLastBlock()).getBlockData());
            blockRepository.save(block);
            return block;
        }//else the latest one is returned
        else {
            return getBlock(blockRepository.getLastBlock());
        }
    }


    /**
     * Mints current block
     * @param block
     * @param startingZeros
     * @return minted block
     */
    public Block saveBlock(Block block, int startingZeros) {
        Long nonce = 0L;
        //means that block is going to be added to blockchain and no data should be added there now
        block.setIsBlocked(1);
        block.setPreviousHash(blockRepository.getPreviousHash());
        block.setNonce(nonce);
        String dataToHash = block.toString();
        String hash = HashUtils.getSHA256(dataToHash);
        while (!hash.startsWith(HashUtils.getStartingZeros(startingZeros))) {
            nonce=nonce+1L;
            block.setNonce(nonce);
            dataToHash = block.toString();
            hash = HashUtils.getSHA256(dataToHash);
        }
        block.setCurrentHash(hash);
        block.setTimestamp(LocalDateTime.now());
        blockRepository.save(block);
        return block;
    }

    /**
     * get list of blocks
     * @return list of blocks
     */
    public List<Block> getBlocks(){
        return blockRepository.findAll();
    }

}
