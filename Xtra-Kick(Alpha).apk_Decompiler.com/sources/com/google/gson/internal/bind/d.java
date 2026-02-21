package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import j9.p;
import j9.s;
import j9.u;
import j9.v;
import j9.x;
import java.io.IOException;
import java.util.ArrayList;

public final class d extends JsonWriter {

    /* renamed from: k  reason: collision with root package name */
    public static final c f4007k = new c();

    /* renamed from: l  reason: collision with root package name */
    public static final x f4008l = new x("closed");

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f4009h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public String f4010i;

    /* renamed from: j  reason: collision with root package name */
    public s f4011j = u.f8877h;

    public d() {
        super(f4007k);
    }

    public final JsonWriter beginArray() {
        p pVar = new p();
        e(pVar);
        this.f4009h.add(pVar);
        return this;
    }

    public final JsonWriter beginObject() {
        v vVar = new v();
        e(vVar);
        this.f4009h.add(vVar);
        return this;
    }

    public final s c() {
        ArrayList arrayList = this.f4009h;
        return (s) arrayList.get(arrayList.size() - 1);
    }

    public final void close() {
        ArrayList arrayList = this.f4009h;
        if (arrayList.isEmpty()) {
            arrayList.add(f4008l);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public final void e(s sVar) {
        if (this.f4010i != null) {
            sVar.getClass();
            if (!(sVar instanceof u) || getSerializeNulls()) {
                ((v) c()).f8878h.put(this.f4010i, sVar);
            }
            this.f4010i = null;
        } else if (this.f4009h.isEmpty()) {
            this.f4011j = sVar;
        } else {
            s c10 = c();
            if (c10 instanceof p) {
                p pVar = (p) c10;
                if (sVar == null) {
                    pVar.getClass();
                    sVar = u.f8877h;
                }
                pVar.f8876h.add(sVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final JsonWriter endArray() {
        ArrayList arrayList = this.f4009h;
        if (arrayList.isEmpty() || this.f4010i != null) {
            throw new IllegalStateException();
        } else if (c() instanceof p) {
            arrayList.remove(arrayList.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final JsonWriter endObject() {
        ArrayList arrayList = this.f4009h;
        if (arrayList.isEmpty() || this.f4010i != null) {
            throw new IllegalStateException();
        } else if (c() instanceof v) {
            arrayList.remove(arrayList.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final void flush() {
    }

    public final JsonWriter name(String str) {
        if (this.f4009h.isEmpty() || this.f4010i != null) {
            throw new IllegalStateException();
        } else if (c() instanceof v) {
            this.f4010i = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final JsonWriter nullValue() {
        e(u.f8877h);
        return this;
    }

    public final JsonWriter value(double d10) {
        if (isLenient() || (!Double.isNaN(d10) && !Double.isInfinite(d10))) {
            e(new x((Number) Double.valueOf(d10)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d10);
    }

    public final JsonWriter value(long j10) {
        e(new x((Number) Long.valueOf(j10)));
        return this;
    }

    public final JsonWriter value(Boolean bool) {
        if (bool == null) {
            e(u.f8877h);
            return this;
        }
        e(new x(bool));
        return this;
    }

    public final JsonWriter value(Number number) {
        if (number == null) {
            e(u.f8877h);
            return this;
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        e(new x(number));
        return this;
    }

    public final JsonWriter value(String str) {
        if (str == null) {
            e(u.f8877h);
            return this;
        }
        e(new x(str));
        return this;
    }

    public final JsonWriter value(boolean z10) {
        e(new x(Boolean.valueOf(z10)));
        return this;
    }
}
