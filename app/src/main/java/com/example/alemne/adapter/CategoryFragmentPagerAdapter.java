package com.example.alemne.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.alemne.pojo.WebModel;
import com.example.alemne.ui.fragment.CourseFragment;
import com.example.alemne.ui.fragment.Freelancer;
import com.example.alemne.ui.fragment.LibraryFragments;
import com.example.alemne.ui.fragment.Sharea;

import java.util.ArrayList;

public class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public CategoryFragmentPagerAdapter(Context context,@NonNull FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new Freelancer();

        }
        else if (position == 1)
        {
            fragment = new LibraryFragments();

        }
        else if (position == 2)
        {
            fragment = new CourseFragment();


        }

        else if (position == 3)
        {
            fragment = new Sharea();


        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "العمل الحر(freelancer)";

        }
        else if (position == 1)
        {
            title = "قراءة ومكتبات";

        }
        else if (position == 2)
        {
            title = "مواقع";

        }
        else if (position == 3)
        {
            title = "اكاديميات و مبادرات ";

        }
        return title;
    }




}
