/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.libSBOLj;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * These utility methods calculate ID encodings.
 * code borrowed from  org.jbei.ice.lib.utils.Utils by Tim Ham
 * @author mgaldzic
 * @since 0.35, 05/30/2011
 */
public class IdentifierUtils {

    /**
     * Provides a String of the Hex encoded input
     * @param bytes
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getHexString(byte[] bytes) throws UnsupportedEncodingException {

        byte[] HEX_CHAR_TABLE = {(byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4',
            (byte) '5', (byte) '6', (byte) '7', (byte) '8', (byte) '9', (byte) 'a', (byte) 'b',
            (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f'};
        {
            byte[] hex = new byte[2 * bytes.length];
            int index = 0;

            for (byte b : bytes) {
                int v = b & 0xFF;
                hex[index++] = HEX_CHAR_TABLE[v >>> 4];
                hex[index++] = HEX_CHAR_TABLE[v & 0xF];
            }
            return new String(hex, "ASCII");
        }
    }

    /**
     * Hashes the input String with SHA-1 into a Hex encoded String.
     * Useful for keys
     * @param string
     * @return Hex version of hash
     */
    public static String encryptSHA(String string) {
        return encrypt(string, "SHA-1");
    }

    private static String encrypt(String string, String algorithm) {
        String result = "";

        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            digest.update(string.getBytes("UTF-8"));

            byte[] hashed = digest.digest();

            result = IdentifierUtils.getHexString(hashed);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Random Unique ID
     * @return 
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
