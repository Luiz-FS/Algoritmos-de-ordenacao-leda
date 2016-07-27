package algoritmos.dividAndConquer;

import sorting.AbstractSorting;
import util.Util;

public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex) {
			
			int pivo = particiona(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivo - 1);
			sort(array, pivo + 1, rightIndex);
		}
	}

	private int particiona(T[] array, int leftIndex, int rightIndex) {
		
		int i = leftIndex;
		int j = rightIndex;
		int pos_pivo = leftIndex;
		
		while (i < j) {
			
			while (i < rightIndex && array[i].compareTo(array[pos_pivo]) <= 0) {
				i++;
			}
			
			while (j > leftIndex && array[j].compareTo(array[pos_pivo]) > 0) {
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
