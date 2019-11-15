package com.example.retrofitviewmodelfragmentexample.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;

import com.example.retrofitviewmodelfragmentexample.model.Photo;
import com.example.retrofitviewmodelfragmentexample.network.RetrofitClientInstance;
import com.example.retrofitviewmodelfragmentexample.api.PhotoApi;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PhotoRepository {

    private static PhotoRepository photoRepository;

    public static PhotoRepository getInstance(){
        if (photoRepository == null){
            photoRepository = new PhotoRepository();
        }
        return photoRepository;
    }

    private PhotoApi photoApi;

    public PhotoRepository(){
        photoApi = RetrofitClientInstance.getRetrofitInstance().create(PhotoApi.class);
    }

    public Observable<List<Photo>> getPhoto(){
        return photoApi.getAllPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
