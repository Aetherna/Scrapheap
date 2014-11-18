package scrapheap.gba.com.scrapheap;

import android.app.Application;

import dagger.ObjectGraph;
import scrapheap.gba.com.scrapheap.database.DataBaseModule;

/**
 * Created by Ifa on 2014-11-18.
 */
public class ScrapheapApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules());
        objectGraph.inject(this);
    }


    private Object[] getModules() {
        return new Object[]{
                new AppModule(this),
                new DataBaseModule(this)
        };
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }
}
