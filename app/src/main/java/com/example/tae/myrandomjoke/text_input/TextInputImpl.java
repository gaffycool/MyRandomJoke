package com.example.tae.myrandomjoke.text_input;

import android.util.Log;

import com.example.tae.myrandomjoke.data.network.DataManager;
import com.example.tae.myrandomjoke.data.network.model.RandomJoke;
import com.example.tae.myrandomjoke.random_jokes.IRandomJokeMvpView;
import com.example.tae.myrandomjoke.random_jokes.IRandomJokesPresenter;
import com.example.tae.myrandomjoke.ui.base.BasePresenter;
import com.example.tae.myrandomjoke.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TAE on 22-Feb-18.
 */

public class TextInputImpl <V extends ITextInputJokeMvpView>
        extends BasePresenter<V>
        implements ITextInputJokePresenter<V> {

    public TextInputImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadTextInputJokes(String firstName) {

        getCompositeDisposable()
                .add(getDataManager().getTextInputJoke(firstName)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<RandomJoke>() {
                            @Override
                            public void accept(RandomJoke randomJoke) throws Exception {

                                getMvpView().onFetchDataSuccess(randomJoke);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.i("error", throwable.getMessage());
                            }
                        })
                );

    }

}
