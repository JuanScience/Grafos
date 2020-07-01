
package grafos;

public class IncidenceMatrix {
    int[][] matrix;
    
    //Constructor
    public IncidenceMatrix(int nNodes, int nBounds){
        matrix = new int[nNodes][nBounds];
    }
    
    public void setData(int bound, int nodeA, int nodeB) {
        matrix[nodeA][bound] = 1;
        matrix[nodeB][bound] = 1;
    }
    
    public boolean searchData(int nodeA, int nodeB) {
        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[nodeA][i] == 1 && matrix[nodeB][i] == 1){
                return true;
            }
        }
        return false;
    }
    
}
