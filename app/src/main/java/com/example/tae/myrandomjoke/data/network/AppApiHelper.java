package com.example.tae.myrandomjoke.data.network;

import com.example.tae.myrandomjoke.data.network.model.RandomJoke;
import com.example.tae.myrandomjoke.data.network.model.Value;
import com.example.tae.myrandomjoke.data.network.service.IRequestInterface;
import com.example.tae.myrandomjoke.data.network.service.ServiceConnection;

import io.reactivex.Observable;

/**
 * Created by TAE on 13-Feb-18.
 */

public class AppApiHelper implements IApiHelper{

    private IRequestInterface iRequestInterface;


    public AppApiHelper() {
        iRequestInterface = ServiceConnection.getConnection();
    }


    @Override
    public Observable<RandomJoke> getRandomJoke() {
        return iRequestInterface.getRandomJoke();
    }

    @Override
    public Observable<RandomJoke> getTextInputJoke(String firstName) {
        return iRequestInterface.getTextInputJoke(firstName);
    }
}
