package grafos;

/**
 * @author Juan Carlos Salazar Muñoz
 */

import java.util.Scanner;

public class Grafos {
    
    private static final Scanner INGRESO = new Scanner (System.in);
    private static LinkedAdjacencyList LAList;
    private static IncidenceMatrix IMatrix;
    
    public static void main(String[] args) {
        System.out.println("Bienvenido!");
        menu();
    }
    
    //menú de opciones
    public static void menu(){
        System.out.println("\n\n--------------MENÚ GRAFOS--------------");
        System.out.println("(0)  * Insertar grafo");
        System.out.println("(1)  * Recorrido DFS");
        System.out.println("(2)  * Recorrido BFS");
        System.out.println("(3)  * Distancia mínima");
        System.out.println("(4)  * Representación grafo");
        System.out.println("(5)  * Borrar grafo");
        System.out.println("(6)  * Salir");
        System.out.println("----------------------------------------\n");
        System.out.print("Ingrese una opción (0-6) -> ");
        opciones(INGRESO.nextLine());
    }
    
    private static void opciones(String nextLine) {
        if(isNumeric(nextLine)){
            int n = Integer.parseInt(nextLine);
            switch (n){
                case 0: 
                    newGraph();
                    menu();
                case 1:
                    if(created())
                        depthFirstSearch();
                    menu();
                case 2:
                    if(created())
                        breadthFirstSearch();
                    menu();
                case 3:
                    if(created())
                        minimalDistance();
                    menu();
                case 4:
                    if(created()){
                        LAList.print();
                        IMatrix.print();
                    }
                    menu();
                case 5:
                    LAList = null;
                    IMatrix = null;
                    menu();
                case 6:
                    System.out.print("\nAdiós!\n\n");
                    System.exit(0);
                default:
                    System.out.println("\nIngreso no válido");
                    menu();
            }
        }else{
            System.out.println("\nIngreso no válido");
            menu();
        }
    }
    
    //Valida si un string es numérico
    public static boolean isNumeric(String s){
        if("".equals(s) || (s == null ? ("\"" + s + "\"") == null : s.equals("\"" + s + "\""))){//Si se envía un enter
            return false;
        }
        for (int i = 0; i < s.length(); i++){//valida caracter por caracter si es dígito
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public static int requestNumber(String s){
        while(!isNumeric(s)){
            System.out.print("Ingrese un dato válido: ");
            s = INGRESO.nextLine();
        }
        return Integer.parseInt(s);
    }
    
    public static void newGraph() {
        int nNodes = 0;
        while (nNodes == 0){
            System.out.print("Ingrese el número de nodos: ");
            nNodes = requestNumber(INGRESO.nextLine());
        }

        int nBounds = 0;
        while(nBounds > (nNodes * (nNodes - 1)) / 2 || nBounds == 0){
            System.out.print("Ingrese el número de vértices: ");
            nBounds = requestNumber(INGRESO.nextLine());
        }
        LAList = new LinkedAdjacencyList(nNodes);
        IMatrix = new IncidenceMatrix(nNodes, nBounds);
        
        int nodeA, nodeB;
        boolean flag;
        for (int i = 0; i < nBounds; i++){
            flag = true;
            while (flag){
                
                nodeA = nNodes + 1;
                while(nodeA > nNodes){
                    System.out.print("\nIngrese el primer nodo del vértice " + i + ": ");
                    nodeA = requestNumber(INGRESO.nextLine());
                }
                nodeB = nNodes + 1;
                while(nodeB > nNodes){
                    System.out.print("Ingrese el segundo nodo del vértice " + i + ": ");
                    nodeB = requestNumber(INGRESO.nextLine());
                }
                flag = LAList.searchData(nodeA, nodeB);
                
                if(flag)
                    System.out.println("El vértice dado ya existe");
                else{
                    LAList.setData(nodeA, nodeB);
                    IMatrix.setData(i, nodeA, nodeB);
                    
                }
            }
        }
    }
    
    public static boolean created(){
        if(LAList == null){
            System.out.println("\nTodavía no hay un grafo creado");
            return false;
        }
        else
            return true;
    }
    
    public static void depthFirstSearch() {
        if(created()){
            int nNodes = LAList.list.length;
            int start = nNodes + 1;
            while(start > nNodes){
                System.out.print("\nIngrese un nodo para comenzar el recorrido DFS: ");
                start = requestNumber(INGRESO.nextLine());
            }
            boolean[] isVisited = new boolean[nNodes];
            LAList.depthFirstSearch(start, isVisited);                
        }
    }

    private static void breadthFirstSearch() {
        if(created()){
            int nNodes = LAList.list.length;
            int start = nNodes + 1;
            while(start > nNodes){
                System.out.print("\nIngrese un nodo para comenzar el recorrido DFS: ");
                start = requestNumber(INGRESO.nextLine());
            }
            int[] isVisited = new int[nNodes];
            LAList.breadthFirstSearch(start, isVisited);                
        }
    }

    private static void minimalDistance() {
        if(created()){
            int nNodes = LAList.list.length;
            int start = nNodes + 2;
            while(start > nNodes){
                System.out.print("\nIngrese un nodo de partida: ");
                start = requestNumber(INGRESO.nextLine());
            }
            int end = nNodes + 1;
            while(end > nNodes){
                System.out.print("\nIngrese un nodo de llegada: ");
                end = requestNumber(INGRESO.nextLine());
            }
            int[][] isVisited = new int[3][nNodes];
            int distance = 0;
            isVisited = LAList.minimalDistance(start, start, end, isVisited, distance);
            
            if (start == end){
                System.out.println("\nEl nodo de partida es el mismo al de llegada");
            }else if(isVisited[1][end] == 0)
                System.out.println("\nNo existe un camino entre los nodos");
            else{
                String answer = String.valueOf(end);
                int middle = end;
                while(isVisited[0][middle] != start){
                    answer = isVisited[0][middle] + answer;
                    middle = isVisited[0][middle];
                }
                answer = start + answer;
                System.out.print("\nEl nodo " + start + " está de " + end + " a una distancia de: ");
                System.out.println(isVisited[1][end]);
                System.out.println("La ruta es: " + answer);
            }
        }        
    }

}
