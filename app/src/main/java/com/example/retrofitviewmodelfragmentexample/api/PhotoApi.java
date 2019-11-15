package com.example.retrofitviewmodelfragmentexample.api;

import com.example.retrofitviewmodelfragmentexample.model.Photo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PhotoApi {
    @GET("/photos")
    Observable<List<Photo>> getAllPhotos();
}
