package negocio;

import java.util.LinkedList;

public class LinkedListConTope<E> extends LinkedList<E> {

	private static final long serialVersionUID = 1L;
	private int max;
	
	public LinkedListConTope(int max){
		super();
		this.max = max;
	}

	public boolean agregar(E j) throws Exception{
		
		if (this.size() == max)
			throw new Exception("Lista llena");
		else
			return add(j);

	}
}