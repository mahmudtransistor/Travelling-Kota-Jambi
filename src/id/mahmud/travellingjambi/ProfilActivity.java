package id.mahmud.travellingjambi;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class ProfilActivity extends Activity {
	ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profil);
		//Deklarasi Warna ActionBar
		actionBar = getActionBar();
	    ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#9e9e9e"));
	    actionBar.setBackgroundDrawable(colorDrawable);
	}
}
