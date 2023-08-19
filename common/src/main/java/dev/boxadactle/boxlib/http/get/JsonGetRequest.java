package dev.boxadactle.boxlib.http.get;

import com.google.gson.JsonObject;
import dev.boxadactle.boxlib.http.HttpGetRequest;
import net.minecraft.util.GsonHelper;

public interface JsonGetRequest extends HttpGetRequest {

    @Override
    default void onOkResponse(String response) {
        JsonObject res = GsonHelper.parse(response);
        onJson(res);
    }

    void onJson(JsonObject json);

}
