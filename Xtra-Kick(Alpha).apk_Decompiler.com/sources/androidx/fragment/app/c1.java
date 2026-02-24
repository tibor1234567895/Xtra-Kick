package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.h;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.r;
import androidx.activity.result.e;
import androidx.activity.result.g;
import androidx.lifecycle.d0;
import androidx.lifecycle.h2;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import b0.m0;
import b0.n0;
import c0.i;
import com.woxthebox.draglistview.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import m0.q;
import q0.f;
import z0.d;

public abstract class c1 {
    public final p0 A = new p0(1, this);
    public e B;
    public e C;
    public e D;
    public ArrayDeque E = new ArrayDeque();
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public ArrayList K;
    public ArrayList L;
    public ArrayList M;
    public h1 N;
    public final o O = new o(1, this);

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1371a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f1372b;

    /* renamed from: c  reason: collision with root package name */
    public final n1 f1373c = new n1();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f1374d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f1375e;

    /* renamed from: f  reason: collision with root package name */
    public final l0 f1376f = new l0(this);

    /* renamed from: g  reason: collision with root package name */
    public r f1377g;

    /* renamed from: h  reason: collision with root package name */
    public final q0 f1378h = new q0(this);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f1379i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    public final Map f1380j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k  reason: collision with root package name */
    public final Map f1381k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l  reason: collision with root package name */
    public final Map f1382l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m  reason: collision with root package name */
    public ArrayList f1383m;

    /* renamed from: n  reason: collision with root package name */
    public final n0 f1384n = new n0(this);

    /* renamed from: o  reason: collision with root package name */
    public final CopyOnWriteArrayList f1385o = new CopyOnWriteArrayList();

    /* renamed from: p  reason: collision with root package name */
    public final o0 f1386p = new o0(this, 0);

    /* renamed from: q  reason: collision with root package name */
    public final o0 f1387q = new o0(this, 1);

    /* renamed from: r  reason: collision with root package name */
    public final o0 f1388r = new o0(this, 2);

    /* renamed from: s  reason: collision with root package name */
    public final o0 f1389s = new o0(this, 3);

    /* renamed from: t  reason: collision with root package name */
    public final r0 f1390t = new r0(this);

    /* renamed from: u  reason: collision with root package name */
    public int f1391u = -1;

    /* renamed from: v  reason: collision with root package name */
    public e0 f1392v;

    /* renamed from: w  reason: collision with root package name */
    public h0 f1393w;

    /* renamed from: x  reason: collision with root package name */
    public c0 f1394x;

    /* renamed from: y  reason: collision with root package name */
    public c0 f1395y;

    /* renamed from: z  reason: collision with root package name */
    public final s0 f1396z = new s0(this);

    public static boolean I(int i10) {
        return Log.isLoggable("FragmentManager", i10);
    }

