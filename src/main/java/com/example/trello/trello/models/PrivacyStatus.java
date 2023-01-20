package com.example.trello.trello.models;

public enum PrivacyStatus {
    PUBLIC("public"),
    PRIVATE("private");

    private String name;

    PrivacyStatus(String name) {
        this.name = name;
    }
}
