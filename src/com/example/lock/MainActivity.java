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
	//private String passtimestring;


	
	//private ComponentName componentName;


	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        DevicePolicyManager policyStart = (DevicePolicyManager) this.getSystemService(this.DEVICE_POLICY_SERVICE);
        ComponentName componentStartName = new ComponentName(this, AdminReceiver.class);
        
        if (!policyStart.isAdminActive(componentStartName)) { 

            Intent intent1 = new Intent( 

            DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN); 

            intent1.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentStartName); 

            startActivity(intent1); 

        } 
        
        try {
			Intent intent2=new Intent(this, LockStatusService.class);
			startService(intent2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        
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