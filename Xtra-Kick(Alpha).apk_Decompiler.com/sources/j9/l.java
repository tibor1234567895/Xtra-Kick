package j9;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class l extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8855a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b0 f8856b;

    public /* synthetic */ l(b0 b0Var, int i10) {
        this.f8855a = i10;
        this.f8856b = b0Var;
    }

    public final Object b(JsonReader jsonReader) {
        int i10 = this.f8855a;
        b0 b0Var = this.f8856b;
        switch (i10) {
            case 0:
                return new AtomicLong(((Number) b0Var.b(jsonReader)).longValue());
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) b0Var.b(jsonReader)).longValue()));
                }
                jsonReader.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i11 = 0; i11 < size; i11++) {
                    atomicLongArray.set(i11, ((Long) arrayList.get(i11)).longValue());
                }
                return atomicLongArray;
            default:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return b0Var.b(jsonReader);
                }
                jsonReader.nextNull();
                return null;
        }
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        int i10 = this.f8855a;
        b0 b0Var = this.f8856b;
        switch (i10) {
            case 0:
                b0Var.c(jsonWriter, Long.valueOf(((AtomicLong) obj).get()));
                return;
            case 1:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                jsonWriter.beginArray();
                int length = atomicLongArray.length();
                for (int i11 = 0; i11 < length; i11++) {
                    b0Var.c(jsonWriter, Long.valueOf(atomicLongArray.get(i11)));
                }
                jsonWriter.endArray();
                return;
            default:
                if (obj == null) {
                    jsonWriter.nullValue();
                    return;
                } else {
                    b0Var.c(jsonWriter, obj);
                    return;
                }
        }
    }
}
