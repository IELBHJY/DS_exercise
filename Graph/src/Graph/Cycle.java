package Graph;

import java.util.Iterator;

/**
 * Created by apple on 2018/1/30.
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    public Cycle(Graph g){
        marked=new boolean[g.V()];
        for(int i=0;i<g.V();i++){
            if(!marked[i]){
                dfs(g,i,i);
            }
        }
    }
    private void dfs(Graph g,int v,int u){
        marked[v]=true;
        Iterator iterator=g.adj(v);
        while(iterator.hasNext()){
            int w=(int)iterator.next();
            if(!marked[w]){
                dfs(g,w,v);
            }
            else if(w!=u) hasCycle=true;
        }
    }
    public boolean hasCycle(){
        return hasCycle;
    }
}
