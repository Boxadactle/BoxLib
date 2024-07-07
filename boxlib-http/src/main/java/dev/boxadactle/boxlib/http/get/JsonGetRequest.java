package dev.boxadactle.boxlib.http.get;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.boxadactle.boxlib.http.HttpGetRequest;
import net.minecraft.util.GsonHelper;

/**
 * Represents a JSON GET request that extends the {@link HttpGetRequest} interface.
 * This interface provides a callback method to handle the JSON response.
 */
public interface JsonGetRequest extends HttpGetRequest<JsonElement> {

    /**
     * Callback method that is called when a successful response is received.
     * Parses the response into a {@link JsonObject} and calls the {@link #onJson(JsonObject)} method.
     *
     * @param response the JSON response as a string
     */
    @Override
    default JsonElement handleResponse(String response) {
        return GsonHelper.parse(response);
    }

}
