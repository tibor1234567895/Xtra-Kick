package n3;

import androidx.fragment.app.p0;
import hb.f0;
import hb.h0;
import hb.l1;
import hb.o1;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import jb.c;
import kb.i;
import kb.o0;
import kb.v;
import la.g;
import ma.r;
import ma.z;
import pa.e;
import pa.h;
import wa.a;
import xa.j;

public final class g3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f11194a;

    /* renamed from: b  reason: collision with root package name */
    public final n4 f11195b;

    /* renamed from: c  reason: collision with root package name */
    public final r3 f11196c;

    /* renamed from: d  reason: collision with root package name */
    public final i f11197d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f11198e;

    /* renamed from: f  reason: collision with root package name */
    public final d5 f11199f;

    /* renamed from: g  reason: collision with root package name */
    public final o4 f11200g;

    /* renamed from: h  reason: collision with root package name */
    public final a f11201h;

    /* renamed from: i  reason: collision with root package name */
    public final v0 f11202i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicBoolean f11203j;

    /* renamed from: k  reason: collision with root package name */
    public final c f11204k;

    /* renamed from: l  reason: collision with root package name */
    public final h3 f11205l;

    /* renamed from: m  reason: collision with root package name */
    public final o1 f11206m;

    /* renamed from: n  reason: collision with root package name */
    public final v f11207n;

    public g3(Object obj, n4 n4Var, r3 r3Var, p0 p0Var, boolean z10, d5 d5Var, o4 o4Var, w1 w1Var) {
        boolean z11;
        j.f("pagingSource", n4Var);
        j.f("config", r3Var);
        j.f("retryFlow", p0Var);
        this.f11194a = obj;
        this.f11195b = n4Var;
        this.f11196c = r3Var;
        this.f11197d = p0Var;
        this.f11198e = z10;
        this.f11199f = d5Var;
        this.f11200g = o4Var;
        this.f11201h = w1Var;
        if (r3Var.f11463f != Integer.MIN_VALUE) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            this.f11202i = new v0();
            this.f11203j = new AtomicBoolean(false);
            this.f11204k = h0.a(-2, (jb.a) null, 6);
            this.f11205l = new h3(r3Var);
            o1 o1Var = new o1((l1) null);
            this.f11206m = o1Var;
            this.f11207n = new v(new z2(this, (e) null), h0.G1(new x(o1Var, new y2(this, (e) null), (e) null)));
            return;
        }
        throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.".toString());
    }

    public static final Object a(g3 g3Var, v vVar, d1 d1Var, e eVar) {
        g3Var.getClass();
        i a10 = q0.a(vVar, new l2(d1Var, g3Var, (e) null));
        t tVar = new t((Object) d1Var, (e) null, 1);
        j.f("<this>", a10);
        Object b10 = h0.p(new o0(new k0(a10, tVar, (e) null)), -1).b(new k2(g3Var, 0, d1Var), eVar);
        if (b10 == qa.a.COROUTINE_SUSPENDED) {
            return b10;
        }
        return la.v.f9814a;
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: ob.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: n3.k4} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: ob.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: ob.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: ob.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v12, resolved type: ob.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v32, resolved type: ob.d} */
    /* JADX WARNING: type inference failed for: r0v74, types: [ob.a] */
    /* JADX WARNING: type inference failed for: r0v76, types: [ob.a] */
    /* JADX WARNING: type inference failed for: r1v86, types: [ob.a] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x036f, code lost:
        throw new java.lang.IllegalArgumentException("Use doInitialLoad for LoadType == REFRESH");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0370, code lost:
        r1 = ((n3.k4) r5).f11288b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0375, code lost:
        r13.f11195b.getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0382, code lost:
        if ((!xa.j.a(r1, r10.f16818h)) != false) goto L_0x03b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0384, code lost:
        if (r14 != r7) goto L_0x0389;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0386, code lost:
        r0 = "prevKey";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0389, code lost:
        r0 = "nextKey";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x03b5, code lost:
        throw new java.lang.IllegalStateException(fb.p.b("The same value, " + r10.f16818h + ", was passed as the " + r0 + " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            ").toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03b6, code lost:
        r1 = r13.f11205l;
        r2 = r1.f11229a;
        r3.f11428h = r13;
        r3.f11429i = r14;
        r3.f11430j = r0;
        r3.f11431k = r11;
        r3.f11432l = r10;
        r3.f11433m = r9;
        r3.f11434n = r8;
        r3.f11435o = r5;
        r3.f11436p = r1;
        r3.f11437q = r2;
        r3.f11443w = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x03d5, code lost:
        if (r2.e(r3) != r4) goto L_0x03d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x03d9, code lost:
        r15 = r13;
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r17 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x03ee, code lost:
        if (r1.f11230b.e(r13.f11451a, r14, (n3.k4) r5) != false) goto L_0x03f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x03f2, code lost:
        r1 = (n3.k4) r5;
        r11.f16816h = r1.f11287a.size() + r11.f16816h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0400, code lost:
        if (r14 != r7) goto L_0x0409;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0404, code lost:
        if (r1.f11288b == null) goto L_0x0407;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0409, code lost:
        if (r14 != r6) goto L_0x0413;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x040d, code lost:
        if (r1.f11289c != null) goto L_0x0413;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0410, code lost:
        r9.f16814h = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0414, code lost:
        r3 = r17;
        r0 = r13;
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x041a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x041b, code lost:
        r2.f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0421, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0425, code lost:
        if ((r5 instanceof n3.h4) == false) goto L_0x048d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0427, code lost:
        r1 = r13.f11205l;
        r2 = r1.f11229a;
        r3.f11428h = r13;
        r3.f11429i = r14;
        r3.f11430j = r0;
        r3.f11431k = r5;
        r3.f11432l = r1;
        r3.f11433m = r2;
        r3.f11434n = null;
        r3.f11443w = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0441, code lost:
        if (r2.e(r3) != r4) goto L_0x0445;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0445, code lost:
        r8 = r13;
        r16 = r4;
        r4 = r0;
        r0 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r1 = r1.f11230b;
        r6 = new n3.w0(((n3.h4) r5).f11231a);
        r3.f11428h = r14;
        r3.f11429i = r4;
        r3.f11430j = r2;
        r3.f11431k = r1;
        r3.f11432l = null;
        r3.f11433m = null;
        r3.f11443w = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x046a, code lost:
        if (r8.i(r1, r14, r6, r3) != r0) goto L_0x046f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x046f, code lost:
        r0 = r1;
        r1 = r2;
        r3 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0472, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        r0.f11318k.put(r3, r4.f11452b);
        r0 = la.v.f9814a;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x047b, code lost:
        r1.f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0485, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0486, code lost:
        r2.f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x048c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0490, code lost:
        if ((r5 instanceof n3.i4) == false) goto L_0x04a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0492, code lost:
        r13.f11206m.e((java.util.concurrent.CancellationException) null);
        r13.f11195b.f11359a.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x04a9, code lost:
        if (n3.j2.f11265a[r14.ordinal()] != 2) goto L_0x04ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x04ab, code lost:
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x04ad, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x04ae, code lost:
        r1 = r13.f11205l;
        r15 = r1.f11229a;
        r3.f11428h = r13;
        r3.f11429i = r14;
        r3.f11430j = r0;
        r3.f11431k = r11;
        r3.f11432l = r10;
        r3.f11433m = r9;
        r3.f11434n = r8;
        r3.f11435o = r5;
        r3.f11436p = r2;
        r3.f11437q = r1;
        r3.f11438r = r15;
        r17 = r0;
        r3.f11443w = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x04d2, code lost:
        if (r15.e(r3) != r4) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x04d6, code lost:
        r0 = r14;
        r14 = r17;
        r16 = r5;
        r5 = r2;
        r2 = r13;
        r13 = r11;
        r11 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:?, code lost:
        r1 = r1.f11230b;
        r17 = r6;
        r5 = r1.c(r5, r14.f11452b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x04ed, code lost:
        if (r5 != null) goto L_0x04f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x04ef, code lost:
        r6 = r17;
        r5 = r8;
        r8 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x04f4, code lost:
        r1.b(r5);
        r6 = r2.f11204k;
        r3.f11428h = r2;
        r3.f11429i = r0;
        r3.f11430j = r14;
        r3.f11431k = r13;
        r3.f11432l = r11;
        r3.f11433m = r10;
        r3.f11434n = r9;
        r3.f11435o = r8;
        r3.f11436p = r15;
        r3.f11437q = r1;
        r18 = r1;
        r3.f11438r = null;
        r3.f11443w = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x051a, code lost:
        if (r6.g(r5, r3) != r4) goto L_0x051e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x051e, code lost:
        r6 = r17;
        r5 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r13;
        r13 = r14;
        r1 = r15;
        r14 = r0;
        r15 = r2;
        r0 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:?, code lost:
        r2 = la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x052d, code lost:
        r2 = r15;
        r15 = r1;
        r1 = r0;
        r0 = r14;
        r14 = r13;
        r13 = r11;
        r11 = r10;
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        r17 = r6;
        r18 = r7;
        r6 = r2.h(r1, r0, r14.f11451a, r14.f11452b.a(r0) + r13.f16816h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0548, code lost:
        r7 = r1.f11319l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
        r11.f16818h = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x054c, code lost:
        if (r6 != null) goto L_0x056c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0554, code lost:
        if ((r7.a(r0) instanceof n3.w0) != false) goto L_0x056c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0558, code lost:
        if (r10.f16814h == false) goto L_0x0562;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x055a, code lost:
        n3.z0.f11599b.getClass();
        r6 = n3.z0.f11600c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0562, code lost:
        n3.z0.f11599b.getClass();
        r6 = n3.z0.f11601d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0569, code lost:
        r7.c(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x056c, code lost:
        r1 = r1.f((n3.k4) r5, r0);
        r6 = r2.f11204k;
        r3.f11428h = r2;
        r3.f11429i = r0;
        r3.f11430j = r14;
        r3.f11431k = r13;
        r3.f11432l = r11;
        r3.f11433m = r10;
        r3.f11434n = r8;
        r3.f11435o = r5;
        r3.f11436p = r15;
        r3.f11437q = null;
        r3.f11438r = null;
        r3.f11443w = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0594, code lost:
        if (r6.g(r1, r3) != r4) goto L_0x0598;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0598, code lost:
        r6 = r17;
        r7 = r18;
        r9 = r13;
        r1 = r15;
        r15 = r11;
        r11 = r14;
        r14 = r10;
        r10 = r2;
        r16 = r8;
        r8 = r0;
        r0 = r5;
        r5 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:?, code lost:
        r2 = la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x05aa, code lost:
        ((ob.d) r1).f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x05b2, code lost:
        if ((r5 instanceof n3.e4) == false) goto L_0x05bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x05b9, code lost:
        if (((n3.k4) r0).f11288b != null) goto L_0x05bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x05bb, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00bd, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x05bd, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x05c0, code lost:
        if ((r5 instanceof n3.c4) == false) goto L_0x05ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x05c6, code lost:
        if (((n3.k4) r0).f11289c != null) goto L_0x05ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x05c8, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x05ca, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x05cd, code lost:
        if (r10.f11199f == null) goto L_0x061e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x05cf, code lost:
        if (r1 != 0) goto L_0x05d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x05d1, code lost:
        if (r0 == 0) goto L_0x061e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x05d3, code lost:
        r13 = r10.f11205l;
        r5 = r13.f11229a;
        r3.f11428h = r10;
        r3.f11429i = r8;
        r3.f11430j = r11;
        r3.f11431k = r9;
        r3.f11432l = r15;
        r3.f11433m = r14;
        r3.f11434n = r13;
        r3.f11435o = r5;
        r3.f11436p = null;
        r3.f11439s = r1;
        r3.f11440t = r0;
        r3.f11443w = 11;
        r2 = r5.e(r3);
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x05f6, code lost:
        if (r2 != r4) goto L_0x05f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:?, code lost:
        r2 = r13.f11230b.a((n3.y5) r10.f11202i.f11516a.f8716c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0607, code lost:
        ((ob.d) r5).f((java.lang.Object) null);
        r5 = r10.f11199f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x060f, code lost:
        if (r1 == 0) goto L_0x0617;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0611, code lost:
        ((n3.c5) r5).b(r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0617, code lost:
        if (r0 == 0) goto L_0x061e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0619, code lost:
        ((n3.c5) r5).b(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x061e, code lost:
        r13 = r10;
        r10 = r11;
        r0 = r14;
        r11 = r8;
        r8 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0625, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0626, code lost:
        ((ob.d) r5).f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x062c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x062d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x062e, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x062f, code lost:
        ((ob.d) r1).f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0635, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0639, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x063a, code lost:
        r5 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x063b, code lost:
        ((ob.d) r5).f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0641, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0647, code lost:
        throw new java.lang.IllegalStateException("Use doInitialLoad for LoadType == REFRESH");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0648, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0649, code lost:
        ((ob.d) r2).f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x064f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:?, code lost:
        return la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01f0, code lost:
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r5 = r5.f11230b;
        r10 = r1.ordinal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x022d, code lost:
        if (r10 == 0) goto L_0x0642;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0230, code lost:
        if (r10 == 1) goto L_0x026f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0233, code lost:
        if (r10 == 2) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0237, code lost:
        r10 = (r5.f11311d + r8.f11452b.f11054d) + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0240, code lost:
        if (r10 >= 0) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0242, code lost:
        r9.f16816h = (r0.f11196c.f11458a * (-r10)) + r9.f16816h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x024e, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x024f, code lost:
        r5 = r5.f11310c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r11 = ma.r.d(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0255, code lost:
        if (r10 > r11) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0257, code lost:
        r13 = r10 + 1;
        r9.f16816h += ((n3.k4) r5.get(r10)).f11287a.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x026a, code lost:
        if (r10 != r11) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x026d, code lost:
        r10 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0275, code lost:
        r10 = (r5.f11311d + r8.f11452b.f11053c) - 1;
        r5 = r5.f11310c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x027e, code lost:
        if (r10 <= ma.r.d(r5)) goto L_0x0294;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0280, code lost:
        r9.f16816h = ((r10 - ma.r.d(r5)) * r0.f11196c.f11458a) + r9.f16816h;
        r10 = ma.r.d(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0294, code lost:
        if (r10 < 0) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0296, code lost:
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0297, code lost:
        r13 = r11 + 1;
        r9.f16816h += ((n3.k4) r5.get(r11)).f11287a.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02aa, code lost:
        if (r11 != r10) goto L_0x02ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x02ad, code lost:
        r11 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02af, code lost:
        r5 = la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02b1, code lost:
        ((ob.d) r2).f((java.lang.Object) null);
        r2 = new xa.u();
        r5 = r0.f11205l;
        r10 = r5.f11229a;
        r3.f11428h = r0;
        r3.f11429i = r1;
        r3.f11430j = r8;
        r3.f11431k = r9;
        r3.f11432l = r2;
        r3.f11433m = r5;
        r3.f11434n = r10;
        r3.f11435o = r2;
        r3.f11443w = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02d7, code lost:
        if (r10.e(r3) != r4) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02db, code lost:
        r13 = r0;
        r11 = r1;
        r0 = r2;
        r1 = r10;
        r10 = r8;
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r2 = r5.f11230b;
        r5 = r13.h(r2, r11, r10.f11451a, r10.f11452b.a(r11) + r9.f16816h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02f2, code lost:
        if (r5 != null) goto L_0x02f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02f4, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02f6, code lost:
        r3.f11428h = r13;
        r3.f11429i = r11;
        r3.f11430j = r10;
        r3.f11431k = r9;
        r3.f11432l = r8;
        r3.f11433m = r1;
        r3.f11434n = r5;
        r3.f11435o = r0;
        r3.f11443w = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x030d, code lost:
        if (r13.j(r2, r11, r3) != r4) goto L_0x0311;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0311, code lost:
        r16 = r5;
        r5 = r1;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0316, code lost:
        r2 = r1;
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0318, code lost:
        ((ob.d) r1).f((java.lang.Object) null);
        r0.f16818h = r2;
        r0 = new xa.q();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0325, code lost:
        r1 = r8.f16818h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0327, code lost:
        if (r1 == null) goto L_0x0636;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0329, code lost:
        r1 = r13.g(r11, r1);
        r3.f11428h = r13;
        r3.f11429i = r11;
        r3.f11430j = r10;
        r3.f11431k = r9;
        r3.f11432l = r8;
        r3.f11433m = r0;
        r3.f11434n = r1;
        r3.f11435o = null;
        r3.f11436p = null;
        r3.f11443w = 4;
        r2 = r13.f11195b.b(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0349, code lost:
        if (r2 != r4) goto L_0x034d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x034d, code lost:
        r14 = r11;
        r11 = r9;
        r9 = r0;
        r0 = r10;
        r10 = r8;
        r8 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0353, code lost:
        r5 = (n3.l4) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0358, code lost:
        if ((r5 instanceof n3.k4) == false) goto L_0x0422;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x035a, code lost:
        r1 = r14.ordinal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x035f, code lost:
        if (r1 == 1) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0362, code lost:
        if (r1 != 2) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0364, code lost:
        r1 = ((n3.k4) r5).f11289c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(n3.g3 r17, n3.d1 r18, n3.r0 r19, pa.e r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r20
            r17.getClass()
            boolean r3 = r2 instanceof n3.q2
            if (r3 == 0) goto L_0x001c
            r3 = r2
            n3.q2 r3 = (n3.q2) r3
            int r4 = r3.f11443w
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x001c
            int r4 = r4 - r5
            r3.f11443w = r4
            goto L_0x0021
        L_0x001c:
            n3.q2 r3 = new n3.q2
            r3.<init>(r0, r2)
        L_0x0021:
            java.lang.Object r2 = r3.f11441u
            qa.a r4 = qa.a.COROUTINE_SUSPENDED
            int r5 = r3.f11443w
            n3.d1 r6 = n3.d1.APPEND
            n3.d1 r7 = n3.d1.PREPEND
            java.lang.String r12 = "Use doInitialLoad for LoadType == REFRESH"
            switch(r5) {
                case 0: goto L_0x01f3;
                case 1: goto L_0x01cf;
                case 2: goto L_0x01aa;
                case 3: goto L_0x0184;
                case 4: goto L_0x015c;
                case 5: goto L_0x012e;
                case 6: goto L_0x010d;
                case 7: goto L_0x00f5;
                case 8: goto L_0x00c0;
                case 9: goto L_0x0090;
                case 10: goto L_0x0061;
                case 11: goto L_0x0038;
                default: goto L_0x0030;
            }
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            int r0 = r3.f11440t
            int r1 = r3.f11439s
            java.lang.Object r5 = r3.f11435o
            ob.a r5 = (ob.a) r5
            java.lang.Object r13 = r3.f11434n
            n3.h3 r13 = (n3.h3) r13
            java.lang.Object r14 = r3.f11433m
            xa.q r14 = (xa.q) r14
            java.lang.Object r15 = r3.f11432l
            xa.u r15 = (xa.u) r15
            java.lang.Object r9 = r3.f11431k
            xa.s r9 = (xa.s) r9
            java.lang.Object r11 = r3.f11430j
            n3.r0 r11 = (n3.r0) r11
            java.lang.Object r8 = r3.f11429i
            n3.d1 r8 = (n3.d1) r8
            java.lang.Object r10 = r3.f11428h
            n3.g3 r10 = (n3.g3) r10
            hb.h0.O1(r2)
            goto L_0x05f9
        L_0x0061:
            java.lang.Object r0 = r3.f11436p
            r1 = r0
            ob.a r1 = (ob.a) r1
            java.lang.Object r0 = r3.f11435o
            n3.l4 r0 = (n3.l4) r0
            java.lang.Object r5 = r3.f11434n
            n3.g4 r5 = (n3.g4) r5
            java.lang.Object r8 = r3.f11433m
            xa.q r8 = (xa.q) r8
            java.lang.Object r9 = r3.f11432l
            xa.u r9 = (xa.u) r9
            java.lang.Object r10 = r3.f11431k
            xa.s r10 = (xa.s) r10
            java.lang.Object r11 = r3.f11430j
            n3.r0 r11 = (n3.r0) r11
            java.lang.Object r13 = r3.f11429i
            n3.d1 r13 = (n3.d1) r13
            java.lang.Object r14 = r3.f11428h
            n3.g3 r14 = (n3.g3) r14
            hb.h0.O1(r2)     // Catch:{ all -> 0x00bd }
            r15 = r9
            r9 = r10
            r10 = r14
            r14 = r8
            r8 = r13
            goto L_0x05a8
        L_0x0090:
            java.lang.Object r0 = r3.f11437q
            n3.l3 r0 = (n3.l3) r0
            java.lang.Object r1 = r3.f11436p
            ob.a r1 = (ob.a) r1
            java.lang.Object r5 = r3.f11435o
            n3.l4 r5 = (n3.l4) r5
            java.lang.Object r8 = r3.f11434n
            n3.g4 r8 = (n3.g4) r8
            java.lang.Object r9 = r3.f11433m
            xa.q r9 = (xa.q) r9
            java.lang.Object r10 = r3.f11432l
            xa.u r10 = (xa.u) r10
            java.lang.Object r11 = r3.f11431k
            xa.s r11 = (xa.s) r11
            java.lang.Object r13 = r3.f11430j
            n3.r0 r13 = (n3.r0) r13
            java.lang.Object r14 = r3.f11429i
            n3.d1 r14 = (n3.d1) r14
            java.lang.Object r15 = r3.f11428h
            n3.g3 r15 = (n3.g3) r15
            hb.h0.O1(r2)     // Catch:{ all -> 0x00bd }
            goto L_0x052b
        L_0x00bd:
            r0 = move-exception
            goto L_0x062f
        L_0x00c0:
            ob.d r0 = r3.f11438r
            java.lang.Object r1 = r3.f11437q
            n3.h3 r1 = (n3.h3) r1
            java.lang.Object r5 = r3.f11436p
            n3.d1 r5 = (n3.d1) r5
            java.lang.Object r8 = r3.f11435o
            n3.l4 r8 = (n3.l4) r8
            java.lang.Object r9 = r3.f11434n
            n3.g4 r9 = (n3.g4) r9
            java.lang.Object r10 = r3.f11433m
            xa.q r10 = (xa.q) r10
            java.lang.Object r11 = r3.f11432l
            xa.u r11 = (xa.u) r11
            java.lang.Object r13 = r3.f11431k
            xa.s r13 = (xa.s) r13
            java.lang.Object r14 = r3.f11430j
            n3.r0 r14 = (n3.r0) r14
            java.lang.Object r15 = r3.f11429i
            n3.d1 r15 = (n3.d1) r15
            r17 = r0
            java.lang.Object r0 = r3.f11428h
            n3.g3 r0 = (n3.g3) r0
            hb.h0.O1(r2)
            r2 = r0
            r0 = r15
            r15 = r17
            goto L_0x04e3
        L_0x00f5:
            java.lang.Object r0 = r3.f11431k
            n3.l3 r0 = (n3.l3) r0
            java.lang.Object r1 = r3.f11430j
            ob.a r1 = (ob.a) r1
            java.lang.Object r4 = r3.f11429i
            n3.r0 r4 = (n3.r0) r4
            java.lang.Object r3 = r3.f11428h
            n3.d1 r3 = (n3.d1) r3
            hb.h0.O1(r2)     // Catch:{ all -> 0x010a }
            goto L_0x0472
        L_0x010a:
            r0 = move-exception
            goto L_0x0483
        L_0x010d:
            java.lang.Object r0 = r3.f11433m
            ob.a r0 = (ob.a) r0
            java.lang.Object r1 = r3.f11432l
            n3.h3 r1 = (n3.h3) r1
            java.lang.Object r5 = r3.f11431k
            n3.l4 r5 = (n3.l4) r5
            java.lang.Object r6 = r3.f11430j
            n3.r0 r6 = (n3.r0) r6
            java.lang.Object r7 = r3.f11429i
            n3.d1 r7 = (n3.d1) r7
            java.lang.Object r8 = r3.f11428h
            n3.g3 r8 = (n3.g3) r8
            hb.h0.O1(r2)
            r2 = r0
            r0 = r4
            r4 = r6
            r14 = r7
            goto L_0x044b
        L_0x012e:
            java.lang.Object r0 = r3.f11437q
            ob.a r0 = (ob.a) r0
            java.lang.Object r1 = r3.f11436p
            n3.h3 r1 = (n3.h3) r1
            java.lang.Object r5 = r3.f11435o
            n3.l4 r5 = (n3.l4) r5
            java.lang.Object r8 = r3.f11434n
            n3.g4 r8 = (n3.g4) r8
            java.lang.Object r9 = r3.f11433m
            xa.q r9 = (xa.q) r9
            java.lang.Object r10 = r3.f11432l
            xa.u r10 = (xa.u) r10
            java.lang.Object r11 = r3.f11431k
            xa.s r11 = (xa.s) r11
            java.lang.Object r13 = r3.f11430j
            n3.r0 r13 = (n3.r0) r13
            java.lang.Object r14 = r3.f11429i
            n3.d1 r14 = (n3.d1) r14
            java.lang.Object r15 = r3.f11428h
            n3.g3 r15 = (n3.g3) r15
            hb.h0.O1(r2)
            r2 = r0
            goto L_0x03db
        L_0x015c:
            java.lang.Object r0 = r3.f11434n
            n3.g4 r0 = (n3.g4) r0
            java.lang.Object r1 = r3.f11433m
            xa.q r1 = (xa.q) r1
            java.lang.Object r5 = r3.f11432l
            xa.u r5 = (xa.u) r5
            java.lang.Object r8 = r3.f11431k
            xa.s r8 = (xa.s) r8
            java.lang.Object r9 = r3.f11430j
            n3.r0 r9 = (n3.r0) r9
            java.lang.Object r10 = r3.f11429i
            n3.d1 r10 = (n3.d1) r10
            java.lang.Object r11 = r3.f11428h
            n3.g3 r11 = (n3.g3) r11
            hb.h0.O1(r2)
            r14 = r10
            r13 = r11
            r10 = r5
            r11 = r8
            r8 = r0
            r0 = r9
            r9 = r1
            goto L_0x0353
        L_0x0184:
            java.lang.Object r0 = r3.f11435o
            xa.u r0 = (xa.u) r0
            java.lang.Object r1 = r3.f11434n
            java.lang.Object r5 = r3.f11433m
            ob.a r5 = (ob.a) r5
            java.lang.Object r8 = r3.f11432l
            xa.u r8 = (xa.u) r8
            java.lang.Object r9 = r3.f11431k
            xa.s r9 = (xa.s) r9
            java.lang.Object r10 = r3.f11430j
            n3.r0 r10 = (n3.r0) r10
            java.lang.Object r11 = r3.f11429i
            n3.d1 r11 = (n3.d1) r11
            java.lang.Object r13 = r3.f11428h
            n3.g3 r13 = (n3.g3) r13
            hb.h0.O1(r2)     // Catch:{ all -> 0x01a7 }
            goto L_0x0316
        L_0x01a7:
            r0 = move-exception
            goto L_0x063b
        L_0x01aa:
            java.lang.Object r0 = r3.f11435o
            xa.u r0 = (xa.u) r0
            java.lang.Object r1 = r3.f11434n
            ob.a r1 = (ob.a) r1
            java.lang.Object r5 = r3.f11433m
            n3.h3 r5 = (n3.h3) r5
            java.lang.Object r8 = r3.f11432l
            xa.u r8 = (xa.u) r8
            java.lang.Object r9 = r3.f11431k
            xa.s r9 = (xa.s) r9
            java.lang.Object r10 = r3.f11430j
            n3.r0 r10 = (n3.r0) r10
            java.lang.Object r11 = r3.f11429i
            n3.d1 r11 = (n3.d1) r11
            java.lang.Object r13 = r3.f11428h
            n3.g3 r13 = (n3.g3) r13
            hb.h0.O1(r2)
            goto L_0x02e1
        L_0x01cf:
            java.lang.Object r0 = r3.f11433m
            ob.a r0 = (ob.a) r0
            java.lang.Object r1 = r3.f11432l
            n3.h3 r1 = (n3.h3) r1
            java.lang.Object r5 = r3.f11431k
            xa.s r5 = (xa.s) r5
            java.lang.Object r8 = r3.f11430j
            n3.r0 r8 = (n3.r0) r8
            java.lang.Object r9 = r3.f11429i
            n3.d1 r9 = (n3.d1) r9
            java.lang.Object r10 = r3.f11428h
            n3.g3 r10 = (n3.g3) r10
            hb.h0.O1(r2)
            r2 = r0
            r0 = r10
            r16 = r5
            r5 = r1
            r1 = r9
        L_0x01f0:
            r9 = r16
            goto L_0x0227
        L_0x01f3:
            hb.h0.O1(r2)
            n3.d1 r2 = n3.d1.REFRESH
            if (r1 == r2) goto L_0x01fc
            r2 = 1
            goto L_0x01fd
        L_0x01fc:
            r2 = 0
        L_0x01fd:
            if (r2 == 0) goto L_0x0650
            xa.s r5 = new xa.s
            r5.<init>()
            n3.h3 r2 = r0.f11205l
            ob.d r8 = r2.f11229a
            r3.f11428h = r0
            r3.f11429i = r1
            r9 = r19
            r3.f11430j = r9
            r3.f11431k = r5
            r3.f11432l = r2
            r3.f11433m = r8
            r10 = 1
            r3.f11443w = r10
            java.lang.Object r10 = r8.e(r3)
            if (r10 != r4) goto L_0x0221
            goto L_0x0638
        L_0x0221:
            r16 = r5
            r5 = r2
            r2 = r8
            r8 = r9
            goto L_0x01f0
        L_0x0227:
            n3.l3 r5 = r5.f11230b     // Catch:{ all -> 0x0648 }
            int r10 = r1.ordinal()     // Catch:{ all -> 0x0648 }
            if (r10 == 0) goto L_0x0642
            r11 = 1
            if (r10 == r11) goto L_0x026f
            r11 = 2
            if (r10 == r11) goto L_0x0237
            goto L_0x02af
        L_0x0237:
            int r10 = r5.f11311d     // Catch:{ all -> 0x0648 }
            n3.a6 r11 = r8.f11452b     // Catch:{ all -> 0x0648 }
            int r11 = r11.f11054d     // Catch:{ all -> 0x0648 }
            int r10 = r10 + r11
            r11 = 1
            int r10 = r10 + r11
            if (r10 >= 0) goto L_0x024f
            int r11 = r9.f16816h     // Catch:{ all -> 0x0648 }
            n3.r3 r13 = r0.f11196c     // Catch:{ all -> 0x0648 }
            int r13 = r13.f11458a     // Catch:{ all -> 0x0648 }
            int r10 = -r10
            int r13 = r13 * r10
            int r13 = r13 + r11
            r9.f16816h = r13     // Catch:{ all -> 0x0648 }
            r10 = 0
        L_0x024f:
            java.util.ArrayList r5 = r5.f11310c
            int r11 = ma.r.d(r5)     // Catch:{ all -> 0x0648 }
            if (r10 > r11) goto L_0x02af
        L_0x0257:
            int r13 = r10 + 1
            int r14 = r9.f16816h     // Catch:{ all -> 0x0648 }
            java.lang.Object r15 = r5.get(r10)     // Catch:{ all -> 0x0648 }
            n3.k4 r15 = (n3.k4) r15     // Catch:{ all -> 0x0648 }
            java.util.List r15 = r15.f11287a     // Catch:{ all -> 0x0648 }
            int r15 = r15.size()     // Catch:{ all -> 0x0648 }
            int r14 = r14 + r15
            r9.f16816h = r14     // Catch:{ all -> 0x0648 }
            if (r10 != r11) goto L_0x026d
            goto L_0x02af
        L_0x026d:
            r10 = r13
            goto L_0x0257
        L_0x026f:
            int r10 = r5.f11311d     // Catch:{ all -> 0x0648 }
            n3.a6 r11 = r8.f11452b     // Catch:{ all -> 0x0648 }
            int r11 = r11.f11053c     // Catch:{ all -> 0x0648 }
            int r10 = r10 + r11
            r11 = 1
            int r10 = r10 - r11
            java.util.ArrayList r5 = r5.f11310c
            int r11 = ma.r.d(r5)     // Catch:{ all -> 0x0648 }
            if (r10 <= r11) goto L_0x0294
            int r11 = r9.f16816h     // Catch:{ all -> 0x0648 }
            n3.r3 r13 = r0.f11196c     // Catch:{ all -> 0x0648 }
            int r13 = r13.f11458a     // Catch:{ all -> 0x0648 }
            int r14 = ma.r.d(r5)     // Catch:{ all -> 0x0648 }
            int r10 = r10 - r14
            int r10 = r10 * r13
            int r10 = r10 + r11
            r9.f16816h = r10     // Catch:{ all -> 0x0648 }
            int r10 = ma.r.d(r5)     // Catch:{ all -> 0x0648 }
        L_0x0294:
            if (r10 < 0) goto L_0x02af
            r11 = 0
        L_0x0297:
            int r13 = r11 + 1
            int r14 = r9.f16816h     // Catch:{ all -> 0x0648 }
            java.lang.Object r15 = r5.get(r11)     // Catch:{ all -> 0x0648 }
            n3.k4 r15 = (n3.k4) r15     // Catch:{ all -> 0x0648 }
            java.util.List r15 = r15.f11287a     // Catch:{ all -> 0x0648 }
            int r15 = r15.size()     // Catch:{ all -> 0x0648 }
            int r14 = r14 + r15
            r9.f16816h = r14     // Catch:{ all -> 0x0648 }
            if (r11 != r10) goto L_0x02ad
            goto L_0x02af
        L_0x02ad:
            r11 = r13
            goto L_0x0297
        L_0x02af:
            la.v r5 = la.v.f9814a     // Catch:{ all -> 0x0648 }
            ob.d r2 = (ob.d) r2
            r5 = 0
            r2.f(r5)
            xa.u r2 = new xa.u
            r2.<init>()
            n3.h3 r5 = r0.f11205l
            ob.d r10 = r5.f11229a
            r3.f11428h = r0
            r3.f11429i = r1
            r3.f11430j = r8
            r3.f11431k = r9
            r3.f11432l = r2
            r3.f11433m = r5
            r3.f11434n = r10
            r3.f11435o = r2
            r11 = 2
            r3.f11443w = r11
            java.lang.Object r11 = r10.e(r3)
            if (r11 != r4) goto L_0x02db
            goto L_0x0638
        L_0x02db:
            r13 = r0
            r11 = r1
            r0 = r2
            r1 = r10
            r10 = r8
            r8 = r0
        L_0x02e1:
            n3.l3 r2 = r5.f11230b     // Catch:{ all -> 0x0639 }
            int r5 = r10.f11451a     // Catch:{ all -> 0x0639 }
            n3.a6 r14 = r10.f11452b     // Catch:{ all -> 0x0639 }
            int r14 = r14.a(r11)     // Catch:{ all -> 0x0639 }
            int r15 = r9.f16816h     // Catch:{ all -> 0x0639 }
            int r14 = r14 + r15
            java.lang.Object r5 = r13.h(r2, r11, r5, r14)     // Catch:{ all -> 0x0639 }
            if (r5 != 0) goto L_0x02f6
            r2 = 0
            goto L_0x0318
        L_0x02f6:
            r3.f11428h = r13     // Catch:{ all -> 0x0639 }
            r3.f11429i = r11     // Catch:{ all -> 0x0639 }
            r3.f11430j = r10     // Catch:{ all -> 0x0639 }
            r3.f11431k = r9     // Catch:{ all -> 0x0639 }
            r3.f11432l = r8     // Catch:{ all -> 0x0639 }
            r3.f11433m = r1     // Catch:{ all -> 0x0639 }
            r3.f11434n = r5     // Catch:{ all -> 0x0639 }
            r3.f11435o = r0     // Catch:{ all -> 0x0639 }
            r14 = 3
            r3.f11443w = r14     // Catch:{ all -> 0x0639 }
            java.lang.Object r2 = r13.j(r2, r11, r3)     // Catch:{ all -> 0x0639 }
            if (r2 != r4) goto L_0x0311
            goto L_0x0638
        L_0x0311:
            r16 = r5
            r5 = r1
            r1 = r16
        L_0x0316:
            r2 = r1
            r1 = r5
        L_0x0318:
            ob.d r1 = (ob.d) r1
            r5 = 0
            r1.f(r5)
            r0.f16818h = r2
            xa.q r0 = new xa.q
            r0.<init>()
        L_0x0325:
            java.lang.Object r1 = r8.f16818h
            if (r1 == 0) goto L_0x0636
            n3.g4 r1 = r13.g(r11, r1)
            r3.f11428h = r13
            r3.f11429i = r11
            r3.f11430j = r10
            r3.f11431k = r9
            r3.f11432l = r8
            r3.f11433m = r0
            r3.f11434n = r1
            r2 = 0
            r3.f11435o = r2
            r3.f11436p = r2
            r2 = 4
            r3.f11443w = r2
            n3.n4 r2 = r13.f11195b
            java.lang.Object r2 = r2.b(r1, r3)
            if (r2 != r4) goto L_0x034d
            goto L_0x0638
        L_0x034d:
            r14 = r11
            r11 = r9
            r9 = r0
            r0 = r10
            r10 = r8
            r8 = r1
        L_0x0353:
            r5 = r2
            n3.l4 r5 = (n3.l4) r5
            boolean r1 = r5 instanceof n3.k4
            if (r1 == 0) goto L_0x0422
            int r1 = r14.ordinal()
            r2 = 1
            if (r1 == r2) goto L_0x0370
            r2 = 2
            if (r1 != r2) goto L_0x036a
            r1 = r5
            n3.k4 r1 = (n3.k4) r1
            java.lang.Object r1 = r1.f11289c
            goto L_0x0375
        L_0x036a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r12)
            throw r0
        L_0x0370:
            r1 = r5
            n3.k4 r1 = (n3.k4) r1
            java.lang.Object r1 = r1.f11288b
        L_0x0375:
            n3.n4 r2 = r13.f11195b
            r2.getClass()
            java.lang.Object r2 = r10.f16818h
            boolean r1 = xa.j.a(r1, r2)
            r2 = 1
            r1 = r1 ^ r2
            if (r1 != 0) goto L_0x03b6
            if (r14 != r7) goto L_0x0389
            java.lang.String r0 = "prevKey"
            goto L_0x038b
        L_0x0389:
            java.lang.String r0 = "nextKey"
        L_0x038b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "The same value, "
            r1.<init>(r2)
            java.lang.Object r2 = r10.f16818h
            r1.append(r2)
            java.lang.String r2 = ", was passed as the "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r0 = fb.p.b(r0)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x03b6:
            n3.h3 r1 = r13.f11205l
            ob.d r2 = r1.f11229a
            r3.f11428h = r13
            r3.f11429i = r14
            r3.f11430j = r0
            r3.f11431k = r11
            r3.f11432l = r10
            r3.f11433m = r9
            r3.f11434n = r8
            r3.f11435o = r5
            r3.f11436p = r1
            r3.f11437q = r2
            r15 = 5
            r3.f11443w = r15
            java.lang.Object r15 = r2.e(r3)
            if (r15 != r4) goto L_0x03d9
            goto L_0x0638
        L_0x03d9:
            r15 = r13
            r13 = r0
        L_0x03db:
            n3.l3 r0 = r1.f11230b     // Catch:{ all -> 0x041a }
            int r1 = r13.f11451a     // Catch:{ all -> 0x041a }
            r17 = r3
            r3 = r5
            n3.k4 r3 = (n3.k4) r3     // Catch:{ all -> 0x041a }
            boolean r0 = r0.e(r1, r14, r3)     // Catch:{ all -> 0x041a }
            ob.d r2 = (ob.d) r2
            r1 = 0
            r2.f(r1)
            if (r0 != 0) goto L_0x03f2
            goto L_0x0636
        L_0x03f2:
            int r0 = r11.f16816h
            r1 = r5
            n3.k4 r1 = (n3.k4) r1
            java.util.List r2 = r1.f11287a
            int r2 = r2.size()
            int r2 = r2 + r0
            r11.f16816h = r2
            if (r14 != r7) goto L_0x0409
            java.lang.Object r0 = r1.f11288b
            if (r0 == 0) goto L_0x0407
            goto L_0x0409
        L_0x0407:
            r1 = 1
            goto L_0x0410
        L_0x0409:
            if (r14 != r6) goto L_0x0413
            java.lang.Object r0 = r1.f11289c
            if (r0 != 0) goto L_0x0413
            goto L_0x0407
        L_0x0410:
            r9.f16814h = r1
            goto L_0x0414
        L_0x0413:
            r1 = 1
        L_0x0414:
            r3 = r17
            r0 = r13
            r13 = r15
            goto L_0x04a0
        L_0x041a:
            r0 = move-exception
            ob.d r2 = (ob.d) r2
            r1 = 0
            r2.f(r1)
            throw r0
        L_0x0422:
            r1 = 1
            boolean r2 = r5 instanceof n3.h4
            if (r2 == 0) goto L_0x048d
            n3.h3 r1 = r13.f11205l
            ob.d r2 = r1.f11229a
            r3.f11428h = r13
            r3.f11429i = r14
            r3.f11430j = r0
            r3.f11431k = r5
            r3.f11432l = r1
            r3.f11433m = r2
            r6 = 0
            r3.f11434n = r6
            r6 = 6
            r3.f11443w = r6
            java.lang.Object r6 = r2.e(r3)
            if (r6 != r4) goto L_0x0445
            goto L_0x0638
        L_0x0445:
            r8 = r13
            r16 = r4
            r4 = r0
            r0 = r16
        L_0x044b:
            n3.l3 r1 = r1.f11230b     // Catch:{ all -> 0x0485 }
            n3.w0 r6 = new n3.w0     // Catch:{ all -> 0x0485 }
            n3.h4 r5 = (n3.h4) r5     // Catch:{ all -> 0x0485 }
            java.lang.Throwable r5 = r5.f11231a     // Catch:{ all -> 0x0485 }
            r6.<init>(r5)     // Catch:{ all -> 0x0485 }
            r3.f11428h = r14     // Catch:{ all -> 0x0485 }
            r3.f11429i = r4     // Catch:{ all -> 0x0485 }
            r3.f11430j = r2     // Catch:{ all -> 0x0485 }
            r3.f11431k = r1     // Catch:{ all -> 0x0485 }
            r5 = 0
            r3.f11432l = r5     // Catch:{ all -> 0x0485 }
            r3.f11433m = r5     // Catch:{ all -> 0x0485 }
            r5 = 7
            r3.f11443w = r5     // Catch:{ all -> 0x0485 }
            java.lang.Object r3 = r8.i(r1, r14, r6, r3)     // Catch:{ all -> 0x0485 }
            if (r3 != r0) goto L_0x046f
            r4 = r0
            goto L_0x0638
        L_0x046f:
            r0 = r1
            r1 = r2
            r3 = r14
        L_0x0472:
            java.util.LinkedHashMap r0 = r0.f11318k     // Catch:{ all -> 0x010a }
            n3.a6 r2 = r4.f11452b     // Catch:{ all -> 0x010a }
            r0.put(r3, r2)     // Catch:{ all -> 0x010a }
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x010a }
            ob.d r1 = (ob.d) r1
            r2 = 0
            r1.f(r2)
            goto L_0x0636
        L_0x0483:
            r2 = r1
            goto L_0x0486
        L_0x0485:
            r0 = move-exception
        L_0x0486:
            ob.d r2 = (ob.d) r2
            r15 = 0
            r2.f(r15)
            throw r0
        L_0x048d:
            r15 = 0
            boolean r2 = r5 instanceof n3.i4
            if (r2 == 0) goto L_0x04a0
            hb.o1 r0 = r13.f11206m
            r0.e(r15)
            n3.n4 r0 = r13.f11195b
            androidx.emoji2.text.w r0 = r0.f11359a
            r0.c()
            goto L_0x0636
        L_0x04a0:
            int[] r2 = n3.j2.f11265a
            int r15 = r14.ordinal()
            r2 = r2[r15]
            r15 = 2
            if (r2 != r15) goto L_0x04ad
            r2 = r6
            goto L_0x04ae
        L_0x04ad:
            r2 = r7
        L_0x04ae:
            n3.h3 r1 = r13.f11205l
            ob.d r15 = r1.f11229a
            r3.f11428h = r13
            r3.f11429i = r14
            r3.f11430j = r0
            r3.f11431k = r11
            r3.f11432l = r10
            r3.f11433m = r9
            r3.f11434n = r8
            r3.f11435o = r5
            r3.f11436p = r2
            r3.f11437q = r1
            r3.f11438r = r15
            r17 = r0
            r0 = 8
            r3.f11443w = r0
            java.lang.Object r0 = r15.e(r3)
            if (r0 != r4) goto L_0x04d6
            goto L_0x0638
        L_0x04d6:
            r0 = r14
            r14 = r17
            r16 = r5
            r5 = r2
            r2 = r13
            r13 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r16
        L_0x04e3:
            n3.l3 r1 = r1.f11230b     // Catch:{ all -> 0x062d }
            r17 = r6
            n3.a6 r6 = r14.f11452b     // Catch:{ all -> 0x062d }
            n3.o1 r5 = r1.c(r5, r6)     // Catch:{ all -> 0x062d }
            if (r5 != 0) goto L_0x04f4
            r6 = r17
            r5 = r8
            r8 = r9
            goto L_0x0535
        L_0x04f4:
            r1.b(r5)     // Catch:{ all -> 0x062d }
            jb.c r6 = r2.f11204k     // Catch:{ all -> 0x062d }
            r3.f11428h = r2     // Catch:{ all -> 0x062d }
            r3.f11429i = r0     // Catch:{ all -> 0x062d }
            r3.f11430j = r14     // Catch:{ all -> 0x062d }
            r3.f11431k = r13     // Catch:{ all -> 0x062d }
            r3.f11432l = r11     // Catch:{ all -> 0x062d }
            r3.f11433m = r10     // Catch:{ all -> 0x062d }
            r3.f11434n = r9     // Catch:{ all -> 0x062d }
            r3.f11435o = r8     // Catch:{ all -> 0x062d }
            r3.f11436p = r15     // Catch:{ all -> 0x062d }
            r3.f11437q = r1     // Catch:{ all -> 0x062d }
            r18 = r1
            r1 = 0
            r3.f11438r = r1     // Catch:{ all -> 0x062d }
            r1 = 9
            r3.f11443w = r1     // Catch:{ all -> 0x062d }
            java.lang.Object r1 = r6.g(r5, r3)     // Catch:{ all -> 0x062d }
            if (r1 != r4) goto L_0x051e
            goto L_0x0638
        L_0x051e:
            r6 = r17
            r5 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r13
            r13 = r14
            r1 = r15
            r14 = r0
            r15 = r2
            r0 = r18
        L_0x052b:
            la.v r2 = la.v.f9814a     // Catch:{ all -> 0x00bd }
            r2 = r15
            r15 = r1
            r1 = r0
            r0 = r14
            r14 = r13
            r13 = r11
            r11 = r10
            r10 = r9
        L_0x0535:
            int r9 = r14.f11451a     // Catch:{ all -> 0x062d }
            r17 = r6
            n3.a6 r6 = r14.f11452b     // Catch:{ all -> 0x062d }
            int r6 = r6.a(r0)     // Catch:{ all -> 0x062d }
            r18 = r7
            int r7 = r13.f16816h     // Catch:{ all -> 0x062d }
            int r6 = r6 + r7
            java.lang.Object r6 = r2.h(r1, r0, r9, r6)     // Catch:{ all -> 0x062d }
            n3.h1 r7 = r1.f11319l
            r11.f16818h = r6     // Catch:{ all -> 0x062d }
            if (r6 != 0) goto L_0x056c
            n3.a1 r6 = r7.a(r0)     // Catch:{ all -> 0x062d }
            boolean r6 = r6 instanceof n3.w0     // Catch:{ all -> 0x062d }
            if (r6 != 0) goto L_0x056c
            boolean r6 = r10.f16814h     // Catch:{ all -> 0x062d }
            if (r6 == 0) goto L_0x0562
            n3.y0 r6 = n3.z0.f11599b     // Catch:{ all -> 0x062d }
            r6.getClass()     // Catch:{ all -> 0x062d }
            n3.z0 r6 = n3.z0.f11600c     // Catch:{ all -> 0x062d }
            goto L_0x0569
        L_0x0562:
            n3.y0 r6 = n3.z0.f11599b     // Catch:{ all -> 0x062d }
            r6.getClass()     // Catch:{ all -> 0x062d }
            n3.z0 r6 = n3.z0.f11601d     // Catch:{ all -> 0x062d }
        L_0x0569:
            r7.c(r0, r6)     // Catch:{ all -> 0x062d }
        L_0x056c:
            r6 = r5
            n3.k4 r6 = (n3.k4) r6     // Catch:{ all -> 0x062d }
            n3.q1 r1 = r1.f(r6, r0)     // Catch:{ all -> 0x062d }
            jb.c r6 = r2.f11204k     // Catch:{ all -> 0x062d }
            r3.f11428h = r2     // Catch:{ all -> 0x062d }
            r3.f11429i = r0     // Catch:{ all -> 0x062d }
            r3.f11430j = r14     // Catch:{ all -> 0x062d }
            r3.f11431k = r13     // Catch:{ all -> 0x062d }
            r3.f11432l = r11     // Catch:{ all -> 0x062d }
            r3.f11433m = r10     // Catch:{ all -> 0x062d }
            r3.f11434n = r8     // Catch:{ all -> 0x062d }
            r3.f11435o = r5     // Catch:{ all -> 0x062d }
            r3.f11436p = r15     // Catch:{ all -> 0x062d }
            r7 = 0
            r3.f11437q = r7     // Catch:{ all -> 0x062d }
            r3.f11438r = r7     // Catch:{ all -> 0x062d }
            r7 = 10
            r3.f11443w = r7     // Catch:{ all -> 0x062d }
            java.lang.Object r1 = r6.g(r1, r3)     // Catch:{ all -> 0x062d }
            if (r1 != r4) goto L_0x0598
            goto L_0x0638
        L_0x0598:
            r6 = r17
            r7 = r18
            r9 = r13
            r1 = r15
            r15 = r11
            r11 = r14
            r14 = r10
            r10 = r2
            r16 = r8
            r8 = r0
            r0 = r5
            r5 = r16
        L_0x05a8:
            la.v r2 = la.v.f9814a     // Catch:{ all -> 0x00bd }
            ob.d r1 = (ob.d) r1
            r2 = 0
            r1.f(r2)
            boolean r1 = r5 instanceof n3.e4
            if (r1 == 0) goto L_0x05bd
            r1 = r0
            n3.k4 r1 = (n3.k4) r1
            java.lang.Object r1 = r1.f11288b
            if (r1 != 0) goto L_0x05bd
            r1 = 1
            goto L_0x05be
        L_0x05bd:
            r1 = 0
        L_0x05be:
            boolean r2 = r5 instanceof n3.c4
            if (r2 == 0) goto L_0x05ca
            n3.k4 r0 = (n3.k4) r0
            java.lang.Object r0 = r0.f11289c
            if (r0 != 0) goto L_0x05ca
            r0 = 1
            goto L_0x05cb
        L_0x05ca:
            r0 = 0
        L_0x05cb:
            n3.d5 r2 = r10.f11199f
            if (r2 == 0) goto L_0x061e
            if (r1 != 0) goto L_0x05d3
            if (r0 == 0) goto L_0x061e
        L_0x05d3:
            n3.h3 r13 = r10.f11205l
            ob.d r5 = r13.f11229a
            r3.f11428h = r10
            r3.f11429i = r8
            r3.f11430j = r11
            r3.f11431k = r9
            r3.f11432l = r15
            r3.f11433m = r14
            r3.f11434n = r13
            r3.f11435o = r5
            r2 = 0
            r3.f11436p = r2
            r3.f11439s = r1
            r3.f11440t = r0
            r2 = 11
            r3.f11443w = r2
            java.lang.Object r2 = r5.e(r3)
            if (r2 != r4) goto L_0x05f9
            goto L_0x0638
        L_0x05f9:
            n3.l3 r2 = r13.f11230b     // Catch:{ all -> 0x0625 }
            n3.v0 r13 = r10.f11202i     // Catch:{ all -> 0x0625 }
            j3.w0 r13 = r13.f11516a     // Catch:{ all -> 0x0625 }
            java.lang.Object r13 = r13.f8716c     // Catch:{ all -> 0x0625 }
            n3.y5 r13 = (n3.y5) r13     // Catch:{ all -> 0x0625 }
            n3.o4 r2 = r2.a(r13)     // Catch:{ all -> 0x0625 }
            ob.d r5 = (ob.d) r5
            r13 = 0
            r5.f(r13)
            n3.d5 r5 = r10.f11199f
            if (r1 == 0) goto L_0x0617
            r1 = r5
            n3.c5 r1 = (n3.c5) r1
            r1.b(r7, r2)
        L_0x0617:
            if (r0 == 0) goto L_0x061e
            n3.c5 r5 = (n3.c5) r5
            r5.b(r6, r2)
        L_0x061e:
            r13 = r10
            r10 = r11
            r0 = r14
            r11 = r8
            r8 = r15
            goto L_0x0325
        L_0x0625:
            r0 = move-exception
            ob.d r5 = (ob.d) r5
            r1 = 0
            r5.f(r1)
            throw r0
        L_0x062d:
            r0 = move-exception
            r1 = r15
        L_0x062f:
            ob.d r1 = (ob.d) r1
            r2 = 0
            r1.f(r2)
            throw r0
        L_0x0636:
            la.v r4 = la.v.f9814a
        L_0x0638:
            return r4
        L_0x0639:
            r0 = move-exception
            r5 = r1
        L_0x063b:
            ob.d r5 = (ob.d) r5
            r1 = 0
            r5.f(r1)
            throw r0
        L_0x0642:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0648 }
            r0.<init>(r12)     // Catch:{ all -> 0x0648 }
            throw r0     // Catch:{ all -> 0x0648 }
        L_0x0648:
            r0 = move-exception
            ob.d r2 = (ob.d) r2
            r1 = 0
            r2.f(r1)
            throw r0
        L_0x0650:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r12.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.g3.b(n3.g3, n3.d1, n3.r0, pa.e):java.lang.Object");
    }

    public static final Object c(g3 g3Var, d1 d1Var, a6 a6Var, v2 v2Var) {
        boolean z10;
        g3Var.getClass();
        boolean z11 = true;
        if (j2.f11265a[d1Var.ordinal()] == 1) {
            Object f10 = g3Var.f(v2Var);
            if (f10 == qa.a.COROUTINE_SUSPENDED) {
                return f10;
            }
        } else {
            if (a6Var != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                v0 v0Var = g3Var.f11202i;
                v0Var.getClass();
                j.f("viewportHint", a6Var);
                if (!(d1Var == d1.PREPEND || d1Var == d1.APPEND)) {
                    z11 = false;
                }
                if (z11) {
                    v0Var.f11516a.c((y5) null, new t0(d1Var, 0, a6Var));
                } else {
                    throw new IllegalArgumentException(j.k("invalid load type for reset: ", d1Var).toString());
                }
            } else {
                throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint".toString());
            }
        }
        return la.v.f9814a;
    }

    public static final void d(g3 g3Var, f0 f0Var) {
        if (g3Var.f11196c.f11463f != Integer.MIN_VALUE) {
            for (d1 d3Var : r.e(d1.APPEND, d1.PREPEND)) {
                h0.b1(f0Var, (h) null, 0, new d3(d3Var, g3Var, (e) null), 3);
            }
        }
        h0.b1(f0Var, (h) null, 0, new e3(g3Var, (e) null), 3);
        h0.b1(f0Var, (h) null, 0, new f3(g3Var, (e) null), 3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(pa.e r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof n3.o2
            if (r0 == 0) goto L_0x0013
            r0 = r5
            n3.o2 r0 = (n3.o2) r0
            int r1 = r0.f11380m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11380m = r1
            goto L_0x0018
        L_0x0013:
            n3.o2 r0 = new n3.o2
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f11378k
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11380m
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            ob.d r1 = r0.f11377j
            n3.h3 r2 = r0.f11376i
            n3.g3 r0 = r0.f11375h
            hb.h0.O1(r5)
            goto L_0x004d
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            hb.h0.O1(r5)
            n3.h3 r2 = r4.f11205l
            ob.d r5 = r2.f11229a
            r0.f11375h = r4
            r0.f11376i = r2
            r0.f11377j = r5
            r0.f11380m = r3
            java.lang.Object r0 = r5.e(r0)
            if (r0 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r0 = r4
            r1 = r5
        L_0x004d:
            r5 = 0
            n3.l3 r2 = r2.f11230b     // Catch:{ all -> 0x0060 }
            n3.v0 r0 = r0.f11202i     // Catch:{ all -> 0x0060 }
            j3.w0 r0 = r0.f11516a     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r0.f8716c     // Catch:{ all -> 0x0060 }
            n3.y5 r0 = (n3.y5) r0     // Catch:{ all -> 0x0060 }
            n3.o4 r0 = r2.a(r0)     // Catch:{ all -> 0x0060 }
            r1.f(r5)
            return r0
        L_0x0060:
            r0 = move-exception
            r1.f(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.g3.e(pa.e):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r0v14, types: [ob.a] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0215, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0216, code lost:
        r4 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r12 = r3.f11230b;
        r3 = new n3.w0(((n3.h4) r4).f11231a);
        r0.f11400h = r2;
        r0.f11401i = null;
        r0.f11402j = null;
        r0.f11403k = null;
        r0.f11406n = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0232, code lost:
        if (r7.i(r12, r5, r3, r0) != r1) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0234, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0235, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0236, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r12 = la.v.f9814a;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0238, code lost:
        r0.f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x023f, code lost:
        return la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0242, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0243, code lost:
        r2.f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0248, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x024b, code lost:
        if ((r12 instanceof n3.i4) == false) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x024d, code lost:
        r7.f11206m.e((java.util.concurrent.CancellationException) null);
        r7.f11195b.f11359a.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x025b, code lost:
        return la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r12 = r7.f11230b;
        r0.f11400h = r8;
        r0.f11401i = r2;
        r0.f11402j = null;
        r0.f11406n = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e6, code lost:
        if (r8.j(r12, r5, r0) != r1) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e8, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e9, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ea, code lost:
        r12 = la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ec, code lost:
        ((ob.d) r2).f((java.lang.Object) null);
        r12 = r7.g(r5, r7.f11194a);
        r0.f11400h = r7;
        r0.f11401i = null;
        r0.f11406n = 3;
        r12 = r7.f11195b.b(r12, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0104, code lost:
        if (r12 != r1) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0106, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0107, code lost:
        r12 = (n3.l4) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010b, code lost:
        if ((r12 instanceof n3.k4) == false) goto L_0x01fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010d, code lost:
        r2 = r7.f11205l;
        r8 = r2.f11229a;
        r0.f11400h = r7;
        r0.f11401i = r12;
        r0.f11402j = r2;
        r0.f11403k = r8;
        r0.f11406n = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0120, code lost:
        if (r8.e(r0) != r1) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0122, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0123, code lost:
        r9 = r7;
        r7 = r2;
        r2 = r8;
        r8 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r12 = r7.f11230b;
        r7 = r12.e(0, r5, (n3.k4) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0131, code lost:
        r12 = r12.f11319l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        n3.z0.f11599b.getClass();
        r12.c(r5, n3.z0.f11601d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0142, code lost:
        if (((n3.k4) r8).f11288b != null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0144, code lost:
        r12.c(r4, n3.z0.f11600c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x014e, code lost:
        if (((n3.k4) r8).f11289c != null) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0150, code lost:
        r12.c(r3, n3.z0.f11600c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0158, code lost:
        if (r7 == false) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x015a, code lost:
        r7 = r9.f11205l;
        r12 = r7.f11229a;
        r0.f11400h = r9;
        r0.f11401i = r8;
        r0.f11402j = r7;
        r0.f11403k = r12;
        r0.f11406n = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x016d, code lost:
        if (r12.e(r0) != r1) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0170, code lost:
        r2 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r12 = r7.f11230b;
        r7 = r9.f11204k;
        r12 = r12.f((n3.k4) r8, r5);
        r0.f11400h = r9;
        r0.f11401i = r8;
        r0.f11402j = r2;
        r0.f11403k = null;
        r0.f11406n = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x018b, code lost:
        if (r7.g(r12, r0) != r1) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x018d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x018e, code lost:
        r5 = r8;
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0190, code lost:
        r12 = la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0192, code lost:
        ((ob.d) r2).f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x019f, code lost:
        r5 = r8;
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01a3, code lost:
        if (r7.f11199f == null) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01a5, code lost:
        r12 = (n3.k4) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01aa, code lost:
        if (r12.f11288b == null) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01ae, code lost:
        if (r12.f11289c != null) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01b0, code lost:
        r2 = r7.f11205l;
        r12 = r2.f11229a;
        r0.f11400h = r7;
        r0.f11401i = r5;
        r0.f11402j = r2;
        r0.f11403k = r12;
        r0.f11406n = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01c3, code lost:
        if (r12.e(r0) != r1) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01c5, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c6, code lost:
        r1 = r12;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r12 = r2.f11230b.a((n3.y5) r0.f11202i.f11516a.f8716c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01d6, code lost:
        r1.f((java.lang.Object) null);
        r5 = (n3.k4) r5;
        r1 = r5.f11288b;
        r0 = r0.f11199f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01df, code lost:
        if (r1 != null) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01e1, code lost:
        ((n3.c5) r0).b(r4, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e9, code lost:
        if (r5.f11289c != null) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01eb, code lost:
        ((n3.c5) r0).b(r3, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01f1, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01f2, code lost:
        r1.f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01f5, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f6, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f7, code lost:
        r2.f((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01fa, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01fd, code lost:
        if ((r12 instanceof n3.h4) == false) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ff, code lost:
        r3 = r7.f11205l;
        r2 = r3.f11229a;
        r0.f11400h = r7;
        r0.f11401i = r12;
        r0.f11402j = r3;
        r0.f11403k = r2;
        r0.f11406n = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0213, code lost:
        if (r2.e(r0) != r1) goto L_0x0216;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(pa.e r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof n3.p2
            if (r0 == 0) goto L_0x0013
            r0 = r12
            n3.p2 r0 = (n3.p2) r0
            int r1 = r0.f11406n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11406n = r1
            goto L_0x0018
        L_0x0013:
            n3.p2 r0 = new n3.p2
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f11404l
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11406n
            n3.d1 r3 = n3.d1.APPEND
            n3.d1 r4 = n3.d1.PREPEND
            n3.d1 r5 = n3.d1.REFRESH
            r6 = 0
            switch(r2) {
                case 0: goto L_0x00be;
                case 1: goto L_0x00ae;
                case 2: goto L_0x00a2;
                case 3: goto L_0x0099;
                case 4: goto L_0x0086;
                case 5: goto L_0x0073;
                case 6: goto L_0x0062;
                case 7: goto L_0x004f;
                case 8: goto L_0x003c;
                case 9: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0030:
            java.lang.Object r0 = r0.f11400h
            ob.a r0 = (ob.a) r0
            hb.h0.O1(r12)     // Catch:{ all -> 0x0039 }
            goto L_0x0236
        L_0x0039:
            r12 = move-exception
            goto L_0x0240
        L_0x003c:
            ob.d r2 = r0.f11403k
            java.lang.Object r3 = r0.f11402j
            n3.h3 r3 = (n3.h3) r3
            java.lang.Object r4 = r0.f11401i
            n3.l4 r4 = (n3.l4) r4
            java.lang.Object r7 = r0.f11400h
            n3.g3 r7 = (n3.g3) r7
            hb.h0.O1(r12)
            goto L_0x0217
        L_0x004f:
            ob.d r1 = r0.f11403k
            java.lang.Object r2 = r0.f11402j
            n3.h3 r2 = (n3.h3) r2
            java.lang.Object r5 = r0.f11401i
            n3.l4 r5 = (n3.l4) r5
            java.lang.Object r0 = r0.f11400h
            n3.g3 r0 = (n3.g3) r0
            hb.h0.O1(r12)
            goto L_0x01c8
        L_0x0062:
            java.lang.Object r2 = r0.f11402j
            ob.a r2 = (ob.a) r2
            java.lang.Object r5 = r0.f11401i
            n3.l4 r5 = (n3.l4) r5
            java.lang.Object r7 = r0.f11400h
            n3.g3 r7 = (n3.g3) r7
            hb.h0.O1(r12)     // Catch:{ all -> 0x0198 }
            goto L_0x0190
        L_0x0073:
            ob.d r2 = r0.f11403k
            java.lang.Object r7 = r0.f11402j
            n3.h3 r7 = (n3.h3) r7
            java.lang.Object r8 = r0.f11401i
            n3.l4 r8 = (n3.l4) r8
            java.lang.Object r9 = r0.f11400h
            n3.g3 r9 = (n3.g3) r9
            hb.h0.O1(r12)
            goto L_0x0171
        L_0x0086:
            ob.d r2 = r0.f11403k
            java.lang.Object r7 = r0.f11402j
            n3.h3 r7 = (n3.h3) r7
            java.lang.Object r8 = r0.f11401i
            n3.l4 r8 = (n3.l4) r8
            java.lang.Object r9 = r0.f11400h
            n3.g3 r9 = (n3.g3) r9
            hb.h0.O1(r12)
            goto L_0x0127
        L_0x0099:
            java.lang.Object r2 = r0.f11400h
            n3.g3 r2 = (n3.g3) r2
            hb.h0.O1(r12)
            r7 = r2
            goto L_0x0107
        L_0x00a2:
            java.lang.Object r2 = r0.f11401i
            ob.a r2 = (ob.a) r2
            java.lang.Object r7 = r0.f11400h
            n3.g3 r7 = (n3.g3) r7
            hb.h0.O1(r12)     // Catch:{ all -> 0x025c }
            goto L_0x00ea
        L_0x00ae:
            java.lang.Object r2 = r0.f11402j
            ob.a r2 = (ob.a) r2
            java.lang.Object r7 = r0.f11401i
            n3.h3 r7 = (n3.h3) r7
            java.lang.Object r8 = r0.f11400h
            n3.g3 r8 = (n3.g3) r8
            hb.h0.O1(r12)
            goto L_0x00d7
        L_0x00be:
            hb.h0.O1(r12)
            n3.h3 r7 = r11.f11205l
            ob.d r12 = r7.f11229a
            r0.f11400h = r11
            r0.f11401i = r7
            r0.f11402j = r12
            r2 = 1
            r0.f11406n = r2
            java.lang.Object r2 = r12.e(r0)
            if (r2 != r1) goto L_0x00d5
            return r1
        L_0x00d5:
            r8 = r11
            r2 = r12
        L_0x00d7:
            n3.l3 r12 = r7.f11230b     // Catch:{ all -> 0x025c }
            r0.f11400h = r8     // Catch:{ all -> 0x025c }
            r0.f11401i = r2     // Catch:{ all -> 0x025c }
            r0.f11402j = r6     // Catch:{ all -> 0x025c }
            r7 = 2
            r0.f11406n = r7     // Catch:{ all -> 0x025c }
            java.lang.Object r12 = r8.j(r12, r5, r0)     // Catch:{ all -> 0x025c }
            if (r12 != r1) goto L_0x00e9
            return r1
        L_0x00e9:
            r7 = r8
        L_0x00ea:
            la.v r12 = la.v.f9814a     // Catch:{ all -> 0x025c }
            ob.d r2 = (ob.d) r2
            r2.f(r6)
            java.lang.Object r12 = r7.f11194a
            n3.g4 r12 = r7.g(r5, r12)
            r0.f11400h = r7
            r0.f11401i = r6
            r2 = 3
            r0.f11406n = r2
            n3.n4 r2 = r7.f11195b
            java.lang.Object r12 = r2.b(r12, r0)
            if (r12 != r1) goto L_0x0107
            return r1
        L_0x0107:
            n3.l4 r12 = (n3.l4) r12
            boolean r2 = r12 instanceof n3.k4
            if (r2 == 0) goto L_0x01fb
            n3.h3 r2 = r7.f11205l
            ob.d r8 = r2.f11229a
            r0.f11400h = r7
            r0.f11401i = r12
            r0.f11402j = r2
            r0.f11403k = r8
            r9 = 4
            r0.f11406n = r9
            java.lang.Object r9 = r8.e(r0)
            if (r9 != r1) goto L_0x0123
            return r1
        L_0x0123:
            r9 = r7
            r7 = r2
            r2 = r8
            r8 = r12
        L_0x0127:
            n3.l3 r12 = r7.f11230b     // Catch:{ all -> 0x01f6 }
            r7 = r8
            n3.k4 r7 = (n3.k4) r7     // Catch:{ all -> 0x01f6 }
            r10 = 0
            boolean r7 = r12.e(r10, r5, r7)     // Catch:{ all -> 0x01f6 }
            n3.h1 r12 = r12.f11319l
            n3.y0 r10 = n3.z0.f11599b     // Catch:{ all -> 0x01f6 }
            r10.getClass()     // Catch:{ all -> 0x01f6 }
            n3.z0 r10 = n3.z0.f11601d     // Catch:{ all -> 0x01f6 }
            r12.c(r5, r10)     // Catch:{ all -> 0x01f6 }
            r10 = r8
            n3.k4 r10 = (n3.k4) r10     // Catch:{ all -> 0x01f6 }
            java.lang.Object r10 = r10.f11288b     // Catch:{ all -> 0x01f6 }
            if (r10 != 0) goto L_0x0149
            n3.z0 r10 = n3.z0.f11600c     // Catch:{ all -> 0x01f6 }
            r12.c(r4, r10)     // Catch:{ all -> 0x01f6 }
        L_0x0149:
            r10 = r8
            n3.k4 r10 = (n3.k4) r10     // Catch:{ all -> 0x01f6 }
            java.lang.Object r10 = r10.f11289c     // Catch:{ all -> 0x01f6 }
            if (r10 != 0) goto L_0x0155
            n3.z0 r10 = n3.z0.f11600c     // Catch:{ all -> 0x01f6 }
            r12.c(r3, r10)     // Catch:{ all -> 0x01f6 }
        L_0x0155:
            r2.f(r6)
            if (r7 == 0) goto L_0x019f
            n3.h3 r7 = r9.f11205l
            ob.d r12 = r7.f11229a
            r0.f11400h = r9
            r0.f11401i = r8
            r0.f11402j = r7
            r0.f11403k = r12
            r2 = 5
            r0.f11406n = r2
            java.lang.Object r2 = r12.e(r0)
            if (r2 != r1) goto L_0x0170
            return r1
        L_0x0170:
            r2 = r12
        L_0x0171:
            n3.l3 r12 = r7.f11230b     // Catch:{ all -> 0x0198 }
            jb.c r7 = r9.f11204k     // Catch:{ all -> 0x0198 }
            r10 = r8
            n3.k4 r10 = (n3.k4) r10     // Catch:{ all -> 0x0198 }
            n3.q1 r12 = r12.f(r10, r5)     // Catch:{ all -> 0x0198 }
            r0.f11400h = r9     // Catch:{ all -> 0x0198 }
            r0.f11401i = r8     // Catch:{ all -> 0x0198 }
            r0.f11402j = r2     // Catch:{ all -> 0x0198 }
            r0.f11403k = r6     // Catch:{ all -> 0x0198 }
            r5 = 6
            r0.f11406n = r5     // Catch:{ all -> 0x0198 }
            java.lang.Object r12 = r7.g(r12, r0)     // Catch:{ all -> 0x0198 }
            if (r12 != r1) goto L_0x018e
            return r1
        L_0x018e:
            r5 = r8
            r7 = r9
        L_0x0190:
            la.v r12 = la.v.f9814a     // Catch:{ all -> 0x0198 }
            ob.d r2 = (ob.d) r2
            r2.f(r6)
            goto L_0x01a1
        L_0x0198:
            r12 = move-exception
            ob.d r2 = (ob.d) r2
            r2.f(r6)
            throw r12
        L_0x019f:
            r5 = r8
            r7 = r9
        L_0x01a1:
            n3.d5 r12 = r7.f11199f
            if (r12 == 0) goto L_0x0259
            r12 = r5
            n3.k4 r12 = (n3.k4) r12
            java.lang.Object r2 = r12.f11288b
            if (r2 == 0) goto L_0x01b0
            java.lang.Object r12 = r12.f11289c
            if (r12 != 0) goto L_0x0259
        L_0x01b0:
            n3.h3 r2 = r7.f11205l
            ob.d r12 = r2.f11229a
            r0.f11400h = r7
            r0.f11401i = r5
            r0.f11402j = r2
            r0.f11403k = r12
            r8 = 7
            r0.f11406n = r8
            java.lang.Object r0 = r12.e(r0)
            if (r0 != r1) goto L_0x01c6
            return r1
        L_0x01c6:
            r1 = r12
            r0 = r7
        L_0x01c8:
            n3.l3 r12 = r2.f11230b     // Catch:{ all -> 0x01f1 }
            n3.v0 r2 = r0.f11202i     // Catch:{ all -> 0x01f1 }
            j3.w0 r2 = r2.f11516a     // Catch:{ all -> 0x01f1 }
            java.lang.Object r2 = r2.f8716c     // Catch:{ all -> 0x01f1 }
            n3.y5 r2 = (n3.y5) r2     // Catch:{ all -> 0x01f1 }
            n3.o4 r12 = r12.a(r2)     // Catch:{ all -> 0x01f1 }
            r1.f(r6)
            n3.k4 r5 = (n3.k4) r5
            java.lang.Object r1 = r5.f11288b
            n3.d5 r0 = r0.f11199f
            if (r1 != 0) goto L_0x01e7
            r1 = r0
            n3.c5 r1 = (n3.c5) r1
            r1.b(r4, r12)
        L_0x01e7:
            java.lang.Object r1 = r5.f11289c
            if (r1 != 0) goto L_0x0259
            n3.c5 r0 = (n3.c5) r0
            r0.b(r3, r12)
            goto L_0x0259
        L_0x01f1:
            r12 = move-exception
            r1.f(r6)
            throw r12
        L_0x01f6:
            r12 = move-exception
            r2.f(r6)
            throw r12
        L_0x01fb:
            boolean r2 = r12 instanceof n3.h4
            if (r2 == 0) goto L_0x0249
            n3.h3 r3 = r7.f11205l
            ob.d r2 = r3.f11229a
            r0.f11400h = r7
            r0.f11401i = r12
            r0.f11402j = r3
            r0.f11403k = r2
            r4 = 8
            r0.f11406n = r4
            java.lang.Object r4 = r2.e(r0)
            if (r4 != r1) goto L_0x0216
            return r1
        L_0x0216:
            r4 = r12
        L_0x0217:
            n3.l3 r12 = r3.f11230b     // Catch:{ all -> 0x0242 }
            n3.w0 r3 = new n3.w0     // Catch:{ all -> 0x0242 }
            n3.h4 r4 = (n3.h4) r4     // Catch:{ all -> 0x0242 }
            java.lang.Throwable r4 = r4.f11231a     // Catch:{ all -> 0x0242 }
            r3.<init>(r4)     // Catch:{ all -> 0x0242 }
            r0.f11400h = r2     // Catch:{ all -> 0x0242 }
            r0.f11401i = r6     // Catch:{ all -> 0x0242 }
            r0.f11402j = r6     // Catch:{ all -> 0x0242 }
            r0.f11403k = r6     // Catch:{ all -> 0x0242 }
            r4 = 9
            r0.f11406n = r4     // Catch:{ all -> 0x0242 }
            java.lang.Object r12 = r7.i(r12, r5, r3, r0)     // Catch:{ all -> 0x0242 }
            if (r12 != r1) goto L_0x0235
            return r1
        L_0x0235:
            r0 = r2
        L_0x0236:
            la.v r12 = la.v.f9814a     // Catch:{ all -> 0x0039 }
            ob.d r0 = (ob.d) r0
            r0.f(r6)
            la.v r12 = la.v.f9814a
            return r12
        L_0x0240:
            r2 = r0
            goto L_0x0243
        L_0x0242:
            r12 = move-exception
        L_0x0243:
            ob.d r2 = (ob.d) r2
            r2.f(r6)
            throw r12
        L_0x0249:
            boolean r12 = r12 instanceof n3.i4
            if (r12 == 0) goto L_0x0259
            hb.o1 r12 = r7.f11206m
            r12.e(r6)
            n3.n4 r12 = r7.f11195b
            androidx.emoji2.text.w r12 = r12.f11359a
            r12.c()
        L_0x0259:
            la.v r12 = la.v.f9814a
            return r12
        L_0x025c:
            r12 = move-exception
            ob.d r2 = (ob.d) r2
            r2.f(r6)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.g3.f(pa.e):java.lang.Object");
    }

    public final g4 g(d1 d1Var, Object obj) {
        int i10;
        d4 d4Var = g4.f11208a;
        d1 d1Var2 = d1.REFRESH;
        r3 r3Var = this.f11196c;
        if (d1Var == d1Var2) {
            i10 = r3Var.f11461d;
        } else {
            i10 = r3Var.f11458a;
        }
        boolean z10 = r3Var.f11460c;
        d4Var.getClass();
        j.f("loadType", d1Var);
        int ordinal = d1Var.ordinal();
        if (ordinal == 0) {
            return new f4(i10, obj, z10);
        }
        if (ordinal != 1) {
            if (ordinal != 2) {
                throw new g();
            } else if (obj != null) {
                return new c4(i10, obj, z10);
            } else {
                throw new IllegalArgumentException("key cannot be null for append".toString());
            }
        } else if (obj != null) {
            return new e4(i10, obj, z10);
        } else {
            throw new IllegalArgumentException("key cannot be null for prepend".toString());
        }
    }

    public final Object h(l3 l3Var, d1 d1Var, int i10, int i11) {
        int i12;
        l3Var.getClass();
        int ordinal = d1Var.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                i12 = l3Var.f11314g;
            } else if (ordinal == 2) {
                i12 = l3Var.f11315h;
            } else {
                throw new g();
            }
            if (i10 != i12 || (l3Var.f11319l.a(d1Var) instanceof w0) || i11 >= this.f11196c.f11459b) {
                return null;
            }
            d1 d1Var2 = d1.PREPEND;
            ArrayList arrayList = l3Var.f11310c;
            if (d1Var == d1Var2) {
                return ((k4) z.s(arrayList)).f11288b;
            }
            return ((k4) z.z(arrayList)).f11289c;
        }
        throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
    }

    public final Object i(l3 l3Var, d1 d1Var, w0 w0Var, ra.c cVar) {
        if (j.a(l3Var.f11319l.a(d1Var), w0Var)) {
            return la.v.f9814a;
        }
        h1 h1Var = l3Var.f11319l;
        h1Var.c(d1Var, w0Var);
        Object g10 = this.f11204k.g(new r1(h1Var.d(), (c1) null), cVar);
        if (g10 == qa.a.COROUTINE_SUSPENDED) {
            return g10;
        }
        return la.v.f9814a;
    }

    public final Object j(l3 l3Var, d1 d1Var, ra.c cVar) {
        a1 a10 = l3Var.f11319l.a(d1Var);
        x0 x0Var = x0.f11553b;
        if (j.a(a10, x0Var)) {
            return la.v.f9814a;
        }
        h1 h1Var = l3Var.f11319l;
        h1Var.c(d1Var, x0Var);
        Object g10 = this.f11204k.g(new r1(h1Var.d(), (c1) null), cVar);
        if (g10 == qa.a.COROUTINE_SUSPENDED) {
            return g10;
        }
        return la.v.f9814a;
    }
}
