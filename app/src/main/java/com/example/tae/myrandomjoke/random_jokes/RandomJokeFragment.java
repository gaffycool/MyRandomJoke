package com.example.tae.myrandomjoke.random_jokes;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tae.myrandomjoke.R;
import com.example.tae.myrandomjoke.data.network.AppDataManager;
import com.example.tae.myrandomjoke.data.network.model.RandomJoke;
import com.example.tae.myrandomjoke.ui.base.BaseFragment;
import com.example.tae.myrandomjoke.ui.utils.rx.AppSchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;


/**
 * A simple {@link Fragment} subclass.
 */
public class RandomJokeFragment extends BaseFragment implements IRandomJokeMvpView{

    private RandomJokesImpl<RandomJokeFragment> randomJokeFragmentRandomJokesPresenter;
    public RandomJokeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        randomJokeFragmentRandomJokesPresenter = new RandomJokesImpl<>(new AppDataManager(),
                new AppSchedulerProvider(), new CompositeDisposable());
        randomJokeFragmentRandomJokesPresenter.onAttach(this);
        return inflater.inflate(R.layout.fragment_random_joke, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        randomJokeFragmentRandomJokesPresenter.loadRandomJokes();
    }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(RandomJoke randomJoke) {

        Toast.makeText(getActivity(), "Random joke: " + randomJoke.getValue().getJoke(), Toast.LENGTH_LONG).show();
       // randomJokeFragmentRandomJokesPresenter.loadRandomJokes();
    }

    @Override
    public void onFetchDataError(String error) {
        Toast.makeText(getActivity(), "error: " + error.toString(), Toast.LENGTH_LONG).show();

    }
}
