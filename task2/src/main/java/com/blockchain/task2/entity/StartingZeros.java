package com.blockchain.task2.entity;

import org.springframework.stereotype.Component;

@Component
public class StartingZeros {

    //default value for starting zeros
    private Integer startingZerosNumber = 4;

    public Integer getStartingZerosNumber() {
        return startingZerosNumber;
    }

    public void setStartingZerosNumber(Integer startingZerosNumber) {
        this.startingZerosNumber = startingZerosNumber;
    }
}
