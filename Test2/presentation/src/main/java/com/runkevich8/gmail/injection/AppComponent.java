package com.runkevich8.gmail.injection;


import com.runkevich8.gmail.presentation.screens.user.UserViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    public void inject(UserViewModel userViewModel);


}
