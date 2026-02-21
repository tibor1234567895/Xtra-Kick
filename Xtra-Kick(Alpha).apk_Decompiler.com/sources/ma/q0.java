package ma;

import eb.j;
import java.util.Iterator;
import la.v;
import pa.e;
import ra.h;
import wa.p;

public final class q0 extends h implements p {

    /* renamed from: i  reason: collision with root package name */
    public Object f10827i;

    /* renamed from: j  reason: collision with root package name */
    public Iterator f10828j;

    /* renamed from: k  reason: collision with root package name */
    public int f10829k;

    /* renamed from: l  reason: collision with root package name */
    public int f10830l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f10831m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f10832n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f10833o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Iterator f10834p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f10835q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f10836r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q0(int i10, int i11, Iterator it, boolean z10, boolean z11, e eVar) {
        super(eVar);
        this.f10832n = i10;
        this.f10833o = i11;
        this.f10834p = it;
        this.f10835q = z10;
        this.f10836r = z11;
    }

    public final e create(Object obj, e eVar) {
        q0 q0Var = new q0(this.f10832n, this.f10833o, this.f10834p, this.f10835q, this.f10836r, eVar);
        q0Var.f10831m = obj;
        return q0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((q0) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x00b6 A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f10830l
            r3 = 0
            r4 = 0
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            if (r2 == 0) goto L_0x005a
            if (r2 == r9) goto L_0x0047
            if (r2 == r8) goto L_0x0042
            if (r2 == r7) goto L_0x0031
            if (r2 == r6) goto L_0x0022
            if (r2 != r5) goto L_0x001a
            goto L_0x0042
        L_0x001a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0022:
            java.lang.Object r2 = r0.f10827i
            ma.m0 r2 = (ma.m0) r2
            java.lang.Object r4 = r0.f10831m
            eb.j r4 = (eb.j) r4
            hb.h0.O1(r18)
            r11 = r0
            r12 = r1
            goto L_0x018d
        L_0x0031:
            java.util.Iterator r2 = r0.f10828j
            java.lang.Object r8 = r0.f10827i
            ma.m0 r8 = (ma.m0) r8
            java.lang.Object r10 = r0.f10831m
            eb.j r10 = (eb.j) r10
            hb.h0.O1(r18)
            r11 = r0
            r12 = r1
            goto L_0x0159
        L_0x0042:
            hb.h0.O1(r18)
            goto L_0x01a8
        L_0x0047:
            int r2 = r0.f10829k
            java.util.Iterator r4 = r0.f10828j
            java.lang.Object r5 = r0.f10827i
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r6 = r0.f10831m
            eb.j r6 = (eb.j) r6
            hb.h0.O1(r18)
            r7 = r0
            r10 = r1
            r12 = r2
            goto L_0x00a4
        L_0x005a:
            hb.h0.O1(r18)
            java.lang.Object r2 = r0.f10831m
            eb.j r2 = (eb.j) r2
            int r10 = r0.f10832n
            r11 = 1024(0x400, float:1.435E-42)
            if (r10 <= r11) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r11 = r10
        L_0x0069:
            int r12 = r0.f10833o
            int r12 = r12 - r10
            java.util.Iterator r10 = r0.f10834p
            if (r12 < 0) goto L_0x00d5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r11)
            r7 = r0
            r6 = r2
            r4 = r10
            r2 = 0
            r10 = r1
        L_0x007a:
            boolean r11 = r4.hasNext()
            int r13 = r7.f10832n
            if (r11 == 0) goto L_0x00b6
            java.lang.Object r11 = r4.next()
            if (r2 <= 0) goto L_0x008b
            int r2 = r2 + -1
            goto L_0x007a
        L_0x008b:
            r5.add(r11)
            int r11 = r5.size()
            if (r11 != r13) goto L_0x007a
            r7.f10831m = r6
            r7.f10827i = r5
            r7.f10828j = r4
            r7.f10829k = r12
            r7.f10830l = r9
            r6.a(r5, r7)
            if (r1 != r10) goto L_0x00a4
            return r10
        L_0x00a4:
            boolean r2 = r7.f10835q
            if (r2 == 0) goto L_0x00ac
            r5.clear()
            goto L_0x00b4
        L_0x00ac:
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = r7.f10832n
            r2.<init>(r5)
            r5 = r2
        L_0x00b4:
            r2 = r12
            goto L_0x007a
        L_0x00b6:
            boolean r2 = r5.isEmpty()
            r2 = r2 ^ r9
            if (r2 == 0) goto L_0x01a8
            boolean r2 = r7.f10836r
            if (r2 != 0) goto L_0x00c7
            int r2 = r5.size()
            if (r2 != r13) goto L_0x01a8
        L_0x00c7:
            r7.f10831m = r3
            r7.f10827i = r3
            r7.f10828j = r3
            r7.f10830l = r8
            r6.a(r5, r7)
            if (r1 != r10) goto L_0x01a8
            return r10
        L_0x00d5:
            ma.m0 r8 = new ma.m0
            java.lang.Object[] r11 = new java.lang.Object[r11]
            r8.<init>(r4, r11)
            r11 = r0
            r12 = r1
            r16 = r10
            r10 = r2
            r2 = r16
        L_0x00e3:
            boolean r13 = r2.hasNext()
            if (r13 == 0) goto L_0x0168
            java.lang.Object r13 = r2.next()
            int r14 = r8.a()
            int r15 = r8.f10824j
            if (r14 != r15) goto L_0x00f7
            r14 = 1
            goto L_0x00f8
        L_0x00f7:
            r14 = 0
        L_0x00f8:
            if (r14 != 0) goto L_0x0160
            int r14 = r8.f10825k
            int r4 = r8.f10826l
            int r14 = r14 + r4
            int r14 = r14 % r15
            java.lang.Object[] r15 = r8.f10823i
            r15[r14] = r13
            int r4 = r4 + 1
            r8.f10826l = r4
            int r4 = r8.a()
            int r13 = r8.f10824j
            if (r4 != r13) goto L_0x0112
            r4 = 1
            goto L_0x0113
        L_0x0112:
            r4 = 0
        L_0x0113:
            if (r4 == 0) goto L_0x015e
            int r4 = r8.f10826l
            int r14 = r11.f10832n
            if (r4 >= r14) goto L_0x0140
            int r4 = r13 >> 1
            int r13 = r13 + r4
            int r13 = r13 + r9
            if (r13 <= r14) goto L_0x0122
            goto L_0x0123
        L_0x0122:
            r14 = r13
        L_0x0123:
            int r4 = r8.f10825k
            if (r4 != 0) goto L_0x0131
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r15, r14)
            java.lang.String r13 = "copyOf(this, newSize)"
            xa.j.e(r13, r4)
            goto L_0x0137
        L_0x0131:
            java.lang.Object[] r4 = new java.lang.Object[r14]
            java.lang.Object[] r4 = r8.toArray(r4)
        L_0x0137:
            ma.m0 r13 = new ma.m0
            int r8 = r8.f10826l
            r13.<init>(r8, r4)
            r8 = r13
            goto L_0x015e
        L_0x0140:
            boolean r4 = r11.f10835q
            if (r4 == 0) goto L_0x0146
            r4 = r8
            goto L_0x014b
        L_0x0146:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r8)
        L_0x014b:
            r11.f10831m = r10
            r11.f10827i = r8
            r11.f10828j = r2
            r11.f10830l = r7
            r10.a(r4, r11)
            if (r1 != r12) goto L_0x0159
            return r12
        L_0x0159:
            int r4 = r11.f10833o
            r8.b(r4)
        L_0x015e:
            r4 = 0
            goto L_0x00e3
        L_0x0160:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "ring buffer is full"
            r1.<init>(r2)
            throw r1
        L_0x0168:
            boolean r2 = r11.f10836r
            if (r2 == 0) goto L_0x01a8
            r2 = r8
            r4 = r10
        L_0x016e:
            int r7 = r2.f10826l
            int r8 = r11.f10833o
            if (r7 <= r8) goto L_0x0193
            boolean r7 = r11.f10835q
            if (r7 == 0) goto L_0x017a
            r7 = r2
            goto L_0x017f
        L_0x017a:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>(r2)
        L_0x017f:
            r11.f10831m = r4
            r11.f10827i = r2
            r11.f10828j = r3
            r11.f10830l = r6
            r4.a(r7, r11)
            if (r1 != r12) goto L_0x018d
            return r12
        L_0x018d:
            int r7 = r11.f10833o
            r2.b(r7)
            goto L_0x016e
        L_0x0193:
            boolean r6 = r2.isEmpty()
            r6 = r6 ^ r9
            if (r6 == 0) goto L_0x01a8
            r11.f10831m = r3
            r11.f10827i = r3
            r11.f10828j = r3
            r11.f10830l = r5
            r4.a(r2, r11)
            if (r1 != r12) goto L_0x01a8
            return r12
        L_0x01a8:
            la.v r1 = la.v.f9814a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.q0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
