package com.company;

/**
 * Created by apple on 2018/1/11.
 */
public class example {

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exChange(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public static void show(Comparable[] a){
        for(Comparable i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void Selection(Comparable[] a){
        //按 a[] 升序排列,思路：N次循环，每次将a[i] 和a[i+1,,,,N]中最小的元素交换
        int N=a.length;
        for(int i=0;i<N;i++){
            int min=i;
            for(int j=i+1;j<N;j++){
                if(less(a[j],a[min])){
                    min=j;
                }
            }
            exChange(a,i,min);
        }
    }

    public static void Insertion(Comparable[] a){
        //a[] 升序列排序,思路：将a[i] 插入到a[i-1],a[i-2],a[i-3],.....
        int N=a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exChange(a,j,j-1);
            }
        }
    }

    public static void Shell(Comparable[] a){
        //a[] 生序，思路：将a分成h列，对每列进行Insertion，每次缩减h，直到h=1
        int N=a.length;
        int h=1;
        while(h<N/3) h=3*h+1;//h=1,4,13,40,121,364,1093
        while(h>=1){
            //从每列第二个元素开始
            for(int i=h;i<N;i++){
                //将a[i] insert into a[i-h],a[i-2*h],a[i-3*h],,.....
                for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h){
                    exChange(a,j,j-h);
                }
            }
            h/=3;
        }
    }

    private static Comparable aux[];
    private static void merge(Comparable[] a,int lo,int mid,int hi){
        int i=lo;
        int j=mid+1;
        for(int k=lo;k<=hi;k++){
            aux[k]=a[k];
        }
        for(int k=lo;k<=hi;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(aux[j],aux[i])) a[k]=aux[j++];
            else a[k]=aux[i++];
        }
    }

    public static void MergeSort(Comparable[] a,int lo,int hi){
        aux=new Comparable[a.length];
        if(hi<=lo) return ;
        int mid=lo+(hi-lo)/2;
        MergeSort(a,lo,mid);
        MergeSort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void MergeBU(Comparable[] a)
    {
        int N=a.length;
        aux=new Comparable[N];
        for(int sz=1;sz<N;sz*=2){
            for(int lo=0;lo<N-sz;lo+=2*sz){
                merge(a,lo,lo+sz-1,Math.min(lo+sz-1+sz,N-1));
            }
        }
    }

    public static void quickSort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int j=partition(a,lo,hi);
        quickSort(a,lo,j-1);
        quickSort(a,j+1,hi);
    }
    private static int partition(Comparable[] a,int lo,int hi){
        //数组切分， it is: the left part of i no more than a[i], the right part of i no less than a[i]
        int i=lo;
        int j=hi+1;
        Comparable v=a[lo];// 切分元素
        while(true){
            while(less(a[++i],v)){if(i==hi) break;}
            while(less(v,a[--j])){if(j==lo) break;}
            if(i>=j) break;
            exChange(a,i,j);
        }
        exChange(a,lo,j);
        return j;
    }

    public static void quickThreeWay(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int lt=lo;
        int i=lo+1;
        int gt=hi;
        Comparable v=a[lo];
        while(i<=gt){
            int cmp=a[i].compareTo(v);
            if(cmp<0) exChange(a,lt++,i++);
            else if(cmp>0) exChange(a,i,gt--);
            else i++;
        }
        quickSort(a,lo,lt-1);
        quickSort(a,gt+1,hi);
    }

    private static boolean less(Comparable[] pq,int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    private static void change(Comparable[]pq,int i,int j){
        Comparable t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }

    private static void sink(Comparable[] a,int k,int N){
        while(2*k<=N){
            int j=2*k;
            if(j<N&&less(a,j,j+1)) j++;
            if(!less(a,k,j)) break;
            change(a,k,j);
            k=j;
        }
    }

    private static void swim(Comparable[] a,int k){
        while(k>1&&less(a,k/2,k)){
            exChange(a,k/2,k);
            k=k/2;
        }
    }

    public static void heapSort(Comparable[] pq){
        int N=pq.length;
        Comparable[] a=new Comparable[N+1];
        for(int i=0;i<N;i++){
            a[i+1]=pq[i];
        }
        for(int i=N/2;i>0;i--){
            sink(a,i,N);
        }
        while(N>1){
           change(a,1,N--);
           sink(a,1,N);
        }
    }
}
