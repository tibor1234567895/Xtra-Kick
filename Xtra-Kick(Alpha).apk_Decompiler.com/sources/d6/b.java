package d6;

import a2.i;
import a2.k;
import a2.l;
import a2.q;
import a2.s;
import android.net.Uri;
import android.os.SystemClock;
import d9.r0;
import g1.b1;
import j1.l0;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k1.h;
import k1.z;
import p1.d;
import r1.n;
import r1.p;
import r1.v;
import r3.b0;
import v1.f0;
import v1.r;
import v1.w;

public final class b implements l {

    /* renamed from: h  reason: collision with root package name */
    public final Uri f4510h;

    /* renamed from: i  reason: collision with root package name */
    public final q f4511i = new q("DefaultHlsPlaylistTracker:MediaPlaylist");

    /* renamed from: j  reason: collision with root package name */
    public final h f4512j;

    /* renamed from: k  reason: collision with root package name */
    public r1.l f4513k;

    /* renamed from: l  reason: collision with root package name */
    public long f4514l;

    /* renamed from: m  reason: collision with root package name */
    public long f4515m;

    /* renamed from: n  reason: collision with root package name */
    public long f4516n;

    /* renamed from: o  reason: collision with root package name */
    public long f4517o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4518p;

    /* renamed from: q  reason: collision with root package name */
    public IOException f4519q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ c f4520r;

    public b(c cVar, Uri uri) {
        this.f4520r = cVar;
        this.f4510h = uri;
        this.f4512j = cVar.f4522h.a();
    }

