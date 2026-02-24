package d5;

import android.support.v4.media.session.u;
import android.util.Log;
import b5.n;
import b5.p;
import com.bumptech.glide.load.data.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import l0.d;
import p5.c;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final Class f4458a;

    /* renamed from: b  reason: collision with root package name */
    public final List f4459b;

    /* renamed from: c  reason: collision with root package name */
    public final c f4460c;

    /* renamed from: d  reason: collision with root package name */
    public final d f4461d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4462e;

    public o(Class cls, Class cls2, Class cls3, List list, c cVar, u uVar) {
        this.f4458a = cls;
        this.f4459b = list;
        this.f4460c = cVar;
        this.f4461d = uVar;
        this.f4462e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: d5.q0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: d5.n0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: d5.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: d5.q0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: d5.q0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final d5.o0 a(int r18, int r19, android.support.v4.media.n r20, b5.n r21, com.bumptech.glide.load.data.g r22) {
        /*
            r17 = this;
            r7 = r17
            r0 = r20
            l0.d r8 = r7.f4461d
            java.lang.Object r1 = r8.j()
            w5.n.b(r1)
            r9 = r1
            java.util.List r9 = (java.util.List) r9
            r1 = r17
            r2 = r22
            r3 = r18
            r4 = r19
            r5 = r21
            r6 = r9
            d5.o0 r1 = r1.b(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0135 }
            r8.e(r9)
            java.lang.Object r2 = r0.f338j
            d5.n r2 = (d5.n) r2
            java.lang.Object r0 = r0.f337i
            b5.a r0 = (b5.a) r0
            r2.getClass()
            java.lang.Object r3 = r1.get()
            java.lang.Class r15 = r3.getClass()
            b5.a r3 = b5.a.RESOURCE_DISK_CACHE
            d5.i r4 = r2.f4434h
            r5 = 0
            if (r0 == r3) goto L_0x004c
            b5.r r3 = r4.f(r15)
            com.bumptech.glide.h r6 = r2.f4441o
            int r8 = r2.f4445s
            int r9 = r2.f4446t
            d5.o0 r6 = r3.a(r6, r1, r8, r9)
            r14 = r3
            goto L_0x004e
        L_0x004c:
            r6 = r1
            r14 = r5
        L_0x004e:
            boolean r3 = r1.equals(r6)
            if (r3 != 0) goto L_0x0057
            r1.e()
        L_0x0057:
            com.bumptech.glide.h r1 = r4.f4394c
            com.bumptech.glide.n r1 = r1.b()
            r5.i r1 = r1.f3296d
            java.lang.Class r3 = r6.d()
            b5.q r1 = r1.a(r3)
            r3 = 0
            r13 = 1
            if (r1 == 0) goto L_0x006d
            r1 = 1
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            if (r1 == 0) goto L_0x0096
            com.bumptech.glide.h r1 = r4.f4394c
            com.bumptech.glide.n r1 = r1.b()
            r1.getClass()
            java.lang.Class r5 = r6.d()
            r5.i r1 = r1.f3296d
            b5.q r5 = r1.a(r5)
            if (r5 == 0) goto L_0x008c
            b5.n r1 = r2.f4448v
            b5.c r1 = r5.g(r1)
            goto L_0x0098
        L_0x008c:
            com.bumptech.glide.m r0 = new com.bumptech.glide.m
            java.lang.Class r1 = r6.d()
            r0.<init>((int) r13, (java.lang.Class) r1)
            throw r0
        L_0x0096:
            b5.c r1 = b5.c.NONE
        L_0x0098:
            b5.j r8 = r2.C
            java.util.ArrayList r9 = r4.b()
            int r10 = r9.size()
            r11 = 0
        L_0x00a3:
            if (r11 >= r10) goto L_0x00b8
            java.lang.Object r12 = r9.get(r11)
            h5.h0 r12 = (h5.h0) r12
            b5.j r12 = r12.f7575a
            boolean r12 = r12.equals(r8)
            if (r12 == 0) goto L_0x00b5
            r8 = 1
            goto L_0x00b9
        L_0x00b5:
            int r11 = r11 + 1
            goto L_0x00a3
        L_0x00b8:
            r8 = 0
        L_0x00b9:
            r8 = r8 ^ r13
            d5.u r9 = r2.f4447u
            boolean r0 = r9.d(r8, r0, r1)
            if (r0 == 0) goto L_0x012c
            if (r5 == 0) goto L_0x011d
            int r0 = r1.ordinal()
            if (r0 == 0) goto L_0x00f8
            if (r0 != r13) goto L_0x00e4
            d5.q0 r0 = new d5.q0
            com.bumptech.glide.h r1 = r4.f4394c
            e5.k r9 = r1.f3188a
            b5.j r10 = r2.C
            b5.j r11 = r2.f4442p
            int r12 = r2.f4445s
            int r1 = r2.f4446t
            b5.n r4 = r2.f4448v
            r8 = r0
            r13 = r1
            r16 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x0101
        L_0x00e4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unknown strategy: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x00f8:
            d5.f r0 = new d5.f
            b5.j r1 = r2.C
            b5.j r4 = r2.f4442p
            r0.<init>(r1, r4)
        L_0x0101:
            android.support.v4.media.session.u r1 = d5.n0.f4453l
            java.lang.Object r1 = r1.j()
            d5.n0 r1 = (d5.n0) r1
            w5.n.b(r1)
            r1.f4457k = r3
            r3 = 1
            r1.f4456j = r3
            r1.f4455i = r6
            d5.k r2 = r2.f4439m
            r2.f4416a = r0
            r2.f4417b = r5
            r2.f4418c = r1
            r6 = r1
            goto L_0x012c
        L_0x011d:
            r3 = 1
            com.bumptech.glide.m r0 = new com.bumptech.glide.m
            java.lang.Object r1 = r6.get()
            java.lang.Class r1 = r1.getClass()
            r0.<init>((int) r3, (java.lang.Class) r1)
            throw r0
        L_0x012c:
            p5.c r0 = r7.f4460c
            r1 = r21
            d5.o0 r0 = r0.d(r6, r1)
            return r0
        L_0x0135:
            r0 = move-exception
            r1 = r0
            r8.e(r9)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.o.a(int, int, android.support.v4.media.n, b5.n, com.bumptech.glide.load.data.g):d5.o0");
    }

    public final o0 b(g gVar, int i10, int i11, n nVar, List list) {
        List list2 = this.f4459b;
        int size = list2.size();
        o0 o0Var = null;
        for (int i12 = 0; i12 < size; i12++) {
            p pVar = (p) list2.get(i12);
            try {
                if (pVar.a(gVar.e(), nVar)) {
                    o0Var = pVar.b(gVar.e(), i10, i11, nVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Objects.toString(pVar);
                }
                list.add(e10);
            }
            if (o0Var != null) {
                break;
            }
        }
        if (o0Var != null) {
            return o0Var;
        }
        throw new i0(this.f4462e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f4458a + ", decoders=" + this.f4459b + ", transcoder=" + this.f4460c + '}';
    }
}