    public static boolean J(c0 c0Var) {
        Iterator it = c0Var.B.f1373c.e().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            c0 c0Var2 = (c0) it.next();
            if (c0Var2 != null) {
                z10 = J(c0Var2);
                continue;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public static boolean L(c0 c0Var) {
        if (c0Var == null) {
            return true;
        }
        return c0Var.J && (c0Var.f1370z == null || L(c0Var.C));
    }

    public static boolean M(c0 c0Var) {
        if (c0Var == null) {
            return true;
        }
        c1 c1Var = c0Var.f1370z;
        if (!c0Var.equals(c1Var.f1395y) || !M(c1Var.f1394x)) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v34, resolved type: androidx.fragment.app.c0} */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x015e, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A(java.util.ArrayList r21, java.util.ArrayList r22, int r23, int r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            java.lang.Object r5 = r1.get(r3)
            androidx.fragment.app.a r5 = (androidx.fragment.app.a) r5
            boolean r5 = r5.f1548p
            java.util.ArrayList r6 = r0.M
            if (r6 != 0) goto L_0x001e
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r0.M = r6
            goto L_0x0021
        L_0x001e:
            r6.clear()
        L_0x0021:
            java.util.ArrayList r6 = r0.M
            androidx.fragment.app.n1 r7 = r0.f1373c
            java.util.List r8 = r7.f()
            r6.addAll(r8)
            androidx.fragment.app.c0 r6 = r0.f1395y
            r8 = 0
            r9 = r3
        L_0x0030:
            r10 = 1
            if (r9 >= r4) goto L_0x0187
            java.lang.Object r11 = r1.get(r9)
            androidx.fragment.app.a r11 = (androidx.fragment.app.a) r11
            java.lang.Object r12 = r2.get(r9)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x0136
            java.util.ArrayList r12 = r0.M
            r13 = 0
        L_0x0048:
            java.util.ArrayList r14 = r11.f1533a
            int r15 = r14.size()
            if (r13 >= r15) goto L_0x0133
            java.lang.Object r15 = r14.get(r13)
            androidx.fragment.app.o1 r15 = (androidx.fragment.app.o1) r15
            int r3 = r15.f1521a
            if (r3 == r10) goto L_0x011e
            r10 = 2
            if (r3 == r10) goto L_0x009c
            r10 = 3
            if (r3 == r10) goto L_0x007e
            r10 = 6
            if (r3 == r10) goto L_0x007e
            r10 = 7
            if (r3 == r10) goto L_0x011e
            r10 = 8
            if (r3 == r10) goto L_0x006b
            goto L_0x0097
        L_0x006b:
            androidx.fragment.app.o1 r3 = new androidx.fragment.app.o1
            r10 = 0
            r2 = 9
            r3.<init>(r2, r6, r10)
            r14.add(r13, r3)
            r2 = 1
            r15.f1523c = r2
            int r13 = r13 + 1
            androidx.fragment.app.c0 r6 = r15.f1522b
            goto L_0x0097
        L_0x007e:
            androidx.fragment.app.c0 r2 = r15.f1522b
            r12.remove(r2)
            androidx.fragment.app.c0 r2 = r15.f1522b
            if (r2 != r6) goto L_0x0097
            androidx.fragment.app.o1 r3 = new androidx.fragment.app.o1
            r6 = 9
            r3.<init>((int) r6, (androidx.fragment.app.c0) r2)
            r14.add(r13, r3)
            int r13 = r13 + 1
            r2 = 1
            r3 = 0
            r6 = r3
            goto L_0x0098
        L_0x0097:
            r2 = 1
        L_0x0098:
            r18 = r7
            goto L_0x0127
        L_0x009c:
            androidx.fragment.app.c0 r2 = r15.f1522b
            int r3 = r2.E
            int r10 = r12.size()
            int r10 = r10 + -1
            r16 = 0
        L_0x00a8:
            if (r10 < 0) goto L_0x0109
            java.lang.Object r17 = r12.get(r10)
            r18 = r7
            r7 = r17
            androidx.fragment.app.c0 r7 = (androidx.fragment.app.c0) r7
            int r1 = r7.E
            if (r1 != r3) goto L_0x00fa
            if (r7 != r2) goto L_0x00c2
            r1 = 1
            r17 = r2
            r19 = r3
            r16 = 1
            goto L_0x00fe
        L_0x00c2:
            if (r7 != r6) goto L_0x00d6
            androidx.fragment.app.o1 r1 = new androidx.fragment.app.o1
            r6 = 0
            r17 = r2
            r2 = 9
            r1.<init>(r2, r7, r6)
            r14.add(r13, r1)
            int r13 = r13 + 1
            r1 = 0
            r6 = r1
            goto L_0x00d8
        L_0x00d6:
            r17 = r2
        L_0x00d8:
            r1 = 0
            androidx.fragment.app.o1 r2 = new androidx.fragment.app.o1
            r19 = r3
            r3 = 3
            r2.<init>(r3, r7, r1)
            int r1 = r15.f1524d
            r2.f1524d = r1
            int r1 = r15.f1526f
            r2.f1526f = r1
            int r1 = r15.f1525e
            r2.f1525e = r1
            int r1 = r15.f1527g
            r2.f1527g = r1
            r14.add(r13, r2)
            r12.remove(r7)
            int r13 = r13 + 1
            goto L_0x00fe
        L_0x00fa:
            r17 = r2
            r19 = r3
        L_0x00fe:
            int r10 = r10 + -1
            r1 = r21
            r2 = r17
            r7 = r18
            r3 = r19
            goto L_0x00a8
        L_0x0109:
            r17 = r2
            r18 = r7
            r2 = 1
            if (r16 == 0) goto L_0x0116
            r14.remove(r13)
            int r13 = r13 + -1
            goto L_0x0127
        L_0x0116:
            r15.f1521a = r2
            r15.f1523c = r2
            r2 = r17
            r1 = 1
            goto L_0x0123
        L_0x011e:
            r18 = r7
            r1 = 1
            androidx.fragment.app.c0 r2 = r15.f1522b
        L_0x0123:
            r12.add(r2)
            r2 = r1
        L_0x0127:
            int r13 = r13 + r2
            r10 = 1
            r1 = r21
            r2 = r22
            r3 = r23
            r7 = r18
            goto L_0x0048
        L_0x0133:
            r18 = r7
            goto L_0x016f
        L_0x0136:
            r18 = r7
            r1 = 1
            java.util.ArrayList r2 = r0.M
            java.util.ArrayList r3 = r11.f1533a
            int r7 = r3.size()
            int r7 = r7 - r1
        L_0x0142:
            if (r7 < 0) goto L_0x016f
            java.lang.Object r10 = r3.get(r7)
            androidx.fragment.app.o1 r10 = (androidx.fragment.app.o1) r10
            int r12 = r10.f1521a
            if (r12 == r1) goto L_0x0166
            r1 = 3
            if (r12 == r1) goto L_0x0160
            switch(r12) {
                case 6: goto L_0x0160;
                case 7: goto L_0x0166;
                case 8: goto L_0x015d;
                case 9: goto L_0x015a;
                case 10: goto L_0x0155;
                default: goto L_0x0154;
            }
        L_0x0154:
            goto L_0x016b
        L_0x0155:
            androidx.lifecycle.s r1 = r10.f1528h
            r10.f1529i = r1
            goto L_0x016b
        L_0x015a:
            androidx.fragment.app.c0 r1 = r10.f1522b
            goto L_0x015e
        L_0x015d:
            r1 = 0
        L_0x015e:
            r6 = r1
            goto L_0x016b
        L_0x0160:
            androidx.fragment.app.c0 r1 = r10.f1522b
            r2.add(r1)
            goto L_0x016b
        L_0x0166:
            androidx.fragment.app.c0 r1 = r10.f1522b
            r2.remove(r1)
        L_0x016b:
            int r7 = r7 + -1
            r1 = 1
            goto L_0x0142
        L_0x016f:
            if (r8 != 0) goto L_0x0179
            boolean r1 = r11.f1539g
            if (r1 == 0) goto L_0x0176
            goto L_0x0179
        L_0x0176:
            r1 = 0
            r8 = 0
            goto L_0x017b
        L_0x0179:
            r1 = 1
            r8 = 1
        L_0x017b:
            int r9 = r9 + 1
            r1 = r21
            r2 = r22
            r3 = r23
            r7 = r18
            goto L_0x0030
        L_0x0187:
            r18 = r7
            java.util.ArrayList r1 = r0.M
            r1.clear()
            if (r5 != 0) goto L_0x01cf
            int r1 = r0.f1391u
            r2 = 1
            if (r1 < r2) goto L_0x01cf
            r1 = r23
        L_0x0197:
            if (r1 >= r4) goto L_0x01cf
            r2 = r21
            java.lang.Object r3 = r2.get(r1)
            androidx.fragment.app.a r3 = (androidx.fragment.app.a) r3
            java.util.ArrayList r3 = r3.f1533a
            java.util.Iterator r3 = r3.iterator()
        L_0x01a7:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x01ca
            java.lang.Object r5 = r3.next()
            androidx.fragment.app.o1 r5 = (androidx.fragment.app.o1) r5
            androidx.fragment.app.c0 r5 = r5.f1522b
            if (r5 == 0) goto L_0x01c5
            androidx.fragment.app.c1 r6 = r5.f1370z
            if (r6 == 0) goto L_0x01c5
            androidx.fragment.app.m1 r5 = r0.f(r5)
            r6 = r18
            r6.g(r5)
            goto L_0x01c7
        L_0x01c5:
            r6 = r18
        L_0x01c7:
            r18 = r6
            goto L_0x01a7
        L_0x01ca:
            r6 = r18
            int r1 = r1 + 1
            goto L_0x0197
        L_0x01cf:
            r2 = r21
            r1 = r23
        L_0x01d3:
            if (r1 >= r4) goto L_0x042b
            java.lang.Object r3 = r2.get(r1)
            androidx.fragment.app.a r3 = (androidx.fragment.app.a) r3
            r5 = r22
            java.lang.Object r6 = r5.get(r1)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            java.lang.String r7 = "Unknown cmd: "
            if (r6 == 0) goto L_0x0311
            r6 = -1
            r3.f(r6)
            java.util.ArrayList r6 = r3.f1533a
            int r9 = r6.size()
            int r9 = r9 + -1
        L_0x01f7:
            if (r9 < 0) goto L_0x0427
            java.lang.Object r10 = r6.get(r9)
            androidx.fragment.app.o1 r10 = (androidx.fragment.app.o1) r10
            androidx.fragment.app.c0 r11 = r10.f1522b
            if (r11 == 0) goto L_0x024e
            boolean r12 = r3.f1322t
            r11.f1364t = r12
            androidx.fragment.app.x r12 = r11.P
            if (r12 != 0) goto L_0x020c
            goto L_0x0213
        L_0x020c:
            androidx.fragment.app.x r12 = r11.s()
            r13 = 1
            r12.f1597a = r13
        L_0x0213:
            int r12 = r3.f1538f
            r13 = 8194(0x2002, float:1.1482E-41)
            r14 = 4097(0x1001, float:5.741E-42)
            if (r12 == r14) goto L_0x0233
            if (r12 == r13) goto L_0x0231
            r13 = 4100(0x1004, float:5.745E-42)
            r14 = 8197(0x2005, float:1.1486E-41)
            if (r12 == r14) goto L_0x0233
            r14 = 4099(0x1003, float:5.744E-42)
            if (r12 == r14) goto L_0x022e
            if (r12 == r13) goto L_0x022b
            r13 = 0
            goto L_0x0233
        L_0x022b:
            r13 = 8197(0x2005, float:1.1486E-41)
            goto L_0x0233
        L_0x022e:
            r13 = 4099(0x1003, float:5.744E-42)
            goto L_0x0233
        L_0x0231:
            r13 = 4097(0x1001, float:5.741E-42)
        L_0x0233:
            androidx.fragment.app.x r12 = r11.P
            if (r12 != 0) goto L_0x023a
            if (r13 != 0) goto L_0x023a
            goto L_0x0241
        L_0x023a:
            r11.s()
            androidx.fragment.app.x r12 = r11.P
            r12.f1602f = r13
        L_0x0241:
            java.util.ArrayList r12 = r3.f1547o
            java.util.ArrayList r13 = r3.f1546n
            r11.s()
            androidx.fragment.app.x r14 = r11.P
            r14.f1603g = r12
            r14.f1604h = r13
        L_0x024e:
            int r12 = r10.f1521a
            androidx.fragment.app.c1 r13 = r3.f1319q
            switch(r12) {
                case 1: goto L_0x02fb;
                case 2: goto L_0x0255;
                case 3: goto L_0x02ec;
                case 4: goto L_0x02c6;
                case 5: goto L_0x029e;
                case 6: goto L_0x028f;
                case 7: goto L_0x027b;
                case 8: goto L_0x0275;
                case 9: goto L_0x0270;
                case 10: goto L_0x0269;
                default: goto L_0x0255;
            }
        L_0x0255:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r7)
            int r3 = r10.f1521a
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0269:
            androidx.lifecycle.s r10 = r10.f1528h
            r13.a0(r11, r10)
            goto L_0x030d
        L_0x0270:
            r13.b0(r11)
            goto L_0x030d
        L_0x0275:
            r10 = 0
            r13.b0(r10)
            goto L_0x030d
        L_0x027b:
            int r12 = r10.f1524d
            int r14 = r10.f1525e
            int r15 = r10.f1526f
            int r10 = r10.f1527g
            r11.i0(r12, r14, r15, r10)
            r10 = 1
            r13.Y(r11, r10)
            r13.g(r11)
            goto L_0x030d
        L_0x028f:
            int r12 = r10.f1524d
            int r14 = r10.f1525e
            int r15 = r10.f1526f
            int r10 = r10.f1527g
            r11.i0(r12, r14, r15, r10)
            r13.c(r11)
            goto L_0x030d
        L_0x029e:
            int r12 = r10.f1524d
            int r14 = r10.f1525e
            int r15 = r10.f1526f
            int r10 = r10.f1527g
            r11.i0(r12, r14, r15, r10)
            r10 = 1
            r13.Y(r11, r10)
            r12 = 2
            boolean r12 = I(r12)
            if (r12 == 0) goto L_0x02b7
            java.util.Objects.toString(r11)
        L_0x02b7:
            boolean r12 = r11.G
            if (r12 != 0) goto L_0x030d
            r11.G = r10
            boolean r12 = r11.Q
            r10 = r10 ^ r12
            r11.Q = r10
            r13.c0(r11)
            goto L_0x030d
        L_0x02c6:
            int r12 = r10.f1524d
            int r14 = r10.f1525e
            int r15 = r10.f1526f
            int r10 = r10.f1527g
            r11.i0(r12, r14, r15, r10)
            r13.getClass()
            r10 = 2
            boolean r10 = I(r10)
            if (r10 == 0) goto L_0x02de
            java.util.Objects.toString(r11)
        L_0x02de:
            boolean r10 = r11.G
            if (r10 == 0) goto L_0x030d
            r10 = 0
            r11.G = r10
            boolean r10 = r11.Q
            r10 = r10 ^ 1
            r11.Q = r10
            goto L_0x030d
        L_0x02ec:
            int r12 = r10.f1524d
            int r14 = r10.f1525e
            int r15 = r10.f1526f
            int r10 = r10.f1527g
            r11.i0(r12, r14, r15, r10)
            r13.a(r11)
            goto L_0x030d
        L_0x02fb:
            int r12 = r10.f1524d
            int r14 = r10.f1525e
            int r15 = r10.f1526f
            int r10 = r10.f1527g
            r11.i0(r12, r14, r15, r10)
            r10 = 1
            r13.Y(r11, r10)
            r13.T(r11)
        L_0x030d:
            int r9 = r9 + -1
            goto L_0x01f7
        L_0x0311:
            r6 = 1
            r3.f(r6)
            java.util.ArrayList r6 = r3.f1533a
            int r9 = r6.size()
            r10 = 0
        L_0x031c:
            if (r10 >= r9) goto L_0x0427
            java.lang.Object r11 = r6.get(r10)
            androidx.fragment.app.o1 r11 = (androidx.fragment.app.o1) r11
            androidx.fragment.app.c0 r12 = r11.f1522b
            if (r12 == 0) goto L_0x0355
            boolean r13 = r3.f1322t
            r12.f1364t = r13
            androidx.fragment.app.x r13 = r12.P
            if (r13 != 0) goto L_0x0331
            goto L_0x0338
        L_0x0331:
            androidx.fragment.app.x r13 = r12.s()
            r14 = 0
            r13.f1597a = r14
        L_0x0338:
            int r13 = r3.f1538f
            androidx.fragment.app.x r14 = r12.P
            if (r14 != 0) goto L_0x0341
            if (r13 != 0) goto L_0x0341
            goto L_0x0348
        L_0x0341:
            r12.s()
            androidx.fragment.app.x r14 = r12.P
            r14.f1602f = r13
        L_0x0348:
            java.util.ArrayList r13 = r3.f1546n
            java.util.ArrayList r14 = r3.f1547o
            r12.s()
            androidx.fragment.app.x r15 = r12.P
            r15.f1603g = r13
            r15.f1604h = r14
        L_0x0355:
            int r13 = r11.f1521a
            androidx.fragment.app.c1 r14 = r3.f1319q
            switch(r13) {
                case 1: goto L_0x040d;
                case 2: goto L_0x035c;
                case 3: goto L_0x03fc;
                case 4: goto L_0x03d2;
                case 5: goto L_0x03aa;
                case 6: goto L_0x0398;
                case 7: goto L_0x0382;
                case 8: goto L_0x037b;
                case 9: goto L_0x0376;
                case 10: goto L_0x0370;
                default: goto L_0x035c;
            }
        L_0x035c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r7)
            int r3 = r11.f1521a
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0370:
            androidx.lifecycle.s r11 = r11.f1529i
            r14.a0(r12, r11)
            goto L_0x037e
        L_0x0376:
            r11 = 0
            r14.b0(r11)
            goto L_0x037e
        L_0x037b:
            r14.b0(r12)
        L_0x037e:
            r16 = r3
            goto L_0x0421
        L_0x0382:
            int r13 = r11.f1524d
            int r15 = r11.f1525e
            r16 = r3
            int r3 = r11.f1526f
            int r11 = r11.f1527g
            r12.i0(r13, r15, r3, r11)
            r3 = 0
            r14.Y(r12, r3)
            r14.c(r12)
            goto L_0x0421
        L_0x0398:
            r16 = r3
            int r3 = r11.f1524d
            int r13 = r11.f1525e
            int r15 = r11.f1526f
            int r11 = r11.f1527g
            r12.i0(r3, r13, r15, r11)
            r14.g(r12)
            goto L_0x0421
        L_0x03aa:
            r16 = r3
            int r3 = r11.f1524d
            int r13 = r11.f1525e
            int r15 = r11.f1526f
            int r11 = r11.f1527g
            r12.i0(r3, r13, r15, r11)
            r3 = 0
            r14.Y(r12, r3)
            r11 = 2
            boolean r11 = I(r11)
            if (r11 == 0) goto L_0x03c5
            java.util.Objects.toString(r12)
        L_0x03c5:
            boolean r11 = r12.G
            if (r11 == 0) goto L_0x0421
            r12.G = r3
            boolean r3 = r12.Q
            r3 = r3 ^ 1
            r12.Q = r3
            goto L_0x0421
        L_0x03d2:
            r16 = r3
            int r3 = r11.f1524d
            int r13 = r11.f1525e
            int r15 = r11.f1526f
            int r11 = r11.f1527g
            r12.i0(r3, r13, r15, r11)
            r14.getClass()
            r3 = 2
            boolean r3 = I(r3)
            if (r3 == 0) goto L_0x03ec
            java.util.Objects.toString(r12)
        L_0x03ec:
            boolean r3 = r12.G
            if (r3 != 0) goto L_0x0421
            r3 = 1
            r12.G = r3
            boolean r11 = r12.Q
            r3 = r3 ^ r11
            r12.Q = r3
            r14.c0(r12)
            goto L_0x0421
        L_0x03fc:
            r16 = r3
            int r3 = r11.f1524d
            int r13 = r11.f1525e
            int r15 = r11.f1526f
            int r11 = r11.f1527g
            r12.i0(r3, r13, r15, r11)
            r14.T(r12)
            goto L_0x0421
        L_0x040d:
            r16 = r3
            int r3 = r11.f1524d
            int r13 = r11.f1525e
            int r15 = r11.f1526f
            int r11 = r11.f1527g
            r12.i0(r3, r13, r15, r11)
            r3 = 0
            r14.Y(r12, r3)
            r14.a(r12)
        L_0x0421:
            int r10 = r10 + 1
            r3 = r16
            goto L_0x031c
        L_0x0427:
            int r1 = r1 + 1
            goto L_0x01d3
        L_0x042b:
            r5 = r22
            int r1 = r4 + -1
            java.lang.Object r1 = r5.get(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r8 == 0) goto L_0x058e
            java.util.ArrayList r3 = r0.f1383m
            if (r3 == 0) goto L_0x058e
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x058e
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
            java.util.Iterator r6 = r21.iterator()
        L_0x044e:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0482
            java.lang.Object r7 = r6.next()
            androidx.fragment.app.a r7 = (androidx.fragment.app.a) r7
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            r10 = 0
        L_0x0460:
            java.util.ArrayList r11 = r7.f1533a
            int r11 = r11.size()
            if (r10 >= r11) goto L_0x047e
            java.util.ArrayList r11 = r7.f1533a
            java.lang.Object r11 = r11.get(r10)
            androidx.fragment.app.o1 r11 = (androidx.fragment.app.o1) r11
            androidx.fragment.app.c0 r11 = r11.f1522b
            if (r11 == 0) goto L_0x047b
            boolean r12 = r7.f1539g
            if (r12 == 0) goto L_0x047b
            r9.add(r11)
        L_0x047b:
            int r10 = r10 + 1
            goto L_0x0460
        L_0x047e:
            r3.addAll(r9)
            goto L_0x044e
        L_0x0482:
            java.util.ArrayList r6 = r0.f1383m
            java.util.Iterator r6 = r6.iterator()
        L_0x0488:
            boolean r7 = r6.hasNext()
            java.lang.String r9 = "fragment"
            if (r7 == 0) goto L_0x04ed
            java.lang.Object r7 = r6.next()
            l3.l r7 = (l3.l) r7
            java.util.Iterator r10 = r3.iterator()
        L_0x049a:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0488
            java.lang.Object r11 = r10.next()
            androidx.fragment.app.c0 r11 = (androidx.fragment.app.c0) r11
            r7.getClass()
            xa.j.f(r9, r11)
            if (r1 == 0) goto L_0x04e8
            j3.r2 r12 = r7.f9551a
            kb.n0 r13 = r12.f8678e
            java.lang.Object r13 = r13.getValue()
            java.util.List r13 = (java.util.List) r13
            int r14 = r13.size()
            java.util.ListIterator r13 = r13.listIterator(r14)
        L_0x04c0:
            boolean r14 = r13.hasPrevious()
            if (r14 == 0) goto L_0x04dd
            java.lang.Object r14 = r13.previous()
            r15 = r14
            j3.r r15 = (j3.r) r15
            java.lang.String r15 = r15.f8665m
            r16 = r6
            java.lang.String r6 = r11.F
            boolean r6 = xa.j.a(r15, r6)
            if (r6 == 0) goto L_0x04da
            goto L_0x04e0
        L_0x04da:
            r6 = r16
            goto L_0x04c0
        L_0x04dd:
            r16 = r6
            r14 = 0
        L_0x04e0:
            j3.r r14 = (j3.r) r14
            if (r14 == 0) goto L_0x04ea
            r12.f(r14)
            goto L_0x04ea
        L_0x04e8:
            r16 = r6
        L_0x04ea:
            r6 = r16
            goto L_0x049a
        L_0x04ed:
            java.util.ArrayList r6 = r0.f1383m
            java.util.Iterator r6 = r6.iterator()
        L_0x04f3:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x058e
            java.lang.Object r7 = r6.next()
            l3.l r7 = (l3.l) r7
            java.util.Iterator r10 = r3.iterator()
        L_0x0503:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x04f3
            java.lang.Object r11 = r10.next()
            androidx.fragment.app.c0 r11 = (androidx.fragment.app.c0) r11
            r7.getClass()
            xa.j.f(r9, r11)
            j3.r2 r12 = r7.f9551a
            kb.n0 r13 = r12.f8678e
            java.lang.Object r13 = r13.getValue()
            java.util.Collection r13 = (java.util.Collection) r13
            kb.n0 r14 = r12.f8679f
            java.lang.Object r14 = r14.getValue()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.ArrayList r13 = ma.z.C(r14, r13)
            int r14 = r13.size()
            java.util.ListIterator r13 = r13.listIterator(r14)
        L_0x0533:
            boolean r14 = r13.hasPrevious()
            if (r14 == 0) goto L_0x0550
            java.lang.Object r14 = r13.previous()
            r15 = r14
            j3.r r15 = (j3.r) r15
            java.lang.String r15 = r15.f8665m
            r16 = r3
            java.lang.String r3 = r11.F
            boolean r3 = xa.j.a(r15, r3)
            if (r3 == 0) goto L_0x054d
            goto L_0x0553
        L_0x054d:
            r3 = r16
            goto L_0x0533
        L_0x0550:
            r16 = r3
            r14 = 0
        L_0x0553:
            j3.r r14 = (j3.r) r14
            if (r1 != 0) goto L_0x056c
            if (r14 == 0) goto L_0x055a
            goto L_0x056c
        L_0x055a:
            java.lang.String r1 = "The fragment "
            java.lang.String r2 = " is unknown to the FragmentNavigator. Please use the navigate() function to add fragments to the FragmentNavigator managed FragmentManager."
            java.lang.String r1 = android.support.v4.media.h.l(r1, r11, r2)
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x056c:
            if (r14 == 0) goto L_0x058a
            l3.m r3 = r7.f9552b
            r3.getClass()
            l3.m.k(r11, r14, r12)
            if (r1 == 0) goto L_0x058a
            java.util.Set r3 = r3.m()
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x058a
            boolean r3 = r11.f1363s
            if (r3 == 0) goto L_0x058a
            r3 = 0
            r12.e(r14, r3)
        L_0x058a:
            r3 = r16
            goto L_0x0503
        L_0x058e:
            r3 = r23
        L_0x0590:
            if (r3 >= r4) goto L_0x05db
            java.lang.Object r6 = r2.get(r3)
            androidx.fragment.app.a r6 = (androidx.fragment.app.a) r6
            if (r1 == 0) goto L_0x05ba
            java.util.ArrayList r7 = r6.f1533a
            int r7 = r7.size()
            int r7 = r7 + -1
        L_0x05a2:
            if (r7 < 0) goto L_0x05d8
            java.util.ArrayList r9 = r6.f1533a
            java.lang.Object r9 = r9.get(r7)
            androidx.fragment.app.o1 r9 = (androidx.fragment.app.o1) r9
            androidx.fragment.app.c0 r9 = r9.f1522b
            if (r9 == 0) goto L_0x05b7
            androidx.fragment.app.m1 r9 = r0.f(r9)
            r9.k()
        L_0x05b7:
            int r7 = r7 + -1
            goto L_0x05a2
        L_0x05ba:
            java.util.ArrayList r6 = r6.f1533a
            java.util.Iterator r6 = r6.iterator()
        L_0x05c0:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x05d8
            java.lang.Object r7 = r6.next()
            androidx.fragment.app.o1 r7 = (androidx.fragment.app.o1) r7
            androidx.fragment.app.c0 r7 = r7.f1522b
            if (r7 == 0) goto L_0x05c0
            androidx.fragment.app.m1 r7 = r0.f(r7)
            r7.k()
            goto L_0x05c0
        L_0x05d8:
            int r3 = r3 + 1
            goto L_0x0590
        L_0x05db:
            int r3 = r0.f1391u
            r6 = 1
            r0.O(r3, r6)
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            r6 = r23
        L_0x05e8:
            if (r6 >= r4) goto L_0x0615
            java.lang.Object r7 = r2.get(r6)
            androidx.fragment.app.a r7 = (androidx.fragment.app.a) r7
            java.util.ArrayList r7 = r7.f1533a
            java.util.Iterator r7 = r7.iterator()
        L_0x05f6:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0612
            java.lang.Object r9 = r7.next()
            androidx.fragment.app.o1 r9 = (androidx.fragment.app.o1) r9
            androidx.fragment.app.c0 r9 = r9.f1522b
            if (r9 == 0) goto L_0x05f6
            android.view.ViewGroup r9 = r9.L
            if (r9 == 0) goto L_0x05f6
            androidx.fragment.app.n r9 = androidx.fragment.app.n.h(r9, r0)
            r3.add(r9)
            goto L_0x05f6
        L_0x0612:
            int r6 = r6 + 1
            goto L_0x05e8
        L_0x0615:
            java.util.Iterator r3 = r3.iterator()
        L_0x0619:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x062e
            java.lang.Object r6 = r3.next()
            androidx.fragment.app.n r6 = (androidx.fragment.app.n) r6
            r6.f1509d = r1
            r6.i()
            r6.d()
            goto L_0x0619
        L_0x062e:
            r1 = r23
        L_0x0630:
            if (r1 >= r4) goto L_0x0651
            java.lang.Object r3 = r2.get(r1)
            androidx.fragment.app.a r3 = (androidx.fragment.app.a) r3
            java.lang.Object r6 = r5.get(r1)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x064b
            int r6 = r3.f1321s
            if (r6 < 0) goto L_0x064b
            r6 = -1
            r3.f1321s = r6
        L_0x064b:
            r3.getClass()
            int r1 = r1 + 1
            goto L_0x0630
        L_0x0651:
            if (r8 == 0) goto L_0x066e
            java.util.ArrayList r1 = r0.f1383m
            if (r1 == 0) goto L_0x066e
            r1 = 0
        L_0x0658:
            java.util.ArrayList r2 = r0.f1383m
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x066e
            java.util.ArrayList r2 = r0.f1383m
            java.lang.Object r2 = r2.get(r1)
            l3.l r2 = (l3.l) r2
            r2.getClass()
            int r1 = r1 + 1
            goto L_0x0658
        L_0x066e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c1.A(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final c0 B(String str) {
        return this.f1373c.b(str);
    }

    public final int C(boolean z10, int i10, String str) {
        ArrayList arrayList = this.f1374d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str != null || i10 >= 0) {
            int size = this.f1374d.size() - 1;
            while (size >= 0) {
                a aVar = (a) this.f1374d.get(size);
                if ((str != null && str.equals(aVar.f1541i)) || (i10 >= 0 && i10 == aVar.f1321s)) {
                    break;
                }
                size--;
            }
            if (size < 0) {
                return size;
            }
            if (z10) {
                while (size > 0) {
                    a aVar2 = (a) this.f1374d.get(size - 1);
                    if ((str == null || !str.equals(aVar2.f1541i)) && (i10 < 0 || i10 != aVar2.f1321s)) {
                        return size;
                    }
                    size--;
                }
                return size;
            } else if (size == this.f1374d.size() - 1) {
                return -1;
            } else {
                return size + 1;
            }
        } else if (z10) {
            return 0;
        } else {
            return this.f1374d.size() - 1;
        }
    }

    public final c0 D(int i10) {
        n1 n1Var = this.f1373c;
        ArrayList arrayList = n1Var.f1513a;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                c0 c0Var = (c0) arrayList.get(size);
                if (c0Var != null && c0Var.D == i10) {
                    return c0Var;
                }
            } else {
                for (m1 m1Var : n1Var.f1514b.values()) {
                    if (m1Var != null) {
                        c0 c0Var2 = m1Var.f1502c;
                        if (c0Var2.D == i10) {
                            return c0Var2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public final c0 E(String str) {
        n1 n1Var = this.f1373c;
        if (str != null) {
            ArrayList arrayList = n1Var.f1513a;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                c0 c0Var = (c0) arrayList.get(size);
                if (c0Var != null && str.equals(c0Var.F)) {
                    return c0Var;
                }
            }
        }
        if (str != null) {
            for (m1 m1Var : n1Var.f1514b.values()) {
                if (m1Var != null) {
                    c0 c0Var2 = m1Var.f1502c;
                    if (str.equals(c0Var2.F)) {
                        return c0Var2;
                    }
                }
            }
        } else {
            n1Var.getClass();
        }
        return null;
    }

    public final ViewGroup F(c0 c0Var) {
        ViewGroup viewGroup = c0Var.L;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (c0Var.E > 0 && this.f1393w.d()) {
            View c10 = this.f1393w.c(c0Var.E);
            if (c10 instanceof ViewGroup) {
                return (ViewGroup) c10;
            }
        }
        return null;
    }

    public final j0 G() {
        c0 c0Var = this.f1394x;
        return c0Var != null ? c0Var.f1370z.G() : this.f1396z;
    }

    public final p0 H() {
        c0 c0Var = this.f1394x;
        return c0Var != null ? c0Var.f1370z.H() : this.A;
    }

    public final boolean K() {
        c0 c0Var = this.f1394x;
        if (c0Var == null) {
            return true;
        }
        return c0Var.F() && this.f1394x.x().K();
    }

    public final boolean N() {
        return this.G || this.H;
    }

    public final void O(int i10, boolean z10) {
        HashMap hashMap;
        e0 e0Var;
        if (this.f1392v == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z10 || i10 != this.f1391u) {
            this.f1391u = i10;
            n1 n1Var = this.f1373c;
            Iterator it = n1Var.f1513a.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                hashMap = n1Var.f1514b;
                if (!hasNext) {
                    break;
                }
                m1 m1Var = (m1) hashMap.get(((c0) it.next()).f1356l);
                if (m1Var != null) {
                    m1Var.k();
                }
            }
            Iterator it2 = hashMap.values().iterator();
            while (true) {
                boolean z11 = false;
                if (!it2.hasNext()) {
                    break;
                }
                m1 m1Var2 = (m1) it2.next();
                if (m1Var2 != null) {
                    m1Var2.k();
                    c0 c0Var = m1Var2.f1502c;
                    if (c0Var.f1363s && !c0Var.H()) {
                        z11 = true;
                    }
                    if (z11) {
                        if (c0Var.f1364t && !n1Var.f1515c.containsKey(c0Var.f1356l)) {
                            n1Var.i(m1Var2.o(), c0Var.f1356l);
                        }
                        n1Var.h(m1Var2);
                    }
                }
            }
            d0();
            if (this.F && (e0Var = this.f1392v) != null && this.f1391u == 7) {
                e0Var.f1406l.invalidateOptionsMenu();
                this.F = false;
            }
        }
    }

    public final void P() {
        if (this.f1392v != null) {
            this.G = false;
            this.H = false;
            this.N.f1452i = false;
            for (c0 c0Var : this.f1373c.f()) {
                if (c0Var != null) {
                    c0Var.B.P();
                }
            }
        }
    }

    public final boolean Q() {
        return R(-1, 0);
    }

    public final boolean R(int i10, int i11) {
        y(false);
        x(true);
        c0 c0Var = this.f1395y;
        if (c0Var != null && i10 < 0 && c0Var.u().Q()) {
            return true;
        }
        boolean S = S(this.K, this.L, (String) null, i10, i11);
        if (S) {
            this.f1372b = true;
            try {
                U(this.K, this.L);
            } finally {
                d();
            }
        }
        f0();
        u();
        this.f1373c.f1514b.values().removeAll(Collections.singleton((Object) null));
        return S;
    }

    public final boolean S(ArrayList arrayList, ArrayList arrayList2, String str, int i10, int i11) {
        int C2 = C((i11 & 1) != 0, i10, str);
        if (C2 < 0) {
            return false;
        }
        for (int size = this.f1374d.size() - 1; size >= C2; size--) {
            arrayList.add((a) this.f1374d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void T(c0 c0Var) {
        if (I(2)) {
            Objects.toString(c0Var);
        }
        boolean z10 = !c0Var.H();
        if (!c0Var.H || z10) {
            n1 n1Var = this.f1373c;
            synchronized (n1Var.f1513a) {
                n1Var.f1513a.remove(c0Var);
            }
            c0Var.f1362r = false;
            if (J(c0Var)) {
                this.F = true;
            }
            c0Var.f1363s = true;
            c0(c0Var);
        }
    }

    public final void U(ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    if (!((a) arrayList.get(i10)).f1548p) {
                        if (i11 != i10) {
                            A(arrayList, arrayList2, i11, i10);
                        }
                        i11 = i10 + 1;
                        if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                            while (i11 < size && ((Boolean) arrayList2.get(i11)).booleanValue() && !((a) arrayList.get(i11)).f1548p) {
                                i11++;
                            }
                        }
                        A(arrayList, arrayList2, i10, i11);
                        i10 = i11 - 1;
                    }
                    i10++;
                }
                if (i11 != size) {
                    A(arrayList, arrayList2, i11, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public final void V(Bundle bundle) {
        n0 n0Var;
        int i10;
        m1 m1Var;
        Bundle bundle2;
        Bundle bundle3;
        for (String next : bundle.keySet()) {
            if (next.startsWith("result_") && (bundle3 = bundle.getBundle(next)) != null) {
                bundle3.setClassLoader(this.f1392v.f1403i.getClassLoader());
                this.f1381k.put(next.substring(7), bundle3);
            }
        }
        HashMap hashMap = new HashMap();
        for (String next2 : bundle.keySet()) {
            if (next2.startsWith("fragment_") && (bundle2 = bundle.getBundle(next2)) != null) {
                bundle2.setClassLoader(this.f1392v.f1403i.getClassLoader());
                hashMap.put(next2.substring(9), bundle2);
            }
        }
        n1 n1Var = this.f1373c;
        HashMap hashMap2 = n1Var.f1515c;
        hashMap2.clear();
        hashMap2.putAll(hashMap);
        f1 f1Var = (f1) bundle.getParcelable("state");
        if (f1Var != null) {
            HashMap hashMap3 = n1Var.f1514b;
            hashMap3.clear();
            Iterator it = f1Var.f1419h.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                n0Var = this.f1384n;
                if (!hasNext) {
                    break;
                }
                Bundle i11 = n1Var.i((Bundle) null, (String) it.next());
                if (i11 != null) {
                    h1 h1Var = this.N;
                    c0 c0Var = (c0) h1Var.f1447d.get(((l1) i11.getParcelable("state")).f1481i);
                    if (c0Var != null) {
                        if (I(2)) {
                            c0Var.toString();
                        }
                        m1Var = new m1(n0Var, n1Var, c0Var, i11);
                    } else {
                        m1Var = new m1(this.f1384n, this.f1373c, this.f1392v.f1403i.getClassLoader(), G(), i11);
                    }
                    c0 c0Var2 = m1Var.f1502c;
                    c0Var2.f1353i = i11;
                    c0Var2.f1370z = this;
                    if (I(2)) {
                        c0Var2.toString();
                    }
                    m1Var.m(this.f1392v.f1403i.getClassLoader());
                    n1Var.g(m1Var);
                    m1Var.f1504e = this.f1391u;
                }
            }
            h1 h1Var2 = this.N;
            h1Var2.getClass();
            Iterator it2 = new ArrayList(h1Var2.f1447d.values()).iterator();
            while (true) {
                i10 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                c0 c0Var3 = (c0) it2.next();
                if (hashMap3.get(c0Var3.f1356l) != null) {
                    i10 = 1;
                }
                if (i10 == 0) {
                    if (I(2)) {
                        c0Var3.toString();
                        Objects.toString(f1Var.f1419h);
                    }
                    this.N.e(c0Var3);
                    c0Var3.f1370z = this;
                    m1 m1Var2 = new m1(n0Var, n1Var, c0Var3);
                    m1Var2.f1504e = 1;
                    m1Var2.k();
                    c0Var3.f1363s = true;
                    m1Var2.k();
                }
            }
            ArrayList<String> arrayList = f1Var.f1420i;
            n1Var.f1513a.clear();
            if (arrayList != null) {
                for (String str : arrayList) {
                    c0 b10 = n1Var.b(str);
                    if (b10 != null) {
                        if (I(2)) {
                            b10.toString();
                        }
                        n1Var.a(b10);
                    } else {
                        throw new IllegalStateException(h.n("No instantiated fragment for (", str, ")"));
                    }
                }
            }
            if (f1Var.f1421j != null) {
                this.f1374d = new ArrayList(f1Var.f1421j.length);
                int i12 = 0;
                while (true) {
                    c[] cVarArr = f1Var.f1421j;
                    if (i12 >= cVarArr.length) {
                        break;
                    }
                    c cVar = cVarArr[i12];
                    cVar.getClass();
                    a aVar = new a(this);
                    cVar.u(aVar);
                    aVar.f1321s = cVar.f1341n;
                    int i13 = 0;
                    while (true) {
                        ArrayList arrayList2 = cVar.f1336i;
                        if (i13 >= arrayList2.size()) {
                            break;
                        }
                        String str2 = (String) arrayList2.get(i13);
                        if (str2 != null) {
                            ((o1) aVar.f1533a.get(i13)).f1522b = B(str2);
                        }
                        i13++;
                    }
                    aVar.f(1);
                    if (I(2)) {
                        aVar.toString();
                        PrintWriter printWriter = new PrintWriter(new a2());
                        aVar.j("  ", printWriter, false);
                        printWriter.close();
                    }
                    this.f1374d.add(aVar);
                    i12++;
                }
            } else {
                this.f1374d = null;
            }
            this.f1379i.set(f1Var.f1422k);
            String str3 = f1Var.f1423l;
            if (str3 != null) {
                c0 B2 = B(str3);
                this.f1395y = B2;
                q(B2);
            }
            ArrayList arrayList3 = f1Var.f1424m;
            if (arrayList3 != null) {
                while (i10 < arrayList3.size()) {
                    this.f1380j.put((String) arrayList3.get(i10), (e) f1Var.f1425n.get(i10));
                    i10++;
                }
            }
            this.E = new ArrayDeque(f1Var.f1426o);
        }
    }

    public final Bundle W() {
        int i10;
        c[] cVarArr;
        ArrayList arrayList;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n nVar = (n) it.next();
            if (nVar.f1510e) {
                I(2);
                nVar.f1510e = false;
                nVar.d();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((n) it2.next()).g();
        }
        y(true);
        this.G = true;
        this.N.f1452i = true;
        n1 n1Var = this.f1373c;
        n1Var.getClass();
        HashMap hashMap = n1Var.f1514b;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        for (m1 m1Var : hashMap.values()) {
            if (m1Var != null) {
                c0 c0Var = m1Var.f1502c;
                n1Var.i(m1Var.o(), c0Var.f1356l);
                arrayList2.add(c0Var.f1356l);
                if (I(2)) {
                    c0Var.toString();
                    Objects.toString(c0Var.f1353i);
                }
            }
        }
        HashMap hashMap2 = this.f1373c.f1515c;
        if (hashMap2.isEmpty()) {
            I(2);
        } else {
            n1 n1Var2 = this.f1373c;
            synchronized (n1Var2.f1513a) {
                cVarArr = null;
                if (n1Var2.f1513a.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(n1Var2.f1513a.size());
                    Iterator it3 = n1Var2.f1513a.iterator();
                    while (it3.hasNext()) {
                        c0 c0Var2 = (c0) it3.next();
                        arrayList.add(c0Var2.f1356l);
                        if (I(2)) {
                            c0Var2.toString();
                        }
                    }
                }
            }
            ArrayList arrayList3 = this.f1374d;
            if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                cVarArr = new c[size];
                for (i10 = 0; i10 < size; i10++) {
                    cVarArr[i10] = new c((a) this.f1374d.get(i10));
                    if (I(2)) {
                        Objects.toString(this.f1374d.get(i10));
                    }
                }
            }
            f1 f1Var = new f1();
            f1Var.f1419h = arrayList2;
            f1Var.f1420i = arrayList;
            f1Var.f1421j = cVarArr;
            f1Var.f1422k = this.f1379i.get();
            c0 c0Var3 = this.f1395y;
            if (c0Var3 != null) {
                f1Var.f1423l = c0Var3.f1356l;
            }
            f1Var.f1424m.addAll(this.f1380j.keySet());
            f1Var.f1425n.addAll(this.f1380j.values());
            f1Var.f1426o = new ArrayList(this.E);
            bundle.putParcelable("state", f1Var);
            for (String str : this.f1381k.keySet()) {
                bundle.putBundle(h.m("result_", str), (Bundle) this.f1381k.get(str));
            }
            for (String str2 : hashMap2.keySet()) {
                bundle.putBundle(h.m("fragment_", str2), (Bundle) hashMap2.get(str2));
            }
        }
        return bundle;
    }

    public final void X() {
        synchronized (this.f1371a) {
            boolean z10 = true;
            if (this.f1371a.size() != 1) {
                z10 = false;
            }
            if (z10) {
                this.f1392v.f1404j.removeCallbacks(this.O);
                this.f1392v.f1404j.post(this.O);
                f0();
            }
        }
    }

    public final void Y(c0 c0Var, boolean z10) {
        ViewGroup F2 = F(c0Var);
        if (F2 != null && (F2 instanceof FragmentContainerView)) {
            ((FragmentContainerView) F2).setDrawDisappearingViewsLast(!z10);
        }
    }

    public final void Z(d0 d0Var, j1 j1Var) {
        t o10 = d0Var.o();
        if (o10.b() != s.DESTROYED) {
            FragmentManager$6 fragmentManager$6 = new FragmentManager$6(this, j1Var, o10);
            y0 y0Var = (y0) this.f1382l.put("integrity", new y0(o10, j1Var, fragmentManager$6));
            if (y0Var != null) {
                y0Var.f1612h.c(y0Var.f1614j);
            }
            if (I(2)) {
                o10.toString();
                Objects.toString(j1Var);
            }
            o10.a(fragmentManager$6);
        }
    }

    public final m1 a(c0 c0Var) {
        String str = c0Var.T;
        if (str != null) {
            d.d(c0Var, str);
        }
        if (I(2)) {
            c0Var.toString();
        }
        m1 f10 = f(c0Var);
        c0Var.f1370z = this;
        n1 n1Var = this.f1373c;
        n1Var.g(f10);
        if (!c0Var.H) {
            n1Var.a(c0Var);
            c0Var.f1363s = false;
            if (c0Var.M == null) {
                c0Var.Q = false;
            }
            if (J(c0Var)) {
                this.F = true;
            }
        }
        return f10;
    }

    public final void a0(c0 c0Var, s sVar) {
        if (!c0Var.equals(B(c0Var.f1356l)) || !(c0Var.A == null || c0Var.f1370z == this)) {
            throw new IllegalArgumentException("Fragment " + c0Var + " is not an active fragment of FragmentManager " + this);
        }
        c0Var.U = sVar;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(androidx.fragment.app.e0 r6, androidx.fragment.app.h0 r7, androidx.fragment.app.c0 r8) {
        /*
            r5 = this;
            androidx.fragment.app.e0 r0 = r5.f1392v
            if (r0 != 0) goto L_0x0147
            r5.f1392v = r6
            r5.f1393w = r7
            r5.f1394x = r8
            java.util.concurrent.CopyOnWriteArrayList r7 = r5.f1385o
            if (r8 == 0) goto L_0x0017
            androidx.fragment.app.t0 r0 = new androidx.fragment.app.t0
            r0.<init>(r8)
            r7.add(r0)
            goto L_0x001e
        L_0x0017:
            boolean r0 = r6 instanceof androidx.fragment.app.i1
            if (r0 == 0) goto L_0x001e
            r7.add(r6)
        L_0x001e:
            androidx.fragment.app.c0 r7 = r5.f1394x
            if (r7 == 0) goto L_0x0025
            r5.f0()
        L_0x0025:
            boolean r7 = r6 instanceof androidx.activity.s
            if (r7 == 0) goto L_0x0039
            androidx.fragment.app.f0 r7 = r6.f1406l
            androidx.activity.r r7 = r7.f454o
            r5.f1377g = r7
            if (r8 == 0) goto L_0x0033
            r0 = r8
            goto L_0x0034
        L_0x0033:
            r0 = r6
        L_0x0034:
            androidx.fragment.app.q0 r1 = r5.f1378h
            r7.a(r0, r1)
        L_0x0039:
            r7 = 0
            if (r8 == 0) goto L_0x005b
            androidx.fragment.app.c1 r6 = r8.f1370z
            androidx.fragment.app.h1 r6 = r6.N
            java.util.HashMap r0 = r6.f1448e
            java.lang.String r1 = r8.f1356l
            java.lang.Object r1 = r0.get(r1)
            androidx.fragment.app.h1 r1 = (androidx.fragment.app.h1) r1
            if (r1 != 0) goto L_0x0058
            androidx.fragment.app.h1 r1 = new androidx.fragment.app.h1
            boolean r6 = r6.f1450g
            r1.<init>(r6)
            java.lang.String r6 = r8.f1356l
            r0.put(r6, r1)
        L_0x0058:
            r5.N = r1
            goto L_0x007a
        L_0x005b:
            boolean r0 = r6 instanceof androidx.lifecycle.h2
            if (r0 == 0) goto L_0x0073
            androidx.lifecycle.g2 r6 = r6.m()
            android.support.v4.media.session.u r0 = new android.support.v4.media.session.u
            androidx.fragment.app.g1 r1 = androidx.fragment.app.h1.f1446j
            r0.<init>((androidx.lifecycle.g2) r6, (androidx.lifecycle.b2) r1)
            java.lang.Class<androidx.fragment.app.h1> r6 = androidx.fragment.app.h1.class
            androidx.lifecycle.w1 r6 = r0.q(r6)
            androidx.fragment.app.h1 r6 = (androidx.fragment.app.h1) r6
            goto L_0x0078
        L_0x0073:
            androidx.fragment.app.h1 r6 = new androidx.fragment.app.h1
            r6.<init>(r7)
        L_0x0078:
            r5.N = r6
        L_0x007a:
            androidx.fragment.app.h1 r6 = r5.N
            boolean r0 = r5.N()
            r6.f1452i = r0
            androidx.fragment.app.h1 r6 = r5.N
            androidx.fragment.app.n1 r0 = r5.f1373c
            r0.f1516d = r6
            androidx.fragment.app.e0 r6 = r5.f1392v
            boolean r0 = r6 instanceof t3.h
            r1 = 2
            if (r0 == 0) goto L_0x00a8
            if (r8 != 0) goto L_0x00a8
            t3.e r6 = r6.a()
            androidx.activity.f r0 = new androidx.activity.f
            r0.<init>(r1, r5)
            java.lang.String r2 = "android:support:fragments"
            r6.c(r2, r0)
            android.os.Bundle r6 = r6.a(r2)
            if (r6 == 0) goto L_0x00a8
            r5.V(r6)
        L_0x00a8:
            androidx.fragment.app.e0 r6 = r5.f1392v
            boolean r0 = r6 instanceof androidx.activity.result.h
            if (r0 == 0) goto L_0x010d
            androidx.fragment.app.f0 r6 = r6.f1406l
            androidx.activity.i r6 = r6.f455p
            if (r8 == 0) goto L_0x00c2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r8.f1356l
            java.lang.String r3 = ":"
            java.lang.String r0 = android.support.v4.media.h.p(r0, r2, r3)
            goto L_0x00c4
        L_0x00c2:
            java.lang.String r0 = ""
        L_0x00c4:
            java.lang.String r2 = "FragmentManager:"
            java.lang.String r0 = android.support.v4.media.h.m(r2, r0)
            java.lang.String r2 = "StartActivityForResult"
            java.lang.String r2 = q0.f.g(r0, r2)
            e.f r3 = new e.f
            r3.<init>()
            androidx.fragment.app.p0 r4 = new androidx.fragment.app.p0
            r4.<init>(r1, r5)
            androidx.activity.result.e r1 = r6.c(r2, r3, r4)
            r5.B = r1
            java.lang.String r1 = "StartIntentSenderForResult"
            java.lang.String r1 = q0.f.g(r0, r1)
            androidx.fragment.app.u0 r2 = new androidx.fragment.app.u0
            r2.<init>()
            androidx.fragment.app.p0 r3 = new androidx.fragment.app.p0
            r4 = 3
            r3.<init>(r4, r5)
            androidx.activity.result.e r1 = r6.c(r1, r2, r3)
            r5.C = r1
            java.lang.String r1 = "RequestPermissions"
            java.lang.String r0 = q0.f.g(r0, r1)
            e.d r1 = new e.d
            r1.<init>()
            androidx.fragment.app.p0 r2 = new androidx.fragment.app.p0
            r2.<init>(r7, r5)
            androidx.activity.result.e r6 = r6.c(r0, r1, r2)
            r5.D = r6
        L_0x010d:
            androidx.fragment.app.e0 r6 = r5.f1392v
            boolean r7 = r6 instanceof c0.h
            if (r7 == 0) goto L_0x0118
            androidx.fragment.app.o0 r7 = r5.f1386p
            r6.f(r7)
        L_0x0118:
            androidx.fragment.app.e0 r6 = r5.f1392v
            boolean r7 = r6 instanceof c0.i
            if (r7 == 0) goto L_0x0123
            androidx.fragment.app.o0 r7 = r5.f1387q
            r6.i(r7)
        L_0x0123:
            androidx.fragment.app.e0 r6 = r5.f1392v
            boolean r7 = r6 instanceof b0.m0
            if (r7 == 0) goto L_0x012e
            androidx.fragment.app.o0 r7 = r5.f1388r
            r6.g(r7)
        L_0x012e:
            androidx.fragment.app.e0 r6 = r5.f1392v
            boolean r7 = r6 instanceof b0.n0
            if (r7 == 0) goto L_0x0139
            androidx.fragment.app.o0 r7 = r5.f1389s
            r6.h(r7)
        L_0x0139:
            androidx.fragment.app.e0 r6 = r5.f1392v
            boolean r7 = r6 instanceof m0.q
            if (r7 == 0) goto L_0x0146
            if (r8 != 0) goto L_0x0146
            androidx.fragment.app.r0 r7 = r5.f1390t
            r6.e(r7)
        L_0x0146:
            return
        L_0x0147:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Already attached"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c1.b(androidx.fragment.app.e0, androidx.fragment.app.h0, androidx.fragment.app.c0):void");
    }

    public final void b0(c0 c0Var) {
        if (c0Var == null || (c0Var.equals(B(c0Var.f1356l)) && (c0Var.A == null || c0Var.f1370z == this))) {
            c0 c0Var2 = this.f1395y;
            this.f1395y = c0Var;
            q(c0Var2);
            q(this.f1395y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + c0Var + " is not an active fragment of FragmentManager " + this);
    }

    public final void c(c0 c0Var) {
        if (I(2)) {
            Objects.toString(c0Var);
        }
        if (c0Var.H) {
            c0Var.H = false;
            if (!c0Var.f1362r) {
                this.f1373c.a(c0Var);
                if (I(2)) {
                    c0Var.toString();
                }
                if (J(c0Var)) {
                    this.F = true;
                }
            }
        }
    }

    public final void c0(c0 c0Var) {
        int i10;
        int i11;
        int i12;
        int i13;
        ViewGroup F2 = F(c0Var);
        if (F2 != null) {
            x xVar = c0Var.P;
            boolean z10 = false;
            if (xVar == null) {
                i10 = 0;
            } else {
                i10 = xVar.f1598b;
            }
            if (xVar == null) {
                i11 = 0;
            } else {
                i11 = xVar.f1599c;
            }
            int i14 = i11 + i10;
            if (xVar == null) {
                i12 = 0;
            } else {
                i12 = xVar.f1600d;
            }
            int i15 = i12 + i14;
            if (xVar == null) {
                i13 = 0;
            } else {
                i13 = xVar.f1601e;
            }
            if (i13 + i15 > 0) {
                if (F2.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    F2.setTag(R.id.visible_removing_fragment_view_tag, c0Var);
                }
                c0 c0Var2 = (c0) F2.getTag(R.id.visible_removing_fragment_view_tag);
                x xVar2 = c0Var.P;
                if (xVar2 != null) {
                    z10 = xVar2.f1597a;
                }
                if (c0Var2.P != null) {
                    c0Var2.s().f1597a = z10;
                }
            }
        }
    }

    public final void d() {
        this.f1372b = false;
        this.L.clear();
        this.K.clear();
    }

    public final void d0() {
        Iterator it = this.f1373c.d().iterator();
        while (it.hasNext()) {
            m1 m1Var = (m1) it.next();
            c0 c0Var = m1Var.f1502c;
            if (c0Var.N) {
                if (this.f1372b) {
                    this.J = true;
                } else {
                    c0Var.N = false;
                    m1Var.k();
                }
            }
        }
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f1373c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((m1) it.next()).f1502c.L;
            if (viewGroup != null) {
                p0 H2 = H();
                n.f1505f.getClass();
                hashSet.add(c2.a(viewGroup, H2));
            }
        }
        return hashSet;
    }

    public final void e0(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new a2());
        e0 e0Var = this.f1392v;
        if (e0Var != null) {
            try {
                e0Var.f1406l.dump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
            }
        } else {
            v("  ", (FileDescriptor) null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    public final m1 f(c0 c0Var) {
        String str = c0Var.f1356l;
        n1 n1Var = this.f1373c;
        m1 m1Var = (m1) n1Var.f1514b.get(str);
        if (m1Var != null) {
            return m1Var;
        }
        m1 m1Var2 = new m1(this.f1384n, n1Var, c0Var);
        m1Var2.m(this.f1392v.f1403i.getClassLoader());
        m1Var2.f1504e = this.f1391u;
        return m1Var2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r0 = r4.f1378h;
        r1 = r4.f1374d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        if (r1 == null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        r1 = r1.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        if (r1 <= 0) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (M(r4.f1394x) == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        r0.f489a = r2;
        r0 = r0.f491c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        r0.b(java.lang.Boolean.valueOf(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f0() {
        /*
            r4 = this;
            java.util.ArrayList r0 = r4.f1371a
            monitor-enter(r0)
            java.util.ArrayList r1 = r4.f1371a     // Catch:{ all -> 0x001a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x001a }
            r2 = 1
            if (r1 != 0) goto L_0x001e
            androidx.fragment.app.q0 r1 = r4.f1378h     // Catch:{ all -> 0x001a }
            r1.f489a = r2     // Catch:{ all -> 0x001a }
            l0.a r1 = r1.f491c     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x001c
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x001a }
            r1.b(r2)     // Catch:{ all -> 0x001a }
            goto L_0x001c
        L_0x001a:
            r1 = move-exception
            goto L_0x0046
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            androidx.fragment.app.q0 r0 = r4.f1378h
            java.util.ArrayList r1 = r4.f1374d
            r3 = 0
            if (r1 == 0) goto L_0x002b
            int r1 = r1.size()
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            if (r1 <= 0) goto L_0x0037
            androidx.fragment.app.c0 r1 = r4.f1394x
            boolean r1 = M(r1)
            if (r1 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            r0.f489a = r2
            l0.a r0 = r0.f491c
            if (r0 == 0) goto L_0x0045
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r0.b(r1)
        L_0x0045:
            return
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c1.f0():void");
    }

    public final void g(c0 c0Var) {
        if (I(2)) {
            Objects.toString(c0Var);
        }
        if (!c0Var.H) {
            c0Var.H = true;
            if (c0Var.f1362r) {
                if (I(2)) {
                    c0Var.toString();
                }
                n1 n1Var = this.f1373c;
                synchronized (n1Var.f1513a) {
                    n1Var.f1513a.remove(c0Var);
                }
                c0Var.f1362r = false;
                if (J(c0Var)) {
                    this.F = true;
                }
                c0(c0Var);
            }
        }
    }

    public final void h(boolean z10, Configuration configuration) {
        if (!z10 || !(this.f1392v instanceof c0.h)) {
            for (c0 c0Var : this.f1373c.f()) {
                if (c0Var != null) {
                    c0Var.onConfigurationChanged(configuration);
                    if (z10) {
                        c0Var.B.h(true, configuration);
                    }
                }
            }
            return;
        }
        e0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        throw null;
    }

    public final boolean i() {
        boolean z10;
        if (this.f1391u < 1) {
            return false;
        }
        for (c0 c0Var : this.f1373c.f()) {
            if (c0Var != null) {
                if (!c0Var.G) {
                    z10 = c0Var.B.i();
                } else {
                    z10 = false;
                }
                if (z10) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean j() {
        boolean z10;
        if (this.f1391u < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z11 = false;
        for (c0 c0Var : this.f1373c.f()) {
            if (c0Var != null && L(c0Var)) {
                if (!c0Var.G) {
                    z10 = c0Var.B.j() | false;
                } else {
                    z10 = false;
                }
                if (z10) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0Var);
                    z11 = true;
                }
            }
        }
        if (this.f1375e != null) {
            for (int i10 = 0; i10 < this.f1375e.size(); i10++) {
                c0 c0Var2 = (c0) this.f1375e.get(i10);
                if (arrayList == null || !arrayList.contains(c0Var2)) {
                    c0Var2.getClass();
                }
            }
        }
        this.f1375e = arrayList;
        return z11;
    }

    public final void k() {
        Integer num;
        Integer num2;
        Integer num3;
        boolean z10 = true;
        this.I = true;
        y(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((n) it.next()).g();
        }
        e0 e0Var = this.f1392v;
        boolean z11 = e0Var instanceof h2;
        n1 n1Var = this.f1373c;
        if (z11) {
            z10 = n1Var.f1516d.f1451h;
        } else {
            Context context = e0Var.f1403i;
            if (context instanceof Activity) {
                z10 = true ^ ((Activity) context).isChangingConfigurations();
            }
        }
        if (z10) {
            for (e eVar : this.f1380j.values()) {
                for (String d10 : eVar.f1400h) {
                    h1 h1Var = n1Var.f1516d;
                    h1Var.getClass();
                    I(3);
                    h1Var.d(d10);
                }
            }
        }
        t(-1);
        e0 e0Var2 = this.f1392v;
        if (e0Var2 instanceof i) {
            e0Var2.p(this.f1387q);
        }
        e0 e0Var3 = this.f1392v;
        if (e0Var3 instanceof c0.h) {
            e0Var3.k(this.f1386p);
        }
        e0 e0Var4 = this.f1392v;
        if (e0Var4 instanceof m0) {
            e0Var4.l(this.f1388r);
        }
        e0 e0Var5 = this.f1392v;
        if (e0Var5 instanceof n0) {
            e0Var5.n(this.f1389s);
        }
        e0 e0Var6 = this.f1392v;
        if ((e0Var6 instanceof q) && this.f1394x == null) {
            e0Var6.j(this.f1390t);
        }
        this.f1392v = null;
        this.f1393w = null;
        this.f1394x = null;
        if (this.f1377g != null) {
            this.f1378h.a();
            this.f1377g = null;
        }
        e eVar2 = this.B;
        if (eVar2 != null) {
            g gVar = eVar2.f506c;
            ArrayList arrayList = gVar.f513e;
            String str = eVar2.f504a;
            if (!arrayList.contains(str) && (num3 = (Integer) gVar.f511c.remove(str)) != null) {
                gVar.f510b.remove(num3);
            }
            gVar.f514f.remove(str);
            HashMap hashMap = gVar.f515g;
            if (hashMap.containsKey(str)) {
                StringBuilder s10 = h.s("Dropping pending result for request ", str, ": ");
                s10.append(hashMap.get(str));
                Log.w("ActivityResultRegistry", s10.toString());
                hashMap.remove(str);
            }
            Bundle bundle = gVar.f516h;
            if (bundle.containsKey(str)) {
                StringBuilder s11 = h.s("Dropping pending result for request ", str, ": ");
                s11.append(bundle.getParcelable(str));
                Log.w("ActivityResultRegistry", s11.toString());
                bundle.remove(str);
            }
            h.y(gVar.f512d.get(str));
            e eVar3 = this.C;
            g gVar2 = eVar3.f506c;
            ArrayList arrayList2 = gVar2.f513e;
            String str2 = eVar3.f504a;
            if (!arrayList2.contains(str2) && (num2 = (Integer) gVar2.f511c.remove(str2)) != null) {
                gVar2.f510b.remove(num2);
            }
            gVar2.f514f.remove(str2);
            HashMap hashMap2 = gVar2.f515g;
            if (hashMap2.containsKey(str2)) {
                StringBuilder s12 = h.s("Dropping pending result for request ", str2, ": ");
                s12.append(hashMap2.get(str2));
                Log.w("ActivityResultRegistry", s12.toString());
                hashMap2.remove(str2);
            }
            Bundle bundle2 = gVar2.f516h;
            if (bundle2.containsKey(str2)) {
                StringBuilder s13 = h.s("Dropping pending result for request ", str2, ": ");
                s13.append(bundle2.getParcelable(str2));
                Log.w("ActivityResultRegistry", s13.toString());
                bundle2.remove(str2);
            }
            h.y(gVar2.f512d.get(str2));
            e eVar4 = this.D;
            g gVar3 = eVar4.f506c;
            ArrayList arrayList3 = gVar3.f513e;
            String str3 = eVar4.f504a;
            if (!arrayList3.contains(str3) && (num = (Integer) gVar3.f511c.remove(str3)) != null) {
                gVar3.f510b.remove(num);
            }
            gVar3.f514f.remove(str3);
            HashMap hashMap3 = gVar3.f515g;
            if (hashMap3.containsKey(str3)) {
                StringBuilder s14 = h.s("Dropping pending result for request ", str3, ": ");
                s14.append(hashMap3.get(str3));
                Log.w("ActivityResultRegistry", s14.toString());
                hashMap3.remove(str3);
            }
            Bundle bundle3 = gVar3.f516h;
            if (bundle3.containsKey(str3)) {
                StringBuilder s15 = h.s("Dropping pending result for request ", str3, ": ");
                s15.append(bundle3.getParcelable(str3));
                Log.w("ActivityResultRegistry", s15.toString());
                bundle3.remove(str3);
            }
            h.y(gVar3.f512d.get(str3));
        }
    }

    public final void l(boolean z10) {
        if (!z10 || !(this.f1392v instanceof i)) {
            for (c0 c0Var : this.f1373c.f()) {
                if (c0Var != null) {
                    c0Var.onLowMemory();
                    if (z10) {
                        c0Var.B.l(true);
                    }
                }
            }
            return;
        }
        e0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        throw null;
    }

    public final void m(boolean z10, boolean z11) {
        if (!z11 || !(this.f1392v instanceof m0)) {
            for (c0 c0Var : this.f1373c.f()) {
                if (c0Var != null && z11) {
                    c0Var.B.m(z10, true);
                }
            }
            return;
        }
        e0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        throw null;
    }

    public final void n() {
        Iterator it = this.f1373c.e().iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            if (c0Var != null) {
                c0Var.G();
                c0Var.B.n();
            }
        }
    }

    public final boolean o() {
        boolean z10;
        if (this.f1391u < 1) {
            return false;
        }
        for (c0 c0Var : this.f1373c.f()) {
            if (c0Var != null) {
                if (!c0Var.G) {
                    z10 = c0Var.B.o();
                } else {
                    z10 = false;
                }
                if (z10) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void p() {
        if (this.f1391u >= 1) {
            for (c0 c0Var : this.f1373c.f()) {
                if (c0Var != null && !c0Var.G) {
                    c0Var.B.p();
                }
            }
        }
    }

    public final void q(c0 c0Var) {
        if (c0Var != null && c0Var.equals(B(c0Var.f1356l))) {
            c0Var.f1370z.getClass();
            boolean M2 = M(c0Var);
            Boolean bool = c0Var.f1361q;
            if (bool == null || bool.booleanValue() != M2) {
                c0Var.f1361q = Boolean.valueOf(M2);
                d1 d1Var = c0Var.B;
                d1Var.f0();
                d1Var.q(d1Var.f1395y);
            }
        }
    }

    public final void r(boolean z10, boolean z11) {
        if (!z11 || !(this.f1392v instanceof n0)) {
            for (c0 c0Var : this.f1373c.f()) {
                if (c0Var != null) {
                    c0Var.U(z10);
                    if (z11) {
                        c0Var.B.r(z10, true);
                    }
                }
            }
            return;
        }
        e0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        throw null;
    }

    public final boolean s() {
        boolean z10;
        if (this.f1391u < 1) {
            return false;
        }
        boolean z11 = false;
        for (c0 c0Var : this.f1373c.f()) {
            if (c0Var != null && L(c0Var)) {
                if (!c0Var.G) {
                    z10 = c0Var.B.s() | false;
                } else {
                    z10 = false;
                }
                if (z10) {
                    z11 = true;
                }
            }
        }
        return z11;
    }

    /* JADX INFO: finally extract failed */
    public final void t(int i10) {
        try {
            this.f1372b = true;
            for (m1 m1Var : this.f1373c.f1514b.values()) {
                if (m1Var != null) {
                    m1Var.f1504e = i10;
                }
            }
            O(i10, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((n) it.next()).g();
            }
            this.f1372b = false;
            y(true);
        } catch (Throwable th) {
            this.f1372b = false;
            throw th;
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        c0 c0Var = this.f1394x;
        if (c0Var != null) {
            sb2.append(c0Var.getClass().getSimpleName());
            sb2.append("{");
            obj = this.f1394x;
        } else {
            e0 e0Var = this.f1392v;
            if (e0Var != null) {
                sb2.append(e0Var.getClass().getSimpleName());
                sb2.append("{");
                obj = this.f1392v;
            } else {
                sb2.append("null");
                sb2.append("}}");
                return sb2.toString();
            }
        }
        sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        sb2.append("}");
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u() {
        if (this.J) {
            this.J = false;
            d0();
        }
    }

    public final void v(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String g10 = f.g(str, "    ");
        n1 n1Var = this.f1373c;
        n1Var.getClass();
        String str2 = str + "    ";
        HashMap hashMap = n1Var.f1514b;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (m1 m1Var : hashMap.values()) {
                printWriter.print(str);
                if (m1Var != null) {
                    c0 c0Var = m1Var.f1502c;
                    printWriter.println(c0Var);
                    c0Var.getClass();
                    printWriter.print(str2);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(c0Var.D));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(c0Var.E));
                    printWriter.print(" mTag=");
                    printWriter.println(c0Var.F);
                    printWriter.print(str2);
                    printWriter.print("mState=");
                    printWriter.print(c0Var.f1352h);
                    printWriter.print(" mWho=");
                    printWriter.print(c0Var.f1356l);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(c0Var.f1369y);
                    printWriter.print(str2);
                    printWriter.print("mAdded=");
                    printWriter.print(c0Var.f1362r);
                    printWriter.print(" mRemoving=");
                    printWriter.print(c0Var.f1363s);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(c0Var.f1365u);
                    printWriter.print(" mInLayout=");
                    printWriter.println(c0Var.f1366v);
                    printWriter.print(str2);
                    printWriter.print("mHidden=");
                    printWriter.print(c0Var.G);
                    printWriter.print(" mDetached=");
                    printWriter.print(c0Var.H);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(c0Var.J);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(str2);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(c0Var.I);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(c0Var.O);
                    if (c0Var.f1370z != null) {
                        printWriter.print(str2);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(c0Var.f1370z);
                    }
                    if (c0Var.A != null) {
                        printWriter.print(str2);
                        printWriter.print("mHost=");
                        printWriter.println(c0Var.A);
                    }
                    if (c0Var.C != null) {
                        printWriter.print(str2);
                        printWriter.print("mParentFragment=");
                        printWriter.println(c0Var.C);
                    }
                    if (c0Var.f1357m != null) {
                        printWriter.print(str2);
                        printWriter.print("mArguments=");
                        printWriter.println(c0Var.f1357m);
                    }
                    if (c0Var.f1353i != null) {
                        printWriter.print(str2);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(c0Var.f1353i);
                    }
                    if (c0Var.f1354j != null) {
                        printWriter.print(str2);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(c0Var.f1354j);
                    }
                    if (c0Var.f1355k != null) {
                        printWriter.print(str2);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(c0Var.f1355k);
                    }
                    c0 B2 = c0Var.B(false);
                    if (B2 != null) {
                        printWriter.print(str2);
                        printWriter.print("mTarget=");
                        printWriter.print(B2);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(c0Var.f1360p);
                    }
                    printWriter.print(str2);
                    printWriter.print("mPopDirection=");
                    x xVar = c0Var.P;
                    printWriter.println(xVar == null ? false : xVar.f1597a);
                    x xVar2 = c0Var.P;
                    if ((xVar2 == null ? 0 : xVar2.f1598b) != 0) {
                        printWriter.print(str2);
                        printWriter.print("getEnterAnim=");
                        x xVar3 = c0Var.P;
                        printWriter.println(xVar3 == null ? 0 : xVar3.f1598b);
                    }
                    x xVar4 = c0Var.P;
                    if ((xVar4 == null ? 0 : xVar4.f1599c) != 0) {
                        printWriter.print(str2);
                        printWriter.print("getExitAnim=");
                        x xVar5 = c0Var.P;
                        printWriter.println(xVar5 == null ? 0 : xVar5.f1599c);
                    }
                    x xVar6 = c0Var.P;
                    if ((xVar6 == null ? 0 : xVar6.f1600d) != 0) {
                        printWriter.print(str2);
                        printWriter.print("getPopEnterAnim=");
                        x xVar7 = c0Var.P;
                        printWriter.println(xVar7 == null ? 0 : xVar7.f1600d);
                    }
                    x xVar8 = c0Var.P;
                    if ((xVar8 == null ? 0 : xVar8.f1601e) != 0) {
                        printWriter.print(str2);
                        printWriter.print("getPopExitAnim=");
                        x xVar9 = c0Var.P;
                        printWriter.println(xVar9 == null ? 0 : xVar9.f1601e);
                    }
                    if (c0Var.L != null) {
                        printWriter.print(str2);
                        printWriter.print("mContainer=");
                        printWriter.println(c0Var.L);
                    }
                    if (c0Var.M != null) {
                        printWriter.print(str2);
                        printWriter.print("mView=");
                        printWriter.println(c0Var.M);
                    }
                    if (c0Var.v() != null) {
                        new c1.d(c0Var, c0Var.m()).b(str2, printWriter);
                    }
                    printWriter.print(str2);
                    printWriter.println("Child " + c0Var.B + Constants.EXT_TAG_END);
                    c0Var.B.v(f.g(str2, "  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = n1Var.f1513a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size3; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(((c0) arrayList.get(i10)).toString());
            }
        }
        ArrayList arrayList2 = this.f1375e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i11 = 0; i11 < size2; i11++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(((c0) this.f1375e.get(i11)).toString());
            }
        }
        ArrayList arrayList3 = this.f1374d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i12 = 0; i12 < size; i12++) {
                a aVar = (a) this.f1374d.get(i12);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i12);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.j(g10, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1379i.get());
        synchronized (this.f1371a) {
            int size4 = this.f1371a.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i13 = 0; i13 < size4; i13++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i13);
                    printWriter.print(": ");
                    printWriter.println((z0) this.f1371a.get(i13));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1392v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1393w);
        if (this.f1394x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1394x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1391u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.G);
        printWriter.print(" mStopped=");
        printWriter.print(this.H);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.I);
        if (this.F) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.F);
        }
    }

    public final void w(z0 z0Var, boolean z10) {
        if (!z10) {
            if (this.f1392v == null) {
                if (this.I) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (N()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f1371a) {
            if (this.f1392v != null) {
                this.f1371a.add(z0Var);
                X();
            } else if (!z10) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void x(boolean z10) {
        if (this.f1372b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f1392v == null) {
            if (this.I) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.f1392v.f1404j.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (!z10 && N()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.K == null) {
            this.K = new ArrayList();
            this.L = new ArrayList();
        }
    }

    public final boolean y(boolean z10) {
        boolean z11;
        x(z10);
        boolean z12 = false;
        while (true) {
            ArrayList arrayList = this.K;
            ArrayList arrayList2 = this.L;
            synchronized (this.f1371a) {
                if (this.f1371a.isEmpty()) {
                    z11 = false;
                } else {
                    try {
                        int size = this.f1371a.size();
                        z11 = false;
                        for (int i10 = 0; i10 < size; i10++) {
                            z11 |= ((z0) this.f1371a.get(i10)).a(arrayList, arrayList2);
                        }
                    } finally {
                        this.f1371a.clear();
                        this.f1392v.f1404j.removeCallbacks(this.O);
                    }
                }
            }
            if (z11) {
                z12 = true;
                this.f1372b = true;
                try {
                    U(this.K, this.L);
                } finally {
                    d();
                }
            } else {
                f0();
                u();
                this.f1373c.f1514b.values().removeAll(Collections.singleton((Object) null));
                return z12;
            }
        }
    }

    public final void z(z0 z0Var, boolean z10) {
        if (!z10 || (this.f1392v != null && !this.I)) {
            x(z10);
            if (z0Var.a(this.K, this.L)) {
                this.f1372b = true;
                try {
                    U(this.K, this.L);
                } finally {
                    d();
                }
            }
            f0();
            u();
            this.f1373c.f1514b.values().removeAll(Collections.singleton((Object) null));
        }
    }
}
