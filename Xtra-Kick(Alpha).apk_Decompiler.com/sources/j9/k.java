package j9;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public final class k extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return Long.valueOf(jsonReader.nextLong());
        }
        jsonReader.nextNull();
        return null;
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        Number number = (Number) obj;
        if (number == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(number.toString());
        }
    }
}
