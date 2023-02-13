package com.example.lesson2_m2.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lesson2_m2.R;

public class FirstFragment extends Fragment {
    AppCompatButton buttonToSecondFrag;
    AppCompatButton buttonToThirdFrag;
    EditText editTextFirst, editTextSecond;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById();
        onClick();
    }

    private void findViewById() {
        buttonToSecondFrag = requireActivity().findViewById(R.id.btn_first);
        buttonToThirdFrag = requireActivity().findViewById(R.id.btn_second);
        editTextFirst = requireActivity().findViewById(R.id.et_first);
        editTextSecond = requireActivity().findViewById(R.id.et_second);
    }

    private void onClick(){
        buttonToSecondFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextFirst.getText().toString().isEmpty()){
                    moveToSecondFragment();
                } else {
                    Toast.makeText(requireActivity(), "Input text", Toast.LENGTH_SHORT);
                }
            }
        });

        buttonToThirdFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextSecond.getText().toString().isEmpty()){
                    moveToThirdFragment();
                } else {
                    Toast.makeText(requireActivity(), "Input text", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    private void moveToSecondFragment() {
        String inputOne = editTextFirst.getText().toString();

        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("inputOne", inputOne);
        secondFragment.setArguments(bundle);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, secondFragment)
                .addToBackStack(null)
                .commit();
    }
    private void moveToThirdFragment() {
        String inputTwo = editTextSecond.getText().toString();

        ThirdFragment thirdFragment = new ThirdFragment();
        Bundle bundle = new Bundle();
        bundle.putString("inputTwo", inputTwo);
        thirdFragment.setArguments(bundle);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, thirdFragment)
                .addToBackStack(null)
                .commit();
    }
}