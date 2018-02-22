package com.example.tae.myrandomjoke.random_jokes;

import com.example.tae.myrandomjoke.ui.base.MvpPresenter;

/**
 * Created by TAE on 22-Feb-18.
 */

public interface IRandomJokesPresenter   <V extends IRandomJokeMvpView> extends MvpPresenter<V> {

    void loadRandomJokes();

}

