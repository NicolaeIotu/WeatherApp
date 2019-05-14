package com.fasttrackit.weatherapp.weatherprovider;

import java.util.HashMap;

public abstract class Language {
	
	private static HashMap<LanguageType, String> codes = new HashMap<LanguageType, String>() {

		private static final long serialVersionUID = 5586738318755832019L;

		{
			put(LanguageType.ARABIC, "ar");
		    put(LanguageType.BULGARIAN, "bg");
		    put(LanguageType.CATALAN, "ca");
		    put(LanguageType.CHINESE_SIMPLIFIED, "zh_cn");
		    put(LanguageType.CHINESE_TRADITIONAL, "zh_tw");
		    put(LanguageType.CROATIAN, "hr");
		    put(LanguageType.CZECH, "cz");
		    put(LanguageType.DUTCH, "nl");
		    put(LanguageType.ENGLISH, "en");
		    put(LanguageType.FINNISH, "fi");
		    put(LanguageType.FRENCH, "fr");
		    put(LanguageType.GALICIAN, "gl");
		    put(LanguageType.GERMAN, "de");
		    put(LanguageType.GREEK, "el");
		    put(LanguageType.HUNGARIAN, "hu");
		    put(LanguageType.ITALIAN, "it");
		    put(LanguageType.JAPANESE, "ja");
		    put(LanguageType.KOREAN, "kr");
		    put(LanguageType.LATVIAN, "la");
		    put(LanguageType.LITHUANIAN, "lt");
		    put(LanguageType.MACEDONIAN, "mk");
		    put(LanguageType.PERSIAN, "fa");
		    put(LanguageType.POLISH, "pl");
		    put(LanguageType.PORTUGUESE, "pt");
		    put(LanguageType.ROMANIAN, "ro");
		    put(LanguageType.RUSSIAN, "ru");
		    put(LanguageType.SLOVAK, "sk");
		    put(LanguageType.SLOVENIAN, "sl");
		    put(LanguageType.SPANISH, "es");
		    put(LanguageType.SWEDISH, "se");
		    put(LanguageType.TURKISH, "tr");
		    put(LanguageType.UKRAINIAN, "ua");
		    put(LanguageType.VIETNAMESE, "vi");
        };
    };

	public static String getCode(LanguageType languageType) {
		return codes.get(languageType);
	}
    
    
	
//	Arabic - ar, Bulgarian - bg, Catalan - ca, Czech - cz, German - de, Greek - el, English - en, 
//Persian (Farsi) - fa, Finnish - fi, French - fr, Galician - gl, Croatian - hr, Hungarian - hu, 
//Italian - it, Japanese - ja, Korean - kr, Latvian - la, Lithuanian - lt, Macedonian - mk, Dutch - nl, 
//Polish - pl, Portuguese - pt, Romanian - ro, Russian - ru, Swedish - se, Slovak - sk, Slovenian - sl, 
//Spanish - es, Turkish - tr, Ukrainian - ua, Vietnamese - vi, Chinese Simplified - zh_cn, Chinese Traditional - zh_tw
	
//	private static HashMap<LanguageType, String> populateMap() {
//		HashMap<LanguageType,String> map = new HashMap<LanguageType,String>();
//	    map.put(LanguageType.ARABIC, "ar");
//	    map.put(LanguageType.BULGARIAN, "bg");
//	    map.put(LanguageType.CATALAN, "ca");
//	    map.put(LanguageType.CHINESE_SIMPLIFIED, "zh_cn");
//	    map.put(LanguageType.CHINESE_TRADITIONAL, "zh_tw");
//	    map.put(LanguageType.CROATIAN, "hr");
//	    map.put(LanguageType.CZECH, "cz");
//	    map.put(LanguageType.DUTCH, "nl");
//	    map.put(LanguageType.ENGLISH, "en");
//	    map.put(LanguageType.FINNISH, "fi");
//	    map.put(LanguageType.FRENCH, "fr");
//	    map.put(LanguageType.GALICIAN, "gl");
//	    map.put(LanguageType.GERMAN, "de");
//	    map.put(LanguageType.GREEK, "el");
//	    map.put(LanguageType.HUNGARIAN, "hu");
//	    map.put(LanguageType.ITALIAN, "it");
//	    map.put(LanguageType.JAPANESE, "ja");
//	    map.put(LanguageType.KOREAN, "kr");
//	    map.put(LanguageType.LATVIAN, "la");
//	    map.put(LanguageType.LITHUANIAN, "lt");
//	    map.put(LanguageType.MACEDONIAN, "mk");
//	    map.put(LanguageType.PERSIAN, "fa");
//	    map.put(LanguageType.POLISH, "pl");
//	    map.put(LanguageType.PORTUGUESE, "pt");
//	    map.put(LanguageType.ROMANIAN, "ro");
//	    map.put(LanguageType.RUSSIAN, "ru");
//	    map.put(LanguageType.SLOVAK, "sk");
//	    map.put(LanguageType.SLOVENIAN, "sl");
//	    map.put(LanguageType.SPANISH, "es");
//	    map.put(LanguageType.SWEDISH, "se");
//	    map.put(LanguageType.TURKISH, "tr");
//	    map.put(LanguageType.UKRAINIAN, "ua");
//	    map.put(LanguageType.VIETNAMESE, "vi");
//
//	    return map;
//	}

	
}
