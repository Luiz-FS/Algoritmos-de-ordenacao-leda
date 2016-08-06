package algoritmos.variationsSorting.selectionSort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

public class OddEvenSelectionSort<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		selectionParEImpar(array, leftIndex, rightIndex);
		selectionParEImpar(array, leftIndex + 1, rightIndex);
		merge(array, leftIndex, rightIndex);
	}
	
	
	private void selectionParEImpar(T[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex <= rightIndex) {
			
			int menor = leftIndex;
			menor = procuraMenor(array, leftIndex, menor, rightIndex);
			
			if (menor != leftIndex) {
				Util.swap(array, menor, leftIndex);
			}
			
			selectionParEImpar(array, leftIndex + 2, rightIndex);
		}
	}
	
	private int procuraMenor(T[] array, int leftIndex, int menor, int rightIndex) {
		
		if (leftIndex <= rightIndex) {
			
			if (array[leftIndex].compareTo(array[menor]) < 0) {
				menor = leftIndex;
			}
			
			menor = procuraMenor(array, leftIndex+2, menor, rightIndex);
		}
		
		return menor;
	}
	
	private void merge(T[] array, int leftIndex, int rightIndex) {
		
		T[] helper = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
		
		int i = 0;
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
