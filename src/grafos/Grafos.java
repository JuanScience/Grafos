package grafos;

/**
 * @author Juan Carlos Salazar Muñoz
 */

import java.util.Scanner;

public class Grafos {
    
    private static final Scanner INGRESO = new Scanner (System.in);
    private static LinkedAdjacencyList LAList;
    
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
        System.out.println("(3)  * Borrar");
        System.out.println("(4)  * Salir");
        System.out.println("----------------------------------------\n");
        System.out.print("Ingrese una opción (0-4) -> ");
        opciones(INGRESO.nextLine());
    }
    
    private static void opciones(String nextLine) {
        if(isNumeric(nextLine)){
            int n = Integer.parseInt(nextLine);
            switch (n){
                case 0: 
                    newGraph(requestNumber(INGRESO.nextLine()));
                    menu();
                case 1:
                    menu();
                case 2:
                    
                    menu();
                case 3:
                    
                    menu();
                case 4:
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
        System.out.print("Ingrese el número de nodos: ");
        String nodes = INGRESO.nextLine();
        while(!isNumeric(nodes)){
            System.out.print("Ingrese un dato válido: ");
            nodes = INGRESO.nextLine();
        }
        return Integer.parseInt(nodes);
    }
    
    public static void newGraph(int nNodes) {
        LAList = new LinkedAdjacencyList(nNodes);
        for (int i = 0; i < nNodes; i++){
            System.out.println("Cuando el nodo no tenga más relaciones, por favor presione 's'");
            boolean flag = false;
            int number;
            while (!flag){
                System.out.print("Ingrese un nodo con el que tenga relación el nodo " + i + ": ");
                String node = INGRESO.nextLine();
                
                while(!isNumeric(node) || node.toUpperCase().charAt(0) != 'S'){
                    System.out.print("Ingrese un dato válido: ");
                    node = INGRESO.nextLine();
                }
                
                if (node.toUpperCase().charAt(0) == 'S')
                    flag = true;
                else{
                    number = Integer.parseInt(node);
                    if (number >= 0 && number <nNodes){
                        //Verifique si ya está
                        
                        //Inserta la relación
                    }
                    else{
                        System.out.println("El nodo ingresado está fuera del rango del grafo");
                    }
                }
            }
        }
    }
}
