import java.util.*;
class Graph {
    private int vertices;
    private List<List<Integer>> adjacencyList;
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    public void addedge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); 
    }

    void BFS(int startv)
    {
        boolean visited[]=new boolean[vertices];
        Queue <Integer> q=new LinkedList<>();
        visited[startv]=true;
        q.add(startv);
        while(!q.isEmpty())
        {
            int v=q.poll();
            System.out.print(v+" ");
            for(int i:adjacencyList.get(v))
            {
                if(!visited[i])
                {
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        Graph g=new Graph(n);
        for(int i=0;i<n;i++)
        {
            int u=obj.nextInt();
            int v=obj.nextInt();
            g.addedge(u,v);
        }
        g.BFS(0);
    }
}