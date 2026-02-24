package wb;

import dc.l;
import dc.n;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import la.v;
import qb.f;
import qb.h;
import sb.c;
import xa.j;

public final class b0 implements Closeable {

    /* renamed from: l  reason: collision with root package name */
    public static final z f16185l = new z(0);

    /* renamed from: m  reason: collision with root package name */
    public static final Logger f16186m;

    /* renamed from: h  reason: collision with root package name */
    public final l f16187h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f16188i;

    /* renamed from: j  reason: collision with root package name */
    public final a0 f16189j;

    /* renamed from: k  reason: collision with root package name */
    public final f f16190k;

    static {
        Logger logger = Logger.getLogger(i.class.getName());
        j.e("getLogger(Http2::class.java.name)", logger);
        f16186m = logger;
    }

    public b0(l lVar, boolean z10) {
        this.f16187h = lVar;
        this.f16188i = z10;
        a0 a0Var = new a0(lVar);
        this.f16189j = a0Var;
        this.f16190k = new f(a0Var);
    }

    public final void N(q qVar, int i10, int i11, int i12) {
        byte b10;
        if (i12 != 0) {
            if ((i11 & 8) != 0) {
                byte readByte = this.f16187h.readByte();
                byte[] bArr = f.f13487a;
                b10 = readByte & 255;
            } else {
                b10 = 0;
            }
            int readInt = this.f16187h.readInt() & Integer.MAX_VALUE;
            f16185l.getClass();
            List v10 = v(z.a(i10 - 4, i11, b10), b10, i11, i12);
            qVar.getClass();
            j.f("requestHeaders", v10);
            v vVar = qVar.f16295i;
            vVar.getClass();
            synchronized (vVar) {
                if (vVar.H.contains(Integer.valueOf(readInt))) {
                    vVar.Y(readInt, c.PROTOCOL_ERROR);
                    return;
                }
                vVar.H.add(Integer.valueOf(readInt));
                c cVar = vVar.f16320q;
                c.c(cVar, vVar.f16314k + '[' + readInt + "] onRequest", 0, new fb.j(vVar, readInt, v10), 6);
                return;
            }
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: wb.g0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: wb.v} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: wb.g0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: wb.g0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void W(wb.q r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            java.lang.String r0 = "TYPE_WINDOW_UPDATE length !=4: "
            r1 = 4
            r2 = 1
            if (r8 != r1) goto L_0x0065
            dc.l r0 = r6.f16187h     // Catch:{ Exception -> 0x0077 }
            int r0 = r0.readInt()     // Catch:{ Exception -> 0x0077 }
            byte[] r1 = qb.f.f13487a     // Catch:{ Exception -> 0x0077 }
            long r0 = (long) r0
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r0 = r0 & r3
            r3 = 0
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x005d
            java.util.logging.Logger r9 = f16186m
            java.util.logging.Level r3 = java.util.logging.Level.FINE
            boolean r3 = r9.isLoggable(r3)
            if (r3 == 0) goto L_0x002f
            wb.i r3 = wb.i.f16255a
            r3.getClass()
            java.lang.String r8 = wb.i.c(r0, r10, r8, r2)
            r9.fine(r8)
        L_0x002f:
            if (r10 != 0) goto L_0x0042
            wb.v r7 = r7.f16295i
            monitor-enter(r7)
            long r8 = r7.D     // Catch:{ all -> 0x003f }
            long r8 = r8 + r0
            r7.D = r8     // Catch:{ all -> 0x003f }
            r7.notifyAll()     // Catch:{ all -> 0x003f }
            la.v r8 = la.v.f9814a     // Catch:{ all -> 0x003f }
            goto L_0x0057
        L_0x003f:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x0042:
            wb.v r7 = r7.f16295i
            wb.g0 r7 = r7.k(r10)
            if (r7 == 0) goto L_0x005c
            monitor-enter(r7)
            long r8 = r7.f16243f     // Catch:{ all -> 0x0059 }
            long r8 = r8 + r0
            r7.f16243f = r8     // Catch:{ all -> 0x0059 }
            if (r5 <= 0) goto L_0x0055
            r7.notifyAll()     // Catch:{ all -> 0x0059 }
        L_0x0055:
            la.v r8 = la.v.f9814a     // Catch:{ all -> 0x0059 }
        L_0x0057:
            monitor-exit(r7)
            goto L_0x005c
        L_0x0059:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x005c:
            return
        L_0x005d:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ Exception -> 0x0077 }
            java.lang.String r0 = "windowSizeIncrement was 0"
            r7.<init>(r0)     // Catch:{ Exception -> 0x0077 }
            throw r7     // Catch:{ Exception -> 0x0077 }
        L_0x0065:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ Exception -> 0x0077 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0077 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0077 }
            r1.append(r8)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0077 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0077 }
            throw r7     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            r7 = move-exception
            java.util.logging.Logger r0 = f16186m
            wb.i r1 = wb.i.f16255a
            r1.getClass()
            r1 = 8
            java.lang.String r8 = wb.i.b(r10, r8, r1, r9, r2)
            r0.fine(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.b0.W(wb.q, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f6, code lost:
        throw new java.io.IOException(android.support.v4.media.h.i("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", r10));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(boolean r22, wb.q r23) {
        /*
            r21 = this;
            r1 = r21
            r0 = r23
            java.lang.String r2 = "handler"
            xa.j.f(r2, r0)
            r2 = 0
            dc.l r3 = r1.f16187h     // Catch:{ EOFException -> 0x0354 }
            r4 = 9
            r3.u0(r4)     // Catch:{ EOFException -> 0x0354 }
            dc.l r3 = r1.f16187h
            int r3 = qb.f.m(r3)
            r4 = 16384(0x4000, float:2.2959E-41)
            if (r3 > r4) goto L_0x0348
            dc.l r5 = r1.f16187h
            byte r5 = r5.readByte()
            r5 = r5 & 255(0xff, float:3.57E-43)
            dc.l r6 = r1.f16187h
            byte r6 = r6.readByte()
            r6 = r6 & 255(0xff, float:3.57E-43)
            dc.l r7 = r1.f16187h
            int r7 = r7.readInt()
            r8 = 2147483647(0x7fffffff, float:NaN)
            r11 = r7 & r8
            r7 = 8
            r8 = 1
            if (r5 == r7) goto L_0x0051
            java.util.logging.Logger r7 = f16186m
            java.util.logging.Level r9 = java.util.logging.Level.FINE
            boolean r9 = r7.isLoggable(r9)
            if (r9 == 0) goto L_0x0051
            wb.i r9 = wb.i.f16255a
            r9.getClass()
            java.lang.String r9 = wb.i.b(r11, r3, r5, r6, r8)
            r7.fine(r9)
        L_0x0051:
            r7 = 4
            if (r22 == 0) goto L_0x0074
            if (r5 != r7) goto L_0x0057
            goto L_0x0074
        L_0x0057:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected a SETTINGS frame but was "
            r2.<init>(r3)
            wb.i r3 = wb.i.f16255a
            r3.getClass()
            java.lang.String r3 = wb.i.a(r5)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0074:
            r9 = 5
            r10 = 91
            switch(r5) {
                case 0: goto L_0x0205;
                case 1: goto L_0x0200;
                case 2: goto L_0x01dc;
                case 3: goto L_0x014b;
                case 4: goto L_0x0096;
                case 5: goto L_0x0091;
                case 6: goto L_0x008c;
                case 7: goto L_0x0087;
                case 8: goto L_0x0082;
                default: goto L_0x007a;
            }
        L_0x007a:
            dc.l r0 = r1.f16187h
            long r2 = (long) r3
            r0.a(r2)
            goto L_0x0346
        L_0x0082:
            r1.W(r0, r3, r6, r11)
            goto L_0x0346
        L_0x0087:
            r1.k(r0, r3, r11)
            goto L_0x0346
        L_0x008c:
            r1.z(r0, r3, r6, r11)
            goto L_0x0346
        L_0x0091:
            r1.N(r0, r3, r6, r11)
            goto L_0x0346
        L_0x0096:
            if (r11 != 0) goto L_0x0143
            r5 = r6 & 1
            if (r5 == 0) goto L_0x00a8
            if (r3 != 0) goto L_0x00a0
            goto L_0x0346
        L_0x00a0:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "FRAME_SIZE_ERROR ack frame should be empty!"
            r0.<init>(r2)
            throw r0
        L_0x00a8:
            int r5 = r3 % 6
            if (r5 != 0) goto L_0x0137
            wb.p0 r5 = new wb.p0
            r5.<init>()
            cb.e r2 = cb.l.c(r2, r3)
            r3 = 6
            cb.b r2 = cb.l.b(r2, r3)
            int r3 = r2.f3063h
            int r6 = r2.f3064i
            int r2 = r2.f3065j
            if (r2 <= 0) goto L_0x00c4
            if (r3 <= r6) goto L_0x00c8
        L_0x00c4:
            if (r2 >= 0) goto L_0x0119
            if (r6 > r3) goto L_0x0119
        L_0x00c8:
            dc.l r10 = r1.f16187h
            short r11 = r10.readShort()
            byte[] r12 = qb.f.f13487a
            r12 = 65535(0xffff, float:9.1834E-41)
            r11 = r11 & r12
            int r10 = r10.readInt()
            r12 = 2
            if (r11 == r12) goto L_0x0105
            r12 = 3
            if (r11 == r12) goto L_0x0103
            if (r11 == r7) goto L_0x00f7
            if (r11 == r9) goto L_0x00e3
            goto L_0x0112
        L_0x00e3:
            if (r10 < r4) goto L_0x00eb
            r12 = 16777215(0xffffff, float:2.3509886E-38)
            if (r10 > r12) goto L_0x00eb
            goto L_0x0112
        L_0x00eb:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "
            java.lang.String r2 = android.support.v4.media.h.i(r2, r10)
            r0.<init>(r2)
            throw r0
        L_0x00f7:
            if (r10 < 0) goto L_0x00fb
            r11 = 7
            goto L_0x0112
        L_0x00fb:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            r0.<init>(r2)
            throw r0
        L_0x0103:
            r11 = 4
            goto L_0x0112
        L_0x0105:
            if (r10 == 0) goto L_0x0112
            if (r10 != r8) goto L_0x010a
            goto L_0x0112
        L_0x010a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            r0.<init>(r2)
            throw r0
        L_0x0112:
            r5.b(r11, r10)
            if (r3 == r6) goto L_0x0119
            int r3 = r3 + r2
            goto L_0x00c8
        L_0x0119:
            wb.v r2 = r0.f16295i
            sb.c r6 = r2.f16319p
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = r2.f16314k
            java.lang.String r4 = " applyAndAckSettings"
            java.lang.String r7 = android.support.v4.media.h.p(r3, r2, r4)
            r8 = 0
            j3.x r10 = new j3.x
            r10.<init>(r0, r5)
            r11 = 6
            sb.c.c(r6, r7, r8, r10, r11)
            goto L_0x0346
        L_0x0137:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "TYPE_SETTINGS length % 6 != 0: "
            java.lang.String r2 = android.support.v4.media.h.i(r2, r3)
            r0.<init>(r2)
            throw r0
        L_0x0143:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "TYPE_SETTINGS streamId != 0"
            r0.<init>(r2)
            throw r0
        L_0x014b:
            if (r3 != r7) goto L_0x01ce
            if (r11 == 0) goto L_0x01c6
            dc.l r3 = r1.f16187h
            int r3 = r3.readInt()
            wb.b r4 = wb.c.f16191i
            r4.getClass()
            wb.c[] r4 = wb.c.values()
            int r5 = r4.length
            r6 = 0
        L_0x0160:
            if (r6 >= r5) goto L_0x0171
            r7 = r4[r6]
            int r8 = r7.f16199h
            if (r8 != r3) goto L_0x016a
            r8 = 1
            goto L_0x016b
        L_0x016a:
            r8 = 0
        L_0x016b:
            if (r8 == 0) goto L_0x016e
            goto L_0x0172
        L_0x016e:
            int r6 = r6 + 1
            goto L_0x0160
        L_0x0171:
            r7 = 0
        L_0x0172:
            if (r7 == 0) goto L_0x01ba
            wb.v r0 = r0.f16295i
            r0.getClass()
            if (r11 == 0) goto L_0x0181
            r3 = r11 & 1
            if (r3 != 0) goto L_0x0181
            r3 = 1
            goto L_0x0182
        L_0x0181:
            r3 = 0
        L_0x0182:
            if (r3 == 0) goto L_0x01af
            sb.c r12 = r0.f16320q
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.f16314k
            r3.append(r4)
            r3.append(r10)
            r3.append(r11)
            java.lang.String r4 = "] onReset"
            r3.append(r4)
            java.lang.String r13 = r3.toString()
            r14 = 0
            wb.t r3 = new wb.t
            r3.<init>(r0, r11, r7, r2)
            r17 = 6
            r16 = r3
            sb.c.c(r12, r13, r14, r16, r17)
            goto L_0x0346
        L_0x01af:
            wb.g0 r0 = r0.w(r11)
            if (r0 == 0) goto L_0x0346
            r0.k(r7)
            goto L_0x0346
        L_0x01ba:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "TYPE_RST_STREAM unexpected error code: "
            java.lang.String r2 = android.support.v4.media.h.i(r2, r3)
            r0.<init>(r2)
            throw r0
        L_0x01c6:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "TYPE_RST_STREAM streamId == 0"
            r0.<init>(r2)
            throw r0
        L_0x01ce:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "TYPE_RST_STREAM length: "
            java.lang.String r4 = " != 4"
            java.lang.String r2 = android.support.v4.media.h.j(r2, r3, r4)
            r0.<init>(r2)
            throw r0
        L_0x01dc:
            if (r3 != r9) goto L_0x01f2
            if (r11 == 0) goto L_0x01ea
            dc.l r0 = r1.f16187h
            r0.readInt()
            r0.readByte()
            goto L_0x0346
        L_0x01ea:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "TYPE_PRIORITY streamId == 0"
            r0.<init>(r2)
            throw r0
        L_0x01f2:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "TYPE_PRIORITY length: "
            java.lang.String r4 = " != 5"
            java.lang.String r2 = android.support.v4.media.h.j(r2, r3, r4)
            r0.<init>(r2)
            throw r0
        L_0x0200:
            r1.w(r0, r3, r6, r11)
            goto L_0x0346
        L_0x0205:
            if (r11 == 0) goto L_0x033e
            r2 = r6 & 1
            if (r2 == 0) goto L_0x020e
            r2 = 1
            r14 = 1
            goto L_0x0210
        L_0x020e:
            r2 = 0
            r14 = 0
        L_0x0210:
            r2 = r6 & 32
            if (r2 == 0) goto L_0x0216
            r2 = 1
            goto L_0x0217
        L_0x0216:
            r2 = 0
        L_0x0217:
            if (r2 != 0) goto L_0x0336
            r2 = r6 & 8
            if (r2 == 0) goto L_0x0226
            dc.l r2 = r1.f16187h
            byte r2 = r2.readByte()
            r2 = r2 & 255(0xff, float:3.57E-43)
            goto L_0x0227
        L_0x0226:
            r2 = 0
        L_0x0227:
            wb.z r4 = f16185l
            r4.getClass()
            int r13 = wb.z.a(r3, r6, r2)
            dc.l r3 = r1.f16187h
            java.lang.String r4 = "source"
            xa.j.f(r4, r3)
            wb.v r4 = r0.f16295i
            r4.getClass()
            if (r11 == 0) goto L_0x0244
            r4 = r11 & 1
            if (r4 != 0) goto L_0x0244
            r4 = 1
            goto L_0x0245
        L_0x0244:
            r4 = 0
        L_0x0245:
            if (r4 == 0) goto L_0x0284
            wb.v r0 = r0.f16295i
            r0.getClass()
            dc.j r12 = new dc.j
            r12.<init>()
            long r4 = (long) r13
            r3.u0(r4)
            r3.read(r12, r4)
            sb.c r15 = r0.f16320q
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.f16314k
            r3.append(r4)
            r3.append(r10)
            r3.append(r11)
            java.lang.String r4 = "] onData"
            r3.append(r4)
            java.lang.String r16 = r3.toString()
            r17 = 0
            wb.r r19 = new wb.r
            r9 = r19
            r10 = r0
            r9.<init>(r10, r11, r12, r13, r14)
            r20 = 6
            sb.c.c(r15, r16, r17, r19, r20)
            goto L_0x032f
        L_0x0284:
            wb.v r4 = r0.f16295i
            wb.g0 r4 = r4.k(r11)
            if (r4 != 0) goto L_0x029e
            wb.v r4 = r0.f16295i
            wb.c r5 = wb.c.PROTOCOL_ERROR
            r4.Y(r11, r5)
            wb.v r0 = r0.f16295i
            long r4 = (long) r13
            r0.N(r4)
            r3.a(r4)
            goto L_0x032f
        L_0x029e:
            pb.p0 r0 = qb.h.f13493a
            wb.e0 r0 = r4.f16246i
            long r5 = (long) r13
            r0.getClass()
        L_0x02a6:
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0327
            wb.g0 r7 = r0.f16219n
            monitor-enter(r7)
            boolean r8 = r0.f16214i     // Catch:{ all -> 0x0324 }
            dc.j r9 = r0.f16216k     // Catch:{ all -> 0x0324 }
            long r9 = r9.f4787i     // Catch:{ all -> 0x0324 }
            long r9 = r9 + r5
            long r11 = r0.f16213h     // Catch:{ all -> 0x0324 }
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x02be
            r9 = 1
            goto L_0x02bf
        L_0x02be:
            r9 = 0
        L_0x02bf:
            la.v r10 = la.v.f9814a     // Catch:{ all -> 0x0324 }
            monitor-exit(r7)
            if (r9 == 0) goto L_0x02cf
            r3.a(r5)
            wb.g0 r0 = r0.f16219n
            wb.c r3 = wb.c.FLOW_CONTROL_ERROR
            r0.e(r3)
            goto L_0x0327
        L_0x02cf:
            if (r8 == 0) goto L_0x02d5
            r3.a(r5)
            goto L_0x0327
        L_0x02d5:
            dc.j r7 = r0.f16215j
            long r7 = r3.read(r7, r5)
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x031e
            long r5 = r5 - r7
            wb.g0 r7 = r0.f16219n
            monitor-enter(r7)
            boolean r8 = r0.f16218m     // Catch:{ all -> 0x031b }
            if (r8 == 0) goto L_0x02f1
            dc.j r8 = r0.f16215j     // Catch:{ all -> 0x031b }
            long r9 = r8.f4787i     // Catch:{ all -> 0x031b }
            r8.c()     // Catch:{ all -> 0x031b }
            goto L_0x030a
        L_0x02f1:
            dc.j r8 = r0.f16216k     // Catch:{ all -> 0x031b }
            long r9 = r8.f4787i     // Catch:{ all -> 0x031b }
            r11 = 0
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x02fd
            r9 = 1
            goto L_0x02fe
        L_0x02fd:
            r9 = 0
        L_0x02fe:
            dc.j r10 = r0.f16215j     // Catch:{ all -> 0x031b }
            r8.F0(r10)     // Catch:{ all -> 0x031b }
            if (r9 == 0) goto L_0x0308
            r7.notifyAll()     // Catch:{ all -> 0x031b }
        L_0x0308:
            r9 = 0
        L_0x030a:
            monitor-exit(r7)
            r7 = 0
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 <= 0) goto L_0x02a6
            pb.p0 r7 = qb.h.f13493a
            wb.g0 r7 = r0.f16219n
            wb.v r7 = r7.f16239b
            r7.N(r9)
            goto L_0x02a6
        L_0x031b:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        L_0x031e:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        L_0x0324:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        L_0x0327:
            if (r14 == 0) goto L_0x032f
            pb.p0 r0 = qb.h.f13493a
            r3 = 1
            r4.j(r0, r3)
        L_0x032f:
            dc.l r0 = r1.f16187h
            long r2 = (long) r2
            r0.a(r2)
            goto L_0x0346
        L_0x0336:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA"
            r0.<init>(r2)
            throw r0
        L_0x033e:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "PROTOCOL_ERROR: TYPE_DATA streamId == 0"
            r0.<init>(r2)
            throw r0
        L_0x0346:
            r0 = 1
            return r0
        L_0x0348:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "FRAME_SIZE_ERROR: "
            java.lang.String r2 = android.support.v4.media.h.i(r2, r3)
            r0.<init>(r2)
            throw r0
        L_0x0354:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.b0.c(boolean, wb.q):boolean");
    }

    public final void close() {
        this.f16187h.close();
    }

    public final void e(q qVar) {
        j.f("handler", qVar);
        if (!this.f16188i) {
            n nVar = i.f16256b;
            n n10 = this.f16187h.n((long) nVar.f4804h.length);
            Level level = Level.FINE;
            Logger logger = f16186m;
            if (logger.isLoggable(level)) {
                logger.fine(h.e("<< CONNECTION " + n10.e(), new Object[0]));
            }
            if (!j.a(nVar, n10)) {
                throw new IOException("Expected a connection header but was ".concat(n10.q()));
            }
        } else if (!c(true, qVar)) {
            throw new IOException("Required SETTINGS preface not received");
        }
    }

    public final void k(q qVar, int i10, int i11) {
        c cVar;
        Object[] array;
        boolean z10;
        if (i10 < 8) {
            throw new IOException(android.support.v4.media.h.i("TYPE_GOAWAY length < 8: ", i10));
        } else if (i11 == 0) {
            int readInt = this.f16187h.readInt();
            int readInt2 = this.f16187h.readInt();
            int i12 = i10 - 8;
            c.f16191i.getClass();
            c[] values = c.values();
            int length = values.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length) {
                    cVar = null;
                    break;
                }
                cVar = values[i13];
                if (cVar.f16199h == readInt2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    break;
                }
                i13++;
            }
            if (cVar != null) {
                n nVar = n.f4803l;
                if (i12 > 0) {
                    nVar = this.f16187h.n((long) i12);
                }
                qVar.getClass();
                j.f("debugData", nVar);
                nVar.d();
                v vVar = qVar.f16295i;
                synchronized (vVar) {
                    array = vVar.f16313j.values().toArray(new g0[0]);
                    j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
                    vVar.f16317n = true;
                    v vVar2 = v.f9814a;
                }
                for (g0 g0Var : (g0[]) array) {
                    if (g0Var.f16238a > readInt && g0Var.h()) {
                        g0Var.k(c.REFUSED_STREAM);
                        qVar.f16295i.w(g0Var.f16238a);
                    }
                }
                return;
            }
            throw new IOException(android.support.v4.media.h.i("TYPE_GOAWAY unexpected error code: ", readInt2));
        } else {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0104, code lost:
        throw new java.io.IOException("Invalid dynamic table size update " + r3.f16221b);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List v(int r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            wb.a0 r0 = r2.f16189j
            r0.f16183l = r3
            r0.f16180i = r3
            r0.f16184m = r4
            r0.f16181j = r5
            r0.f16182k = r6
        L_0x000c:
            wb.f r3 = r2.f16190k
            dc.i0 r4 = r3.f16223d
            boolean r5 = r4.R()
            java.util.ArrayList r6 = r3.f16222c
            if (r5 != 0) goto L_0x0148
            byte r4 = r4.readByte()
            byte[] r5 = qb.f.f13487a
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 128(0x80, float:1.794E-43)
            if (r4 == r5) goto L_0x0140
            r0 = r4 & 128(0x80, float:1.794E-43)
            r1 = 0
            if (r0 != r5) goto L_0x007f
            r5 = 127(0x7f, float:1.78E-43)
            int r4 = r3.e(r4, r5)
            int r4 = r4 + -1
            r5 = 1
            if (r4 < 0) goto L_0x0040
            wb.h r0 = wb.h.f16252a
            r0.getClass()
            wb.e[] r0 = wb.h.f16253b
            int r0 = r0.length
            int r0 = r0 - r5
            if (r4 > r0) goto L_0x0040
            r1 = 1
        L_0x0040:
            if (r1 == 0) goto L_0x004c
            wb.h r3 = wb.h.f16252a
            r3.getClass()
            wb.e[] r3 = wb.h.f16253b
            r3 = r3[r4]
            goto L_0x0066
        L_0x004c:
            wb.h r0 = wb.h.f16252a
            r0.getClass()
            wb.e[] r0 = wb.h.f16253b
            int r0 = r0.length
            int r0 = r4 - r0
            int r1 = r3.f16225f
            int r1 = r1 + r5
            int r1 = r1 + r0
            if (r1 < 0) goto L_0x006a
            wb.e[] r3 = r3.f16224e
            int r0 = r3.length
            if (r1 >= r0) goto L_0x006a
            r3 = r3[r1]
            xa.j.c(r3)
        L_0x0066:
            r6.add(r3)
            goto L_0x000c
        L_0x006a:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Header index too large "
            r6.<init>(r0)
            int r4 = r4 + r5
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.<init>(r4)
            throw r3
        L_0x007f:
            r5 = 64
            if (r4 != r5) goto L_0x009d
            wb.h r4 = wb.h.f16252a
            dc.n r5 = r3.d()
            r4.getClass()
            wb.h.a(r5)
            dc.n r4 = r3.d()
            wb.e r6 = new wb.e
            r6.<init>((dc.n) r5, (dc.n) r4)
            r3.c(r6)
            goto L_0x000c
        L_0x009d:
            r0 = r4 & 64
            if (r0 != r5) goto L_0x00bb
            r5 = 63
            int r4 = r3.e(r4, r5)
            int r4 = r4 + -1
            dc.n r4 = r3.b(r4)
            dc.n r5 = r3.d()
            wb.e r6 = new wb.e
            r6.<init>((dc.n) r4, (dc.n) r5)
            r3.c(r6)
            goto L_0x000c
        L_0x00bb:
            r5 = r4 & 32
            r0 = 32
            if (r5 != r0) goto L_0x0105
            r5 = 31
            int r4 = r3.e(r4, r5)
            r3.f16221b = r4
            if (r4 < 0) goto L_0x00ef
            int r5 = r3.f16220a
            if (r4 > r5) goto L_0x00ef
            int r5 = r3.f16227h
            if (r4 >= r5) goto L_0x000c
            if (r4 != 0) goto L_0x00e9
            wb.e[] r4 = r3.f16224e
            int r5 = r4.length
            r6 = 0
            ma.o.f(r4, r6, r1, r5)
            wb.e[] r4 = r3.f16224e
            int r4 = r4.length
            int r4 = r4 + -1
            r3.f16225f = r4
            r3.f16226g = r1
            r3.f16227h = r1
            goto L_0x000c
        L_0x00e9:
            int r5 = r5 - r4
            r3.a(r5)
            goto L_0x000c
        L_0x00ef:
            java.io.IOException r4 = new java.io.IOException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Invalid dynamic table size update "
            r5.<init>(r6)
            int r3 = r3.f16221b
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.<init>(r3)
            throw r4
        L_0x0105:
            r5 = 16
            if (r4 == r5) goto L_0x0126
            if (r4 != 0) goto L_0x010c
            goto L_0x0126
        L_0x010c:
            r5 = 15
            int r4 = r3.e(r4, r5)
            int r4 = r4 + -1
            dc.n r4 = r3.b(r4)
            dc.n r3 = r3.d()
            wb.e r5 = new wb.e
            r5.<init>((dc.n) r4, (dc.n) r3)
            r6.add(r5)
            goto L_0x000c
        L_0x0126:
            wb.h r4 = wb.h.f16252a
            dc.n r5 = r3.d()
            r4.getClass()
            wb.h.a(r5)
            dc.n r3 = r3.d()
            wb.e r4 = new wb.e
            r4.<init>((dc.n) r5, (dc.n) r3)
            r6.add(r4)
            goto L_0x000c
        L_0x0140:
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r4 = "index == 0"
            r3.<init>(r4)
            throw r3
        L_0x0148:
            java.util.List r3 = ma.z.J(r6)
            r6.clear()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.b0.v(int, int, int, int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(wb.q r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            if (r13 == 0) goto L_0x00ed
            r0 = r12 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000a
            r7 = 1
            goto L_0x000b
        L_0x000a:
            r7 = 0
        L_0x000b:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x001a
            dc.l r0 = r9.f16187h
            byte r0 = r0.readByte()
            byte[] r3 = qb.f.f13487a
            r0 = r0 & 255(0xff, float:3.57E-43)
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            r3 = r12 & 32
            if (r3 == 0) goto L_0x002e
            dc.l r3 = r9.f16187h
            r3.readInt()
            r3.readByte()
            byte[] r3 = qb.f.f13487a
            r10.getClass()
            int r11 = r11 + -5
        L_0x002e:
            wb.z r3 = f16185l
            r3.getClass()
            int r11 = wb.z.a(r11, r12, r0)
            java.util.List r11 = r9.v(r11, r0, r12, r13)
            r10.getClass()
            java.lang.String r12 = "headerBlock"
            xa.j.f(r12, r11)
            wb.v r12 = r10.f16295i
            r12.getClass()
            if (r13 == 0) goto L_0x004f
            r12 = r13 & 1
            if (r12 != 0) goto L_0x004f
            r1 = 1
        L_0x004f:
            r12 = 91
            wb.v r10 = r10.f16295i
            if (r1 == 0) goto L_0x007f
            r10.getClass()
            sb.c r0 = r10.f16320q
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r10.f16314k
            r1.append(r2)
            r1.append(r12)
            r1.append(r13)
            java.lang.String r12 = "] onHeaders"
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r2 = 0
            wb.s r4 = new wb.s
            r4.<init>(r10, r13, r11, r7)
            r5 = 6
            sb.c.c(r0, r1, r2, r4, r5)
            goto L_0x00e9
        L_0x007f:
            monitor-enter(r10)
            wb.g0 r0 = r10.k(r13)     // Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x00df
            boolean r0 = r10.f16317n     // Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x008b
            goto L_0x00dd
        L_0x008b:
            int r0 = r10.f16315l     // Catch:{ all -> 0x00ea }
            if (r13 > r0) goto L_0x0090
            goto L_0x00dd
        L_0x0090:
            int r0 = r13 % 2
            int r1 = r10.f16316m     // Catch:{ all -> 0x00ea }
            int r1 = r1 % 2
            if (r0 != r1) goto L_0x0099
            goto L_0x00dd
        L_0x0099:
            pb.p0 r8 = qb.h.j(r11)     // Catch:{ all -> 0x00ea }
            wb.g0 r11 = new wb.g0     // Catch:{ all -> 0x00ea }
            r6 = 0
            r3 = r11
            r4 = r13
            r5 = r10
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ea }
            r10.f16315l = r13     // Catch:{ all -> 0x00ea }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x00ea }
            java.util.LinkedHashMap r1 = r10.f16313j     // Catch:{ all -> 0x00ea }
            r1.put(r0, r11)     // Catch:{ all -> 0x00ea }
            sb.g r0 = r10.f16318o     // Catch:{ all -> 0x00ea }
            sb.c r1 = r0.f()     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r0.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r2 = r10.f16314k     // Catch:{ all -> 0x00ea }
            r0.append(r2)     // Catch:{ all -> 0x00ea }
            r0.append(r12)     // Catch:{ all -> 0x00ea }
            r0.append(r13)     // Catch:{ all -> 0x00ea }
            java.lang.String r12 = "] onStream"
            r0.append(r12)     // Catch:{ all -> 0x00ea }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x00ea }
            r3 = 0
            l3.j r5 = new l3.j     // Catch:{ all -> 0x00ea }
            r12 = 9
            r5.<init>(r10, r12, r11)     // Catch:{ all -> 0x00ea }
            r6 = 6
            sb.c.c(r1, r2, r3, r5, r6)     // Catch:{ all -> 0x00ea }
        L_0x00dd:
            monitor-exit(r10)
            goto L_0x00e9
        L_0x00df:
            la.v r12 = la.v.f9814a     // Catch:{ all -> 0x00ea }
            monitor-exit(r10)
            pb.p0 r10 = qb.h.j(r11)
            r0.j(r10, r7)
        L_0x00e9:
            return
        L_0x00ea:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        L_0x00ed:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "PROTOCOL_ERROR: TYPE_HEADERS streamId == 0"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.b0.w(wb.q, int, int, int):void");
    }

    public final void z(q qVar, int i10, int i11, int i12) {
        boolean z10;
        if (i10 != 8) {
            throw new IOException(android.support.v4.media.h.i("TYPE_PING length != 8: ", i10));
        } else if (i12 == 0) {
            int readInt = this.f16187h.readInt();
            int readInt2 = this.f16187h.readInt();
            if ((i11 & 1) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                v vVar = qVar.f16295i;
                synchronized (vVar) {
                    if (readInt == 1) {
                        vVar.f16324u++;
                    } else if (readInt != 2) {
                        if (readInt == 3) {
                            vVar.notifyAll();
                        }
                        v vVar2 = v.f9814a;
                    } else {
                        vVar.f16326w++;
                    }
                }
                return;
            }
            c.c(qVar.f16295i.f16319p, android.support.v4.media.h.p(new StringBuilder(), qVar.f16295i.f16314k, " ping"), 0, new p(qVar.f16295i, readInt, readInt2), 6);
        } else {
            throw new IOException("TYPE_PING streamId != 0");
        }
    }
}
