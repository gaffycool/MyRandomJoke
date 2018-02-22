package com.example.tae.myrandomjoke.text_input;

import com.example.tae.myrandomjoke.data.network.model.RandomJoke;
import com.example.tae.myrandomjoke.ui.base.MvpView;

/**
 * Created by TAE on 22-Feb-18.
 */

public interface ITextInputJokeMvpView extends MvpView {

    void onFetchDataProgress();
    void onFetchDataSuccess(RandomJoke randomJoke);
    void onFetchDataError(String error);
}