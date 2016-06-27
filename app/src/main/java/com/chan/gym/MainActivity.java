package com.chan.gym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.chan.gym.activities.SearchActivity;
import com.chan.gym.adapter.MainViewPagerAdapter;
import com.chan.gym.fragment.JihuaFragment;
import com.chan.gym.fragment.ShouyeFragment;
import com.chan.gym.fragment.YudingFragment;
import com.chan.gym.navi_activities.GoodActivity;
import com.chan.gym.navi_activities.LocationActivity;
import com.chan.gym.navi_activities.MessageActivity;
import com.chan.gym.navi_activities.RecorderActivity;
import com.chan.gym.navi_activities.SettingsActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 		initToolBar();
		initTabLayout();
		initNavigationView();
	}
	private void initToolBar() {
		Toolbar tb_main_content = (Toolbar) findViewById(R.id.tb_main_content);
		tb_main_content.setTitle("");
		setSupportActionBar(tb_main_content);

		tb_main_content
				.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						if (item.getItemId() == R.id.search) {
							startActivity(new Intent(MainActivity.this,
									SearchActivity.class));
						}
						return true;
					}
				});

		final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout_main);

		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
				tb_main_content, R.string.navigation_drawer_open,
				R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();

	}

	private void initNavigationView() {
		final NavigationView navigationView = (NavigationView) findViewById(R.id.nv_main);
		navigationView.inflateMenu(R.menu.navigation_menu);
		navigationView.setBackgroundColor(getResources()
				.getColor(R.color.white));
		navigationView.setItemIconTintList(null);
		// 设置监听，返回false则navigation的item不可以被选择,返回true则可以被选择
		navigationView
				.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
					@Override
					public boolean onNavigationItemSelected(MenuItem item) {
						switch (item.getItemId()) {
							case R.id.item_message :
								startActivity(new Intent(MainActivity.this,
										MessageActivity.class));
								break;
							case R.id.item_recorder :
								startActivity(new Intent(MainActivity.this,
										RecorderActivity.class));
								break;
							case R.id.item_location :
								startActivity(new Intent(MainActivity.this,
										LocationActivity.class));
								break;
							case R.id.item_good :
								startActivity(new Intent(MainActivity.this,
										GoodActivity.class));
								break;
							case R.id.item_setting :
								startActivity(new Intent(MainActivity.this,
										SettingsActivity.class));

								break;
							default :
								break;
						}
						return true;
					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_tb_menu, menu);
		return true;
	}

	private void initTabLayout() {
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout_main_content);
		ViewPager viewPager = (ViewPager) findViewById(R.id.vp_main_content);

		String[] tabTitleArray = new String[]{"首页", "预定", "计划"};

		/* 先初始化tab再初始化viewpager */
		List<Fragment> fragmentList = new ArrayList<>();
		ShouyeFragment shouyeFragment = new ShouyeFragment();
		YudingFragment yudingFragment = new YudingFragment();
		JihuaFragment jihuaFragment = new JihuaFragment();

		fragmentList.add(shouyeFragment);
		fragmentList.add(yudingFragment);
		fragmentList.add(jihuaFragment);

		MainViewPagerAdapter adapter = new MainViewPagerAdapter(
				getSupportFragmentManager(), fragmentList, tabTitleArray);
		viewPager.setAdapter(adapter);

		tabLayout.setupWithViewPager(viewPager);

	}
}
