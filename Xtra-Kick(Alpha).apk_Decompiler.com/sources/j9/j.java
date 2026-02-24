package j9;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public final class j extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8854a;

    public /* synthetic */ j(int i10) {
        this.f8854a = i10;
    }

    public final Object b(JsonReader jsonReader) {
        switch (this.f8854a) {
            case 0:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            default:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
        }
    }

    public final /* bridge */ /* synthetic */ void c(JsonWriter jsonWriter, Object obj) {
        switch (this.f8854a) {
            case 0:
                d(jsonWriter, (Number) obj);
                return;
            default:
                d(jsonWriter, (Number) obj);
                return;
        }
    }

    public final void d(JsonWriter jsonWriter, Number number) {
        switch (this.f8854a) {
            case 0:
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                n.a(number.doubleValue());
                jsonWriter.value(number);
                return;
            default:
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                n.a((double) number.floatValue());
                jsonWriter.value(number);
                return;
        }
    }
}
