package com.aashi.movieBookingSys.services;

import com.aashi.movieBookingSys.Exceptions.LanguageDetailsNotFoundException;
import com.aashi.movieBookingSys.entities.Language;

import java.util.List;

public interface LanguageService {
    public Language acceptLanguageDetails(Language language);
    public Language getLanguageDetails(int id) throws LanguageDetailsNotFoundException;
    public Language getLanguageDetailsByLanguageName(String languageName) throws LanguageDetailsNotFoundException;
    public boolean deleteLanguage(int id) throws LanguageDetailsNotFoundException;
    public List<Language> getAllLanguageDetails();
}
