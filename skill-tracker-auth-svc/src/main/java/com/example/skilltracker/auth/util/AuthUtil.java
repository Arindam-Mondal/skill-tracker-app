package com.example.skilltracker.auth.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthUtil {
    //Method to Hash to String
    public static String stringToHash (String stringToHash) throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(stringToHash.getBytes());
        byte[] digest = messageDigest.digest();
        String hashedOutput = DatatypeConverter.printHexBinary(digest);
        return hashedOutput;
    }
}
