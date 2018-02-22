package com.example.tae.myrandomjoke.data.network.service;

import com.example.tae.myrandomjoke.data.network.model.RandomJoke;
import com.example.tae.myrandomjoke.data.network.model.Value;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by TAE on 09-Feb-18.
 */

public interface IRequestInterface {

    @GET(ApiList.Random_API)
    Observable<RandomJoke> getRandomJoke();

    @GET(ApiList.TextInput_API)
    Observable<RandomJoke> getTextInputJoke(@Query("firstName") String firstName);

  //  @GET(ApiList.POP_API)
  //  Observable<PopMusic> getPopMusic();


}
