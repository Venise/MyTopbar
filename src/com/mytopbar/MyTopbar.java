package com.mytopbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyTopbar extends RelativeLayout{

	private Button leftButton;
	private Button rightButton;
	private TextView titleTextView;
	
	private String title;
	private float titleTextSize;
	private int titleTextColor;
	private Drawable background;//设置整个RelativeLayout的背景
	
	private int leftTextColor;
	private float leftTextSize;
	private Drawable leftBackground;
	private String leftText;
	
	private int rightTextColor;
	private float rightTextSize;
	private Drawable rightBackground;
	private String rightText;
	
	private LayoutParams leftParams;
	private LayoutParams titleParams;
	private LayoutParams rightParams;
	private TopbarClickListenter topbarListenter;
	
	public interface TopbarClickListenter {
		public void onLeftClick();
		public void onRightClick();
	}
	
	public void setOnTopbarClickListener(TopbarClickListenter listenter) {
		this.topbarListenter = listenter;
	}
	
	public MyTopbar(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Topbar);
		
		title = ta.getString(R.styleable.Topbar_title);
		background = ta.getDrawable(R.styleable.Topbar_background);
		titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize, 0);
		
		leftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor, 0);
		leftTextSize = ta.getDimension(R.styleable.Topbar_leftTextSize, 0);
		leftText = ta.getString(R.styleable.Topbar_leftText);
		leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
		
		rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor, 0);
		rightTextSize = ta.getDimension(R.styleable.Topbar_rightTextSize, 0);
		rightText = ta.getString(R.styleable.Topbar_rightText);
		rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
		
		ta.recycle();//一定要Recycle;
		
		titleTextView = new TextView(context);
		leftButton = new Button(context);
		rightButton = new Button(context);
		
		titleTextView.setText(title);
		titleTextView.setTextColor(titleTextColor);
		titleTextView.setTextSize(titleTextSize);
		titleTextView.setGravity(Gravity.CENTER);
		
		leftButton.setBackground(leftBackground);
		leftButton.setTextColor(leftTextColor);
		leftButton.setTextSize(leftTextSize);
		leftButton.setText(leftText);
		leftButton.setGravity(Gravity.CENTER);
		
		rightButton.setBackground(rightBackground);
		rightButton.setTextColor(rightTextColor);
		rightButton.setTextSize(rightTextSize);
		rightButton.setText(rightText);
		rightButton.setGravity(Gravity.CENTER);
		
		setBackground(background);
		
		leftParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
		addView(leftButton, leftParams);
		
		rightParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		addView(rightButton, rightParams);
		
		titleParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		addView(titleTextView, titleParams);
		
		leftButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				topbarListenter.onLeftClick();
			}
		});
		
		rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				topbarListenter.onRightClick();
			}
		});
	}
	
	public void setLeftVisible(Boolean flag) {
		if (flag) {
			leftButton.setVisibility(View.VISIBLE);
		}else {
			leftButton.setVisibility(View.INVISIBLE);
		}
	}
}
