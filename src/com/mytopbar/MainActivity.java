package com.mytopbar;

import com.mytopbar.MyTopbar.TopbarClickListenter;

import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;

/**
 * 学习目的：
 * 1、掌握如何自定义控件属性；
 * 2、掌握如何动态创建组件；
 * 3、掌握如何开发设计动态模板；
 * 4、体会模板化开发的便利之处；
 * 5、体会接口回调机制的思想。
 */

public class MainActivity extends Activity {

	private MyTopbar topbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		topbar = (MyTopbar) findViewById(R.id.topbar);
		
		topbar.setOnTopbarClickListener(new TopbarClickListenter() {
			
			@Override
			public void onRightClick() {
				Toast.makeText(MainActivity.this, "点击右边按钮", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onLeftClick() {
				Toast.makeText(MainActivity.this, "点击左边按钮", Toast.LENGTH_SHORT).show();
			}
		});
	}

}
