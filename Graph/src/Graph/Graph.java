package Graph;


//import java.util.Iterator;

import java.util.Iterator;

/**
 * Created by apple on 2018/1/29.
 */
public class Graph {
    private final int V;
    private int E;
    public Bag<Integer>[] adj;
    public Graph(int v){
        this.V=v;
        this.E=0;
        adj=new Bag[v];
        for(int i=0;i<v;i++){
            adj[i]=new Bag<Integer>();
        }
    }
    public int V(){
        return this.V;
    }
    public int E(){
        return this.E;
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterator adj(int v){
        return adj[v].iterator();
    }
}
