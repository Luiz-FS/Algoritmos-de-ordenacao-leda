package testes;

import java.util.Date;

import algoritmos.variationsSorting.selectionSort.OddEvenSelectionSort;
import sorting.AbstractSorting;
import util.RandomIntegerList;

public class Main {
	
	private static <T> void imprime(T[] array) {

		String print = "";
		for(T elem : array) {

			print += elem.toString() + " ";
		}

		System.out.println(print);
	}

	private static long executingSortAlgoritm(AbstractSorting<Integer> sort, int tamanho) {

		Integer[] array = RandomIntegerList.randomArray(tamanho);
		imprime(array);
		long startTime = new Date().getTime();
		sort.sort(array);
		long endTime = new Date().getTime();
		imprime(array);
		long diference = endTime - startTime;

		return diference;
	}

	public static void main(String[] args) {
		
		executingSortAlgoritm(new OddEvenSelectionSort<>(), 10);
		
		/*
		String saida = "alg time sample" + "\n";

		for(int i = 20000; i <= 40000; i += 1000){
			
			saida += "selection " + executingSortAlgoritm(new SelectionSort<>(), i) + " " + i + "\n";
			saida += "insertion " + executingSortAlgoritm(new InsertionSort<>(), i) + " " + i + "\n";
			saida += "quick " + executingSortAlgoritm(new QuickSort<>(), i) + " " + i + "\n";
			saida += "merge " + executingSortAlgoritm(new MergeSort<>(), i) + " " + i + "\n";
			saida += "hybrid " + executingSortAlgoritm(new HybridMergeSort<>(), i) + " " + i + "\n";
			saida += "counting " + executingSortAlgoritm(new CountingSort(), i) + " " + i + "\n";
			saida += "extended " + executingSortAlgoritm(new ExtendedCountingSort(), i) + " " + i + "\n";
		}
		
		System.out.println(saida);
		File arquivo = new File("sort-dividAndConquer-comparator2.data");
		
		try {
			FileWriter gravar = new FileWriter(arquivo);
			gravar.write(saida);
			gravar.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
