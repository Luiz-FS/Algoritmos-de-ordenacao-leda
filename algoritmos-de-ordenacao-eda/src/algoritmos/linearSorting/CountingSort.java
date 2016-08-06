package algoritmos.linearSorting;

import sorting.AbstractSorting;

public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array,int leftIndex, int rightIndex) {
		
		countingSort(array, leftIndex, rightIndex);
	}

	private void countingSort(Integer[] array, int leftIndex, int rightIndex) {
		
		if(array.length == 0)
			return;
		
		int maior = procuraMaior(array, leftIndex, rightIndex);
		
		int[] C = new int[maior + 1];
		int[] B = new int[array.length];
		
		for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i]] += 1;
		}
		
		for (int i = 1; i< C.length; i++) {
			C[i] += C[i-1];
		}
		
		for (int i = rightIndex; i >= leftIndex; i--) {
			
			B[C[array[i]]-1] = array[i];
			C[array[i]] -= 1;
		}
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			
			array[i] = B[i-leftIndex];
		}
	}
	
	private int procuraMaior(Integer[] array, int leftIndex, int rightIndex) {
		
		int maior = leftIndex;
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			
			if(array[i].compareTo(array[maior]) > 0) {
				
				maior = i;
			}
		}
		
		return array[maior];
	}
}

