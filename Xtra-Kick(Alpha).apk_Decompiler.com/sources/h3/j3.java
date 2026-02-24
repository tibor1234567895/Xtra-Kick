package h3;

import androidx.preference.Preference;
import com.github.andreyasadchy.xtra.ui.settings.SettingsActivity;
import g.t;
import g1.l;
import i0.i;
import j1.h;
import j1.q;
import java.io.Serializable;
import java.util.List;
import n1.b;
import n1.c;
import o3.s;
import xa.j;
import y8.y;

public final /* synthetic */ class j3 implements h, q3, p3, l, i4.h, s, y, r3, q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7138h;

    public /* synthetic */ j3(int i10) {
        this.f7138h = i10;
    }

    public void a(a4 a4Var, e2 e2Var, List list) {
        a4Var.g0(list);
    }

    public void b(Object obj) {
        switch (this.f7138h) {
            case 0:
                ((a4) obj).v0();
                return;
            case 1:
                ((a4) obj).g();
                return;
            case 2:
                ((a4) obj).stop();
                return;
            case 3:
                ((a4) obj).D0();
                return;
            case 4:
                ((a4) obj).A0();
                return;
            default:
                ((a4) obj).e();
                return;
        }
    }

    public void c(Preference preference, Serializable serializable) {
        String str;
        int i10 = SettingsActivity.d.f3494s0;
        j.f("<anonymous parameter 0>", preference);
        if (j.a(serializable.toString(), "auto")) {
            str = null;
        } else {
            str = serializable.toString();
        }
        t.w(i.b(str));
    }

    public void d(a4 a4Var, f2 f2Var) {
        switch (this.f7138h) {
            case Constants.MAX_COMPATIBILITY_VERSION:
                t3.A(a4Var, f2Var);
                return;
            default:
                t3.A(a4Var, f2Var);
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r11v1, types: [g1.d1] */
    /* JADX WARNING: type inference failed for: r6v6, types: [g1.d1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g1.m e(android.os.Bundle r45) {
        /*
            r44 = this;
            r0 = r45
            java.lang.String r1 = "package name should be set."
            r2 = r44
            int r3 = r2.f7138h
            java.lang.String r4 = "type should be set."
            java.lang.String r5 = "uid should be set."
            r6 = 0
            r7 = 0
            r9 = 0
            switch(r3) {
                case 9: goto L_0x0165;
                case 10: goto L_0x0153;
                case 11: goto L_0x012b;
                case 12: goto L_0x00ef;
                case 13: goto L_0x0099;
                case 14: goto L_0x0078;
                case 15: goto L_0x0013;
                case 16: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x02f2
        L_0x0015:
            java.lang.String r3 = h3.m4.f7203q
            boolean r6 = r0.containsKey(r3)
            j1.a.a(r5, r6)
            int r11 = r0.getInt(r3)
            java.lang.String r3 = h3.m4.f7204r
            boolean r5 = r0.containsKey(r3)
            j1.a.a(r4, r5)
            int r12 = r0.getInt(r3)
            java.lang.String r3 = h3.m4.f7205s
            int r13 = r0.getInt(r3, r9)
            java.lang.String r3 = h3.m4.f7211y
            int r14 = r0.getInt(r3, r9)
            java.lang.String r3 = h3.m4.f7206t
            java.lang.String r15 = r0.getString(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r15)
            if (r3 != 0) goto L_0x0072
            java.lang.String r1 = h3.m4.f7207u
            java.lang.String r3 = ""
            java.lang.String r16 = r0.getString(r1, r3)
            java.lang.String r1 = h3.m4.f7209w
            android.os.IBinder r18 = b0.j.a(r0, r1)
            java.lang.String r1 = h3.m4.f7208v
            android.os.Parcelable r1 = r0.getParcelable(r1)
            r17 = r1
            android.content.ComponentName r17 = (android.content.ComponentName) r17
            java.lang.String r1 = h3.m4.f7210x
            android.os.Bundle r0 = r0.getBundle(r1)
            h3.m4 r1 = new h3.m4
            if (r0 != 0) goto L_0x006b
            android.os.Bundle r0 = android.os.Bundle.EMPTY
        L_0x006b:
            r19 = r0
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        L_0x0072:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L_0x0078:
            java.lang.String r1 = h3.j4.f7139k
            r3 = -1
            int r1 = r0.getInt(r1, r3)
            java.lang.String r3 = h3.j4.f7140l
            android.os.Bundle r3 = r0.getBundle(r3)
            java.lang.String r4 = h3.j4.f7141m
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r4 = r0.getLong(r4, r5)
            h3.j4 r0 = new h3.j4
            if (r3 != 0) goto L_0x0095
            android.os.Bundle r3 = android.os.Bundle.EMPTY
        L_0x0095:
            r0.<init>(r1, r3, r4)
            return r0
        L_0x0099:
            java.lang.String r1 = h3.i4.f7110t
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x00a4
            g1.j1 r1 = h3.i4.f7108r
            goto L_0x00ac
        L_0x00a4:
            g1.a r3 = g1.j1.f6429x
            g1.m r1 = r3.e(r1)
            g1.j1 r1 = (g1.j1) r1
        L_0x00ac:
            r11 = r1
            java.lang.String r1 = h3.i4.f7111u
            boolean r12 = r0.getBoolean(r1, r9)
            java.lang.String r1 = h3.i4.f7112v
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r13 = r0.getLong(r1, r3)
            java.lang.String r1 = h3.i4.f7113w
            long r15 = r0.getLong(r1, r3)
            java.lang.String r1 = h3.i4.f7114x
            long r17 = r0.getLong(r1, r7)
            java.lang.String r1 = h3.i4.f7115y
            int r19 = r0.getInt(r1, r9)
            java.lang.String r1 = h3.i4.f7116z
            long r20 = r0.getLong(r1, r7)
            java.lang.String r1 = h3.i4.A
            long r22 = r0.getLong(r1, r3)
            java.lang.String r1 = h3.i4.B
            long r24 = r0.getLong(r1, r3)
            java.lang.String r1 = h3.i4.C
            long r26 = r0.getLong(r1, r7)
            h3.i4 r0 = new h3.i4
            r10 = r0
            r10.<init>(r11, r12, r13, r15, r17, r19, r20, r22, r24, r26)
            return r0
        L_0x00ef:
            java.lang.String r1 = h3.h4.f7076j
            java.util.ArrayList r0 = r0.getParcelableArrayList(r1)
            if (r0 != 0) goto L_0x0101
            java.lang.String r0 = "SessionCommands"
            java.lang.String r1 = "Missing commands. Creating an empty SessionCommands"
            j1.v.g(r0, r1)
            h3.h4 r0 = h3.h4.f7075i
            goto L_0x012a
        L_0x0101:
            h3.g4 r1 = new h3.g4
            r1.<init>()
        L_0x0106:
            int r3 = r0.size()
            java.util.HashSet r4 = r1.f7052a
            if (r9 >= r3) goto L_0x0125
            h3.j3 r3 = h3.f4.f7033o
            java.lang.Object r5 = r0.get(r9)
            android.os.Bundle r5 = (android.os.Bundle) r5
            g1.m r3 = r3.e(r5)
            h3.f4 r3 = (h3.f4) r3
            r3.getClass()
            r4.add(r3)
            int r9 = r9 + 1
            goto L_0x0106
        L_0x0125:
            h3.h4 r0 = new h3.h4
            r0.<init>(r4)
        L_0x012a:
            return r0
        L_0x012b:
            java.lang.String r1 = h3.f4.f7030l
            int r1 = r0.getInt(r1, r9)
            if (r1 == 0) goto L_0x0139
            h3.f4 r0 = new h3.f4
            r0.<init>(r1)
            goto L_0x0152
        L_0x0139:
            java.lang.String r1 = h3.f4.f7031m
            java.lang.String r1 = r0.getString(r1)
            r1.getClass()
            java.lang.String r3 = h3.f4.f7032n
            android.os.Bundle r0 = r0.getBundle(r3)
            h3.f4 r3 = new h3.f4
            if (r0 != 0) goto L_0x014e
            android.os.Bundle r0 = android.os.Bundle.EMPTY
        L_0x014e:
            r3.<init>(r0, r1)
            r0 = r3
        L_0x0152:
            return r0
        L_0x0153:
            h3.v3 r1 = new h3.v3
            java.lang.String r3 = h3.v3.f7385k
            boolean r3 = r0.getBoolean(r3, r9)
            java.lang.String r4 = h3.v3.f7386l
            boolean r0 = r0.getBoolean(r4, r9)
            r1.<init>(r3, r0)
            return r1
        L_0x0165:
            java.lang.String r1 = h3.w3.f7398d0
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x016e
            goto L_0x0177
        L_0x016e:
            g1.a r3 = g1.d1.f6348o
            g1.m r1 = r3.e(r1)
            r6 = r1
            g1.d1 r6 = (g1.d1) r6
        L_0x0177:
            r11 = r6
            java.lang.String r1 = h3.w3.f7400f0
            int r12 = r0.getInt(r1, r9)
            java.lang.String r1 = h3.w3.f7399e0
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x0189
            h3.i4 r1 = h3.i4.f7109s
            goto L_0x0191
        L_0x0189:
            h3.j3 r3 = h3.i4.D
            g1.m r1 = r3.e(r1)
            h3.i4 r1 = (h3.i4) r1
        L_0x0191:
            r13 = r1
            java.lang.String r1 = h3.w3.f7401g0
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x019d
            g1.j1 r1 = h3.i4.f7108r
            goto L_0x01a5
        L_0x019d:
            g1.a r3 = g1.j1.f6429x
            g1.m r1 = r3.e(r1)
            g1.j1 r1 = (g1.j1) r1
        L_0x01a5:
            r14 = r1
            java.lang.String r1 = h3.w3.f7402h0
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x01b1
            g1.j1 r1 = h3.i4.f7108r
            goto L_0x01b9
        L_0x01b1:
            g1.a r3 = g1.j1.f6429x
            g1.m r1 = r3.e(r1)
            g1.j1 r1 = (g1.j1) r1
        L_0x01b9:
            r15 = r1
            java.lang.String r1 = h3.w3.f7403i0
            int r16 = r0.getInt(r1, r9)
            java.lang.String r1 = h3.w3.M
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x01cb
            g1.e1 r1 = g1.e1.f6351k
            goto L_0x01d3
        L_0x01cb:
            g1.a r3 = g1.e1.f6354n
            g1.m r1 = r3.e(r1)
            g1.e1 r1 = (g1.e1) r1
        L_0x01d3:
            r17 = r1
            java.lang.String r1 = h3.w3.N
            int r18 = r0.getInt(r1, r9)
            java.lang.String r1 = h3.w3.O
            boolean r19 = r0.getBoolean(r1, r9)
            java.lang.String r1 = h3.w3.P
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x01ec
            g1.q1 r1 = g1.u1.f6622h
            goto L_0x01f4
        L_0x01ec:
            g1.a r3 = g1.u1.f6626l
            g1.m r1 = r3.e(r1)
            g1.u1 r1 = (g1.u1) r1
        L_0x01f4:
            r21 = r1
            java.lang.String r1 = h3.w3.Q
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x0201
            g1.b2 r1 = g1.b2.f6311l
            goto L_0x0209
        L_0x0201:
            g1.a r3 = g1.b2.f6316q
            g1.m r1 = r3.e(r1)
            g1.b2 r1 = (g1.b2) r1
        L_0x0209:
            r20 = r1
            java.lang.String r1 = h3.w3.R
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x0216
            g1.v0 r1 = g1.v0.P
            goto L_0x021e
        L_0x0216:
            g1.a r3 = g1.v0.f6650x0
            g1.m r1 = r3.e(r1)
            g1.v0 r1 = (g1.v0) r1
        L_0x021e:
            r22 = r1
            java.lang.String r1 = h3.w3.S
            r3 = 1065353216(0x3f800000, float:1.0)
            float r23 = r0.getFloat(r1, r3)
            java.lang.String r1 = h3.w3.T
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x0233
            g1.h r1 = g1.h.f6386n
            goto L_0x023b
        L_0x0233:
            g1.a r3 = g1.h.f6392t
            g1.m r1 = r3.e(r1)
            g1.h r1 = (g1.h) r1
        L_0x023b:
            r24 = r1
            java.lang.String r1 = h3.w3.f7404j0
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x0248
            i1.d r1 = i1.d.f7990j
            goto L_0x0250
        L_0x0248:
            i1.c r3 = i1.d.f7993m
            g1.m r1 = r3.e(r1)
            i1.d r1 = (i1.d) r1
        L_0x0250:
            r25 = r1
            java.lang.String r1 = h3.w3.U
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x025d
            g1.q r1 = g1.q.f6514k
            goto L_0x0265
        L_0x025d:
            g1.a r3 = g1.q.f6518o
            g1.m r1 = r3.e(r1)
            g1.q r1 = (g1.q) r1
        L_0x0265:
            r26 = r1
            java.lang.String r1 = h3.w3.V
            int r27 = r0.getInt(r1, r9)
            java.lang.String r1 = h3.w3.W
            boolean r28 = r0.getBoolean(r1, r9)
            java.lang.String r1 = h3.w3.X
            boolean r29 = r0.getBoolean(r1, r9)
            java.lang.String r1 = h3.w3.Y
            r3 = 1
            int r30 = r0.getInt(r1, r3)
            java.lang.String r1 = h3.w3.Z
            int r31 = r0.getInt(r1, r9)
            java.lang.String r1 = h3.w3.f7395a0
            int r32 = r0.getInt(r1, r3)
            java.lang.String r1 = h3.w3.f7396b0
            boolean r33 = r0.getBoolean(r1, r9)
            java.lang.String r1 = h3.w3.f7397c0
            boolean r34 = r0.getBoolean(r1, r9)
            java.lang.String r1 = h3.w3.f7405k0
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x02a3
            g1.v0 r1 = g1.v0.P
            goto L_0x02ab
        L_0x02a3:
            g1.a r3 = g1.v0.f6650x0
            g1.m r1 = r3.e(r1)
            g1.v0 r1 = (g1.v0) r1
        L_0x02ab:
            r35 = r1
            java.lang.String r1 = h3.w3.f7406l0
            long r36 = r0.getLong(r1, r7)
            java.lang.String r1 = h3.w3.f7407m0
            long r38 = r0.getLong(r1, r7)
            java.lang.String r1 = h3.w3.f7408n0
            long r40 = r0.getLong(r1, r7)
            java.lang.String r1 = h3.w3.f7410p0
            android.os.Bundle r1 = r0.getBundle(r1)
            if (r1 != 0) goto L_0x02ca
            g1.a2 r1 = g1.a2.f6286i
            goto L_0x02d2
        L_0x02ca:
            g1.a r3 = g1.a2.f6288k
            g1.m r1 = r3.e(r1)
            g1.a2 r1 = (g1.a2) r1
        L_0x02d2:
            r42 = r1
            java.lang.String r1 = h3.w3.f7409o0
            android.os.Bundle r0 = r0.getBundle(r1)
            if (r0 != 0) goto L_0x02df
            g1.y1 r0 = g1.y1.H
            goto L_0x02e9
        L_0x02df:
            g1.x1 r1 = new g1.x1
            r1.<init>((android.os.Bundle) r0)
            g1.y1 r0 = new g1.y1
            r0.<init>(r1)
        L_0x02e9:
            r43 = r0
            h3.w3 r0 = new h3.w3
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r38, r40, r42, r43)
            return r0
        L_0x02f2:
            java.lang.String r3 = h3.n4.f7251n
            android.os.Bundle r3 = r0.getBundle(r3)
            if (r3 != 0) goto L_0x02fb
            goto L_0x031e
        L_0x02fb:
            android.os.Parcelable$Creator<android.support.v4.media.session.MediaSessionCompat$Token> r7 = android.support.v4.media.session.MediaSessionCompat$Token.CREATOR
            java.lang.Class<android.support.v4.media.session.MediaSessionCompat$Token> r7 = android.support.v4.media.session.MediaSessionCompat$Token.class
            java.lang.ClassLoader r7 = r7.getClassLoader()
            r3.setClassLoader(r7)
            java.lang.String r7 = "android.support.v4.media.session.EXTRA_BINDER"
            android.os.IBinder r7 = b0.j.a(r3, r7)
            android.support.v4.media.session.f r7 = android.support.v4.media.session.e.A0(r7)
            d4.e r8 = d4.b.a(r3)
            java.lang.String r9 = "android.support.v4.media.session.TOKEN"
            android.os.Parcelable r3 = r3.getParcelable(r9)
            android.support.v4.media.session.MediaSessionCompat$Token r3 = (android.support.v4.media.session.MediaSessionCompat$Token) r3
            if (r3 != 0) goto L_0x0320
        L_0x031e:
            r10 = r6
            goto L_0x0328
        L_0x0320:
            android.support.v4.media.session.MediaSessionCompat$Token r6 = new android.support.v4.media.session.MediaSessionCompat$Token
            java.lang.Object r3 = r3.f351i
            r6.<init>(r3, r7, r8)
            goto L_0x031e
        L_0x0328:
            java.lang.String r3 = h3.n4.f7252o
            boolean r6 = r0.containsKey(r3)
            j1.a.a(r5, r6)
            int r11 = r0.getInt(r3)
            java.lang.String r3 = h3.n4.f7253p
            boolean r5 = r0.containsKey(r3)
            j1.a.a(r4, r5)
            int r12 = r0.getInt(r3)
            java.lang.String r3 = h3.n4.f7254q
            android.os.Parcelable r3 = r0.getParcelable(r3)
            r13 = r3
            android.content.ComponentName r13 = (android.content.ComponentName) r13
            java.lang.String r3 = h3.n4.f7255r
            java.lang.String r14 = r0.getString(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r14)
            if (r3 != 0) goto L_0x0369
            java.lang.String r1 = h3.n4.f7256s
            android.os.Bundle r0 = r0.getBundle(r1)
            h3.n4 r1 = new h3.n4
            if (r0 != 0) goto L_0x0363
            android.os.Bundle r0 = android.os.Bundle.EMPTY
        L_0x0363:
            r15 = r0
            r9 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15)
            return r1
        L_0x0369:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.j3.e(android.os.Bundle):g1.m");
    }

    public Object h(n2 n2Var, e2 e2Var, int i10) {
        switch (this.f7138h) {
            case 0:
                android.support.v4.media.h.y(n2Var);
                throw null;
            default:
                android.support.v4.media.h.y(n2Var);
                throw null;
        }
    }

    public void invoke(Object obj) {
        switch (this.f7138h) {
            case 0:
                ((c) obj).getClass();
                return;
            case 1:
                ((c) obj).getClass();
                return;
            case 2:
                ((c) obj).getClass();
                return;
            default:
                ((c) obj).getClass();
                return;
        }
    }

    public /* synthetic */ j3(String str, int i10) {
        this.f7138h = i10;
    }

    public /* synthetic */ j3(b bVar, Exception exc, int i10) {
        this.f7138h = i10;
    }
}
