package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class PostsViewModel extends BaseViewModel {

    private PostsRouter postsRouter;

    public PostsViewModel(PostsRouter postsRouter) {
        super(postsRouter);
        this.postsRouter = postsRouter;
    }


}
