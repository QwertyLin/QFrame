package q.frame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QActivity extends Activity {
	
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
    
    public void addBtn(String text, boolean alignLeft){
    	Button v = (Button)inflater.inflate(R.layout.layout_header_btn, null);
    	v.setText(text);
    	LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    	if(alignLeft){
    		llp.gravity = Gravity.LEFT;
    	}else{
    		llp.gravity = Gravity.RIGHT;
    	}
    	v.setLayoutParams(llp);
    	layoutHeader.addView(v);
    }
    
    public void addBtnBack(String text){
    	Button v = (Button)inflater.inflate(R.layout.layout_header_back, null);
    	v.setText(text);
    	layoutHeader.addView(v);
    }
    
}
