package com.example.alemne.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filterable;
import android.widget.Filter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.alemne.R;
import com.example.alemne.pojo.WebModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

public class WebAdapter extends RecyclerView.Adapter<WebAdapter.WebViewHolder> implements Filterable {
    Context mContext;

    public WebAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    private ArrayList<WebModel> listmodel=new ArrayList<>();
    private ArrayList<WebModel> listmodelfull ;

    public void setListmodel(@NonNull ArrayList<WebModel> listmodel) {
        this.listmodel = listmodel;
        listmodelfull = new ArrayList<>(listmodel);
        notifyDataSetChanged();
    }

    @NonNull
    public ArrayList<WebModel> getListmodel() {
        return listmodel;
    }

    @Override
    public WebViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WebViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WebViewHolder holder, int position) {
        holder.image.setImageResource(listmodel.get(position).getImage());

        try{
            holder.title.setText(listmodel.get(position).getTitle());
            holder.body.setText(listmodel.get(position).getBody());

        }
        catch (Exception e)
        {
            Log.e(TAG, "onBindViewHolder: "+e.getMessage() );
        }

        holder.enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(listmodel.get(position)
                        .getLink()));
                mContext.startActivity(browserIntent);
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = listmodel.get(position).getLink();
                String i=mContext.getString(listmodel.get(position).getTitle());
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, " تطبيق علمني"+"\n \n"+" رابط "+i+"\n");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                mContext.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });


    }

    @Override
    public int getItemCount() {
        return listmodel.size();
    }


    public class WebViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView title, body;
        Button share, enter;

        public WebViewHolder(@NonNull View itemView) {
            super(itemView);
            enter = itemView.findViewById(R.id.enter);
            share = itemView.findViewById(R.id.share);
            image = itemView.findViewById(R.id.web_image);
            title = itemView.findViewById(R.id.web_name);
            body = itemView.findViewById(R.id.web_desc);
        }
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<WebModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listmodelfull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (WebModel item : listmodelfull) {
                    String i=mContext.getString(item.getTitle());
                    String j=mContext.getString(item.getBody());
                    if (i.toLowerCase().contains(filterPattern)|j.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listmodel.clear();
            listmodel.addAll((List) results.values);

            notifyDataSetChanged();
        }


    };

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
