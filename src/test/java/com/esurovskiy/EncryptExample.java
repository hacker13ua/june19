package com.esurovskiy;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        final SecretKey secretKey = keyGenerator.generateKey();
        final String s = "TEST message to encrypt";
        final byte[] data = s.getBytes();
        final Cipher aes = Cipher.getInstance("AES");
        aes.init(Cipher.ENCRYPT_MODE, secretKey);
        final byte[] bytes = aes.doFinal(data);
        System.out.println(new String(bytes));
        final Cipher aes2 = Cipher.getInstance("AES");
        aes2.init(Cipher.DECRYPT_MODE, secretKey);
        System.out.println(new String(aes2.doFinal(bytes)));


    }
}
