package com.ozzmhmt.todoist.project;

import com.ozzmhmt.todoist.di.components.ApplicationComponent;
import com.ozzmhmt.todoist.di.scopes.AcitivityScope;

import dagger.Component;

@AcitivityScope
@Component(modules = {ProjectModule.class}, dependencies = {ApplicationComponent.class})
public interface ProjectComponent {
    void inject(ProjectActivity projectActivity);
}
