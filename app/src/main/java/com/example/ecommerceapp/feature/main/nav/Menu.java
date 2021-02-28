package com.example.ecommerceapp.feature.main.nav;


import com.example.ecommerceapp.util.AppAction;

import java.io.Serializable;

public class Menu implements Serializable {

    private int menuTitle = 0;
    private int menuIcon = 0;
    private AppAction action;

    public Menu() {
    }

    public Menu(int menuTitle, int menuIcon, AppAction action) {
        this.menuTitle = menuTitle;

        this.menuIcon = menuIcon;
        this.action = action;
    }

    public int getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(int menuTitle) {
        this.menuTitle = menuTitle;
    }
    public int getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(int menuIcon) {
        this.menuIcon = menuIcon;
    }

    public AppAction getAction() {
        return action;
    }

    public void setAction(AppAction action) {
        this.action = action;
    }
}
