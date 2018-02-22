package com.example.tae.myrandomjoke.text_input;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tae.myrandomjoke.R;
import com.example.tae.myrandomjoke.data.network.AppDataManager;
import com.example.tae.myrandomjoke.data.network.model.RandomJoke;
import com.example.tae.myrandomjoke.random_jokes.RandomJokeFragment;
import com.example.tae.myrandomjoke.random_jokes.RandomJokesImpl;
import com.example.tae.myrandomjoke.ui.base.BaseFragment;
import com.example.tae.myrandomjoke.ui.utils.rx.AppSchedulerProvider;

import org.w3c.dom.Text;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by TAE on 22-Feb-18.
 */

public class TextInputFragment extends BaseFragment implements ITextInputJokeMvpView{

    private TextInputImpl<TextInputFragment> textInputFragmentTextInputPresenter;

    private EditText fName;
    private Button btnSubmit;
    private String mFirstName;
    public TextInputFragment()
    {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        textInputFragmentTextInputPresenter = new TextInputImpl(new AppDataManager(),
                new AppSchedulerProvider(), new CompositeDisposable());
        textInputFragmentTextInputPresenter.onAttach(this);

        return inflater.inflate(R.layout.fragment_text_input, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fName = view.findViewById(R.id.nfName);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirstName = fName.getText().toString();
                textInputFragmentTextInputPresenter.loadTextInputJokes(mFirstName);
            }
        });

    }

    @Override
    public void onFetchDataProgress() {

    }

    @Override
    public void onFetchDataSuccess(RandomJoke randomJoke) {

        Toast.makeText(getActivity(), "Custom Character '" + mFirstName + "'s Joke: " + randomJoke.getValue().getJoke(), Toast.LENGTH_LONG).show();

    }

    @Override
    public void onFetchDataError(String error) {

    }
}
