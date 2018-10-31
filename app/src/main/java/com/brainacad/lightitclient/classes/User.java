package com.brainacad.lightitclient.classes;

import com.google.gson.annotations.Expose;

public class User {

    @Expose(serialize = false)
    private int id;

    private String username;
    private String password;
}
