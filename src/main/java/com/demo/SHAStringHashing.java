/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author damiann
 */
public class SHAStringHashing {
    public String hashSHA256(String password, String username) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        try {
            
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i=0;i<byteData.length;i++) {
                String hex=Integer.toHexString(0xff & byteData[i]);
                if(hex.length()==1) hexString.append('0');
                hexString.append(hex);
            }
            
            md.update((hexString.toString() + username).getBytes());

        } finally {
            byte byteeData[] = md.digest();

            StringBuffer hexxString = new StringBuffer();
            for (int i=0;i<byteeData.length;i++) {
                String hex=Integer.toHexString(0xff & byteeData[i]);
                if(hex.length()==1) hexxString.append('0');
                hexxString.append(hex);
            }

            return hexxString.toString();
        }
    }
}
