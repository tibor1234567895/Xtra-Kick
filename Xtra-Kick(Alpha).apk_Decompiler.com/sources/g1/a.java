package g1;

import android.os.Bundle;
import android.support.v4.media.h;
import h3.e2;
import h3.n1;
import h3.n2;
import h3.p1;
import h3.r3;
import h3.y0;
import j1.q;
import n1.b;
import n1.c;

public final /* synthetic */ class a implements l, n1, r3, q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6241h;

    public /* synthetic */ a(int i10) {
        this.f6241h = i10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: g1.s0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: g1.m0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r8v13, types: [g1.s0] */
    /* JADX WARNING: type inference failed for: r8v16, types: [g1.m0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g1.m e(android.os.Bundle r38) {
        /*
            r37 = this;
            r1 = r37
            r0 = r38
            int r2 = r1.f6241h
            r3 = 3
            r4 = 2
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.lang.String r7 = ""
            r8 = 0
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r11 = 0
            r13 = -1
            r14 = 1
            r15 = 0
            switch(r2) {
                case 0: goto L_0x0868;
                case 1: goto L_0x0816;
                case 2: goto L_0x07c4;
                case 3: goto L_0x07a6;
                case 4: goto L_0x078e;
                case 5: goto L_0x0606;
                case 6: goto L_0x05dd;
                case 7: goto L_0x057c;
                case 8: goto L_0x0522;
                case 9: goto L_0x04f1;
                case 10: goto L_0x04ca;
                case 11: goto L_0x02fe;
                case 12: goto L_0x02d8;
                case 13: goto L_0x02d2;
                case 14: goto L_0x02c0;
                case 15: goto L_0x0295;
                case 16: goto L_0x0251;
                case 17: goto L_0x0225;
                case 18: goto L_0x01f8;
                case 19: goto L_0x01cf;
                case 20: goto L_0x019b;
                case 21: goto L_0x015f;
                case 22: goto L_0x00e4;
                case 23: goto L_0x00bd;
                case 24: goto L_0x008e;
                case 25: goto L_0x001c;
                case 26: goto L_0x0077;
                case 27: goto L_0x003c;
                case 28: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x08b2
        L_0x001e:
            java.lang.String r2 = g1.b2.f6312m
            int r2 = r0.getInt(r2, r15)
            java.lang.String r3 = g1.b2.f6313n
            int r3 = r0.getInt(r3, r15)
            java.lang.String r4 = g1.b2.f6314o
            int r4 = r0.getInt(r4, r15)
            java.lang.String r6 = g1.b2.f6315p
            float r0 = r0.getFloat(r6, r5)
            g1.b2 r5 = new g1.b2
            r5.<init>(r0, r2, r3, r4)
            return r5
        L_0x003c:
            java.lang.String r2 = g1.z1.f6772m
            g1.a r2 = g1.v1.f6672o
            java.lang.String r3 = g1.z1.f6772m
            android.os.Bundle r3 = r0.getBundle(r3)
            r3.getClass()
            g1.m r2 = r2.e(r3)
            g1.v1 r2 = (g1.v1) r2
            java.lang.String r3 = g1.z1.f6773n
            int[] r3 = r0.getIntArray(r3)
            int r4 = r2.f6673h
            int[] r4 = new int[r4]
            if (r3 == 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r3 = r4
        L_0x005d:
            java.lang.String r4 = g1.z1.f6774o
            boolean[] r4 = r0.getBooleanArray(r4)
            int r5 = r2.f6673h
            boolean[] r5 = new boolean[r5]
            if (r4 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r4 = r5
        L_0x006b:
            java.lang.String r5 = g1.z1.f6775p
            boolean r0 = r0.getBoolean(r5, r15)
            g1.z1 r5 = new g1.z1
            r5.<init>(r2, r0, r3, r4)
            return r5
        L_0x0077:
            java.lang.String r2 = g1.a2.f6287j
            java.util.ArrayList r0 = r0.getParcelableArrayList(r2)
            if (r0 != 0) goto L_0x0082
            d9.r1 r0 = d9.r1.f4658l
            goto L_0x0088
        L_0x0082:
            g1.a r2 = g1.z1.f6776q
            d9.r1 r0 = j1.c.a(r2, r0)
        L_0x0088:
            g1.a2 r2 = new g1.a2
            r2.<init>(r0)
            return r2
        L_0x008e:
            java.lang.String r2 = g1.w1.f6683j
            android.os.Bundle r2 = r0.getBundle(r2)
            r2.getClass()
            g1.a r3 = g1.v1.f6672o
            g1.m r2 = r3.e(r2)
            g1.v1 r2 = (g1.v1) r2
            java.lang.String r3 = g1.w1.f6684k
            int[] r0 = r0.getIntArray(r3)
            r0.getClass()
            g1.w1 r3 = new g1.w1
            int r4 = r0.length
            if (r4 != 0) goto L_0x00b2
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00b9
        L_0x00b2:
            g9.a r4 = new g9.a
            int r5 = r0.length
            r4.<init>(r15, r5, r0)
            r0 = r4
        L_0x00b9:
            r3.<init>((g1.v1) r2, (java.util.List) r0)
            return r3
        L_0x00bd:
            java.lang.String r2 = g1.v1.f6670m
            java.util.ArrayList r2 = r0.getParcelableArrayList(r2)
            if (r2 != 0) goto L_0x00ca
            d9.p0 r2 = d9.r0.f4657i
            d9.r1 r2 = d9.r1.f4658l
            goto L_0x00d0
        L_0x00ca:
            g1.a r3 = g1.a0.f6264w0
            d9.r1 r2 = j1.c.a(r3, r2)
        L_0x00d0:
            java.lang.String r3 = g1.v1.f6671n
            java.lang.String r0 = r0.getString(r3, r7)
            g1.v1 r3 = new g1.v1
            g1.a0[] r4 = new g1.a0[r15]
            java.lang.Object[] r2 = r2.toArray(r4)
            g1.a0[] r2 = (g1.a0[]) r2
            r3.<init>(r0, r2)
            return r3
        L_0x00e4:
            java.lang.String r2 = g1.t1.B
            android.os.Bundle r2 = r0.getBundle(r2)
            if (r2 == 0) goto L_0x00f5
            g1.a r3 = g1.s0.f6555t
            g1.m r2 = r3.e(r2)
            g1.s0 r2 = (g1.s0) r2
            goto L_0x00f7
        L_0x00f5:
            g1.s0 r2 = g1.s0.f6549n
        L_0x00f7:
            r18 = r2
            java.lang.String r2 = g1.t1.C
            long r20 = r0.getLong(r2, r9)
            java.lang.String r2 = g1.t1.D
            long r22 = r0.getLong(r2, r9)
            java.lang.String r2 = g1.t1.E
            long r24 = r0.getLong(r2, r9)
            java.lang.String r2 = g1.t1.F
            boolean r26 = r0.getBoolean(r2, r15)
            java.lang.String r2 = g1.t1.G
            boolean r27 = r0.getBoolean(r2, r15)
            java.lang.String r2 = g1.t1.H
            android.os.Bundle r2 = r0.getBundle(r2)
            if (r2 == 0) goto L_0x0128
            g1.a r3 = g1.m0.f6462s
            g1.m r2 = r3.e(r2)
            r8 = r2
            g1.m0 r8 = (g1.m0) r8
        L_0x0128:
            r28 = r8
            java.lang.String r2 = g1.t1.I
            boolean r2 = r0.getBoolean(r2, r15)
            java.lang.String r3 = g1.t1.J
            long r29 = r0.getLong(r3, r11)
            java.lang.String r3 = g1.t1.K
            long r31 = r0.getLong(r3, r9)
            java.lang.String r3 = g1.t1.L
            int r33 = r0.getInt(r3, r15)
            java.lang.String r3 = g1.t1.M
            int r34 = r0.getInt(r3, r15)
            java.lang.String r3 = g1.t1.N
            long r35 = r0.getLong(r3, r11)
            g1.t1 r0 = new g1.t1
            r16 = r0
            r0.<init>()
            java.lang.Object r17 = g1.t1.f6574z
            r19 = 0
            r16.l(r17, r18, r19, r20, r22, r24, r26, r27, r28, r29, r31, r33, r34, r35)
            r0.f6586s = r2
            return r0
        L_0x015f:
            java.lang.String r2 = g1.r1.f6536o
            int r19 = r0.getInt(r2, r15)
            java.lang.String r2 = g1.r1.f6537p
            long r20 = r0.getLong(r2, r9)
            java.lang.String r2 = g1.r1.f6538q
            long r22 = r0.getLong(r2, r11)
            java.lang.String r2 = g1.r1.f6539r
            boolean r25 = r0.getBoolean(r2, r15)
            java.lang.String r2 = g1.r1.f6540s
            android.os.Bundle r0 = r0.getBundle(r2)
            if (r0 == 0) goto L_0x0188
            g1.a r2 = g1.c.f6327t
            g1.m r0 = r2.e(r0)
            g1.c r0 = (g1.c) r0
            goto L_0x018a
        L_0x0188:
            g1.c r0 = g1.c.f6321n
        L_0x018a:
            r24 = r0
            g1.r1 r0 = new g1.r1
            r0.<init>()
            r17 = 0
            r18 = 0
            r16 = r0
            r16.q(r17, r18, r19, r20, r22, r24, r25)
            return r0
        L_0x019b:
            g1.q1 r2 = g1.u1.f6622h
            g1.a r2 = g1.t1.O
            java.lang.String r3 = g1.u1.f6623i
            android.os.IBinder r3 = j1.b.a(r0, r3)
            d9.r1 r2 = g1.u1.i(r2, r3)
            g1.a r3 = g1.r1.f6541t
            java.lang.String r4 = g1.u1.f6624j
            android.os.IBinder r4 = j1.b.a(r0, r4)
            d9.r1 r3 = g1.u1.i(r3, r4)
            java.lang.String r4 = g1.u1.f6625k
            int[] r0 = r0.getIntArray(r4)
            g1.s1 r4 = new g1.s1
            if (r0 != 0) goto L_0x01cb
            int r0 = r2.f4660k
            int[] r5 = new int[r0]
        L_0x01c3:
            if (r15 >= r0) goto L_0x01ca
            r5[r15] = r15
            int r15 = r15 + 1
            goto L_0x01c3
        L_0x01ca:
            r0 = r5
        L_0x01cb:
            r4.<init>(r2, r3, r0)
            return r4
        L_0x01cf:
            java.lang.String r2 = g1.p1.f6509l
            java.lang.String r2 = g1.l1.f6454h
            int r2 = r0.getInt(r2, r13)
            if (r2 != r3) goto L_0x01da
            goto L_0x01db
        L_0x01da:
            r14 = 0
        L_0x01db:
            j1.a.b(r14)
            java.lang.String r2 = g1.p1.f6509l
            boolean r2 = r0.getBoolean(r2, r15)
            if (r2 == 0) goto L_0x01f2
            g1.p1 r2 = new g1.p1
            java.lang.String r3 = g1.p1.f6510m
            boolean r0 = r0.getBoolean(r3, r15)
            r2.<init>(r0)
            goto L_0x01f7
        L_0x01f2:
            g1.p1 r2 = new g1.p1
            r2.<init>()
        L_0x01f7:
            return r2
        L_0x01f8:
            java.lang.String r2 = g1.m1.f6468l
            java.lang.String r2 = g1.l1.f6454h
            int r2 = r0.getInt(r2, r13)
            if (r2 != r4) goto L_0x0203
            goto L_0x0204
        L_0x0203:
            r14 = 0
        L_0x0204:
            j1.a.b(r14)
            java.lang.String r2 = g1.m1.f6468l
            r3 = 5
            int r2 = r0.getInt(r2, r3)
            java.lang.String r3 = g1.m1.f6469m
            float r0 = r0.getFloat(r3, r6)
            int r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x021e
            g1.m1 r0 = new g1.m1
            r0.<init>(r2)
            goto L_0x0224
        L_0x021e:
            g1.m1 r3 = new g1.m1
            r3.<init>(r2, r0)
            r0 = r3
        L_0x0224:
            return r0
        L_0x0225:
            java.lang.String r2 = g1.l1.f6454h
            int r2 = r0.getInt(r2, r13)
            if (r2 == 0) goto L_0x0248
            if (r2 == r14) goto L_0x0245
            if (r2 == r4) goto L_0x0242
            if (r2 != r3) goto L_0x0236
            g1.a r2 = g1.p1.f6511n
            goto L_0x024a
        L_0x0236:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Unknown RatingType: "
            java.lang.String r2 = android.support.v4.media.h.i(r3, r2)
            r0.<init>(r2)
            throw r0
        L_0x0242:
            g1.a r2 = g1.m1.f6470n
            goto L_0x024a
        L_0x0245:
            g1.a r2 = g1.c1.f6336l
            goto L_0x024a
        L_0x0248:
            g1.a r2 = g1.d0.f6340n
        L_0x024a:
            g1.m r0 = r2.e(r0)
            g1.l1 r0 = (g1.l1) r0
            return r0
        L_0x0251:
            java.lang.String r2 = g1.j1.f6422q
            int r18 = r0.getInt(r2, r15)
            java.lang.String r2 = g1.j1.f6423r
            android.os.Bundle r2 = r0.getBundle(r2)
            if (r2 != 0) goto L_0x0260
            goto L_0x0269
        L_0x0260:
            g1.a r3 = g1.s0.f6555t
            g1.m r2 = r3.e(r2)
            r8 = r2
            g1.s0 r8 = (g1.s0) r8
        L_0x0269:
            r19 = r8
            java.lang.String r2 = g1.j1.f6424s
            int r21 = r0.getInt(r2, r15)
            java.lang.String r2 = g1.j1.f6425t
            long r22 = r0.getLong(r2, r11)
            java.lang.String r2 = g1.j1.f6426u
            long r24 = r0.getLong(r2, r11)
            java.lang.String r2 = g1.j1.f6427v
            int r26 = r0.getInt(r2, r13)
            java.lang.String r2 = g1.j1.f6428w
            int r27 = r0.getInt(r2, r13)
            g1.j1 r0 = new g1.j1
            r17 = 0
            r20 = 0
            r16 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r24, r26, r27)
            return r0
        L_0x0295:
            java.lang.String r2 = g1.g1.f6383j
            java.util.ArrayList r0 = r0.getIntegerArrayList(r2)
            if (r0 != 0) goto L_0x02a0
            g1.g1 r0 = g1.g1.f6382i
            goto L_0x02bf
        L_0x02a0:
            g1.f1 r2 = new g1.f1
            r2.<init>()
        L_0x02a5:
            int r3 = r0.size()
            if (r15 >= r3) goto L_0x02bb
            java.lang.Object r3 = r0.get(r15)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r2.a(r3)
            int r15 = r15 + 1
            goto L_0x02a5
        L_0x02bb:
            g1.g1 r0 = r2.c()
        L_0x02bf:
            return r0
        L_0x02c0:
            java.lang.String r2 = g1.e1.f6352l
            float r2 = r0.getFloat(r2, r5)
            java.lang.String r3 = g1.e1.f6353m
            float r0 = r0.getFloat(r3, r5)
            g1.e1 r3 = new g1.e1
            r3.<init>(r2, r0)
            return r3
        L_0x02d2:
            g1.d1 r2 = new g1.d1
            r2.<init>(r0)
            return r2
        L_0x02d8:
            java.lang.String r2 = g1.c1.f6335k
            java.lang.String r2 = g1.l1.f6454h
            int r2 = r0.getInt(r2, r13)
            if (r2 != r14) goto L_0x02e3
            goto L_0x02e4
        L_0x02e3:
            r14 = 0
        L_0x02e4:
            j1.a.b(r14)
            java.lang.String r2 = g1.c1.f6335k
            float r0 = r0.getFloat(r2, r6)
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x02f7
            g1.c1 r0 = new g1.c1
            r0.<init>()
            goto L_0x02fd
        L_0x02f7:
            g1.c1 r2 = new g1.c1
            r2.<init>(r0)
            r0 = r2
        L_0x02fd:
            return r0
        L_0x02fe:
            g1.v0 r2 = g1.v0.P
            g1.u0 r2 = new g1.u0
            r2.<init>()
            java.lang.String r3 = g1.v0.Q
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.f6596a = r3
            java.lang.String r3 = g1.v0.R
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.f6597b = r3
            java.lang.String r3 = g1.v0.S
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.f6598c = r3
            java.lang.String r3 = g1.v0.T
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.f6599d = r3
            java.lang.String r3 = g1.v0.U
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.f6600e = r3
            java.lang.String r3 = g1.v0.V
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.f6601f = r3
            java.lang.String r3 = g1.v0.W
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.f6602g = r3
            java.lang.String r3 = g1.v0.Z
            byte[] r3 = r0.getByteArray(r3)
            java.lang.String r4 = g1.v0.f6645s0
            boolean r5 = r0.containsKey(r4)
            if (r5 == 0) goto L_0x0353
            int r4 = r0.getInt(r4)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
        L_0x0353:
            r2.b(r3, r8)
            java.lang.String r3 = g1.v0.f6627a0
            android.os.Parcelable r3 = r0.getParcelable(r3)
            android.net.Uri r3 = (android.net.Uri) r3
            r2.f6607l = r3
            java.lang.String r3 = g1.v0.f6638l0
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.f6619x = r3
            java.lang.String r3 = g1.v0.f6639m0
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.f6620y = r3
            java.lang.String r3 = g1.v0.f6640n0
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.f6621z = r3
            java.lang.String r3 = g1.v0.f6643q0
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.C = r3
            java.lang.String r3 = g1.v0.f6644r0
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.D = r3
            java.lang.String r3 = g1.v0.f6646t0
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            r2.E = r3
            java.lang.String r3 = g1.v0.f6649w0
            android.os.Bundle r3 = r0.getBundle(r3)
            r2.G = r3
            java.lang.String r3 = g1.v0.X
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x03b0
            android.os.Bundle r3 = r0.getBundle(r3)
            if (r3 == 0) goto L_0x03b0
            g1.a r4 = g1.l1.f6455i
            g1.m r3 = r4.e(r3)
            g1.l1 r3 = (g1.l1) r3
            r2.f6603h = r3
        L_0x03b0:
            java.lang.String r3 = g1.v0.Y
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x03c8
            android.os.Bundle r3 = r0.getBundle(r3)
            if (r3 == 0) goto L_0x03c8
            g1.a r4 = g1.l1.f6455i
            g1.m r3 = r4.e(r3)
            g1.l1 r3 = (g1.l1) r3
            r2.f6604i = r3
        L_0x03c8:
            java.lang.String r3 = g1.v0.f6628b0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x03da
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f6608m = r3
        L_0x03da:
            java.lang.String r3 = g1.v0.f6629c0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x03ec
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f6609n = r3
        L_0x03ec:
            java.lang.String r3 = g1.v0.f6630d0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x03fe
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f6610o = r3
        L_0x03fe:
            java.lang.String r3 = g1.v0.f6648v0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0410
            boolean r3 = r0.getBoolean(r3)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.f6611p = r3
        L_0x0410:
            java.lang.String r3 = g1.v0.f6631e0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0422
            boolean r3 = r0.getBoolean(r3)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.f6612q = r3
        L_0x0422:
            java.lang.String r3 = g1.v0.f6632f0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0434
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f6613r = r3
        L_0x0434:
            java.lang.String r3 = g1.v0.f6633g0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0446
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f6614s = r3
        L_0x0446:
            java.lang.String r3 = g1.v0.f6634h0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0458
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f6615t = r3
        L_0x0458:
            java.lang.String r3 = g1.v0.f6635i0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x046a
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f6616u = r3
        L_0x046a:
            java.lang.String r3 = g1.v0.f6636j0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x047c
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f6617v = r3
        L_0x047c:
            java.lang.String r3 = g1.v0.f6637k0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x048e
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f6618w = r3
        L_0x048e:
            java.lang.String r3 = g1.v0.f6641o0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x04a0
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.A = r3
        L_0x04a0:
            java.lang.String r3 = g1.v0.f6642p0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x04b2
            int r3 = r0.getInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.B = r3
        L_0x04b2:
            java.lang.String r3 = g1.v0.f6647u0
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x04c4
            int r0 = r0.getInt(r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.F = r0
        L_0x04c4:
            g1.v0 r0 = new g1.v0
            r0.<init>(r2)
            return r0
        L_0x04ca:
            g1.p0 r2 = g1.p0.f6501k
            g1.o0 r2 = new g1.o0
            r2.<init>()
            java.lang.String r3 = g1.p0.f6502l
            android.os.Parcelable r3 = r0.getParcelable(r3)
            android.net.Uri r3 = (android.net.Uri) r3
            r2.f6495a = r3
            java.lang.String r3 = g1.p0.f6503m
            java.lang.String r3 = r0.getString(r3)
            r2.f6496b = r3
            java.lang.String r3 = g1.p0.f6504n
            android.os.Bundle r0 = r0.getBundle(r3)
            r2.f6497c = r0
            g1.p0 r0 = new g1.p0
            r0.<init>(r2)
            return r0
        L_0x04f1:
            g1.m0 r2 = new g1.m0
            g1.m0 r3 = g1.m0.f6456m
            long r4 = r3.f6463h
            java.lang.String r6 = g1.m0.f6457n
            long r4 = r0.getLong(r6, r4)
            java.lang.String r6 = g1.m0.f6458o
            long r7 = r3.f6464i
            long r6 = r0.getLong(r6, r7)
            java.lang.String r8 = g1.m0.f6459p
            long r9 = r3.f6465j
            long r8 = r0.getLong(r8, r9)
            java.lang.String r10 = g1.m0.f6460q
            float r11 = r3.f6466k
            float r10 = r0.getFloat(r10, r11)
            java.lang.String r11 = g1.m0.f6461r
            float r3 = r3.f6467l
            float r11 = r0.getFloat(r11, r3)
            r3 = r2
            r3.<init>(r4, r6, r8, r10, r11)
            return r2
        L_0x0522:
            g1.i0 r2 = g1.h0.f6399m
            g1.g0 r2 = new g1.g0
            r2.<init>()
            g1.i0 r3 = g1.h0.f6399m
            long r4 = r3.f6406h
            java.lang.String r6 = g1.h0.f6400n
            long r4 = r0.getLong(r6, r4)
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 < 0) goto L_0x0539
            r6 = 1
            goto L_0x053a
        L_0x0539:
            r6 = 0
        L_0x053a:
            j1.a.b(r6)
            r2.f6377a = r4
            long r4 = r3.f6407i
            java.lang.String r6 = g1.h0.f6401o
            long r4 = r0.getLong(r6, r4)
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0553
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 < 0) goto L_0x0552
            goto L_0x0553
        L_0x0552:
            r14 = 0
        L_0x0553:
            j1.a.b(r14)
            r2.f6378b = r4
            boolean r4 = r3.f6408j
            java.lang.String r5 = g1.h0.f6402p
            boolean r4 = r0.getBoolean(r5, r4)
            r2.f6379c = r4
            boolean r4 = r3.f6409k
            java.lang.String r5 = g1.h0.f6403q
            boolean r4 = r0.getBoolean(r5, r4)
            r2.f6380d = r4
            boolean r3 = r3.f6410l
            java.lang.String r4 = g1.h0.f6404r
            boolean r0 = r0.getBoolean(r4, r3)
            r2.f6381e = r0
            g1.i0 r0 = new g1.i0
            r0.<init>(r2)
            return r0
        L_0x057c:
            java.lang.String r2 = g1.s0.f6550o
            java.lang.String r9 = r0.getString(r2, r7)
            r9.getClass()
            java.lang.String r2 = g1.s0.f6551p
            android.os.Bundle r2 = r0.getBundle(r2)
            if (r2 != 0) goto L_0x0590
            g1.m0 r2 = g1.m0.f6456m
            goto L_0x0598
        L_0x0590:
            g1.a r3 = g1.m0.f6462s
            g1.m r2 = r3.e(r2)
            g1.m0 r2 = (g1.m0) r2
        L_0x0598:
            r12 = r2
            java.lang.String r2 = g1.s0.f6552q
            android.os.Bundle r2 = r0.getBundle(r2)
            if (r2 != 0) goto L_0x05a4
            g1.v0 r2 = g1.v0.P
            goto L_0x05ac
        L_0x05a4:
            g1.a r3 = g1.v0.f6650x0
            g1.m r2 = r3.e(r2)
            g1.v0 r2 = (g1.v0) r2
        L_0x05ac:
            r13 = r2
            java.lang.String r2 = g1.s0.f6553r
            android.os.Bundle r2 = r0.getBundle(r2)
            if (r2 != 0) goto L_0x05b8
            g1.i0 r2 = g1.i0.f6412t
            goto L_0x05c0
        L_0x05b8:
            g1.a r3 = g1.h0.f6405s
            g1.m r2 = r3.e(r2)
            g1.i0 r2 = (g1.i0) r2
        L_0x05c0:
            r10 = r2
            java.lang.String r2 = g1.s0.f6554s
            android.os.Bundle r0 = r0.getBundle(r2)
            if (r0 != 0) goto L_0x05cc
            g1.p0 r0 = g1.p0.f6501k
            goto L_0x05d4
        L_0x05cc:
            g1.a r2 = g1.p0.f6505o
            g1.m r0 = r2.e(r0)
            g1.p0 r0 = (g1.p0) r0
        L_0x05d4:
            r14 = r0
            g1.s0 r0 = new g1.s0
            r11 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14)
            return r0
        L_0x05dd:
            java.lang.String r2 = g1.d0.f6338l
            java.lang.String r2 = g1.l1.f6454h
            int r2 = r0.getInt(r2, r13)
            if (r2 != 0) goto L_0x05e8
            goto L_0x05e9
        L_0x05e8:
            r14 = 0
        L_0x05e9:
            j1.a.b(r14)
            java.lang.String r2 = g1.d0.f6338l
            boolean r2 = r0.getBoolean(r2, r15)
            if (r2 == 0) goto L_0x0600
            g1.d0 r2 = new g1.d0
            java.lang.String r3 = g1.d0.f6339m
            boolean r0 = r0.getBoolean(r3, r15)
            r2.<init>(r0)
            goto L_0x0605
        L_0x0600:
            g1.d0 r2 = new g1.d0
            r2.<init>()
        L_0x0605:
            return r2
        L_0x0606:
            g1.a0 r2 = g1.a0.P
            g1.z r2 = new g1.z
            r2.<init>()
            if (r0 == 0) goto L_0x061a
            java.lang.Class<j1.c> r3 = j1.c.class
            java.lang.ClassLoader r3 = r3.getClassLoader()
            int r4 = j1.l0.f8453a
            r0.setClassLoader(r3)
        L_0x061a:
            java.lang.String r3 = g1.a0.Q
            java.lang.String r3 = r0.getString(r3)
            g1.a0 r4 = g1.a0.P
            java.lang.String r5 = r4.f6265h
            if (r3 == 0) goto L_0x0627
            goto L_0x0628
        L_0x0627:
            r3 = r5
        L_0x0628:
            r2.f6744a = r3
            java.lang.String r3 = g1.a0.R
            java.lang.String r3 = r0.getString(r3)
            if (r3 == 0) goto L_0x0633
            goto L_0x0635
        L_0x0633:
            java.lang.String r3 = r4.f6266i
        L_0x0635:
            r2.f6745b = r3
            java.lang.String r3 = g1.a0.S
            java.lang.String r3 = r0.getString(r3)
            if (r3 == 0) goto L_0x0640
            goto L_0x0642
        L_0x0640:
            java.lang.String r3 = r4.f6267j
        L_0x0642:
            r2.f6746c = r3
            java.lang.String r3 = g1.a0.T
            int r5 = r4.f6268k
            int r3 = r0.getInt(r3, r5)
            r2.f6747d = r3
            java.lang.String r3 = g1.a0.U
            int r5 = r4.f6269l
            int r3 = r0.getInt(r3, r5)
            r2.f6748e = r3
            java.lang.String r3 = g1.a0.V
            int r5 = r4.f6270m
            int r3 = r0.getInt(r3, r5)
            r2.f6749f = r3
            java.lang.String r3 = g1.a0.W
            int r5 = r4.f6271n
            int r3 = r0.getInt(r3, r5)
            r2.f6750g = r3
            java.lang.String r3 = g1.a0.X
            java.lang.String r3 = r0.getString(r3)
            if (r3 == 0) goto L_0x0675
            goto L_0x0677
        L_0x0675:
            java.lang.String r3 = r4.f6273p
        L_0x0677:
            r2.f6751h = r3
            java.lang.String r3 = g1.a0.Y
            android.os.Parcelable r3 = r0.getParcelable(r3)
            g1.z0 r3 = (g1.z0) r3
            if (r3 == 0) goto L_0x0684
            goto L_0x0686
        L_0x0684:
            g1.z0 r3 = r4.f6274q
        L_0x0686:
            r2.f6752i = r3
            java.lang.String r3 = g1.a0.Z
            java.lang.String r3 = r0.getString(r3)
            if (r3 == 0) goto L_0x0691
            goto L_0x0693
        L_0x0691:
            java.lang.String r3 = r4.f6275r
        L_0x0693:
            r2.f6753j = r3
            java.lang.String r3 = g1.a0.f6242a0
            java.lang.String r3 = r0.getString(r3)
            if (r3 == 0) goto L_0x069e
            goto L_0x06a0
        L_0x069e:
            java.lang.String r3 = r4.f6276s
        L_0x06a0:
            r2.f6754k = r3
            java.lang.String r3 = g1.a0.f6243b0
            int r5 = r4.f6277t
            int r3 = r0.getInt(r3, r5)
            r2.f6755l = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x06b1:
            java.lang.String r5 = g1.a0.k(r15)
            byte[] r5 = r0.getByteArray(r5)
            if (r5 != 0) goto L_0x0787
            r2.f6756m = r3
            java.lang.String r3 = g1.a0.f6245d0
            android.os.Parcelable r3 = r0.getParcelable(r3)
            g1.u r3 = (g1.u) r3
            r2.f6757n = r3
            java.lang.String r3 = g1.a0.f6246e0
            long r5 = r4.f6280w
            long r5 = r0.getLong(r3, r5)
            r2.f6758o = r5
            java.lang.String r3 = g1.a0.f6247f0
            int r5 = r4.f6281x
            int r3 = r0.getInt(r3, r5)
            r2.f6759p = r3
            java.lang.String r3 = g1.a0.f6248g0
            int r5 = r4.f6282y
            int r3 = r0.getInt(r3, r5)
            r2.f6760q = r3
            java.lang.String r3 = g1.a0.f6249h0
            float r5 = r4.f6283z
            float r3 = r0.getFloat(r3, r5)
            r2.f6761r = r3
            java.lang.String r3 = g1.a0.f6250i0
            int r5 = r4.A
            int r3 = r0.getInt(r3, r5)
            r2.f6762s = r3
            java.lang.String r3 = g1.a0.f6251j0
            float r5 = r4.B
            float r3 = r0.getFloat(r3, r5)
            r2.f6763t = r3
            java.lang.String r3 = g1.a0.f6252k0
            byte[] r3 = r0.getByteArray(r3)
            r2.f6764u = r3
            java.lang.String r3 = g1.a0.f6253l0
            int r5 = r4.D
            int r3 = r0.getInt(r3, r5)
            r2.f6765v = r3
            java.lang.String r3 = g1.a0.f6254m0
            android.os.Bundle r3 = r0.getBundle(r3)
            if (r3 == 0) goto L_0x0727
            g1.a r5 = g1.o.f6489q
            g1.m r3 = r5.e(r3)
            g1.o r3 = (g1.o) r3
            r2.f6766w = r3
        L_0x0727:
            java.lang.String r3 = g1.a0.f6255n0
            int r5 = r4.F
            int r3 = r0.getInt(r3, r5)
            r2.f6767x = r3
            java.lang.String r3 = g1.a0.f6256o0
            int r5 = r4.G
            int r3 = r0.getInt(r3, r5)
            r2.f6768y = r3
            java.lang.String r3 = g1.a0.f6257p0
            int r5 = r4.H
            int r3 = r0.getInt(r3, r5)
            r2.f6769z = r3
            java.lang.String r3 = g1.a0.f6258q0
            int r5 = r4.I
            int r3 = r0.getInt(r3, r5)
            r2.A = r3
            java.lang.String r3 = g1.a0.f6259r0
            int r5 = r4.J
            int r3 = r0.getInt(r3, r5)
            r2.B = r3
            java.lang.String r3 = g1.a0.f6260s0
            int r5 = r4.K
            int r3 = r0.getInt(r3, r5)
            r2.C = r3
            java.lang.String r3 = g1.a0.f6262u0
            int r5 = r4.L
            int r3 = r0.getInt(r3, r5)
            r2.D = r3
            java.lang.String r3 = g1.a0.f6263v0
            int r5 = r4.M
            int r3 = r0.getInt(r3, r5)
            r2.E = r3
            java.lang.String r3 = g1.a0.f6261t0
            int r4 = r4.N
            int r0 = r0.getInt(r3, r4)
            r2.F = r0
            g1.a0 r0 = new g1.a0
            r0.<init>(r2)
            return r0
        L_0x0787:
            r3.add(r5)
            int r15 = r15 + 1
            goto L_0x06b1
        L_0x078e:
            java.lang.String r2 = g1.q.f6515l
            int r2 = r0.getInt(r2, r15)
            java.lang.String r3 = g1.q.f6516m
            int r3 = r0.getInt(r3, r15)
            java.lang.String r4 = g1.q.f6517n
            int r0 = r0.getInt(r4, r15)
            g1.q r4 = new g1.q
            r4.<init>(r2, r3, r0)
            return r4
        L_0x07a6:
            g1.o r2 = new g1.o
            java.lang.String r3 = g1.o.f6485m
            int r3 = r0.getInt(r3, r13)
            java.lang.String r4 = g1.o.f6486n
            int r4 = r0.getInt(r4, r13)
            java.lang.String r5 = g1.o.f6487o
            int r5 = r0.getInt(r5, r13)
            java.lang.String r6 = g1.o.f6488p
            byte[] r0 = r0.getByteArray(r6)
            r2.<init>(r3, r4, r5, r0)
            return r2
        L_0x07c4:
            g1.h r2 = g1.h.f6386n
            g1.g r2 = new g1.g
            r2.<init>()
            java.lang.String r3 = g1.h.f6387o
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x07d9
            int r3 = r0.getInt(r3)
            r2.f6372a = r3
        L_0x07d9:
            java.lang.String r3 = g1.h.f6388p
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x07e7
            int r3 = r0.getInt(r3)
            r2.f6373b = r3
        L_0x07e7:
            java.lang.String r3 = g1.h.f6389q
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x07f5
            int r3 = r0.getInt(r3)
            r2.f6374c = r3
        L_0x07f5:
            java.lang.String r3 = g1.h.f6390r
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0803
            int r3 = r0.getInt(r3)
            r2.f6375d = r3
        L_0x0803:
            java.lang.String r3 = g1.h.f6391s
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0811
            int r0 = r0.getInt(r3)
            r2.f6376e = r0
        L_0x0811:
            g1.h r0 = r2.a()
            return r0
        L_0x0816:
            java.lang.String r2 = g1.b.f6290p
            long r4 = r0.getLong(r2)
            java.lang.String r2 = g1.b.f6291q
            int r6 = r0.getInt(r2)
            java.lang.String r2 = g1.b.f6297w
            int r7 = r0.getInt(r2)
            java.lang.String r2 = g1.b.f6292r
            java.util.ArrayList r2 = r0.getParcelableArrayList(r2)
            java.lang.String r3 = g1.b.f6293s
            int[] r3 = r0.getIntArray(r3)
            java.lang.String r8 = g1.b.f6294t
            long[] r8 = r0.getLongArray(r8)
            java.lang.String r9 = g1.b.f6295u
            long r11 = r0.getLong(r9)
            java.lang.String r9 = g1.b.f6296v
            boolean r13 = r0.getBoolean(r9)
            g1.b r0 = new g1.b
            if (r3 != 0) goto L_0x084c
            int[] r3 = new int[r15]
        L_0x084c:
            r9 = r3
            if (r2 != 0) goto L_0x0852
            android.net.Uri[] r2 = new android.net.Uri[r15]
            goto L_0x085a
        L_0x0852:
            android.net.Uri[] r3 = new android.net.Uri[r15]
            java.lang.Object[] r2 = r2.toArray(r3)
            android.net.Uri[] r2 = (android.net.Uri[]) r2
        L_0x085a:
            if (r8 != 0) goto L_0x0860
            long[] r3 = new long[r15]
            r10 = r3
            goto L_0x0861
        L_0x0860:
            r10 = r8
        L_0x0861:
            r3 = r0
            r8 = r9
            r9 = r2
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r13)
            return r0
        L_0x0868:
            java.lang.String r2 = g1.c.f6323p
            java.util.ArrayList r2 = r0.getParcelableArrayList(r2)
            if (r2 != 0) goto L_0x0874
            g1.b[] r2 = new g1.b[r15]
            r5 = r2
            goto L_0x0898
        L_0x0874:
            int r3 = r2.size()
            g1.b[] r3 = new g1.b[r3]
            r4 = 0
        L_0x087b:
            int r5 = r2.size()
            if (r4 >= r5) goto L_0x0897
            g1.a r5 = g1.b.f6298x
            java.lang.Object r6 = r2.get(r4)
            android.os.Bundle r6 = (android.os.Bundle) r6
            g1.m r5 = r5.e(r6)     // Catch:{ all -> 0x0894 }
            g1.b r5 = (g1.b) r5
            r3[r4] = r5
            int r4 = r4 + 1
            goto L_0x087b
        L_0x0894:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0897:
            r5 = r3
        L_0x0898:
            java.lang.String r2 = g1.c.f6324q
            long r6 = r0.getLong(r2, r11)
            java.lang.String r2 = g1.c.f6325r
            long r8 = r0.getLong(r2, r9)
            java.lang.String r2 = g1.c.f6326s
            int r10 = r0.getInt(r2, r15)
            g1.c r0 = new g1.c
            r4 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r8, r10)
            return r0
        L_0x08b2:
            i1.b r2 = i1.b.f7970y
            i1.a r2 = new i1.a
            r2.<init>()
            java.lang.String r3 = i1.b.f7971z
            java.lang.CharSequence r3 = r0.getCharSequence(r3)
            if (r3 == 0) goto L_0x08c3
            r2.f7953a = r3
        L_0x08c3:
            java.lang.String r3 = i1.b.A
            java.io.Serializable r3 = r0.getSerializable(r3)
            android.text.Layout$Alignment r3 = (android.text.Layout.Alignment) r3
            if (r3 == 0) goto L_0x08cf
            r2.f7955c = r3
        L_0x08cf:
            java.lang.String r3 = i1.b.B
            java.io.Serializable r3 = r0.getSerializable(r3)
            android.text.Layout$Alignment r3 = (android.text.Layout.Alignment) r3
            if (r3 == 0) goto L_0x08db
            r2.f7956d = r3
        L_0x08db:
            java.lang.String r3 = i1.b.C
            android.os.Parcelable r3 = r0.getParcelable(r3)
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
            if (r3 == 0) goto L_0x08e7
            r2.f7954b = r3
        L_0x08e7:
            java.lang.String r3 = i1.b.D
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0903
            java.lang.String r4 = i1.b.E
            boolean r5 = r0.containsKey(r4)
            if (r5 == 0) goto L_0x0903
            float r3 = r0.getFloat(r3)
            int r4 = r0.getInt(r4)
            r2.f7957e = r3
            r2.f7958f = r4
        L_0x0903:
            java.lang.String r3 = i1.b.F
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0911
            int r3 = r0.getInt(r3)
            r2.f7959g = r3
        L_0x0911:
            java.lang.String r3 = i1.b.G
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x091f
            float r3 = r0.getFloat(r3)
            r2.f7960h = r3
        L_0x091f:
            java.lang.String r3 = i1.b.H
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x092d
            int r3 = r0.getInt(r3)
            r2.f7961i = r3
        L_0x092d:
            java.lang.String r3 = i1.b.J
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0949
            java.lang.String r4 = i1.b.I
            boolean r5 = r0.containsKey(r4)
            if (r5 == 0) goto L_0x0949
            float r3 = r0.getFloat(r3)
            int r4 = r0.getInt(r4)
            r2.f7963k = r3
            r2.f7962j = r4
        L_0x0949:
            java.lang.String r3 = i1.b.K
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0957
            float r3 = r0.getFloat(r3)
            r2.f7964l = r3
        L_0x0957:
            java.lang.String r3 = i1.b.L
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0965
            float r3 = r0.getFloat(r3)
            r2.f7965m = r3
        L_0x0965:
            java.lang.String r3 = i1.b.M
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0975
            int r3 = r0.getInt(r3)
            r2.f7967o = r3
            r2.f7966n = r14
        L_0x0975:
            java.lang.String r3 = i1.b.N
            boolean r3 = r0.getBoolean(r3, r15)
            if (r3 != 0) goto L_0x097f
            r2.f7966n = r15
        L_0x097f:
            java.lang.String r3 = i1.b.O
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x098d
            int r3 = r0.getInt(r3)
            r2.f7968p = r3
        L_0x098d:
            java.lang.String r3 = i1.b.P
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x099b
            float r0 = r0.getFloat(r3)
            r2.f7969q = r0
        L_0x099b:
            i1.b r0 = r2.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.a.e(android.os.Bundle):g1.m");
    }

    public void g(y0 y0Var) {
        switch (this.f6241h) {
            case 0:
                h.B(y0Var);
                throw null;
            default:
                h.B(y0Var);
                throw null;
        }
    }

    public Object h(n2 n2Var, e2 e2Var, int i10) {
        switch (this.f6241h) {
            case 0:
                h.y(n2Var);
                throw null;
            default:
                h.y(n2Var);
                throw null;
        }
    }

    public void invoke(Object obj) {
        switch (this.f6241h) {
            case 0:
                ((c) obj).getClass();
                return;
            default:
                ((c) obj).getClass();
                return;
        }
    }

    public /* synthetic */ a(int i10, int i11, Bundle bundle, String str) {
        this.f6241h = i11;
    }

    public /* synthetic */ a(int i10, p1 p1Var, String str) {
        this.f6241h = i10;
    }

    public /* synthetic */ a(b bVar, int i10, long j10) {
        this.f6241h = 1;
    }

    public /* synthetic */ a(b bVar, long j10, int i10) {
        this.f6241h = 0;
    }
}
