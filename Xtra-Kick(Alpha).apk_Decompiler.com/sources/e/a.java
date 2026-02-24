package e;

import android.content.ClipData;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Handler;
import android.support.v4.media.n;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.c3;
import androidx.appcompat.widget.i3;
import androidx.appcompat.widget.j3;
import androidx.appcompat.widget.r;
import androidx.appcompat.widget.r1;
import androidx.appcompat.widget.w4;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.emoji2.text.c;
import androidx.emoji2.text.d;
import androidx.emoji2.text.e;
import androidx.profileinstaller.ProfileInstallReceiver;
import g1.f;
import g1.v1;
import h3.b3;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import l0.b;
import m.b0;
import m.i;
import m.m;
import m.o;
import m0.h;
import m0.i0;
import m0.m2;
import m0.q2;
import m0.r2;
import m0.s2;
import m0.t2;
import m0.u2;
import m0.y;
import n3.i2;
import n3.p3;
import n3.r3;
import o1.j0;
import p3.g;
import q1.p;
import v1.c1;
import v1.d1;
import v1.l1;
import xa.j;

public class a implements c3, b0, m, r1, y, h, c1, d1, g {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4851h;

    /* renamed from: i  reason: collision with root package name */
    public Object f4852i;

    public a() {
        this.f4851h = 16;
        this.f4852i = Build.VERSION.SDK_INT >= 28 ? new e() : new d();
    }

