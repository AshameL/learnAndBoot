package com.example.noWeb.alg.jianzhiOffer;

public class T02__替换空格 {
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;// spacenums为计算空格数
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)==' '){
                spaceNum++;
            }
        }
        int indexOld = str.length()-1; // indexOld为 替换前str的下标
        int newLength = str.length() + spaceNum*2;// 计算宫格转换成%20后的str下标
        int indexNew = newLength-1; // indexNew为 替换后的str的下标
        str.setLength(newLength); // 使str的长度扩大到转换成 %20 之后的长度，防止下标越界
        for(;indexOld>=0 && indexOld<newLength; indexOld--){
            if(str.charAt(indexOld)==' '){
                str.setCharAt(indexNew--,'0');
                str.setCharAt(indexNew--,'2');
                str.setCharAt(indexNew--,'%');
            }else {
                str.setCharAt(indexNew--,str.charAt(indexOld));
            }
        }
        return str.toString();

    }
}
