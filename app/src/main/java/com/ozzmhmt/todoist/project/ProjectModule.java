package com.ozzmhmt.todoist.project;

import com.ozzmhmt.todoist.di.scopes.AcitivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectModule {

    private ProjectView view;

    public ProjectModule(ProjectView view) {
        this.view = view;
    }

    @Provides
    @AcitivityScope
    public ProjectView getView() {
        return view;
    }
}