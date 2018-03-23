package com.runkevich8.gmail.presentation.screens.user;

import android.arch.lifecycle.ViewModelProviders;

import com.runkevich8.gmail.presentation.base.BaseMvvmActivity;
import com.runkevich8.gmail.test.R;
import com.runkevich8.gmail.test.databinding.ActivityClasswork8Binding;

public class UserActivity extends BaseMvvmActivity<ActivityClasswork8Binding,UserViewModel> {

   // UserActivity = ActivityUserBinding
    //import com.runkevich8.gmail.test.databinding.ActivityClasswork8Binding;

    @Override
    public int provideLayoutId() {
        return R.layout.activity_classwork8;
    }

    @Override
    public UserViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserViewModel.class);

    }
}