    public final q2 A(View view, q2 q2Var) {
        boolean z10;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f4852i;
        if (!b.a(coordinatorLayout.f1198u, q2Var)) {
            coordinatorLayout.f1198u = q2Var;
            boolean z11 = true;
            if (q2Var.e() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            coordinatorLayout.f1199v = z10;
            if (z10 || coordinatorLayout.getBackground() != null) {
                z11 = false;
            }
            coordinatorLayout.setWillNotDraw(z11);
            m2 m2Var = q2Var.f10131a;
            if (!m2Var.m()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = coordinatorLayout.getChildAt(i10);
                    WeakHashMap weakHashMap = m0.c1.f10054a;
                    if (i0.b(childAt) && ((z.e) childAt.getLayoutParams()).f17322a != null && m2Var.m()) {
                        break;
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return q2Var;
    }

    public final boolean C(long j10) {
        long j11 = j10;
        boolean z10 = false;
        while (true) {
            long j12 = j();
            if (j12 != Long.MIN_VALUE) {
                boolean z11 = false;
                for (d1 d1Var : (d1[]) this.f4852i) {
                    long j13 = d1Var.j();
                    boolean z12 = j13 != Long.MIN_VALUE && j13 <= j11;
                    if (j13 == j12 || z12) {
                        z11 |= d1Var.C(j11);
                    }
                }
                z10 |= z11;
                if (!z11) {
                    break;
                }
            } else {
                break;
            }
        }
        return z10;
    }

    public final void D(long j10) {
        for (d1 D : (d1[]) this.f4852i) {
            D.D(j10);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x0654, code lost:
        r6 = r0;
        r3 = r2;
        r5 = 1;
        r2 = r1;
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0710, code lost:
        r1 = 4096;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x0771, code lost:
        r20 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x0777, code lost:
        r3 = r2;
        r6 = null;
        r5 = 1;
        r2 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x07a7, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x07a8, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x07aa, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:0x07e2, code lost:
        if (r0.o() == r1.getLeastSignificantBits()) goto L_0x07e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:429:0x07fa, code lost:
        r0 = android.support.v4.media.h.o(r0, r4.P, ". Setting mimeType to audio/x-unknown");
        r5 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:430:0x0804, code lost:
        r6 = null;
        r3 = null;
        r5 = 1;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:431:0x080a, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:433:0x080e, code lost:
        j1.v.g("MatroskaExtractor", r0);
        r2 = "audio/x-unknown";
        r0 = null;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:442:0x0830, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:443:0x0831, code lost:
        r6 = r1;
        r5 = r3;
        r3 = r0;
        r0 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:444:0x0836, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:446:0x0839, code lost:
        if (r4.N == null) goto L_0x084c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:447:0x083b, code lost:
        r7 = j1.k.a(new j1.b0(r4.N));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:448:0x0846, code lost:
        if (r7 == null) goto L_0x084c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:449:0x0848, code lost:
        r6 = r7.f8452c;
        r2 = "video/dolby-vision";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:450:0x084c, code lost:
        r7 = r4.V | 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:451:0x0852, code lost:
        if (r4.U == false) goto L_0x0856;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:452:0x0854, code lost:
        r8 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:453:0x0856, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:454:0x0857, code lost:
        r7 = r7 | r8;
        r8 = new g1.z();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:455:0x0861, code lost:
        if (g1.a1.i(r2) == false) goto L_0x086f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:456:0x0863, code lost:
        r8.f6767x = r4.O;
        r8.f6768y = r4.Q;
        r8.f6769z = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:458:0x0873, code lost:
        if (g1.a1.k(r2) == false) goto L_0x09fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:460:0x0877, code lost:
        if (r4.f14112q != 0) goto L_0x088b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:461:0x0879, code lost:
        r1 = r4.f14110o;
        r5 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:462:0x087c, code lost:
        if (r1 != -1) goto L_0x0880;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:463:0x087e, code lost:
        r1 = r4.f14108m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:464:0x0880, code lost:
        r4.f14110o = r1;
        r1 = r4.f14111p;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:465:0x0884, code lost:
        if (r1 != -1) goto L_0x0888;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:466:0x0886, code lost:
        r1 = r4.f14109n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:467:0x0888, code lost:
        r4.f14111p = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:468:0x088b, code lost:
        r5 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:469:0x088c, code lost:
        r1 = r4.f14110o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:470:0x088e, code lost:
        if (r1 == r5) goto L_0x08a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:471:0x0890, code lost:
        r9 = r4.f14111p;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x0892, code lost:
        if (r9 == r5) goto L_0x08a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:473:0x0894, code lost:
        r1 = ((float) (r4.f14109n * r1)) / ((float) (r4.f14108m * r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:474:0x08a0, code lost:
        r1 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:476:0x08a4, code lost:
        if (r4.f14119x == false) goto L_0x0977;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:478:0x08ac, code lost:
        if (r4.D == -1.0f) goto L_0x096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:480:0x08b2, code lost:
        if (r4.E == -1.0f) goto L_0x096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:0x08b8, code lost:
        if (r4.F == -1.0f) goto L_0x096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x08be, code lost:
        if (r4.G == -1.0f) goto L_0x096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:486:0x08c4, code lost:
        if (r4.H == -1.0f) goto L_0x096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:488:0x08ca, code lost:
        if (r4.I == -1.0f) goto L_0x096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:490:0x08d0, code lost:
        if (r4.J == -1.0f) goto L_0x096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:492:0x08d6, code lost:
        if (r4.K == -1.0f) goto L_0x096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x08dc, code lost:
        if (r4.L == -1.0f) goto L_0x096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:496:0x08e2, code lost:
        if (r4.M != -1.0f) goto L_0x08e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:497:0x08e6, code lost:
        r5 = new byte[25];
        r9 = java.nio.ByteBuffer.wrap(r5).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        r9.put((byte) 0);
        r9.putShort((short) ((int) ((r4.D * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r4.E * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r4.F * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r4.G * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r4.H * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r4.I * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r4.J * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) ((r4.K * 50000.0f) + 0.5f)));
        r9.putShort((short) ((int) (r4.L + 0.5f)));
        r9.putShort((short) ((int) (r4.M + 0.5f)));
        r9.putShort((short) r4.B);
        r9.putShort((short) r4.C);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:498:0x096a, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:499:0x096b, code lost:
        r9 = new g1.o(r4.f14120y, r4.A, r4.f14121z, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:500:0x0977, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:501:0x0978, code lost:
        r5 = r4.f14096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:502:0x097a, code lost:
        if (r5 == null) goto L_0x0991;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:503:0x097c, code lost:
        r10 = s2.d.f14127h0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:504:0x0982, code lost:
        if (r10.containsKey(r5) == false) goto L_0x0991;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x0984, code lost:
        r5 = ((java.lang.Integer) r10.get(r4.f14096a)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x0991, code lost:
        r5 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:508:0x0994, code lost:
        if (r4.f14113r != 0) goto L_0x09e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:510:0x099d, code lost:
        if (java.lang.Float.compare(r4.f14114s, 0.0f) != 0) goto L_0x09e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:512:0x09a5, code lost:
        if (java.lang.Float.compare(r4.f14115t, 0.0f) != 0) goto L_0x09e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:514:0x09ad, code lost:
        if (java.lang.Float.compare(r4.f14116u, 0.0f) != 0) goto L_0x09b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:515:0x09af, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:517:0x09b9, code lost:
        if (java.lang.Float.compare(r4.f14115t, 90.0f) != 0) goto L_0x09be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:518:0x09bb, code lost:
        r5 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:520:0x09c6, code lost:
        if (java.lang.Float.compare(r4.f14115t, -180.0f) == 0) goto L_0x09e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:522:0x09d0, code lost:
        if (java.lang.Float.compare(r4.f14115t, 180.0f) != 0) goto L_0x09d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:524:0x09db, code lost:
        if (java.lang.Float.compare(r4.f14115t, -90.0f) != 0) goto L_0x09e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:525:0x09dd, code lost:
        r5 = 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:526:0x09e0, code lost:
        r5 = 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:527:0x09e2, code lost:
        r8.f6759p = r4.f14108m;
        r8.f6760q = r4.f14109n;
        r8.f6763t = r1;
        r8.f6762s = r5;
        r8.f6764u = r4.f14117v;
        r8.f6765v = r4.f14118w;
        r8.f6766w = r9;
        r5 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:529:0x0a00, code lost:
        if ("application/x-subrip".equals(r2) != false) goto L_0x0a33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:531:0x0a08, code lost:
        if ("text/x-ssa".equals(r2) != false) goto L_0x0a33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:533:0x0a10, code lost:
        if ("text/vtt".equals(r2) != false) goto L_0x0a33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:535:0x0a18, code lost:
        if ("application/vobsub".equals(r2) != false) goto L_0x0a33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:537:0x0a20, code lost:
        if ("application/pgs".equals(r2) != false) goto L_0x0a33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:539:0x0a28, code lost:
        if ("application/dvbsubs".equals(r2) == false) goto L_0x0a2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:541:0x0a32, code lost:
        throw g1.b1.a("Unexpected MIME type.", (java.lang.Exception) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:542:0x0a33, code lost:
        r5 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:543:0x0a34, code lost:
        r1 = r4.f14096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:544:0x0a36, code lost:
        if (r1 == null) goto L_0x0a44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:546:0x0a3e, code lost:
        if (s2.d.f14127h0.containsKey(r1) != false) goto L_0x0a44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:547:0x0a40, code lost:
        r8.f6745b = r4.f14096a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:548:0x0a44, code lost:
        r8.b(r18);
        r8.f6754k = r2;
        r8.f6755l = r0;
        r8.f6746c = r4.W;
        r8.f6747d = r7;
        r8.f6756m = r3;
        r8.f6751h = r6;
        r8.f6757n = r4.f14107l;
        r0 = r8.a();
        r1 = r22.d(r4.f14098c, r5);
        r4.X = r1;
        r1.a(r0);
        r16.put(r4.f14098c, r4);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x07e9  */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x080c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(int r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            java.lang.Object r2 = r0.f4852i
            s2.d r2 = (s2.d) r2
            d2.y r3 = r2.f14131b0
            j1.a.f(r3)
            android.util.SparseArray r3 = r2.f14132c
            r4 = 160(0xa0, float:2.24E-43)
            r5 = 0
            java.lang.String r7 = "A_OPUS"
            if (r1 == r4) goto L_0x0a82
            r4 = 174(0xae, float:2.44E-43)
            r8 = -1
            if (r1 == r4) goto L_0x017f
            r4 = 19899(0x4dbb, float:2.7884E-41)
            r7 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r1 == r4) goto L_0x0165
            r4 = 25152(0x6240, float:3.5245E-41)
            if (r1 == r4) goto L_0x0131
            r4 = 28032(0x6d80, float:3.9281E-41)
            if (r1 == r4) goto L_0x011a
            r4 = 357149030(0x1549a966, float:4.072526E-26)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 == r4) goto L_0x0101
            r4 = 374648427(0x1654ae6b, float:1.718026E-25)
            if (r1 == r4) goto L_0x00ec
            if (r1 == r7) goto L_0x003e
            goto L_0x0b00
        L_0x003e:
            boolean r1 = r2.f14151v
            if (r1 != 0) goto L_0x00e5
            d2.y r1 = r2.f14131b0
            j1.w r3 = r2.C
            j1.w r4 = r2.D
            long r10 = r2.f14146q
            r12 = -1
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 == 0) goto L_0x00d8
            long r10 = r2.f14149t
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 == 0) goto L_0x00d8
            if (r3 == 0) goto L_0x00d8
            int r7 = r3.f8479a
            if (r7 == 0) goto L_0x00d8
            if (r4 == 0) goto L_0x00d8
            int r8 = r4.f8479a
            if (r8 == r7) goto L_0x0064
            goto L_0x00d8
        L_0x0064:
            int[] r8 = new int[r7]
            long[] r9 = new long[r7]
            long[] r10 = new long[r7]
            long[] r11 = new long[r7]
            r12 = 0
        L_0x006d:
            if (r12 >= r7) goto L_0x0081
            long r13 = r3.b(r12)
            r11[r12] = r13
            long r13 = r2.f14146q
            long r15 = r4.b(r12)
            long r15 = r15 + r13
            r9[r12] = r15
            int r12 = r12 + 1
            goto L_0x006d
        L_0x0081:
            r3 = 0
        L_0x0082:
            int r4 = r7 + -1
            if (r3 >= r4) goto L_0x0099
            int r4 = r3 + 1
            r12 = r9[r4]
            r14 = r9[r3]
            long r12 = r12 - r14
            int r13 = (int) r12
            r8[r3] = r13
            r12 = r11[r4]
            r14 = r11[r3]
            long r12 = r12 - r14
            r10[r3] = r12
            r3 = r4
            goto L_0x0082
        L_0x0099:
            long r12 = r2.f14146q
            long r14 = r2.f14145p
            long r12 = r12 + r14
            r14 = r9[r4]
            long r12 = r12 - r14
            int r3 = (int) r12
            r8[r4] = r3
            long r12 = r2.f14149t
            r14 = r11[r4]
            long r12 = r12 - r14
            r10[r4] = r12
            int r3 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x00d2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Discarding last cue point with unexpected duration: "
            r3.<init>(r5)
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "MatroskaExtractor"
            j1.v.g(r5, r3)
            int[] r8 = java.util.Arrays.copyOf(r8, r4)
            long[] r9 = java.util.Arrays.copyOf(r9, r4)
            long[] r10 = java.util.Arrays.copyOf(r10, r4)
            long[] r11 = java.util.Arrays.copyOf(r11, r4)
        L_0x00d2:
            d2.n r3 = new d2.n
            r3.<init>(r8, r9, r10, r11)
            goto L_0x00df
        L_0x00d8:
            d2.e0 r3 = new d2.e0
            long r4 = r2.f14149t
            r3.<init>(r4)
        L_0x00df:
            r1.g(r3)
            r1 = 1
            r2.f14151v = r1
        L_0x00e5:
            r1 = 0
            r2.C = r1
            r2.D = r1
            goto L_0x0b00
        L_0x00ec:
            r1 = 0
            int r3 = r3.size()
            if (r3 == 0) goto L_0x00fa
            d2.y r1 = r2.f14131b0
            r1.a()
            goto L_0x0b00
        L_0x00fa:
            java.lang.String r2 = "No valid tracks were found"
            g1.b1 r1 = g1.b1.a(r2, r1)
            throw r1
        L_0x0101:
            long r3 = r2.f14147r
            int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x010c
            r3 = 1000000(0xf4240, double:4.940656E-318)
            r2.f14147r = r3
        L_0x010c:
            long r3 = r2.f14148s
            int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x0b00
            long r3 = r2.l(r3)
            r2.f14149t = r3
            goto L_0x0b00
        L_0x011a:
            r2.f(r1)
            s2.c r1 = r2.f14150u
            boolean r2 = r1.f14103h
            if (r2 == 0) goto L_0x0b00
            byte[] r1 = r1.f14104i
            if (r1 != 0) goto L_0x0129
            goto L_0x0b00
        L_0x0129:
            java.lang.String r1 = "Combining encryption and compression is not supported"
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x0131:
            r2.f(r1)
            s2.c r1 = r2.f14150u
            boolean r3 = r1.f14103h
            if (r3 == 0) goto L_0x0b00
            d2.w0 r3 = r1.f14105j
            if (r3 == 0) goto L_0x015d
            g1.u r3 = new g1.u
            r4 = 1
            g1.t[] r5 = new g1.t[r4]
            g1.t r6 = new g1.t
            java.util.UUID r7 = g1.n.f6473a
            s2.c r2 = r2.f14150u
            d2.w0 r2 = r2.f14105j
            byte[] r2 = r2.f4304b
            java.lang.String r8 = "video/webm"
            r9 = 0
            r6.<init>(r7, r9, r8, r2)
            r2 = 0
            r5[r2] = r6
            r3.<init>(r9, r4, r5)
            r1.f14107l = r3
            goto L_0x0b00
        L_0x015d:
            r1 = 0
            java.lang.String r2 = "Encrypted Track found but ContentEncKeyID was not found"
            g1.b1 r1 = g1.b1.a(r2, r1)
            throw r1
        L_0x0165:
            int r1 = r2.f14152w
            if (r1 == r8) goto L_0x0177
            long r3 = r2.f14153x
            r5 = -1
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x0177
            if (r1 != r7) goto L_0x0b00
            r2.f14155z = r3
            goto L_0x0b00
        L_0x0177:
            java.lang.String r1 = "Mandatory element SeekID or SeekPosition not found"
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        L_0x017f:
            s2.c r1 = r2.f14150u
            j1.a.f(r1)
            java.lang.String r4 = r1.f14097b
            if (r4 == 0) goto L_0x0a7a
            int r5 = r4.hashCode()
            java.lang.String r6 = "A_DTS/LOSSLESS"
            java.lang.String r8 = "S_VOBSUB"
            java.lang.String r9 = "V_MPEG4/ISO/AVC"
            java.lang.String r10 = "V_MPEG4/ISO/ASP"
            java.lang.String r11 = "S_DVBSUB"
            java.lang.String r12 = "V_MS/VFW/FOURCC"
            java.lang.String r13 = "A_MPEG/L3"
            java.lang.String r14 = "A_MPEG/L2"
            java.lang.String r15 = "A_VORBIS"
            java.lang.String r0 = "A_TRUEHD"
            r16 = r3
            java.lang.String r3 = "A_MS/ACM"
            r22 = r1
            java.lang.String r1 = "V_MPEG4/ISO/SP"
            r17 = r2
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            switch(r5) {
                case -2095576542: goto L_0x0340;
                case -2095575984: goto L_0x0337;
                case -1985379776: goto L_0x032e;
                case -1784763192: goto L_0x0325;
                case -1730367663: goto L_0x031c;
                case -1482641358: goto L_0x0313;
                case -1482641357: goto L_0x030a;
                case -1373388978: goto L_0x0301;
                case -933872740: goto L_0x02f7;
                case -538363189: goto L_0x02eb;
                case -538363109: goto L_0x02df;
                case -425012669: goto L_0x02d3;
                case -356037306: goto L_0x02c7;
                case 62923557: goto L_0x02b9;
                case 62923603: goto L_0x02ab;
                case 62927045: goto L_0x029d;
                case 82318131: goto L_0x028f;
                case 82338133: goto L_0x0281;
                case 82338134: goto L_0x0273;
                case 99146302: goto L_0x0265;
                case 444813526: goto L_0x0257;
                case 542569478: goto L_0x0249;
                case 635596514: goto L_0x023b;
                case 725948237: goto L_0x022d;
                case 725957860: goto L_0x021f;
                case 738597099: goto L_0x0211;
                case 855502857: goto L_0x0203;
                case 1045209816: goto L_0x01f5;
                case 1422270023: goto L_0x01e7;
                case 1809237540: goto L_0x01d9;
                case 1950749482: goto L_0x01cb;
                case 1950789798: goto L_0x01bd;
                case 1951062397: goto L_0x01b1;
                default: goto L_0x01af;
            }
        L_0x01af:
            goto L_0x0349
        L_0x01b1:
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L_0x01b9
            goto L_0x0349
        L_0x01b9:
            r4 = 32
            goto L_0x034a
        L_0x01bd:
            java.lang.String r5 = "A_FLAC"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x01c7
            goto L_0x0349
        L_0x01c7:
            r4 = 31
            goto L_0x034a
        L_0x01cb:
            java.lang.String r5 = "A_EAC3"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x01d5
            goto L_0x0349
        L_0x01d5:
            r4 = 30
            goto L_0x034a
        L_0x01d9:
            java.lang.String r5 = "V_MPEG2"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x01e3
            goto L_0x0349
        L_0x01e3:
            r4 = 29
            goto L_0x034a
        L_0x01e7:
            java.lang.String r5 = "S_TEXT/UTF8"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x01f1
            goto L_0x0349
        L_0x01f1:
            r4 = 28
            goto L_0x034a
        L_0x01f5:
            java.lang.String r5 = "S_TEXT/WEBVTT"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x01ff
            goto L_0x0349
        L_0x01ff:
            r4 = 27
            goto L_0x034a
        L_0x0203:
            java.lang.String r5 = "V_MPEGH/ISO/HEVC"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x020d
            goto L_0x0349
        L_0x020d:
            r4 = 26
            goto L_0x034a
        L_0x0211:
            java.lang.String r5 = "S_TEXT/ASS"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x021b
            goto L_0x0349
        L_0x021b:
            r4 = 25
            goto L_0x034a
        L_0x021f:
            java.lang.String r5 = "A_PCM/INT/LIT"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0229
            goto L_0x0349
        L_0x0229:
            r4 = 24
            goto L_0x034a
        L_0x022d:
            java.lang.String r5 = "A_PCM/INT/BIG"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0237
            goto L_0x0349
        L_0x0237:
            r4 = 23
            goto L_0x034a
        L_0x023b:
            java.lang.String r5 = "A_PCM/FLOAT/IEEE"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0245
            goto L_0x0349
        L_0x0245:
            r4 = 22
            goto L_0x034a
        L_0x0249:
            java.lang.String r5 = "A_DTS/EXPRESS"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0253
            goto L_0x0349
        L_0x0253:
            r4 = 21
            goto L_0x034a
        L_0x0257:
            java.lang.String r5 = "V_THEORA"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0261
            goto L_0x0349
        L_0x0261:
            r4 = 20
            goto L_0x034a
        L_0x0265:
            java.lang.String r5 = "S_HDMV/PGS"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x026f
            goto L_0x0349
        L_0x026f:
            r4 = 19
            goto L_0x034a
        L_0x0273:
            java.lang.String r5 = "V_VP9"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x027d
            goto L_0x0349
        L_0x027d:
            r4 = 18
            goto L_0x034a
        L_0x0281:
            java.lang.String r5 = "V_VP8"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x028b
            goto L_0x0349
        L_0x028b:
            r4 = 17
            goto L_0x034a
        L_0x028f:
            java.lang.String r5 = "V_AV1"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0299
            goto L_0x0349
        L_0x0299:
            r4 = 16
            goto L_0x034a
        L_0x029d:
            java.lang.String r5 = "A_DTS"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x02a7
            goto L_0x0349
        L_0x02a7:
            r4 = 15
            goto L_0x034a
        L_0x02ab:
            java.lang.String r5 = "A_AC3"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x02b5
            goto L_0x0349
        L_0x02b5:
            r4 = 14
            goto L_0x034a
        L_0x02b9:
            java.lang.String r5 = "A_AAC"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x02c3
            goto L_0x0349
        L_0x02c3:
            r4 = 13
            goto L_0x034a
        L_0x02c7:
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x02cf
            goto L_0x0349
        L_0x02cf:
            r4 = 12
            goto L_0x034a
        L_0x02d3:
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x02db
            goto L_0x0349
        L_0x02db:
            r4 = 11
            goto L_0x034a
        L_0x02df:
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x02e7
            goto L_0x0349
        L_0x02e7:
            r4 = 10
            goto L_0x034a
        L_0x02eb:
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x02f3
            goto L_0x0349
        L_0x02f3:
            r4 = 9
            goto L_0x034a
        L_0x02f7:
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x02fe
            goto L_0x0349
        L_0x02fe:
            r4 = 8
            goto L_0x034a
        L_0x0301:
            boolean r4 = r4.equals(r12)
            if (r4 != 0) goto L_0x0308
            goto L_0x0349
        L_0x0308:
            r4 = 7
            goto L_0x034a
        L_0x030a:
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x0311
            goto L_0x0349
        L_0x0311:
            r4 = 6
            goto L_0x034a
        L_0x0313:
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x031a
            goto L_0x0349
        L_0x031a:
            r4 = 5
            goto L_0x034a
        L_0x031c:
            boolean r4 = r4.equals(r15)
            if (r4 != 0) goto L_0x0323
            goto L_0x0349
        L_0x0323:
            r4 = 4
            goto L_0x034a
        L_0x0325:
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x032c
            goto L_0x0349
        L_0x032c:
            r4 = 3
            goto L_0x034a
        L_0x032e:
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0335
            goto L_0x0349
        L_0x0335:
            r4 = 2
            goto L_0x034a
        L_0x0337:
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x033e
            goto L_0x0349
        L_0x033e:
            r4 = 1
            goto L_0x034a
        L_0x0340:
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0347
            goto L_0x0349
        L_0x0347:
            r4 = 0
            goto L_0x034a
        L_0x0349:
            r4 = -1
        L_0x034a:
            switch(r4) {
                case 0: goto L_0x034f;
                case 1: goto L_0x034f;
                case 2: goto L_0x034f;
                case 3: goto L_0x034f;
                case 4: goto L_0x034f;
                case 5: goto L_0x034f;
                case 6: goto L_0x034f;
                case 7: goto L_0x034f;
                case 8: goto L_0x034f;
                case 9: goto L_0x034f;
                case 10: goto L_0x034f;
                case 11: goto L_0x034f;
                case 12: goto L_0x034f;
                case 13: goto L_0x034f;
                case 14: goto L_0x034f;
                case 15: goto L_0x034f;
                case 16: goto L_0x034f;
                case 17: goto L_0x034f;
                case 18: goto L_0x034f;
                case 19: goto L_0x034f;
                case 20: goto L_0x034f;
                case 21: goto L_0x034f;
                case 22: goto L_0x034f;
                case 23: goto L_0x034f;
                case 24: goto L_0x034f;
                case 25: goto L_0x034f;
                case 26: goto L_0x034f;
                case 27: goto L_0x034f;
                case 28: goto L_0x034f;
                case 29: goto L_0x034f;
                case 30: goto L_0x034f;
                case 31: goto L_0x034f;
                case 32: goto L_0x034f;
                default: goto L_0x034d;
            }
        L_0x034d:
            r4 = 0
            goto L_0x0350
        L_0x034f:
            r4 = 1
        L_0x0350:
            if (r4 == 0) goto L_0x0a73
            r4 = r17
            d2.y r5 = r4.f14131b0
            r4 = r22
            r22 = r5
            int r5 = r4.f14098c
            r18 = r5
            java.lang.String r5 = r4.f14097b
            r5.getClass()
            int r19 = r5.hashCode()
            switch(r19) {
                case -2095576542: goto L_0x04fb;
                case -2095575984: goto L_0x04f2;
                case -1985379776: goto L_0x04e9;
                case -1784763192: goto L_0x04e0;
                case -1730367663: goto L_0x04d7;
                case -1482641358: goto L_0x04ce;
                case -1482641357: goto L_0x04c5;
                case -1373388978: goto L_0x04bc;
                case -933872740: goto L_0x04b2;
                case -538363189: goto L_0x04a6;
                case -538363109: goto L_0x049a;
                case -425012669: goto L_0x048e;
                case -356037306: goto L_0x0482;
                case 62923557: goto L_0x0474;
                case 62923603: goto L_0x0466;
                case 62927045: goto L_0x0458;
                case 82318131: goto L_0x044a;
                case 82338133: goto L_0x043c;
                case 82338134: goto L_0x042e;
                case 99146302: goto L_0x0420;
                case 444813526: goto L_0x0412;
                case 542569478: goto L_0x0404;
                case 635596514: goto L_0x03f6;
                case 725948237: goto L_0x03e8;
                case 725957860: goto L_0x03da;
                case 738597099: goto L_0x03cc;
                case 855502857: goto L_0x03be;
                case 1045209816: goto L_0x03b0;
                case 1422270023: goto L_0x03a2;
                case 1809237540: goto L_0x0394;
                case 1950749482: goto L_0x0386;
                case 1950789798: goto L_0x0378;
                case 1951062397: goto L_0x036c;
                default: goto L_0x036a;
            }
        L_0x036a:
            goto L_0x0504
        L_0x036c:
            boolean r0 = r5.equals(r7)
            if (r0 != 0) goto L_0x0374
            goto L_0x0504
        L_0x0374:
            r0 = 32
            goto L_0x0505
        L_0x0378:
            java.lang.String r0 = "A_FLAC"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0382
            goto L_0x0504
        L_0x0382:
            r0 = 31
            goto L_0x0505
        L_0x0386:
            java.lang.String r0 = "A_EAC3"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0390
            goto L_0x0504
        L_0x0390:
            r0 = 30
            goto L_0x0505
        L_0x0394:
            java.lang.String r0 = "V_MPEG2"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x039e
            goto L_0x0504
        L_0x039e:
            r0 = 29
            goto L_0x0505
        L_0x03a2:
            java.lang.String r0 = "S_TEXT/UTF8"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03ac
            goto L_0x0504
        L_0x03ac:
            r0 = 28
            goto L_0x0505
        L_0x03b0:
            java.lang.String r0 = "S_TEXT/WEBVTT"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03ba
            goto L_0x0504
        L_0x03ba:
            r0 = 27
            goto L_0x0505
        L_0x03be:
            java.lang.String r0 = "V_MPEGH/ISO/HEVC"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03c8
            goto L_0x0504
        L_0x03c8:
            r0 = 26
            goto L_0x0505
        L_0x03cc:
            java.lang.String r0 = "S_TEXT/ASS"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03d6
            goto L_0x0504
        L_0x03d6:
            r0 = 25
            goto L_0x0505
        L_0x03da:
            java.lang.String r0 = "A_PCM/INT/LIT"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03e4
            goto L_0x0504
        L_0x03e4:
            r0 = 24
            goto L_0x0505
        L_0x03e8:
            java.lang.String r0 = "A_PCM/INT/BIG"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03f2
            goto L_0x0504
        L_0x03f2:
            r0 = 23
            goto L_0x0505
        L_0x03f6:
            java.lang.String r0 = "A_PCM/FLOAT/IEEE"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0400
            goto L_0x0504
        L_0x0400:
            r0 = 22
            goto L_0x0505
        L_0x0404:
            java.lang.String r0 = "A_DTS/EXPRESS"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x040e
            goto L_0x0504
        L_0x040e:
            r0 = 21
            goto L_0x0505
        L_0x0412:
            java.lang.String r0 = "V_THEORA"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x041c
            goto L_0x0504
        L_0x041c:
            r0 = 20
            goto L_0x0505
        L_0x0420:
            java.lang.String r0 = "S_HDMV/PGS"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x042a
            goto L_0x0504
        L_0x042a:
            r0 = 19
            goto L_0x0505
        L_0x042e:
            java.lang.String r0 = "V_VP9"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0438
            goto L_0x0504
        L_0x0438:
            r0 = 18
            goto L_0x0505
        L_0x043c:
            java.lang.String r0 = "V_VP8"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0446
            goto L_0x0504
        L_0x0446:
            r0 = 17
            goto L_0x0505
        L_0x044a:
            java.lang.String r0 = "V_AV1"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0454
            goto L_0x0504
        L_0x0454:
            r0 = 16
            goto L_0x0505
        L_0x0458:
            java.lang.String r0 = "A_DTS"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0462
            goto L_0x0504
        L_0x0462:
            r0 = 15
            goto L_0x0505
        L_0x0466:
            java.lang.String r0 = "A_AC3"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0470
            goto L_0x0504
        L_0x0470:
            r0 = 14
            goto L_0x0505
        L_0x0474:
            java.lang.String r0 = "A_AAC"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x047e
            goto L_0x0504
        L_0x047e:
            r0 = 13
            goto L_0x0505
        L_0x0482:
            boolean r0 = r5.equals(r6)
            if (r0 != 0) goto L_0x048a
            goto L_0x0504
        L_0x048a:
            r0 = 12
            goto L_0x0505
        L_0x048e:
            boolean r0 = r5.equals(r8)
            if (r0 != 0) goto L_0x0496
            goto L_0x0504
        L_0x0496:
            r0 = 11
            goto L_0x0505
        L_0x049a:
            boolean r0 = r5.equals(r9)
            if (r0 != 0) goto L_0x04a2
            goto L_0x0504
        L_0x04a2:
            r0 = 10
            goto L_0x0505
        L_0x04a6:
            boolean r0 = r5.equals(r10)
            if (r0 != 0) goto L_0x04ae
            goto L_0x0504
        L_0x04ae:
            r0 = 9
            goto L_0x0505
        L_0x04b2:
            boolean r0 = r5.equals(r11)
            if (r0 != 0) goto L_0x04b9
            goto L_0x0504
        L_0x04b9:
            r0 = 8
            goto L_0x0505
        L_0x04bc:
            boolean r0 = r5.equals(r12)
            if (r0 != 0) goto L_0x04c3
            goto L_0x0504
        L_0x04c3:
            r0 = 7
            goto L_0x0505
        L_0x04c5:
            boolean r0 = r5.equals(r13)
            if (r0 != 0) goto L_0x04cc
            goto L_0x0504
        L_0x04cc:
            r0 = 6
            goto L_0x0505
        L_0x04ce:
            boolean r0 = r5.equals(r14)
            if (r0 != 0) goto L_0x04d5
            goto L_0x0504
        L_0x04d5:
            r0 = 5
            goto L_0x0505
        L_0x04d7:
            boolean r0 = r5.equals(r15)
            if (r0 != 0) goto L_0x04de
            goto L_0x0504
        L_0x04de:
            r0 = 4
            goto L_0x0505
        L_0x04e0:
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x04e7
            goto L_0x0504
        L_0x04e7:
            r0 = 3
            goto L_0x0505
        L_0x04e9:
            boolean r0 = r5.equals(r3)
            if (r0 != 0) goto L_0x04f0
            goto L_0x0504
        L_0x04f0:
            r0 = 2
            goto L_0x0505
        L_0x04f2:
            boolean r0 = r5.equals(r1)
            if (r0 != 0) goto L_0x04f9
            goto L_0x0504
        L_0x04f9:
            r0 = 1
            goto L_0x0505
        L_0x04fb:
            boolean r0 = r5.equals(r2)
            if (r0 != 0) goto L_0x0502
            goto L_0x0504
        L_0x0502:
            r0 = 0
            goto L_0x0505
        L_0x0504:
            r0 = -1
        L_0x0505:
            java.lang.String r1 = "video/x-unknown"
            java.lang.String r2 = "audio/raw"
            java.lang.String r3 = "MatroskaExtractor"
            switch(r0) {
                case 0: goto L_0x0820;
                case 1: goto L_0x0820;
                case 2: goto L_0x07ad;
                case 3: goto L_0x079e;
                case 4: goto L_0x0714;
                case 5: goto L_0x070e;
                case 6: goto L_0x070b;
                case 7: goto L_0x0672;
                case 8: goto L_0x065d;
                case 9: goto L_0x0820;
                case 10: goto L_0x063b;
                case 11: goto L_0x062d;
                case 12: goto L_0x0629;
                case 13: goto L_0x0603;
                case 14: goto L_0x05ff;
                case 15: goto L_0x05fb;
                case 16: goto L_0x05f7;
                case 17: goto L_0x05f3;
                case 18: goto L_0x05ef;
                case 19: goto L_0x05eb;
                case 20: goto L_0x07a7;
                case 21: goto L_0x05fb;
                case 22: goto L_0x05d7;
                case 23: goto L_0x05bb;
                case 24: goto L_0x05ab;
                case 25: goto L_0x0592;
                case 26: goto L_0x0577;
                case 27: goto L_0x0573;
                case 28: goto L_0x056f;
                case 29: goto L_0x056b;
                case 30: goto L_0x0567;
                case 31: goto L_0x0559;
                case 32: goto L_0x0516;
                default: goto L_0x050e;
            }
        L_0x050e:
            java.lang.String r0 = "Unrecognized codec identifier."
            r1 = 0
            g1.b1 r0 = g1.b1.a(r0, r1)
            throw r0
        L_0x0516:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 3
            r0.<init>(r1)
            java.lang.String r1 = r4.f14097b
            byte[] r1 = r4.a(r1)
            r0.add(r1)
            r1 = 8
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r1)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r5 = r4.R
            java.nio.ByteBuffer r2 = r2.putLong(r5)
            byte[] r2 = r2.array()
            r0.add(r2)
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
            java.nio.ByteBuffer r1 = r1.order(r3)
            long r2 = r4.S
            java.nio.ByteBuffer r1 = r1.putLong(r2)
            byte[] r1 = r1.array()
            r0.add(r1)
            java.lang.String r1 = "audio/opus"
            r2 = 5760(0x1680, float:8.071E-42)
            goto L_0x0771
        L_0x0559:
            java.lang.String r0 = r4.f14097b
            byte[] r0 = r4.a(r0)
            java.util.List r0 = java.util.Collections.singletonList(r0)
            java.lang.String r1 = "audio/flac"
            goto L_0x07a8
        L_0x0567:
            java.lang.String r1 = "audio/eac3"
            goto L_0x07a7
        L_0x056b:
            java.lang.String r1 = "video/mpeg2"
            goto L_0x07a7
        L_0x056f:
            java.lang.String r1 = "application/x-subrip"
            goto L_0x07a7
        L_0x0573:
            java.lang.String r1 = "text/vtt"
            goto L_0x07a7
        L_0x0577:
            j1.b0 r0 = new j1.b0
            java.lang.String r1 = r4.f14097b
            byte[] r1 = r4.a(r1)
            r0.<init>((byte[]) r1)
            d2.h0 r0 = d2.h0.a(r0)
            int r1 = r0.f4197b
            r4.Y = r1
            java.lang.String r1 = "video/hevc"
            java.util.List r2 = r0.f4196a
            java.lang.String r0 = r0.f4202g
            goto L_0x0654
        L_0x0592:
            java.lang.String r0 = r4.f14097b
            byte[] r0 = r4.a(r0)
            byte[] r1 = s2.d.f14123d0
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            r1 = 1
            r2[r1] = r0
            d9.r1 r0 = d9.r0.i(r2)
            java.lang.String r1 = "text/x-ssa"
            goto L_0x07a8
        L_0x05ab:
            int r0 = r4.P
            int r0 = j1.l0.t(r0)
            if (r0 != 0) goto L_0x05de
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unsupported little endian PCM bit depth: "
            r0.<init>(r1)
            goto L_0x05e8
        L_0x05bb:
            int r0 = r4.P
            r1 = 8
            if (r0 != r1) goto L_0x05c8
            r0 = -1
            r1 = 3
            r3 = 0
            r5 = 1
            r6 = 0
            goto L_0x0837
        L_0x05c8:
            r1 = 16
            if (r0 != r1) goto L_0x05cf
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x05de
        L_0x05cf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unsupported big endian PCM bit depth: "
            r0.<init>(r1)
            goto L_0x05e8
        L_0x05d7:
            int r0 = r4.P
            r1 = 32
            if (r0 != r1) goto L_0x05e1
            r0 = 4
        L_0x05de:
            r1 = 1
            goto L_0x0804
        L_0x05e1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unsupported floating point PCM bit depth: "
            r0.<init>(r1)
        L_0x05e8:
            r1 = 1
            goto L_0x07fa
        L_0x05eb:
            java.lang.String r1 = "application/pgs"
            goto L_0x07a7
        L_0x05ef:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            goto L_0x07a7
        L_0x05f3:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            goto L_0x07a7
        L_0x05f7:
            java.lang.String r1 = "video/av01"
            goto L_0x07a7
        L_0x05fb:
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x07a7
        L_0x05ff:
            java.lang.String r1 = "audio/ac3"
            goto L_0x07a7
        L_0x0603:
            java.lang.String r0 = r4.f14097b
            byte[] r0 = r4.a(r0)
            java.util.List r0 = java.util.Collections.singletonList(r0)
            byte[] r1 = r4.f14106k
            j1.a0 r2 = new j1.a0
            int r3 = r1.length
            r2.<init>(r3, r1)
            r1 = 0
            j1.k r1 = d2.a.b(r2, r1)
            int r2 = r1.f8450a
            r4.Q = r2
            int r2 = r1.f8451b
            r4.O = r2
            java.lang.String r2 = "audio/mp4a-latm"
            java.lang.String r1 = r1.f8452c
            r3 = 1
            goto L_0x0831
        L_0x0629:
            java.lang.String r1 = "audio/vnd.dts.hd"
            goto L_0x07a7
        L_0x062d:
            java.lang.String r0 = r4.f14097b
            byte[] r0 = r4.a(r0)
            d9.r1 r0 = d9.r0.n(r0)
            java.lang.String r1 = "application/vobsub"
            goto L_0x07a8
        L_0x063b:
            j1.b0 r0 = new j1.b0
            java.lang.String r1 = r4.f14097b
            byte[] r1 = r4.a(r1)
            r0.<init>((byte[]) r1)
            d2.e r0 = d2.e.a(r0)
            int r1 = r0.f4158b
            r4.Y = r1
            java.lang.String r1 = "video/avc"
            java.util.List r2 = r0.f4157a
            java.lang.String r0 = r0.f4162f
        L_0x0654:
            r3 = 1
            r5 = -1
            r6 = r0
            r3 = r2
            r5 = 1
            r2 = r1
            r1 = -1
            goto L_0x080a
        L_0x065d:
            r0 = 4
            byte[] r1 = new byte[r0]
            java.lang.String r2 = r4.f14097b
            byte[] r2 = r4.a(r2)
            r3 = 0
            java.lang.System.arraycopy(r2, r3, r1, r3, r0)
            d9.r1 r0 = d9.r0.n(r1)
            java.lang.String r1 = "application/dvbsubs"
            goto L_0x07a8
        L_0x0672:
            j1.b0 r0 = new j1.b0
            java.lang.String r2 = r4.f14097b
            byte[] r2 = r4.a(r2)
            r0.<init>((byte[]) r2)
            r2 = 16
            r0.H(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            long r5 = r0.l()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            r7 = 1482049860(0x58564944, double:7.322299212E-315)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x0696
            android.util.Pair r0 = new android.util.Pair     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            java.lang.String r1 = "video/divx"
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0704 }
            goto L_0x06f9
        L_0x0696:
            r7 = 859189832(0x33363248, double:4.244961792E-315)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x06a6
            android.util.Pair r0 = new android.util.Pair     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            java.lang.String r1 = "video/3gpp"
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0704 }
            goto L_0x06f9
        L_0x06a6:
            r7 = 826496599(0x31435657, double:4.08343576E-315)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x06ee
            int r1 = r0.f8415b     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            int r1 = r1 + 20
            byte[] r0 = r0.f8414a     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
        L_0x06b3:
            int r2 = r0.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            int r2 = r2 + -4
            if (r1 >= r2) goto L_0x06e6
            byte r2 = r0[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            if (r2 != 0) goto L_0x06e3
            int r2 = r1 + 1
            byte r2 = r0[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            if (r2 != 0) goto L_0x06e3
            int r2 = r1 + 2
            byte r2 = r0[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            r3 = 1
            if (r2 != r3) goto L_0x06e3
            int r2 = r1 + 3
            byte r2 = r0[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            r3 = 15
            if (r2 != r3) goto L_0x06e3
            int r2 = r0.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            byte[] r0 = java.util.Arrays.copyOfRange(r0, r1, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            java.lang.String r2 = "video/wvc1"
            java.util.List r0 = java.util.Collections.singletonList(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            r1.<init>(r2, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            r0 = r1
            goto L_0x06f9
        L_0x06e3:
            int r1 = r1 + 1
            goto L_0x06b3
        L_0x06e6:
            java.lang.String r0 = "Failed to find FourCC VC1 initialization data"
            r1 = 0
            g1.b1 r0 = g1.b1.a(r0, r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
            throw r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0703 }
        L_0x06ee:
            java.lang.String r0 = "Unknown FourCC. Setting mimeType to video/x-unknown"
            j1.v.g(r3, r0)
            android.util.Pair r0 = new android.util.Pair
            r2 = 0
            r0.<init>(r1, r2)
        L_0x06f9:
            java.lang.Object r1 = r0.first
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.second
            java.util.List r0 = (java.util.List) r0
            goto L_0x07a8
        L_0x0703:
            r2 = 0
        L_0x0704:
            java.lang.String r0 = "Error parsing FourCC private data"
            g1.b1 r0 = g1.b1.a(r0, r2)
            throw r0
        L_0x070b:
            java.lang.String r0 = "audio/mpeg"
            goto L_0x0710
        L_0x070e:
            java.lang.String r0 = "audio/mpeg-L2"
        L_0x0710:
            r1 = 4096(0x1000, float:5.74E-42)
            r2 = 0
            goto L_0x0777
        L_0x0714:
            java.lang.String r0 = r4.f14097b
            byte[] r0 = r4.a(r0)
            java.lang.String r1 = "Error parsing vorbis codec private"
            r2 = 0
            byte r2 = r0[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            r3 = 2
            if (r2 != r3) goto L_0x0792
            r2 = 0
            r3 = 1
        L_0x0724:
            byte r5 = r0[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            if (r5 != r6) goto L_0x0730
            int r2 = r2 + 255
            int r3 = r3 + 1
            goto L_0x0724
        L_0x0730:
            int r3 = r3 + 1
            int r2 = r2 + r5
            r5 = 0
        L_0x0734:
            byte r7 = r0[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            r7 = r7 & r6
            if (r7 != r6) goto L_0x073e
            int r5 = r5 + 255
            int r3 = r3 + 1
            goto L_0x0734
        L_0x073e:
            r6 = 1
            int r3 = r3 + r6
            int r5 = r5 + r7
            byte r7 = r0[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            if (r7 != r6) goto L_0x078c
            byte[] r6 = new byte[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            r7 = 0
            java.lang.System.arraycopy(r0, r3, r6, r7, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            int r3 = r3 + r2
            byte r2 = r0[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            r7 = 3
            if (r2 != r7) goto L_0x0786
            int r3 = r3 + r5
            byte r2 = r0[r3]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            r5 = 5
            if (r2 != r5) goto L_0x0780
            int r2 = r0.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            int r2 = r2 - r3
            byte[] r2 = new byte[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            int r5 = r0.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            int r5 = r5 - r3
            r7 = 0
            java.lang.System.arraycopy(r0, r3, r2, r7, r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            r3 = 2
            r0.<init>(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            r0.add(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            r0.add(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            java.lang.String r1 = "audio/vorbis"
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0771:
            r20 = r2
            r2 = r0
            r0 = r1
            r1 = r20
        L_0x0777:
            r3 = 1
            r5 = 0
            r3 = r2
            r6 = r5
            r5 = 1
            r2 = r0
            r0 = r1
            goto L_0x0836
        L_0x0780:
            r0 = 0
            g1.b1 r2 = g1.b1.a(r1, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0799 }
            throw r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0799 }
        L_0x0786:
            r0 = 0
            g1.b1 r0 = g1.b1.a(r1, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            throw r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
        L_0x078c:
            r0 = 0
            g1.b1 r0 = g1.b1.a(r1, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
            throw r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0798 }
        L_0x0792:
            r0 = 0
            g1.b1 r2 = g1.b1.a(r1, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0799 }
            throw r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0799 }
        L_0x0798:
            r0 = 0
        L_0x0799:
            g1.b1 r0 = g1.b1.a(r1, r0)
            throw r0
        L_0x079e:
            d2.y0 r0 = new d2.y0
            r0.<init>()
            r4.T = r0
            java.lang.String r1 = "audio/true-hd"
        L_0x07a7:
            r0 = 0
        L_0x07a8:
            r2 = 1
            r2 = r1
        L_0x07aa:
            r3 = 1
            goto L_0x0830
        L_0x07ad:
            j1.b0 r0 = new j1.b0
            java.lang.String r1 = r4.f14097b
            byte[] r1 = r4.a(r1)
            r0.<init>((byte[]) r1)
            int r1 = r0.n()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0818 }
            r5 = 1
            if (r1 != r5) goto L_0x07c0
            goto L_0x07e4
        L_0x07c0:
            r6 = 65534(0xfffe, float:9.1833E-41)
            if (r1 != r6) goto L_0x07e6
            r1 = 24
            r0.G(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0818 }
            long r6 = r0.o()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0818 }
            java.util.UUID r1 = s2.d.f14126g0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0818 }
            long r8 = r1.getMostSignificantBits()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0818 }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x07e6
            long r6 = r0.o()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0818 }
            long r0 = r1.getLeastSignificantBits()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0818 }
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 != 0) goto L_0x07e6
        L_0x07e4:
            r0 = 1
            goto L_0x07e7
        L_0x07e6:
            r0 = 0
        L_0x07e7:
            if (r0 == 0) goto L_0x080c
            int r0 = r4.P
            int r0 = j1.l0.t(r0)
            if (r0 != 0) goto L_0x05de
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unsupported PCM bit depth: "
            r0.<init>(r1)
            goto L_0x05e8
        L_0x07fa:
            int r2 = r4.P
            java.lang.String r5 = ". Setting mimeType to audio/x-unknown"
            java.lang.String r0 = android.support.v4.media.h.o(r0, r2, r5)
            r5 = r1
            goto L_0x080e
        L_0x0804:
            r3 = 0
            r5 = 0
            r6 = r3
            r3 = r5
            r5 = r1
            r1 = r0
        L_0x080a:
            r0 = -1
            goto L_0x0837
        L_0x080c:
            java.lang.String r0 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
        L_0x080e:
            j1.v.g(r3, r0)
            java.lang.String r0 = "audio/x-unknown"
            r1 = 0
            r2 = r0
            r0 = r1
            r3 = r5
            goto L_0x0830
        L_0x0818:
            java.lang.String r0 = "Error parsing MS/ACM codec private"
            r1 = 0
            g1.b1 r0 = g1.b1.a(r0, r1)
            throw r0
        L_0x0820:
            r0 = 1
            byte[] r1 = r4.f14106k
            if (r1 != 0) goto L_0x0827
            r1 = 0
            goto L_0x082b
        L_0x0827:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x082b:
            java.lang.String r2 = "video/mp4v-es"
            r0 = r1
            goto L_0x07aa
        L_0x0830:
            r1 = 0
        L_0x0831:
            r5 = -1
            r6 = r1
            r5 = r3
            r3 = r0
            r0 = -1
        L_0x0836:
            r1 = -1
        L_0x0837:
            byte[] r7 = r4.N
            if (r7 == 0) goto L_0x084c
            j1.b0 r7 = new j1.b0
            byte[] r8 = r4.N
            r7.<init>((byte[]) r8)
            j1.k r7 = j1.k.a(r7)
            if (r7 == 0) goto L_0x084c
            java.lang.String r6 = r7.f8452c
            java.lang.String r2 = "video/dolby-vision"
        L_0x084c:
            boolean r7 = r4.V
            r7 = r7 | 0
            boolean r8 = r4.U
            if (r8 == 0) goto L_0x0856
            r8 = 2
            goto L_0x0857
        L_0x0856:
            r8 = 0
        L_0x0857:
            r7 = r7 | r8
            g1.z r8 = new g1.z
            r8.<init>()
            boolean r9 = g1.a1.i(r2)
            if (r9 == 0) goto L_0x086f
            int r9 = r4.O
            r8.f6767x = r9
            int r9 = r4.Q
            r8.f6768y = r9
            r8.f6769z = r1
            goto L_0x0a34
        L_0x086f:
            boolean r1 = g1.a1.k(r2)
            if (r1 == 0) goto L_0x09fa
            int r1 = r4.f14112q
            if (r1 != 0) goto L_0x088b
            int r1 = r4.f14110o
            r5 = -1
            if (r1 != r5) goto L_0x0880
            int r1 = r4.f14108m
        L_0x0880:
            r4.f14110o = r1
            int r1 = r4.f14111p
            if (r1 != r5) goto L_0x0888
            int r1 = r4.f14109n
        L_0x0888:
            r4.f14111p = r1
            goto L_0x088c
        L_0x088b:
            r5 = -1
        L_0x088c:
            int r1 = r4.f14110o
            if (r1 == r5) goto L_0x08a0
            int r9 = r4.f14111p
            if (r9 == r5) goto L_0x08a0
            int r5 = r4.f14109n
            int r5 = r5 * r1
            float r1 = (float) r5
            int r5 = r4.f14108m
            int r5 = r5 * r9
            float r5 = (float) r5
            float r1 = r1 / r5
            goto L_0x08a2
        L_0x08a0:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x08a2:
            boolean r5 = r4.f14119x
            if (r5 == 0) goto L_0x0977
            float r5 = r4.D
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x096a
            float r5 = r4.E
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x096a
            float r5 = r4.F
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x096a
            float r5 = r4.G
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x096a
            float r5 = r4.H
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x096a
            float r5 = r4.I
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x096a
            float r5 = r4.J
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x096a
            float r5 = r4.K
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x096a
            float r5 = r4.L
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x096a
            float r5 = r4.M
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x08e6
            goto L_0x096a
        L_0x08e6:
            r5 = 25
            byte[] r5 = new byte[r5]
            java.nio.ByteBuffer r9 = java.nio.ByteBuffer.wrap(r5)
            java.nio.ByteOrder r10 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r9 = r9.order(r10)
            r10 = 0
            r9.put(r10)
            float r10 = r4.D
            r11 = 1195593728(0x47435000, float:50000.0)
            float r10 = r10 * r11
            r12 = 1056964608(0x3f000000, float:0.5)
            float r10 = r10 + r12
            int r10 = (int) r10
            short r10 = (short) r10
            r9.putShort(r10)
            float r10 = r4.E
            float r10 = r10 * r11
            float r10 = r10 + r12
            int r10 = (int) r10
            short r10 = (short) r10
            r9.putShort(r10)
            float r10 = r4.F
            float r10 = r10 * r11
            float r10 = r10 + r12
            int r10 = (int) r10
            short r10 = (short) r10
            r9.putShort(r10)
            float r10 = r4.G
            float r10 = r10 * r11
            float r10 = r10 + r12
            int r10 = (int) r10
            short r10 = (short) r10
            r9.putShort(r10)
            float r10 = r4.H
            float r10 = r10 * r11
            float r10 = r10 + r12
            int r10 = (int) r10
            short r10 = (short) r10
            r9.putShort(r10)
            float r10 = r4.I
            float r10 = r10 * r11
            float r10 = r10 + r12
            int r10 = (int) r10
            short r10 = (short) r10
            r9.putShort(r10)
            float r10 = r4.J
            float r10 = r10 * r11
            float r10 = r10 + r12
            int r10 = (int) r10
            short r10 = (short) r10
            r9.putShort(r10)
            float r10 = r4.K
            float r10 = r10 * r11
            float r10 = r10 + r12
            int r10 = (int) r10
            short r10 = (short) r10
            r9.putShort(r10)
            float r10 = r4.L
            float r10 = r10 + r12
            int r10 = (int) r10
            short r10 = (short) r10
            r9.putShort(r10)
            float r10 = r4.M
            float r10 = r10 + r12
            int r10 = (int) r10
            short r10 = (short) r10
            r9.putShort(r10)
            int r10 = r4.B
            short r10 = (short) r10
            r9.putShort(r10)
            int r10 = r4.C
            short r10 = (short) r10
            r9.putShort(r10)
            goto L_0x096b
        L_0x096a:
            r5 = 0
        L_0x096b:
            g1.o r9 = new g1.o
            int r10 = r4.f14120y
            int r11 = r4.A
            int r12 = r4.f14121z
            r9.<init>(r10, r11, r12, r5)
            goto L_0x0978
        L_0x0977:
            r9 = 0
        L_0x0978:
            java.lang.String r5 = r4.f14096a
            if (r5 == 0) goto L_0x0991
            java.util.Map r10 = s2.d.f14127h0
            boolean r5 = r10.containsKey(r5)
            if (r5 == 0) goto L_0x0991
            java.lang.String r5 = r4.f14096a
            java.lang.Object r5 = r10.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L_0x0992
        L_0x0991:
            r5 = -1
        L_0x0992:
            int r10 = r4.f14113r
            if (r10 != 0) goto L_0x09e2
            float r10 = r4.f14114s
            r11 = 0
            int r10 = java.lang.Float.compare(r10, r11)
            if (r10 != 0) goto L_0x09e2
            float r10 = r4.f14115t
            int r10 = java.lang.Float.compare(r10, r11)
            if (r10 != 0) goto L_0x09e2
            float r10 = r4.f14116u
            int r10 = java.lang.Float.compare(r10, r11)
            if (r10 != 0) goto L_0x09b1
            r5 = 0
            goto L_0x09e2
        L_0x09b1:
            float r10 = r4.f14115t
            r11 = 1119092736(0x42b40000, float:90.0)
            int r10 = java.lang.Float.compare(r10, r11)
            if (r10 != 0) goto L_0x09be
            r5 = 90
            goto L_0x09e2
        L_0x09be:
            float r10 = r4.f14115t
            r11 = -1020002304(0xffffffffc3340000, float:-180.0)
            int r10 = java.lang.Float.compare(r10, r11)
            if (r10 == 0) goto L_0x09e0
            float r10 = r4.f14115t
            r11 = 1127481344(0x43340000, float:180.0)
            int r10 = java.lang.Float.compare(r10, r11)
            if (r10 != 0) goto L_0x09d3
            goto L_0x09e0
        L_0x09d3:
            float r10 = r4.f14115t
            r11 = -1028390912(0xffffffffc2b40000, float:-90.0)
            int r10 = java.lang.Float.compare(r10, r11)
            if (r10 != 0) goto L_0x09e2
            r5 = 270(0x10e, float:3.78E-43)
            goto L_0x09e2
        L_0x09e0:
            r5 = 180(0xb4, float:2.52E-43)
        L_0x09e2:
            int r10 = r4.f14108m
            r8.f6759p = r10
            int r10 = r4.f14109n
            r8.f6760q = r10
            r8.f6763t = r1
            r8.f6762s = r5
            byte[] r1 = r4.f14117v
            r8.f6764u = r1
            int r1 = r4.f14118w
            r8.f6765v = r1
            r8.f6766w = r9
            r5 = 2
            goto L_0x0a34
        L_0x09fa:
            java.lang.String r1 = "application/x-subrip"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0a33
            java.lang.String r1 = "text/x-ssa"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0a33
            java.lang.String r1 = "text/vtt"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0a33
            java.lang.String r1 = "application/vobsub"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0a33
            java.lang.String r1 = "application/pgs"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0a33
            java.lang.String r1 = "application/dvbsubs"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0a2b
            goto L_0x0a33
        L_0x0a2b:
            java.lang.String r0 = "Unexpected MIME type."
            r1 = 0
            g1.b1 r0 = g1.b1.a(r0, r1)
            throw r0
        L_0x0a33:
            r5 = 3
        L_0x0a34:
            java.lang.String r1 = r4.f14096a
            if (r1 == 0) goto L_0x0a44
            java.util.Map r9 = s2.d.f14127h0
            boolean r1 = r9.containsKey(r1)
            if (r1 != 0) goto L_0x0a44
            java.lang.String r1 = r4.f14096a
            r8.f6745b = r1
        L_0x0a44:
            r1 = r18
            r8.b(r1)
            r8.f6754k = r2
            r8.f6755l = r0
            java.lang.String r0 = r4.W
            r8.f6746c = r0
            r8.f6747d = r7
            r8.f6756m = r3
            r8.f6751h = r6
            g1.u r0 = r4.f14107l
            r8.f6757n = r0
            g1.a0 r0 = r8.a()
            int r1 = r4.f14098c
            r2 = r22
            d2.x0 r1 = r2.d(r1, r5)
            r4.X = r1
            r1.a(r0)
            int r0 = r4.f14098c
            r1 = r16
            r1.put(r0, r4)
        L_0x0a73:
            r0 = 0
            r2 = r17
            r2.f14150u = r0
            goto L_0x0b00
        L_0x0a7a:
            r0 = 0
            java.lang.String r1 = "CodecId is missing in TrackEntry element"
            g1.b1 r0 = g1.b1.a(r1, r0)
            throw r0
        L_0x0a82:
            r1 = r3
            int r0 = r2.G
            r3 = 2
            if (r0 == r3) goto L_0x0a8a
            goto L_0x0b00
        L_0x0a8a:
            int r0 = r2.M
            java.lang.Object r0 = r1.get(r0)
            s2.c r0 = (s2.c) r0
            d2.x0 r1 = r0.X
            r1.getClass()
            long r3 = r2.R
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0ac4
            java.lang.String r1 = r0.f14097b
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x0ac4
            r1 = 8
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r1 = r1.order(r3)
            long r3 = r2.R
            java.nio.ByteBuffer r1 = r1.putLong(r3)
            byte[] r1 = r1.array()
            j1.b0 r3 = r2.f14143n
            r3.getClass()
            int r4 = r1.length
            r3.E(r4, r1)
        L_0x0ac4:
            r1 = 0
            r3 = 0
        L_0x0ac6:
            int r4 = r2.K
            if (r1 >= r4) goto L_0x0ad2
            int[] r4 = r2.L
            r4 = r4[r1]
            int r3 = r3 + r4
            int r1 = r1 + 1
            goto L_0x0ac6
        L_0x0ad2:
            r1 = 0
        L_0x0ad3:
            int r4 = r2.K
            if (r1 >= r4) goto L_0x0afd
            long r4 = r2.H
            int r6 = r0.f14100e
            int r6 = r6 * r1
            int r6 = r6 / 1000
            long r6 = (long) r6
            long r5 = r4 + r6
            int r4 = r2.O
            if (r1 != 0) goto L_0x0aec
            boolean r7 = r2.Q
            if (r7 != 0) goto L_0x0aec
            r4 = r4 | 1
        L_0x0aec:
            r7 = r4
            int[] r4 = r2.L
            r8 = r4[r1]
            int r10 = r3 - r8
            r3 = r2
            r4 = r0
            r9 = r10
            r3.g(r4, r5, r7, r8, r9)
            int r1 = r1 + 1
            r3 = r10
            goto L_0x0ad3
        L_0x0afd:
            r0 = 0
            r2.G = r0
        L_0x0b00:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.E(int):void");
    }

    public final androidx.appcompat.widget.b0 F(ProviderInfo providerInfo, PackageManager packageManager) {
        String str = providerInfo.authority;
        String str2 = providerInfo.packageName;
        Signature[] b10 = ((c) this.f4852i).b(packageManager, str2);
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : b10) {
            arrayList.add(byteArray.toByteArray());
        }
        return new androidx.appcompat.widget.b0(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
    }

    public final void G(Exception exc) {
        v.d("MediaCodecAudioRenderer", "Audio sink error", exc);
        n nVar = ((j0) this.f4852i).K0;
        Handler handler = (Handler) nVar.f337i;
        if (handler != null) {
            handler.post(new o1.c(nVar, exc, 1));
        }
    }

    public final void H() {
        Object obj = this.f4852i;
        p pVar = (p) obj;
        int i10 = pVar.f13223z - 1;
        pVar.f13223z = i10;
        if (i10 <= 0) {
            int i11 = 0;
            for (q1.v vVar : ((p) obj).B) {
                vVar.i();
                i11 += vVar.P.f15716h;
            }
            v1[] v1VarArr = new v1[i11];
            int i12 = 0;
            for (q1.v vVar2 : ((p) this.f4852i).B) {
                vVar2.i();
                int i13 = vVar2.P.f15716h;
                int i14 = 0;
                while (i14 < i13) {
                    vVar2.i();
                    v1VarArr[i12] = vVar2.P.i(i14);
                    i14++;
                    i12++;
                }
            }
            ((p) this.f4852i).A = new l1(v1VarArr);
            Object obj2 = this.f4852i;
            ((p) obj2).f13222y.h((p) obj2);
        }
    }

    public final void a(o oVar, boolean z10) {
        if (oVar instanceof m.i0) {
            oVar.k().c(false);
        }
        b0 b0Var = ((androidx.appcompat.widget.n) this.f4852i).f948l;
        if (b0Var != null) {
            b0Var.a(oVar, z10);
        }
    }

    public final int b() {
        return ((ContentInfo) this.f4852i).getFlags();
    }

    public final boolean c() {
        for (d1 c10 : (d1[]) this.f4852i) {
            if (c10.c()) {
                return true;
            }
        }
        return false;
    }

    public final ClipData d() {
        return ((ContentInfo) this.f4852i).getClip();
    }

    public final boolean e(o oVar, MenuItem menuItem) {
        switch (this.f4851h) {
            case Constants.MAX_COMPATIBILITY_VERSION:
                r rVar = ((ActionMenuView) this.f4852i).H;
                if (rVar == null || !((w4) rVar).f1120h.N.G()) {
                    return false;
                }
                return true;
            default:
                i3 i3Var = (i3) ((j3) this.f4852i).f898e;
                if (i3Var != null) {
                    return i3Var.onMenuItemClick(menuItem);
                }
                return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: m.h} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(m.o r6, m.q r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f4852i
            m.i r0 = (m.i) r0
            android.os.Handler r0 = r0.f9943n
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            java.lang.Object r0 = r5.f4852i
            m.i r0 = (m.i) r0
            java.util.ArrayList r0 = r0.f9945p
            int r0 = r0.size()
            r2 = 0
        L_0x0015:
            r3 = -1
            if (r2 >= r0) goto L_0x002c
            java.lang.Object r4 = r5.f4852i
            m.i r4 = (m.i) r4
            java.util.ArrayList r4 = r4.f9945p
            java.lang.Object r4 = r4.get(r2)
            m.h r4 = (m.h) r4
            m.o r4 = r4.f9918b
            if (r6 != r4) goto L_0x0029
            goto L_0x002d
        L_0x0029:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x002c:
            r2 = -1
        L_0x002d:
            if (r2 != r3) goto L_0x0030
            return
        L_0x0030:
            int r2 = r2 + 1
            java.lang.Object r0 = r5.f4852i
            m.i r0 = (m.i) r0
            java.util.ArrayList r0 = r0.f9945p
            int r0 = r0.size()
            if (r2 >= r0) goto L_0x004b
            java.lang.Object r0 = r5.f4852i
            m.i r0 = (m.i) r0
            java.util.ArrayList r0 = r0.f9945p
            java.lang.Object r0 = r0.get(r2)
            r1 = r0
            m.h r1 = (m.h) r1
        L_0x004b:
            m.g r0 = new m.g
            r0.<init>(r5, r1, r7, r6)
            long r1 = android.os.SystemClock.uptimeMillis()
            r3 = 200(0xc8, double:9.9E-322)
            long r1 = r1 + r3
            java.lang.Object r7 = r5.f4852i
            m.i r7 = (m.i) r7
            android.os.Handler r7 = r7.f9943n
            r7.postAtTime(r0, r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.g(m.o, m.q):void");
    }

    public void i(int i10) {
    }

    public final long j() {
        long j10 = Long.MAX_VALUE;
        for (d1 j11 : (d1[]) this.f4852i) {
            long j12 = j11.j();
            if (j12 != Long.MIN_VALUE) {
                j10 = Math.min(j10, j12);
            }
        }
        if (j10 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j10;
    }

    public final void l(o oVar) {
        switch (this.f4851h) {
            case Constants.MAX_COMPATIBILITY_VERSION:
                m mVar = ((ActionMenuView) this.f4852i).C;
                if (mVar != null) {
                    mVar.l(oVar);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final boolean n(o oVar) {
        Object obj = this.f4852i;
        if (oVar == ((androidx.appcompat.widget.n) obj).f946j) {
            return false;
        }
        ((androidx.appcompat.widget.n) obj).F = ((m.i0) oVar).A.f9999a;
        b0 b0Var = ((androidx.appcompat.widget.n) obj).f948l;
        if (b0Var != null) {
            return b0Var.n(oVar);
        }
        return false;
    }

    public final void q() {
        p3.h.f12545b.getClass();
    }

    public final void r(d1 d1Var) {
        q1.v vVar = (q1.v) d1Var;
        p pVar = (p) this.f4852i;
        pVar.f13222y.r(pVar);
    }

    public final ContentInfo s() {
        return (ContentInfo) this.f4852i;
    }

    public final void t(int i10, Object obj) {
        p3.h.f12545b.t(i10, obj);
        ((ProfileInstallReceiver) this.f4852i).setResultCode(i10);
    }

    public final String toString() {
        switch (this.f4851h) {
            case 12:
                return "ContentInfoCompat{" + ((ContentInfo) this.f4852i) + "}";
            default:
                return super.toString();
        }
    }

    public final long u() {
        long j10 = Long.MAX_VALUE;
        for (d1 u10 : (d1[]) this.f4852i) {
            long u11 = u10.u();
            if (u11 != Long.MIN_VALUE) {
                j10 = Math.min(j10, u11);
            }
        }
        if (j10 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j10;
    }

    public final void w(o oVar, MenuItem menuItem) {
        ((i) this.f4852i).f9943n.removeCallbacksAndMessages(oVar);
    }

    public void x(int i10) {
    }

    public final int z() {
        return ((ContentInfo) this.f4852i).getSource();
    }

    public a(int i10) {
        this.f4851h = 21;
        this.f4852i = new q1.e(5);
    }

    public /* synthetic */ a(int i10, Object obj) {
        this.f4851h = i10;
        this.f4852i = obj;
    }

    public a(ClipData clipData, int i10) {
        this.f4851h = 11;
        this.f4852i = Build.VERSION.SDK_INT >= 31 ? new m0.e(clipData, i10) : new m0.g(clipData, i10);
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [p0.f] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.net.Uri r8, android.content.ClipDescription r9, android.net.Uri r10) {
        /*
            r7 = this;
            r0 = 15
            r7.f4851h = r0
            r7.<init>()
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 25
            if (r0 < r1) goto L_0x0013
            p0.f r0 = new p0.f
            r0.<init>(r8, r9, r10)
            goto L_0x001e
        L_0x0013:
            android.support.v4.media.session.u r0 = new android.support.v4.media.session.u
            r5 = 7
            r6 = 0
            r1 = r0
            r2 = r8
            r3 = r9
            r4 = r10
            r1.<init>((java.lang.Object) r2, (java.lang.Object) r3, (java.lang.Object) r4, (int) r5, (int) r6)
        L_0x001e:
            r7.f4852i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.<init>(android.net.Uri, android.content.ClipDescription, android.net.Uri):void");
    }

    public a(ContentInfo contentInfo) {
        this.f4851h = 12;
        contentInfo.getClass();
        this.f4852i = b0.b0.o(contentInfo);
    }

    public a(Window window, View view) {
        this.f4851h = 14;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f4852i = new u2(window);
        } else {
            this.f4852i = i10 >= 26 ? new t2(window, view) : i10 >= 23 ? new s2(window, view) : new r2(window, view);
        }
    }

    public a(TextView textView) {
        this.f4851h = 18;
        if (textView != null) {
            this.f4852i = new w0.m(textView);
            return;
        }
        throw new NullPointerException("textView cannot be null");
    }

    public a(g1.h hVar) {
        this.f4851h = 19;
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(hVar.f6393h).setFlags(hVar.f6394i).setUsage(hVar.f6395j);
        int i10 = l0.f8453a;
        if (i10 >= 29) {
            g1.d.a(usage, hVar.f6396k);
        }
        if (i10 >= 32) {
            f.a(usage, hVar.f6397l);
        }
        this.f4852i = usage.build();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(g1.h hVar, int i10) {
        this(hVar);
        this.f4851h = 19;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(b3 b3Var) {
        this(26, (Object) b3Var);
        this.f4851h = 26;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(r3 r3Var, Object obj, wa.a aVar) {
        this(r3Var, obj, aVar, 0);
        this.f4851h = 27;
        j.f("pagingSourceFactory", aVar);
    }

    public a(r3 r3Var, Object obj, wa.a aVar, int i10) {
        this.f4851h = 27;
        j.f("pagingSourceFactory", aVar);
        this.f4852i = new i2(new p3(aVar, (pa.e) null), obj, r3Var).f11255f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(r3 r3Var, wa.a aVar) {
        this(r3Var, (Object) null, aVar);
        this.f4851h = 27;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(j0 j0Var) {
        this(20, (Object) j0Var);
        this.f4851h = 20;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(p pVar) {
        this(22, (Object) pVar);
        this.f4851h = 22;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(s2.d dVar) {
        this(25, (Object) dVar);
        this.f4851h = 25;
    }
}
