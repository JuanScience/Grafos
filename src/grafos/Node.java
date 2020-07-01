package grafos;

public class Node {
    int node;
    Node link;
    
    //Constructor
    public Node(int nNode){
        node = nNode;
        link = null;
    }
    
    //Métodos
    public void setNode(int node) {
        this.node = node;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public int getNode() {
        return node;
    }

    public Node getLink() {
        return link;
    }
}
