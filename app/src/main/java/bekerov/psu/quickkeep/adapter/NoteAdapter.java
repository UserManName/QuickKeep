package bekerov.psu.quickkeep.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bekerov.psu.quickkeep.R;
import bekerov.psu.quickkeep.item.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{

    private List<Note> mNotes = new ArrayList<>();

    public void setNotes(Collection<Note> notes) {
        mNotes.addAll(notes);
        notifyDataSetChanged();
    }

    public void setNote(Note note) {
        mNotes.add(note);
        notifyDataSetChanged();
    }

    public Note getNote(int position){
        return mNotes.get(position);
    }

    public void clearNotes(){
        mNotes.clear();
        notifyDataSetChanged();
    }

    public void deleteNote(int position){
        mNotes.remove(position);
        notifyDataSetChanged();
    }

    public void addNotePosition(Note note, int position){
        mNotes.remove(position);
        mNotes.add(position, note);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(mNotes.get(position));
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        private TextView headlineText;
        private TextView anotherText;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            headlineText = itemView.findViewById(R.id.headLineText);
            anotherText = itemView.findViewById(R.id.anotherText);
        }

        public void bind (Note note){
            headlineText.setText(note.getHeadlineText());
            anotherText.setText(note.getAnotherText());
        }
    }

}
