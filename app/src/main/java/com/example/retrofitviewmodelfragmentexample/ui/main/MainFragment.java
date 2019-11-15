package com.example.retrofitviewmodelfragmentexample.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.retrofitviewmodelfragmentexample.R;
import com.example.retrofitviewmodelfragmentexample.adapter.CustomAdapter;
import com.example.retrofitviewmodelfragmentexample.api.PhotoApi;
import com.example.retrofitviewmodelfragmentexample.model.Photo;
import com.example.retrofitviewmodelfragmentexample.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private PhotoApi photoApi;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<Photo> photoList = new ArrayList<>();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        photoApi = retrofit.create(PhotoApi.class);


        return inflater.inflate(R.layout.main_fragment, container, false);
    }


    private void displayData(List<Photo> photos) {

        mRecyclerView = getView().findViewById(R.id.recycler_view);
        if(mAdapter == null) {
            mAdapter = new CustomAdapter(getContext(), photos);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.init();

        mViewModel.getPhotoRepsitory().subscribe(new Observer<List<Photo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Photo> photos) {
                photoList.addAll(photos);
                displayData(photoList);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }
}
