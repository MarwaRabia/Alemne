package com.example.alemne;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.example.alemne.adapter.CategoryFragmentPagerAdapter;
import com.example.alemne.ui.fragment.CourseFragment;
import com.google.android.material.tabs.TabLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_page_toolbar)
    Toolbar mMainAppToolbar;
   @BindView(R.id.tablayout_id)
    TabLayout mTablayoutId;
    @BindView(R.id.viewpager_id)
    ViewPager mViewpagerId;
    CategoryFragmentPagerAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mMainAppToolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
       getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        createTabFragment();

    }




    private void createTabFragment() {
        adapter=new CategoryFragmentPagerAdapter(this,getSupportFragmentManager());
        mViewpagerId.setAdapter(adapter);
        mViewpagerId.setCurrentItem(adapter.getCount()-1);
        mTablayoutId.setupWithViewPager(mViewpagerId);
    }


}