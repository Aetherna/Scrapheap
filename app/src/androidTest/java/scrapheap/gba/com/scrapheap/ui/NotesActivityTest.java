package scrapheap.gba.com.scrapheap.ui;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

import com.robotium.solo.Solo;

import scrapheap.gba.com.scrapheap.R;

import static org.fest.assertions.api.Assertions.assertThat;

public class NotesActivityTest extends ActivityInstrumentationTestCase2<NotesActivity> {

    private Solo solo;

    public NotesActivityTest() {
        super(NotesActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testCreateNote() {
        //given empty list of notes
        ListView notes = (ListView) solo.getView(R.id.notes);
        solo.clickOnButton("Clear Notes");
        //when clicking on create note button
        solo.clickOnButton("Create Note");
        //then check if note appeared in notes
        solo.waitForView(R.id.notes);
        assertThat(notes.getCount()).isEqualTo(1);

    }


    public void testDeleteNotes() {
        //given empty list of notes
        ListView notes = (ListView) solo.getView(R.id.notes);
        //when clicking on create note button
        solo.clickOnButton("Clear Notes");
        //then check if note appeared in notes
        solo.waitForView(R.id.notes);
        assertThat(notes.getCount()).isEqualTo(0);

    }

    public void testNoteDetails(){
        //given 1 note created
        solo.clickOnButton("Create Note");

        //when clicking on notes item
        solo.clickInList(0);

        solo.waitForText("Fetched");

    };

}