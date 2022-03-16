package com.srs.imooc.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JedisDemo {

    public static void main(String[] args) {
        Jedis jedis =  new Jedis("120.53.100.18", 6380);
        try {
            jedis.select(3);
            System.out.println("redis链接成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        //字符串
        jedis.set("srs","srs");
        System.out.println(jedis.get("srs1"));
        //多个字符串
        jedis.mset(new String[]{"id","1", "name", "奶粉"});
        List<String> goods = jedis.mget(new String[]{"id", "name"});
        System.out.println(goods);
        //自增
        jedis.incr("num");
        System.out.println("num=" + jedis.get("num"));
        //自减
        jedis.decr("num");
        System.out.println("num=" + jedis.get("num"));


        //Hash
        jedis.hset("Goods:1", "id", "1");
        jedis.hset("Goods:1", "name", "电视机");
        System.out.println(jedis.hget("Goods:1", "name"));
        Map<String, String> goods2 = new HashMap<>();
        goods2.put("id", "2");
        goods2.put("name", "冰箱");
        //hset
        jedis.hmset("Goods:2", goods2);
        //hget
        System.out.println(jedis.hget("Goods:2", "name"));
        //hgetAll获取key对应的所有数据
        System.out.println(jedis.hgetAll("Goods:2"));

        //list
        jedis.del("list");
        //从右添加数据
        jedis.rpush("list", new String[]{"d", "e", "f"});
        //从左添加数据
        jedis.lpush("list", new String[]{"c","b","a"});
        //获取list中的数据
        System.out.println(jedis.lrange("list", 0, -1));
        //从左弹出数据
        jedis.lpop("list");
        //从右弹出数据
        jedis.rpop("list");
        System.out.println(jedis.lrange("list", 0, -1));

    }
}
