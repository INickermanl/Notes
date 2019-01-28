package nickerman.com.notes.screens.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import nickerman.com.notes.R;
import nickerman.com.notes.adapters.AdapterMainNotes;
import nickerman.com.notes.adapters.INoteClick;
import nickerman.com.notes.models.Note;
import nickerman.com.notes.util.ui.VerticalSpacingItemDecorator;

public class NotesView implements NotesContract.View {

    private View root;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public NotesView(View root) {
        this.root = root;

        initView();
    }

    private void initView() {
        this.recyclerView = root.findViewById(R.id.recycler_view);
    }

    @Override
    public void setAdapter(List<Note> notes, INoteClick iNoteClick) {

        LinearLayoutManager llm = new LinearLayoutManager(root.getContext());
        adapter = new AdapterMainNotes(notes, iNoteClick);
        VerticalSpacingItemDecorator vsd = new VerticalSpacingItemDecorator(10);
        recyclerView.addItemDecoration(vsd);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

    }
}
