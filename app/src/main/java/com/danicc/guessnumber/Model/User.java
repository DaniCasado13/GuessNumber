package com.danicc.guessnumber.Model;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    Integer Attempts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAttempts() {
        return Attempts;
    }

    public void setAttempts(Integer attempts) {
        Attempts = attempts;
    }
}
