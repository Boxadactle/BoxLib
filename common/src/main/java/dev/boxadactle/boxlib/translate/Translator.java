package dev.boxadactle.boxlib.translate;

import com.google.common.html.HtmlEscapers;
import dev.boxadactle.boxlib.http.Request;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The `Translator` class provides methods for translating text from one language to another.
 * It uses Google Translate to perform the translation.
 */
public class Translator {

    static String regex = "<div class=\"result-container\">([^<]+)</div>";

    /**
     * Constructs the URL for the translation request.
     *
     * @param text        The text to be translated.
     * @param sourceLang  The source language of the text.
     * @param targetLang  The target language for the translation.
     * @return The URL for the translation request.
     */
    private static String getUrl(String text, String sourceLang, String targetLang) {
        return "https://translate.google.com/m?hl=en&sl=" +
                sourceLang + "&tl=" +
                targetLang + "&ie=UTF-8&prev=_m&q=" +
                URLEncoder.encode(text, StandardCharsets.UTF_8).replace("+", "%20");
    }

    /**
     * Decodes HTML-encoded text.
     *
     * @param text  The HTML-encoded text to be decoded.
     * @return The decoded text.
     */
    private static String decodeHTMLText(String text) {
        return HtmlEscapers.htmlEscaper().escape(text);
    }

    /**
     * Translates the given text from the source language to the target language.
     *
     * @param text        The text to be translated.
     * @param sourceLang  The source language of the text.
     * @param targetLang  The target language for the translation.
     * @return The translated text.
     */
    public static String translate(String text, Language sourceLang, Language targetLang) {
        String url = getUrl(text, sourceLang.getCode(), targetLang.getCode());
        String html = Request.sendPlainGetRequest(url);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        if (matcher.find()) {
            return decodeHTMLText(matcher.group(1));
        }

        return text;
    }

    /**
     * Translates the given text to the target language using automatic language detection.
     *
     * @param text        The text to be translated.
     * @param targetLang  The target language for the translation.
     * @return The translated text.
     */
    public static String translate(String text, Language targetLang) {
        return translate(text, Language.AUTO, targetLang);
    }
}
