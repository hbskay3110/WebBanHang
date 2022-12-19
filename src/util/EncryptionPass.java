package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class EncryptionPass {
	public static String toSHA1(String str) {
		String salt = "fsddjfd235@#$dasd";
		String rs = null;
		str = str+ salt;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			rs = Base64.encodeBase64String(md.digest(dataBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static void main(String[] args) {
		System.out.println(toSHA1("phanan219"));
	}

}
