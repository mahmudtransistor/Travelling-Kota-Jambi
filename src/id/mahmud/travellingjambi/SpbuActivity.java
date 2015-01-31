package id.mahmud.travellingjambi;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;

public class SpbuActivity extends Activity {
	private GoogleMap maps;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spbu);
		
		initMaps();
	}
	private void initMaps(){
		maps = ((MapFragment)getFragmentManager().findFragmentById(R.id.mapspbu)).getMap();
		//Deklarasi Restoran
		LatLng sbbu1 = new LatLng(-1.62323,103.55159);
		MarkerOptions markesbbu1 = new MarkerOptions();
		markesbbu1.position(sbbu1);
		markesbbu1.title("ATM BNI SPBU SIMPANG RIMBO");
		markesbbu1.snippet("Jambi 36124");
		markesbbu1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
		maps.addMarker(markesbbu1);
		
		LatLng sbbu2 = new LatLng(-1.611216,103.631226);
		MarkerOptions markesbbu2 = new MarkerOptions();
		markesbbu2.position(sbbu2);
		markesbbu2.title("SPBU Persijam");
		markesbbu2.snippet("Jambi 36124");
		markesbbu2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
		maps.addMarker(markesbbu2);
		
		LatLng sbbu3 = new LatLng(-1.629082,103.625566);
		MarkerOptions markesbbu3 = new MarkerOptions();
		markesbbu3.position(sbbu3);
		markesbbu3.title("SPBU Talang Bakung");
		markesbbu3.snippet("Jambi 36124");
		markesbbu3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
		maps.addMarker(markesbbu3);
		
		LatLng sbbu4 = new LatLng(-1.629082,103.625566);
		MarkerOptions markesbbu4 = new MarkerOptions();
		markesbbu4.position(sbbu4);
		markesbbu4.title("SPBU Kebun Handil");
		markesbbu4.snippet("Jl. DI Panjaitan, Kec Jelutung Jambi 36137");
		markesbbu4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		maps.addMarker(markesbbu4);
		
		LatLng sbbu5 = new LatLng(-1.6258665,103.6213188);
		MarkerOptions markesbbu5 = new MarkerOptions();
		markesbbu5.position(sbbu5);
		markesbbu5.title("SPBU");
		markesbbu5.snippet("JL. Gajah Mada, Simpang Kawat, Jelutung");
		markesbbu5.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
		maps.addMarker(markesbbu5);
		
		LatLng sbbu6 = new LatLng(-1.6258665,103.6213188);
		MarkerOptions markesbbu6 = new MarkerOptions();
		markesbbu6.position(sbbu6);
		markesbbu6.title("SPBU 24-36111");
		markesbbu6.snippet("JL. Kol M Taher, Rt. 019/09");
		markesbbu6.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
		maps.addMarker(markesbbu6);
		
		
		maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		maps.getUiSettings().setCompassEnabled(true);
        
		maps.getUiSettings().setZoomControlsEnabled(true);
        
		maps.getUiSettings().setMyLocationButtonEnabled(true);
        
		maps.setMyLocationEnabled(true);
		
		maps.moveCamera(CameraUpdateFactory.newLatLngZoom(sbbu1, 9));
		maps.animateCamera(CameraUpdateFactory.zoomTo(9),1000,null);
		
       maps.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
			
			@Override
			public void onInfoWindowClick(Marker arg0) {
				// TODO Auto-generated method stub
			AlertDialog.Builder trans = new AlertDialog.Builder(new ContextThemeWrapper(SpbuActivity.this, R.style.AlertDialogCustom));
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
