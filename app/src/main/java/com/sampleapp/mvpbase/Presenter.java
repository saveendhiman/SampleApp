package com.sampleapp.mvpbase;

/**
 * Created by saveen_dhiman on 05-November-16.
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}