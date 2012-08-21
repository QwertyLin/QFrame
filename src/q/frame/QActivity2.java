package q.frame;

import com.umeng.analytics.MobclickAgent;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QActivity2 extends Activity {
	
	private LayoutInflater inflater;
	private LinearLayout layoutHeader;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(R.layout.layout_frame);
        inflater = getLayoutInflater();
        //
        layoutHeader = (LinearLayout)findViewById(R.id.layout_frame_btns);
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
    
    @Override
    public void setContentView(int layoutResID) {
    	((FrameLayout)findViewById(R.id.layout_frame_main)).addView(inflater.inflate(layoutResID, null));
    }
    
    @Override
    public void setContentView(View view) {
    	((FrameLayout)findViewById(R.id.layout_frame_main)).addView(view);
    }
    
    @Override
    public void setTitle(CharSequence title) {
    	((TextView)findViewById(R.id.layout_frame_title)).setText(title);
    }
    
    public void addBtn(String text, OnClickListener onClick){
    	Button v = (Button)inflater.inflate(R.layout.layout_header_btn, null);
    	v.setText(text);
    	v.setOnClickListener(onClick);
    	layoutHeader.addView(v);
    }
    
    public void addBtnImg(int resId, OnClickListener onClick){
    	ImageButton v = (ImageButton)inflater.inflate(R.layout.layout_header_imgbtn, null);
    	v.setImageResource(resId);
    	v.setOnClickListener(onClick);
    	layoutHeader.addView(v);
    }
    
    public void addBtnBack(String text, OnClickListener onClick){
    	Button v = (Button)inflater.inflate(R.layout.layout_header_back, null);
    	v.setText(text);
    	v.setOnClickListener(onClick);
    	layoutHeader.addView(v);
    }
    
    public void addBtnBlank(){
    	TextView v = new TextView(this);
    	LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
    	llp.weight = 1;
    	v.setLayoutParams(llp);
    	layoutHeader.addView(v);
    }
    
    public void addBtnSep(){
    	TextView v = new TextView(this);
    	v.setLayoutParams(new LinearLayout.LayoutParams(10, LinearLayout.LayoutParams.WRAP_CONTENT));
    	layoutHeader.addView(v);
    }
    
}
