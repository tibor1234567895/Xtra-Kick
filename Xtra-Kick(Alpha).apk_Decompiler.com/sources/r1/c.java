package r1;

import a2.i;
import a2.k;
import a2.l;
import a2.n;
import a2.q;
import a2.s;
import android.net.Uri;
import android.os.SystemClock;
import g.r0;
import g1.b1;
import j1.l0;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k1.h;
import k1.z;
import p1.d;
import v1.f0;
import v1.r;
import v1.w;

public final class c implements l {

    /* renamed from: h  reason: collision with root package name */
    public final Uri f13531h;

    /* renamed from: i  reason: collision with root package name */
    public final q f13532i = new q("DefaultHlsPlaylistTracker:MediaPlaylist");

    /* renamed from: j  reason: collision with root package name */
    public final h f13533j;

    /* renamed from: k  reason: collision with root package name */
    public l f13534k;

    /* renamed from: l  reason: collision with root package name */
    public long f13535l;

    /* renamed from: m  reason: collision with root package name */
    public long f13536m;

    /* renamed from: n  reason: collision with root package name */
    public long f13537n;

    /* renamed from: o  reason: collision with root package name */
    public long f13538o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f13539p;

    /* renamed from: q  reason: collision with root package name */
    public IOException f13540q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ d f13541r;

    public c(d dVar, Uri uri) {
        this.f13541r = dVar;
        this.f13531h = uri;
        this.f13533j = dVar.f13543h.a();
    }

    public static boolean a(c cVar, long j10) {
        boolean z10;
        cVar.f13538o = SystemClock.elapsedRealtime() + j10;
        d dVar = cVar.f13541r;
        if (!cVar.f13531h.equals(dVar.f13553r)) {
            return false;
        }
        List list = dVar.f13552q.f13612e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                z10 = false;
                break;
            }
            c cVar2 = (c) dVar.f13546k.get(((n) list.get(i10)).f13604a);
            cVar2.getClass();
            if (elapsedRealtime > cVar2.f13538o) {
                Uri uri = cVar2.f13531h;
                dVar.f13553r = uri;
                cVar2.c(dVar.p(uri));
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
        d dVar = this.f13541r;
        s sVar = new s(this.f13533j, uri, dVar.f13544i.a(dVar.f13552q, this.f13534k));
        i iVar = dVar.f13545j;
        int i10 = sVar.f79c;
        this.f13532i.g(sVar, this, iVar.b(i10));
        dVar.f13548m.m(new r(sVar.f78b), i10);
    }

    public final void c(Uri uri) {
        this.f13538o = 0;
        if (!this.f13539p) {
            q qVar = this.f13532i;
            if (!qVar.d() && !qVar.c()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j10 = this.f13537n;
                if (elapsedRealtime < j10) {
                    this.f13539p = true;
                    this.f13541r.f13550o.postDelayed(new r0(this, 13, uri), j10 - elapsedRealtime);
                    return;
                }
                b(uri);
            }
        }
    }

