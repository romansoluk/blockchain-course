package com.blockchain.task2.repository;

import com.blockchain.task2.entity.BlockData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockDataRepository extends JpaRepository<BlockData, Long> {


}
