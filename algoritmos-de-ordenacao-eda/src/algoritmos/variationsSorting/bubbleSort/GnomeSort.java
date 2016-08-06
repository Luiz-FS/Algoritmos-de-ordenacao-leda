package algoritmos.variationsSorting.bubbleSort;

import sorting.AbstractSorting;
import util.Util;

public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	public void sort(T[] array,int leftIndex, int rightIndex){

		int i = leftIndex + 1;
		int j = leftIndex + 2;

		while (i <= rightIndex) {

			if (array[i - 1] == null) {

				Util.swap(array, i, i-1);
				i -= 1;

				if (i == leftIndex)
					i = leftIndex + 1;
			}

			if (array[i] == null) {
				i = j;
				j += 1;


			} else { 

				if (array[i-1].compareTo(array[i]) <= 0) {

					i = j;
					j += 1;

				} else {

					Util.swap(array, i, i-1);
					i -= 1;

					if (i == leftIndex)
						i = leftIndex + 1;
				}
			}
		}
	}

}
