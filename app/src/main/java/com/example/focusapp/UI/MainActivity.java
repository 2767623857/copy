package com.example.focusapp.UI;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.focusapp.A_F.Fragment_mine;
import com.example.focusapp.A_F.Fragment_notes;
import com.example.focusapp.A_F.Fragment_record;
import com.example.focusapp.A_F.Fragment_tomato;
import com.example.focusapp.DAO.DatabaseHelper;
import com.example.focusapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 *  TODO：负责app界面下方四个按钮
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager mviewPager;
    private FragmentPagerAdapter mAdapter;//fragment适配器，适配器数据为fragment的list
    private List<Fragment> mfragment;//存放fragment的list

    private LinearLayout fragment_mine;//四个页面对应fragment
    private LinearLayout fragment_tomato;
    private LinearLayout fragment_record;
    private LinearLayout fragment_notes;

    private ImageButton mImgTomato;//底部tab按钮
    private ImageButton mImgNotes;
    private ImageButton mImgRecord;
    private ImageButton mImgMine;

    private TextView mTvTomato;
    private TextView mTvNotes;
    private TextView mTvRecord;
    private TextView mTvMine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper helper=new DatabaseHelper(this);
        helper.getWritableDatabase();
        initView();//初始化页面
        initEvents();//初始化点击事件
        initDatas();
    }

    private void initDatas() {
        mfragment = new ArrayList<>();
        mfragment.add(new Fragment_tomato());
        mfragment.add(new Fragment_notes());
        mfragment.add(new Fragment_record());
        mfragment.add(new Fragment_mine());
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {//返回当前fragment
                return mfragment.get(position);
            }

            @Override
            public int getCount() {
                return mfragment.size();
            }
        };
        mviewPager.setAdapter(mAdapter);//设置viewpager的数据适配器
        //页面切换监听
        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {}
            @Override//页面选中
            public void onPageSelected(int position) {
                mviewPager.setCurrentItem(position);
                resetImgs();//将所有tab图标置为未选中图标
                selectTab(position);//检测被点击的tab，并将对应tab图标置为被选中图标
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initEvents() {
        fragment_mine.setOnClickListener(this);
        fragment_notes.setOnClickListener(this);
        fragment_record.setOnClickListener(this);
        fragment_tomato.setOnClickListener(this);
    }

    private void initView() {
        mviewPager = findViewById(R.id.id_viewpager);

        fragment_tomato = findViewById(R.id.id_tab_tomato);
        fragment_record = findViewById(R.id.id_tab_record);
        fragment_notes = findViewById(R.id.id_tab_notes);
        fragment_mine = findViewById(R.id.id_tab_mine);

        mImgTomato = findViewById(R.id.id_tab_tomato_img);
        mImgNotes = findViewById(R.id.id_tab_notes_img);
        mImgRecord = findViewById(R.id.id_tab_record_img);
        mImgMine = findViewById(R.id.id_tab_mine_img);

        mTvTomato = findViewById(R.id.tv_text_tomato);
        mTvNotes = findViewById(R.id.tv_text_notes);
        mTvRecord = findViewById(R.id.tv_text_record);
        mTvMine = findViewById(R.id.tv_text_mine);

    }

    @Override
    public void onClick(View v) {
        resetImgs();
        switch (v.getId()){
            case R.id.id_tab_tomato:
                selectTab(0);
                break;
            case R.id.id_tab_notes:
                selectTab(1);
                break;
            case R.id.id_tab_record:
                selectTab(2);
                break;
            case R.id.id_tab_mine:
                selectTab(3);
                break;

        }
    }

    private void selectTab(int i) {
        switch (i){
            case 0:
                mImgTomato.setBackgroundResource(R.drawable.tomoto_press);
                mTvTomato.setTextColor(Color.parseColor("#DC143C"));
                break;
            case 1:
                mImgNotes.setBackgroundResource(R.drawable.note_press);
                mTvNotes.setTextColor(Color.parseColor("#DC143C"));
                break;
            case 2:
                mImgRecord.setBackgroundResource(R.drawable.record_press);
                mTvRecord.setTextColor(Color.parseColor("#DC143C"));
                break;
            case 3:
                mImgMine.setBackgroundResource(R.drawable.mine_press);
                mTvMine.setTextColor(Color.parseColor("#DC143C"));
                break;
        }
        //将通过按压tab得到的页面序号传回，并将其设置为当前页面，即完成页面切换
        mviewPager.setCurrentItem(i);
    }

    private void resetImgs(){
        mImgTomato.setBackgroundResource(R.drawable.black_tomota);
        mImgNotes.setBackgroundResource(R.drawable.note_black);
        mImgRecord.setBackgroundResource(R.drawable.record_black);
        mImgMine.setBackgroundResource(R.drawable.mine_black);

        mTvTomato.setTextColor(Color.parseColor("#000000"));
        mTvNotes.setTextColor(Color.parseColor("#000000"));
        mTvRecord.setTextColor(Color.parseColor("#000000"));
        mTvMine.setTextColor(Color.parseColor("#000000"));

    }

}

