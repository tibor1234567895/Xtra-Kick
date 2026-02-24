package j9;

import com.google.gson.internal.bind.s0;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

public abstract class s {
    public int a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final p b() {
        if (this instanceof p) {
            return (p) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public final v c() {
        if (this instanceof v) {
            return (v) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public final x d() {
        if (this instanceof x) {
            return (x) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            s0.A.c(jsonWriter, this);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
