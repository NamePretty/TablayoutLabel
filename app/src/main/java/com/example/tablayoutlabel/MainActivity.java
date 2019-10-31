package com.example.tablayoutlabel;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.tablayoutlabel.adapter.FmPagerAdapter;
import com.example.tablayoutlabel.fragment.TabFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FmPagerAdapter pagerAdapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"最新","热门","我的"};
    private String[] pictext = new String[]{"25","15","0"};
    private int[] pics = new int[]{R.mipmap.subtitle_left_roll_h,R.mipmap.subtitle_middle_roll_h,R.mipmap.subtitle_right_roll_h};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        for(int i=0;i<titles.length;i++){
            fragments.add(new TabFragment());
            tabLayout.addTab(tabLayout.newTab());
        }

        tabLayout.setupWithViewPager(viewPager,false);
        pagerAdapter = new FmPagerAdapter(fragments,getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        for(int i=0;i<titles.length;i++){
            tabLayout.getTabAt(i).setText(titles[i]);
            tabLayout.getTabAt(i).setCustomView(makeTabViewText(i));
        }
    }


    /**
     * 引入布局设置图标和标题
     * @param position
     * @return
     */
    private View makeTabViewText(int position){
        View tabView = LayoutInflater.from(this).inflate(R.layout.tab_text_value,null);
        TextView textView = tabView.findViewById(R.id.textview);
        TextView textviewValue = tabView.findViewById(R.id.textview_value);
        textView.setText(titles[position]);
        textviewValue.setText(pictext[position]);
        if(position==0){
            textviewValue.setTextColor(getResources().getColor(R.color.colorAccent));
        }else if(position==1){
            textviewValue.setTextColor(getResources().getColor(R.color.colorPrimary));
        }else {
            textviewValue.setTextColor(getResources().getColor(R.color.yellow));
        }
        return tabView;
    }
}
