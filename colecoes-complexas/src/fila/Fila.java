package fila;

import java.util.Scanner;

public class Fila {

	private int capacidade;
	private int[] fila;
	private int head;
	private int top;
	
	public Fila(int capacidade) {
		
		this.capacidade = capacidade;
		this.fila = new int[capacidade];
		this. head = -1;
		this.top = -1;
	}
	
	public boolean isEmpity() {
		
		if (this.head == -1 && this.top == -1) {
			return true;
			
		}else{ 
			return false;
		}
	}
	
	public boolean isFull() {
		
		if (this.head == this.top && this.top != -1 && this.head != -1) {
			return true;
			
		} else {
			return false;
		}
	}
	
	public int size() {
		
		int size = 0;
		
		if (isFull()) {
			size = this.capacidade;
			
		} else if (this.top > this.head) {
			
			size = this.top - this.head;
			
		} else if (this.top < this.head) {
			
			size = (this.capacidade - this.head) + this.top;
		}
		
		return size;
	}
	
	public boolean add(int value) throws Exception{
		
		if (isFull()) {
			throw new Exception("full");
		}
		
		if (isEmpity()) {
			
			this.head = 0;
			this.top = 0;
		}
		
		this.fila[this.top] = value;
		this.top = (this.top + 1) % this.capacidade;
		
		return true;
	}
	
	public int remove() throws Exception{
		
		if (isEmpity()) {
			throw new Exception("empity");
		}
		
		int value = this.fila[this.head];
		
		this.head = (this.head + 1) % this.capacidade;
		
		if (this.head == this.top) {
			
			this.head = -1;
			this.top = -1;
		}
		
		return value;
	}
	
	public int element() throws Exception{
		
		if (isEmpity()) {
			throw new Exception("empity");
		}
		
		return this.fila[this.head];
	}
	
	public String toString() {
		String saida = "";
		
		if (! isEmpity()) {
			
			int i = this.head;
				
			do {
				
				saida += this.fila[i] + " ";
				
				i = (i + 1) % this.capacidade;
				
			} while (i != this.top);
			
			saida = saida.substring(0, saida.length() - 1);
			
		} else {
			saida = "empty";
		}
		
		return saida;
	}
	
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int tamanho = in.nextInt();
		in.nextLine();
		
		Fila fila = new Fila(tamanho);
		
		String[] operacao = {};
		
		do {
			
			operacao = in.nextLine().split(" ");
			
			if (operacao[0].equals("print")) {
				
				System.out.println(fila);
				
			} else if (operacao[0].equals("element")) {
				
				try {
					System.out.println(fila.element());
					
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				
			} else if (operacao[0].equals("add")) {
				
				try {
					fila.add(Integer.parseInt(operacao[1]));
					
				} catch (Exception e) {
						
					System.out.println(e.getMessage());
				}
				
			} else if (operacao[0].equals("remove")) {
				
				try {
					fila.remove();
					
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
			}
			
		} while (! operacao[0].equals("end"));
	}
}
