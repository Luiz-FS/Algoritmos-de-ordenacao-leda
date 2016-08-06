package algoritmos.variationsSorting.bubbleSort;

import sorting.AbstractSorting;
import util.Util;

public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array,int leftIndex, int rightIndex) {

		combSort(array, leftIndex, rightIndex);
	}

	private void combSort(T[] array, int leftIndex, int rightIndex) {

		int gap = rightIndex - leftIndex;

		boolean swaped = true;

		while(gap != 1 || swaped) {

			swaped = false;
			gap = newGap(gap);

			for(int i = leftIndex; i <= rightIndex - gap; i++) {

				int j = i + gap;

				if (array[i] == null) {
					Util.swap(array, i, j);
				}

				if (array[j] != null) {

					if(array[i].compareTo(array[j]) > 0) {
						Util.swap(array, i, j);
						swaped = true;
					}
				}
			}
		}
	}

	private int newGap(int gap) {

		gap = (gap * 10) / 13;

		if(gap == 9 || gap == 10)
			gap = 11;

		if(gap < 1)
			gap = 1;

		return gap;
	}

}
