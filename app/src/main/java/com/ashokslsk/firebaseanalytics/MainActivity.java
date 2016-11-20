package com.ashokslsk.firebaseanalytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnlytics;
    private Button mFireclick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnlytics = FirebaseAnalytics.getInstance(this);
        mFireclick = (Button) findViewById(R.id.fire);

        mFireclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Firebase logevent
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID,"btn_click");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME,"Next Activty");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE,"Button");
                mFirebaseAnlytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT,bundle);

                mFirebaseAnlytics.setAnalyticsCollectionEnabled(true);

                mFirebaseAnlytics.setMinimumSessionDuration(20000);

                mFirebaseAnlytics.setSessionTimeoutDuration(500);

                mFirebaseAnlytics.setUserId("123");

                mFirebaseAnlytics.setUserProperty("123","Values");


            }
        });

    }
}
