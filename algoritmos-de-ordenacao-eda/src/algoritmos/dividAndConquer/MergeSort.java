package algoritmos.dividAndConquer;

import sorting.AbstractSorting;
import util.Util;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex) {
			
			int med = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, med);
			sort(array, med + 1, rightIndex);
			merge(array, leftIndex, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int rightIndex) {
		
		T[] helper = Util.copyArray(array, leftIndex, rightIndex + 1);
		
		int i = 0;
		int med = (helper.length - 1) / 2;
		int j = med + 1;
		int pos = leftIndex;
		
		while (i <= med && j < helper.length) {
			
			if (helper[i].compareTo(helper[j]) <= 0) {
				
				array[pos] = helper[i];
				i++;
				
			} else {
				
				array[pos] = helper[j];
				j++;
			}
			
			pos++;
		}
		
		while (i <= med) {
			array[pos] = helper[i];
			i++;
			pos++;
		}
		
		while (j < helper.length) {
			
			array[pos] = helper[j];
			j++;
			pos++;
		}
	}
}
