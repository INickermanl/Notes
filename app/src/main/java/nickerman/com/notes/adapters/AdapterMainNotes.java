package nickerman.com.notes.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nickerman.com.notes.R;
import nickerman.com.notes.models.Note;

public class AdapterMainNotes extends RecyclerView.Adapter<AdapterMainNotes.ViewHolder>{

    private List<Note> mNotes;
    private INoteClick mNoteClick;

    public AdapterMainNotes( INoteClick noteClick) {
        this.mNotes = new ArrayList<>();
        this.mNoteClick = noteClick;
    }

    public void setItems(List<Note> notes){
        this.mNotes = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_note,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Note note = mNotes.get(i);

        viewHolder.title.setText(note.getTitle());
        viewHolder.timesTamp.setText(note.getTimesTamp());

    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       private TextView title,timesTamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            timesTamp = itemView.findViewById(R.id.note_date);
            title = itemView.findViewById(R.id.note_title);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mNoteClick.onNoteClick(getAdapterPosition());
        }
    }
}
