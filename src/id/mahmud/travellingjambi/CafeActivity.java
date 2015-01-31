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

public class CafeActivity extends Activity {
	private GoogleMap maps;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cafe);
	initmaps();
	}
	private void initmaps(){
		maps = ((MapFragment)getFragmentManager().findFragmentById(R.id.mapcafe)).getMap();
		//Deklarasi Koordinat Cafe
		
		LatLng cafe1 = new LatLng(-1.6203,103.6076645);
		MarkerOptions markecafe1 = new MarkerOptions();
		markecafe1.position(cafe1);
		markecafe1.title("Excelso WTC");
		markecafe1.snippet("Jalan Sultan Thaha Kota Jambi, Jambi");
		markecafe1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
		maps.addMarker(markecafe1);
		
		LatLng cafe2 = new LatLng(-1.6201055,103.6076645);
		MarkerOptions markecafe2 = new MarkerOptions();
		markecafe2.position(cafe2);
		markecafe2.title("Black Canyon Coffee Jambi Town Square");
		markecafe2.snippet("Jl. A. Bakaruddin No. 88 Sipin, Jambi Town Square Lt. Basement Jambi");
		markecafe2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
		maps.addMarker(markecafe2);
		
		LatLng cafe3 = new LatLng(-1.608351, 103.595133);
		MarkerOptions markecafe3 = new MarkerOptions();
		markecafe3.position(cafe3);
		markecafe3.title("CAFE LAMPU JAMBI");
		markecafe3.snippet("Jln. Sumantri Brojonegoro Lampu merah Simp.IV sipin ( Deretan Sophie Martin sipin ) jambi");
		markecafe3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
		maps.addMarker(markecafe3);
		
		LatLng cafe4 = new LatLng(-1.6201055,103.6076645);
		MarkerOptions markecafe4 = new MarkerOptions();
		markecafe4.position(cafe4);
		markecafe4.title("KFC Wiltop Trade Center Jambi");
		markecafe4.snippet("Wiltop Trade Center, Komplek Willtop Batanghari Jl. Sultan Saha, Kel. Beringin, Kec. Pasar");
		markecafe4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
		maps.addMarker(markecafe4);
		
		LatLng cafe5 = new LatLng(-1.627410, 103.627832);
		MarkerOptions markecafe5 = new MarkerOptions();
		markecafe5.position(cafe5);
		markecafe5.title("Aroma Kopithua");
		markecafe5.snippet("Jl. H. Adam Malik, Jambi , Beringin V , Ruko No.3 - Jambi");
		markecafe5.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
		maps.addMarker(markecafe5);
		
		LatLng cafe6 = new LatLng(-1.651947, 103.623884);
		MarkerOptions markecafe6 = new MarkerOptions();
		markecafe6.position(cafe6);
		markecafe6.title("Kedai Kopi Espresso Bar Jambi");
		markecafe6.snippet("JL.Sumatera, Puncak Jelutung, Kotabaru");
		markecafe6.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
		maps.addMarker(markecafe6);
		
		LatLng cafe7 = new LatLng(-1.5894234,103.6147428);
		MarkerOptions markecafe7 = new MarkerOptions();
		markecafe7.position(cafe7);
		markecafe7.title("Coffee Time");
		markecafe7.snippet("Jl. Sultan Thaha no. 17 WTC Batang Hari lt.3");
		markecafe7.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		maps.addMarker(markecafe7);
		
		maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
		maps.getUiSettings().setCompassEnabled(true);
		
		maps.getUiSettings().setZoomControlsEnabled(true);
		
		maps.getUiSettings().setMyLocationButtonEnabled(true);
		
		maps.setMyLocationEnabled(true);
		//Deklarasi kamera google maps
		maps.moveCamera(CameraUpdateFactory.newLatLngZoom(cafe1, 9));
		maps.animateCamera(CameraUpdateFactory.zoomTo(9),1000,null);
		
	    maps.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
				
				@Override
				public void onInfoWindowClick(Marker arg0) {
					// TODO Auto-generated method stub
				AlertDialog.Builder trans = new AlertDialog.Builder(new ContextThemeWrapper(CafeActivity.this, R.style.AlertDialogCustom));
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
