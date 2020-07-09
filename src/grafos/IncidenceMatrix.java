
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
    
    public void print(){
        System.out.println("");
        System.out.print("  |");
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i = 0; i < matrix.length; i++){
            System.out.print(i + " |");
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
}
