package com.aashi.movieBookingSys.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Language {

    @Id
    @GeneratedValue
    private int languageId;
    @Column(length = 20, nullable = false, unique = true)
    private String languageName;
    public int getLanguageId() {
        return languageId;
    }
    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
    public String getLanguageName() {
        return languageName;
    }
    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
    @Override
    public String toString() {
        return "Language{" + "languageId=" + languageId + ", languageName='" + languageName + '\'' + '}';
    }
}
