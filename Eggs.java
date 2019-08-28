package com.jeannie;

import java.util.Random;
import java.util.Scanner;

public class Eggs {
	public int score;
	public int result;
	
	public void open(){
		Random ra = new Random();
		System.out.println("请按数字1砸金蛋……");
		Scanner sc=new Scanner(System.in);
		String str = sc.nextLine();
		while (!str.equals("1")) {
			System.out.println("输入错误，请重新输入!!!");
			str = sc.nextLine();
		}
		for (int i = 1; i < 5; i++) {
			int tmp = ra.nextInt(30);
			int score = 20-tmp;
			result +=score;
			System.out.println("第"+i+"次砸金蛋，恭喜您本次得了"+score+"分！！！！");
			System.out.println("您目前总分为："+result);
		    if(i==4) {
		    	System.out.println("------------------------------------------");
		    	System.out.println("游戏结束，谢谢！！");
		    	break;
		    }
			System.out.println("继续玩游戏吗？继续请按数字1，否则退出");
			str = sc.nextLine();
			if(!str.equals("1")) {
				System.out.println("游戏结束，谢谢！！");
				System.exit(0);
			}
			System.out.println();
			System.out.println();
		}
		
	}

}
