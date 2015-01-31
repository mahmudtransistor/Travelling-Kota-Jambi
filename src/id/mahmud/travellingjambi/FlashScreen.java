package id.mahmud.travellingjambi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class FlashScreen extends Activity {
	
	protected boolean active = true;
	protected int falshtime = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flash_screen);
		
		Thread FlashScreen = new Thread(){
			public void run(){
				try{
					int waited = 0;
					while(active && (waited<falshtime)){
						sleep(250);
						if(active){
							waited +=250;
							
						}
					}
				}catch (InterruptedException e){
					
				}finally{
					finish();
					Intent trans = new Intent(getApplicationContext(),MenuUtama.class);
					startActivity(trans);
				}
			}
		};
		FlashScreen.start();
	}
@Override
public boolean onTouchEvent(MotionEvent event) {
	// TODO Auto-generated method stub
	if(event.getAction() == MotionEvent.ACTION_DOWN){
		active = false;
	}
	return super.onTouchEvent(event);
}
	
}
