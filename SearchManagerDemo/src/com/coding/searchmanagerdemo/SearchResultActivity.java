package com.coding.searchmanagerdemo;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class SearchResultActivity extends Activity implements OnClickListener{
 private TextView tvquery,tvdata;
 private Button btnsearch;
 @Override
 protected void onCreate(Bundle savedInstanceState){
  super.onCreate(savedInstanceState);
  setContentView(R.layout.searchresult);
  tvquery=(TextView)findViewById(R.id.tvquery);
  tvdata=(TextView)findViewById(R.id.tvdata);
  btnsearch=(Button)findViewById(R.id.btnSearch);
  doSearchQuery();
  btnsearch.setOnClickListener(this);
 }
 //����query��bundle������queryֵ��������������б�ֵ��
 public void doSearchQuery(){
  final Intent intent = getIntent();
  //�����������ֵ
  String query=intent.getStringExtra(SearchManager.QUERY);
  tvquery.setText(query);
  //����������¼
  SearchRecentSuggestions suggestions=new SearchRecentSuggestions(this,
    SearchSuggestionSampleProvider.AUTHORITY, SearchSuggestionSampleProvider.MODE);
  suggestions.saveRecentQuery(query, null);
  if(Intent.ACTION_SEARCH.equals(intent.getAction())){
   //��ȡ���ݵ�����
   Bundle bundled=intent.getBundleExtra(SearchManager.APP_DATA);
   if(bundled!=null){
    String ttdata=bundled.getString("data");
    tvdata.setText(ttdata);
   }else{
    tvdata.setText("no data");
   }
  }
 }
 @Override
 public void onClick(View v) {
  // TODO Auto-generated method stub
  onSearchRequested();
 }
 @Override
 public boolean onSearchRequested(){
  startSearch("onNewIntent", false, null, false);
  return true;
 }
 /*����search bar��ActivityͬʱҲ�Ǵ������������Activityʱ��
  * ��һ��:�������ļ��У��������������Activity���android:launchMode="singleTop"����
  * �ڶ���:��дActivity��onNewIntent(Intent intent)
  */
 @Override
 public void onNewIntent(Intent intent){
  super.onNewIntent(intent);
  //�����������ֵ
  String query=intent.getStringExtra(SearchManager.QUERY);
  tvquery.setText(query);
  //����������¼
  SearchRecentSuggestions suggestions=new SearchRecentSuggestions(this,
    SearchSuggestionSampleProvider.AUTHORITY, SearchSuggestionSampleProvider.MODE);
  suggestions.saveRecentQuery(query, null);
  if(Intent.ACTION_SEARCH.equals(intent.getAction())){
   //��ȡ���ݵ�����
   Bundle bundled=intent.getBundleExtra(SearchManager.APP_DATA);
   if(bundled!=null){
    String ttdata=bundled.getString("data");
    tvdata.setText(ttdata);
   }else{
    tvdata.setText("no data");
   }
  }
 }
}
