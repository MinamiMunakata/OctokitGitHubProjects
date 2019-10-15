package com.example.octokitgithubprojects;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.airbnb.epoxy.DataBindingEpoxyModel;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import com.example.octokitgithubprojects.model.Project;
import com.example.octokitgithubprojects.view.callback.ProjectClickCallback;
import java.lang.CharSequence;
import java.lang.Number;

public interface ProjectListItemBindingModelBuilder {
  ProjectListItemBindingModelBuilder onBind(
      OnModelBoundListener<ProjectListItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ProjectListItemBindingModelBuilder onUnbind(
      OnModelUnboundListener<ProjectListItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ProjectListItemBindingModelBuilder onVisibilityStateChanged(
      OnModelVisibilityStateChangedListener<ProjectListItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ProjectListItemBindingModelBuilder onVisibilityChanged(
      OnModelVisibilityChangedListener<ProjectListItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ProjectListItemBindingModelBuilder project(Project project);

  ProjectListItemBindingModelBuilder callback(ProjectClickCallback callback);

  ProjectListItemBindingModelBuilder id(long id);

  ProjectListItemBindingModelBuilder id(@Nullable Number... ids);

  ProjectListItemBindingModelBuilder id(long id1, long id2);

  ProjectListItemBindingModelBuilder id(@Nullable CharSequence key);

  ProjectListItemBindingModelBuilder id(@Nullable CharSequence key,
      @Nullable CharSequence... otherKeys);

  ProjectListItemBindingModelBuilder id(@Nullable CharSequence key, long id);

  ProjectListItemBindingModelBuilder layout(@LayoutRes int layoutRes);

  ProjectListItemBindingModelBuilder spanSizeOverride(
      @Nullable EpoxyModel.SpanSizeOverrideCallback spanSizeCallback);
}
