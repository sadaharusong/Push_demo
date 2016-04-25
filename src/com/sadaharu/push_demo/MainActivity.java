package com.sadaharu.push_demo;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);
		JPushInterface.setAlias(this, "test123456", new TagAliasCallback()
		{
			
			@Override
			public void gotResult(int arg0, String arg1, Set<String> arg2)
			{
				// TODO Auto-generated method stub
				Log.d("tag", "set alias result is :" + arg0);
			}
		});
		Set <String> sets = new HashSet<>();
		sets.add("sports");
		sets.add("game");
		JPushInterface.setTags(this, sets, new TagAliasCallback()
		{
			
			@Override
			public void gotResult(int arg0, String arg1, Set<String> arg2)
			{
				// TODO Auto-generated method stub
				Log.d("tag", "set tags result is :" + arg0);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
