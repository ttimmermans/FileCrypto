package net.codejava.crypto;
 
import java.io.File;
 
/**
 * A tester for the CryptoUtils class.
 * @author www.codejava.net
 *
 */
public class CodeJavaNet_CryptoTest {
    public static void main(String[] args) {
        String key = "Mary has one cat";
        File inputFile = new File("VolderVoorTest/bla.txt");
        File encryptedFile = new File("document.encrypted");
        File decryptedFile = new File("document.decrypted");
         
        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}