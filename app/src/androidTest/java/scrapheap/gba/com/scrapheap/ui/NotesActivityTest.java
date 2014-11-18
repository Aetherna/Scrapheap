package scrapheap.gba.com.scrapheap.ui;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

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
        solo.clickOnButton("Create Note");
        Assert.assertTrue(solo.searchText("Note Time:"));
    }

}