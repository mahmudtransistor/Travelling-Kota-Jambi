package id.mahmud.travellingjambi;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextThemeWrapper;


public class HotelActivity extends FragmentActivity {
    private GoogleMap maps;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hotel);
		
		maps = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
		//Deklarasi Hotel
		LatLng abadi = new LatLng(-1.595644, 103.613177);
		MarkerOptions markeabadi = new MarkerOptions();
		markeabadi.position(abadi);
		markeabadi.title("Abadi Suite Hotel & Tower");
		markeabadi.snippet("Jl. Prof. HMO. Bafadhal No. 111, Jambi 36134 Indonesia");
		markeabadi.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
		maps.addMarker(markeabadi);
		
		LatLng aston = new LatLng(-1.601702, 103.604222);
		MarkerOptions markeaston = new MarkerOptions();
		markeaston.position(aston);
		markeaston.title("Aston Jambi Hotel & Conference Center");
		markeaston.snippet("Jalan Muhammad Husni Thamrin, Kecamatan Jelutung, Kota Jambi");
		markeaston.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
		maps.addMarker(markeaston);
		
		LatLng novita = new LatLng(-1.595992,103.615252);
		MarkerOptions markenovita = new MarkerOptions();
		markenovita.position(novita);
		markenovita.title("Novita Hotel");
		markenovita.snippet("Jl. Gatot Subroto No.44 Jambi, Sumatera Barat 13614, Indonesia");
		markenovita.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
		maps.addMarker(markenovita);
		
		LatLng grand = new LatLng(-1.619570, 103.582687);
		MarkerOptions markegrand = new MarkerOptions();
		markegrand.position(grand);
		markegrand.title("Grand Hotel Jambi");
		markegrand.snippet("Jl. Pattimura No. 28C, Simpang 4, Sipin, Jambi 65148");
		markegrand.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
		maps.addMarker(markegrand);
		
		LatLng ratu = new LatLng(-1.595547, 103.598652);
		MarkerOptions markeratu = new MarkerOptions();
		markeratu.position(ratu);
		markeratu.title("Ratu Hotel & Resort");
		markeratu.snippet("Jalan Slamet Riyadi No.24 Jambi 36124");
		markeratu.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
		maps.addMarker(markeratu);
		
		LatLng hotel1 = new LatLng(-1.599150, 103.632297);
		MarkerOptions markehotel1 = new MarkerOptions();
		markehotel1.position(hotel1);
		markehotel1.title("Hotel Jambi Prima");
		markehotel1.snippet("Talang Banjar, Kecamatan Jambi Timur, Kota Jambi, Jambi");
		markehotel1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
		maps.addMarker(markehotel1);
		
		LatLng hotel2 = new LatLng(-1.584565, 103.630066);
		MarkerOptions markehotel2 = new MarkerOptions();
		markehotel2.position(hotel2);
		markehotel2.title("Hotel Wiltop");
		markehotel2.snippet("JL. Sultan Thaha No. 17 Jambi 36111");
		markehotel2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
		maps.addMarker(markehotel2);
		
		LatLng hotel3 = new LatLng(-1.618026, 103.558140);
		MarkerOptions markehotel3 = new MarkerOptions();
		markehotel3.position(hotel3);
		markehotel3.title("Golden Harvest Hotel");
		markehotel3.snippet("Jl.Pattimura no.65 - Simpang Rimbo");
		markehotel3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		maps.addMarker(markehotel3);
		
		LatLng hotel4 = new LatLng(-1.611505, 103.583202);
		MarkerOptions markehotel4 = new MarkerOptions();
		markehotel4.position(hotel4);
		markehotel4.title("Hotel Jaya");
		markehotel4.snippet("JL. RE. Martadinata No. 7");
		markehotel4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
		maps.addMarker(markehotel4);
		
		LatLng hotel5 = new LatLng(-1.619227, 103.588867);
		MarkerOptions markehotel5 = new MarkerOptions();
		markehotel5.position(hotel5);
		markehotel5.title("Hotel Nusa Wijaya");
		markehotel5.snippet("Jl. Kolonel Abunjani No.14, Simpang Empat Sipin Jambi");
		markehotel5.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
		maps.addMarker(markehotel5);
		
		LatLng hotel6 = new LatLng(-1.626605, 103.633671);
		MarkerOptions markehotel6 = new MarkerOptions();
		markehotel6.position(hotel6);
		markehotel6.title("Hotel Palem");
		markehotel6.snippet("JL. Soekarno Hatta No. 45");
		markehotel6.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
		maps.addMarker(markehotel6);
		
		
		maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		maps.getUiSettings().setCompassEnabled(true);
        
		maps.getUiSettings().setZoomControlsEnabled(true);
        
		maps.getUiSettings().setMyLocationButtonEnabled(true);
        
		maps.setMyLocationEnabled(true);
		
		
		maps.moveCamera(CameraUpdateFactory.newLatLngZoom(abadi, 9));
		maps.animateCamera(CameraUpdateFactory.zoomTo(9),1000,null);
		
		maps.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
			
			@Override
			public void onInfoWindowClick(Marker arg0) {
				// TODO Auto-generated method stub
			AlertDialog.Builder trans = new AlertDialog.Builder(new ContextThemeWrapper(HotelActivity.this, R.style.AlertDialogCustom));
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
	
