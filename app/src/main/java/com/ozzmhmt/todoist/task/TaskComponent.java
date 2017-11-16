package com.ozzmhmt.todoist.task;

import com.ozzmhmt.todoist.di.components.ApplicationComponent;
import com.ozzmhmt.todoist.di.scopes.AcitivityScope;

import dagger.Component;

@AcitivityScope
@Component(modules = {TaskModule.class}, dependencies = {ApplicationComponent.class})
public interface TaskComponent {

    void inject(TaskActivity taskActivity);
}
