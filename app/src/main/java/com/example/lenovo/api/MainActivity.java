package com.example.lenovo.api;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.lenovo.api.adapter.ItemAdapter;
import com.example.lenovo.api.databinding.ActivityMainBinding;
import com.example.lenovo.api.model.Name;
import com.example.lenovo.api.model.UserResponse;
import com.example.lenovo.api.model.UserkuResponse;
import com.example.lenovo.api.network.ApiClient;
import com.example.lenovo.api.network.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ItemAdapter adapter;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(R.layout.activity_main);
       // loadUserAsync(10);
        createUserku();

    }
    private void loadUserAsync(int result) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<UserResponse> call = apiInterface.getUser(result);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                showData(userResponse);
                Toast.makeText(MainActivity.this, "S", Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("Error", t.toString());
                Toast.makeText(MainActivity.this, "E", Toast.LENGTH_SHORT ).show();
            }
        });
    }

    private void get() {
        $nama = "fauzi";
        $status = "nikah"

        return json;
    }
    private void showData(UserResponse userResponse) {
        adapter = new ItemAdapter(userResponse.getResults());
        binding.setAdapter(adapter);
    }
    private void createUserku() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<UserkuResponse> call = apiInterface.postUserku("pjkk@gmail.com", "oji",
                "ll", "male");
        call.enqueue(new Callback<UserkuResponse>() {
            @Override
            public void onResponse(Call<UserkuResponse> call, Response<UserkuResponse> response) {
                UserkuResponse userkuResponse = response.body();
                Toast.makeText(MainActivity.this, String.valueOf(response.code()),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserkuResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void initList(){

        adapter = new ItemAdapter(new ArrayList<Name>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        this.binding.mainRcvItem.setLayoutManager(layoutManager);
        this.binding.mainRcvItem.setAdapter(adapter);
        adapter.add(new Name("Mr","Achmad","Fauzi"));
    }
}
