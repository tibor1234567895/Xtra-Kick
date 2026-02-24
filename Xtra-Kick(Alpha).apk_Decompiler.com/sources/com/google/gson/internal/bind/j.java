package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j9.b0;
import j9.c0;
import j9.t;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class j extends b0 {

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f4033b = new SqlDateTypeAdapter$1();

    /* renamed from: a  reason: collision with root package name */
    public final SimpleDateFormat f4034a = new SimpleDateFormat("MMM d, yyyy");

    public final Object b(JsonReader jsonReader) {
        synchronized (this) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                Date date = new Date(this.f4034a.parse(jsonReader.nextString()).getTime());
                return date;
            } catch (ParseException e10) {
                throw new t((Exception) e10);
            }
        }
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        String str;
        Date date = (Date) obj;
        synchronized (this) {
            if (date == null) {
                str = null;
            } else {
                str = this.f4034a.format(date);
            }
            jsonWriter.value(str);
        }
    }
}
