package company.com.happy.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import company.com.happy.R;

public class MainActivity extends Activity {

    //头部
    @BindView(R.id.ll_header_left_container)
    LinearLayout cityContainer;
    @BindView(R.id.tv_header_main_city)
    TextView tvCity;//显示城市名称
    @BindView(R.id.iv_header_main_add)
    ImageView ivAdd;
    @BindView(R.id.menu_layout)
    View menulayout;


    //中段
    @BindView(R.id.ptrlv_main)
    PullToRefreshListView ptrListView;
    ListView listView;
    List<String> datas;
    ArrayAdapter<String> adapter;

    //脚部
    @BindView(R.id.rg_main_footer)
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initalListView();
    }

    @OnClick(R.id.ll_header_left_container)
    public void jumpToCity(View view) {
        Intent intent = new Intent(this, CityActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.iv_header_main_add)
    public void toggleMenu(View view) {
        if (menulayout.getVisibility() == View.VISIBLE) {
            menulayout.setVisibility(View.INVISIBLE);
        } else {
            menulayout.setVisibility(View.VISIBLE);
        }
    }


    private void initalListView() {
        listView = ptrListView.getRefreshableView();
        datas = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
         //为listview添加若干个头部
        LayoutInflater inflater = LayoutInflater.from(this);
        View listHeaderIcons = inflater.inflate(R.layout.header_list_icons, listView, false);
        View listHeaderSquares = inflater.inflate(R.layout.header_list_square, listView, false);
        View listHeaderAds = inflater.inflate(R.layout.header_list_ads, listView, false);
        View listHeaderRecommend = inflater.inflate(R.layout.header_list_recommend, listView, false);
        View listHeaderCategories = inflater.inflate(R.layout.header_list_categories, listView, false);

        listView.addHeaderView(listHeaderIcons);
        listView.addHeaderView(listHeaderSquares);
        listView.addHeaderView(listHeaderAds);
        listView.addHeaderView(listHeaderRecommend);
        listView.addHeaderView(listHeaderCategories);

        listView.setAdapter(adapter);
        initListHeaderIcons(listHeaderIcons);
        //添加下拉松手后的刷新
        ptrListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datas.add(0, "新增内容");
                        adapter.notifyDataSetChanged();
                        ptrListView.onRefreshComplete();
                    }
                }, 1500);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView abslistview, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView abslistview, int i, int i1, int i2) {
          if(i==0){
              cityContainer.setVisibility(View.VISIBLE);
              ivAdd.setVisibility(View.VISIBLE);

          }else{
              cityContainer.setVisibility(View.GONE);
              ivAdd.setVisibility(View.GONE);
          }
            }
        });
    }
    private void initListHeaderIcons(View listHeaderIcons){
        final ViewPager pager= (ViewPager) listHeaderIcons.
                findViewById(R.id.vp_header_list_icons);

        final PagerAdapter adapter=new PagerAdapter() {
            int[]resID=new int[]{
                    R.layout.icons_list_1,
                    R.layout.icons_list_2,
                    R.layout.icons_list_3,
            };
            @Override
            public int getCount() {
                return 30000;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                int layoutId=resID[position%3];
                View view=LayoutInflater.from(MainActivity.this).
                        inflate(layoutId,pager,false);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        };
        pager.setAdapter(adapter);
        pager.setCurrentItem(15000);
        final ImageView iv1 = (ImageView) listHeaderIcons.findViewById(R.id.iv_header_list_icons_indicator1);
        final ImageView iv2 = (ImageView) listHeaderIcons.findViewById(R.id.iv_header_list_icons_indicator2);
        final ImageView iv3 = (ImageView) listHeaderIcons.findViewById(R.id.iv_header_list_icons_indicator3);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                iv1.setImageResource(R.drawable.banner_dot);
                iv2.setImageResource(R.drawable.banner_dot);
                iv3.setImageResource(R.drawable.banner_dot);
                switch (position%3){
                    case 0:
                        iv1.setImageResource(R.drawable.banner_dot_pressed);
                        break;
                    case 1:
                        iv2.setImageResource(R.drawable.banner_dot_pressed);
                        break;
                    case 2:
                        iv3.setImageResource(R.drawable.banner_dot_pressed);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {
        datas.add("aaa");
        datas.add("bbb");
        datas.add("ccc");
        datas.add("ddd");
        datas.add("eee");
        datas.add("fff");
        datas.add("ggg");
        datas.add("hhh");
        datas.add("jjj");
        adapter.notifyDataSetChanged();

    }
}
