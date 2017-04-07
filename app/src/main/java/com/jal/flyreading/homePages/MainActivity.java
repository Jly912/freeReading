package com.jal.flyreading.homePages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jal.flyreading.R;

public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment;
    private BookmarksFragment bookmarksFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
