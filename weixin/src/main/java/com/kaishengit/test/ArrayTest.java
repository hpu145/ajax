package com.kaishengit.test;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {

		int[] a = {12,34,54,26,74,32};
		int[] b = {37,91,40,34,78,54,36,19};
		
		int i = 0;
		int j = 0;
		
		// 将数组进行排序
		Arrays.sort(a);
		Arrays.sort(b);
		
		//找出交集
		while(i < a.length && j < b.length) {
			if(a[i] < b[j]) {
				i++;
			} else if( a[i] > b[j]) {
				j++;
			} else {
				System.out.println(a[i]);
				i++;
				j++;
			}
		}
		
		
		
		/*Scanner input = new Scanner(System.in);
		String regex = "\\d[,\\d]*";
		String str = "";
		//校验用户输入是否符合规范
		do {
			System.out.println("请输入一组数，并以，相隔开");
			str = input.next();
		} while (!str.matches(regex));
		// String数组转int
		String[] arrayStr = str.split(",");
		int[] arrayInt = new int[arrayStr.length];
		for (int i = 0; i < arrayStr.length; i++) {
			arrayInt[i] = Integer.parseInt(arrayStr[i]);
			System.out.println(arrayInt[i]);
		}
		// java自带排序，升序
		Arrays.sort(arrayInt);
		// 把升序排列的数组按倒序输出
		StringBuffer resBuffer = new StringBuffer();
		for (int i = arrayInt.length - 1; i >= 0 ; i--) {
			resBuffer.append(arrayInt[i]).append(",");
		}
		// StringBuffer转String
		String res = resBuffer.toString();
		// 去掉字符串最后的,
		res = res.substring(0, res.length() - 1);
		System.out.println(res);
		input.close();*/

	}

}
