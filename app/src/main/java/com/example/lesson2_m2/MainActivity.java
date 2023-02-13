package com.example.lesson2_m2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.lesson2_m2.fragments.FirstFragment;

public class MainActivity extends AppCompatActivity {
    FragmentContainerView fragmentContainerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainerView = findViewById(R.id.fragment_container_view);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_view, new FirstFragment()).commit();
    }
}