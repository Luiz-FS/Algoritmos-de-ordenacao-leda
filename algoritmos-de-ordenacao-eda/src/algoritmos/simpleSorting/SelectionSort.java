package algoritmos.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		int menor;
		
		for (int i = leftIndex; i < rightIndex; i++) {
			
			menor = i;
			
			for (int j = i + 1; j <= rightIndex; j++) {
				
				if (array[j].compareTo(array[menor]) < 0) {
					menor = j;
				}
			}
			
			if(menor != i) {
				
				Util.swap(array, menor, i);
			}
		}
	}

}
