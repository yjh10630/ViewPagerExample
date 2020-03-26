package com.example.viewpagerexample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpagerexample.R;

public class IndexFragment extends Fragment {

    private TextView tv_title;
    private int index;

    public static IndexFragment newInstance(int position) {
        IndexFragment f = new IndexFragment();
        Bundle b = new Bundle();
        b.putInt("index", position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        if (getArguments() != null) {
            index = getArguments().getInt("index");
        }

        Log.d("####", "[" +index+ "] onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("####", "[" +index+ "] onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("####", "[" +index+ "] onCreateView");
        return inflater.inflate(R.layout.fragment_index, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d("####", "[" +index+ "] onViewCreated");
        tv_title = view.findViewById(R.id.tv_title);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("####", "[" +index+ "] onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            int index = getArguments().getInt("index");
            tv_title.setText(String.valueOf(index));
        }
    }

    @Override
    public void onResume() {
        Log.d("####", "[" +index+ "] onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("####", "[" +index+ "] onPause");
        super.onPause();
    }

    @Override
    public void onDestroy() {
        Log.d("####", "[" +index+ "] onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.d("####", "[" +index+ "] onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.d("####", "[" +index+ "] onDetach");
        super.onDetach();
    }
}
