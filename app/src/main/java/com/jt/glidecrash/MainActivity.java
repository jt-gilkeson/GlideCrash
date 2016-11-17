package com.jt.glidecrash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		if (savedInstanceState == null)
		{
			MasterFragment frag = MasterFragment.newInstance();

			getSupportFragmentManager()
					.beginTransaction()
					.add(android.R.id.content, frag, null)
					.commit();
		}
	}
}
