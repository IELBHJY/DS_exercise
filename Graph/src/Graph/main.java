package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by apple on 2018/1/29.
 */
public class main {
    public static void main(String[] args){
        /*Graph g=new Graph(6);
        //g.addEdge(0,1);
        g.addEdge(0,2);
        //g.addEdge(0,5);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        BreadthFirstSearch bfs=new BreadthFirstSearch(g,0);
        Iterator iterator=bfs.pathTo(5);
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        //List<String> text=readTxtFileIntoStringArrList("/Users/apple/Desktop/test.txt");
        //Graph g=new Graph(text.size());
        /*DiGraph g=new DiGraph(13);
        g.addEdge(0,1);
        g.addEdge(0,5);
        g.addEdge(0,6);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,5);
        g.addEdge(5,4);
        g.addEdge(6,4);
        g.addEdge(6,9);
        g.addEdge(7,6);
        g.addEdge(8,7);
        g.addEdge(9,11);
        g.addEdge(9,12);
        g.addEdge(9,10);
        g.addEdge(11,12);
        DepthFirstOrder dfs=new DepthFirstOrder(g);
        Queue<Integer> queue=dfs.post();
        Stack<Integer> stack=dfs.reversepost();
        while(queue.peek()!=null){
            System.out.print(queue.poll()+" ");
        }
        System.out.println();
        while(stack.peek()!=null){
            System.out.print(stack.pop()+" ");
        }*/
    }
    public static List<String> readTxtFileIntoStringArrList(String filePath)
    {
        List<String> list = new ArrayList<String>();
        try
        {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }
}
