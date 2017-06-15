package company.com.happy.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import company.com.happy.R;
import company.com.happy.adapter.MyFragmentAdapter;


public class GuideActivity extends FragmentActivity {
@BindView(R.id.viewPager_Guide)
   ViewPager viewPager;
    MyFragmentAdapter adpter;
    @BindView(R.id.indicator)
    CirclePageIndicator indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initViewPager();

    }
    private void initViewPager(){
        adpter=new MyFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adpter);
        indicator.setViewPager(viewPager);
//        final float density = getResources().getDisplayMetrics().density;
//        indicator.setBackgroundColor(669900);
//        indicator.setRadius(10 * density);
//        indicator.setPageColor(0x880000FF);
//        indicator.setFillColor(0x99669988);
//        indicator.setStrokeColor(0xFF000000);
//        indicator.setStrokeWidth(2 * density);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==3){
                    indicator.setVisibility(View.INVISIBLE);
                }else{
                    indicator.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
