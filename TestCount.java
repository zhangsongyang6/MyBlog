package com.xuliyun;

import java.util.ArrayList;
import java.util.Random;

public class TestCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Count c = new Count();
		ArrayList<String> list = c.numCount();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			for (int j = 0; j < 20 - list.get(i).length(); j++) {
				System.out.print(" ");
			}
			if ((i + 1) % 4 == 0) {
				System.out.println();
				System.out.println();
				System.out.println();
			}
		}
	}

}
