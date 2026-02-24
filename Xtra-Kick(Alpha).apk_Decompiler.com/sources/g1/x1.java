package g1;

import android.os.Bundle;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import j1.c;
import j1.l0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class x1 {

    /* renamed from: a  reason: collision with root package name */
    public int f6690a;

    /* renamed from: b  reason: collision with root package name */
    public int f6691b;

    /* renamed from: c  reason: collision with root package name */
    public int f6692c;

    /* renamed from: d  reason: collision with root package name */
    public int f6693d;

    /* renamed from: e  reason: collision with root package name */
    public int f6694e;

    /* renamed from: f  reason: collision with root package name */
    public int f6695f;

    /* renamed from: g  reason: collision with root package name */
    public int f6696g;

    /* renamed from: h  reason: collision with root package name */
    public int f6697h;

    /* renamed from: i  reason: collision with root package name */
    public int f6698i;

    /* renamed from: j  reason: collision with root package name */
    public int f6699j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f6700k;

    /* renamed from: l  reason: collision with root package name */
    public r0 f6701l;

    /* renamed from: m  reason: collision with root package name */
    public int f6702m;

    /* renamed from: n  reason: collision with root package name */
    public r0 f6703n;

    /* renamed from: o  reason: collision with root package name */
    public int f6704o;

    /* renamed from: p  reason: collision with root package name */
    public int f6705p;

    /* renamed from: q  reason: collision with root package name */
    public int f6706q;

    /* renamed from: r  reason: collision with root package name */
    public r0 f6707r;

    /* renamed from: s  reason: collision with root package name */
    public r0 f6708s;

    /* renamed from: t  reason: collision with root package name */
    public int f6709t;

    /* renamed from: u  reason: collision with root package name */
    public int f6710u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f6711v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f6712w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f6713x;

    /* renamed from: y  reason: collision with root package name */
    public HashMap f6714y;

    /* renamed from: z  reason: collision with root package name */
    public HashSet f6715z;

    @Deprecated
    public x1() {
        this.f6690a = Integer.MAX_VALUE;
        this.f6691b = Integer.MAX_VALUE;
        this.f6692c = Integer.MAX_VALUE;
        this.f6693d = Integer.MAX_VALUE;
        this.f6698i = Integer.MAX_VALUE;
        this.f6699j = Integer.MAX_VALUE;
        this.f6700k = true;
        p0 p0Var = r0.f4657i;
        r1 r1Var = r1.f4658l;
        this.f6701l = r1Var;
        this.f6702m = 0;
        this.f6703n = r1Var;
        this.f6704o = 0;
        this.f6705p = Integer.MAX_VALUE;
        this.f6706q = Integer.MAX_VALUE;
        this.f6707r = r1Var;
        this.f6708s = r1Var;
        this.f6709t = 0;
        this.f6710u = 0;
        this.f6711v = false;
        this.f6712w = false;
        this.f6713x = false;
        this.f6714y = new HashMap();
        this.f6715z = new HashSet();
    }

    public static r1 f(String[] strArr) {
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        for (String str : strArr) {
            str.getClass();
            o0Var.c(l0.I(str));
        }
        return o0Var.e();
    }

    public void a(w1 w1Var) {
        this.f6714y.put(w1Var.f6686h, w1Var);
    }

    public y1 b() {
        return new y1(this);
    }

    public x1 c() {
        this.f6714y.clear();
        return this;
    }

    public x1 d(int i10) {
        Iterator it = this.f6714y.values().iterator();
        while (it.hasNext()) {
            if (((w1) it.next()).f6686h.f6675j == i10) {
                it.remove();
            }
        }
        return this;
    }

    public final void e(y1 y1Var) {
        this.f6690a = y1Var.f6725h;
        this.f6691b = y1Var.f6726i;
        this.f6692c = y1Var.f6727j;
        this.f6693d = y1Var.f6728k;
        this.f6694e = y1Var.f6729l;
        this.f6695f = y1Var.f6730m;
        this.f6696g = y1Var.f6731n;
        this.f6697h = y1Var.f6732o;
        this.f6698i = y1Var.f6733p;
        this.f6699j = y1Var.f6734q;
        this.f6700k = y1Var.f6735r;
        this.f6701l = y1Var.f6736s;
        this.f6702m = y1Var.f6737t;
        this.f6703n = y1Var.f6738u;
        this.f6704o = y1Var.f6739v;
        this.f6705p = y1Var.f6740w;
        this.f6706q = y1Var.f6741x;
        this.f6707r = y1Var.f6742y;
        this.f6708s = y1Var.f6743z;
        this.f6709t = y1Var.A;
        this.f6710u = y1Var.B;
        this.f6711v = y1Var.C;
        this.f6712w = y1Var.D;
        this.f6713x = y1Var.E;
        this.f6715z = new HashSet(y1Var.G);
        this.f6714y = new HashMap(y1Var.F);
    }

    public x1 g() {
        this.f6710u = -3;
        return this;
    }

    public x1 h(w1 w1Var) {
        v1 v1Var = w1Var.f6686h;
        d(v1Var.f6675j);
        this.f6714y.put(v1Var, w1Var);
        return this;
    }

    public x1 i(int i10, boolean z10) {
        if (z10) {
            this.f6715z.add(Integer.valueOf(i10));
        } else {
            this.f6715z.remove(Integer.valueOf(i10));
        }
        return this;
    }

    public x1 j(int i10, int i11) {
        this.f6698i = i10;
        this.f6699j = i11;
        this.f6700k = true;
        return this;
    }

    public x1(Bundle bundle) {
        r1 r1Var;
        String str = y1.N;
        y1 y1Var = y1.H;
        this.f6690a = bundle.getInt(str, y1Var.f6725h);
        this.f6691b = bundle.getInt(y1.O, y1Var.f6726i);
        this.f6692c = bundle.getInt(y1.P, y1Var.f6727j);
        this.f6693d = bundle.getInt(y1.Q, y1Var.f6728k);
        this.f6694e = bundle.getInt(y1.R, y1Var.f6729l);
        this.f6695f = bundle.getInt(y1.S, y1Var.f6730m);
        this.f6696g = bundle.getInt(y1.T, y1Var.f6731n);
        this.f6697h = bundle.getInt(y1.U, y1Var.f6732o);
        this.f6698i = bundle.getInt(y1.V, y1Var.f6733p);
        this.f6699j = bundle.getInt(y1.W, y1Var.f6734q);
        this.f6700k = bundle.getBoolean(y1.X, y1Var.f6735r);
        String[] stringArray = bundle.getStringArray(y1.Y);
        this.f6701l = r0.k(stringArray == null ? new String[0] : stringArray);
        this.f6702m = bundle.getInt(y1.f6723g0, y1Var.f6737t);
        String[] stringArray2 = bundle.getStringArray(y1.I);
        this.f6703n = f(stringArray2 == null ? new String[0] : stringArray2);
        this.f6704o = bundle.getInt(y1.J, y1Var.f6739v);
        this.f6705p = bundle.getInt(y1.Z, y1Var.f6740w);
        this.f6706q = bundle.getInt(y1.f6717a0, y1Var.f6741x);
        String[] stringArray3 = bundle.getStringArray(y1.f6718b0);
        this.f6707r = r0.k(stringArray3 == null ? new String[0] : stringArray3);
        String[] stringArray4 = bundle.getStringArray(y1.K);
        this.f6708s = f(stringArray4 == null ? new String[0] : stringArray4);
        this.f6709t = bundle.getInt(y1.L, y1Var.A);
        this.f6710u = bundle.getInt(y1.f6724h0, y1Var.B);
        this.f6711v = bundle.getBoolean(y1.M, y1Var.C);
        this.f6712w = bundle.getBoolean(y1.f6719c0, y1Var.D);
        this.f6713x = bundle.getBoolean(y1.f6720d0, y1Var.E);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(y1.f6721e0);
        if (parcelableArrayList == null) {
            r1Var = r1.f4658l;
        } else {
            r1Var = c.a(w1.f6685l, parcelableArrayList);
        }
        this.f6714y = new HashMap();
        for (int i10 = 0; i10 < r1Var.f4660k; i10++) {
            w1 w1Var = (w1) r1Var.get(i10);
            this.f6714y.put(w1Var.f6686h, w1Var);
        }
        int[] intArray = bundle.getIntArray(y1.f6722f0);
        intArray = intArray == null ? new int[0] : intArray;
        this.f6715z = new HashSet();
        for (int valueOf : intArray) {
            this.f6715z.add(Integer.valueOf(valueOf));
        }
    }

    public x1(y1 y1Var) {
        e(y1Var);
    }
}
