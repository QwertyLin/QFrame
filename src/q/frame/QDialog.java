package q.frame;

import q.manager.QWindow;
import q.util.QApp;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QDialog {
	
	public static class Simple extends Dialog {
		
		private Context ctx;
		private LinearLayout layoutBtns;

		public Simple(Context ctx, String text) {
			super(ctx);
			this.ctx = ctx;
			Window window = this.getWindow();
			window.requestFeature(Window.FEATURE_NO_TITLE);
			window.setBackgroundDrawableResource(R.color.transparent);
	        this.setContentView(R.layout.dialog_simple);
	        //
	        layoutBtns = (LinearLayout)findViewById(R.id.dialog_simple_btns);
	        //
	        if(text != null){
	        	setText(text);
	        }
		}
		
		public void setText(String text){
			((TextView)findViewById(R.id.dialog_simple_text)).setText(text);
		}
		
		public void addBtn(String text, android.view.View.OnClickListener onClick){
			Button btn = new Button(ctx);
			btn.setText(text);
			btn.setOnClickListener(onClick);
			LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
			btn.setLayoutParams(llp);
			btn.setBackgroundResource(R.drawable.btn_blue);
			btn.setTextColor(0xFFFFFFFF);
			btn.setPadding(0, 10, 0, 10);
			layoutBtns.addView(btn);
		}
		
		public void addBtnGotIt(){
			Button btn = new Button(ctx);
			btn.setText("我知道了");
			btn.setOnClickListener(new android.view.View.OnClickListener() {
				@Override
				public void onClick(View v) {
					cancel();
				}
			});
			LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
			btn.setLayoutParams(llp);
			btn.setBackgroundResource(R.drawable.btn_blue);
			btn.setTextColor(0xFFFFFFFF);
			btn.setPadding(0, 10, 0, 10);
			layoutBtns.addView(btn);
		}
		
	}

	
	public static class Loading extends Dialog {
		
		RotateAnimation 
			animOut = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f),
			animIn = new RotateAnimation(359, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		View ivOut, ivIn;
		
		public Loading(Context ctx) {
			super(ctx);
			QApp qApp = (QApp)ctx.getApplicationContext();
			//
			Window window = this.getWindow();
			window.requestFeature(Window.FEATURE_NO_TITLE);
			window.setBackgroundDrawableResource(R.color.transparent);
	        this.setContentView(R.layout.dialog_loading);
	        FrameLayout.LayoutParams rlp = new FrameLayout.LayoutParams(qApp.getQWindow().getWidth() - 20, RelativeLayout.LayoutParams.WRAP_CONTENT);
	        rlp.setMargins(10, 0, 10, 0);
	        this.findViewById(R.id.dialog_loading_layout).setLayoutParams(rlp);
	        //
	        ivOut = this.findViewById(R.id.dialog_loading_out);
	        ivIn = this.findViewById(R.id.dialog_loading_in);
	        //
	        LinearInterpolator li = new LinearInterpolator();//�??效果
	        animOut.setDuration(500);
			animOut.setRepeatCount(Animation.INFINITE);
			animOut.setInterpolator(li);
	        animIn.setDuration(500);
			animIn.setRepeatCount(Animation.INFINITE);
			animIn.setInterpolator(li);
		}
		
		@Override
		public void show() {
			ivOut.startAnimation(animOut);
			ivIn.startAnimation(animIn);
			super.show();
		}
		
		@Override
		public void cancel() {
			ivOut.clearAnimation();
			ivIn.clearAnimation();
			super.cancel();
		}
	}
}
