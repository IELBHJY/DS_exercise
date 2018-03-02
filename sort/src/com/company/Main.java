package com.company;

import java.util.*;

public class Main  {

    public static void main(String[] args) {
	// write your code here
        Stack<Integer> stack=new Stack<>();
        Queue<Integer> queue=new LinkedList<>();
        List<Student> list=new ArrayList<>();
        int n=50;
        while(n>0){
            stack.push(n%2);
            n=n/2;
        }
        //String a="1";
        //String b="21";
        Random random=new Random();
        List<Student> students = new ArrayList();
        students.add(new Student("yasuo",1,100,60));
        students.add(new Student("jie",2,95,62));
        students.add(new Student("feizi",3,90,64));
        //使用Collections.sort()方法来对集合进行排序
        //Collections.sort(students);
        //System.out.println(students);
        //int[] a1=new int[]{1,2,3};
        //Integer[] a2=new Integer[]{1,2,3};
        //Arrays.sort(a2);
        //List<Integer> integersList = int.asList(a1);
        Integer a[]=new Integer[]{20,34,12,35,67,45,12,1,3,78,100};
        //String a[]=new String[]{"a","b","c"};
        example e=new example();
        //e.MergeBU(a);
        //e.quickThreeWay(a,0,a.length-1);
        //e.show(a);
        e.heapSort(a);
        e.show(a);
    }
}
