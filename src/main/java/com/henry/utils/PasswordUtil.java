package com.henry.utils;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil {
	/**
	 * 产生16位的salt
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String generate() throws UnsupportedEncodingException {
        Random RANDOM = new SecureRandom();
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);//产生16个随机数
        String str = new String(salt,"UTF-8");
        Base64 base64 = new Base64();
        salt = base64.encode(salt);
        str = new String(salt);
		return str;
	}
	
	/**
	 *  pwd = SHA ( SHA(pwd) + SALT)
	 * 
	 * @param password
	 * @return
	 */
	public static String encode(String password, String salt) {
		StringBuilder sb = new StringBuilder(password);
		sb.append(salt);
		return DigestUtils.sha512Hex(sb.toString());
	}
}
