package util;

import java.util.Random;

public final class RandomIntegerList {

	public static int randomInteger(int random){

		//note a single Random object is reused here
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(random);
		return randomInt;
	}

	public static Integer[] randomArray(int tamanho) {

		Integer[] randomArray = new Integer[tamanho];

		for (int i = 0; i < tamanho; i++) {

			randomArray[i] = randomInteger(20000);

		}
		
		return randomArray;
	}
}
