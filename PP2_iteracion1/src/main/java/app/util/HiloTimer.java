package app.util;

import java.util.Timer;

public class HiloTimer extends Thread{
	//private float tiempo = 1;
	
	public HiloTimer(){
		super();
	}
	
	public void run()
	{
		Timer time = new Timer ();
		try {
			time.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Thread.sleep(1000);
		//for
	}
}
