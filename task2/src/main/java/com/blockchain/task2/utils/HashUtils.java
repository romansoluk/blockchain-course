package com.blockchain.task2.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

public class HashUtils {

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String hashString(byte[] hash)
    {
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    public static String getSHA256ForList(List<String> dataToHash) throws NoSuchAlgorithmException {
        return hashString(getSHA(String.join("", dataToHash)));

    }

    public static String getSHA256(String dataToHash) {
       try {
           //todo: fix leading zero cut
           return hashString(getSHA(dataToHash));
       }catch (NoSuchAlgorithmException e){
           e.getMessage();
       }
        return null;

    }

    public static String getStartingZeros(int zerosNumber){
        return "0".repeat(Math.max(0, zerosNumber));
    }


}
