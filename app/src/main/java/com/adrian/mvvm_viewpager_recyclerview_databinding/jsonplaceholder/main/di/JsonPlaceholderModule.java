package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.TestData;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.model.DataModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.CommentsViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.PostsViewModel;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class JsonPlaceholderModule {

    private JsonPlaceholderActivity jsonPlaceholderActivity;

    public JsonPlaceholderModule(JsonPlaceholderActivity jsonPlaceholderActivity) {
        this.jsonPlaceholderActivity = jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderRouter providesJsonPlaceholderRouter() {
        return this.jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderViewModel providesJsonPlaceholderViewModel(JsonPlaceholderRouter jsonPlaceholderRouter) {
        return new JsonPlaceholderViewModel(jsonPlaceholderRouter);
    }

    @ActivityScope
    @Provides
    @Named("postsDataModel")
    DataModel providesPostsDataModel(PostsViewModel postsViewModel) {
        return new DataModel(postsViewModel);
    }

    @ActivityScope
    @Provides
    @Named("commentsDataModel")
    DataModel providesCommentsDataModel(CommentsViewModel commentsViewModel) {
        return new DataModel(commentsViewModel);
    }

    @ActivityScope
    @Provides
    TestData providesTestData(PostsViewModel postsViewModel, CommentsViewModel commentsViewModel) {
        return new TestData(postsViewModel, commentsViewModel);
    }
}