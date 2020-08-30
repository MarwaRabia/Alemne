package com.example.alemne.ui.fragment;


import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

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
import com.example.alemne.pojo.WebModel;
import com.example.alemne.adapter.WebAdapter;

import java.util.ArrayList;

public class LibraryFragments extends Fragment {

    RecyclerView mMRecycler;
    View rootView;
    WebAdapter webAdapter;
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
            getLibraryModel();
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
    private ArrayList<WebModel> getLibraryModel() {
        arr.add(new WebModel(R.drawable.osboha,R.string.osbohan,R.string.osbohad,"https://www.facebook.com/osboha180"));
        arr.add(new WebModel(R.drawable.shaaa,R.string.shamln,R.string.shamld,"https://shamela.ws/index.php/categories"));
        arr.add(new WebModel(R.drawable.waqfeea,R.string.waqfeean,R.string.waqfeead,"http://www.waqfeya.com/"));
        arr.add(new WebModel(R.drawable.noord,R.string.noorn,R.string.noord,"https://www.noor-book.com/"));
        arr.add(new WebModel(R.drawable.misl,R.string.shan,R.string.shad,"https://www.muslim-library.com/about-us-ar/?lang=Arabic"));
        arr.add(new WebModel(R.drawable.digitallibrary,R.string.digitallibraryn,
                R.string.digitallibraryd,"https://www.wdl.org/ar/"));
        arr.add(new WebModel(R.drawable.kotob,R.string.kotobn,R.string.kotobd,"https://www.kutub.info/about"));
        arr.add(new WebModel(R.drawable.maktaba,R.string.maktaban,R.string.maktabad,"https://books-library.online/"));
        arr.add(new WebModel(R.drawable.boo,R.string.booksn,R.string.booksd,"https://www.pdf-books.org/"));
        arr.add(new WebModel(R.drawable.juce,R.string.jucen,R.string.juced,"https://www.booksjuice.com/"));
        arr.add(new WebModel(R.drawable.ketabe,R.string.ketaben,R.string.ketabed,"https://www.mybook4u.com/"));
        arr.add(new WebModel(R.drawable.rashff,R.string.rashfn,R.string.rashfd,"https://rashf.com/"));
        arr.add(new WebModel(R.drawable.book,R.string.bpdfn,R.string.bpdfd,"https://www.kutub-pdf.net/"));

//        arr.add(new WebModel(R.drawable.,R.string.,R.string.,""));
//        arr.add(new WebModel(R.drawable.,R.string.,R.string.,""));
        return  arr;
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
