package com.ozzmhmt.todoist.di.components;

import android.content.Context;

import com.ozzmhmt.todoist.api.TodoApi;
import com.ozzmhmt.todoist.db.DaoSession;
import com.ozzmhmt.todoist.di.modules.ApplicationModule;
import com.ozzmhmt.todoist.di.modules.DatabaseModule;
import com.ozzmhmt.todoist.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    Context context();

    TodoApi todoapi();

    DaoSession session();
}
