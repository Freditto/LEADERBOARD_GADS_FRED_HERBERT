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
import android.widget.GridLayout;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LearningFragment extends Fragment {

    RecyclerView recyclerViewL;
    GridLayoutManager gridLayoutManager;
    List<Learners> learnersList;

    public LearningFragment() {
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
        View view = inflater.inflate(R.layout.fragment_learning, container, false);
        recyclerViewL = (RecyclerView)view.findViewById(R.id.rv_learners);
        learnersList = new ArrayList<>();
        LinearLayoutManager learnerLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewL.setLayoutManager(learnerLayoutManager);

        try {
            URL learnersUrl = ApiUtil.buildUrl();
            new LearnerQueryTask().execute(learnersUrl);

        }
        catch (Exception e){
            Log.d("error", e.getMessage());
        }

        return view;
    }

    public class LearnerQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL searchURL = urls[0];
            String result = null;

            try {
                result = ApiUtil.getJson(searchURL);
            }
            catch (IOException e){
                Log.e("Error", e.getMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {


            ArrayList<Learners> learners = ApiUtil.learnersArrayListFromjson(result);
            String resultString = "";
//            for (Learners learners1 : learners){
//                resultString = resultString +learners1.name + "\n" +
//                        learners1.hours + learners1.country + learners1.badgeUrl
//                ;
//            }
            LearnerAdapter adapter = new LearnerAdapter(learners);
            recyclerViewL.setAdapter(adapter);


        }


    }


}