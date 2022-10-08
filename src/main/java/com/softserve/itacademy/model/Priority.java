package com.softserve.itacademy.model;

public enum Priority {
    LOW, MEDIUM, HIGH;
    public String info() {
        return name().substring(0,1) + name().toLowerCase().substring(1);
    }
}