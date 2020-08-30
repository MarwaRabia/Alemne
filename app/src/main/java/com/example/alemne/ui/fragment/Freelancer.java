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

import static android.content.ContentValues.TAG;

public class Freelancer  extends Fragment {

    WebAdapter webAdapter;
    RecyclerView mMRecycler;
    ArrayList <WebModel>arr=new ArrayList();
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
            getafreeModel();
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
////        mMRecycler.setRotation(180);
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
//        mViewModel.getWebfree();
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
    private void getafreeModel () {
        arr.add(new WebModel(R.drawable.freelancer,R.string.freelancern,R.string.freelancerd,"https://www.freelancer.com/"));
        arr.add(new WebModel(R.drawable.fiverrl,R.string.fiverrn,R.string.fiverrd,"https://www.fiverr.com/"));
        arr.add(new WebModel(R.drawable.upwork,R.string.upworkn,R.string.upworkd,"https://www.upwork.com/"));
        arr.add(new WebModel(R.drawable.khmassat,R.string.khamsatn,R.string.khamsatd,"https://khamsat.com/"));
        arr.add(new WebModel(R.drawable.mosql,R.string.mostaqln,R.string.mostaqld,"https://mostaql.com/"));
        arr.add(new WebModel(R.drawable.baaeed,R.string.baaeedn,R.string.baaeedd,"https://baaeed.com/"));
        arr.add(new WebModel(R.drawable.nab,R.string.nabbeshn,R.string.nabbeshd,"https://www.nabbesh.com/ar/"));
        arr.add(new WebModel(R.drawable.kafiillogo,R.string.kafiiln,R.string.kafiild,"https://kafiil.com/"));
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
