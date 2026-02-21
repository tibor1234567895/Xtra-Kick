package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.n;
import java.sql.Timestamp;
import java.util.Date;
import o9.a;

final class TypeAdapters$26 implements c0 {
    public final b0 a(n nVar, a aVar) {
        if (aVar.f12361a != Timestamp.class) {
            return null;
        }
        nVar.getClass();
        return new f0(this, nVar.b(new a(Date.class)), 0);
    }
}
