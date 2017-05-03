package com.coding.searchmanagerdemo;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
public class SearchManagerDemoActivity extends Activity implements OnClickListener {
	 private EditText etdata;
	 private Button btnsearch;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        etdata=(EditText)findViewById(R.id.etdata);
	        btnsearch=(Button)findViewById(R.id.btncall);
	        btnsearch.setOnClickListener(this);
	    }
	 @Override
	 public void onClick(View v) {
	  onSearchRequested();
	 }
	 /*
	  * Ϊ���ܹ�ʹ��search bar,���Ǳ�����дActivity��onSearchRequested�ķ�����
	  * search bar�����Զ�����������ͨ��һ����ť���߲˵��ĵ���¼�����
	  * @see android.app.Activity#onSearchRequested()
	  */
	 public boolean onSearchRequested(){
	  String text=etdata.getText().toString();
	  Bundle bundle=new Bundle();
	  bundle.putString("data", text);
	  //�򿪸��������򣨵�һ������Ĭ����ӵ��������ֵ��,bundleΪ���ݵ�����
	  startSearch("andy", false, bundle, false);
	  /*һ��Ҫ����true,
	   * �������super.onSearchRequested()����,���������Ĭ��ֵ�޷���ӵ��������У�bundleҲ�޷����ݳ�ȥ
	   */
	  return true;
	 } 
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
