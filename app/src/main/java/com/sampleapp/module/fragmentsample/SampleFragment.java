package com.sampleapp.module.fragmentsample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sampleapp.R;
import com.sampleapp.base.BaseFragment;
import com.sampleapp.base.SampleApplication;
import com.sampleapp.utils.AppUtils;
import com.sampleapp.utils.ProgressBarHandler;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by saveen_dhiman on 05-August-17.
 * SHow user last login time and uploaded forms
 */
public class SampleFragment extends BaseFragment implements SampleView {

//    @BindView(R.id.txtUserName)
//    TextView mTxtUserName;

    LinearLayoutManager mLinearLayoutManager;
    @Inject
    ProgressBarHandler mProgressBarHandler;
    @Inject
    AppUtils mAppUtils;
    @Inject
    SamplePresenter mPresenter;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_sample;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((SampleApplication) getActivity().getApplication()).getAppComponent().inject(this);
        mPresenter.attachView(this);
        mPresenter.injectDependency(getActivity());
        init();
    }

    //noting much just initial work and API call
    private void init() {


    }


    @Override
    public void showProgress() {

            mProgressBarHandler.showProgress();
    }

    @Override
    public void hideProgress() {
        mProgressBarHandler.hideProgress();

    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
//        mAppUtils.showSnackBar(mRecyclerForms, mAppUtils.getErrorMessage(throwable));
    }

    @Override
    public void onException(String message) {
//        mAppUtils.showSnackBar(mRecyclerForms, message);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }
}