    public final void d(l lVar, r rVar) {
        d9.r0 r0Var;
        l lVar2;
        long j10;
        String str;
        boolean z10;
        IOException iOException;
        d9.r0 r0Var2;
        long j11;
        int i10;
        i iVar;
        long j12;
        long j13;
        i iVar2;
        long j14;
        l lVar3 = lVar;
        l lVar4 = this.f13534k;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f13535l = elapsedRealtime;
        d dVar = this.f13541r;
        dVar.getClass();
        boolean d10 = lVar3.d(lVar4);
        d9.r0 r0Var3 = lVar3.f13596r;
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
                l lVar5 = dVar.f13554s;
                if (lVar5 != null) {
                    j12 = lVar5.f13586h;
                } else {
                    j12 = 0;
                }
                if (lVar4 == null) {
                    r0Var2 = r0Var3;
                    j13 = j12;
                } else {
                    d9.r0 r0Var4 = lVar4.f13596r;
                    int size = r0Var4.size();
                    r0Var2 = r0Var3;
                    long j16 = lVar4.f13589k;
                    j13 = j12;
                    int i11 = (int) (j15 - j16);
                    if (i11 < r0Var4.size()) {
                        iVar2 = (i) r0Var4.get(i11);
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
                l lVar6 = dVar.f13554s;
                if (lVar6 != null) {
                    i10 = lVar6.f13588j;
                } else {
                    i10 = 0;
                }
                if (lVar4 != null) {
                    int i12 = (int) (j15 - lVar4.f13589k);
                    d9.r0 r0Var5 = lVar4.f13596r;
                    if (i12 < r0Var5.size()) {
                        iVar = (i) r0Var5.get(i12);
                    } else {
                        iVar = null;
                    }
                    if (iVar != null) {
                        int i13 = lVar4.f13588j + iVar.f13569k;
                        r0Var = r0Var2;
                        i10 = i13 - ((i) r0Var.get(0)).f13569k;
                        lVar2 = lVar3.b(i10, j11);
                    }
                }
            }
            r0Var = r0Var2;
            lVar2 = lVar3.b(i10, j11);
        }
        this.f13534k = lVar2;
        boolean z11 = true;
        CopyOnWriteArrayList copyOnWriteArrayList = dVar.f13547l;
        Uri uri = this.f13531h;
        if (lVar2 != lVar4) {
            this.f13540q = null;
            this.f13536m = elapsedRealtime;
            if (uri.equals(dVar.f13553r)) {
                if (dVar.f13554s == null) {
                    dVar.f13555t = !lVar2.f13593o;
                    dVar.f13556u = lVar2.f13586h;
                }
                dVar.f13554s = lVar2;
                ((q1.q) dVar.f13551p).t(lVar2);
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((v) it.next()).a();
            }
        } else if (!lVar2.f13593o) {
            l lVar7 = this.f13534k;
            if (j15 + ((long) r0Var.size()) < lVar7.f13589k) {
                new d
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0109: CONSTRUCTOR  (r1v23 ? I:p1.d) =  call: p1.d.<init>():void type: CONSTRUCTOR in method: r1.c.d(r1.l, v1.r):void, dex: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v23 ?
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
                    r1.l r2 = r0.f13534k
                    long r3 = android.os.SystemClock.elapsedRealtime()
                    r0.f13535l = r3
                    r1.d r5 = r0.f13541r
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
                    r1.l r6 = r5.f13554s
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
                    r1.l r6 = r5.f13554s
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
                    r0.f13534k = r1
                    r6 = 1
                    java.util.concurrent.CopyOnWriteArrayList r10 = r5.f13547l
                    android.net.Uri r13 = r0.f13531h
                    r8 = 0
                    if (r1 == r2) goto L_0x00f5
                    r0.f13540q = r8
                    r0.f13536m = r3
                    android.net.Uri r7 = r5.f13553r
                    boolean r7 = r13.equals(r7)
                    if (r7 == 0) goto L_0x00e1
                    r1.l r7 = r5.f13554s
                    if (r7 != 0) goto L_0x00d8
                    boolean r7 = r1.f13593o
                    r7 = r7 ^ r6
                    r5.f13555t = r7
                    long r7 = r1.f13586h
                    r5.f13556u = r7
                L_0x00d8:
                    r5.f13554s = r1
                    r1.w r7 = r5.f13551p
                    q1.q r7 = (q1.q) r7
                    r7.t(r1)
                L_0x00e1:
                    java.util.Iterator r1 = r10.iterator()
                L_0x00e5:
                    boolean r7 = r1.hasNext()
                    if (r7 == 0) goto L_0x014f
                    java.lang.Object r7 = r1.next()
                    r1.v r7 = (r1.v) r7
                    r7.a()
                    goto L_0x00e5
                L_0x00f5:
                    boolean r1 = r1.f13593o
                    if (r1 != 0) goto L_0x014f
                    int r1 = r7.size()
                    long r14 = (long) r1
                    long r11 = r11 + r14
                    r1.l r1 = r0.f13534k
                    long r14 = r1.f13589k
                    int r7 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
                    if (r7 >= 0) goto L_0x010e
                    p1.d r1 = new p1.d
                    r1.<init>()
                    r7 = 1
                    goto L_0x012a
                L_0x010e:
                    long r11 = r0.f13536m
                    long r11 = r3 - r11
                    double r11 = (double) r11
                    long r14 = r1.f13591m
                    long r14 = j1.l0.Q(r14)
                    double r14 = (double) r14
                    r16 = 4615063718147915776(0x400c000000000000, double:3.5)
                    double r14 = r14 * r16
                    int r1 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
                    if (r1 <= 0) goto L_0x0128
                    p1.d r1 = new p1.d
                    r1.<init>()
                    goto L_0x0129
                L_0x0128:
                    r1 = r8
                L_0x0129:
                    r7 = 0
                L_0x012a:
                    if (r1 == 0) goto L_0x014f
                    r0.f13540q = r1
                    j1.z r8 = new j1.z
                    v1.w r11 = new v1.w
                    r12 = 4
                    r11.<init>(r12)
                    r12 = r22
                    r8.<init>((v1.r) r12, (v1.w) r11, (java.io.IOException) r1, (int) r6)
                    java.util.Iterator r1 = r10.iterator()
                L_0x013f:
                    boolean r10 = r1.hasNext()
                    if (r10 == 0) goto L_0x014f
                    java.lang.Object r10 = r1.next()
                    r1.v r10 = (r1.v) r10
                    r10.b(r13, r8, r7)
                    goto L_0x013f
                L_0x014f:
                    r1.l r1 = r0.f13534k
                    r1.k r7 = r1.f13600v
                    boolean r7 = r7.f13581e
                    if (r7 != 0) goto L_0x0160
                    long r7 = r1.f13591m
                    if (r1 == r2) goto L_0x015c
                    goto L_0x0162
                L_0x015c:
                    r1 = 2
                    long r7 = r7 / r1
                    goto L_0x0162
                L_0x0160:
                    r7 = 0
                L_0x0162:
                    long r1 = j1.l0.Q(r7)
                    long r1 = r1 + r3
                    r0.f13537n = r1
                    r1.l r1 = r0.f13534k
                    long r1 = r1.f13592n
                    r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                    int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                    if (r7 != 0) goto L_0x0180
                    android.net.Uri r1 = r5.f13553r
                    boolean r1 = r13.equals(r1)
                    if (r1 == 0) goto L_0x017f
                    goto L_0x0180
                L_0x017f:
                    r6 = 0
                L_0x0180:
                    if (r6 == 0) goto L_0x01fc
                    r1.l r1 = r0.f13534k
                    boolean r2 = r1.f13593o
                    if (r2 != 0) goto L_0x01fc
                    r1.k r1 = r1.f13600v
                    long r5 = r1.f13577a
                    int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                    if (r2 != 0) goto L_0x0195
                    boolean r1 = r1.f13581e
                    if (r1 != 0) goto L_0x0195
                    goto L_0x01f9
                L_0x0195:
                    android.net.Uri$Builder r1 = r13.buildUpon()
                    r1.l r2 = r0.f13534k
                    r1.k r5 = r2.f13600v
                    boolean r5 = r5.f13581e
                    if (r5 == 0) goto L_0x01dd
                    d9.r0 r5 = r2.f13596r
                    int r5 = r5.size()
                    long r5 = (long) r5
                    long r7 = r2.f13589k
                    long r7 = r7 + r5
                    java.lang.String r2 = "_HLS_msn"
                    java.lang.String r5 = java.lang.String.valueOf(r7)
                    r1.appendQueryParameter(r2, r5)
                    r1.l r2 = r0.f13534k
                    long r5 = r2.f13592n
                    int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                    if (r7 == 0) goto L_0x01dd
                    d9.r0 r2 = r2.f13597s
                    int r5 = r2.size()
                    boolean r6 = r2.isEmpty()
                    if (r6 != 0) goto L_0x01d4
                    java.lang.Object r2 = d9.v0.a(r2)
                    r1.g r2 = (r1.g) r2
                    boolean r2 = r2.f13560t
                    if (r2 == 0) goto L_0x01d4
                    int r5 = r5 + -1
                L_0x01d4:
                    java.lang.String r2 = "_HLS_part"
                    java.lang.String r5 = java.lang.String.valueOf(r5)
                    r1.appendQueryParameter(r2, r5)
                L_0x01dd:
                    r1.l r2 = r0.f13534k
                    r1.k r2 = r2.f13600v
                    long r5 = r2.f13577a
                    int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                    if (r7 == 0) goto L_0x01f5
                    boolean r2 = r2.f13578b
                    if (r2 == 0) goto L_0x01ee
                    java.lang.String r2 = "v2"
                    goto L_0x01f0
                L_0x01ee:
                    java.lang.String r2 = "YES"
                L_0x01f0:
                    java.lang.String r3 = "_HLS_skip"
                    r1.appendQueryParameter(r3, r2)
                L_0x01f5:
                    android.net.Uri r13 = r1.build()
                L_0x01f9:
                    r0.c(r13)
                L_0x01fc:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: r1.c.d(r1.l, v1.r):void");
            }

            public final k h(n nVar, long j10, long j11, IOException iOException, int i10) {
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
                boolean z12 = iOException instanceof q;
                Uri uri2 = this.f13531h;
                d dVar = this.f13541r;
                int i12 = sVar.f79c;
                if (z10 || z12) {
                    if (iOException instanceof z) {
                        i11 = ((z) iOException).f9070k;
                    } else {
                        i11 = Integer.MAX_VALUE;
                    }
                    if (z12 || i11 == 400 || i11 == 503) {
                        this.f13537n = SystemClock.elapsedRealtime();
                        c(uri2);
                        f0 f0Var = dVar.f13548m;
                        int i13 = l0.f8453a;
                        f0Var.k(rVar, i12, iOException, true);
                        return q.f72e;
                    }
                }
                j1.z zVar = new j1.z(rVar, new w(i12), iOException, i10);
                Iterator it = dVar.f13547l.iterator();
                boolean z13 = false;
                while (it.hasNext()) {
                    z13 |= !((v) it.next()).b(uri2, zVar, false);
                }
                i iVar = dVar.f13545j;
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
                dVar.f13548m.k(rVar, i12, iOException, z14);
                if (!z14) {
                    return kVar;
                }
                iVar.getClass();
                return kVar;
            }

            public final void l(n nVar, long j10, long j11, boolean z10) {
                s sVar = (s) nVar;
                long j12 = sVar.f77a;
                Uri uri = sVar.f80d.f8992c;
                r rVar = new r();
                d dVar = this.f13541r;
                dVar.f13545j.getClass();
                dVar.f13548m.d(rVar);
            }

            public final void n(n nVar, long j10, long j11) {
                s sVar = (s) nVar;
                p pVar = (p) sVar.f82f;
                Uri uri = sVar.f80d.f8992c;
                r rVar = new r();
                if (pVar instanceof l) {
                    d((l) pVar, rVar);
                    this.f13541r.f13548m.g(rVar);
                } else {
                    b1 b10 = b1.b("Loaded playlist has unexpected type.");
                    this.f13540q = b10;
                    this.f13541r.f13548m.k(rVar, 4, b10, true);
                }
                this.f13541r.f13545j.getClass();
            }
        }
