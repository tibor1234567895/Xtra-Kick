package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import java.sql.Date;
import o9.a;

final class SqlDateTypeAdapter$1 implements c0 {
    public final b0 a(n nVar, a aVar) {
        if (aVar.f12361a == Date.class) {
            return new j();
        }
        return null;
    }
}
