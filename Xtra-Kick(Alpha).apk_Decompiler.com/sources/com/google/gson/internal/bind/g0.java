package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class g0 extends b0 {
    public final Object b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        jsonReader.beginObject();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            int nextInt = jsonReader.nextInt();
            if ("year".equals(nextName)) {
                i10 = nextInt;
            } else if ("month".equals(nextName)) {
                i11 = nextInt;
            } else if ("dayOfMonth".equals(nextName)) {
                i12 = nextInt;
            } else if ("hourOfDay".equals(nextName)) {
                i13 = nextInt;
            } else if ("minute".equals(nextName)) {
                i14 = nextInt;
            } else if ("second".equals(nextName)) {
                i15 = nextInt;
            }
        }
        jsonReader.endObject();
        return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        Calendar calendar = (Calendar) obj;
        if (calendar == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name("year");
        jsonWriter.value((long) calendar.get(1));
        jsonWriter.name("month");
        jsonWriter.value((long) calendar.get(2));
        jsonWriter.name("dayOfMonth");
        jsonWriter.value((long) calendar.get(5));
        jsonWriter.name("hourOfDay");
        jsonWriter.value((long) calendar.get(11));
        jsonWriter.name("minute");
        jsonWriter.value((long) calendar.get(12));
        jsonWriter.name("second");
        jsonWriter.value((long) calendar.get(13));
        jsonWriter.endObject();
    }
}
