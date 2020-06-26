package Tarea;
import java.util.Scanner;
// estructura de un nodo
class Nodo{
    public  int valor;
    // apuntador al siguente nodo
    public Nodo sgt;
}
public class SacaFrankEVA_ListasEnlazadas {
    // Nodo global
    public static Nodo nodo = null;
    public static void main(String[] args) {
        // valor que el usuario ingresara
        int valor = 0;
        // Entrada de datos
        Scanner entrada = new Scanner(System.in);
        int op;
        do{
            // Menu para el usuario
            System.out.println("-------------------------------------------");
            System.out.println("||       Listas Enlazadas                ||");
            System.out.println("|| 1) Insertar Datos                     ||");
            System.out.println("|| 2) Listar Datos                       ||");
            System.out.println("|| 3) Eliminar todos los datos           ||");
            System.out.println("|| 4) Eliminar Datos en cierta posicion  ||");
            System.out.println("|| 5) Salir                              ||");
            System.out.println("-------------------------------------------");
            System.out.print("Ingrese...: ");
            // valor que ingresara el usuario segun lo que quiera
            op = entrada.nextInt();
            switch (op){
                // Insertar datos a la lista
                case 1:
                    // solicitar valor al usuario
                    System.out.println("Ingrese el numero: ");
                    valor = entrada.nextInt();
                    // Creacion de un nodo para agregar el valor ingresado
                    Nodo nuevo = new Nodo();
                    // guarda el dato ingresado
                    nuevo.valor = valor;
                    // auxiliares para tener un inicio y un fin
                    Nodo aux = nodo;
                    Nodo aux2 = null;
                    // Mientras el nodo no sea el ultimo y ordenar de manera ascendente
                    while ((aux != null) && (aux.valor < valor)) {
                        // agregar al final para que sea de manera ordenada
                        aux2 = aux;
                        aux = aux.sgt;
                    }
                    // para que el elemento vaya al inicio
                    if (nodo == aux){
                        nodo = nuevo;
                    }else{
                        // Entro al while y debe recorrer una posicion
                        aux2.sgt = nuevo;
                    }
                    // pasara al inicio
                    nuevo.sgt = aux;
                    System.out.printf("Valor %d. Agregado\n",valor);
                    break;
                // Listar todos los datos de la lista
                case 2:
                    // metodo mostrar
                    mostrar(nodo);
                    break;
                // Eliminar datos a la lista en n posicion
                case 3:
                    // Mientras existan valores en la lista
                    while (nodo != null){
                        // Guardaremos el nodo en un auxiliare
                        aux = nodo;
                        // guardamos el valor
                        valor = aux.valor;
                        // Pasams a siguiente nodo
                        nodo = aux.sgt;
                        // Presentamos el nodo borrado
                        System.out.printf("Valor %d Borrado\n",valor);
                    }
                    break;
                // Eliminar datos a la lista en n posicion
                case 4:
                    // Solicitamos el nodo a borrar
                    System.out.print("Dijite el numero a eliminar: ");
                    valor = entrada.nextInt();
                    // validar si la lista tiene datos
                    if(nodo != null){
                        Nodo auxB;
                        Nodo ant = null;
                        // nodo que nos servira para reccorer la lista y buscar el que queremos
                        auxB = nodo;
                        // recorrer la lista y si el valor es diferente del que buscamos
                        while ((auxB != null) && (auxB.valor != valor)){
                            // Respaldar el valor
                            ant = auxB;
                            // Pasar al siguiente
                            auxB = auxB.sgt;
                        }
                        // si es que el dato no existe
                        if(auxB == null){
                            System.out.println("El Valor Que Quiere Eliminar No Existe");
                        // Ciclo usado para saber que es el primer dato el que queremos eliminar
                        }else if(ant == null){
                            // apuntar al siguiente y eliminamos el primero
                            nodo = nodo.sgt;
                        }else {
                            // Apuntador al siguiente
                            ant.sgt = auxB.sgt;
                        }
                    }
                    break;
                // Salida
                case 5:
                    // Salida del sistema
                    System.out.println("Gracias!");
                    break;
                default:
                    // En caso de que el usuario no ingrese el numero correcto
                    System.out.println("Ingrese de nuevo....");
            }
         // Condicion para que el ciclo termine solo si presiona el numero para salir
        }while(op != 5);

    }
    public static void mostrar(Nodo nodo){
        // Nodo auxiliar
        Nodo nuevo = nodo;
        // Mientras la lista tenga datos
        while (nuevo != null) {
            // Presentar el valor
            System.out.println(nuevo.valor+" - Mostrado\n");
            // Paso al siguiente nodo
            nuevo = nuevo.sgt;
        }
    }
}
