package com.example.noWeb.alg.leetocde.递归回溯.组合基础题;

import java.util.ArrayList;
import java.util.List;

public class No17_电话号码组合 {
    private String[] letterMap = {" ",//0
            "",  //1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz"//9

    };
    private ArrayList<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return res;
        }

        findCombination(digits,0,"");

        return res;
    }

    private void findCombination(String digits, int index, String s) {
        if(index==digits.length()){
            res.add(s);
            return;
        }
        char c = digits.charAt(index);

        String letters = letterMap[c-'0'];
        for(int i =0;i<letters.length();i++){
            findCombination(digits,index+1,s+letters.charAt(i));
        }
    }

}
