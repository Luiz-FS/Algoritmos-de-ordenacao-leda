package algoritmos.variationsSorting.countSort;

import sorting.AbstractSorting;

public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array,int leftIndex, int rightIndex) {

		extendedCountingSort(array, leftIndex, rightIndex);
	}

	private void extendedCountingSort(Integer[] array, int leftIndex, int rightIndex) {

		if(array.length == 0)
			return;

		int maior = procuraMaior(array, leftIndex, rightIndex);
		int menor = procuraMenor(array, leftIndex, rightIndex);

		int[] C = new int[maior - menor + 1];
		int[] B = new int[(rightIndex - leftIndex) + 1];

		for (int i = leftIndex; i <= rightIndex; i++) {

				C[array[i]-menor] += 1;
		}

		for (int i = 1; i< C.length; i++) {
			C[i] += C[i-1];
		}

		for (int i = rightIndex; i >= leftIndex; i--) {

				B[C[array[i]-menor]-1] = array[i];
				C[array[i]-menor] -= 1;
		}

		for(int i = leftIndex; i <= rightIndex; i++) {

			array[i] = B[i - leftIndex];
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

	private int procuraMenor(Integer[] array, int leftIndex, int rightIndex) {

		int menor = leftIndex;

		for(int i = leftIndex; i <= rightIndex; i++) {
			
			if(array[i] != null && array[i].compareTo(array[menor]) < 0) {

				menor = i;
			}
		}

		return array[menor];
	}

}
