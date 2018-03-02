package Graph;

import java.util.Iterator;

/**
 * Created by apple on 2018/1/29.
 */
public class CC {
    private int count;
    private int[] id;
    private boolean[] marked;
    public CC(Graph g){
        count=g.V();
        id=new int[g.V()];
        marked=new boolean[g.V()];
        for(int i=0;i<g.V();i++){
            if(!marked[i]) {
                dfs(g,i);
                count++;
            }
        }
    }
    private void dfs(Graph g,int s){
        marked[s]=true;
        id[s]=count;
        Iterator iterator=g.adj(s);
        while(iterator.hasNext()){
            int w=(int)iterator.next();
            if(!marked[w]) dfs(g,w);
        }
    }
    public boolean isConnect(int v,int w){
        return id[v]==id[w];
    }
    public int id(int v){
        return id[v];
    }
    public int Count(){return this.count;}
}
