import java.security.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import javax.crypto.*;

public abstract class TD4 {
	private static final String password = "password";
	private static final String password_md5 = "f71dbe52628a3f83a77ab494817525c6";
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

			bytes_md5 = password_md5.getBytes("UTF-8");
			bytes_sha = password_sha.getBytes("UTF-8");

			md5_digest = md5.digest(bytes_md5);
			sha_digest = sha.digest(bytes_sha);
		} catch (Exception e) {
		}
	}

	private static String[] code_ascii = { "a", "b", "c", "d", "e", "f", "g",
			"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "y", "z" };

	public final static List<String> generer(int p_taille)
			throws Exception {
		List<String> resultats = new ArrayList<String>();
		if (p_taille == 0) {
			resultats.add("");
			return resultats;
		}
		for (String valeur : generer(p_taille - 1)) {
			for (int i = 0; i < code_ascii.length; i++) {
				String t = valeur + code_ascii[i];
				byte[] t_md5 = t.getBytes("UTF-8");
				byte[] digest = md5.digest(t_md5);
				for(byte b : digest){
					System.out.print(b);
					
				}
				System.out.println();
				if(Arrays.equals(digest, md5_digest)){
					System.out.println(valeur);
					return null;
				}
				resultats.add(new String(digest));
			}
		}
		return resultats;
	}

	public static void main(String[] args) throws Exception {
		List l = generer(5);
		for(byte b : md5_digest){
			System.out.print(b);
		}
		System.out.println("");
	}
}
