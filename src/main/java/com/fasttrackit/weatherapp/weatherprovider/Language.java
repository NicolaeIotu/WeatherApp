package com.fasttrackit.weatherapp.weatherprovider;

import java.util.HashMap;

public abstract class Language {
	
	public String code(LanguageType languageType) {
		return langCodes.get(languageType);
	}

	private HashMap<LanguageType, String> langCodes = populateMap();
	
	private static HashMap<LanguageType, String> populateMap() {
		HashMap<LanguageType,String> map = new HashMap<LanguageType,String>();
	    map.put(LanguageType.ARABIC, "ar");
	    map.put(LanguageType.BULGARIAN, "bg");
	    return map;
	}
	
}
