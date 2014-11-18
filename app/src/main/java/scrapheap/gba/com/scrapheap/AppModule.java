package scrapheap.gba.com.scrapheap;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import scrapheap.gba.com.scrapheap.database.DataBaseModule;

/**
 * Created by Ifa on 2014-11-18.
 */
@Module(injects = {ScrapheapApplication.class}, includes = {DataBaseModule.class}, library = true)
public class AppModule {

    private ScrapheapApplication application;

    public AppModule(ScrapheapApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context getAppContext() {
        return application;
    }
}
