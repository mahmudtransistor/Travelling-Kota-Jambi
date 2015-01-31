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

public class MasjidActivity extends Activity {
	 private GoogleMap maps;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_masjid);
		initmaps();
		
	}
	private void initmaps(){
		maps = ((MapFragment)getFragmentManager().findFragmentById(R.id.mapmasjid)).getMap();
		//Deklarasi Tempat Masjid
		LatLng magung = new LatLng(-1.588984,103.615762);
		MarkerOptions markemagung = new MarkerOptions();
		markemagung.position(magung);
		markemagung.title("Masjid Agung Al Falah");
		markemagung.snippet("JL. Sultan Thaha, No. 60, Legok");
		markemagung.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
		maps.addMarker(markemagung);
		
		LatLng alazhar = new LatLng(-1.638966,102.5305145);
		MarkerOptions markealazhar = new MarkerOptions();
		markealazhar.position(alazhar);
		markealazhar.title("Al-Azhar");
		markealazhar.snippet("JL. Kolonel Amir Hamzah");
		markealazhar.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
		maps.addMarker(markealazhar);
		
		LatLng aliklas = new LatLng(-0.546838,102.4725705);
		MarkerOptions markealiklas = new MarkerOptions();
		markealiklas.position(aliklas);
		markealiklas.title("Masjid Baitul Ikhlas");
		markealiklas.snippet("Buluran Kenali, Telanaipura");
		markealiklas.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
		maps.addMarker(markealiklas);
		
		LatLng mutakin = new LatLng(-1.598389,103.59905);
		MarkerOptions markemutakin = new MarkerOptions();
		markemutakin.position(mutakin);
		markemutakin.title("Al Muttaqin");
		markemutakin.snippet("JL. Slamet Riyadi, No. 88");
		markemutakin.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
		maps.addMarker(markemutakin);
		
		LatLng raudah = new LatLng(-6.183504,106.994749);
		MarkerOptions markeraudah = new MarkerOptions();
		markeraudah.position(raudah);
		markeraudah.title("Masjid Ar Raudhah");
		markeraudah.snippet("Jalan Taman Yasmin Raya");
		markeraudah.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		maps.addMarker(markeraudah);
		
		
		
		maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		maps.getUiSettings().setCompassEnabled(true);
        
		maps.getUiSettings().setZoomControlsEnabled(true);
        
		maps.getUiSettings().setMyLocationButtonEnabled(true);
        
		maps.setMyLocationEnabled(true);
		
		maps.moveCamera(CameraUpdateFactory.newLatLngZoom(magung, 9));
		maps.animateCamera(CameraUpdateFactory.zoomTo(9),1000,null);
		
       maps.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
			
			@Override
			public void onInfoWindowClick(Marker arg0) {
				// TODO Auto-generated method stub
			AlertDialog.Builder trans = new AlertDialog.Builder(new ContextThemeWrapper(MasjidActivity.this, R.style.AlertDialogCustom));
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
