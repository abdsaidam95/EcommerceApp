package com.example.ecommerceapp.util;

public enum AppAction {

    ACTION_SET_LANGUAGE_ARABIC("ACTION_SET_LANGUAGE_ARABIC"),
    ACTION_LANGUAGE_DIALOG("ACTION_LANGUAGE_DIALOG"),
    ACTION_ON_BOARDING("ACTION_ON_BOARDING"),
    ACTION_LOGIN("ACTION_LOGIN"),
    ACTION_REGISTER("ACTION_REGISTER"),
    ACTION_GO_LOGIN("ACTION_GO_LOGIN"),
    ACTION_CHANGE_PASSWORD("ACTION_CHANGE_PASSWORD"),



    ;

    private final String action;

    AppAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
