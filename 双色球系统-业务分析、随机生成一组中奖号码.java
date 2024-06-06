package com.study;
 
import java.util.Random;
import java.util.Scanner;
 
public class Test7 {
    public static void main(String[] args) {
        //1、随机6个红球号码（1-33，不能重复），随机一个篮球号码（1-16），可以采用数组装起来作为中奖号码
       int[] luckNumbers = createLuckNumber();
 
 
        //2、用户选中的号码
        int[] userNumbers = userInputNumbers();
 
        //3、判断中奖情况
        judge(luckNumbers,userNumbers);
    }
 
    public static void judge(int[] lunckNumbers,int[] userNumbers){
        //判断是否中奖了
        //1、定义两个变量分别存储红球命中的个数，以及篮球命中的个数
        int red = 0;
        int blue = 0;
 
        //2、判断红球命中了几个，开始统计
        for (int i = 0; i < userNumbers.length - 1; i++) {
            for (int j = 0; j < lunckNumbers.length - 1; j++) {
                //每次找到了相等了，意味着当前号码命中了
                if (userNumbers[i] == lunckNumbers[j]){
                    red ++;
                    break;
                }
            }
        }
        //蓝球号码是否命中了
        blue = lunckNumbers[6] == userNumbers[6] ? 1 : 0;
 
        System.out.println("中奖号码是：" );
        printArray(lunckNumbers);
        System.out.println("您投注的号码是：" );
        printArray(userNumbers);
        System.out.println("您命中了几个红球："+red);
        System.out.println(("您是否命中蓝球："+(blue == 1 ? "是":"否")));
 
 
        //判断中奖情况
        if(blue == 1 && red < 3){
            System.out.println("恭喜您，中了5元小奖！");
        }else if((blue == 1 && red == 3) || (blue == 0 && red == 4)){
            System.out.println("恭喜您，中了10元小奖！");
        }else if((blue == 1 && red == 4) || (blue == 0 && red == 5)){
            System.out.println("恭喜您，中了200元大奖！");
        }else if(blue == 1 && red == 5){
            System.out.println("恭喜您，中了3000元大奖！");
        }else if(blue == 0 && red == 6){
            System.out.println("恭喜您，中了500万超级大奖！");
        }else if(blue == 1 && red == 6){
            System.out.println("恭喜您，中了1000万巨奖！可以开始享受人生，诗和远方！");
        }else{
            System.out.println("感谢您为福利事业作出的突出贡献！");
        }
 
    }
 
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();//换行
    }
 
    public static int[] userInputNumbers(){
        //a、定义一个数组存储7个号码
        int[] numbers = new int[7];
        //b、让用户录入6个红球
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.println("请您输入第"+(i+1)+"个红球号码（1-33，要求不重复）：");
            int data = sc.nextInt();
            //c、把当前录入的数据存入到数组中去
            numbers[i] = data;
        }
 
        //d、单独录入一个蓝球号码
        System.out.println("请您输入蓝球号码（1-16）：");
        numbers[6] = sc.nextInt();
        return numbers;
    }
 
    public static int[] createLuckNumber() {
        //a、定义一个动态初始化的数组，存储7个数字
        int[] numbers = new int[7];
        //b、遍历数组，为每个位置生成对应的号码。（注意：遍历前6个位置，生成6个不重复的红球号码，范围是1-33）
        Random r = new Random();
        for (int i = 0; i < numbers.length; i++) {
            while (true) {
                int data = r.nextInt(33) + 1;//1-33 —— >  (0-32)+1
                //c.注意：必须判断当前随机的这个号码之前是否出现过，出现过要重新随机一个，直到不重复为止，才可以存入数组中去
                //定义一个flag变量，默认data没有重复
                boolean flag = true;
                for (int j = 0; j < i; j++) {
                    if (numbers[j] == data) {
                        //data当前这个数据之前出现过，不能用
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    //data这个数据之前没有出现过，可以使用了
                    numbers[i] = data;
                    break;
                }
            }
        }
        //d、为第7个位置生成一个1-16的号码作为篮球号码
        numbers[numbers.length - 1] = r.nextInt(16) +1;
        return numbers;
    }
}