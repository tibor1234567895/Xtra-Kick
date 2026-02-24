package com.google.gson.internal.bind;

import j9.b0;
import j9.c0;
import j9.s;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import o9.a;

public final class s0 {
    public static final i0 A;
    public static final c0 B;
    public static final c0 C = new TypeAdapters$30();

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f4048a = new TypeAdapters$32(Class.class, new y().a());

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f4049b = new TypeAdapters$32(BitSet.class, new j0().a());

    /* renamed from: c  reason: collision with root package name */
    public static final m0 f4050c = new m0();

    /* renamed from: d  reason: collision with root package name */
    public static final c0 f4051d;

    /* renamed from: e  reason: collision with root package name */
    public static final c0 f4052e = new TypeAdapters$33(Byte.TYPE, Byte.class, new n0());

    /* renamed from: f  reason: collision with root package name */
    public static final c0 f4053f = new TypeAdapters$33(Short.TYPE, Short.class, new o0());

    /* renamed from: g  reason: collision with root package name */
    public static final c0 f4054g = new TypeAdapters$33(Integer.TYPE, Integer.class, new p0());

    /* renamed from: h  reason: collision with root package name */
    public static final c0 f4055h = new TypeAdapters$32(AtomicInteger.class, new q0().a());

    /* renamed from: i  reason: collision with root package name */
    public static final c0 f4056i = new TypeAdapters$32(AtomicBoolean.class, new r0().a());

    /* renamed from: j  reason: collision with root package name */
    public static final c0 f4057j = new TypeAdapters$32(AtomicIntegerArray.class, new o().a());

    /* renamed from: k  reason: collision with root package name */
    public static final p f4058k = new p();

    /* renamed from: l  reason: collision with root package name */
    public static final c0 f4059l = new TypeAdapters$32(Number.class, new s());

    /* renamed from: m  reason: collision with root package name */
    public static final c0 f4060m = new TypeAdapters$33(Character.TYPE, Character.class, new t());

    /* renamed from: n  reason: collision with root package name */
    public static final v f4061n = new v();

    /* renamed from: o  reason: collision with root package name */
    public static final w f4062o = new w();

    /* renamed from: p  reason: collision with root package name */
    public static final c0 f4063p;

    /* renamed from: q  reason: collision with root package name */
    public static final c0 f4064q = new TypeAdapters$32(StringBuilder.class, new x());

    /* renamed from: r  reason: collision with root package name */
    public static final c0 f4065r = new TypeAdapters$32(StringBuffer.class, new z());

    /* renamed from: s  reason: collision with root package name */
    public static final c0 f4066s = new TypeAdapters$32(URL.class, new a0());

    /* renamed from: t  reason: collision with root package name */
    public static final c0 f4067t = new TypeAdapters$32(URI.class, new b0());

    /* renamed from: u  reason: collision with root package name */
    public static final c0 f4068u = new TypeAdapters$35(InetAddress.class, new c0());

    /* renamed from: v  reason: collision with root package name */
    public static final c0 f4069v = new TypeAdapters$32(UUID.class, new d0());

    /* renamed from: w  reason: collision with root package name */
    public static final c0 f4070w = new TypeAdapters$32(Currency.class, new e0().a());

    /* renamed from: x  reason: collision with root package name */
    public static final c0 f4071x = new TypeAdapters$26();

    /* renamed from: y  reason: collision with root package name */
    public static final c0 f4072y = new TypeAdapters$34(new g0());

    /* renamed from: z  reason: collision with root package name */
    public static final c0 f4073z = new TypeAdapters$32(Locale.class, new h0());

    static {
        l0 l0Var = new l0();
        f4051d = new TypeAdapters$33(Boolean.TYPE, Boolean.class, l0Var);
        new q();
        new r();
        u uVar = new u();
        f4063p = new TypeAdapters$32(String.class, uVar);
        i0 i0Var = new i0();
        A = i0Var;
        B = new TypeAdapters$35(s.class, i0Var);
    }

    private s0() {
        throw new UnsupportedOperationException();
    }

    public static c0 a(Class cls, b0 b0Var) {
        return new TypeAdapters$32(cls, b0Var);
    }

    public static c0 b(Class cls, Class cls2, b0 b0Var) {
        return new TypeAdapters$33(cls, cls2, b0Var);
    }

    public static c0 c(a aVar, b0 b0Var) {
        return new TypeAdapters$31(aVar, b0Var);
    }
}
