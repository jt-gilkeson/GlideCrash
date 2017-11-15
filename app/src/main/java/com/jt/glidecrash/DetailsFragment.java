package com.jt.glidecrash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by JT on 11/16/2016.
 */
public class DetailsFragment extends Fragment
{
	public static DetailsFragment newInstance()
	{
		Bundle args = new Bundle();
		
		DetailsFragment fragment = new DetailsFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_details, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		ImageView iv = (ImageView)view.findViewById(R.id.glide_image);
		Glide.with(this).load("http://www.ssaurel.com/blog/wp-content/uploads/2016/04/glide_logo.png").into(iv);
	}
}
