package company.com.happy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import company.com.happy.fragment.FragmentA;
import company.com.happy.fragment.FragmentB;
import company.com.happy.fragment.FragmentC;
import company.com.happy.fragment.FragmentD;

/**
 * Created by Administrator on 2017/6/15 0015.
 */


public class MyFragmentAdapter extends FragmentPagerAdapter {
     private List<Fragment> fragmentsList;
    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
        fragmentsList=new ArrayList<Fragment>();
        fragmentsList.add(new FragmentA());
        fragmentsList.add(new FragmentB());
        fragmentsList.add(new FragmentC());
        fragmentsList.add(new FragmentD());
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
