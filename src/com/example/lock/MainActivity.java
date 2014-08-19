package com.example.lock;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.R.anim;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends Activity {
private DevicePolicyManager policyManager;
private static String newpassword = "3214";
private ComponentName componentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        policyManager=(DevicePolicyManager) this.getSystemService(this.DEVICE_POLICY_SERVICE);
        componentName=new ComponentName(this, AdminReceiver.class);
        
        if (!policyManager.isAdminActive(componentName)) { 

            Intent intent = new Intent( 

            DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN); 

            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName); 

            startActivity(intent); 

        } 

        activeManage();
        
        //policyManager.resetPassword("123", 0);
        
        //Intent intent1 = new Intent(DevicePolicyManager.ACTION_SET_NEW_PASSWORD);
        //startActivity(intent1); 
        
        policyManager.resetPassword(newpassword,0);
        
        mylock();
        
        android.os.Process.killProcess(android.os.Process.myPid());
        
    }
    
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
    

    
    private void activeManage(){
        Intent intent=new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "--∆‰À˚√Ë ˆ--");
        startActivityForResult(intent, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}