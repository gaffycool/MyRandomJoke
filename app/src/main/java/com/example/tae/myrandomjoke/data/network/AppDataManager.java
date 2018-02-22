package com.example.tae.myrandomjoke.data.network;

import com.example.tae.myrandomjoke.data.network.model.RandomJoke;

import io.reactivex.Observable;

/**
 * Created by TAE on 13-Feb-18.
 */

public class AppDataManager implements DataManager{

    private IApiHelper iApiHelper;


    public AppDataManager() {
        iApiHelper = new AppApiHelper();
    }

    @Override
    public Observable<RandomJoke> getTextInputJoke(String firstName){
        return iApiHelper.getTextInputJoke(firstName);
    }
    @Override
    public Observable<RandomJoke> getRandomJoke() {
        return iApiHelper.getRandomJoke();
    }
}
