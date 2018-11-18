package com.brainacad.lightitclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.brainacad.lightitclient.api.Constants;
import com.brainacad.lightitclient.api.models.ResProduct;
import com.brainacad.lightitclient.api.models.regist.ReqRegistration;
import com.brainacad.lightitclient.api.network.ApiManager;
import com.brainacad.lightitclient.trash.models.LoginUserRequest;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.list_item);
        ApiManager apiManager = new ApiManager();


        apiManager.registration(new ReqRegistration("t101", "t101"));
/*        apiManager.getProductList(new ApiManager.OnProductResponse() {
            @Override
            public void onProductRes(List<ResProduct> list) {
                for (ResProduct p : list) {
                    Log.d(Constants.TAG, " onProductRes: " +
                            "\n" + p.getId() +
                            "\n" + p.getImg() +
                            "\n" + p.getText() +
                            "\n" + p.getTitle());
                }
            }
        });*/

/*        imageView = findViewById(R.id.image_url);
        Picasso picasso = Picasso.get();
        picasso.load("http://smktesting.herokuapp.com/static/img2.png")
                .into(imageView);
*/



        /*LoginUserRequest userRequest = new LoginUserRequest();
        userRequest.setUsername("user");
        userRequest.setPassword("user123");
        new ApiManager().login(userRequest);*/
//        new ApiManager().registration(userRequest.getUsername(), userRequest.getPassword());



    }

}
