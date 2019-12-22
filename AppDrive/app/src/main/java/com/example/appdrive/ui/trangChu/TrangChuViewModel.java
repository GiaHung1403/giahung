package com.example.appdrive.ui.trangChu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrangChuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TrangChuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}