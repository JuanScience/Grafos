
package grafos;

public class LinkedAdjacencyList {
    Node[] list;
    
    //Constructor
    public LinkedAdjacencyList(int nNodes){
        list = new Node[nNodes];
        for (int i = 0; i < nNodes; i++) {
            list[i] = new Node(i); 
        }
    }
    
    //Métodos
    public void setData(int nodeA, int nodeB) {
        Node flag = list[nodeA];
        while (flag.getLink() != null){
            flag = flag.getLink();
        }
        Node x = new Node(nodeB);
        flag.setLink(x);
        
        flag = list[nodeB];
        while (flag.getLink() != null){
            flag = flag.getLink();
        }
        x = new Node(nodeA);
        flag.setLink(x);
    }
    
    public boolean searchData(int nodeA, int nodeB) {
        Node flag = list[nodeA].getLink();
        while(flag != null){
            if(flag.getNode() == nodeB)
                return true;
            else
                flag = flag.getLink();
        }
        return false;
    }
    
    public void print(){
        Node flag;
        for (Node list1 : list) {
            flag = list1;
            System.out.println("");
            while (flag != null){
                if(flag.getLink() != null)
                    System.out.print("[" + flag.toString().substring(flag.toString().length() - 6)
                            + "|" + flag.getNode() + "|" 
                            + flag.getLink().toString().substring(flag.getLink().toString().length() - 6) + "] ");
                else
                    System.out.print("[" + flag.toString().substring(flag.toString().length() - 6) 
                            + "|" + flag.getNode() + "|null] ");
                flag = flag.getLink();
            }
        }
        System.out.println("");
    }
    
    public void depthFirstSearch(int node, boolean[] visited) {
        visited[node] = true; //Se controla los visitados
        System.out.print(node + " ");
        Node a = this.list[node].getLink();
        while(a != null){
            if(!visited[a.getNode()])
                depthFirstSearch(a.getNode(),visited);
            a = a.getLink();
        }
    }

    public void breadthFirstSearch(int node, int[] visited) {
        if(visited[node] == 0){
            visited[node] = 2;
            System.out.print(node + " ");
        }
        if(visited[node] == 1){
            visited[node] = 2;
        }
        Node a = this.list[node].getLink();
        while(a != null){
            if(visited[a.getNode()] == 0){
                visited[a.getNode()] = 1;
                System.out.print(a.getNode() + " ");
            }
            a = a.getLink();
        }
        a = this.list[node].getLink();
        while(a != null){
            if(visited[a.getNode()] == 1)
                breadthFirstSearch(a.getNode(), visited);
            a = a.getLink();
        }
    }

    public int[][] minimalDistance (int node, int start, int end, int[][] visited, int distance){
        if(visited[2][node] == 0){
            visited[0][node] = node;
            visited[1][node] = distance;
            visited[2][node] = 2;
            if(start == end){
                return visited;
            }
        }else if(visited[2][node] == 1){
            visited[2][node] = 2;
        }
        Node a = this.list[node].getLink();
        distance = distance + 1;
        while(a != null){
            if(visited[2][a.getNode()] == 0 || visited[1][a.getNode()] >= distance){
                visited[0][a.getNode()] = node;
                visited[1][a.getNode()] = distance;
                visited[2][a.getNode()] = 1;
                minimalDistance(a.getNode(), start, end, visited, distance);
            }           
            a = a.getLink();
        }

        return visited;
    }

    public void printPath(int start, int end, int[][] visited) {
        System.out.print(start + " está de " + end + " a una distancia de: ");
        System.out.println(visited[1][end]);
        String answer = String.valueOf(end);
        int middle = end;
        while(visited[0][middle] != start){
            answer = visited[0][middle] + answer;
            middle = visited[0][middle];
        }
        answer = start + answer;
        System.out.println("La ruta es: " + answer);
    }
    
}
