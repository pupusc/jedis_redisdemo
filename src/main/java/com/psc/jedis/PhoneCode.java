package com.psc.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class PhoneCode {
    public static void main(String[] args) {
   /*     String code=getCode();
        System.out.println(code);
*/
        //verifyPhoneCode(getCode(),"15377778888");
        getRedisCode("15377778888","623735");


    }
    public static String getCode(){
        Random random=new Random();
        String code="";
        for (int i=0;i<6;i++){
        int rand=random.nextInt(10);
        code+=rand;
        }
        return code;
    }
    //每个手机每天只能发送三次，将验证码发送到redis中，设置过期时间
    public static  void verifyPhoneCode(String code,String PhoneCode){
        Jedis jedis=new Jedis("120.48.109.178",6379);
        jedis.auth("..1253650814..");
        String countKey="verifyCode"+PhoneCode+"count";
        String codeKey="verifyCode"+PhoneCode+"code";
        String count=jedis.get(countKey);
        if (count==null){
            jedis.setex(countKey,24*60*60,"1");
        }else if(Integer.parseInt(count)<2) {
            jedis.incr(countKey);
        }else if (Integer.parseInt(count)>=2){
            jedis.close();
            System.out.println("今日次数超过限制");
        }
        String vcode=getCode();
        jedis.setex(codeKey,120,vcode);
        jedis.close();
    }
    public static void getRedisCode(String Phone,String code){
        Jedis jedis=new Jedis("120.48.109.178",6379);
        jedis.auth("..1253650814..");
        String codeKey="verifyCode"+Phone+"code";
        String RedisCode=jedis.get(codeKey);
        if (code.equals(RedisCode)){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }

}
