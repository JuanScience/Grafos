
package grafos;

public class LinkedAdjacencyList {
    Node[] list;
    
    //Constructor
    public LinkedAdjacencyList(int nNodes){
        list = new Node[nNodes];
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
        Node flag = list[nodeA];
        while (flag.getLink() != null){
            if(flag.getNode() == nodeB)
                return true;
            flag = flag.getLink();
        }
        return false;
    }
    
}
