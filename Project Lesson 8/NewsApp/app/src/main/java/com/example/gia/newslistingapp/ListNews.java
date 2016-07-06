package com.example.gia.newslistingapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListNews extends AppCompatActivity {

    // Definition of the variables
    ListView listNews;
    TextView textResults;

    ArrayList<HashMap<String, String>> news_list;
    ArrayList<ListAdapter> list_adapter;

    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);

        // Initialization of the Variables
        textResults = (TextView) findViewById(R.id.textSearchResults);
        listNews = (ListView) findViewById(R.id.news_list);

        news_list = new ArrayList<HashMap<String, String>>();
        list_adapter =  new ArrayList<ListAdapter>();

        progress = new ProgressDialog(this);
        progress.setTitle("Loading");

        // Create the Intent to get the input argument in the previous activity
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        new getNewsInformation().execute(url);
    }

    private class getNewsInformation extends AsyncTask<String, Void, Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.show();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            String stream = null;
            String sectionName = "";
            String title = "";
            String url = "";
            String URLString = strings[0];
            NewsInformationHandler newsHandler = new NewsInformationHandler();
            stream = newsHandler.getStreamData(URLString);

            if (stream != null) {
                try {
                    JSONObject jsonResult = new JSONObject(stream);
                    JSONArray results = jsonResult.getJSONObject("response").getJSONArray("results");
                    int totalItems = results.length();
                    if (totalItems != 0) {
                        for (int i = 0; i < totalItems; i++) {

                            HashMap<String, String> newsMap = new HashMap<String, String>();

                            JSONObject newsObject = results.getJSONObject(i);

                            Log.v("DEBUG", "newsObject " + newsObject.toString());

                            if (newsObject.has("sectionName")) {
                                sectionName = newsObject.getString("sectionName");
                            } else {
                                sectionName = "";
                            }
                            Log.v("DEBUG", "publicationDate " + sectionName);
                            if (newsObject.has("webTitle")) {
                                title = newsObject.getString("webTitle");
                            } else {
                                title = "";
                            }
                            url = newsObject.getString("webUrl");

                            Log.v("DEBUG", "title " + title);
                            Log.v("DEBUG", "publicationDate " + sectionName);
                            newsMap.put("title", title);
                            newsMap.put("publicationDate", sectionName);
                            newsMap.put("url", url);
                            news_list.add(newsMap);

                            ListAdapter listAdapter = new SimpleAdapter(ListNews.this,
                                    news_list,
                                    R.layout.news_item,
                                    new String[]{"title", "sectionName"},
                                    new int[]{R.id.news_title, R.id.news_content});

                            list_adapter.add(listAdapter);
                        }
                    }
                    else{
                        progress.dismiss();
                        return false;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    progress.dismiss();
                    return false;
                }
            }
            progress.dismiss();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result){
                for (int i = 0; i < list_adapter.size(); i ++){
                    listNews.setAdapter(list_adapter.get(i));
                    listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent,
                                                View view,
                                                int position,
                                                long id) {
                            String url = news_list.get(+position).get("url");
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(url));
                            startActivity(intent);
                        }
                    });
                }
            }
            else{
                textResults.setText("No results found.");
                Toast.makeText(ListNews.this, "Search failed!", Toast.LENGTH_LONG).show();
            }
        }

    }
}
