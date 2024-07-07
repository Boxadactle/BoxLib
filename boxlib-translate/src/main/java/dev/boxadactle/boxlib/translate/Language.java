package dev.boxadactle.boxlib.translate;

/**
 * The `Language` enum represents different languages and their corresponding codes.
 * Each language is associated with a code that can be used for language translation or identification purposes.
 */
public enum Language {

    AUTO("auto"),
    AFRIKAANS("af"),
    ALBANIAN("sq"),
    AMHARIC("am"),
    ARABIC("ar"),
    ARMENIAN("hy"),
    AZERBAIJANI("az"),
    BASQUE("eu"),
    BELARUSIAN("be"),
    BENGALI("bn"),
    BOSNIAN("bs"),
    BULGARIAN("bg"),
    CATALAN("ca"),
    CEBUANO("ceb"),
    CHICHEWA("ny"),
    CHINESE("zh-CN"),
    CHINESE_TRADITIONAL("zh-TW"),
    CORSICAN("co"),
    CROATIAN("hr"),
    CZECH("cs"),
    DANISH("da"),
    DUTCH("nl"),
    ENGLISH("en"),
    ESPERANTO("eo"),
    ESTONIAN("et"),
    FILIPINO("tl"),
    FINNISH("fi"),
    FRENCH("fr"),
    FRISIAN("fy"),
    GALICIAN("gl"),
    GEORGIAN("ka"),
    GERMAN("de"),
    GREEK("el"),
    GUJARATI("gu"),
    HAITIAN_CREOLE("ht"),
    HAUSA("ha"),
    HAWAIIAN("haw"),
    HEBREW("iw"),
    HINDI("hi"),
    HMONG("hmn"),
    HUNGARIAN("hu"),
    ICELANDIC("is"),
    IGBO("ig"),
    INDONESIAN("id"),
    IRISH("ga"),
    ITALIAN("it"),
    JAPANESE("ja"),
    JAVANESE("jw"),
    KANNADA("kn"),
    KAZAKH("kk"),
    KHMER("km"),
    KOREAN("ko"),
    KURDISH("ku"),
    KYRGYZ("ky"),
    LAO("lo"),
    LATIN("la"),
    LATVIAN("lv"),
    LITHUANIAN("lt"),
    LUXEMBOURGISH("lb"),
    MACEDONIAN("mk"),
    MALAGASY("mg"),
    MALAY("ms"),
    MALAYALAM("ml"),
    MALTESE("mt"),
    MAORI("mi"),
    MARATHI("mr"),
    MONGOLIAN("mn"),
    MYANMAR_BURMESE("my"),
    NEPALI("ne"),
    NORWEGIAN("no"),
    ODIA("or"),
    PASHTO("ps"),
    PERSIAN("fa"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    PUNJABI("pa"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    SAMOAN("sm"),
    SCOTS_GAELIC("gd"),
    SERBIAN("sr"),
    SESOTHO("st"),
    SHONA("sn"),
    SINDHI("sd"),
    SINHALA("si"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SOMALI("so"),
    SPANISH("es"),
    SUNDANESE("su"),
    SWAHILI("sw"),
    SWEDISH("sv"),
    TAJIK("tg"),
    TAMIL("ta"),
    TATAR("tt"),
    TELUGU("te"),
    THAI("th"),
    TURKISH("tr"),
    TURKMEN("tk"),
    UKRAINIAN("uk"),
    URDU("ur"),
    UYGHUR("ug"),
    UZBEK("uz"),
    VIETNAMESE("vi"),
    WELSH("cy"),
    XHOSA("xh"),
    YIDDISH("yi"),
    YORUBA("yo"),
    ZULU("zu");

    final String code;

    Language(String code) {
        this.code = code;
    }

    /**
     * Returns the code associated with this language.
     *
     * @return the language code
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the Language enum constant that matches the given code.
     *
     * @param code the language code
     * @return the Language enum constant that matches the given code, or AUTO if no match is found
     */
    public static Language fromCode(String code) {
        for (Language language : values()) {
            if (language.code.equals(code)) {
                return language;
            }
        }
        return AUTO;
    }

    /**
     * Returns the Language enum constant that matches the specified name, ignoring case.
     * If no matching constant is found, returns the AUTO constant.
     *
     * @param name the name of the language
     * @return the Language enum constant that matches the specified name, or AUTO if no match is found
     */
    public static Language fromName(String name) {
        for (Language language : values()) {
            if (language.name().equalsIgnoreCase(name)) {
                return language;
            }
        }
        return AUTO;
    }
}
