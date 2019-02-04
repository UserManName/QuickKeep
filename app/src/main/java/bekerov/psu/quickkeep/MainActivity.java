package bekerov.psu.quickkeep;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collection;

import bekerov.psu.quickkeep.adapter.NoteAdapter;
import bekerov.psu.quickkeep.adapter.RecyclerItemClickListener;
import bekerov.psu.quickkeep.item.Note;

public class MainActivity extends AppCompatActivity {

    private String mIdHeadlineText;
    private String mIdAnotherText;

    private RecyclerView mRecyclerView;
    private NoteAdapter mNoteAdapter;
    private Toast mToast = null;
    private boolean mChangeNote = false;
    private int mPositionChangeNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIdHeadlineText = getResources().getString(R.string.id_headline_text);
        mIdAnotherText = getResources().getString(R.string.id_another_text);

        initRecyclerView();
        loadNotes();

    }

    public void addNoteClick(View view) {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivityForResult(intent, 1);
    }

    public void initRecyclerView() {
        mRecyclerView = findViewById(R.id.notes_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(MainActivity.this, mRecyclerView
                        ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                        intent.putExtra(mIdHeadlineText, mNoteAdapter.getNote(position).getHeadlineText());
                        intent.putExtra(mIdAnotherText,  mNoteAdapter.getNote(position).getAnotherText());
                        mChangeNote = true;
                        mPositionChangeNote = position;
                        startActivityForResult(intent, 1);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        mNoteAdapter.deleteNote(position);
                        showShortToast("Запись удалена");
                    }
                })
        );
        mNoteAdapter = new NoteAdapter();
        mRecyclerView.setAdapter(mNoteAdapter);


    }

    public Collection<Note> getNotes() {
        return Arrays.asList(new Note("1","1"), new Note("2","2"), new Note("3","3"), new Note("4","4"), new Note("5","5")
                , new Note("6","6"), new Note(), new Note(), new Note(), new Note(), new Note()
                , new Note(), new Note(), new Note(), new Note(), new Note(), new Note());
    }

    public void loadNotes() {
        Collection<Note> notes = getNotes();
        mNoteAdapter.setNotes(notes);
    }

    public void showShortToast(String msg){
        if (mToast == null) {
            mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        }
        if (!mToast.getView().isShown()) {
            mToast.setText(msg);
            mToast.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch(resultCode){
            case RESULT_OK:
                assert data != null;
                if(mChangeNote) {
                    mNoteAdapter.addNotePosition(
                            new Note(data.getStringExtra(mIdHeadlineText),
                                    data.getStringExtra(mIdAnotherText)),
                                    mPositionChangeNote);
                    mChangeNote = false;
                } else
                    mNoteAdapter.setNote(new Note(data.getStringExtra(mIdHeadlineText),
                            data.getStringExtra(mIdAnotherText)));
                break;
            case RESULT_CANCELED:
                break;
        }
    }
}
