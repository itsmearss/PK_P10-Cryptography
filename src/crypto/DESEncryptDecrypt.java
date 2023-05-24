/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author ARS
 */
public class DESEncryptDecrypt {
    public static void doEncryptDecrypt(){
        try {
            String data = "Dasar Symmetric Cryptography";
            byte[] plain = data.getBytes("UTF8");
            //Membuat DES private key
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            keyGen.init(56);
            Key key = keyGen.generateKey();
            //Membuat DES cipher => print ke provider
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            //proses encrypt
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(plain);
            //proses decrypt
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] originText = cipher.doFinal(cipherText);
            System.out.println("Plain Text: " + data);
            System.out.println("Enkripsi: " + new String(cipherText, "UTF8"));
            System.out.println("Enkripsi Heksa: " + MyStringUtils.getHexString(cipherText));
            System.out.println("Dekripsi: " + new String(originText, "UTF8"));
        } catch (UnsupportedEncodingException | InvalidKeyException |
                NoSuchAlgorithmException | BadPaddingException |
                IllegalBlockSizeException | NoSuchPaddingException e) {
        }
    }
    
    public static void main(String[] args) {
        doEncryptDecrypt();
    }
}
