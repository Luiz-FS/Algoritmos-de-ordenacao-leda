package algoritmos.variationsSorting.mergeSort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

public class HybridMergeSort<T extends Comparable<T>> extends AbstractSorting<T>{

	public static final int SIZE_LIMIT = 4;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		hybridMergeSort(array, leftIndex, rightIndex);
	}

	private void hybridMergeSort(T[] array, int leftIndex, int rightIndex) {

		if ((rightIndex - leftIndex <= SIZE_LIMIT)) {
			
			insertionSort(array, leftIndex, rightIndex);
			
		} else {
			
			int med = (leftIndex + rightIndex) / 2;
			hybridMergeSort(array, leftIndex, med);
			hybridMergeSort(array, med + 1, rightIndex);
			merge(array, leftIndex, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int rightIndex) {
		
		T[] helper = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);

		int i = 0;
		int med = (helper.length - 1) / 2;
		int j = med + 1;
		int pos = leftIndex;

		while (i <= med && j < helper.length) {

			if (helper[i].compareTo(helper[j]) <= 0) {

				array[pos] = helper[i];
				i += 1;

			} else {

				array[pos] = helper[j];
				j += 1;
			}

			pos += 1;
		}

		while (i <= med) {
			array[pos] = helper[i];
			i += 1;
			pos += 1;
		}

		while (j < helper.length) {
			array[pos] = helper[j];
			j += 1;
			pos += 1;
		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
	
		insertion(array, leftIndex, leftIndex + 1, rightIndex);
	}
	
	private void insertion(T[] array, int leftIndex, int atualIndex, int rightIndex) {
		
		if (atualIndex <= rightIndex) {

			int j = atualIndex;

			while (j > leftIndex && array[j].compareTo(array[j-1]) < 0) {
				Util.swap(array, j, j-1);
				j--;
			}

			insertion(array, leftIndex, atualIndex + 1, rightIndex);	
		}
	}

}
