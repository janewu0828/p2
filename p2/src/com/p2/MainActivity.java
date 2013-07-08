package com.p2;

import org.apache.cordova.*;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends DroidGap {
	public final String MyURL = "http://womany.net/about?ref=footer";

	private static final String ACTIVITY_TAG = "Debug";
	String strPhone="0200000000";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/index.html");
	}
	
	private void showAlertDialog(){
		Builder MyAlertDialog = new AlertDialog.Builder(this);
		MyAlertDialog.setTitle("相關");
		MyAlertDialog.setMessage("關於相關的事情");
		
		DialogInterface.OnClickListener OkClick = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}	
		};
		
		DialogInterface.OnClickListener openURL = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				loadUrl(MyURL);
			}	
		};
	
		MyAlertDialog.setPositiveButton("關於我們",openURL);
		MyAlertDialog.setNegativeButton("滾",OkClick);
		MyAlertDialog.show();
	}
	
	private void showCall(MainActivity mainActivity){
	Log.d(MainActivity.ACTIVITY_TAG, "---執行showCall---");
	
	Intent dial = new Intent();
    dial.setAction("android.intent.action.CALL");
	dial.setData(Uri.parse("tel:"+strPhone));
    
    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		menu.add(0, 0, 0, "說明");
		menu.add(0, 1, 1, "離開");
		menu.add(0, 2, 2, "p");
		
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case 0:
				showAlertDialog();
		        break;
		    case 1:
		        finish();
		        break;
		    case 2:
		    	Log.d(MainActivity.ACTIVITY_TAG, "---呼叫showCall---");
		    	break;
		}
		return super.onOptionsItemSelected(item);
	}

}
