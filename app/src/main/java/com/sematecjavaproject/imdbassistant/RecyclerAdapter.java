package com.sematecjavaproject.imdbassistant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sematecjavaproject.imdbassistant.IMDBClass.Search;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    List<Search> searchResult;

    public RecyclerAdapter(List<Search> searchList) {

        searchResult = searchList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item1, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(viewItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        String moviePoster = searchResult.get(position).getPoster();
        Picasso.get().load(moviePoster).into(holder.imageViewPoster);
        String movieTitle = searchResult.get(position).getTitle();
        holder.textViewTitle.setText(movieTitle);
        String movieYear = searchResult.get(position).getYear();
        holder.textViewYear.setText(movieYear);
    }

    @Override
    public int getItemCount() {
        return searchResult.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewPoster;
        TextView textViewTitle;
        TextView textViewYear;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewPoster = itemView.findViewById(R.id.imgPoster);
            textViewTitle = itemView.findViewById(R.id.txtTitle);
            textViewYear = itemView.findViewById(R.id.txtYear);
        }
    }
}
