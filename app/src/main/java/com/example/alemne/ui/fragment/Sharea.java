package com.example.alemne.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alemne.About;
import com.example.alemne.R;
import com.example.alemne.adapter.WebAdapter;
import com.example.alemne.pojo.WebModel;

import java.util.ArrayList;

 public class Sharea extends Fragment {

     WebAdapter webAdapter;
    RecyclerView mMRecycler;
    View rootView;
     ArrayList <WebModel>arr=new ArrayList();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (rootView==null){

            rootView = inflater.inflate(R.layout.main_fragment, container, false);
            mMRecycler=rootView.findViewById(R.id.mRecycler);
            webAdapter=new WebAdapter(getActivity());
            arr.clear();
           getacademyModel();
            webAdapter.setListmodel(arr);
            mMRecycler.setAdapter(webAdapter);
            LinearLayoutManager manager=new LinearLayoutManager(getActivity());
            mMRecycler.setLayoutManager(manager);
        }

        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);

//        mMRecycler=rootView.findViewById(R.id.mRecycler);
//         webAdapter=new WebAdapter(getActivity());
//        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//        // TODO: Use the ViewModel
//        mViewModel.mArrayListMutableLiveData.observe(getActivity(), new Observer<ArrayList<WebModel>>() {
//            @Override
//            public void onChanged(ArrayList<WebModel> webModels) {
//                webAdapter.setListmodel(webModels);
//            }
//        });
//        mMRecycler.setAdapter(webAdapter);
//        mMRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mViewModel.getacadmy();


    }
     @Override
     public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
         inflater.inflate(R.menu.menuitem, menu);
         try {
             MenuItem searchItem = menu.findItem(R.id.mSearch);
             SearchView mSearchView= (SearchView) searchItem.getActionView();
             mSearchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
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
     private void  getacademyModel() {
         try {
             arr.add(new WebModel(R.drawable.inhqraan,R.string.inhqraann,R.string.inhqraand,"https://www.itsthequran.com/"));
             arr.add(new WebModel(R.drawable.tafseer,R.string.tafsiracademyn,R.string.tafsiracademyd,"https://tafsiracademy.com/mod/resource/view.php?id=1054"));
             arr.add(new WebModel(R.drawable.acade,R.string.acaden,R.string.acadend,"https://benaa.islamacademy.net"));
             arr.add(new WebModel(R.drawable.sona,R.string.sunnahn,R.string.sunnahd,"https://tsunnah.com/"));
             arr.add(new WebModel(R.drawable.dalailcentre,R.string.dalailcentren,R.string.dalailcentred,"https://dalailcentre.com/about"));
             arr.add(new WebModel(R.drawable.jeel,R.string.jeeln,R.string.jeeld,"https://jeelacademy.com/"));
             arr.add(new WebModel(R.drawable.masged,R.string.masgedn,R.string.masgedd,"http://gph.edu.sa/public/?page=page_382463"));
             arr.add(new WebModel(R.drawable.zad,R.string.zadn,R.string.zadid,"https://www.zad-academy.com/"));
             arr.add(new WebModel(R.drawable.elsahwa,R.string.elsahwan,R.string.elsahwad,"https://www.facebook.com/elsahwaedu/"));
             arr.add(new WebModel(R.drawable.mahoer,R.string.mahoern,R.string.mahoerd,"https://almohawer.org/"));
             arr.add(new WebModel(R.drawable.taaa,R.string.taan,R.string.taad,"https://learningislam.com"));
             arr.add(new WebModel(R.drawable.amod,R.string.sheikhalamoudn,R.string.sheikhalamoudd,"https://sheikhalamoud.org/about"));
             arr.add(new WebModel(R.drawable.zadi,R.string.zadin,R.string.zadid,"https://zadi.net/"));
             arr.add(new WebModel(R.drawable.modaker,R.string.modakern,R.string.modakerd,"https://www.moddaker.com/"));
//        arr.add(new WebModel(R.drawable.,R.string.,R.string.,""));
//        arr.add(new WebModel(R.drawable.,R.string.,R.string.,""));
         }
         catch (Exception e){

         }


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

 }
