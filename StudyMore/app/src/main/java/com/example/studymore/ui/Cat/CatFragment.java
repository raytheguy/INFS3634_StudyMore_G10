package com.example.studymore.ui.Cat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.studymore.R;

public class CatFragment extends Fragment {

    private CatViewModel catViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        catViewModel =
                ViewModelProviders.of(this).get(CatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_encyclo, container, false);

        return root;
    }
}