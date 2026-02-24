package j3;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.media.h;
import android.util.AttributeSet;
import androidx.fragment.app.k;
import fb.w;
import hb.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.a;
import la.v;
import ma.j0;
import ma.s;
import ma.z;
import q.l;
import q.m;
import xa.j;
import xa.y;

public abstract class c1 {

    /* renamed from: q  reason: collision with root package name */
    public static final a1 f8505q = new a1(0);

    /* renamed from: h  reason: collision with root package name */
    public final String f8506h;

    /* renamed from: i  reason: collision with root package name */
    public h1 f8507i;

    /* renamed from: j  reason: collision with root package name */
    public String f8508j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f8509k;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f8510l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public final l f8511m = new l();

    /* renamed from: n  reason: collision with root package name */
    public final LinkedHashMap f8512n = new LinkedHashMap();

    /* renamed from: o  reason: collision with root package name */
    public int f8513o;

    /* renamed from: p  reason: collision with root package name */
    public String f8514p;

    static {
        new LinkedHashMap();
    }

    public c1(o2 o2Var) {
        j.f("navigator", o2Var);
        p2 p2Var = q2.f8656b;
        Class<?> cls = o2Var.getClass();
        p2Var.getClass();
        this.f8506h = p2.a(cls);
    }

    public final void a(u0 u0Var) {
        ArrayList e12 = h0.e1(e(), new k(1, u0Var));
        if (e12.isEmpty()) {
            this.f8510l.add(u0Var);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + u0Var.f8694a + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + e12).toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0094 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle b(android.os.Bundle r7) {
        /*
            r6 = this;
            java.util.LinkedHashMap r0 = r6.f8512n
            if (r7 != 0) goto L_0x0014
            if (r0 == 0) goto L_0x000f
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r1 = 0
            goto L_0x0010
        L_0x000f:
            r1 = 1
        L_0x0010:
            if (r1 == 0) goto L_0x0014
            r7 = 0
            return r7
        L_0x0014:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.util.Set r2 = r0.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0021:
            boolean r3 = r2.hasNext()
            java.lang.String r4 = "name"
            if (r3 == 0) goto L_0x004d
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r5 = r3.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.getValue()
            j3.m r3 = (j3.m) r3
            r3.getClass()
            xa.j.f(r4, r5)
            boolean r4 = r3.f8613c
            if (r4 == 0) goto L_0x0021
            j3.g2 r4 = r3.f8611a
            java.lang.Object r3 = r3.f8614d
            r4.e(r1, r5, r3)
            goto L_0x0021
        L_0x004d:
            if (r7 == 0) goto L_0x00b6
            r1.putAll(r7)
            java.util.Set r7 = r0.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x005a:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x00b6
            java.lang.Object r0 = r7.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r2 = r0.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.getValue()
            j3.m r0 = (j3.m) r0
            r0.getClass()
            xa.j.f(r4, r2)
            boolean r3 = r0.f8612b
            j3.g2 r0 = r0.f8611a
            if (r3 != 0) goto L_0x008b
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x008b
            java.lang.Object r3 = r1.get(r2)
            if (r3 != 0) goto L_0x008b
            goto L_0x0090
        L_0x008b:
            r0.a(r1, r2)     // Catch:{ ClassCastException -> 0x0090 }
            r3 = 1
            goto L_0x0091
        L_0x0090:
            r3 = 0
        L_0x0091:
            if (r3 == 0) goto L_0x0094
            goto L_0x005a
        L_0x0094:
            java.lang.String r7 = "Wrong argument type for '"
            java.lang.String r1 = "' in argument bundle. "
            java.lang.StringBuilder r7 = android.support.v4.media.h.s(r7, r2, r1)
            java.lang.String r0 = r0.b()
            r7.append(r0)
            java.lang.String r0 = " expected."
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        L_0x00b6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.c1.b(android.os.Bundle):android.os.Bundle");
    }

    public final int[] c(c1 c1Var) {
        h1 h1Var;
        ma.l lVar = new ma.l();
        h1 h1Var2 = this;
        while (true) {
            h1 h1Var3 = h1Var2.f8507i;
            if (c1Var != null) {
                h1Var = c1Var.f8507i;
            } else {
                h1Var = null;
            }
            if (h1Var != null) {
                h1 h1Var4 = c1Var.f8507i;
                j.c(h1Var4);
                if (h1Var4.i(h1Var2.f8513o, true) == h1Var2) {
                    lVar.c(h1Var2);
                    break;
                }
            }
            if (h1Var3 == null || h1Var3.f8558s != h1Var2.f8513o) {
                lVar.c(h1Var2);
            }
            if (j.a(h1Var3, c1Var) || h1Var3 == null) {
                break;
            }
            h1Var2 = h1Var3;
        }
        List<c1> J = z.J(lVar);
        ArrayList arrayList = new ArrayList(s.i(J));
        for (c1 c1Var2 : J) {
            arrayList.add(Integer.valueOf(c1Var2.f8513o));
        }
        return z.I(arrayList);
    }

    public final h d(int i10) {
        boolean z10;
        h hVar;
        l lVar = this.f8511m;
        if (lVar.g() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            hVar = null;
        } else {
            hVar = (h) lVar.d(i10, (Integer) null);
        }
        if (hVar != null) {
            return hVar;
        }
        h1 h1Var = this.f8507i;
        if (h1Var != null) {
            return h1Var.d(i10);
        }
        return null;
    }

    public final Map e() {
        return j0.g(this.f8512n);
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x016d A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r12) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L_0x0174
            boolean r1 = r12 instanceof j3.c1
            if (r1 != 0) goto L_0x0009
            goto L_0x0174
        L_0x0009:
            java.util.ArrayList r1 = r11.f8510l
            j3.c1 r12 = (j3.c1) r12
            java.util.ArrayList r2 = r12.f8510l
            java.lang.String r3 = "<this>"
            xa.j.f(r3, r1)
            java.lang.String r4 = "other"
            xa.j.f(r4, r2)
            java.util.Set r4 = ma.z.M(r1)
            r4.retainAll(r2)
            int r2 = r4.size()
            int r1 = r1.size()
            r4 = 1
            if (r2 != r1) goto L_0x002d
            r1 = 1
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            q.l r2 = r11.f8511m
            int r5 = r2.g()
            q.l r6 = r12.f8511m
            int r7 = r6.g()
            if (r5 != r7) goto L_0x00b5
            q.m r5 = hb.h0.a2(r2)
            eb.h r5 = eb.m.a(r5)
            java.util.Iterator r5 = r5.iterator()
        L_0x0048:
            boolean r7 = r5.hasNext()
            r8 = -1
            if (r7 == 0) goto L_0x0075
            java.lang.Object r7 = r5.next()
            j3.h r7 = (j3.h) r7
            boolean r9 = r6.f13083h
            if (r9 == 0) goto L_0x005c
            r6.c()
        L_0x005c:
            r9 = 0
        L_0x005d:
            int r10 = r6.f13086k
            if (r9 >= r10) goto L_0x006b
            java.lang.Object[] r10 = r6.f13085j
            r10 = r10[r9]
            if (r10 != r7) goto L_0x0068
            goto L_0x006c
        L_0x0068:
            int r9 = r9 + 1
            goto L_0x005d
        L_0x006b:
            r9 = -1
        L_0x006c:
            if (r9 < 0) goto L_0x0070
            r7 = 1
            goto L_0x0071
        L_0x0070:
            r7 = 0
        L_0x0071:
            if (r7 != 0) goto L_0x0048
            r5 = 0
            goto L_0x0076
        L_0x0075:
            r5 = 1
        L_0x0076:
            if (r5 == 0) goto L_0x00b5
            q.m r5 = hb.h0.a2(r6)
            eb.h r5 = eb.m.a(r5)
            java.util.Iterator r5 = r5.iterator()
        L_0x0084:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00b0
            java.lang.Object r6 = r5.next()
            j3.h r6 = (j3.h) r6
            boolean r7 = r2.f13083h
            if (r7 == 0) goto L_0x0097
            r2.c()
        L_0x0097:
            r7 = 0
        L_0x0098:
            int r9 = r2.f13086k
            if (r7 >= r9) goto L_0x00a6
            java.lang.Object[] r9 = r2.f13085j
            r9 = r9[r7]
            if (r9 != r6) goto L_0x00a3
            goto L_0x00a7
        L_0x00a3:
            int r7 = r7 + 1
            goto L_0x0098
        L_0x00a6:
            r7 = -1
        L_0x00a7:
            if (r7 < 0) goto L_0x00ab
            r6 = 1
            goto L_0x00ac
        L_0x00ab:
            r6 = 0
        L_0x00ac:
            if (r6 != 0) goto L_0x0084
            r2 = 0
            goto L_0x00b1
        L_0x00b0:
            r2 = 1
        L_0x00b1:
            if (r2 == 0) goto L_0x00b5
            r2 = 1
            goto L_0x00b6
        L_0x00b5:
            r2 = 0
        L_0x00b6:
            java.util.Map r5 = r11.e()
            int r5 = r5.size()
            java.util.Map r6 = r12.e()
            int r6 = r6.size()
            if (r5 != r6) goto L_0x015c
            java.util.Map r5 = r11.e()
            java.util.Set r5 = r5.entrySet()
            xa.j.f(r3, r5)
            java.util.Iterator r5 = r5.iterator()
        L_0x00d7:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x010e
            java.lang.Object r6 = r5.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.util.Map r7 = r12.e()
            java.lang.Object r8 = r6.getKey()
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L_0x0109
            java.util.Map r7 = r12.e()
            java.lang.Object r8 = r6.getKey()
            java.lang.Object r7 = r7.get(r8)
            java.lang.Object r6 = r6.getValue()
            boolean r6 = xa.j.a(r7, r6)
            if (r6 == 0) goto L_0x0109
            r6 = 1
            goto L_0x010a
        L_0x0109:
            r6 = 0
        L_0x010a:
            if (r6 != 0) goto L_0x00d7
            r5 = 0
            goto L_0x010f
        L_0x010e:
            r5 = 1
        L_0x010f:
            if (r5 == 0) goto L_0x015c
            java.util.Map r5 = r12.e()
            java.util.Set r5 = r5.entrySet()
            xa.j.f(r3, r5)
            java.util.Iterator r3 = r5.iterator()
        L_0x0120:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0157
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.util.Map r6 = r11.e()
            java.lang.Object r7 = r5.getKey()
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto L_0x0152
            java.util.Map r6 = r11.e()
            java.lang.Object r7 = r5.getKey()
            java.lang.Object r6 = r6.get(r7)
            java.lang.Object r5 = r5.getValue()
            boolean r5 = xa.j.a(r6, r5)
            if (r5 == 0) goto L_0x0152
            r5 = 1
            goto L_0x0153
        L_0x0152:
            r5 = 0
        L_0x0153:
            if (r5 != 0) goto L_0x0120
            r3 = 0
            goto L_0x0158
        L_0x0157:
            r3 = 1
        L_0x0158:
            if (r3 == 0) goto L_0x015c
            r3 = 1
            goto L_0x015d
        L_0x015c:
            r3 = 0
        L_0x015d:
            int r5 = r11.f8513o
            int r6 = r12.f8513o
            if (r5 != r6) goto L_0x0174
            java.lang.String r5 = r11.f8514p
            java.lang.String r12 = r12.f8514p
            boolean r12 = xa.j.a(r5, r12)
            if (r12 == 0) goto L_0x0174
            if (r1 == 0) goto L_0x0174
            if (r2 == 0) goto L_0x0174
            if (r3 == 0) goto L_0x0174
            r0 = 1
        L_0x0174:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.c1.equals(java.lang.Object):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.util.regex.Matcher} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.util.regex.Matcher} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: java.util.regex.Matcher} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: java.util.regex.Matcher} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: java.util.regex.Matcher} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: java.util.regex.Matcher} */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ef, code lost:
        if ((!hb.h0.e1(r4, new j3.t0(0, r6)).isEmpty()) != false) goto L_0x00f1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02f2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x023b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j3.b1 f(android.support.v4.media.session.u r23) {
        /*
            r22 = this;
            r7 = r22
            r8 = r23
            java.util.ArrayList r0 = r7.f8510l
            boolean r1 = r0.isEmpty()
            r9 = 0
            if (r1 == 0) goto L_0x000e
            return r9
        L_0x000e:
            java.util.Iterator r10 = r0.iterator()
            r11 = r9
        L_0x0013:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x02f5
            java.lang.Object r0 = r10.next()
            j3.u0 r0 = (j3.u0) r0
            java.lang.Object r1 = r8.f428i
            android.net.Uri r1 = (android.net.Uri) r1
            if (r1 == 0) goto L_0x00f4
            java.util.Map r4 = r22.e()
            r0.getClass()
            la.o r5 = r0.f8699f
            java.lang.Object r5 = r5.getValue()
            java.util.regex.Pattern r5 = (java.util.regex.Pattern) r5
            if (r5 == 0) goto L_0x003f
            java.lang.String r6 = r1.toString()
            java.util.regex.Matcher r5 = r5.matcher(r6)
            goto L_0x0040
        L_0x003f:
            r5 = r9
        L_0x0040:
            if (r5 != 0) goto L_0x0044
            goto L_0x00f1
        L_0x0044:
            boolean r6 = r5.matches()
            if (r6 != 0) goto L_0x004c
            goto L_0x00f1
        L_0x004c:
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            boolean r5 = r0.b(r5, r6, r4)
            if (r5 != 0) goto L_0x0059
            goto L_0x00f1
        L_0x0059:
            la.o r5 = r0.f8700g
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x006f
            boolean r5 = r0.c(r1, r6, r4)
            if (r5 != 0) goto L_0x006f
            goto L_0x00f1
        L_0x006f:
            java.lang.String r5 = r1.getFragment()
            la.o r12 = r0.f8706m
            java.lang.Object r12 = r12.getValue()
            java.util.regex.Pattern r12 = (java.util.regex.Pattern) r12
            if (r12 == 0) goto L_0x0086
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.util.regex.Matcher r5 = r12.matcher(r5)
            goto L_0x0087
        L_0x0086:
            r5 = r9
        L_0x0087:
            if (r5 != 0) goto L_0x008a
            goto L_0x00df
        L_0x008a:
            boolean r12 = r5.matches()
            if (r12 != 0) goto L_0x0091
            goto L_0x00df
        L_0x0091:
            la.e r12 = r0.f8704k
            java.lang.Object r12 = r12.getValue()
            java.util.List r12 = (java.util.List) r12
            java.util.ArrayList r13 = new java.util.ArrayList
            int r14 = ma.s.i(r12)
            r13.<init>(r14)
            java.util.Iterator r12 = r12.iterator()
            r14 = 0
        L_0x00a7:
            boolean r15 = r12.hasNext()
            if (r15 == 0) goto L_0x00df
            java.lang.Object r15 = r12.next()
            int r2 = r14 + 1
            if (r14 < 0) goto L_0x00da
            java.lang.String r15 = (java.lang.String) r15
            java.lang.String r14 = r5.group(r2)
            java.lang.String r14 = android.net.Uri.decode(r14)
            java.lang.Object r16 = r4.get(r15)
            r3 = r16
            j3.m r3 = (j3.m) r3
            java.lang.String r9 = "value"
            xa.j.e(r9, r14)     // Catch:{ IllegalArgumentException -> 0x00d7 }
            j3.u0.d(r6, r15, r14, r3)     // Catch:{ IllegalArgumentException -> 0x00d7 }
            la.v r3 = la.v.f9814a
            r13.add(r3)
            r14 = r2
            r9 = 0
            goto L_0x00a7
        L_0x00d7:
            r9 = 0
            goto L_0x00df
        L_0x00da:
            ma.r.h()
            r9 = 0
            throw r9
        L_0x00df:
            j3.t0 r2 = new j3.t0
            r3 = 0
            r2.<init>(r3, r6)
            java.util.ArrayList r2 = hb.h0.e1(r4, r2)
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x00f2
        L_0x00f1:
            r6 = r9
        L_0x00f2:
            r2 = r6
            goto L_0x00f5
        L_0x00f4:
            r2 = r9
        L_0x00f5:
            if (r1 == 0) goto L_0x011f
            java.lang.String r3 = r0.f8694a
            if (r3 != 0) goto L_0x00fc
            goto L_0x0122
        L_0x00fc:
            java.util.List r4 = r1.getPathSegments()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.util.List r3 = r3.getPathSegments()
            java.lang.String r5 = "requestedPathSegments"
            xa.j.e(r5, r4)
            java.lang.String r5 = "uriPathSegments"
            xa.j.e(r5, r3)
            java.util.Set r4 = ma.z.M(r4)
            r4.retainAll(r3)
            int r3 = r4.size()
            r4 = r3
            goto L_0x0123
        L_0x011f:
            r0.getClass()
        L_0x0122:
            r4 = 0
        L_0x0123:
            java.lang.Object r3 = r8.f429j
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x0133
            java.lang.String r5 = r0.f8695b
            boolean r3 = xa.j.a(r3, r5)
            if (r3 == 0) goto L_0x0133
            r5 = 1
            goto L_0x0134
        L_0x0133:
            r5 = 0
        L_0x0134:
            java.lang.Object r3 = r8.f430k
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x0289
            java.lang.String r12 = r0.f8696c
            if (r12 == 0) goto L_0x0286
            la.o r13 = r0.f8708o
            java.lang.Object r13 = r13.getValue()
            java.util.regex.Pattern r13 = (java.util.regex.Pattern) r13
            xa.j.c(r13)
            java.util.regex.Matcher r13 = r13.matcher(r3)
            boolean r13 = r13.matches()
            if (r13 != 0) goto L_0x0155
            goto L_0x0286
        L_0x0155:
            fb.l r13 = new fb.l
            java.lang.String r14 = "/"
            r13.<init>(r14)
            r15 = 0
            fb.y.C(r15)
            java.util.regex.Pattern r13 = r13.f6013h
            java.util.regex.Matcher r13 = r13.matcher(r12)
            boolean r15 = r13.find()
            r9 = 10
            if (r15 != 0) goto L_0x0177
            java.lang.String r12 = r12.toString()
            java.util.List r12 = ma.q.b(r12)
            goto L_0x01a6
        L_0x0177:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>(r9)
            r6 = 0
        L_0x017d:
            int r9 = r13.start()
            java.lang.CharSequence r6 = r12.subSequence(r6, r9)
            java.lang.String r6 = r6.toString()
            r15.add(r6)
            int r6 = r13.end()
            boolean r9 = r13.find()
            if (r9 != 0) goto L_0x017d
            int r9 = r12.length()
            java.lang.CharSequence r6 = r12.subSequence(r6, r9)
            java.lang.String r6 = r6.toString()
            r15.add(r6)
            r12 = r15
        L_0x01a6:
            boolean r6 = r12.isEmpty()
            if (r6 != 0) goto L_0x01d6
            int r6 = r12.size()
            java.util.ListIterator r6 = r12.listIterator(r6)
        L_0x01b4:
            boolean r9 = r6.hasPrevious()
            if (r9 == 0) goto L_0x01d6
            java.lang.Object r9 = r6.previous()
            java.lang.String r9 = (java.lang.String) r9
            int r9 = r9.length()
            if (r9 != 0) goto L_0x01c8
            r9 = 1
            goto L_0x01c9
        L_0x01c8:
            r9 = 0
        L_0x01c9:
            if (r9 != 0) goto L_0x01b4
            int r6 = r6.nextIndex()
            r9 = 1
            int r6 = r6 + r9
            java.util.List r6 = ma.z.G(r12, r6)
            goto L_0x01d9
        L_0x01d6:
            r9 = 1
            ma.b0 r6 = ma.b0.f10801h
        L_0x01d9:
            r12 = 0
            java.lang.Object r13 = r6.get(r12)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r6 = r6.get(r9)
            r9 = r6
            java.lang.String r9 = (java.lang.String) r9
            fb.l r6 = new fb.l
            r6.<init>(r14)
            fb.y.C(r12)
            java.util.regex.Pattern r6 = r6.f6013h
            java.util.regex.Matcher r19 = r6.matcher(r3)
            boolean r6 = r19.find()
            if (r6 != 0) goto L_0x0204
            java.lang.String r3 = r3.toString()
            java.util.List r3 = ma.q.b(r3)
            goto L_0x0235
        L_0x0204:
            java.util.ArrayList r6 = new java.util.ArrayList
            r12 = 10
            r6.<init>(r12)
            r12 = 0
        L_0x020c:
            int r14 = r19.start()
            java.lang.CharSequence r12 = r3.subSequence(r12, r14)
            java.lang.String r12 = r12.toString()
            r6.add(r12)
            int r12 = r19.end()
            boolean r14 = r19.find()
            if (r14 != 0) goto L_0x020c
            int r14 = r3.length()
            java.lang.CharSequence r3 = r3.subSequence(r12, r14)
            java.lang.String r3 = r3.toString()
            r6.add(r3)
            r3 = r6
        L_0x0235:
            boolean r6 = r3.isEmpty()
            if (r6 != 0) goto L_0x0265
            int r6 = r3.size()
            java.util.ListIterator r6 = r3.listIterator(r6)
        L_0x0243:
            boolean r12 = r6.hasPrevious()
            if (r12 == 0) goto L_0x0265
            java.lang.Object r12 = r6.previous()
            java.lang.String r12 = (java.lang.String) r12
            int r12 = r12.length()
            if (r12 != 0) goto L_0x0257
            r12 = 1
            goto L_0x0258
        L_0x0257:
            r12 = 0
        L_0x0258:
            if (r12 != 0) goto L_0x0243
            int r6 = r6.nextIndex()
            r12 = 1
            int r6 = r6 + r12
            java.util.List r3 = ma.z.G(r3, r6)
            goto L_0x0268
        L_0x0265:
            r12 = 1
            ma.b0 r3 = ma.b0.f10801h
        L_0x0268:
            r14 = 0
            java.lang.Object r6 = r3.get(r14)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r3 = r3.get(r12)
            java.lang.String r3 = (java.lang.String) r3
            boolean r6 = xa.j.a(r13, r6)
            if (r6 == 0) goto L_0x027d
            r6 = 2
            r14 = 2
        L_0x027d:
            boolean r3 = xa.j.a(r9, r3)
            if (r3 == 0) goto L_0x0287
            int r14 = r14 + 1
            goto L_0x0287
        L_0x0286:
            r14 = -1
        L_0x0287:
            r6 = r14
            goto L_0x028a
        L_0x0289:
            r6 = -1
        L_0x028a:
            if (r2 != 0) goto L_0x02df
            if (r5 != 0) goto L_0x0291
            r3 = -1
            if (r6 <= r3) goto L_0x02f2
        L_0x0291:
            java.util.Map r3 = r22.e()
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            if (r1 != 0) goto L_0x029d
            goto L_0x02cf
        L_0x029d:
            la.o r12 = r0.f8699f
            java.lang.Object r12 = r12.getValue()
            java.util.regex.Pattern r12 = (java.util.regex.Pattern) r12
            if (r12 == 0) goto L_0x02b0
            java.lang.String r13 = r1.toString()
            java.util.regex.Matcher r12 = r12.matcher(r13)
            goto L_0x02b1
        L_0x02b0:
            r12 = 0
        L_0x02b1:
            if (r12 != 0) goto L_0x02b4
            goto L_0x02cf
        L_0x02b4:
            boolean r13 = r12.matches()
            if (r13 != 0) goto L_0x02bb
            goto L_0x02cf
        L_0x02bb:
            r0.b(r12, r9, r3)
            la.o r12 = r0.f8700g
            java.lang.Object r12 = r12.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x02cf
            r0.c(r1, r9, r3)
        L_0x02cf:
            j3.t0 r1 = new j3.t0
            r12 = 1
            r1.<init>(r12, r9)
            java.util.ArrayList r1 = hb.h0.e1(r3, r1)
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x02f2
        L_0x02df:
            j3.b1 r9 = new j3.b1
            boolean r3 = r0.f8709p
            r0 = r9
            r1 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6)
            if (r11 == 0) goto L_0x02f1
            int r0 = r9.compareTo(r11)
            if (r0 <= 0) goto L_0x02f2
        L_0x02f1:
            r11 = r9
        L_0x02f2:
            r9 = 0
            goto L_0x0013
        L_0x02f5:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.c1.f(android.support.v4.media.session.u):j3.b1");
    }

    public void g(Context context, AttributeSet attributeSet) {
        Object obj;
        j.f("context", context);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, a.f9078e);
        j.e("context.resources.obtain…s, R.styleable.Navigator)", obtainAttributes);
        String string = obtainAttributes.getString(2);
        a1 a1Var = f8505q;
        if (string == null) {
            this.f8513o = 0;
            this.f8508j = null;
        } else if (!w.h(string)) {
            a1Var.getClass();
            String a10 = a1.a(string);
            this.f8513o = a10.hashCode();
            this.f8508j = null;
            p0 p0Var = new p0();
            p0Var.f8651a = a10;
            a(new u0(p0Var.f8651a, p0Var.f8652b, p0Var.f8653c));
        } else {
            throw new IllegalArgumentException("Cannot have an empty route".toString());
        }
        ArrayList arrayList = this.f8510l;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            String str = ((u0) obj).f8694a;
            String str2 = this.f8514p;
            a1Var.getClass();
            if (j.a(str, a1.a(str2))) {
                break;
            }
        }
        y.a(arrayList);
        arrayList.remove(obj);
        this.f8514p = string;
        if (obtainAttributes.hasValue(1)) {
            int resourceId = obtainAttributes.getResourceId(1, 0);
            this.f8513o = resourceId;
            this.f8508j = null;
            a1Var.getClass();
            this.f8508j = a1.b(context, resourceId);
        }
        this.f8509k = obtainAttributes.getText(0);
        v vVar = v.f9814a;
        obtainAttributes.recycle();
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        Set<String> keySet;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = this.f8513o * 31;
        String str = this.f8514p;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i19 = i18 + i10;
        Iterator it = this.f8510l.iterator();
        while (it.hasNext()) {
            u0 u0Var = (u0) it.next();
            int i20 = i11 * 31;
            String str2 = u0Var.f8694a;
            if (str2 != null) {
                i15 = str2.hashCode();
            } else {
                i15 = 0;
            }
            int i21 = (i20 + i15) * 31;
            String str3 = u0Var.f8695b;
            if (str3 != null) {
                i16 = str3.hashCode();
            } else {
                i16 = 0;
            }
            int i22 = (i21 + i16) * 31;
            String str4 = u0Var.f8696c;
            if (str4 != null) {
                i17 = str4.hashCode();
            } else {
                i17 = 0;
            }
            i19 = i22 + i17;
        }
        m a22 = h0.a2(this.f8511m);
        while (a22.hasNext()) {
            h hVar = (h) a22.next();
            int i23 = ((i11 * 31) + hVar.f8552a) * 31;
            n1 n1Var = hVar.f8553b;
            if (n1Var != null) {
                i13 = n1Var.hashCode();
            } else {
                i13 = 0;
            }
            i11 = i23 + i13;
            Bundle bundle = hVar.f8554c;
            if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
                for (String str5 : keySet) {
                    int i24 = i11 * 31;
                    Bundle bundle2 = hVar.f8554c;
                    j.c(bundle2);
                    Object obj = bundle2.get(str5);
                    if (obj != null) {
                        i14 = obj.hashCode();
                    } else {
                        i14 = 0;
                    }
                    i11 = i24 + i14;
                }
            }
        }
        for (String str6 : e().keySet()) {
            int e10 = h.e(str6, i11 * 31, 31);
            Object obj2 = e().get(str6);
            if (obj2 != null) {
                i12 = obj2.hashCode();
            } else {
                i12 = 0;
            }
            i11 = e10 + i12;
        }
        return i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("(");
        String str = this.f8508j;
        if (str == null) {
            sb2.append("0x");
            str = Integer.toHexString(this.f8513o);
        }
        sb2.append(str);
        sb2.append(")");
        String str2 = this.f8514p;
        if (!(str2 == null || w.h(str2))) {
            sb2.append(" route=");
            sb2.append(this.f8514p);
        }
        if (this.f8509k != null) {
            sb2.append(" label=");
            sb2.append(this.f8509k);
        }
        String sb3 = sb2.toString();
        j.e("sb.toString()", sb3);
        return sb3;
    }
}
