package com.coding.spinnerwheel;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
public class SpinnerWheelActivity extends Activity
{
	private ListView ListView01;
	private TextView TextView01;
	String[] s1 =
	{ "", "", "Ipad2", "Iphone4", "I9000", "Itouch", "NANO", "P1000","Android", "Nokia", "", "" };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView01 = (ListView) findViewById(R.id.ListView01);
		TextView01 = (TextView) findViewById(R.id.TextView01);

		/* ���ַ������ݷ���ArrayAdapter */
		ArrayAdapter<String> list1 = new ArrayAdapter<String>(this,
				R.layout.file_row, s1);
		/* �趨ListView��Adapter */
		ListView01.setAdapter(list1);
		/* ��ʱ͸���� */
		ListView01.setCacheColorHint(00000000);
		ListView01.setFastScrollEnabled(true);
		/* ����Ե */
		ListView01.setFadingEdgeLength(100);

		ListView01.setOnScrollListener(new ListView.OnScrollListener()
		{
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount)
			{
				// TODO Auto-generated method stub
				/* ȡ�õڼ�����ʾ���������ֵ */
				TextView01.setText(s1[firstVisibleItem + 2]);
			}

			public void onScrollStateChanged(AbsListView view, int scrollState)
			{
				// TODO Auto-generated method stub
			}
		});

		ListView01.setOnItemClickListener(new ListView.OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View v, int id,
					long arg3)
			{
				// TODO Auto-generated method stub
				/* �趨��ѡ��������Ϊ��ʼ */
				ListView01.setSelectionFromTop(id - 2, 0);
				TextView01.setText(s1[id]);
			}
		});

		ListView01
				.setOnItemSelectedListener(new ListView.OnItemSelectedListener()
				{
					public void onItemSelected(AdapterView<?> parent, View v,
							int id, long arg3)
					{
						// TODO Auto-generated method stub
						TextView01.setText(s1[id]);
					}

					public void onNothingSelected(AdapterView<?> arg0)
					{
						// TODO Auto-generated method stub
					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spinner_wheel, menu);
		return true;
	}

}
