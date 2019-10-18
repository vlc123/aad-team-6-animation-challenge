package com.andela.dairyapp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andela.dairyapp.R;
import com.andela.dairyapp.activities.DetailsActivity;
import com.andela.dairyapp.customs.CircularTextView;
import com.andela.dairyapp.models.Note;
import com.google.gson.Gson;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Note> noteList;

    public NotesAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).bind(noteList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                intent.putExtra("diary", new Gson().toJson(noteList.get(position)));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList != null ? noteList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView note_title, note_description, created_time;
        CircularTextView color_code;
        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            note_title = itemView.findViewById(R.id.note_title);
            note_description = itemView.findViewById(R.id.note_description);
            created_time = itemView.findViewById(R.id.created_at);
            color_code = itemView.findViewById(R.id.color_code);

        }

        void bind(Note note) {
            note_title.setText(note.getNote_name());
            note_description.setText(note.getNote_description());
            created_time.setText(note.getCreated_at());
            color_code.setText(note.getNote_name().subSequence(0, 2));
            color_code.setSolidColor(note.getColor_code());
            color_code.setStrokeColor("#aaaaaa");
            color_code.setWidth(1);
        }
    }

    public boolean addNote(Note note) {
        if (noteList.add(note)) {
            notifyDataSetChanged();
            return true;
        } else {
            return false;
        }

    }
}
