package mine.leetcode.lemonade_change;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sim
 * Date: 2020-12-10
 * Time: 11:05 上午
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> accountBook = new HashMap<Integer, Integer>();
        accountBook.put(5,0);
        accountBook.put(10,0);
        accountBook.put(20,0);

        for (int k:bills){
            if (k==5){
                accountBook.put(5,accountBook.get(5)+1);
            }else if (k==10){
                if (accountBook.get(5) - 1>=0){
                    accountBook.put(5, accountBook.get(5) - 1);
                    accountBook.put(10, accountBook.get(10)+1);
                }else {
                    return false;
                }
            }else if (k==20){
                if (accountBook.get(10) -1 >=0 && accountBook.get(5) - 1 >=0 ) {
                    accountBook.put(10,accountBook.get(10) -1);
                    accountBook.put(5,accountBook.get(5) - 1);
                    accountBook.put(20,accountBook.get(20)+1);
                }else if (accountBook.get(5) - 3 >=0) {
                    accountBook.put(5,accountBook.get(5) - 3);
                    accountBook.put(20,accountBook.get(20)+1);
                } else {
                    return false;
                }


            }


        }
        return true;
    }
    
    public boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int k : bills) {
            if (k == 5){
                five++;
            }else if (k == 10) {
                if (five<=0){
                    return false;
                }
                five--;
                ten++;
            }else {
                if (five<=0){
                    return false;
                }

                if (ten-1>=0 && five-1>=0) {
                    ten--;
                    five--;
                }else {
                    five -=3;
                }
            }
            if (five<0){
                return false;
            }
        }
        return true;
    }

    public boolean lemonadeChange3(int[] bills) {
        // 20美金 优先使用10 + 5的方案
        if (bills.length == 0) return true;
        if (bills.length == 1) return bills[0] == 5;

        int five = 0, ten = 0;
        for (int k : bills) {
            if (k == 5){
                five++;
            }else if (k == 10) {
                if (five<=0){return false;}
                five--;
                ten++;
            }else {
                if (five<=0){return false;}
                if (ten-1>=0 && five-1>=0) {
                    ten--;
                    five--;
                }else {
                    five -=3;
                }
            }
            if (five<0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] input = new int[]{5,5,5,10,20};
        boolean result = new Solution().lemonadeChange2(input);
        System.out.println(result);
    }
}
