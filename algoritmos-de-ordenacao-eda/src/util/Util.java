package util;

import java.util.Arrays;

public class Util {
	
	public static <T> void swap(T[] array, int i, int j){
		
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
	public static <T> T[] copyArray(T[] array, int leftIndex, int rightIndex) {
		
		return Arrays.copyOfRange(array, leftIndex, rightIndex);
	}
}
