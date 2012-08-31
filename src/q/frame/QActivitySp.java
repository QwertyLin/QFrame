package q.frame;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.umeng.analytics.MobclickAgent;

public abstract class QActivitySp extends SherlockActivity {
	
	protected ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light_ForceOverflow);
		super.onCreate(savedInstanceState);
		actionBar = getSupportActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
	}
	
	@Override
    protected void onResume() {
    	super.onResume();
    	MobclickAgent.onResume(this);
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	MobclickAgent.onPause(this);
    }

}
