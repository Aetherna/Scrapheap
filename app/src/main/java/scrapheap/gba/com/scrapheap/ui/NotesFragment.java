package scrapheap.gba.com.scrapheap.ui;

import android.app.Fragment;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import scrapheap.gba.com.scrapheap.R;
import scrapheap.gba.com.scrapheap.ScrapheapApplication;
import scrapheap.gba.com.scrapheap.database.Note;

/**
 * Created by Ifa on 2014-11-18.
 */
@EFragment(R.layout.fragment_notes)
public class NotesFragment extends Fragment {

    @Inject
    Dao<Note, Integer> noteDao;

    @ViewById
    Button createNote;

    @ViewById
    ListView notes;

    private NotesAdapter adapter;

    @AfterViews
    public void injectToDagger() {
        ((ScrapheapApplication) getActivity().getApplication()).getObjectGraph().inject(this);
        adapter = new NotesAdapter(getActivity(), new ArrayList<Note>());
        notes.setAdapter(adapter);
    }

    @Click
    public void createNote() {
        Note note = new Note("Note", "Time:  " + System.currentTimeMillis());
        try {
            noteDao.create(note);

            List<Note> notes = noteDao.queryForAll();
            adapter.clear();
            adapter.addAll(notes);

        } catch (SQLException e) {
            Toast.makeText(getActivity(), "Failed :/", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private class NotesAdapter extends ArrayAdapter<Note> {
        public NotesAdapter(Context context, List<Note> objects) {
            super(context, android.R.layout.simple_list_item_1, objects);
        }
    }
}
