package com.example.hunnids.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hunnids.databinding.ItemShowResumeBinding;
import com.example.hunnids.model.Movie;
import com.example.hunnids.model.Series;
import com.example.hunnids.model.ShowModel;

import java.util.List;


import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;


public class RVResumeAdapter  extends RecyclerView.Adapter<RVResumeAdapter.ResumeVH> {
    private List<ShowModel> showModels;
    public RVResumeAdapter(List<ShowModel> showModels) {
        this.showModels = showModels;
    }

    @NonNull
    @Override
    public ResumeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemShowResumeBinding binding = ItemShowResumeBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ResumeVH(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull ResumeVH holder, int position) {
        holder.bind(showModels.get(position));
    }
    @Override
    public int getItemCount(){
        return showModels.size();
    }
    class ResumeVH extends RecyclerView.ViewHolder{

        private ItemShowResumeBinding binding;
        public ResumeVH(ItemShowResumeBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(ShowModel showModel) {
            if(showModel instanceof Movie){
                binding.txtSeason.setVisibility(View.GONE);

            }else if(showModel instanceof Series){
                binding.txtSeason.setVisibility(View.VISIBLE);
                binding.txtSeason.setText("Precio " + ((Series) showModel).getSeason());
            }
            binding.txtName.setText(showModel.getName());


            ImageLoader imageLoader= Coil.imageLoader(binding.getRoot().getContext());
            ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext())
                    .data(showModel.getImgUrl())
                    .crossfade(true)
                    .target(binding.imgShow)
                    .build();
            imageLoader.enqueue(request);

        }
    }
}
