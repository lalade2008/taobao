package com.lala.taobao.fragment;

import com.lala.taobao.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment{
	View rootView ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView =inflater.inflate(R.layout.mainfragment, null);
		
		return rootView;
	}

}
