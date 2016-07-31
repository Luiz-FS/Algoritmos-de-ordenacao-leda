package parenteses;

import java.util.Scanner;

class Pilha {
	
	private int capacidade;
	private int[] pilha;
	private int top;
	
	public Pilha(int capacidade) {
		
		this.capacidade = capacidade;
		this.pilha = new int[capacidade];
		this.top = -1;
		
	}
	
	public boolean isEmpity() {
		return this.top == -1;
	}
	
	public boolean isFull() {
		return this.top == this.capacidade - 1;
	}
	
	public int size() {
		return this.top + 1;
	}
	
	public boolean push(int valor) throws Exception{
		
		if (isFull()) {
			
			throw new Exception("full");
		}
		
		this.top += 1;
		this.pilha[top] = valor;
		
		return true;
	}
	
	public int pop() throws Exception{
		
		if (isEmpity()) {
			throw new Exception("empty");
		}
		
		int valor = this.pilha[top];
		this.top -= 1;
		
		return valor;
	}
	
	public int peek() throws Exception{
		
		if (isEmpity()) {
			throw new Exception("empty");
		}

		return this.pilha[top];
	}
	
	public String toString() {
		String saida = "";
		
		if (! isEmpity()) {
			
			for (int i = 0; i <= this.top; i++) {
				
				saida += pilha[i] + " ";
			}
			
			saida = saida.substring(0, saida.length() - 1);
			
		} else {
			saida = "empty";
		}
		
		return saida;
	}
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String sequencia = in.nextLine();
		
		Pilha pilha = new Pilha(sequencia.length());
		
		
		verificaSequencia(sequencia, pilha);
	}

	private static void verificaSequencia(String sequencia, Pilha pilha) {
		for (int i = 0; i < sequencia.length(); i++) {
			
			if (sequencia.charAt(i) == '(') {
				
				try {
					pilha.push(1);
				} catch (Exception e) {
				}
				
			} else {
				
				try {
					
					pilha.pop();
					
				} catch (Exception e) {
					
					System.out.println("n");
					return;
				}
			}
		}
		
		if (pilha.isEmpity()) {
			
			System.out.println("s");
			
		} else {
			System.out.println("n");
		}
	}
}
