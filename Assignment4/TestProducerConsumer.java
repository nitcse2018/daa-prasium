import java.util.LinkedList;
import java.util.Queue;

public class TestProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		int num=2;
		ProducerConsumer buf= new ProducerConsumer(num);   // sets the size of the buffer 
		System.out.println("The size of the list is "+num);
		Thread producerThread = new Thread(new Runnable() {
			@Override
			public void run()
			{
				try
				{
					buf.produce();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		Thread consumerThread = new Thread(new Runnable() {
			@Override
			public void run()
			{
				try
				{
					buf.consume();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		producerThread.start();   // Starts producer thread
		consumerThread.start();   // Starts consumer thread
		
		producerThread.join();	 //goes into waiting state
		consumerThread.join();   //goes into waiting state
	}

	static class ProducerConsumer   // inner class
	{
		 Queue <Integer> list;   
		 int size;               
		 public ProducerConsumer(int size)  
		 {
			 this.list=new LinkedList<>(); 	// declares a queue linked list
			 this.size=size;				// size variable of list
		 }
		 
		 public void produce () throws InterruptedException 	// producer method 
		 {
			 while(true)
			 {
				 int val=(int)(Math.random()*(100));   // generates random value between 1-99
				 synchronized(this)           // synchronize block of thread
				 {
					 while(list.size()>=size)     // checks whether the list is full 
					 {
						 wait();               // if full then put the thread into waiting state indefinitely
					 }
					 list.add(val);             // if not full, then add the value into the list
					 System.out.println("Produced value is : "+val);
					 notify();               //wakes up any other thread associated with the object
					 Thread.sleep(1000);     //pause execution of thread for 1000ms
				 }
			 }
		 }

		 public void consume () throws InterruptedException   // consumer method
		 {
			 while(true)
			 {
				 synchronized(this)
				 {
					 while(list.size()==0) 			// checks whether the list is emptied
					 {
						 wait(); 			// if empty then goes into the waiting state
					 }
					int val=list.poll();		//retrieves the head element of the list
					 System.out.println("Consumed Value is : "+val);
					 
					 notify();
					 Thread.sleep(1000);
				 }
			 }
		 }
	}
	
	
	
}
