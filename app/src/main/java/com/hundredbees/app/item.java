package com.hundredbees.app;

public class item {
    int background;
    int profilepic;
    String profileName;

    public item() {
    }

    public item(int background, int profilepic, String profileName) {
        this.background = background;
        this.profilepic = profilepic;
        this.profileName = profileName;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(int profilepic) {
        this.profilepic = profilepic;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
