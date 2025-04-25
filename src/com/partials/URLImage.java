package com.partials;

public class URLImage {
    public imageIcon usernameIcon = new imageIcon("src/com/main/resources/images/username(green).png", 0, 0, 25, 25);
    public imageIcon passwordIcon = new imageIcon("src/com/main/resources/images/password(green).png", 0, 0, 25, 25);
    public imageIcon hidePasswordIcon = new imageIcon("src/com/main/resources/images/hidePassword(green).png", 0, 0, 25,
            25);
    public imageIcon showPasswordIcon = new imageIcon("src/com/main/resources/images/showPassword(green).png", 0, 0, 25,
            25);

    public imageIcon getUsernameIcon() {
        return usernameIcon;
    }

    public imageIcon getPasswordIcon() {
        return passwordIcon;
    }

    public imageIcon getHidePasswordIcon() {
        return hidePasswordIcon;
    }

    public imageIcon getShowPasswordIcon(){
        return showPasswordIcon;
    }
}
