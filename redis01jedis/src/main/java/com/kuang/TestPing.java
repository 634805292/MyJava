package com.kuang;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2021/1/14 21:23
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("123.56.116.224", 6379);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","kuangshen");
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();

        jedis.close();
    }
}
