package scrapheap.gba.com.scrapheap.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Ifa on 2014-11-18.
 */
@DatabaseTable(tableName = "Notes")
public class Note {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String noteName;

    @DatabaseField
    private String noteValue;

    /**
     * No args constructor for ORMLite
     */
    public Note() {
    }

    public Note(String noteName, String noteValue) {
        this.noteName = noteName;
        this.noteValue = noteValue;
    }

    public String getNoteName() {
        return noteName;
    }

    public String getNoteValue() {
        return noteValue;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(id).append(" ").append(noteName).append(" ").append(noteValue).toString();
    }

    public int getId() {
        return id;
    }
}
