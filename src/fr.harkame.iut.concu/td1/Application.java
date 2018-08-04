package td1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
	public static void main(String [] Args){
		ExecutorService es;
		ATache e4;
		System.out.println("Le debut");
		es = Executors.newFixedThreadPool(2);
		es.execute(new ATache(1));
		es.execute(new ATache(2));
		es.execute(new ATache(3));
		es.shutdown();
		System.out.println("La fin");
	}
}
