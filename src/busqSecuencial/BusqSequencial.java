/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqSecuencial;

import java.util.Random;
import java.util.Scanner;

public class BusqSequencial {
    int[] datos;
    int[] datosA;
    int[] datosD;
    
    public BusqSequencial(){
        datos = new int[500];
        datosA = new int[500];
        datosD = new int[500];
    }
    public BusqSequencial(int x){
        datos = new int[x];
        datosA = new int[x];
        datosD = new int[x];
    }
    /**
     * @param args the command line arguments
     */
    private int BusquedaDesorden( int dato) {
        int x = 0;
        boolean bandera = false;
        while ((x < datos.length) && (bandera == false)) {
            if (datos[x] == dato) {
                bandera = true;
            } else {
                x++;
            }
        }
        if (bandera) {
            System.out.println("Busqueda desordenada");
            System.out.println("El dato " + dato + " fue encontrado en la posición " + (x+1));
            System.out.println("El contador es "+x);
        }else{
             System.out.println("Busqueda desordenada");
            System.out.println("El dato " + dato + " no fue encontrado ");
            System.out.println("El contador es "+x);
        }
        return x;
    }
  
    public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
     public static void quickSortD (int[] numbers, int low, int high)
	{

		int i=low;
		int j=high;
		int temp;
		int middle=numbers[(low+high)/2];

		while (i<j)
		{
			while (numbers[i]>middle)
			{
				i++;
			}
			while (numbers[j]<middle)
			{
				j--;
			}
			if (j>=i)
			{
				temp=numbers[i];
				numbers[i]=numbers[j];
				numbers[j]=temp;
				i++;
				j--;
			}
		}


		if (low<j)
		{
			quickSortD(numbers, low, j);
		}
		if (i<high)
		{
			quickSortD(numbers, i, high);
		}
	}
    private int BusquedaOrdenA(int dato) {
        int x = 0;
        boolean bandera = false;
        quickSort(datosA,0,datosA.length-1);
        /*System.out.println("-----------------------");
         for (int i = 0; i < datosA.length; i++) {
            System.out.println(datosA[i]);
        }*/
        while ((x < datosA.length) && (bandera == false) && ( dato >= datosA[x])) {
            if (datosA[x] == dato) {
                bandera = true;
            } else {
                x++;
            }

        }
        if (bandera) {
            System.out.println("Busqueda ascendentemente");
            System.out.println("El dato " + dato + " fue encontrado en la posición " + (x+1));
             System.out.println("El contador es "+x);
        }else{
            System.out.println("Busqueda ascendentemente");
            System.out.println("El dato " + dato + " no fue encontrado ");
             System.out.println("El contador es "+x);
        }
        
        return x;
    }

    private int BusquedaOrdenD( int dato) {
        int x = 0;
        boolean bandera = false;
       
        quickSortD(datosD, 0, datosD.length-1);
        /* for (int i = 0; i < datosD.length; i++) {
            System.out.println(datosD[i]);
        }*/
        while ((x < datosD.length) && (bandera == false) && ( dato  <= datosD[x])) {
            if (datosD[x] == dato) {
                bandera = true;
            } else {
                x++;
            }

        }
        if (bandera) {
            System.out.println("Busqueda descendente");
            System.out.println("El dato " + dato + " Fue encontrado en la posición " + (x+1));
            System.out.println("El contador es "+x);
        }else{
            System.out.println("Busqueda descendente");
            System.out.println("El dato  " + dato + " no fue encontrado ");
            System.out.println("El contador es "+x);
        }
        return x;
    }
    
    private void generarNum(){
        Random a = new Random();
        for (int i = 0; i < datos.length; i++) {
            datos[i] = a.nextInt(datos.length+1);
            datosA[i] = datos[i];
            datosD[i] = datos[i];
            //System.out.println("Num:" +datos[i]);
        }
        
    }
    
    public void menu(){
               Scanner sc = new Scanner(System.in);
        System.out.println("Por favor escoja una opcion");
        System.out.println("1.- Buscar numero\n2.-Creditos");
        int opc = Integer.parseInt(sc.nextLine().replaceAll(" ", ""));
        switch(opc){
            case 1:
                 System.out.println("Por favor ingrese el dato a Buscar");
                int dato = Integer.parseInt(sc.nextLine().replaceAll(" ", ""));
                BusquedaOrdenA(dato);                
                BusquedaOrdenD(dato);
                BusquedaDesorden(dato);
                break;
            case 2:
                System.out.println("Universidad Politecnica de Chiapas");
                System.out.println("Andres Aguilar Cruz");
                System.out.println("Josseline Juliane Arreola Cruz");
                System.out.println("Javier de Jesus Flores Herrera");
                System.out.println("Hugo Sarmiento Toledo");
                
                break;
            default:
                System.out.println("OPCION INVALIDA");
                break;
        }
        System.out.println("Desea realizar otra accion? 1.Si 2. No");
        opc = Integer.parseInt(sc.nextLine().replaceAll(" ", "")); 
        switch(opc){
            case 1:
                menu();
                break;
            case 2:
                System.exit(0);
                break;
        }
        
    }
    public static void main(String[] args) {
        
        System.out.println("Bienvenido");
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese el numero de datos");
        int d = Integer.parseInt(sc.nextLine().replaceAll(" ", ""));;
        BusqSequencial obj = new BusqSequencial(d);
        
       obj.generarNum();
       obj.menu();
        
        
        
        
    }

}
