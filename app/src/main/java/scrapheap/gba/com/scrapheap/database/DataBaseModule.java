package scrapheap.gba.com.scrapheap.database;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import dagger.Module;
import dagger.Provides;
import scrapheap.gba.com.scrapheap.ScrapheapApplication;
import scrapheap.gba.com.scrapheap.ui.NotesFragment_;
import scrapheap.gba.com.scrapheap.utils.SLog;

/**
 * Created by Ifa on 2014-11-18.
 */
@Module(injects = NotesFragment_.class)
public class DataBaseModule {

    private final DataBaseHelper dataBaseHelper;

    public DataBaseModule(ScrapheapApplication application) {
        dataBaseHelper = new DataBaseHelper(application);
    }

    @Provides
    Dao<Note, Integer> getNoteDao() {
        try {
            return dataBaseHelper.getNoteDao();
        } catch (SQLException e) {
            SLog.e("Error on getting dao");
            e.printStackTrace();
        }
        return null;
    }

}
