package q.frame;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.umeng.analytics.MobclickAgent;

public class QActivity extends SherlockActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar_ForceOverflow);
		super.onCreate(savedInstanceState);
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
