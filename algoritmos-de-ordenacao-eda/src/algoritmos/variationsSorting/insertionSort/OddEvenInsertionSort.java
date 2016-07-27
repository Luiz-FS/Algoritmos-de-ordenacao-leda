package algoritmos.variationsSorting.insertionSort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

public class OddEvenInsertionSort<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		insertionSortParEImpar(array, leftIndex, leftIndex + 2, rightIndex);
		insertionSortParEImpar(array, leftIndex + 1, leftIndex + 3, rightIndex);
		merge(array, leftIndex, rightIndex);
	}

	private void insertionSortParEImpar(T[] array, int leftIndex, int current, int rightIndex) {
		
		if (current <= rightIndex) {
			
			insertion(array, leftIndex, current);
			insertionSortParEImpar(array, leftIndex, current + 2, rightIndex);
		}
	}
	
	private void insertion(T[] array, int leftIndex, int current){
		
		if(current <= leftIndex)
				return;
		
		if (array[current].compareTo(array[current - 2]) < 0) {
			
			Util.swap(array, current, current - 2);
			insertion(array, leftIndex,  current - 2);
		}
	}
	
	private void merge(T[] array, int leftIndex, int rightIndex) {
		
		T[] helper = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
		
		int i = leftIndex;
		int j = i + 1;
		int pos = leftIndex;
		
		while (i < helper.length && j < helper.length) {
			
			if (helper[i].compareTo(helper[j]) <= 0) {
				
				array[pos] = helper[i];
				i += 2;
				
			} else {
				
				array[pos] = helper[j];
				j += 2;
			}
			
			pos++;
		}
		
		while (i < helper.length) {
			
			array[pos] = helper[i];
			i += 2;
			pos++;
		}
		
		while (j < helper.length) {
			
			array[pos] = helper[j];
			j += 2;
			pos++;
		}
	}
}
