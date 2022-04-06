package com.blockchain.task2.repository;

import com.blockchain.task2.entity.Block;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface BlockRepository extends JpaRepository<Block, Long> {

    @Query(value = "SELECT COLUMN_ID col FROM SETUP_COLUMN_ID WHERE HASHABLE =1 AND DATA_COLUMN =1 ", nativeQuery = true)
    Collection<String> getHashableColumns();

    @Query(value = "SELECT current_hash FROM block WHERE current_hash is not null order by timestamp desc LIMIT 1", nativeQuery = true)
    String getPreviousHash();

    @Query(value = "SELECT block_id FROM block order by block_id desc LIMIT 1 ", nativeQuery = true)
    Long getLastBlock();

}
