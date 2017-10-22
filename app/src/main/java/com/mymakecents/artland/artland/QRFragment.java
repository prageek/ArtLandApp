package com.mymakecents.artland.artland;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QRFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class QRFragment extends Fragment implements ZXingScannerView.ResultHandler{

    private OnFragmentInteractionListener mListener;

    private ZXingScannerView mScannerView;
    private LinearLayout qrCameraLayout;

    public QRFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(inflater.getContext(), "QR", Toast.LENGTH_SHORT).show();

        mScannerView = new ZXingScannerView(inflater.getContext());   // Programmatically initialize the scanner view
        //setContentView(mScannerView);

        View fragmentView = inflater.inflate(R.layout.fragment_qr, container, false);
        qrCameraLayout = (LinearLayout) fragmentView.findViewById(R.id.ll_qrcamera);
        //mScannerView = new ZXingScannerView(getActivity().getApplicationContext());

        mScannerView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        qrCameraLayout.removeAllViews();
        qrCameraLayout.addView(mScannerView);

        //return inflater.inflate(R.layout.fragment_qr, container, false);
        return qrCameraLayout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {


            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
    public void handleResult(Result result) {
        //MainActivity.tvresult.setText(rawResult.getText());
        //onBackPressed();
        result.getText();
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
