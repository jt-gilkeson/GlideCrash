package com.jt.glidecrash;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by JT on 11/16/2016.
 */
public class MasterFragment extends Fragment
{
	// Workaround for google support library bug
	// https://code.google.com/p/android/issues/detail?id=74222
	protected FragmentManager mGogoChildFragmentManager = null;

	public static MasterFragment newInstance()
	{
		Bundle args = new Bundle();

		MasterFragment fragment = new MasterFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setRetainInstance(true);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_master, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		Button createDetails = (Button)view.findViewById(R.id.load_details_button);

		createDetails.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				DetailsFragment frag = DetailsFragment.newInstance();
				loadFragment(frag);
			}
		});
	}

	@Override
	public void onAttach(Context context)
	{
		// Deal with google support library bug
//		if (mGogoChildFragmentManager != null)
//		{
//			try
//			{
//				Field childField = Fragment.class.getDeclaredField("mChildFragmentManager");
//				childField.setAccessible(true);
//				childField.set(this, mGogoChildFragmentManager);
//			}
//			catch (Exception e)
//			{
//				e.printStackTrace();
//			}
//		}

		super.onAttach(context);
	}

	void loadFragment(Fragment frag)
	{
		FragmentTransaction ft = getChildFragmentManager().beginTransaction();
		ft.replace(R.id.fragment_holder, frag, null);
		ft.commitAllowingStateLoss();
	}

//	protected FragmentManager getGogoChildFragmentManager()
//	{
//		if (mGogoChildFragmentManager == null)
//		{
//			mGogoChildFragmentManager = getChildFragmentManager();
//		}
//
//		return mGogoChildFragmentManager;
//	}

}
