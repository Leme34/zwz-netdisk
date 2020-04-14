package com.micro.common;

import java.util.Random;

public class RandomUtils {
	public static String[] arr={
		"0","1","2","3","4","5","6","7","8","9",
		"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
		"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
	};
	public static String getRandom(Integer len){
		String nums="";
		for(int i=0;i<len;i++){
			Random r=new Random();
			int index=r.nextInt(arr.length-1);
			String str=arr[index];
			nums=nums+str;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		String str=getRandom(4);
	}
}