    public static boolean a(b bVar, long j10) {
        boolean z10;
        bVar.f4517o = SystemClock.elapsedRealtime() + j10;
        c cVar = bVar.f4520r;
        if (!bVar.f4510h.equals(cVar.f4532r)) {
            return false;
        }
        List list = cVar.f4531q.f13612e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                z10 = false;
                break;
            }
            b bVar2 = (b) cVar.f4525k.get(((n) list.get(i10)).f13604a);
            bVar2.getClass();
            if (elapsedRealtime > bVar2.f4517o) {
                Uri uri = bVar2.f4510h;
                cVar.f4532r = uri;
                bVar2.c(cVar.p(uri));
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            return true;
        }
        return false;
    }

    public final void b(Uri uri) {
        c cVar = this.f4520r;
        s sVar = new s(this.f4512j, uri, cVar.f4523i.a(cVar.f4531q, this.f4513k));
        i iVar = cVar.f4524j;
        int i10 = sVar.f79c;
        this.f4511i.g(sVar, this, iVar.b(i10));
        cVar.f4527m.m(new r(sVar.f78b), i10);
    }

    public final void c(Uri uri) {
        this.f4517o = 0;
        if (!this.f4518p) {
            q qVar = this.f4511i;
            if (!qVar.d() && !qVar.c()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j10 = this.f4516n;
                if (elapsedRealtime < j10) {
                    this.f4518p = true;
                    this.f4520r.f4529o.postDelayed(new b0(this, 2, uri), j10 - elapsedRealtime);
                    return;
                }
                b(uri);
            }
        }
    }

    public final void d(r1.l lVar, r rVar) {
        r0 r0Var;
        r1.l lVar2;
        long j10;
        String str;
        boolean z10;
        IOException iOException;
        r0 r0Var2;
        long j11;
        int i10;
        r1.i iVar;
        long j12;
        long j13;
        r1.i iVar2;
        long j14;
        r1.l lVar3 = lVar;
        r1.l lVar4 = this.f4513k;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f4514l = elapsedRealtime;
        c cVar = this.f4520r;
        cVar.getClass();
        boolean d10 = lVar3.d(lVar4);
        r0 r0Var3 = lVar3.f13596r;
        long j15 = lVar3.f13589k;
        if (!d10) {
            if (lVar3.f13593o) {
                lVar2 = lVar4.c();
            } else {
                lVar2 = lVar4;
            }
            r0Var = r0Var3;
        } else {
            if (lVar3.f13594p) {
                j11 = lVar3.f13586h;
                r0Var2 = r0Var3;
            } else {
                r1.l lVar5 = cVar.f4533s;
                if (lVar5 != null) {
                    j12 = lVar5.f13586h;
                } else {
                    j12 = 0;
                }
                if (lVar4 == null) {
                    r0Var2 = r0Var3;
                    j13 = j12;
                } else {
                    r0 r0Var4 = lVar4.f13596r;
                    int size = r0Var4.size();
                    r0Var2 = r0Var3;
                    long j16 = lVar4.f13589k;
                    j13 = j12;
                    int i11 = (int) (j15 - j16);
                    if (i11 < r0Var4.size()) {
                        iVar2 = (r1.i) r0Var4.get(i11);
                    } else {
                        iVar2 = null;
                    }
                    if (iVar2 != null) {
                        j14 = iVar2.f13570l;
                    } else if (((long) size) == j15 - j16) {
                        j14 = lVar4.f13599u;
                    }
                    j11 = j14 + lVar4.f13586h;
                }
                j11 = j13;
            }
            if (lVar3.f13587i) {
                i10 = lVar3.f13588j;
            } else {
                r1.l lVar6 = cVar.f4533s;
                if (lVar6 != null) {
                    i10 = lVar6.f13588j;
                } else {
                    i10 = 0;
                }
                if (lVar4 != null) {
                    int i12 = (int) (j15 - lVar4.f13589k);
                    r0 r0Var5 = lVar4.f13596r;
                    if (i12 < r0Var5.size()) {
                        iVar = (r1.i) r0Var5.get(i12);
                    } else {
                        iVar = null;
                    }
                    if (iVar != null) {
                        int i13 = lVar4.f13588j + iVar.f13569k;
                        r0Var = r0Var2;
                        i10 = i13 - ((r1.i) r0Var.get(0)).f13569k;
                        lVar2 = lVar3.b(i10, j11);
                    }
                }
            }
            r0Var = r0Var2;
            lVar2 = lVar3.b(i10, j11);
        }
        this.f4513k = lVar2;
        boolean z11 = true;
        CopyOnWriteArrayList copyOnWriteArrayList = cVar.f4526l;
        Uri uri = this.f4510h;
        if (lVar2 != lVar4) {
            this.f4519q = null;
            this.f4515m = elapsedRealtime;
            if (uri.equals(cVar.f4532r)) {
                if (cVar.f4533s == null) {
                    cVar.f4534t = !lVar2.f13593o;
                    cVar.f4535u = lVar2.f13586h;
                }
                cVar.f4533s = lVar2;
                ((q1.q) cVar.f4530p).t(lVar2);
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((v) it.next()).a();
            }
        } else if (!lVar2.f13593o) {
            r1.l lVar7 = this.f4513k;
            if (j15 + ((long) r0Var.size()) < lVar7.f13589k) {
                new d
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0109: CONSTRUCTOR  (r1v29 ? I:p1.d) =  call: p1.d.<init>():void type: CONSTRUCTOR in method: d6.b.d(r1.l, v1.r):void, dex: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v29 ?
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 41 more
                    */
                /*
                    this = this;
                    r0 = r20
                    r1 = r21
                    r1.l r2 = r0.f4513k
                    long r3 = android.os.SystemClock.elapsedRealtime()
                    r0.f4514l = r3
                    d6.c r5 = r0.f4520r
                    r5.getClass()
                    boolean r6 = r1.d(r2)
                    d9.r0 r10 = r1.f13596r
                    long r11 = r1.f13589k
                    if (r6 != 0) goto L_0x0029
                    boolean r1 = r1.f13593o
                    if (r1 == 0) goto L_0x0024
                    r1.l r1 = r2.c()
                    goto L_0x0025
                L_0x0024:
                    r1 = r2
                L_0x0025:
                    r7 = r10
                    r9 = 0
                    goto L_0x00b5
                L_0x0029:
                    boolean r6 = r1.f13594p
                    if (r6 == 0) goto L_0x0032
                    long r14 = r1.f13586h
                    r16 = r10
                    goto L_0x0074
                L_0x0032:
                    r1.l r6 = r5.f4533s
                    if (r6 == 0) goto L_0x0039
                    long r14 = r6.f13586h
                    goto L_0x003b
                L_0x0039:
                    r14 = 0
                L_0x003b:
                    if (r2 != 0) goto L_0x0042
                    r16 = r10
                    r18 = r14
                    goto L_0x0072
                L_0x0042:
                    d9.r0 r6 = r2.f13596r
                    int r7 = r6.size()
                    r16 = r10
                    long r9 = r2.f13589k
                    r18 = r14
                    long r13 = r11 - r9
                    int r14 = (int) r13
                    int r13 = r6.size()
                    if (r14 >= r13) goto L_0x005e
                    java.lang.Object r6 = r6.get(r14)
                    r1.i r6 = (r1.i) r6
                    goto L_0x005f
                L_0x005e:
                    r6 = 0
                L_0x005f:
                    if (r6 == 0) goto L_0x0064
                    long r6 = r6.f13570l
                    goto L_0x006d
                L_0x0064:
                    long r6 = (long) r7
                    long r9 = r11 - r9
                    int r13 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
                    if (r13 != 0) goto L_0x0072
                    long r6 = r2.f13599u
                L_0x006d:
                    long r9 = r2.f13586h
                    long r14 = r6 + r9
                    goto L_0x0074
                L_0x0072:
                    r14 = r18
                L_0x0074:
                    boolean r6 = r1.f13587i
                    if (r6 == 0) goto L_0x007e
                    int r6 = r1.f13588j
                L_0x007a:
                    r7 = r16
                    r9 = 0
                    goto L_0x00b1
                L_0x007e:
                    r1.l r6 = r5.f4533s
                    if (r6 == 0) goto L_0x0085
                    int r6 = r6.f13588j
                    goto L_0x0086
                L_0x0085:
                    r6 = 0
                L_0x0086:
                    if (r2 != 0) goto L_0x0089
                    goto L_0x007a
                L_0x0089:
                    long r9 = r2.f13589k
                    long r9 = r11 - r9
                    int r7 = (int) r9
                    d9.r0 r9 = r2.f13596r
                    int r10 = r9.size()
                    if (r7 >= r10) goto L_0x009d
                    java.lang.Object r7 = r9.get(r7)
                    r1.i r7 = (r1.i) r7
                    goto L_0x009e
                L_0x009d:
                    r7 = 0
                L_0x009e:
                    if (r7 == 0) goto L_0x007a
                    int r6 = r2.f13588j
                    int r7 = r7.f13569k
                    int r6 = r6 + r7
                    r7 = r16
                    r9 = 0
                    java.lang.Object r10 = r7.get(r9)
                    r1.i r10 = (r1.i) r10
                    int r10 = r10.f13569k
                    int r6 = r6 - r10
                L_0x00b1:
                    r1.l r1 = r1.b(r6, r14)
                L_0x00b5:
                    r0.f4513k = r1
                    r6 = 1
                    java.util.concurrent.CopyOnWriteArrayList r10 = r5.f4526l
                    android.net.Uri r13 = r0.f4510h
                    r8 = 0
                    if (r1 == r2) goto L_0x00f5
                    r0.f4519q = r8
                    r0.f4515m = r3
                    android.net.Uri r7 = r5.f4532r
                    boolean r7 = r13.equals(r7)
                    if (r7 == 0) goto L_0x00e1
                    r1.l r7 = r5.f4533s
                    if (r7 != 0) goto L_0x00d8
                    boolean r7 = r1.f13593o
                    r7 = r7 ^ r6
                    r5.f4534t = r7
                    long r7 = r1.f13586h
                    r5.f4535u = r7
                L_0x00d8:
                    r5.f4533s = r1
                    r1.w r7 = r5.f4530p
                    q1.q r7 = (q1.q) r7
                    r7.t(r1)
                L_0x00e1:
                    java.util.Iterator r1 = r10.iterator()
                L_0x00e5:
                    boolean r7 = r1.hasNext()
                    if (r7 == 0) goto L_0x0164
                    java.lang.Object r7 = r1.next()
                    r1.v r7 = (r1.v) r7
                    r7.a()
                    goto L_0x00e5
                L_0x00f5:
                    boolean r1 = r1.f13593o
                    if (r1 != 0) goto L_0x0164
                    int r1 = r7.size()
                    long r14 = (long) r1
                    long r11 = r11 + r14
                    r1.l r1 = r0.f4513k
                    long r14 = r1.f13589k
                    int r16 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
                    if (r16 >= 0) goto L_0x010e
                    p1.d r1 = new p1.d
                    r1.<init>()
                    r7 = 1
                    goto L_0x013f
                L_0x010e:
                    long r11 = r0.f4515m
                    long r11 = r3 - r11
                    double r11 = (double) r11
                    long r14 = r1.f13591m
                    long r14 = j1.l0.Q(r14)
                    double r14 = (double) r14
                    r16 = 4615063718147915776(0x400c000000000000, double:3.5)
                    double r14 = r14 * r16
                    int r1 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
                    if (r1 <= 0) goto L_0x013d
                    boolean r1 = r7.isEmpty()
                    if (r1 != 0) goto L_0x013d
                    int r1 = r7.size()
                    int r1 = r1 - r6
                    java.lang.Object r1 = r7.get(r1)
                    r1.i r1 = (r1.i) r1
                    java.lang.String r1 = r1.f13566h
                    if (r1 == 0) goto L_0x013d
                    p1.d r1 = new p1.d
                    r1.<init>()
                    goto L_0x013e
                L_0x013d:
                    r1 = r8
                L_0x013e:
                    r7 = 0
                L_0x013f:
                    if (r1 == 0) goto L_0x0164
                    r0.f4519q = r1
                    j1.z r8 = new j1.z
                    v1.w r11 = new v1.w
                    r12 = 4
                    r11.<init>(r12)
                    r12 = r22
                    r8.<init>((v1.r) r12, (v1.w) r11, (java.io.IOException) r1, (int) r6)
                    java.util.Iterator r1 = r10.iterator()
                L_0x0154:
                    boolean r10 = r1.hasNext()
                    if (r10 == 0) goto L_0x0164
                    java.lang.Object r10 = r1.next()
                    r1.v r10 = (r1.v) r10
                    r10.b(r13, r8, r7)
                    goto L_0x0154
                L_0x0164:
                    r1.l r1 = r0.f4513k
                    r1.k r7 = r1.f13600v
                    boolean r7 = r7.f13581e
                    if (r7 != 0) goto L_0x0175
                    long r7 = r1.f13591m
                    if (r1 == r2) goto L_0x0171
                    goto L_0x0177
                L_0x0171:
                    r1 = 2
                    long r7 = r7 / r1
                    goto L_0x0177
                L_0x0175:
                    r7 = 0
                L_0x0177:
                    long r1 = j1.l0.Q(r7)
                    long r1 = r1 + r3
                    r0.f4516n = r1
                    r1.l r1 = r0.f4513k
                    long r1 = r1.f13592n
                    r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                    int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                    if (r7 != 0) goto L_0x0195
                    android.net.Uri r1 = r5.f4532r
                    boolean r1 = r13.equals(r1)
                    if (r1 == 0) goto L_0x0194
                    goto L_0x0195
                L_0x0194:
                    r6 = 0
                L_0x0195:
                    if (r6 == 0) goto L_0x0211
                    r1.l r1 = r0.f4513k
                    boolean r2 = r1.f13593o
                    if (r2 != 0) goto L_0x0211
                    r1.k r1 = r1.f13600v
                    long r5 = r1.f13577a
                    int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                    if (r2 != 0) goto L_0x01aa
                    boolean r1 = r1.f13581e
                    if (r1 != 0) goto L_0x01aa
                    goto L_0x020e
                L_0x01aa:
                    android.net.Uri$Builder r1 = r13.buildUpon()
                    r1.l r2 = r0.f4513k
                    r1.k r5 = r2.f13600v
                    boolean r5 = r5.f13581e
                    if (r5 == 0) goto L_0x01f2
                    d9.r0 r5 = r2.f13596r
                    int r5 = r5.size()
                    long r5 = (long) r5
                    long r7 = r2.f13589k
                    long r7 = r7 + r5
                    java.lang.String r2 = "_HLS_msn"
                    java.lang.String r5 = java.lang.String.valueOf(r7)
                    r1.appendQueryParameter(r2, r5)
                    r1.l r2 = r0.f4513k
                    long r5 = r2.f13592n
                    int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                    if (r7 == 0) goto L_0x01f2
                    d9.r0 r2 = r2.f13597s
                    int r5 = r2.size()
                    boolean r6 = r2.isEmpty()
                    if (r6 != 0) goto L_0x01e9
                    java.lang.Object r2 = d9.v0.a(r2)
                    r1.g r2 = (r1.g) r2
                    boolean r2 = r2.f13560t
                    if (r2 == 0) goto L_0x01e9
                    int r5 = r5 + -1
                L_0x01e9:
                    java.lang.String r2 = "_HLS_part"
                    java.lang.String r5 = java.lang.String.valueOf(r5)
                    r1.appendQueryParameter(r2, r5)
                L_0x01f2:
                    r1.l r2 = r0.f4513k
                    r1.k r2 = r2.f13600v
                    long r5 = r2.f13577a
                    int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                    if (r7 == 0) goto L_0x020a
                    boolean r2 = r2.f13578b
                    if (r2 == 0) goto L_0x0203
                    java.lang.String r2 = "v2"
                    goto L_0x0205
                L_0x0203:
                    java.lang.String r2 = "YES"
                L_0x0205:
                    java.lang.String r3 = "_HLS_skip"
                    r1.appendQueryParameter(r3, r2)
                L_0x020a:
                    android.net.Uri r13 = r1.build()
                L_0x020e:
                    r0.c(r13)
                L_0x0211:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: d6.b.d(r1.l, v1.r):void");
            }

            public final k h(a2.n nVar, long j10, long j11, IOException iOException, int i10) {
                boolean z10;
                k kVar;
                int i11;
                s sVar = (s) nVar;
                long j12 = sVar.f77a;
                Uri uri = sVar.f80d.f8992c;
                r rVar = new r();
                boolean z11 = false;
                if (uri.getQueryParameter("_HLS_msn") != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z12 = iOException instanceof d;
                Uri uri2 = this.f4510h;
                c cVar = this.f4520r;
                int i12 = sVar.f79c;
                if (z10 || z12) {
                    if (iOException instanceof z) {
                        i11 = ((z) iOException).f9070k;
                    } else {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (z12 || i11 == 400 || i11 == 503) {
                        this.f4516n = SystemClock.elapsedRealtime();
                        c(uri2);
                        f0 f0Var = cVar.f4527m;
                        int i13 = l0.f8453a;
                        f0Var.k(rVar, i12, iOException, true);
                        return q.f72e;
                    }
                }
                j1.z zVar = new j1.z(rVar, new w(i12), iOException, i10);
                Iterator it = cVar.f4526l.iterator();
                boolean z13 = false;
                while (it.hasNext()) {
                    z13 |= !((v) it.next()).b(uri2, zVar, false);
                }
                i iVar = cVar.f4524j;
                if (z13) {
                    iVar.getClass();
                    long c10 = i.c(zVar);
                    if (c10 != -9223372036854775807L) {
                        kVar = q.b(c10, false);
                    } else {
                        kVar = q.f73f;
                    }
                } else {
                    kVar = q.f72e;
                }
                int i14 = kVar.f59a;
                if (i14 == 0 || i14 == 1) {
                    z11 = true;
                }
                boolean z14 = !z11;
                cVar.f4527m.k(rVar, i12, iOException, z14);
                if (!z14) {
                    return kVar;
                }
                iVar.getClass();
                return kVar;
            }

            public final void l(a2.n nVar, long j10, long j11, boolean z10) {
                s sVar = (s) nVar;
                long j12 = sVar.f77a;
                Uri uri = sVar.f80d.f8992c;
                r rVar = new r();
                c cVar = this.f4520r;
                cVar.f4524j.getClass();
                cVar.f4527m.d(rVar);
            }

            public final void n(a2.n nVar, long j10, long j11) {
                s sVar = (s) nVar;
                p pVar = (p) sVar.f82f;
                Uri uri = sVar.f80d.f8992c;
                r rVar = new r();
                if (pVar instanceof r1.l) {
                    d((r1.l) pVar, rVar);
                    this.f4520r.f4527m.g(rVar);
                } else {
                    b1 b10 = b1.b("Loaded playlist has unexpected type.");
                    this.f4519q = b10;
                    this.f4520r.f4527m.k(rVar, 4, b10, true);
                }
                this.f4520r.f4524j.getClass();
            }
        }
