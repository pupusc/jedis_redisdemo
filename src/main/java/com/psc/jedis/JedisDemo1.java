package com.psc.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.xml.soap.SOAPElementFactory;
import java.util.*;

public class JedisDemo1 {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("120.48.109.178",6379);
        jedis.auth("..1253650814..");
        String value=jedis.ping();
        System.out.println(value);

    }
        @Test
    public void demo1(){
        Jedis jedis=new Jedis("120.48.109.178",6379);
        jedis.auth("..1253650814..");
        jedis.set("name","lucy");
        jedis.mset("sex","boy","age","19");
        String name=jedis.get("name");
        List<String> mget=jedis.mget("name","sex","age");

        System.out.println(name);
        Set<String> keys=jedis.keys("*");
        for(String key:keys){
            System.out.println(key);
        }

    }
    @Test
    public void demo2(){
        Jedis jedis=new Jedis("120.48.109.178",6379);
        jedis.auth("..1253650814..");
        jedis.lpush("zhao","12","haha");
        List<String> list= jedis.lrange("zhao",0,-1);
        System.out.println(list);
       /* for (String element:list){
            System.out.println(element);
        }*/
    }
    @Test
    public  void demo3(){
        Jedis jedis=new Jedis("120.48.109.178",6379);
        jedis.auth("..1253650814..");
        jedis.sadd("name","jake","lucy");
        Set<String> set=jedis.smembers("name");
        System.out.println(set);
    }
    @Test
    public void demo4(){
        Jedis jedis=new Jedis("120.48.109.178",6379);
        jedis.auth("..1253650814..");
        jedis.hset("001","name","lisi");
        jedis.hset("001","age","17");
        Map<String , String > map=new HashMap<String, String>();

    }


}
