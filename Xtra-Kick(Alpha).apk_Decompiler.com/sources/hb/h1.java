package hb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import la.v;
import pa.e;
import pa.k;
import ra.i;
import wa.a;
import wa.p;

public final class h1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f7805i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ a f7806j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h1(a aVar, e eVar) {
        super(2, eVar);
        this.f7806j = aVar;
    }

    public final e create(Object obj, e eVar) {
        h1 h1Var = new h1(this.f7806j, eVar);
        h1Var.f7805i = obj;
        return h1Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((h1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:579)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:485)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:205)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
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
        */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            hb.h0.O1(r5)
            java.lang.Object r5 = r4.f7805i
            hb.f0 r5 = (hb.f0) r5
            pa.k r5 = r5.v()
            wa.a r0 = r4.f7806j
            hb.g2 r1 = new hb.g2     // Catch:{ InterruptedException -> 0x0047 }
            hb.l1 r5 = hb.h0.u0(r5)     // Catch:{ InterruptedException -> 0x0047 }
            r1.<init>(r5)     // Catch:{ InterruptedException -> 0x0047 }
            hb.u1 r5 = (hb.u1) r5     // Catch:{ InterruptedException -> 0x0047 }
            r2 = 1
            hb.q0 r5 = r5.M(r2, r2, r1)     // Catch:{ InterruptedException -> 0x0047 }
            r1.f7799i = r5     // Catch:{ InterruptedException -> 0x0047 }
        L_0x001f:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = hb.g2.f7797j     // Catch:{ InterruptedException -> 0x0047 }
            int r2 = r5.get(r1)     // Catch:{ InterruptedException -> 0x0047 }
            if (r2 == 0) goto L_0x0033
            r5 = 2
            if (r2 == r5) goto L_0x003a
            r5 = 3
            if (r2 != r5) goto L_0x002e
            goto L_0x003a
        L_0x002e:
            hb.g2.c(r2)     // Catch:{ InterruptedException -> 0x0047 }
            r5 = 0
            throw r5     // Catch:{ InterruptedException -> 0x0047 }
        L_0x0033:
            r3 = 0
            boolean r5 = r5.compareAndSet(r1, r2, r3)     // Catch:{ InterruptedException -> 0x0047 }
            if (r5 == 0) goto L_0x001f
        L_0x003a:
            java.lang.Object r5 = r0.b()     // Catch:{ all -> 0x0042 }
            r1.a()     // Catch:{ InterruptedException -> 0x0047 }
            return r5
        L_0x0042:
            r5 = move-exception
            r1.a()     // Catch:{ InterruptedException -> 0x0047 }
            throw r5     // Catch:{ InterruptedException -> 0x0047 }
        L_0x0047:
            r5 = move-exception
            java.util.concurrent.CancellationException r0 = new java.util.concurrent.CancellationException
            java.lang.String r1 = "Blocking call was interrupted due to parent cancellation"
            r0.<init>(r1)
            java.lang.Throwable r5 = r0.initCause(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
