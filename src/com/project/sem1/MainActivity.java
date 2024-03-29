package com.project.sem1;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity implements
ActionBar.TabListener {

private ViewPager viewPager;
private ActionBar actionBar;
private TabPagerAdapter tabPagerAdapter;
private String[] tabs = { "Courses", "Map" };
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
viewPager = (ViewPager) findViewById(R.id.pager);
tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
viewPager.setAdapter(tabPagerAdapter);
actionBar = getActionBar();
actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
for (String tab_name : tabs) {
    actionBar.addTab(actionBar.newTab().setText(tab_name)
            .setTabListener(this));
}

viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

    /**
     * on swipe select the respective tab
     * */
    @Override
    public void onPageSelected(int position) {
        actionBar.setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) { }

    @Override
    public void onPageScrollStateChanged(int arg0) { }
});
}

@Override
public void onTabReselected(Tab tab, FragmentTransaction ft) { }

@Override
public void onTabSelected(Tab tab, FragmentTransaction ft) {
viewPager.setCurrentItem(tab.getPosition());
}

@Override
public void onTabUnselected(Tab tab, FragmentTransaction ft) {}
}