package com.ozzmhmt.todoist.di.modules;

import android.content.Context;

import com.ozzmhmt.todoist.db.DaoMaster;
import com.ozzmhmt.todoist.db.DaoSession;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    DaoSession provideDaoSession(Context context) {
        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, "todo-db");
        Database database = helper.getWritableDb();
        return new DaoMaster(database).newSession();
    }
}