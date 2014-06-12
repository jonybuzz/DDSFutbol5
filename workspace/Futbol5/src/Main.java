import org.joda.time.DateTime;

import fixture.BD;


public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {

		for(int i=0; i<10; i++)
			System.out.print(DateTime.now()+"\n");
	}

}
