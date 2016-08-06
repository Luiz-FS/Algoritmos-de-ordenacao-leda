package algoritmos.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		int j;
		
		for(int i = leftIndex; i < rightIndex; i++) {
			
			j = i + 1;
			
			while (j > leftIndex && array[j].compareTo(array[j-1]) < 0) {
				
				Util.swap(array, j, j-1);
				j--;
			}
		}
	}
}
