package j9;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public final class m extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public b0 f8857a;

    public final Object b(JsonReader jsonReader) {
        b0 b0Var = this.f8857a;
        if (b0Var != null) {
            return b0Var.b(jsonReader);
        }
        throw new IllegalStateException();
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        b0 b0Var = this.f8857a;
        if (b0Var != null) {
            b0Var.c(jsonWriter, obj);
            return;
        }
        throw new IllegalStateException();
    }
}
