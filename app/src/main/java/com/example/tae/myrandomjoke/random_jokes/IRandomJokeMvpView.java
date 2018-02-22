package com.example.tae.myrandomjoke.random_jokes;

import com.example.tae.myrandomjoke.data.network.model.RandomJoke;
import com.example.tae.myrandomjoke.ui.base.MvpView;

/**
 * Created by TAE on 22-Feb-18.
 */

public interface IRandomJokeMvpView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccess(RandomJoke randomJoke);
    void onFetchDataError(String error);
}
