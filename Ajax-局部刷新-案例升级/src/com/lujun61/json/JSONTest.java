package com.lujun61.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lujun61.ajax.entity.Province;

/**
 * @description 使用jackson将把java对象转换为json格式的字符串
 * @author Jun Lu
 * @date 2021-10-07 20:10:53
 */
public class JSONTest {
    public static void main(String[] args) {
        Province province = new Province(1, "河北", "冀", "石家庄");

        ObjectMapper om = new ObjectMapper();

        String json = null;

        try {
            //writeValueAsString：参数为java对象；返回结果为JSON格式的字符串
            json = om.writeValueAsString(province);
            System.out.println("转换后的JSON格式：" + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
