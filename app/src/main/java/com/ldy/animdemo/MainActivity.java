package com.ldy.animdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.ldy.animdemo.fragment.FAnimatorSet;
import com.ldy.animdemo.fragment.FObjectAnimator;
import com.ldy.animdemo.fragment.FPropertyValueHolder;
import com.ldy.animdemo.fragment.FTypeEvaluator;
import com.ldy.animdemo.fragment.FValueAnimator;
import com.ldy.animdemo.fragment.FViewPropertyAnimator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by ldy on 2015/11/21.
 */
public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        setOverflowShowingAlways();
    }

    static class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> list = getList();

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {}

        private ArrayList<Fragment> getList() {
            ArrayList<Fragment> list = new ArrayList<>();
            list.add(new FObjectAnimator());  // ObjectAnimator
            list.add(new FValueAnimator()); // ValueAnimator
            list.add(new FAnimatorSet()); // AnimatorSet    xml: AnimatorInflater
            list.add(new FPropertyValueHolder()); // PropertyValuesHolder、Keyframe
            list.add(new FTypeEvaluator());  // FTypeEvaluator
            list.add(new FViewPropertyAnimator());  // ViewPropertyAnimator、 Interpolator
            return list;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    private void setOverflowShowingAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
