package com.example.hunnids.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hunnids.R;
import com.example.hunnids.databinding.FragmentHomeBinding;
import com.example.hunnids.model.Movie;
import com.example.hunnids.model.Series;
import com.example.hunnids.model.ShowModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    /*ListView lista;

    String[][] datos = {
            {"Pollo a la brasa","Pollo cocinado a la brasa de un horno"},
            {"Pollo al Horno","Pollo cocinado al Horno"},
            {"Pato Asado","Pato asado al calor"}
    };
    int[] datosImg = {R.drawable.euphoria, R.drawable.gradient};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }*/

    private FragmentHomeBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RVResumeAdapter adapter = new RVResumeAdapter(getData());
        binding.rvMoviesResume.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false);
        binding.rvMoviesResume.setLayoutManager(layoutManager);
    }

    private List<ShowModel> getData(){
        List<ShowModel>showModels = new ArrayList<>();
        showModels.add(new Series("Pollo a la brasa","",10));
        showModels.add(new Series("Pato asado","",20));
        showModels.add(new Series("Pollo a la olla","",15));
        showModels.add(new Series("Sopa de carne","",10));
        showModels.add(new Series("Tallarines verdes","",20));
        showModels.add(new Series("Lentejas","",20));
        showModels.add(new Series("Arverjita partida","",15));
        /*showModels.add(new Series("Pato asado","",3));
        showModels.add(new Movie("Chaufa","","Infinite saga"));
        showModels.add(new Movie("Arroz con pato","",""));*/

        return showModels;
    }
}