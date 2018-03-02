package Graph;

/**
 * Created by apple on 2018/2/2.
 */
public class EgdeWeightedGraph {
    private final int V;
    private int E;
    Bag<Edge>[] adj;
    public EgdeWeightedGraph(int v){
        this.V=v;
        this.E=0;
        adj=(Bag<Edge>[]) new Bag[this.V];
        for(int i=0;i<v;i++){
            adj[i]=new Bag<Edge>();
        }
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }
    public void addEdge(Edge e){
        int v=e.either();
        int w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public Iterable<Edge> adj(int v){
        return adj[v];
    }
    public Iterable<Edge> edges(){
        Bag<Edge> b=new Bag<Edge>();
        for(int v=0;v<V;v++){
            for(Edge e:adj(v)){
                if(e.other(v)>v){
                    b.add(e);
                }
            }
        }
        return b;
    }
}
