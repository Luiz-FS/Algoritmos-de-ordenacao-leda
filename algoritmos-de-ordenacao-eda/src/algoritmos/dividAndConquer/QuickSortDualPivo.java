package algoritmos.dividAndConquer;

import sorting.AbstractSorting;
import util.Util;

public class QuickSortDualPivo<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex) {
			
			int pivo1 = partition(array, leftIndex, rightIndex);
			int pivo2 = partition(array, pivo1 + 1, rightIndex);
			
			sort(array, leftIndex, pivo1 - 1);
			sort(array, pivo1 + 1, pivo2 - 1);
			sort(array, pivo2 + 1, rightIndex);
		}
	}
	
	private int partition(T[] array, int leftIndex, int rightIndex) {
		
		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}
		
		int i = leftIndex;
		int j = rightIndex;
		int pos_pivo = leftIndex;
		
		while (i < j) {
			
			while (array[i].compareTo(array[pos_pivo]) <= 0) {
				i++;
			}
			
			while (array[j].compareTo(array[pos_pivo]) > 0) {
				j--;
			}
			
			if(i < j) {
				Util.swap(array, i, j);
			}
		}
		
		Util.swap(array, pos_pivo, j);
		return j;
	}
}
