package com.example.viewpagerexample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpagerexample.R;

public class ImageFragment extends Fragment {

    private ImageView iv_img;

    public static ImageFragment newInstance(int position) {
        ImageFragment f = new ImageFragment();
        Bundle b = new Bundle();
        b.putInt("index", position);
        f.setArguments(b);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iv_img = view.findViewById(R.id.iv_img);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            int index = getArguments().getInt("index");
            switch (index) {
                case 0:
                    //iv_img.setImageResource(R.drawable.aa);
                    break;
                case 1:
                    //iv_img.setImageResource(R.drawable.bb);
                    break;
                case 2:
                    //iv_img.setImageResource(R.drawable.cc);
                    break;
                case 3:
                    //iv_img.setImageResource(R.drawable.dd);
                    break;
                case 4:
                    //iv_img.setImageResource(R.drawable.ee);
                    break;
            }
        }
    }
}
