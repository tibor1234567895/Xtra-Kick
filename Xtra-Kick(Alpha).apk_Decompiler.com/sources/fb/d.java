package fb;

import android.support.v4.media.h;
import cb.e;
import java.util.Iterator;
import java.util.NoSuchElementException;
import xa.j;
import ya.a;

public final class d implements Iterator, a {

    /* renamed from: h  reason: collision with root package name */
    public int f5991h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f5992i;

    /* renamed from: j  reason: collision with root package name */
    public int f5993j;

    /* renamed from: k  reason: collision with root package name */
    public e f5994k;

    /* renamed from: l  reason: collision with root package name */
    public int f5995l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ e f5996m;

    public d(e eVar) {
        this.f5996m = eVar;
        int i10 = eVar.f5998b;
        int length = eVar.f5997a.length();
        if (length >= 0) {
            if (i10 < 0) {
                i10 = 0;
            } else if (i10 > length) {
                i10 = length;
            }
            this.f5992i = i10;
            this.f5993j = i10;
            return;
        }
        throw new IllegalArgumentException(h.j("Cannot coerce value to an empty range: maximum ", length, " is less than minimum 0."));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        if (r6 < r3) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r7 = this;
            int r0 = r7.f5993j
            r1 = 0
            if (r0 >= 0) goto L_0x000b
            r7.f5991h = r1
            r0 = 0
            r7.f5994k = r0
            goto L_0x0077
        L_0x000b:
            fb.e r2 = r7.f5996m
            int r3 = r2.f5999c
            r4 = -1
            r5 = 1
            if (r3 <= 0) goto L_0x001a
            int r6 = r7.f5995l
            int r6 = r6 + r5
            r7.f5995l = r6
            if (r6 >= r3) goto L_0x0022
        L_0x001a:
            java.lang.CharSequence r3 = r2.f5997a
            int r3 = r3.length()
            if (r0 <= r3) goto L_0x0034
        L_0x0022:
            cb.e r0 = new cb.e
            int r1 = r7.f5992i
            java.lang.CharSequence r2 = r2.f5997a
            int r2 = fb.y.q(r2)
            r0.<init>(r1, r2)
        L_0x002f:
            r7.f5994k = r0
            r7.f5993j = r4
            goto L_0x0075
        L_0x0034:
            wa.p r0 = r2.f6000d
            java.lang.CharSequence r3 = r2.f5997a
            int r6 = r7.f5993j
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.g(r3, r6)
            la.i r0 = (la.i) r0
            if (r0 != 0) goto L_0x0054
            cb.e r0 = new cb.e
            int r1 = r7.f5992i
            java.lang.CharSequence r2 = r2.f5997a
            int r2 = fb.y.q(r2)
            r0.<init>(r1, r2)
            goto L_0x002f
        L_0x0054:
            java.lang.Object r2 = r0.f9799h
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.f9800i
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r7.f5992i
            cb.e r3 = cb.l.c(r3, r2)
            r7.f5994k = r3
            int r2 = r2 + r0
            r7.f5992i = r2
            if (r0 != 0) goto L_0x0072
            r1 = 1
        L_0x0072:
            int r2 = r2 + r1
            r7.f5993j = r2
        L_0x0075:
            r7.f5991h = r5
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fb.d.a():void");
    }

    public final boolean hasNext() {
        if (this.f5991h == -1) {
            a();
        }
        return this.f5991h == 1;
    }

    public final Object next() {
        if (this.f5991h == -1) {
            a();
        }
        if (this.f5991h != 0) {
            e eVar = this.f5994k;
            j.d("null cannot be cast to non-null type kotlin.ranges.IntRange", eVar);
            this.f5994k = null;
            this.f5991h = -1;
            return eVar;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
