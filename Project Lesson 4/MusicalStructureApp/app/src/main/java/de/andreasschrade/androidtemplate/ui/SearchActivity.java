package de.andreasschrade.androidtemplate.ui;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.andreasschrade.androidtemplate.R;
import de.andreasschrade.androidtemplate.ui.base.BaseActivity;

public class SearchActivity extends BaseActivity {

    // Definition of the Variables
    ImageView btnSearch;

    TextView txtSearchResult;

    EditText txtInputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setupToolbar();

        // Initialization of the variables
        btnSearch = (ImageView) findViewById(R.id.imageIcSearch);
        txtSearchResult = (TextView) findViewById(R.id.textSearchResult);
        txtInputSearch = (EditText) findViewById(R.id.inputSearch);

    }

    private void setupToolbar() {
        final ActionBar ab = getActionBarToolbar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                openDrawer();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return R.id.nav_search;
    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }

    public void search(View v){

        txtSearchResult.setText("Sorry, no results was found.");
        txtInputSearch.setText("");

    }
}
