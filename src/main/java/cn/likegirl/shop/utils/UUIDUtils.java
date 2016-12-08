package cn.likegirl.shop.utils;

import java.util.UUID;


public class UUIDUtils {
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/*@Test
	public void getid(){
		System.out.println(getUUID().length());
	}*/
}
