package com.example.gia.booklistingapp;

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

public class ListBooks extends AppCompatActivity {

    // Definition of the variables
    ListView listBooks;
    TextView textResults;

    ArrayList<HashMap<String, String>> book_list;
    ArrayList<ListAdapter> list_adapter;

    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        // Initialization of the Variables
        textResults = (TextView) findViewById(R.id.textSearchResults);
        listBooks = (ListView) findViewById(R.id.book_list);

        book_list = new ArrayList<HashMap<String, String>>();
        list_adapter =  new ArrayList<ListAdapter>();

        progress = new ProgressDialog(this);
        progress.setTitle("Loading");

        // Create the Intent to get the input argument in the previous activity
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        new getBooksInformation().execute(url);
    }

    private class getBooksInformation extends AsyncTask<String, Void, Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.show();
        }

        protected Boolean doInBackground(String... strings) {
            String stream = null;
            String URLString = strings[0];
            String author = "";
            String title = "";
            BookInformationHandler bookHandler = new BookInformationHandler();
            stream = bookHandler.getStreamData(URLString);

            if (stream != null) {
                try {
                    JSONObject jsonResult = new JSONObject(stream);
                    int totalItems = jsonResult.getInt("totalItems");
                    Log.v("DEBUG", "totalItems " + totalItems);
                    if (totalItems != 0) {
                        JSONArray booksArray = jsonResult.getJSONArray("items");
                        for (int i = 0; i < booksArray.length(); i++) {

                            HashMap<String, String> booksMap = new HashMap<String, String>();

                            JSONObject bookObject = booksArray.getJSONObject(i);
                            JSONObject bookDetails = bookObject.getJSONObject("volumeInfo");

                            if (bookDetails.has("authors")) {
                                author = bookDetails.getString("authors");
                                author = author.replace("[", "");
                                author = author.replace("]", "");
                            } else {
                                author = "";
                            }
                            title = bookDetails.getString("title");

                            Log.v("DEBUG", "title " + title);
                            Log.v("DEBUG", "author " + author);
                            booksMap.put("title", title);
                            booksMap.put("author", author);
                            book_list.add(booksMap);

                            ListAdapter listAdapter = new SimpleAdapter(ListBooks.this,
                                    book_list,
                                    R.layout.book_item,
                                    new String[]{"title", "author"},
                                    new int[]{R.id.book_title, R.id.book_author});

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
                    listBooks.setAdapter(list_adapter.get(i));
                }
            }
            else{
                textResults.setText("No results found.");
                Toast.makeText(ListBooks.this, "Search failed!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
