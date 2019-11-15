package com.example.retrofitviewmodelfragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofitviewmodelfragmentexample.adapter.CustomAdapter;
import com.example.retrofitviewmodelfragmentexample.api.PhotoApi;
import com.example.retrofitviewmodelfragmentexample.model.Photo;
import com.example.retrofitviewmodelfragmentexample.network.RetrofitClientInstance;
import com.example.retrofitviewmodelfragmentexample.ui.main.MainFragment;
import com.example.retrofitviewmodelfragmentexample.ui.main.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
