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

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder> {

    private Context mContext;
    ArrayList<Skills> skillsArrayList;
    public SkillsAdapter(ArrayList<Skills> skillsArrayList){
        this.skillsArrayList = skillsArrayList;
    }


    @NonNull
    @Override
    public SkillsAdapter.SkillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.raw_items, parent, false);
        return new SkillsAdapter.SkillsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsAdapter.SkillsViewHolder holder, int position) {
        Skills skills = skillsArrayList.get(position);
        holder.bind(skills);
    }

    @Override
    public int getItemCount() {
        return skillsArrayList.size();
    }

    public class SkillsViewHolder extends RecyclerView.ViewHolder{

        TextView name, country, hours;
        ImageView badgeUrl;

        public SkillsViewHolder(View itemView){
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.username);
            hours = (TextView)itemView.findViewById(R.id.hrstxt);
            country = (TextView)itemView.findViewById(R.id.countrytxt);

            badgeUrl = (ImageView)itemView.findViewById(R.id.imageviewL);
        }

        public void bind (Skills skills){
            name.setText(skills.name);
            hours.setText(skills.hours);
            country.setText(skills.score);
            Picasso.with(mContext).load(skills.getBadgeUrl()).into(badgeUrl);
        }
    }
}
