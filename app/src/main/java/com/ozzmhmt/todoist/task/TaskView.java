package com.ozzmhmt.todoist.task;

import com.ozzmhmt.todoist.api.response.TaskResponse;

import java.util.List;

public interface TaskView {
    void fillRecycler(List<TaskResponse> body);

    void taskCreateSuccess(TaskResponse body);

    void taskCreateError(String message);
}
