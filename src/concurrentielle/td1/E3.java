package td1;

public final class E3 implements Runnable {

	private final int id;

	public E3(int p_id) {
		this.id = p_id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("Je suis t" + this.id);

	}

	public static void main(String[] Args) throws InterruptedException {
		Thread t1 = new Thread(new E3(1));
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());
		t1.join(100);
		System.out.println(t1.getState());
	}
}
