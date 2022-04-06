package com.blockchain.task2.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "block")
//@Table(name = "block")
public class Block {

    @Id
    @Column(name = "block_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockId;

    @Column(name = "nonce")
    private Long nonce;

    @Column(name = "previous_hash")
    private String previousHash;

    @Column(name = "current_hash")
    private String currentHash;

    @Column(name = "timestamp")
    LocalDateTime timestamp;

    @Column(name = "blocked", columnDefinition = "smallint default 0")
    private Integer isBlocked = 0;

    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<BlockData> blockData = new ArrayList<>();

    public Integer getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Integer isBlocked) {
        this.isBlocked = isBlocked;
    }

    public List<BlockData> getBlockData() {
        return blockData;
    }

    public void setBlockData(List<BlockData> blockData) {
        this.blockData = blockData;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getNonce() {
        return nonce;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public void setCurrentHash(String currentHash) {
        this.currentHash = currentHash;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Block() {
    }


    @Override
    public String toString() {
        return blockId + nonce + previousHash + blockData;
    }
}
