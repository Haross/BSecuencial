/*Universidad Politécnica de Chiapas
Estructura de Datos
Ingeniería en Desarrollo de Software
4° A
Josseline Juliane Arreola Cruz  | Matricula: 143471
Hugo Sarmiento Toledo 		  	| Matricula: 143359
Tuxtla Gutierréz, A 21 de Octubre del 2015
	*/

package busqSecuencial;
import java.util.*;

public class Sorts  {

	public static <T extends Comparable<T>> ArrayList<T> selectionSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		for (int i = 0; i < listaOrdenada.size() - 1; i++){
           T menor= listaOrdenada.get(i);
           int pos=i;
           for (int j= i+1;j< listaOrdenada.size();j++){
        		if (listaOrdenada.get(j).compareTo(menor)<0){
        			menor=listaOrdenada.get(j);
        			pos=j;
        		}
           }
           listaOrdenada.set(pos,listaOrdenada.get(i));
           listaOrdenada.set(i,menor);

        }
        
		return listaOrdenada;
	}

	public static <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		T aux;
        for (int i = 1; i < listaOrdenada.size(); i++) {
            aux=listaOrdenada.get(i);
            for (int j = i-1; j >=0 && listaOrdenada.get(j).compareTo(aux)>0; j--) {
            	listaOrdenada.set(j+1,listaOrdenada.get(j));
            	listaOrdenada.set(j,aux);
            }  
        }
		return listaOrdenada;

	}

	public static <T extends Comparable<T>> ArrayList<T> quickSort(ArrayList<T> list, int left, int right){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		int index = partition(list, left, right);
   		 if (left < index - 1)
      		quickSort(list, left, index - 1);
    	if (index < right)
      		quickSort(list, index, right);

		return list;
	}

	public static <T extends Comparable<T>> int partition(ArrayList<T> list, int left, int right){
		int i = left, j = right;
    	T tmp;
    	T pivot = list.get((left + right) / 2);
    	while (i <= j) {
      		while (list.get(i).compareTo(pivot) < 0)
        		i++;
      		while (list.get(j).compareTo(pivot) > 0)
       			j--;
      		if (i <= j) {
        		tmp = list.get(i);
        		list.set(i,list.get(j));
        		list.set(j, tmp);
        		i++;
        		j--;
      		}
    	};
    return i;
	}

	public static <T extends Comparable<T>> ArrayList<T> heapSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		odernacion(listaOrdenada);
		return listaOrdenada;
	}

	public static <T extends Comparable<T>> void odernacion(ArrayList<T> list){
		
        final int N = list.size();
        for(int nodo = N/2; nodo>=0; nodo--) 
        	hacer(list, nodo, N-1);
        for(int nodo = N-1; nodo>=0; nodo--) {
            T tmp =list.get(0);
            list.set(0, list.get(nodo));
            list.set(nodo,tmp);
            hacer(list, 0, nodo-1);
        }
    }

    public static <T extends Comparable<T>> void hacer(ArrayList<T> list, int nodo, int fin){
        int izq = 2*nodo+1;
        int der = izq+1;
        int may;
        if(izq>fin) return;
        if(der>fin) may=izq;
        else may= list.get(izq).compareTo(list.get(der))>0?izq:der;
        if(list.get(nodo).compareTo(list.get(may))<0) {
            T tmp = list.get(nodo);
            list.set(nodo, list.get(may));
            list.set(may, tmp);
            hacer(list, may, fin);
        }
	}
		
	public static <T extends Comparable<T>> ArrayList<T> mergeSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		listaOrdenada = list;
		if(listaOrdenada.size() <= 1){
			return listaOrdenada;
		}else{
			int medio = listaOrdenada.size()/2;
			ArrayList<T> tempA = new ArrayList<T>();
			ArrayList<T> tempB = new ArrayList<T>();
			int index=0;
			for (int i=0;i<listaOrdenada.size() ; i++ ) {
				if(i<medio){
					tempA.add(listaOrdenada.get(i));
				}else{
					tempB.add(listaOrdenada.get(i));
				}
			}
			ArrayList<T> izq = mergeSort(tempA);
			ArrayList<T> der = mergeSort(tempB);
			return merge(izq, der);
		}
	}

	public static <T extends Comparable<T>> ArrayList<T> merge(ArrayList<T> izq, ArrayList<T> der){
		int i = 0; //indice izq
		int j = 0; //indece der
		int index =0;
		ArrayList<T> resultado = new ArrayList<T>();
		while(i<izq.size() && j<der.size()){ 
			if(izq.get(i).compareTo(der.get(j)) < 0){
				resultado.add(izq.get(i++));
			}else{
				resultado.add(der.get(j++));
			}
		}
		while( i<izq.size()){    // Copia el resto de la mitad izq
            resultado.add(izq.get(i++));   
        }

        while( j<der.size()){ //Copia el resto de la mitad der
            resultado.add(der.get(j++));
        }

        return resultado;
	}
}