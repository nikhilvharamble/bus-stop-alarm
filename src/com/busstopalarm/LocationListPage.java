package com.busstopalarm;
/**
 * Location List Page list a bunch of stops that can be selected used to
 * directly set an alarm without going through the map.
 * 
 * @author David Nufer
 */


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import android.widget.AdapterView.*;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;

public class LocationListPage extends ListActivity {
	/**
	 * static constants for determining if the list is for favorites
	 * or major locations.
	 */
	public static final int FAVORITES = 1;
	public static final int MAJOR = 2;
	
	public BusDbAdapter mBusDbHelper;
	public Cursor mCursor;
	
	
	/**
	 * a list is either LocatonListPage.FAVORTIES or LocatonListPage.MAJOR 
	 */
	private int listType;
	
	private ArrayList<HashMap<String, BusStop>> locationList = new ArrayList<HashMap<String,BusStop>>();
	private SimpleAdapter listAdapter;
	
    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
	  //Try with DB
	  mBusDbHelper = new BusDbAdapter(this);
	  mBusDbHelper.open();
	  
	  
	  listType = getIntent().getIntExtra("listType", 0);
	  if (listType == 0) {
		  // this is an error.  need to do something if we get here
	  }
	  
	  listAdapter = new SimpleAdapter(this, locationList, R.layout.list_item, new String[] {"busstop"}, new int[] {R.id.listItemName});
	  setListAdapter(listAdapter);
	  
	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);

	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	    	Intent i = new Intent(view.getContext(), ConfirmationPage.class);
	    	i.putExtra("busstop", locationList.get(position).get("busstop"));
	    	startActivity(i);
	    	finish();
	    }
	  });
	  
	  registerForContextMenu(getListView());
	  
	  // populate list items
	  fillList(mBusDbHelper);
	  mBusDbHelper.close();
	}
	
	/**
	 * fills the list with stops from the local database
	 * 
	 * @param db the database adapter to use
	 */
	private void fillList(BusDbAdapter db) {
		Cursor c;
		if (listType == FAVORITES) {
			c = db.getFavoriteDest(100); // TODO: 100 is arbitrary choice, maybe change later
		} else { // listType == MAJOR
			c = db.getMajorDest(100);
		}
		DataFetcher df = new DataFetcher();
		int stopIDIndex = c.getColumnIndex("stop_id");
		//int routeIDIndex = c.getColumnIndex("route_id");
		if (c != null) {
			for (int i = 0; i < c.getCount(); i++) {
				HashMap<String, BusStop> item = new HashMap<String, BusStop>();
				BusStop b;
				try {
					String[] stop = c.getString(stopIDIndex).split("_");
					b = df.getStopById(Integer.parseInt(stop[stop.length - 1]));
					item.put("busstop", b);
					c.moveToNext();
					locationList.add(item);
				} catch (IOException e) {
					Toast.makeText(this, "Error Loading from Database", Toast.LENGTH_LONG);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			listAdapter.notifyDataSetChanged();
		}
	}
	
	/**
	 * creates the context menu for items when they get a long click
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, view, menuInfo);
		menu.add(0, 10, 10, "Set alarm for this stop");
		menu.add(0, 11, 11, "Remove this stop");
		menu.add(0, 12, 12, "Canel");
	}
	
	/**
	 * actions for the context menu
	 */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
		int id = (int)getListAdapter().getItemId(info.position);
		
		// sets an alarm for the selected stop
		if (item.getItemId() == 10) {
	    	Intent i = new Intent(getApplicationContext(), ConfirmationPage.class);
	    	i.putExtra("busstop", locationList.get(id).get("busstop"));
	    	startActivity(i);
	    	finish();
	    
	    // removes the selected stop from the list
		} else if (item.getItemId() == 11) {
			locationList.remove(id);
			listAdapter.notifyDataSetChanged();
		}
		return true;
	}
}