package com.example.tae.myrandomjoke.text_input;

import com.example.tae.myrandomjoke.ui.base.MvpPresenter;

/**
 * Created by TAE on 22-Feb-18.
 */

public interface ITextInputJokePresenter <V extends ITextInputJokeMvpView> extends MvpPresenter<V> {

    void loadTextInputJokes(String firstName);

}
