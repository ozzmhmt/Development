package com.ozzmhmt.todoist.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ozzmhmt.todoist.R;
import com.ozzmhmt.todoist.TodoApp;
import com.ozzmhmt.todoist.api.response.ProjectResponse;
import com.ozzmhmt.todoist.core.AdapterOnClickListener;
import com.ozzmhmt.todoist.core.BaseActivity;
import com.ozzmhmt.todoist.task.TaskActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectActivity extends BaseActivity implements ProjectView, AdapterOnClickListener {

    @Inject
    ProjectPresenter presenter;
    @BindView(R.id.projectRecyclerView)
    RecyclerView projectRecyclerView;

    private ProjectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        ButterKnife.bind(this);

        DaggerProjectComponent.builder()
                .applicationComponent(((TodoApp) getApplication()).getComponent())
                .projectModule(new ProjectModule(this))
                .build()
                .inject(this);

        initRecycler();

        presenter.getData();

    }

    private void initRecycler() {
        adapter = new ProjectAdapter(null, this);
        projectRecyclerView.setAdapter(adapter);
    }

    @Override
    public void fillRecycler(List<ProjectResponse> responseList) {
        adapter.setList(responseList);

    }

    @Override
    public void onClick(View view, int position) {
        ProjectResponse item = adapter.getItem(position);
        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("project_id", item.getId());

        startActivity(intent);
    }
}
