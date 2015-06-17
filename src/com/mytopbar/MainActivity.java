package com.mytopbar;

import com.mytopbar.MyTopbar.TopbarClickListenter;

import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;

/**
 * ѧϰĿ�ģ�
 * 1����������Զ���ؼ����ԣ�
 * 2��������ζ�̬���������
 * 3��������ο�����ƶ�̬ģ�壻
 * 4�����ģ�廯�����ı���֮����
 * 5�����ӿڻص����Ƶ�˼�롣
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
				Toast.makeText(MainActivity.this, "����ұ߰�ť", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onLeftClick() {
				Toast.makeText(MainActivity.this, "�����߰�ť", Toast.LENGTH_SHORT).show();
			}
		});
	}

}
