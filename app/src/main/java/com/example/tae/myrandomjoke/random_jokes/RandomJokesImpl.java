package com.example.tae.myrandomjoke.random_jokes;

import android.util.Log;

import com.example.tae.myrandomjoke.data.network.DataManager;
import com.example.tae.myrandomjoke.data.network.model.RandomJoke;
import com.example.tae.myrandomjoke.ui.base.BasePresenter;
import com.example.tae.myrandomjoke.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TAE on 22-Feb-18.
 */

public class RandomJokesImpl <V extends IRandomJokeMvpView>
        extends BasePresenter<V>
        implements IRandomJokesPresenter<V>{
    public RandomJokesImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadRandomJokes(){

        getCompositeDisposable()
                .add(getDataManager().getRandomJoke()
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
