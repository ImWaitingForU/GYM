package com.chan.gym.beans;

/**
 * Created by Chan on 2016/6/27.
 * 商家bean
 */
public class GymBean {

    private String text;

    public GymBean (String text) {
        this.text = text;
    }

    public String getText () {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }
}
