package com.santossingh.popularmovieapp.Services;

import com.santossingh.popularmovieapp.Services.Interfaces.MovieAPI;
import com.santossingh.popularmovieapp.Services.Interfaces.MoviesService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Stark on 18/04/2016.
 */
public class ServiceManager implements MoviesService {
    private MovieAPI movies;

    public void RetrofitOutput(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constant.HTTP.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        movies= retrofit.create(MovieAPI.class);
    }

    @Override
    public MovieAPI getJSONData() {
        if (movies==null){
            RetrofitOutput();
        }
        return movies;
    }
}
