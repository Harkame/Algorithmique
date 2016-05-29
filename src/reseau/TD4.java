import java.security.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import javax.crypto.*;

public abstract class TD4 {
	private static final String password = "password";
	private static final String password_md5 = "f71dbe52628a3f83a77ab494817525c6";
	//private static final String password_md5 = "toto";
	private static final String password_sha = "e6fb06210fafc02fd7479ddbed2d042cc3a5155e";
	private static MessageDigest md5;
	private static MessageDigest sha;
	private static byte[] bytes_md5;
	private static byte[] bytes_sha;
	private static byte[] md5_digest;
	private static byte[] sha_digest;

	static {
		try {
			md5 = MessageDigest.getInstance("MD5");
			sha = MessageDigest.getInstance("SHA");

			bytes_md5 = password_md5.getBytes();
			bytes_sha = password_sha.getBytes();
			
			md5_digest = bytes_md5;

			//md5_digest = md5.digest(bytes_md5);
			//sha_digest = sha.digest(bytes_sha);
		} catch (Exception e) {
		}
	}

	private static String[] repertoire = { "a", "b", "c", "d", "e", "f", "g",
			"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "y", "z" };

	public final static ArrayList<String> Generer(int p_taille) {
		ArrayList<String> resultats = new ArrayList<String>();
		if (p_taille == 0) {
			resultats.add("");
			return resultats;
		}
		for (String valeur : Generer(p_taille - 1)) {
			for (int i = 0; i < repertoire.length; i++) {
				resultats.add(valeur + repertoire[i]);
			}
		}
		return resultats;
	}
	
	public static String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        System.out.println(sb);
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	
	public static String SHA(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        System.out.println(sb);
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	

	public static void main(String[] args) throws Exception {
		List <String>l = Generer(4);
		System.out.println();
		for(int i = 0; i < l.size(); i++){
			if(password_md5.equals(MD5(l.get(i)))){
				System.out.println("Mot original : " + l.get(i));
				break;
			}
		}
		for(int i = 0; i < l.size(); i++){
			if(password_sha.equals(SHA(l.get(i)))){
				System.out.println("Mot original : " + l.get(i));
				break;
			}
		}
		/*
		for(byte b : md5_digest){
			System.out.print(b);
		}
		System.out.println("\nyolo");
		for(byte b: MD5("toto").getBytes()){
			System.out.print(b);
		}
		*/
	}
}
