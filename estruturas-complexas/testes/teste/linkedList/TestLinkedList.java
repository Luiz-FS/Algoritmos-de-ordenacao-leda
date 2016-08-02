package teste.linkedList;

import lista.encadeada.DoubleLinkedList;

public class TestLinkedList {
	
	public static void main(String[] args) {
		
		
		DoubleLinkedList<Integer> listaEncadeada = new DoubleLinkedList<>();
		
		System.out.println(listaEncadeada.size());
		System.out.println(listaEncadeada);
		
		listaEncadeada.add(new Integer(2));
		listaEncadeada.add(new Integer(5));
		listaEncadeada.add(new Integer(3));
		listaEncadeada.add(new Integer(8));
		listaEncadeada.add(new Integer(6));
		listaEncadeada.add(new Integer(9));
		listaEncadeada.add(new Integer(10));
		listaEncadeada.add(new Integer(4));
		listaEncadeada.add(new Integer(7));
		listaEncadeada.add(new Integer(1));
		listaEncadeada.add(new Integer(0));
		listaEncadeada.add(new Integer(11));
		listaEncadeada.add(new Integer(-1));
		
		
		System.out.println(listaEncadeada.size());
		System.out.println(listaEncadeada);
		
		listaEncadeada.removeValue(2);
		System.out.println(listaEncadeada.size());
		System.out.println(listaEncadeada);
		
		listaEncadeada.removeValue(-1);
		System.out.println(listaEncadeada.size());
		System.out.println(listaEncadeada);
		
		listaEncadeada.removeValue(10);
		System.out.println(listaEncadeada.size());
		System.out.println(listaEncadeada);
		
		
		System.out.println(listaEncadeada.search(4));
		System.out.println(listaEncadeada.search(-1));
	}
}
