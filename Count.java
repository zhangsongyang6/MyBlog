package com.xuliyun;

import java.util.ArrayList;
import java.util.Random;

public class Count {

	/**
	 * @param args
	 */
	public ArrayList<String> numCount() {
		Random ra = new Random();
		char[] operator = new char[] { '+', '-' };
		ArrayList<String> expression = new ArrayList<String>();
		for (int i = 0; i < 50; i++) {
			int n = ra.nextInt(3) + 2; // 产生一个2-4的随机数
			int[] number = new int[n];// new一个数组对象，长度为2-4
			String ex = new String();
			int result;
			number[0] = ra.nextInt(100) + 1;
			result = number[0];
			ex = String.valueOf(number[0]);
			for (int j = 1; j < n; j++) {
				int s = ra.nextInt(2);// 随机选择某个运算符
				if (String.valueOf(operator[s]).equals("+")) {
					number[j] = ra.nextInt(101 - result);
					result = result + number[j];
				} else {
					number[j] = ra.nextInt(result + 1);
					result = result - number[j];

				}

				ex = ex + String.valueOf(operator[s]) + String.valueOf(number[j]);/// 5+4+6+9
			}
//			    ex+="="+String.valueOf(result);
			ex += "=";
			expression.add(ex);
		}
		return expression;
	}

}
