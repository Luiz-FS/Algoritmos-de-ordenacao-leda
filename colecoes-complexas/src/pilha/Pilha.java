package pilha;

import java.util.Scanner;

public class Pilha {
	
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
			throw new Exception("empity");
		}
		
		int valor = this.pilha[top];
		this.top -= 1;
		
		return valor;
	}
	
	public int peek() throws Exception{
		
		if (isEmpity()) {
			throw new Exception("empity");
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
		
		int tamanho = in.nextInt();
		in.nextLine();
		
		Pilha pilha = new Pilha(tamanho);
		
		String[] operacao = {};
		
		do {
			
			operacao = in.nextLine().split(" ");
			
			if (operacao[0].equals("print")) {
				
				System.out.println(pilha);
				
			} else if (operacao[0].equals("peek")) {
				
				try {
					System.out.println(pilha.peek());
					
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				
			} else if (operacao[0].equals("push")) {
				
				try {
					pilha.push(Integer.parseInt(operacao[1]));
					
				} catch (Exception e) {
						
					System.out.println(e.getMessage());
				}
				
			} else if (operacao[0].equals("pop")) {
				
				try {
					pilha.pop();
					
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
			}
			
		} while (! operacao[0].equals("end"));
	}
}
