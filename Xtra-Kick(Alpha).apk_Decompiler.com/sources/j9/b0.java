package j9;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public abstract class b0 {
    public final l a() {
        return new l(this, 2);
    }

    public abstract Object b(JsonReader jsonReader);

    public abstract void c(JsonWriter jsonWriter, Object obj);
}
