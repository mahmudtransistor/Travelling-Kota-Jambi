package id.mahmud.travellingjambi;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MapsJambi extends FragmentActivity {
    private GoogleMap map;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps_jambi);
		
		map = ((MapFragment)getFragmentManager().findFragmentById(R.id.mapjambi)).getMap();
		LatLng Jambi = new LatLng(-1.589713, 103.611355);
		MarkerOptions markeJambi = new MarkerOptions();
		markeJambi.position(Jambi);
		markeJambi.title("JAMBI");
		markeJambi.snippet("Muaro Jambi, Jambi, Indonesia");
		markeJambi.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
		map.addMarker(markeJambi);
		
		
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		map.getUiSettings().setCompassEnabled(true);
        
		map.getUiSettings().setZoomControlsEnabled(true);
        
		map.getUiSettings().setMyLocationButtonEnabled(true);
        
		map.setMyLocationEnabled(true);
		
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(Jambi, 12));
		map.animateCamera(CameraUpdateFactory.zoomTo(12),100,null);
		
		
	}
}
