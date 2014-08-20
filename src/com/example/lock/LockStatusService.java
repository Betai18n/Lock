package com.example.lock;

import java.text.SimpleDateFormat;

import android.annotation.SuppressLint;
import android.app.Service;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class LockStatusService extends Service{

	public DevicePolicyManager policyManager;
	public String passtimestring;
	public ComponentName componentName;
	
	
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        
        policyManager=(DevicePolicyManager) this.getSystemService(this.DEVICE_POLICY_SERVICE);
        componentName=new ComponentName(this, AdminReceiver.class);
        
        if (!policyManager.isAdminActive(componentName)) { 

            Intent intent = new Intent( 

            DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN); 

            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName); 

            startActivity(intent); 

        } 
        


        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(new PINReceiver(), filter);
        

        
    }
    
    public void activeManage(){
        Intent intent=new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, " ");
        //startActivityForResult(intent, 0);
    }
    
	public class PINReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			activeManage();
	        
;
	        SimpleDateFormat sDateFormat = new SimpleDateFormat("hhmm");
	        String date = sDateFormat.format(new java.util.Date());

	        passtimestring=date;
	        
	        policyManager.resetPassword(passtimestring,0);
	           
	        //android.os.Process.killProcess(android.os.Process.myPid());
		}
	}
	


    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

}
