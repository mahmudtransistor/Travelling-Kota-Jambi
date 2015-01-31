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

public class WisataActivity extends Activity {
	private GoogleMap maps;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wisata);
		initMaps();
	}
	private void initMaps(){
		maps = ((MapFragment)getFragmentManager().findFragmentById(R.id.mapwisata)).getMap();
		//Deklarasi koordinat Wisata
		
		LatLng wisata1 = new LatLng(-1.620428,103.603115);
		MarkerOptions markewisata1 = new MarkerOptions();
		markewisata1.position(wisata1);
		markewisata1.title("Taman Wisata Kampoeng Radja");
		markewisata1.snippet("JL. Lingkar Barat Simpang Rimbo, Kotabaru");
		markewisata1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
		maps.addMarker(markewisata1);
		
		LatLng wisata2 = new LatLng(-1.606443, 103.592815);
		MarkerOptions markewisata2 = new MarkerOptions();
		markewisata2.position(wisata2);
		markewisata2.title("Museum Negeri Jambi");
		markewisata2.snippet("Jl. Urip Sumoharjo No 1 Kel Sei Putri Kec Telanaipura Jambi ");
		markewisata2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
		maps.addMarker(markewisata2);
		
		LatLng wisata3 = new LatLng(-1.613822, 103.586550);
		MarkerOptions markewisata3 = new MarkerOptions();
		markewisata3.position(wisata3);
		markewisata3.title("Amarta Buana Wisata");
		markewisata3.snippet("JL. Ir. H. Juanda, No. 42");
		markewisata3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
		maps.addMarker(markewisata3);
		
		LatLng wisata4 = new LatLng(-1.475755,103.657699);
		MarkerOptions markewisata4 = new MarkerOptions();
		markewisata4.position(wisata4);
		markewisata4.title("Candi Gedong 2");
		markewisata4.snippet("Desa Muara Jambi, Kec Maro Sebo Muara Jambi Jambi");
		markewisata4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
		maps.addMarker(markewisata4);
		
		LatLng wisata5 = new LatLng(-1.620428,103.603115);
		MarkerOptions markewisata5 = new MarkerOptions();
		markewisata5.position(wisata5);
		markewisata5.title("PT. ALYA RIZKY WISATA Tour & Traveljl");
		markewisata5.snippet("JL HM Yusuf Singedekane, No. 4 Jambi");
		markewisata5.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
		maps.addMarker(markewisata5);
		
		LatLng wisata6 = new LatLng(-1.588199,103.617335);
		MarkerOptions markewisata6 = new MarkerOptions();
		markewisata6.position(wisata6);
		markewisata6.title("Ancol");
		markewisata6.snippet("");
		markewisata6.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
		maps.addMarker(markewisata6);
		
		maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
		maps.getUiSettings().setCompassEnabled(true);
		
		maps.getUiSettings().setZoomControlsEnabled(true);
		
		maps.getUiSettings().setMyLocationButtonEnabled(true);
		
		maps.setMyLocationEnabled(true);
		//Deklarasi kamera google maps
		maps.moveCamera(CameraUpdateFactory.newLatLngZoom(wisata1, 9));
		maps.animateCamera(CameraUpdateFactory.zoomTo(9),1000,null);
		
		maps.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
			
			@Override
			public void onInfoWindowClick(Marker arg0) {
				// TODO Auto-generated method stub
			AlertDialog.Builder trans = new AlertDialog.Builder(new ContextThemeWrapper(WisataActivity.this, R.style.AlertDialogCustom));
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
