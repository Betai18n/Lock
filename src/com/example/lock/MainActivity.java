package com.example.lock;


import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;


import android.R.anim;
import android.R.integer;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class MainActivity extends Activity {
		
		
	//private DevicePolicyManager policyManager;
	private static String newpassword = "3214";
	private char[] nowtime = new char[100];
	private String passtime;
	//private String passtimestring;


	
	//private ComponentName componentName;


	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent2=new Intent(this, LockStatusService.class);
        startService(intent2);
        
        //policyManager=(DevicePolicyManager) this.getSystemService(this.DEVICE_POLICY_SERVICE);
        //componentName=new ComponentName(this, AdminReceiver.class);
        
        //mylock();
        
    }
    
    /*
    private void mylock(){
        boolean active=policyManager.isAdminActive(componentName);
        if(!active){
            activeManage();
            policyManager.lockNow();
        }
        if(active){
            policyManager.lockNow();
        }
    }
    
*/
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}