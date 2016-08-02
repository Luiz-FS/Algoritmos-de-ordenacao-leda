package lista.encadeada;

public class DoubleLinkedList<T> {

	private Node<T> head;
	private int size;

	public DoubleLinkedList() {

		this.head = null;
		this.size = 0;
	}


	public boolean add(T value) {

		Node<T> newNode = new Node<>(value);

		if (isEmpty()) {
			this.head = newNode;

		} else {

			Node<T> aux = this.head;

			while (aux.getNext() != null) {
				aux = aux.getNext();
			}

			aux.setNext(newNode);
			newNode.setPrevios(aux);
		}

		this.size++;
		return true;
	}
	
	public boolean removeValue(T value) {
		
		if(isEmpty()){
			return false;
			
		} else if (this.head.getValue().equals(value)) {
			
			this.head = this.head.getNext();
			this.head.setPrevios(null);
			
		} else {
			
			Node<T> aux = this.head.getNext();
			
			while(aux != null && (! aux.getValue().equals(value))) {
				
				aux = aux.getNext();
			}
			
			if (aux == null) {
				return false;
				
			} else if (aux.getNext() == null){
				
				aux.getPrevios().setNext(aux.getNext());
				
			} else {
				
				aux.getPrevios().setNext(aux.getNext());
				aux.getNext().setPrevios(aux.getPrevios());
			}
		}
		
		this.size--;
		return true;
	}
	
	public T search(T value) {
		
		Node<T> aux = this.head;
		
		while (aux != null && (! aux.getValue().equals(value))) {
			
			aux = aux.getNext();
		}
		
		if (aux != null) {
			return aux.getValue();
		} else {
			return null;
		}
	}
	
	public boolean contains(T value) {
		
		Node<T> aux = this.head;
		
		while (aux != null && (! aux.getValue().equals(value))) {
			
			aux = aux.getNext();
		}
		
		if (aux != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {

		return this.head == null;
	}
	
	@Override
	public String toString() {
		
		String saida = "[";
		
		Node<T> aux = this.head;
		
		while (aux != null) {
			
			saida += aux.getValue() + " ";
			aux = aux.getNext();
		}
		
		saida = saida.trim() + "]";
		
		return saida;
	}
}


class Node<T> {

	private Node<T> previos;
	private T value;
	private Node<T> next;

	public Node(T value) {

		this.previos = null;
		this.value = value;
		this.next = null;
	}

	public Node<T> getPrevios() {
		return previos;
	}

	public void setPrevios(Node<T> previos) {
		this.previos = previos;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}