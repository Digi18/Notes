package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.notes.R;

import java.util.ArrayList;
import java.util.List;

import Models.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    List<Note> mNotes = new ArrayList<>();


    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_row_layout,parent,false);

        return new NoteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {

        Note note = mNotes.get(position);

        holder.title.setText(note.getTitle());
        holder.desc.setText(note.getDescription());

    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public void setmNotes(List<Note> mNotes) {
        this.mNotes = mNotes;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
