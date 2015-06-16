package com.lala.taobao;


import java.util.ArrayList;
import java.util.List;

import com.lala.taobao.fragment.AccountFragment;
import com.lala.taobao.fragment.CartFragment;
import com.lala.taobao.fragment.MainFragment;
import com.lala.taobao.fragment.NearbyFragment;
import com.lala.taobao.fragment.TfaccountFragment;

import android.R.integer;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;


public class MainActivity extends FragmentActivity implements OnClickListener {
	private ViewPager mViewPager;
	private List<Fragment> mFragments = new ArrayList<Fragment>();
	private List<TextView> tabs =new ArrayList<TextView>();
	private TextView guide_home;
	private TextView guide_tfaccount;
	private TextView guide_nearby;
	private TextView guide_cart;
	private TextView guide_account;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);	

		mViewPager=(ViewPager)findViewById(R.id.ViewPager);
		initView();
		guide_home.setOnClickListener(this);
		guide_tfaccount.setOnClickListener(this);
		guide_nearby.setOnClickListener(this);
		guide_cart.setOnClickListener(this);
		guide_account.setOnClickListener(this);		
		mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				changTab(position);
			}			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub				
			}			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub				
			}
		});
	}
	private void initView() {
		guide_home=(TextView)findViewById(R.id.guide_home);
		guide_tfaccount=(TextView)findViewById(R.id.guide_tfaccount);
		guide_nearby=(TextView)findViewById(R.id.guide_nearby);
		guide_cart=(TextView)findViewById(R.id.guide_cart);
		guide_account=(TextView)findViewById(R.id.guide_account);
		tabs.add(guide_home);
		tabs.add(guide_tfaccount);
		tabs.add(guide_nearby);
		tabs.add(guide_cart);
		tabs.add(guide_account);
		
		MainFragment mFragment0=new MainFragment();
		TfaccountFragment mFragment1=new TfaccountFragment();
		NearbyFragment mFragment2=new NearbyFragment();
		CartFragment mFragment3=new CartFragment();		
		AccountFragment mFragment4=new AccountFragment();
		mFragments.add(mFragment0);
		mFragments.add(mFragment1);
		mFragments.add(mFragment2);
		mFragments.add(mFragment3);
		mFragments.add(mFragment4);			
	}
	private class ViewPagerAdapter extends FragmentPagerAdapter {	
		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}
		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub	
			return mFragments.get(position);
		}	
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mFragments.size();
		}	
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.guide_home:
			mViewPager.setCurrentItem(0, false);
			changTab(0);
			break;
		case R.id.guide_tfaccount:
			mViewPager.setCurrentItem(1, false);
			changTab(1);
			break;		
		case R.id.guide_nearby:
			mViewPager.setCurrentItem(2, false);
			changTab(2);
			break;
		case R.id.guide_cart:
			mViewPager.setCurrentItem(3, false);
			changTab(3);
			break;
		case R.id.guide_account:
			mViewPager.setCurrentItem(4, false);
			changTab(4);
			break;

		default:
			break;
		}		
	}	
	private void changTab(int position) {
		if(position==0){
			changeTabIcon(0,0);
		}else{
			changeTabIcon(0,1);	
		}
		if(position==1){
			changeTabIcon(1,0);
		}else{
			changeTabIcon(1,1);	
		}
		if(position==2){
			changeTabIcon(2,0);
		}else{
			changeTabIcon(2,1);
		}
		if(position==3){
			changeTabIcon(3,0);
		}else{
			changeTabIcon(3,1);
		}
		if(position==4){
			changeTabIcon(4,0);
		}else{
			changeTabIcon(4,1);	
		}
	}
	private void changeTabIcon(int position, int status) {
		// TODO Auto-generated method stub
		Drawable mIcon = null;
		Integer tabOnPicId[]={R.drawable.guide_home_on,R.drawable.guide_tfaccount_on,R.drawable.guide_nearby_on,R.drawable.guide_cart_on,R.drawable.guide_account_on};
		Integer tabNmPicId[]={R.drawable.guide_home_nm,R.drawable.guide_tfaccount_nm,R.drawable.guide_nearby_nm,R.drawable.guide_cart_nm,R.drawable.guide_account_nm};
		if(status==0){
			mIcon=getResources().getDrawable(tabOnPicId[position]);
			tabs.get(position).setTextColor(Color.parseColor("#ff5304"));
		}
		if(status==1){
			mIcon=getResources().getDrawable(tabNmPicId[position]);
			tabs.get(position).setTextColor(Color.parseColor("#626770"));
		}		
		mIcon.setBounds(0, 0, mIcon.getMinimumWidth(), mIcon.getMinimumHeight());
		tabs.get(position).setCompoundDrawables(null, mIcon, null, null); 		
	}
	
}