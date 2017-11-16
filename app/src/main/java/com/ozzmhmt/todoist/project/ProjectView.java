package com.ozzmhmt.todoist.project;

import com.ozzmhmt.todoist.api.response.ProjectResponse;

import java.util.List;

public interface ProjectView {
    void fillRecycler(List<ProjectResponse> body);
}
