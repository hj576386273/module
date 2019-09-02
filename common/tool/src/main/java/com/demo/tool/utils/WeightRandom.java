package com.demo.tool.utils;

import java.util.*;

/**
 * @author huangjian
 * @version 1.0
 * @Description 加权随机算法
 * @date 2018/4/9
 */
public class WeightRandom {

    /**
      * @author huangjian
      * @Description  随机轮询
      * @Date 2018/4/9
      * @Param Map key:键 value:权重
      * @return java.lang.String key
      */
    public static String selectServer(Map<String, Integer> servers) {
        if (servers == null || servers.size() == 0) {
            return null;
        }

        Integer sum = 0;
        Set<Map.Entry<String, Integer>> entrySet = servers.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().getValue();
        }
        Integer rand = new Random().nextInt(sum) + 1;
        for (Map.Entry<String, Integer> entry : entrySet) {
            rand -= entry.getValue();
            if (rand <= 0) {
                return entry.getKey();
            }
        }

        return null;
    }

    /*public static void main(String[] args){
        Map<String, Integer> servers = new HashMap<String, Integer>();
        servers.put("192.168.20.101", 100);
        servers.put("192.168.20.102", 200);
        servers.put("192.168.20.103", 300);
        servers.put("192.168.20.104", 400);

        Map<String, Integer> map = new HashMap<String, Integer>();
        String key = null;
        for(int i = 0; i < 1000; i++){
            key = selectServer(servers);
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }
        for(String key1 : map.keySet()){
            System.out.println(key1 + " " + map.get(key1));
        }
    }*/

}
