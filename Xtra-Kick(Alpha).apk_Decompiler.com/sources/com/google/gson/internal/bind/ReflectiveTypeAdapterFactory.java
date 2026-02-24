package com.google.gson.internal.bind;

import com.google.gson.internal.Excluder;
import j9.c0;
import j9.i;
import k5.a;
import n9.b;

public final class ReflectiveTypeAdapterFactory implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public final a f3981h;

    /* renamed from: i  reason: collision with root package name */
    public final i f3982i;

    /* renamed from: j  reason: collision with root package name */
    public final Excluder f3983j;

    /* renamed from: k  reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f3984k;

    /* renamed from: l  reason: collision with root package name */
    public final b f3985l = b.f11760a;

    public ReflectiveTypeAdapterFactory(a aVar, j9.b bVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f3981h = aVar;
        this.f3982i = bVar;
        this.f3983j = excluder;
        this.f3984k = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01a9, code lost:
        r27 = r7;
        r6 = new o9.a(l9.e.g(r1, r27, r27.getGenericSuperclass(), new java.util.HashSet()));
        r7 = r6.f12361a;
        r0 = r33;
        r11 = r34;
        r12 = r12;
        r8 = r8;
        r9 = r9;
        r10 = r10;
        r13 = r13;
        r15 = r15;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0189 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x016e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j9.b0 a(j9.n r34, o9.a r35) {
        /*
            r33 = this;
            r0 = r33
            r11 = r34
            r12 = r35
            java.lang.Class r1 = r12.f12361a
            java.lang.Class<java.lang.Object> r13 = java.lang.Object.class
            boolean r2 = r13.isAssignableFrom(r1)
            r14 = 0
            if (r2 != 0) goto L_0x0012
            return r14
        L_0x0012:
            k5.a r15 = r0.f3981h
            l9.p r10 = r15.f(r12)
            com.google.gson.internal.bind.i r9 = new com.google.gson.internal.bind.i
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            boolean r2 = r1.isInterface()
            if (r2 == 0) goto L_0x002a
        L_0x0025:
            r13 = r8
            r14 = r9
            r15 = r10
            goto L_0x01d8
        L_0x002a:
            r7 = r1
            r6 = r12
        L_0x002c:
            if (r7 == r13) goto L_0x0025
            java.lang.reflect.Field[] r5 = r7.getDeclaredFields()
            int r4 = r5.length
            r3 = 0
            r2 = 0
        L_0x0035:
            java.lang.reflect.Type r1 = r6.f12362b
            if (r2 >= r4) goto L_0x01a9
            r14 = r5[r2]
            r16 = r13
            r13 = 1
            boolean r17 = r0.b(r14, r13)
            boolean r18 = r0.b(r14, r3)
            if (r17 != 0) goto L_0x005d
            if (r18 != 0) goto L_0x005d
            r21 = r2
            r22 = r4
            r30 = r5
            r31 = r6
            r27 = r7
            r13 = r8
            r14 = r9
            r23 = r15
            r25 = 0
            r15 = r10
            goto L_0x016e
        L_0x005d:
            n9.b r3 = r0.f3985l
            r3.a(r14)
            java.lang.reflect.Type r3 = r14.getGenericType()
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
            java.lang.reflect.Type r13 = l9.e.g(r1, r7, r3, r13)
            java.lang.Class<k9.b> r1 = k9.b.class
            java.lang.annotation.Annotation r1 = r14.getAnnotation(r1)
            k9.b r1 = (k9.b) r1
            if (r1 != 0) goto L_0x0086
            j9.i r1 = r0.f3982i
            java.lang.String r1 = r1.a(r14)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r21 = r2
            goto L_0x0097
        L_0x0086:
            java.lang.String r3 = r1.value()
            java.lang.String[] r1 = r1.alternate()
            r21 = r2
            int r2 = r1.length
            if (r2 != 0) goto L_0x009d
            java.util.List r1 = java.util.Collections.singletonList(r3)
        L_0x0097:
            r22 = r4
            r20 = 1
            r4 = r1
            goto L_0x00bd
        L_0x009d:
            java.util.ArrayList r2 = new java.util.ArrayList
            r22 = r4
            int r4 = r1.length
            r20 = 1
            int r4 = r4 + 1
            r2.<init>(r4)
            r2.add(r3)
            int r3 = r1.length
            r4 = 0
        L_0x00ae:
            if (r4 >= r3) goto L_0x00bc
            r23 = r3
            r3 = r1[r4]
            r2.add(r3)
            int r4 = r4 + 1
            r3 = r23
            goto L_0x00ae
        L_0x00bc:
            r4 = r2
        L_0x00bd:
            int r3 = r4.size()
            r1 = 0
            r2 = 0
        L_0x00c3:
            if (r2 >= r3) goto L_0x015e
            java.lang.Object r23 = r4.get(r2)
            r12 = r23
            java.lang.String r12 = (java.lang.String) r12
            r23 = r9
            if (r2 == 0) goto L_0x00d3
            r17 = 0
        L_0x00d3:
            o9.a r9 = new o9.a
            r9.<init>(r13)
            r24 = r1
            java.lang.Class r1 = r9.f12361a
            r25 = r2
            java.util.Map r2 = l9.r.f9793a
            boolean r26 = r2.containsKey(r1)
            java.lang.Class<k9.a> r1 = k9.a.class
            java.lang.annotation.Annotation r1 = r14.getAnnotation(r1)
            k9.a r1 = (k9.a) r1
            if (r1 == 0) goto L_0x00f8
            com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory r2 = r0.f3984k
            r2.getClass()
            j9.b0 r1 = com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.b(r15, r11, r9, r1)
            goto L_0x00f9
        L_0x00f8:
            r1 = 0
        L_0x00f9:
            if (r1 == 0) goto L_0x00fe
            r27 = 1
            goto L_0x0100
        L_0x00fe:
            r27 = 0
        L_0x0100:
            if (r1 != 0) goto L_0x0106
            j9.b0 r1 = r11.b(r9)
        L_0x0106:
            r28 = r1
            com.google.gson.internal.bind.h r2 = new com.google.gson.internal.bind.h
            r0 = r24
            r1 = r2
            r11 = r2
            r24 = r25
            r2 = r12
            r19 = r3
            r25 = 0
            r3 = r17
            r29 = r4
            r4 = r18
            r30 = r5
            r5 = r14
            r31 = r6
            r6 = r27
            r27 = r7
            r7 = r28
            r28 = r13
            r13 = r8
            r8 = r34
            r32 = r14
            r14 = r23
            r23 = r15
            r15 = r10
            r10 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            java.lang.Object r1 = r13.put(r12, r11)
            com.google.gson.internal.bind.h r1 = (com.google.gson.internal.bind.h) r1
            if (r0 != 0) goto L_0x0140
            goto L_0x0141
        L_0x0140:
            r1 = r0
        L_0x0141:
            int r2 = r24 + 1
            r0 = r33
            r11 = r34
            r12 = r35
            r8 = r13
            r9 = r14
            r10 = r15
            r3 = r19
            r15 = r23
            r7 = r27
            r13 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r14 = r32
            goto L_0x00c3
        L_0x015e:
            r0 = r1
            r30 = r5
            r31 = r6
            r27 = r7
            r13 = r8
            r14 = r9
            r23 = r15
            r25 = 0
            r15 = r10
            if (r0 != 0) goto L_0x0189
        L_0x016e:
            int r2 = r21 + 1
            r0 = r33
            r11 = r34
            r12 = r35
            r8 = r13
            r9 = r14
            r10 = r15
            r13 = r16
            r4 = r22
            r15 = r23
            r7 = r27
            r5 = r30
            r6 = r31
            r3 = 0
            r14 = 0
            goto L_0x0035
        L_0x0189:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = r35
            java.lang.reflect.Type r3 = r3.f12362b
            r2.append(r3)
            java.lang.String r3 = " declares multiple JSON fields named "
            r2.append(r3)
            java.lang.String r0 = r0.f4022a
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01a9:
            r27 = r7
            r14 = r9
            r3 = r12
            r16 = r13
            r23 = r15
            r13 = r8
            r15 = r10
            java.lang.reflect.Type r0 = r27.getGenericSuperclass()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r4 = r27
            java.lang.reflect.Type r0 = l9.e.g(r1, r4, r0, r2)
            o9.a r6 = new o9.a
            r6.<init>(r0)
            java.lang.Class r7 = r6.f12361a
            r0 = r33
            r11 = r34
            r12 = r3
            r8 = r13
            r9 = r14
            r10 = r15
            r13 = r16
            r15 = r23
            r14 = 0
            goto L_0x002c
        L_0x01d8:
            r14.<init>(r15, r13)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a(j9.n, o9.a):j9.b0");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        if (r0 == false) goto L_0x0067;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00af A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.reflect.Field r9, boolean r10) {
        /*
            r8 = this;
            java.lang.Class r0 = r9.getType()
            com.google.gson.internal.Excluder r1 = r8.f3983j
            boolean r0 = r1.b(r0)
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0013
            r1.c(r10)
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            if (r0 != 0) goto L_0x00b0
            int r0 = r9.getModifiers()
            int r4 = r1.f3973i
            r0 = r0 & r4
            if (r0 == 0) goto L_0x0020
            goto L_0x0084
        L_0x0020:
            double r4 = r1.f3972h
            r6 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x003f
            java.lang.Class<k9.c> r0 = k9.c.class
            java.lang.annotation.Annotation r0 = r9.getAnnotation(r0)
            k9.c r0 = (k9.c) r0
            java.lang.Class<k9.d> r4 = k9.d.class
            java.lang.annotation.Annotation r4 = r9.getAnnotation(r4)
            k9.d r4 = (k9.d) r4
            boolean r0 = r1.d(r0, r4)
            if (r0 != 0) goto L_0x003f
            goto L_0x0084
        L_0x003f:
            boolean r0 = r9.isSynthetic()
            if (r0 == 0) goto L_0x0046
            goto L_0x0084
        L_0x0046:
            boolean r0 = r1.f3974j
            if (r0 != 0) goto L_0x0067
            java.lang.Class r0 = r9.getType()
            boolean r4 = r0.isMemberClass()
            if (r4 == 0) goto L_0x0063
            int r0 = r0.getModifiers()
            r0 = r0 & 8
            if (r0 == 0) goto L_0x005e
            r0 = 1
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            if (r0 != 0) goto L_0x0063
            r0 = 1
            goto L_0x0064
        L_0x0063:
            r0 = 0
        L_0x0064:
            if (r0 == 0) goto L_0x0067
            goto L_0x0084
        L_0x0067:
            java.lang.Class r0 = r9.getType()
            java.lang.Class<java.lang.Enum> r4 = java.lang.Enum.class
            boolean r4 = r4.isAssignableFrom(r0)
            if (r4 != 0) goto L_0x0081
            boolean r4 = r0.isAnonymousClass()
            if (r4 != 0) goto L_0x007f
            boolean r0 = r0.isLocalClass()
            if (r0 == 0) goto L_0x0081
        L_0x007f:
            r0 = 1
            goto L_0x0082
        L_0x0081:
            r0 = 0
        L_0x0082:
            if (r0 == 0) goto L_0x0086
        L_0x0084:
            r9 = 1
            goto L_0x00ad
        L_0x0086:
            if (r10 == 0) goto L_0x008b
            java.util.List r10 = r1.f3975k
            goto L_0x008d
        L_0x008b:
            java.util.List r10 = r1.f3976l
        L_0x008d:
            boolean r0 = r10.isEmpty()
            if (r0 != 0) goto L_0x00ac
            b4.e0 r0 = new b4.e0
            r0.<init>((java.lang.reflect.Field) r9)
            java.util.Iterator r9 = r10.iterator()
            boolean r10 = r9.hasNext()
            if (r10 != 0) goto L_0x00a3
            goto L_0x00ac
        L_0x00a3:
            java.lang.Object r9 = r9.next()
            android.support.v4.media.h.y(r9)
            r9 = 0
            throw r9
        L_0x00ac:
            r9 = 0
        L_0x00ad:
            if (r9 != 0) goto L_0x00b0
            r2 = 1
        L_0x00b0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b(java.lang.reflect.Field, boolean):boolean");
    }
}
