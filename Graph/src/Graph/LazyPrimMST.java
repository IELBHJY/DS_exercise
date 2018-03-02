package Graph;


import java.util.*;

/**
 * Created by apple on 2018/2/2.
 */
public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;
    public LazyPrimMST(EgdeWeightedGraph g){
        marked=new boolean[g.V()];
        mst=new LinkedList<Edge>();
        pq=new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.weight,o2.weight);
            }
        });
        visit(g,0);
        while(!pq.isEmpty()){
            Edge e=pq.poll();
            int v=e.either();
            int w=e.other(v);
            if(marked[v]&&marked[w]) continue;
            mst.offer(e);
            //将v或者w加入树中
            if(!marked[v]) visit(g,v);
            if(!marked[w]) visit(g,w);
        }
    }
    private void visit(EgdeWeightedGraph g,int v){
        //标记v，并且将所有链接v和未被标记定点的边加入pq
        marked[v]=true;
        for(Edge e:g.adj(v)){
            if(!marked[e.other(v)]){
                pq.add(e);
            }
        }
    }
    public Iterable edges(){
        return mst;
    }
    public double weight(){
        double weight=0;
        while(!mst.isEmpty()){
            Edge e=mst.poll();
            weight+=e.weight;
        }
        return weight;
    }
}
