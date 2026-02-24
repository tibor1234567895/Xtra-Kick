package com.google.gson.internal;

import android.support.v4.media.h;
import j9.b0;
import j9.c0;
import j9.n;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k9.c;
import k9.d;
import l9.f;
import o9.a;

public final class Excluder implements c0, Cloneable {

    /* renamed from: m  reason: collision with root package name */
    public static final Excluder f3971m = new Excluder();

    /* renamed from: h  reason: collision with root package name */
    public final double f3972h = -1.0d;

    /* renamed from: i  reason: collision with root package name */
    public final int f3973i = 136;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f3974j = true;

    /* renamed from: k  reason: collision with root package name */
    public final List f3975k = Collections.emptyList();

    /* renamed from: l  reason: collision with root package name */
    public final List f3976l = Collections.emptyList();

    public final b0 a(n nVar, a aVar) {
        boolean z10;
        boolean z11;
        boolean b10 = b(aVar.f12361a);
        if (!b10) {
            c(true);
            z10 = false;
        } else {
            z10 = true;
        }
        if (!b10) {
            c(false);
            z11 = false;
        } else {
            z11 = true;
        }
        if (z10 || z11) {
            return new f(this, z11, z10, nVar, aVar);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.Class r7) {
        /*
            r6 = this;
            double r0 = r6.f3972h
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0020
            java.lang.Class<k9.c> r0 = k9.c.class
            java.lang.annotation.Annotation r0 = r7.getAnnotation(r0)
            k9.c r0 = (k9.c) r0
            java.lang.Class<k9.d> r1 = k9.d.class
            java.lang.annotation.Annotation r1 = r7.getAnnotation(r1)
            k9.d r1 = (k9.d) r1
            boolean r0 = r6.d(r0, r1)
            if (r0 != 0) goto L_0x0020
            return r4
        L_0x0020:
            boolean r0 = r6.f3974j
            r1 = 0
            if (r0 != 0) goto L_0x003e
            boolean r0 = r7.isMemberClass()
            if (r0 == 0) goto L_0x003a
            int r0 = r7.getModifiers()
            r0 = r0 & 8
            if (r0 == 0) goto L_0x0035
            r0 = 1
            goto L_0x0036
        L_0x0035:
            r0 = 0
        L_0x0036:
            if (r0 != 0) goto L_0x003a
            r0 = 1
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            if (r0 == 0) goto L_0x003e
            return r4
        L_0x003e:
            java.lang.Class<java.lang.Enum> r0 = java.lang.Enum.class
            boolean r0 = r0.isAssignableFrom(r7)
            if (r0 != 0) goto L_0x0054
            boolean r0 = r7.isAnonymousClass()
            if (r0 != 0) goto L_0x0052
            boolean r7 = r7.isLocalClass()
            if (r7 == 0) goto L_0x0054
        L_0x0052:
            r7 = 1
            goto L_0x0055
        L_0x0054:
            r7 = 0
        L_0x0055:
            if (r7 == 0) goto L_0x0058
            return r4
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.Excluder.b(java.lang.Class):boolean");
    }

    public final void c(boolean z10) {
        Iterator it = (z10 ? this.f3975k : this.f3976l).iterator();
        if (it.hasNext()) {
            h.y(it.next());
            throw null;
        }
    }

    public final Object clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public final boolean d(c cVar, d dVar) {
        boolean z10;
        boolean z11;
        double d10 = this.f3972h;
        if (cVar == null || cVar.value() <= d10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return false;
        }
        if (dVar == null || dVar.value() > d10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return true;
        }
        return false;
    }
}
