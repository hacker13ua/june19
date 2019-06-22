package com.esurovskiy;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class EncryptRSAExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        keyGenerator.initialize(10240);

        final KeyPair keyPair = keyGenerator.genKeyPair();
        final PrivateKey aPrivate = keyPair.getPrivate();
        final PublicKey aPublic = keyPair.getPublic();
        System.out.println("Private " +aPrivate);
        System.out.println("Public " +aPublic);
        final String s = "TEST message to encrypt";
        final byte[] data = s.getBytes();
        final Cipher aes = Cipher.getInstance("RSA");
        aes.init(Cipher.ENCRYPT_MODE, aPublic);
        final byte[] bytes = aes.doFinal(data);
        System.out.println(new String(bytes));
        final Cipher aes2 = Cipher.getInstance("RSA");
        aes2.init(Cipher.DECRYPT_MODE, aPrivate);
        System.out.println(new String(aes2.doFinal(bytes)));


    }
}
