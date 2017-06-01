package com.example.android.twobuttonfragmentcomm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondFragment extends Fragment implements View.OnClickListener {
    private Button hiButton;
    private Button byeButton;
    private TextView resultTV;
    private SecondCommsCallback callback;

    public interface SecondCommsCallback {
        void sayMessageTwo(String message);
    }

    public SecondFragment() {
        // Required empty public constructor
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (SecondCommsCallback) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement SecondCommsCallback");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,
                container, false);
        resultTV = (TextView) view.findViewById(R.id.resultTwo_TV);
        hiButton = (Button) view.findViewById(R.id.hi_button);
        byeButton = (Button) view.findViewById(R.id.bye_button);
        hiButton.setOnClickListener(this);
        byeButton.setOnClickListener(this);
        return view;
    }

    public void setText(String message) {
        resultTV.setText(message);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hi_button:
                callback.sayMessageTwo("Hi, One!");
                break;
            case R.id.bye_button:
                callback.sayMessageTwo("Bye, One!");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

}