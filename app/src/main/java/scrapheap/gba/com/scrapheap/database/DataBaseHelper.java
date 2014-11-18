package scrapheap.gba.com.scrapheap.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import scrapheap.gba.com.scrapheap.utils.SLog;

/**
 * Created by Ifa on 2014-11-18.
 */

public class DataBaseHelper extends OrmLiteSqliteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ScrapheapDB";

    private Dao<Note, Integer> noteDao;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Note.class);
        } catch (SQLException e) {
            SLog.e("Error while creating table ");
            throw new RuntimeException(e);
        }
        SLog.i("Created database");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Note.class, false);
        } catch (SQLException e) {
            SLog.e("Error while droping table ");
            throw new RuntimeException(e);
        }
        onCreate(database,connectionSource);
    }

    public Dao<Note, Integer> getNoteDao() throws SQLException {
        if (noteDao == null){
            noteDao = getDao(Note.class);
//            TableUtils.clearTable(connectionSource, Note.class); //TODO: the fock is that?
        }
        return getDao(Note.class);
    }

    @Override
    public void close() {
        super.close();
        noteDao = null;
    }
}
