package com.henry.test;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Ignore;
import org.junit.Test;

import com.henry.utils.PasswordUtil;


public class CodecTest {
	
	@Test
	@Ignore
	public void test() {
		String str = "test";
		str = DigestUtils.sha512Hex(str);
		System.out.println(str);
		System.out.println(str.length());
	}
	
	@Test
	@Ignore
	public void salt() throws UnsupportedEncodingException {
	        Random RANDOM = new SecureRandom();
	        byte[] salt = new byte[16];
	        RANDOM.nextBytes(salt);//产生16个随机数
	        String str = new String(salt,"UTF-8");
	        Base64 base64 = new Base64();
	        salt = base64.encode(salt);
	        str = new String(salt);
	        System.out.println(str.length());
	        System.out.println(str);
	    }
	
	@Test
	public void password() throws UnsupportedEncodingException {
		String salt = PasswordUtil.generate();
		String password = DigestUtils.sha512Hex("test");
		password = PasswordUtil.encode(password, salt);
		System.out.println(salt.length());
		System.out.println(password);
	}
	
}
