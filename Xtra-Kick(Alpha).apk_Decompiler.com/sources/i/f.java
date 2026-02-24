package i;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import f0.k;

public final class f extends k implements k {
    public boolean A;

    /* renamed from: w  reason: collision with root package name */
    public b f7894w;

    /* renamed from: x  reason: collision with root package name */
    public e f7895x;

    /* renamed from: y  reason: collision with root package name */
    public int f7896y;

    /* renamed from: z  reason: collision with root package name */
    public int f7897z;

    public f() {
        this((b) null, (Resources) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0274, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static i.f g(android.content.Context r23, android.content.res.Resources.Theme r24, android.content.res.Resources r25, android.util.AttributeSet r26, android.content.res.XmlResourceParser r27) {
        /*
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            java.lang.String r4 = r27.getName()
            java.lang.String r5 = "animated-selector"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x0275
            i.f r4 = new i.f
            r4.<init>()
            int[] r5 = j.c.f8377a
            android.content.res.TypedArray r5 = d0.t.h(r1, r0, r2, r5)
            r6 = 1
            boolean r7 = r5.getBoolean(r6, r6)
            r4.setVisible(r7, r6)
            i.b r7 = r4.f7894w
            int r8 = r7.f7902d
            int r9 = j.b.b(r5)
            r8 = r8 | r9
            r7.f7902d = r8
            boolean r8 = r7.f7907i
            r9 = 2
            boolean r8 = r5.getBoolean(r9, r8)
            r7.f7907i = r8
            boolean r8 = r7.f7910l
            r10 = 3
            boolean r8 = r5.getBoolean(r10, r8)
            r7.f7910l = r8
            int r8 = r7.f7924z
            r11 = 4
            int r8 = r5.getInt(r11, r8)
            r7.f7924z = r8
            r8 = 5
            int r12 = r7.A
            int r8 = r5.getInt(r8, r12)
            r7.A = r8
            boolean r7 = r7.f7922x
            r8 = 0
            boolean r7 = r5.getBoolean(r8, r7)
            r4.setDither(r7)
            i.h r7 = r4.f7926h
            if (r1 == 0) goto L_0x007b
            r7.f7900b = r1
            android.util.DisplayMetrics r12 = r25.getDisplayMetrics()
            int r12 = r12.densityDpi
            if (r12 != 0) goto L_0x0070
            r12 = 160(0xa0, float:2.24E-43)
        L_0x0070:
            int r13 = r7.f7901c
            r7.f7901c = r12
            if (r13 == r12) goto L_0x007e
            r7.f7911m = r8
            r7.f7908j = r8
            goto L_0x007e
        L_0x007b:
            r7.getClass()
        L_0x007e:
            r5.recycle()
            int r5 = r27.getDepth()
            int r5 = r5 + r6
            r12 = r23
            r7 = r0
        L_0x0089:
            int r13 = r27.next()
            if (r13 == r6) goto L_0x026d
            int r14 = r27.getDepth()
            if (r14 >= r5) goto L_0x0097
            if (r13 == r10) goto L_0x026d
        L_0x0097:
            if (r13 == r9) goto L_0x009a
            goto L_0x0089
        L_0x009a:
            if (r14 <= r5) goto L_0x009d
            goto L_0x0089
        L_0x009d:
            java.lang.String r13 = r27.getName()
            java.lang.String r14 = "item"
            boolean r13 = r13.equals(r14)
            r14 = 0
            r15 = -1
            if (r13 == 0) goto L_0x016a
            int[] r13 = j.c.f8378b
            android.content.res.TypedArray r13 = d0.t.h(r1, r7, r2, r13)
            int r16 = r13.getResourceId(r8, r8)
            int r15 = r13.getResourceId(r6, r15)
            if (r15 <= 0) goto L_0x00c3
            androidx.appcompat.widget.q3 r14 = androidx.appcompat.widget.q3.d()
            android.graphics.drawable.Drawable r14 = r14.f(r12, r15)
        L_0x00c3:
            r13.recycle()
            int r13 = r26.getAttributeCount()
            int[] r15 = new int[r13]
            r6 = 0
            r10 = 0
        L_0x00ce:
            if (r10 >= r13) goto L_0x00f2
            int r9 = r2.getAttributeNameResource(r10)
            if (r9 == 0) goto L_0x00ed
            r11 = 16842960(0x10100d0, float:2.369414E-38)
            if (r9 == r11) goto L_0x00ed
            r11 = 16843161(0x1010199, float:2.3694704E-38)
            if (r9 == r11) goto L_0x00ed
            int r11 = r6 + 1
            boolean r19 = r2.getAttributeBooleanValue(r10, r8)
            if (r19 == 0) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            int r9 = -r9
        L_0x00ea:
            r15[r6] = r9
            r6 = r11
        L_0x00ed:
            int r10 = r10 + 1
            r9 = 2
            r11 = 4
            goto L_0x00ce
        L_0x00f2:
            int[] r6 = android.util.StateSet.trimStateSet(r15, r6)
            java.lang.String r9 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"
            if (r14 != 0) goto L_0x0138
        L_0x00fa:
            int r10 = r27.next()
            r11 = 4
            if (r10 != r11) goto L_0x0102
            goto L_0x00fa
        L_0x0102:
            r11 = 2
            if (r10 != r11) goto L_0x011f
            java.lang.String r10 = r27.getName()
            java.lang.String r11 = "vector"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x011a
            c4.s r14 = new c4.s
            r14.<init>()
            r14.inflate(r1, r3, r2, r7)
            goto L_0x0138
        L_0x011a:
            android.graphics.drawable.Drawable r14 = j.b.a(r1, r3, r2, r7)
            goto L_0x0138
        L_0x011f:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r27.getPositionDescription()
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0138:
            if (r14 == 0) goto L_0x0151
            i.b r9 = r4.f7894w
            int r10 = r9.a(r14)
            int[][] r11 = r9.I
            r11[r10] = r6
            q.l r6 = r9.K
            java.lang.Integer r9 = java.lang.Integer.valueOf(r16)
            r6.f(r10, r9)
            r8 = r23
            goto L_0x0262
        L_0x0151:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r27.getPositionDescription()
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x016a:
            java.lang.String r6 = r27.getName()
            java.lang.String r9 = "transition"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x025d
            int[] r6 = j.c.f8379c
            android.content.res.TypedArray r6 = d0.t.h(r1, r7, r2, r6)
            r9 = 2
            int r10 = r6.getResourceId(r9, r15)
            r9 = 1
            int r11 = r6.getResourceId(r9, r15)
            int r13 = r6.getResourceId(r8, r15)
            if (r13 <= 0) goto L_0x0194
            androidx.appcompat.widget.q3 r14 = androidx.appcompat.widget.q3.d()
            android.graphics.drawable.Drawable r14 = r14.f(r12, r13)
        L_0x0194:
            r12 = 3
            boolean r13 = r6.getBoolean(r12, r8)
            r6.recycle()
            java.lang.String r6 = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable"
            if (r14 != 0) goto L_0x01e3
        L_0x01a0:
            int r14 = r27.next()
            r8 = 4
            if (r14 != r8) goto L_0x01a9
            r8 = 0
            goto L_0x01a0
        L_0x01a9:
            r8 = 2
            if (r14 != r8) goto L_0x01ca
            java.lang.String r14 = r27.getName()
            java.lang.String r8 = "animated-vector"
            boolean r8 = r14.equals(r8)
            if (r8 == 0) goto L_0x01c3
            c4.f r14 = new c4.f
            r8 = r23
            r14.<init>(r8)
            r14.inflate(r1, r3, r2, r0)
            goto L_0x01e5
        L_0x01c3:
            r8 = r23
            android.graphics.drawable.Drawable r14 = j.b.a(r1, r3, r2, r7)
            goto L_0x01e5
        L_0x01ca:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r27.getPositionDescription()
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01e3:
            r8 = r23
        L_0x01e5:
            if (r14 == 0) goto L_0x0244
            if (r10 == r15) goto L_0x0229
            if (r11 == r15) goto L_0x0229
            i.b r6 = r4.f7894w
            int r7 = r6.a(r14)
            long r14 = (long) r10
            r10 = 32
            long r17 = r14 << r10
            long r9 = (long) r11
            r20 = r13
            long r12 = r9 | r17
            if (r20 == 0) goto L_0x0203
            r17 = 8589934592(0x200000000, double:4.243991582E-314)
            goto L_0x0205
        L_0x0203:
            r17 = 0
        L_0x0205:
            q.i r11 = r6.J
            long r0 = (long) r7
            long r21 = r0 | r17
            java.lang.Long r7 = java.lang.Long.valueOf(r21)
            r11.a(r12, r7)
            if (r20 == 0) goto L_0x025f
            r7 = 32
            long r9 = r9 << r7
            long r9 = r9 | r14
            q.i r6 = r6.J
            r11 = 4294967296(0x100000000, double:2.121995791E-314)
            long r0 = r0 | r11
            long r0 = r0 | r17
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r6.a(r9, r0)
            goto L_0x025f
        L_0x0229:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r27.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": <transition> tag requires 'fromId' & 'toId' attributes"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0244:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r27.getPositionDescription()
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x025d:
            r8 = r23
        L_0x025f:
            r7 = r24
            r12 = r8
        L_0x0262:
            r0 = r24
            r1 = r25
            r6 = 1
            r8 = 0
            r9 = 2
            r10 = 3
            r11 = 4
            goto L_0x0089
        L_0x026d:
            int[] r0 = r4.getState()
            r4.onStateChange(r0)
            return r4
        L_0x0275:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r27.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": invalid animated-selector tag "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.f.g(android.content.Context, android.content.res.Resources$Theme, android.content.res.Resources, android.util.AttributeSet, android.content.res.XmlResourceParser):i.f");
    }

    public final h b() {
        return new b(this.f7894w, this, (Resources) null);
    }

    public final void e(h hVar) {
        super.e(hVar);
        if (hVar instanceof b) {
            this.f7894w = (b) hVar;
        }
    }

    public final j f() {
        return new b(this.f7894w, this, (Resources) null);
    }

    public final void jumpToCurrentState() {
        super.jumpToCurrentState();
        e eVar = this.f7895x;
        if (eVar != null) {
            eVar.d();
            this.f7895x = null;
            d(this.f7896y);
            this.f7896y = -1;
            this.f7897z = -1;
        }
    }

    public final Drawable mutate() {
        if (!this.A) {
            super.mutate();
            this.f7894w.e();
            this.A = true;
        }
        return this;
    }

    public final boolean onStateChange(int[] iArr) {
        boolean z10;
        int i10;
        int i11;
        boolean z11;
        e eVar;
        boolean z12;
        int[] iArr2 = iArr;
        b bVar = this.f7894w;
        int f10 = bVar.f(iArr2);
        if (f10 < 0) {
            f10 = bVar.f(StateSet.WILD_CARD);
        }
        int i12 = this.f7932n;
        boolean z13 = false;
        if (f10 != i12) {
            e eVar2 = this.f7895x;
            if (eVar2 != null) {
                if (f10 != this.f7896y) {
                    if (f10 != this.f7897z || !eVar2.a()) {
                        i12 = this.f7896y;
                        eVar2.d();
                    } else {
                        eVar2.b();
                        this.f7896y = this.f7897z;
                        this.f7897z = f10;
                    }
                }
                z10 = true;
                if (z10 || d(f10)) {
                    z13 = true;
                }
            }
            this.f7895x = null;
            this.f7897z = -1;
            this.f7896y = -1;
            b bVar2 = this.f7894w;
            if (i12 < 0) {
                bVar2.getClass();
                i10 = 0;
            } else {
                i10 = ((Integer) bVar2.K.d(i12, 0)).intValue();
            }
            if (f10 < 0) {
                i11 = 0;
            } else {
                i11 = ((Integer) bVar2.K.d(f10, 0)).intValue();
            }
            if (!(i11 == 0 || i10 == 0)) {
                long j10 = ((long) i11) | (((long) i10) << 32);
                int longValue = (int) ((Long) bVar2.J.e(j10, -1L)).longValue();
                if (longValue >= 0) {
                    if ((((Long) bVar2.J.e(j10, -1L)).longValue() & 8589934592L) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    d(longValue);
                    Drawable drawable = this.f7928j;
                    if (drawable instanceof AnimationDrawable) {
                        if ((((Long) bVar2.J.e(j10, -1L)).longValue() & 4294967296L) != 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        eVar = new c((AnimationDrawable) drawable, z12, z11);
                    } else if (drawable instanceof c4.f) {
                        eVar = new a((c4.f) drawable, 1);
                    } else if (drawable instanceof Animatable) {
                        eVar = new a((Animatable) drawable, 0);
                    }
                    eVar.c();
                    this.f7895x = eVar;
                    this.f7897z = i12;
                    this.f7896y = f10;
                    z10 = true;
                    z13 = true;
                }
            }
            z10 = false;
            z13 = true;
        }
        Drawable drawable2 = this.f7928j;
        if (drawable2 != null) {
            return z13 | drawable2.setState(iArr2);
        }
        return z13;
    }

    public final boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        e eVar = this.f7895x;
        if (eVar != null && (visible || z11)) {
            if (z10) {
                eVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public f(b bVar, Resources resources) {
        super(0);
        this.f7896y = -1;
        this.f7897z = -1;
        e(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
