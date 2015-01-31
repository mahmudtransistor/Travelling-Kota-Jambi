package id.mahmud.travellingjambi;

import id.mahmud.travellingjambi.slidermenu.CustomAdapterTravelling;
import id.mahmud.travellingjambi.slidermenu.RowItemTravelling;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class TravellingActivity extends Activity implements OnQueryTextListener {
	
	String[]namatravelling;
	String[]keterangan;
	
	TypedArray gambarTravalling;
	
	private List<RowItemTravelling>list;
	private ListView listTravelling;
	private CustomAdapterTravelling adapter;
	
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_travelling);
		//Deklarasi Warna ActionBar
		actionBar = getActionBar();
		ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#9e9e9e"));
		actionBar.setBackgroundDrawable(colorDrawable);
		
		
		listTravelling = (ListView)findViewById(R.id.list_travelling);
		
		namatravelling = getResources().getStringArray(R.array.nama_traveling);
		keterangan = getResources().getStringArray(R.array.keterangan_travelling);
		gambarTravalling = getResources().obtainTypedArray(R.array.poto_travelling);
		
		
		list = new ArrayList<RowItemTravelling>();
		
		for (int i = 0; i < namatravelling.length; i++) {
			RowItemTravelling item = new RowItemTravelling(gambarTravalling.getResourceId(i,-1),namatravelling[i],keterangan[i]);
			list.add(item);
		}
		gambarTravalling.recycle();
		adapter = new CustomAdapterTravelling(getApplicationContext(), list);
		listTravelling.setAdapter(adapter);
		listTravelling.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				return false;
			}
		});
		listTravelling.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
			if (position == 0){
				Intent trans = new Intent(getApplicationContext(),HotelActivity.class);
				startActivity(trans);
			}
			else if(position == 1){
				Intent trans = new Intent(getApplicationContext(),RestoranActivity.class);
				startActivity(trans);
			}
			else if(position == 2){
				Intent trans = new Intent(getApplicationContext(),MasjidActivity.class);
				startActivity(trans);
			}
			else if(position == 3){
			    Intent trans = new Intent(getApplicationContext(),SpbuActivity.class);
			    startActivity(trans);
			}
			else if(position == 4){
			Intent trans = new Intent(getApplicationContext(),CafeActivity.class);
			startActivity(trans);
			}
			else if(position == 5){
			Intent trans = new Intent(getApplicationContext(),WisataActivity.class);
			startActivity(trans);
			}
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.travelling, menu);
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.option_menu_search).getActionView();
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		searchView.setIconifiedByDefault(false);
		searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Nama Travelling");
		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		adapter.getFilter().filter(newText);
		return false;
	}
}
