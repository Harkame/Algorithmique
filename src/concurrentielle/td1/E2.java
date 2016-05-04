package td1;

public final class E2 extends Thread{
	
	private final int id;
	private static int cpt = 1;
	
	public E2(){
		this.id = cpt++;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++){
			System.out.println("Je suis t" + this.id);
		}
	}
	
	public static void main(String [] Args) throws InterruptedException{
		E2 t1 = new E2();
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());
		t1.join(100);
		System.out.println(t1.getState());
		E2 t2 = new E2();
		t2.start();
		E2 t3 = new E2();
		t3.start();0
	}
}
