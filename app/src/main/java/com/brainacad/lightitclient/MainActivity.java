package com.brainacad.lightitclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.brainacad.lightitclient.api.Constants;
import com.brainacad.lightitclient.api.models.ResProduct;
import com.brainacad.lightitclient.api.models.auth.ReqAuthorization;
import com.brainacad.lightitclient.api.models.comm.ReqComment;
import com.brainacad.lightitclient.api.models.regist.ReqRegistration;
import com.brainacad.lightitclient.api.network.ApiManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.list_item);
        ApiManager apiManager = new ApiManager();

        //registration
        //apiManager.registration(new ReqRegistration("test101", "test101"));
//
        // authorization
        //apiManager.login(new ReqAuthorization("test101", "test101"));

        //getListProducts
//        apiManager.getProductList(new ApiManager.OnProductResponse() {
//            @Override
//            public void onProductRes(List<ResProduct> list) {
//                for (ResProduct p : list) {
//                    Log.d(Constants.TAG, " onProductRes: " +
//                            "\n" + p.getId() +
//                            "\n" + p.getImg() +
//                            "\n" + p.getText() +
//                            "\n" + p.getTitle());
//                }
//            }
//        });

        // getComments
//        apiManager.getCommentsAboutProduct(1);
//        apiManager.getCommentsAboutProduct(2);

        // setComment
        String token = LightItClientApp.getAppInstance().getSharedPreferences().getString("token", null);
        Log.d(Constants.TAG, "onCreate: " + token);

        String tokenStr = "Token " + token;

        //apiManager.postCommentAboutProduct(tokenStr, 1, new ReqComment(5, ":)))"));
        apiManager.postCommentAboutProduct(tokenStr,2, new ReqComment(5, "good)))"));


/*        imageView = findViewById(R.id.image_url);
        Picasso picasso = Picasso.get();
        picasso.load("http://smktesting.herokuapp.com/static/img2.png")
                .into(imageView);
*/

    }

}
