package com.example.leaderboard_gads_fred_herbert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LearnerAdapter extends RecyclerView.Adapter<LearnerAdapter.LearnerViewHolder> {

    private Context mContext;
    ArrayList<Learners> learnersArrayList;
    public LearnerAdapter(ArrayList<Learners> learnersArrayList){
            this.learnersArrayList = learnersArrayList;
    }

    @NonNull
    @Override
    public LearnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.raw_items, parent, false);
        return new LearnerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LearnerViewHolder holder, int position) {
        Learners learners = learnersArrayList.get(position);
        holder.bind(learners);
    }

    @Override
    public int getItemCount() {
        return learnersArrayList.size();
    }

    public class LearnerViewHolder extends RecyclerView.ViewHolder{

        TextView name, country, hours;
        ImageView badgeUrl;

        public LearnerViewHolder(View itemView){
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.username);
            hours = (TextView)itemView.findViewById(R.id.hrstxt);
            country = (TextView)itemView.findViewById(R.id.countrytxt);

            badgeUrl = (ImageView)itemView.findViewById(R.id.imageviewL);
        }

        public void bind (Learners learners){
            name.setText(learners.name);
            hours.setText(learners.hours);
            country.setText(learners.country);
            Picasso.with(mContext).load(learners.getBadgeUrl()).into(badgeUrl);
        }
    }
}
