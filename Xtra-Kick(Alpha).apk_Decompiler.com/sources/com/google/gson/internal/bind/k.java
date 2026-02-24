package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.c0;
import j9.t;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class k extends b0 {

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f4035b = new TimeTypeAdapter$1();

    /* renamed from: a  reason: collision with root package name */
    public final SimpleDateFormat f4036a = new SimpleDateFormat("hh:mm:ss a");

    public final Object b(JsonReader jsonReader) {
        synchronized (this) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                Time time = new Time(this.f4036a.parse(jsonReader.nextString()).getTime());
                return time;
            } catch (ParseException e10) {
                throw new t((Exception) e10);
            }
        }
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        Time time = (Time) obj;
        synchronized (this) {
            if (time == null) {
                str = null;
            } else {
                str = this.f4036a.format(time);
            }
            jsonWriter.value(str);
        }
    }
}
