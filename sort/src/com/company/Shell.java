package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;

/**
 * Created by apple on 2018/1/11.
 */
public class Shell {
     public static void sort(int[] a){
         int N=a.length;
         int h=1;
         while(h<=N/3) h=3*h+1;
         while(h>=1){
             for(int i=h;i<N;i++){
                 for(int j=i;j>=h&&(a[j]<a[j-h]);j-=h){
                     int temp=a[j];
                     a[j]=a[j-h];
                     a[j-h]=temp;
                 }
             }
             for(int z:a){
                 System.out.print(z+" ");
             }
             System.out.println(h);
             h=h/3;
             System.out.println();
         }
     }
     public static void main(String[] args){
        int a[]=new int[]{14,16,13,12,5,2,9,10,11,1,6,7,20,4,15};
         PriorityQueue<Integer> queue=new PriorityQueue<>();
         List<Integer> list=new ArrayList<>();
         for(int i:a){
             queue.offer(i);
         }
         for(int i=0;i<a.length;i++){
             System.out.print(queue.poll()+"  ");
         }
         HashMap<Integer,String> hp=new HashMap<>();
     }
}
