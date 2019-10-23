package com.example.learn.web.service;


import com.example.learn.web.dto.UserDTO;
import com.example.learn.web.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.text.StrBuilder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class UserService  {


    public int save(UserVO userVO) {
        System.out.println("userVO 保存用户成功:" + userVO);
        return 1;
    }
    public int save(UserDTO userDTO) {
        System.out.println("userVO 保存用户成功:" + userDTO);
        return 1;
    }
    public String getSegmentedContent(String content, Integer cityId){
        StrBuilder regBuffer = new StrBuilder("(荣和银滩蓝湾)(\\s*)(</project(card|span))?");
        //regBuffer.append(")(\\s*)(</project(card|span))?");//(荣和银滩蓝湾)(\s*)(</project(card|span))?
        String reg = regBuffer.toString();
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);
        matcher.reset();
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (matcher.find()) {
            // 楼盘卡片不处理
            if(null != matcher.group(3)){
                continue;
            }
            String projectName = matcher.group(1);

            String aTagRegex = "<a[^>]*?data-mp-source=\"insert\".*?>[\\s\\S]*?<\\/a>";
            Pattern aPattern = Pattern.compile(aTagRegex);
            Matcher aMatcher = aPattern.matcher(content);
            int projectStart = matcher.start();
            boolean flag = false;
            // 在每个楼盘分词前后查找超链，如果在300字以内，则该楼盘不生成楼盘词链接
            while (aMatcher.find()) {
                int aStart = aMatcher.start();
                int textLength = 0;
                log.debug("aMatcher.end() :: {}",aMatcher.end());
                String subStr = aStart < projectStart ? content.substring(aMatcher.end(), projectStart)
                        : content.substring(matcher.end(), aStart);
                subStr = subStr.replaceAll("<[^>]+>", "");
                try {
                    textLength = subStr.getBytes("GB18030").length;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                if (textLength < 300) {
                    matcher.appendReplacement(sb, matcher.group());
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            matcher.appendReplacement(sb, this.buildProjectSpan() + matcher.group(2));
            // 每个楼盘词链接只出现一次
            //projectMap.put(projectName, null);
            // 一篇文章最多出现3个楼盘词链接
            if(++i >= 3){
                break;
            }
        }
        matcher.appendTail(sb);
        content = sb.toString();

        return content;
    }
    /**
     * 根据楼盘数据生成projectSpan标签
     */
    public String buildProjectSpan( ){
        return new StringBuffer().append("<projectspan class=\"project-span\" data-id=\"")
                .append(110123818).append("\" data-city-id=\"").append(220).append("\">")
                .append("荣和银滩蓝湾").append("</projectspan>").toString();
        //id = {Long@11571} 157559319
        //pid = {Long@11572} 110123818
        //projectName = "荣和银滩蓝湾"
    }
}
