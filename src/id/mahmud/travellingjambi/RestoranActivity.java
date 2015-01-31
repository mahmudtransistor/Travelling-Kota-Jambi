package id.mahmud.travellingjambi;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextThemeWrapper;

public class RestoranActivity extends FragmentActivity {
	
	private GoogleMap maps;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restoran);
		
		initMap();
		
		
	}

	private void initMap(){
		maps = ((MapFragment)getFragmentManager().findFragmentById(R.id.maprestoran)).getMap();
		
		//Deklarasi Restoran
		LatLng anekarasa = new LatLng(-1.602903,103.5995);
		MarkerOptions markeanekarasa = new MarkerOptions();
		markeanekarasa.position(anekarasa);
		markeanekarasa.title("Aneka Rasa Rumah Makan");
		markeanekarasa.snippet("JL. Mpu Gandring, 75-A, Jambi");
		markeanekarasa.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
		maps.addMarker(markeanekarasa);
		
		LatLng pagisore = new LatLng(-1.596663,103.615975);
		MarkerOptions markepagisore = new MarkerOptions();
		markepagisore.position(pagisore);
		markepagisore.title("Pagi Sore");
		markepagisore.snippet("JL. Kyai Haji Wahid Hasyim, No. 25");
		markepagisore.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
		maps.addMarker(markepagisore);
		
		LatLng sederhana = new LatLng(-1.404062,102.9856215);
		MarkerOptions markesederhana = new MarkerOptions();
		markesederhana.position(sederhana);
		markesederhana.title("Restoran Sederhana");
		markesederhana.snippet("JL. Profesor Doktor Soemantri Bodjonegoro, No. 60 Jambi");
		markesederhana.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
		maps.addMarker(markesederhana);
		
		LatLng murniarea = new LatLng(-1.706263,103.267756);
		MarkerOptions markemurniarea = new MarkerOptions();
		markemurniarea.position(murniarea);
		markemurniarea.title("Murni Area");
		markemurniarea.snippet("Pasar Terminal Rawasari, JL. Sultan Thaha, Pasar Jambi");
		markemurniarea.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
		maps.addMarker(markemurniarea);
		
		LatLng pujasera = new LatLng(-1.621683,103.619582);
		MarkerOptions markepujasera = new MarkerOptions();
		markepujasera.position(pujasera);
		markepujasera.title("Puja Sera");
		markepujasera.snippet("JL. Hayam Wuruk, Jelutung");
		markepujasera.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
		maps.addMarker(markepujasera);
		
		maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		maps.getUiSettings().setCompassEnabled(true);
        
		maps.getUiSettings().setZoomControlsEnabled(true);
        
		maps.getUiSettings().setMyLocationButtonEnabled(true);
        
		maps.setMyLocationEnabled(true);
		
		maps.moveCamera(CameraUpdateFactory.newLatLngZoom(anekarasa, 9));
		maps.animateCamera(CameraUpdateFactory.zoomTo(9),1000,null);
		
        maps.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
			
			@Override
			public void onInfoWindowClick(Marker arg0) {
				// TODO Auto-generated method stub
			AlertDialog.Builder trans = new AlertDialog.Builder(new ContextThemeWrapper(RestoranActivity.this, R.style.AlertDialogCustom));
			trans.setTitle(arg0.getTitle()).setCancelable(false);
			trans.setIcon(android.R.drawable.ic_menu_info_details);
			trans.setMessage(arg0.getPosition() + "\n\n" +
					         arg0.getSnippet());
			trans.setPositiveButton("Cancel",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});
			trans.show();
				
			}

		});
	}
	
	
}
