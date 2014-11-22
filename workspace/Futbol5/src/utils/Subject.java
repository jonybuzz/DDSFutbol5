package utils;

public interface Subject<T> {

	public void addObserver(T ob);
	public void removeObserver(T ob);
	public void notifyObservers();
}
