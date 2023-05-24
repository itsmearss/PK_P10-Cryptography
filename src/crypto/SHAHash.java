/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ARS
 */
public class SHAHash {
    public static String hash(String data, String algorithm){
        String hashed = "";
        try {
            MessageDigest sha = MessageDigest.getInstance(algorithm);
            sha.update(data.getBytes());
            byte[] byteData = sha.digest();
            //konversi dari byte ke hex
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) +
                        0x100, 16).substring(1));
            }
            hashed = sb.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return hashed;
    }
    
    public static void main(String[] args) {
        String data = "Selamat datang di Politeknik Harapan Bersama Tegal";
        System.out.println("Plain Text: " + data);
        System.out.println("SHA-1\t: " + hash(data, "SHA-1"));
        System.out.println("SHA-256\t: " + hash(data, "SHA-256"));
        System.out.println("SHA-512\t: " + hash(data, "SHA-512"));
    }
}
