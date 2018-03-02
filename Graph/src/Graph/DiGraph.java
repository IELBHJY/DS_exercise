package Graph;

/**
 * Created by apple on 2018/1/30.
 */
public class DiGraph {
    private final int V;
    private int E;
    public Bag<Integer>[] adj;
    public DiGraph(int v){
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
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public DiGraph reverse(){
        DiGraph r=new DiGraph(this.V);
        for(int i=0;i<V();i++){
            for(int w:this.adj(i)){
                r.addEdge(w,i);
            }
        }
        return r;
    }
}
