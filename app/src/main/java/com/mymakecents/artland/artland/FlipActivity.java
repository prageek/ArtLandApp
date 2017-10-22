package com.mymakecents.artland.artland;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlipActivity extends AppCompatActivity implements QRFragment.OnFragmentInteractionListener {

    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout;
    private View mCardBackLayout;
    private Uri file;
    private String mScanCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip);
        findViews();
        loadAnimations();
        changeCameraDistance();
        //postSomeStuffToBackEnd();

    }

    private void postSomeStuffToBackEnd() {

    }

    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mCardFrontLayout.setCameraDistance(scale);
        mCardBackLayout.setCameraDistance(scale);
    }

    private void loadAnimations() {
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);
    }

    private void findViews() {
        mCardBackLayout = findViewById(R.id.card_back);
        mCardFrontLayout = findViewById(R.id.card_front);
    }

    public void performQRScan(){
        startQRScanner();
        //       QRFragment newFragment = new QRFragment();
//        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.qrContainer, newFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();

//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.qrContainer, newFragment);
//        transaction.commit();
    }

    public void flipCard(View view) {
        if (mIsBackVisible) {


//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            mSetRightOut.setTarget(mCardBackLayout);
            mSetLeftIn.setTarget(mCardFrontLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;

        } else {
            if(mScanCode==null || "".equals(mScanCode)) {
                performQRScan();
            }
            mSetRightOut.setTarget(mCardFrontLayout);
            mSetLeftIn.setTarget(mCardBackLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;
            TextView tv = (TextView) mCardBackLayout.findViewById(R.id.textView2);
            tv.setText(mScanCode);
        }
    }

    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = Uri.fromFile(getOutputMediaFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);

        startActivityForResult(intent, 100);
    }

    private void startQRScanner() {
        new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result =   IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this,    "Cancelled",Toast.LENGTH_LONG).show();
            } else if(requestCode == 100){
                if (resultCode == RESULT_OK) {
                    ImageView imageView = (ImageView) FlipActivity.this.findViewById(R.id.photoImg);
                    imageView.setImageURI(file);
                    updateText(result.getContents());
                }



            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    private void updateText(String scanCode) {
        Toast.makeText(FlipActivity.this, scanCode, Toast.LENGTH_SHORT).show();
        SharedPreferences pref = FlipActivity.this.getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("qrcode", scanCode);
        mScanCode = scanCode;
        //tvCardText.setText(scanCode);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //Toast.makeText(uri.get, "QR", Toast.LENGTH_SHORT).show();
    }

    private static File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");
    }
}
