package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Map<Integer,String> map= new ConcurrentSkipListMap<>();
        Set<Integer> set=new ConcurrentSkipListSet<>();
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        map.put(23,"23");
        map.remove(2);
        for(Integer i :map.keySet()){
            System.out.println(map.get(i));
        }*/
        SkipList<String> list=new SkipList<String>();
        //System.out.println(list);
        list.put(1, "yan");
        list.put(2, "co");
        //list.put(3, "feng");
        list.put(7, "cao");//测试同一个key值
        //list.put(4, "曹");
        list.put(6, "丰");
        //list.put(5, "艳");
        //list.delete();
        System.out.println(list.findNode(5));
        //System.out.println(list.search(3));
        //System.out.println(list.toString());
        //System.out.println(list.search(2));
    }
}
