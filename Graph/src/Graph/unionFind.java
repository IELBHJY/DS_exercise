package Graph;


/**
 * Created by apple on 2018/1/29.
 */
public class unionFind {
   private int[] id;
   private int[] sz;
   private int count;

    public unionFind(int N) {
        count=N;
        id=new int[N];
        for(int i=0;i<N;i++) id[i]=i;
        sz=new int[N];
        for(int i=0;i<N;i++) sz[i]=1;
    }
    public int getCount(){
        return count;
    }
    public boolean connection(int p,int q){
        return id[p]==id[q];
    }
    public int find(int n){
        while(n!=id[n]){
            id[n]=id[id[n]];
            n=id[n];
        }
        return n;
    }
    public void union(int p,int q){
        int i=find(p);
        int j=find(q);
        if(i==j) return;
        if(sz[i]<sz[j]) {id[i]=j;sz[j]+=sz[i];}
        else{id[j]=i;sz[i]+=sz[j];}
        count--;
    }
}
