package com.example.retrofitviewmodelfragmentexample.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofitviewmodelfragmentexample.api.PhotoApi;
import com.example.retrofitviewmodelfragmentexample.model.Photo;
import com.example.retrofitviewmodelfragmentexample.repository.PhotoRepository;

import java.util.List;

import io.reactivex.Observable;


public class MainViewModel extends ViewModel {
    private Observable<List<Photo>> photo;
    private PhotoRepository photoRespository;

    public void init() {
        if(photo != null)
            return;
        photoRespository = PhotoRepository.getInstance();
        photo = photoRespository.getPhoto();
    }

    public Observable<List<Photo>> getPhotoRepsitory(){
        return photo;
    }
}
