package Graph;

/**
 * Created by apple on 2018/2/1.
 */
public class Edge implements Comparable<Edge> {
    public int v;
    public int w;
    public double weight;
    public Edge(int v,int w,double weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    public int either(){
        return v;
    }
    public int other(int w){
        if(w==this.v) return w;
        else if(w==this.w) return v;
        else throw new  RuntimeException("incompation edge");
    }
    @Override
    public int compareTo(Edge that){
        if(this.weight<that.weight) return -1;
        else if(this.weight>that.weight) return 1;
        else return 0;
    }
    @Override
    public String toString(){
        return "["+v+"-->>"+w+"]"+"("+weight+")";
    }
}
