package sharedbuffertest;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class SharedBufferTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executorService=Executors.newCachedThreadPool();
		Buffer sharedLocation=new UnsynchronizedBuffer();
		System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
		System.out.println("---------\t\t--------\t----------------\t-----------%n%n");
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);

	}

}
