package com.example.leaderboard_gads_fred_herbert;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class SkillsFragment extends Fragment {

    RecyclerView recyclerViewSkills;
    GridLayoutManager gridLayoutManager;
    List<Skills> skillsList;


    public SkillsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skills, container, false);

        recyclerViewSkills = (RecyclerView)view.findViewById(R.id.rv_skills);
        skillsList = new ArrayList<>();
        LinearLayoutManager learnerLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewSkills.setLayoutManager(learnerLayoutManager);

        try {
            URL skillsUrl = ApiUtilSkills.buildUrl();
            new SkillsQueryTask().execute(skillsUrl);

        }
        catch (Exception e){
            Log.d("error", e.getMessage());
        }
        return view;
    }

    public class SkillsQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL searchURL = urls[0];
            String result = null;

            try {
                result = ApiUtilSkills.getJson(searchURL);
            }
            catch (IOException e){
                Log.e("Error", e.getMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {


            ArrayList<Skills> skills = ApiUtilSkills.skillsArrayListFromjson(result);
            String resultString = "";
//            for (Learners learners1 : learners){
//                resultString = resultString +learners1.name + "\n" +
//                        learners1.hours + learners1.country + learners1.badgeUrl
//                ;
//            }
            SkillsAdapter adapter = new SkillsAdapter(skills);
            recyclerViewSkills.setAdapter(adapter);


        }


    }
}