package com.example.learn.local.位运算;

public class No1 {
    public static void main(String[] args) {
      //testOdd();
        testCount1();
    }

    /**
     * 测试 是否是奇数
     */
    private static void  testOdd(){
        System.out.println(String.format("%d 是奇数吗？ %s ",2,isOdd(2)));
        System.out.println(String.format("%d 是奇数吗？ %s ",3,isOdd(3)));
        System.out.println(String.format("%d 是奇数吗？ %s ",-2,isOdd(-2)));// false [return num % 2 == 1;// bad]
        System.out.println(String.format("%d 是奇数吗？ %s ",-3,isOdd(-3)));// false

    }

    /**
     * 三种不同写法，判断奇偶。
     * 第一种，在 有符号数和负数时，有问题。
     * @param num
     * @return
     */
    private static Boolean isOdd(int num) {
        // 普通
//        return num % 2 == 1;// bad
//        return num % 2 != 0;// ok
        // 位运算
        return (num & 0x1) == 0x1;
    }

    private static void testCount1 (){
        System.out.println(String.format("%d 二进制中1的个数 %d",1,countOf1( 1)));
        System.out.println(String.format("%d 二进制中1的个数 %d",2,countOf1( 2)));
        System.out.println(String.format("%d 二进制中1的个数 %d",3,countOf1( 3)));
        System.out.println(String.format("%d 二进制中1的个数 %d",4,countOf1( 4)));
        System.out.println(String.format("%d 二进制中1的个数 %d",0x10,countOf1( 0x10)));
        System.out.println(String.format("%d 二进制中1的个数 %d",0x7f,countOf1( 0x7f)));
        System.out.println(String.format("%d 二进制中1的个数 %d",1,countOf1( 1)));

    }

    /**
     * 返回整数中二进制1的个数
     * @param num
     * @return
     */
    private static  int countOf1(int num){
        int cnt = 0;
        while (num != 0){
//            if ((num & 0x1) == 1 ) {
//                cnt += 1;
//            }
            num = num & (num-1);
            cnt += 1;
        }
        return cnt;
    }

    /**
     * 如果 N是奇数，那么 N-1 是偶数，那么N的二进制位比N-1的二进制位多且仅多最后一位。
     * 如果 N是偶数，那么 N-1 是奇数，
     *
     *  相与后  N的二进制最后一位被消掉了。
     * @param num
     * @return
     */
    private static int countOf1Better(int num){
        int cnt = 0;
        while (num != 0){
            num = num & (num-1);
            cnt += 1;
        }
        return  cnt;
    }
}
