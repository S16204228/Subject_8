package webadv.s16204228.lab01;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 *
 */
import org.apache.commons.codec.digest.DigestUtils;
public class App {
	public static final String ALGORITHM = "SHA-256";
	
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please enter your number and password!");
            System.err.println("number:");
            Scanner s = new Scanner(System.in);  
            String number = s.nextLine();  
            System.err.println("password:");
            String password = s.nextLine();
            String str = number+sha256hex(password);         
            String str5 = null;
            try {
    			FileInputStream fin = new FileInputStream("ttt.txt");
    			 byte b[] = new byte[fin.available()];
    		        int n= fin.read(b);
    		        fin.read(b);
    		      str5=new String(b);
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
            if(str.equals(str5)) {
            	  System.err.println("Longin");
            }
            else {
            	  System.err.println("false");
            }
            System.exit(0);
        }
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}