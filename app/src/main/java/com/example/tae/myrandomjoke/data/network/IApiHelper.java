package com.example.tae.myrandomjoke.data.network;

import com.example.tae.myrandomjoke.data.network.model.RandomJoke;

import io.reactivex.Observable;

/**
 * Created by TAE on 13-Feb-18.
 */

public interface IApiHelper {

    Observable<RandomJoke> getRandomJoke();

    Observable<RandomJoke> getTextInputJoke(String firstname);
}
