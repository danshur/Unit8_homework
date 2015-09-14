import java.util.concurrent.ThreadFactory;

public class HelloThread implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] arg) {
		( new HelloThread()).start();
	}
	public void run() {
        System.out.println("Hello from a thread!");
    }
	private void start() {
		// TODO Auto-generated method stub
		
	}

}
