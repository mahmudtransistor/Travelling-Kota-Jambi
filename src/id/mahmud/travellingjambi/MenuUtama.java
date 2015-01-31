package id.mahmud.travellingjambi;

import id.mahmud.travellingjambi.slidermenu.CustomAdapter;
import id.mahmud.travellingjambi.slidermenu.CustomAdapterMenu;
import id.mahmud.travellingjambi.slidermenu.RowItem;
import id.mahmud.travellingjambi.slidermenu.RowItemMenu;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MenuUtama extends Activity {
	
	String[]menutitles;
	String[]member_name;
	
	TypedArray menuIcons;
	TypedArray picture1;
	
	private CharSequence mDrawertitle;
	private CharSequence mtitle;
	private DrawerLayout mDrawerlayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggel;
	private List<RowItem>rowItems;
	private CustomAdapter adapter;
	
	private List<RowItemMenu>rowItemmenu;
	private ListView listmenu;
	private CustomAdapterMenu adapter1;
	
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_utama);
		//Deklarasi Warna ActionBar
		actionBar = getActionBar();
		ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#9e9e9e"));
		actionBar.setBackgroundDrawable(colorDrawable);
		
		
		mtitle = mDrawertitle = getTitle();
		menutitles = getResources().getStringArray(R.array.title);
		menuIcons = getResources().obtainTypedArray(R.array.icons);
		mDrawerlayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		mDrawerList = (ListView)findViewById(R.id.slider_list);
		
		listmenu = (ListView)findViewById(R.id.list_menuutama);
		member_name = getResources().getStringArray(R.array.nama_menu);
		picture1 = getResources().obtainTypedArray(R.array.Poto);
		
		rowItems = new ArrayList<RowItem>();
		//deklarasi untuk menu utama
		rowItemmenu = new ArrayList<RowItemMenu>();
	
		
		for (int i = 0; i < member_name.length; i++) {
			RowItemMenu item = new RowItemMenu(member_name[i],picture1.getResourceId(i,-1));
			rowItemmenu.add(item);
		}
		
		picture1.recycle();
		adapter1 = new CustomAdapterMenu(getApplicationContext(), rowItemmenu);
		listmenu.setAdapter(adapter1);
		listmenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
			/**
			 * Perintah untuk memanggil activity traveling kota jambi	
			 */
			if (position == 0){
					Intent trans = new Intent(getApplicationContext(),TravellingActivity.class);
					startActivity(trans);
				}else if(position == 1){
					Intent trans = new Intent(getApplicationContext(),MapsJambi.class);
					startActivity(trans);
				}else if(position == 2){
					Intent trans = new Intent(getApplicationContext(),Sejarahjambi.class);
					startActivity(trans);
				}else if(position == 3){
					Keluar();
				
				}
			}
		});
		
		
		for(int i=0;i<menutitles.length;i++){
			RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(i,-1));
			rowItems.add(items);
			
		}
		menuIcons.recycle();
		adapter = new CustomAdapter(getApplicationContext(), rowItems);
		mDrawerList.setAdapter(adapter);
		
		mDrawerList.setOnItemClickListener(new SlideitemListener());

		 // enabling action bar app icon and behaving it as toggle button                                                   
		    getActionBar().setDisplayHomeAsUpEnabled(true);     
		   getActionBar().setHomeButtonEnabled(true);

		  mDrawerToggel = new ActionBarDrawerToggle(this, mDrawerlayout,     R.drawable.ic_drawer, R.string.app_name,R.string.app_name)
		{       
		        public void onDrawerClosed(View view) {
		                 getActionBar().setTitle(mtitle);
		                 // calling onPrepareOptionsMenu() to show action bar icons
		                  invalidateOptionsMenu();
		                  }
		      public void onDrawerOpened(View drawerView) {          
		             getActionBar().setTitle(mDrawertitle);
		       // calling onPrepareOptionsMenu() to hide action bar icons
		             invalidateOptionsMenu();          }
		            };
		 mDrawerlayout.setDrawerListener(mDrawerToggel);
		 if (savedInstanceState == null) {         
		 // on first time display view for first nav item
		           updateDisplay(0);
		      }
		    }  class SlideitemListener implements ListView.OnItemClickListener {
		    
		        @Override
		          public void onItemClick(AdapterView<?> parent, View view, int position, long id)  
		             {                  updateDisplay(position);
		                 }

		       }  private void updateDisplay(int position) {
		                Fragment fragment = null;
		                 switch (position) {   
		                         case 0:      
		                         
		                         break;
		                         case 1:       
		                          Intent aa = new Intent(getApplicationContext(),HomeActivity.class);
			                      startActivity(aa);
		                         break;
		                         case 2:         
		                         Intent trans = new Intent(getApplicationContext(),ProfilActivity.class);
			                     startActivity(trans);
		                         break; 
		                         case 3:
		                        	  Keluar();
		                         break;
		                         
		                         default:              
		                         break;
		                            }   
		                            if (fragment != null) {
		                     android.app.FragmentManager fragmentManager = getFragmentManager();              
		                      fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();                   
		                    // update selected item and title, then close the drawer
		                     setTitle(menutitles[position]);        
		                     mDrawerlayout.closeDrawer(mDrawerList);
		                    }
		                  else {  
		                 // error in creating fragment
		                   Log.e("MainActivity", "Error in creating fragment");
		                       }
		             }
		@Override     
		  public void setTitle(CharSequence title) {      
		                   mtitle = title;         
		                   getActionBar().setTitle(mtitle);
		  }
		  @Override  
		   public boolean onCreateOptionsMenu(Menu menu) {       
		         getMenuInflater().inflate(R.menu.menu_utama, menu);
		         return true;
		   }
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {   
		 // toggle nav drawer on selecting action bar app icon/title      
		   if (mDrawerToggel.onOptionsItemSelected(item)) {                  
		 return true;          
		   }
		  // Handle action bar actions click  
		    
		     return super.onOptionsItemSelected(item);
		         }

		  /**   * When using the ActionBarDrawerToggle, you must call it during   * onPostCreate() and onConfigurationChanged()...   */
		 @Override    
		  protected void onPostCreate(Bundle savedInstanceState) {
		        super.onPostCreate(savedInstanceState);
		 // Sync the toggle state after onRestoreInstanceState has occurred.           
		mDrawerToggel.syncState();    }
		@Override      
		public void onConfigurationChanged(Configuration newConfig) {
		       super.onConfigurationChanged(newConfig);
		      // Pass any configuration change to the drawer toggles
		          mDrawerToggel.onConfigurationChanged(newConfig);
		  }
		
		public void Keluar(){
			
			AlertDialog.Builder trans = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertDialogCustom));
			trans.setTitle("Keluar").setCancelable(false);
			trans.setIcon(R.drawable.ic_launcher);
			trans.setMessage("Anda yakin ingin keluar Aplikasi ? ");
			trans.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
				MenuUtama.this.finish();	
				}
			});
			trans.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
				dialog.dismiss();	
				}
			});
			trans.show();
		}
		public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if (keyCode == KeyEvent.KEYCODE_BACK) {
	        Keluar();
	      
	        }   
	        return super.onKeyDown(keyCode, event);
	     }
		
		
		 }
