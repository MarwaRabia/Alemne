package com.example.alemne.ui.fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import com.example.alemne.About;
import com.example.alemne.R;
import com.example.alemne.adapter.CategoryFragmentPagerAdapter;
import com.example.alemne.pojo.WebModel;
import com.example.alemne.adapter.WebAdapter;

import java.util.ArrayList;
public class CourseFragment extends Fragment  {
    WebAdapter webAdapter;
    RecyclerView mMRecycler;
    ArrayList <WebModel>arr=new ArrayList();
    SearchView mSearchView;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (rootView==null){

       rootView = inflater.inflate(R.layout.main_fragment, container, false);
            mMRecycler=rootView.findViewById(R.id.mRecycler);
            webAdapter=new WebAdapter(getActivity());
            arr.clear();
            getCourseModel();
            webAdapter.setListmodel(arr);
            mMRecycler.setAdapter(webAdapter);
            LinearLayoutManager manager=new LinearLayoutManager(getActivity());
            mMRecycler.setLayoutManager(manager);
        }

        return rootView;
    }


    private void getCourseModel() {
        arr.add(new WebModel(R.drawable.coursera,R.string.courseran,R.string.courserad,
                "https://www.coursera.org/"));
        arr.add(new WebModel(R.drawable.udemy,R.string.udemyn,R.string.udemyd,"https://www.udemy.com/"));
        arr.add(new WebModel(R.drawable.edx,R.string.edxn,R.string.edxd,"https://www.edx.org/"));
        arr.add(new WebModel(R.drawable.udacity,R.string.udacityn,R.string.udacityd,"https://www.udacity.com/"));
        arr.add(new WebModel(R.drawable.lynda,R.string.lyndan,R.string.lyndad,"https://www.lynda.com/"));
        arr.add(new WebModel(R.drawable.futurelearn,R.string.futurelearnn,R.string.futurelearnd,"https://www.futurelearn.com/"));
        arr.add(new WebModel(R.drawable.alison,R.string.alisonn,R.string.alisond,"https://alison.com/"));
        arr.add(new WebModel(R.drawable.codecademy,R.string.codecademyn,R.string.codecademyd,"http://www.codecademy.com"));
        arr.add(new WebModel(R.drawable.iversity,R.string.iversityn,R.string.iversityd,"https://iversity.org/en"));
        arr.add(new WebModel(R.drawable.openlrarn,R.string.openlrarnn,R.string.openlrarnd,"https://www.open.edu/openlearn/free-courses/full-catalogue"));
        arr.add(new WebModel(R.drawable.khanacademy,R.string.khanacademyn,R.string.khanacademyd,"https://www.khanacademy.org/"));
        arr.add(new WebModel(R.drawable.tutorialspoint,R.string.tutorialspointn,R.string.tutorialspointd,"https://www.tutorialspoint.com/index.htm"));
        arr.add(new WebModel(R.drawable.rwaq,R.string.rwaqn,R.string.rwaqd,"https://www.rwaq.org/"));
        arr.add(new WebModel(R.drawable.edrak,R.string.edrakn,R.string.edrakd,"https://www.edraak.org"));
        arr.add(new WebModel(R.drawable.mahara,R.string.maharahn,R.string.maharahd,"https://www.maharah.net"));
        arr.add(new WebModel(R.drawable.sadeem,R.string.sdeemn,R.string.sdeemd,"https://www.sdeem.org"));
        arr.add(new WebModel(R.drawable.nadrus,R.string.nadrusn,R.string.nadrusd,"https://www.nadrus.com/"));
        arr.add(new WebModel(R.drawable.droob,R.string.doroobn,R.string.doroobd,"https://www.doroob.sa/ar/individuals/elearning/"));
        arr.add(new WebModel(R.drawable.nafham,R.string.nafhamn,R.string.nafhamd,"https://lifeskills.nafham.com/"));
        arr.add(new WebModel(R.drawable.edlal,R.string.edlaln,R.string.edlald,"https://www.edlal.org/"));
        arr.add(new WebModel(R.drawable.hassona,R.string.hassounan,R.string.hassounad,"https://www.hassouna-academy.com/index"));
        arr.add(new WebModel(R.drawable.khanacademy,R.string.khanacademyrn,R.string.khanacademyard,"https://ar.khanacademy.org"));
        arr.add(new WebModel(R.drawable.teracourses,R.string.teracoursesn,R.string.teracoursesd,"https://teracourses.com"));
        arr.add(new WebModel(R.drawable.hassob,R.string.hsoubn,R.string.hsoubd,"https://academy.hsoub.com/"));
        arr.add(new WebModel(R.drawable.google,R.string.googlen,R.string.googleld,"https://learndigital.withgoogle.com/maharatgoogle\n"));
        arr.add(new WebModel(R.drawable.refd,R.string.refdn,R.string.refdd,"http://refdacademy.com/news"));
        arr.add(new WebModel(R.drawable.tamkeen,R.string.tamkeenn,R.string.tamkeend,"https://tamkeen-edu.org/"));
        arr.add(new WebModel(R.drawable.sun,R.string.sunn,R.string.sunnahd,"https://shamsunalarabia.net/"));
        arr.add(new WebModel(R.drawable.business,R.string.businessn,R.string.businessd,"https://www.e3melbusiness.com/"));
//     arr.add(new WebModel(R.drawable.,R.string.,R.string.,""));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMRecycler=rootView.findViewById(R.id.mRecycler);
            setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menuitem, menu);
        try {
            MenuItem searchItem = menu.findItem(R.id.mSearch);
             mSearchView= (SearchView) searchItem.getActionView();
            mSearchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
            mSearchView.setQuery("",false);
            mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                    return false;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    webAdapter.getFilter().filter(newText);
                    return false;
                }
            });


            mSearchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean queryTextFocused) {
                    if(!queryTextFocused) {
                        searchItem.collapseActionView();
                        mSearchView.setQuery("", false);
                    }
                }
            });
        }
    catch (Exception e){

    }
        super.onCreateOptionsMenu(menu, inflater);
    }


        @Override
    public boolean onOptionsItemSelected(MenuItem item) {

     if (item.getItemId()==R.id.mShare){
            share();
            return true;
        }
        else if(item.getItemId()==R.id.minfo) {
            info();
            return true;
        }
        else{
            return super.onOptionsItemSelected(item);

        }

    }

    private void info() {
        Intent i=new Intent(getActivity(), About.class);
        startActivity(i);
    }

    private void share() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = getResources().getString(R.string.share_body2)+"";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "تطبيق علمني");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

//    private void search(MenuItem item) {
//
//
//        mSearchView= (SearchView) item.getActionView();
//        mSearchView.setQueryHint("search here");
//        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//               webAdapter.getFilter().filter(newText);
//                System.out.println(newText);
//                return false;
//            }
//        });
//    }




}