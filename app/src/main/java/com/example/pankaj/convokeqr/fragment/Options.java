package com.example.pankaj.convokeqr.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pankaj.convokeqr.R;

public class Options extends Fragment implements View.OnClickListener {

    private OnOptionFragmentInteractionListener mListener;

    public Options() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Options.
     */
    // TODO: Rename and change types and number of parameters
    public static Options newInstance(String param1, String param2) {
        return new Options();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_options, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button check_in = view.findViewById(R.id.checkin);
        Button _150 = view.findViewById(R.id._150);
        Button _300 = view.findViewById(R.id._300);
        check_in.setOnClickListener(this);
        _150.setOnClickListener(this);
        _300.setOnClickListener(this);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOptionFragmentInteractionListener) {
            mListener = (OnOptionFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.checkin:
                mListener.onOptionFragmentInteraction("CheckIn");
                break;
            case R.id._150:
                mListener.onOptionFragmentInteraction("150");
                break;
            case R.id._300:
                mListener.onOptionFragmentInteraction("300");
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnOptionFragmentInteractionListener {
        // TODO: Update argument type and name
        void onOptionFragmentInteraction(String string);
    }
}
