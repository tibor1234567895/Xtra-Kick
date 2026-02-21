package androidx.lifecycle;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcelable;
import android.support.v4.media.session.u;
import android.view.ViewGroup;
import androidx.activity.f;
import androidx.fragment.app.c1;
import androidx.navigation.fragment.NavHostFragment;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel;
import com.github.andreyasadchy.xtra.ui.follow.games.FollowedGamesViewModel;
import com.github.andreyasadchy.xtra.ui.games.GameMediaFragment;
import com.github.andreyasadchy.xtra.ui.games.GamePagerFragment;
import com.github.andreyasadchy.xtra.ui.games.GamePagerViewModel;
import com.github.andreyasadchy.xtra.ui.games.GamesViewModel;
import com.github.andreyasadchy.xtra.ui.player.clip.ClipPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel;
import com.github.andreyasadchy.xtra.ui.streams.common.StreamsViewModel;
import com.github.andreyasadchy.xtra.ui.streams.followed.FollowedStreamsViewModel;
import com.woxthebox.draglistview.R;
import e6.x;
import hb.d1;
import hb.h0;
import hb.u1;
import j3.j1;
import j3.k0;
import j3.l0;
import j3.l1;
import j3.n0;
import j3.q2;
import j3.v;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kb.e1;
import l3.e;
import l3.m;
import la.o;
import m.d;
import ma.l;
import ma.s;
import n3.n4;
import p9.b;
import pa.h;
import pb.m0;
import r7.q;
import tb.g;
import u3.c;
import v3.i;
import wa.a;
import xa.j;
import xa.k;
import y9.p;

public final class p1 extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1738h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1739i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p1(int i10, Object obj) {
        super(0);
        this.f1738h = i10;
        this.f1739i = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0234, code lost:
        if (r3 == false) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0064, code lost:
        if (j4.p.f8772a.contains(r11) != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0286, code lost:
        if (r6 == false) goto L_0x0288;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02a9, code lost:
        if (r6 == null) goto L_0x02ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02b8, code lost:
        if (r6 == null) goto L_0x02ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d4, code lost:
        if (r12 != false) goto L_0x00d6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j4.h a() {
        /*
            r18 = this;
            r1 = r18
            r0 = 26
            int r2 = r1.f1738h
            java.lang.Object r3 = r1.f1739i
            r4 = 0
            r5 = 0
            r6 = 1
            switch(r2) {
                case 7: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0307
        L_0x0010:
            j4.f r3 = (j4.f) r3
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            j4.c r7 = new j4.c
            j4.e0 r8 = r3.f8746a
            dc.l r9 = r8.v()
            r7.<init>(r9)
            dc.i0 r9 = hb.h0.o(r7)
            r2.inJustDecodeBounds = r6
            dc.g0 r10 = new dc.g0
            r10.<init>(r9)
            dc.i0 r10 = hb.h0.o(r10)
            dc.h r10 = r10.G0()
            android.graphics.BitmapFactory.decodeStream(r10, r4, r2)
            java.lang.Exception r10 = r7.f8735h
            if (r10 != 0) goto L_0x0306
            r2.inJustDecodeBounds = r5
            j4.o r10 = j4.o.f8770a
            java.lang.String r11 = r2.outMimeType
            r10.getClass()
            java.util.LinkedHashSet r10 = j4.p.f8772a
            int r10 = r3.f8749d
            int r10 = s.i.a(r10)
            r12 = 2
            if (r10 == 0) goto L_0x0067
            if (r10 == r6) goto L_0x005c
            if (r10 != r12) goto L_0x0056
        L_0x0054:
            r10 = 1
            goto L_0x0068
        L_0x0056:
            la.g r0 = new la.g
            r0.<init>()
            throw r0
        L_0x005c:
            if (r11 == 0) goto L_0x0067
            java.util.LinkedHashSet r10 = j4.p.f8772a
            boolean r10 = r10.contains(r11)
            if (r10 == 0) goto L_0x0067
            goto L_0x0054
        L_0x0067:
            r10 = 0
        L_0x0068:
            r11 = 90
            r13 = 270(0x10e, float:3.78E-43)
            if (r10 == 0) goto L_0x00ae
            x0.g r10 = new x0.g
            j4.n r14 = new j4.n
            dc.g0 r15 = new dc.g0
            r15.<init>(r9)
            dc.i0 r15 = hb.h0.o(r15)
            dc.h r15 = r15.G0()
            r14.<init>((java.io.InputStream) r15)
            r10.<init>(r14)
            j4.m r14 = new j4.m
            int r15 = r10.c()
            if (r15 == r12) goto L_0x0098
            r12 = 7
            if (r15 == r12) goto L_0x0098
            r12 = 4
            if (r15 == r12) goto L_0x0098
            r12 = 5
            if (r15 == r12) goto L_0x0098
            r12 = 0
            goto L_0x0099
        L_0x0098:
            r12 = 1
        L_0x0099:
            int r10 = r10.c()
            switch(r10) {
                case 3: goto L_0x00a8;
                case 4: goto L_0x00a8;
                case 5: goto L_0x00a5;
                case 6: goto L_0x00a2;
                case 7: goto L_0x00a2;
                case 8: goto L_0x00a5;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            r10 = 0
            goto L_0x00aa
        L_0x00a2:
            r10 = 90
            goto L_0x00aa
        L_0x00a5:
            r10 = 270(0x10e, float:3.78E-43)
            goto L_0x00aa
        L_0x00a8:
            r10 = 180(0xb4, float:2.52E-43)
        L_0x00aa:
            r14.<init>(r10, r12)
            goto L_0x00b0
        L_0x00ae:
            j4.m r14 = j4.m.f8764c
        L_0x00b0:
            java.lang.Exception r10 = r7.f8735h
            if (r10 != 0) goto L_0x0305
            r2.inMutable = r5
            int r10 = android.os.Build.VERSION.SDK_INT
            s4.m r3 = r3.f8747b
            if (r10 < r0) goto L_0x00c3
            android.graphics.ColorSpace r12 = r3.f14278c
            if (r12 == 0) goto L_0x00c3
            r2.inPreferredColorSpace = r12
        L_0x00c3:
            boolean r12 = r3.f14283h
            r2.inPremultiplied = r12
            boolean r12 = r14.f8765a
            int r15 = r14.f8766b
            android.graphics.Bitmap$Config r4 = r3.f14277b
            if (r12 != 0) goto L_0x00d6
            if (r15 <= 0) goto L_0x00d3
            r12 = 1
            goto L_0x00d4
        L_0x00d3:
            r12 = 0
        L_0x00d4:
            if (r12 == 0) goto L_0x00e0
        L_0x00d6:
            if (r4 == 0) goto L_0x00de
            boolean r12 = hb.h0.V0(r4)
            if (r12 == 0) goto L_0x00e0
        L_0x00de:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
        L_0x00e0:
            boolean r12 = r3.f14282g
            if (r12 == 0) goto L_0x00f4
            android.graphics.Bitmap$Config r12 = android.graphics.Bitmap.Config.ARGB_8888
            if (r4 != r12) goto L_0x00f4
            java.lang.String r12 = r2.outMimeType
            java.lang.String r5 = "image/jpeg"
            boolean r5 = xa.j.a(r12, r5)
            if (r5 == 0) goto L_0x00f4
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
        L_0x00f4:
            if (r10 < r0) goto L_0x010a
            android.graphics.Bitmap$Config r0 = r2.outConfig
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.RGBA_F16
            if (r0 != r5) goto L_0x010a
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.HARDWARE
            if (r4 == r0) goto L_0x010a
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGBA_F16
        L_0x010a:
            r2.inPreferredConfig = r4
            j4.d0 r0 = r8.k()
            boolean r4 = r0 instanceof j4.g0
            android.content.Context r5 = r3.f14276a
            t4.g r8 = r3.f14279d
            if (r4 == 0) goto L_0x0139
            boolean r4 = hb.h0.Z0(r8)
            if (r4 == 0) goto L_0x0139
            r2.inSampleSize = r6
            r2.inScaled = r6
            j4.g0 r0 = (j4.g0) r0
            int r0 = r0.f8755c
            r2.inDensity = r0
            android.content.res.Resources r0 = r5.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.densityDpi
            r2.inTargetDensity = r0
            r16 = r7
            r4 = r14
            goto L_0x020a
        L_0x0139:
            int r0 = r2.outWidth
            if (r0 <= 0) goto L_0x0201
            int r4 = r2.outHeight
            if (r4 > 0) goto L_0x0143
            goto L_0x0201
        L_0x0143:
            if (r15 == r11) goto L_0x014a
            if (r15 != r13) goto L_0x0148
            goto L_0x014a
        L_0x0148:
            r10 = 0
            goto L_0x014b
        L_0x014a:
            r10 = 1
        L_0x014b:
            if (r10 == 0) goto L_0x014f
            r10 = r4
            goto L_0x0150
        L_0x014f:
            r10 = r0
        L_0x0150:
            if (r15 == r11) goto L_0x0157
            if (r15 != r13) goto L_0x0155
            goto L_0x0157
        L_0x0155:
            r12 = 0
            goto L_0x0158
        L_0x0157:
            r12 = 1
        L_0x0158:
            if (r12 == 0) goto L_0x015b
            goto L_0x015c
        L_0x015b:
            r0 = r4
        L_0x015c:
            boolean r4 = hb.h0.Z0(r8)
            int r12 = r3.f14280e
            if (r4 == 0) goto L_0x0166
            r4 = r10
            goto L_0x016c
        L_0x0166:
            t4.c r4 = r8.f14548a
            int r4 = w4.e.e(r4, r12)
        L_0x016c:
            boolean r16 = hb.h0.Z0(r8)
            if (r16 == 0) goto L_0x0174
            r8 = r0
            goto L_0x017a
        L_0x0174:
            t4.c r8 = r8.f14549b
            int r8 = w4.e.e(r8, r12)
        L_0x017a:
            int r16 = j4.i.f8763a
            int r16 = r10 / r4
            int r13 = java.lang.Integer.highestOneBit(r16)
            int r16 = r0 / r8
            int r11 = java.lang.Integer.highestOneBit(r16)
            int r1 = s.i.a(r12)
            if (r1 == 0) goto L_0x019b
            if (r1 != r6) goto L_0x0195
            int r1 = java.lang.Math.max(r13, r11)
            goto L_0x019f
        L_0x0195:
            la.g r0 = new la.g
            r0.<init>()
            throw r0
        L_0x019b:
            int r1 = java.lang.Math.min(r13, r11)
        L_0x019f:
            if (r1 >= r6) goto L_0x01a2
            r1 = 1
        L_0x01a2:
            r2.inSampleSize = r1
            double r10 = (double) r10
            r16 = r7
            double r6 = (double) r1
            double r10 = r10 / r6
            double r0 = (double) r0
            double r0 = r0 / r6
            double r6 = (double) r4
            r4 = r14
            double r13 = (double) r8
            double r6 = r6 / r10
            double r0 = r13 / r0
            int r8 = s.i.a(r12)
            if (r8 == 0) goto L_0x01c5
            r10 = 1
            if (r8 != r10) goto L_0x01bf
            double r0 = java.lang.Math.min(r6, r0)
            goto L_0x01c9
        L_0x01bf:
            la.g r0 = new la.g
            r0.<init>()
            throw r0
        L_0x01c5:
            double r0 = java.lang.Math.max(r6, r0)
        L_0x01c9:
            boolean r3 = r3.f14281f
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r3 == 0) goto L_0x01d4
            int r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x01d4
            r0 = r6
        L_0x01d4:
            int r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x01db
            r3 = 1
            r13 = 1
            goto L_0x01dd
        L_0x01db:
            r3 = 1
            r13 = 0
        L_0x01dd:
            r8 = r13 ^ 1
            r2.inScaled = r8
            if (r8 == 0) goto L_0x020a
            r3 = 2147483647(0x7fffffff, float:NaN)
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x01f5
            double r6 = (double) r3
            double r6 = r6 / r0
            int r0 = za.b.a(r6)
            r2.inDensity = r0
            r2.inTargetDensity = r3
            goto L_0x020a
        L_0x01f5:
            r2.inDensity = r3
            double r6 = (double) r3
            double r6 = r6 * r0
            int r0 = za.b.a(r6)
            r2.inTargetDensity = r0
            goto L_0x020a
        L_0x0201:
            r16 = r7
            r4 = r14
            r0 = 1
            r2.inSampleSize = r0
            r0 = 0
            r2.inScaled = r0
        L_0x020a:
            dc.h r0 = r9.G0()     // Catch:{ all -> 0x02fc }
            r1 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0, r1, r2)     // Catch:{ all -> 0x02fc }
            hb.h0.A(r9, r1)
            r1 = r16
            java.lang.Exception r1 = r1.f8735h
            if (r1 != 0) goto L_0x02fb
            if (r0 == 0) goto L_0x02ef
            android.content.res.Resources r1 = r5.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r1 = r1.densityDpi
            r0.setDensity(r1)
            boolean r1 = r4.f8765a
            if (r1 != 0) goto L_0x0238
            if (r15 <= 0) goto L_0x0233
            r3 = 1
            goto L_0x0234
        L_0x0233:
            r3 = 0
        L_0x0234:
            if (r3 != 0) goto L_0x0238
            goto L_0x02d3
        L_0x0238:
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            int r4 = r0.getWidth()
            float r4 = (float) r4
            r6 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r6
            int r7 = r0.getHeight()
            float r7 = (float) r7
            float r7 = r7 / r6
            if (r1 == 0) goto L_0x0254
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            r3.postScale(r1, r6, r4, r7)
        L_0x0254:
            if (r15 <= 0) goto L_0x0258
            r1 = 1
            goto L_0x0259
        L_0x0258:
            r1 = 0
        L_0x0259:
            if (r1 == 0) goto L_0x025f
            float r1 = (float) r15
            r3.postRotate(r1, r4, r7)
        L_0x025f:
            android.graphics.RectF r1 = new android.graphics.RectF
            int r4 = r0.getWidth()
            float r4 = (float) r4
            int r6 = r0.getHeight()
            float r6 = (float) r6
            r7 = 0
            r1.<init>(r7, r7, r4, r6)
            r3.mapRect(r1)
            float r4 = r1.left
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x027a
            r6 = 1
            goto L_0x027b
        L_0x027a:
            r6 = 0
        L_0x027b:
            if (r6 == 0) goto L_0x0288
            float r6 = r1.top
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x0285
            r6 = 1
            goto L_0x0286
        L_0x0285:
            r6 = 0
        L_0x0286:
            if (r6 != 0) goto L_0x028f
        L_0x0288:
            float r4 = -r4
            float r1 = r1.top
            float r1 = -r1
            r3.postTranslate(r4, r1)
        L_0x028f:
            r1 = 90
            if (r15 == r1) goto L_0x029a
            r1 = 270(0x10e, float:3.78E-43)
            if (r15 != r1) goto L_0x0298
            goto L_0x029a
        L_0x0298:
            r1 = 0
            goto L_0x029b
        L_0x029a:
            r1 = 1
        L_0x029b:
            if (r1 == 0) goto L_0x02ac
            int r1 = r0.getHeight()
            int r4 = r0.getWidth()
            android.graphics.Bitmap$Config r6 = r0.getConfig()
            if (r6 != 0) goto L_0x02bc
            goto L_0x02ba
        L_0x02ac:
            int r1 = r0.getWidth()
            int r4 = r0.getHeight()
            android.graphics.Bitmap$Config r6 = r0.getConfig()
            if (r6 != 0) goto L_0x02bc
        L_0x02ba:
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
        L_0x02bc:
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r4, r6)
            java.lang.String r4 = "createBitmap(width, height, config)"
            xa.j.e(r4, r1)
            android.graphics.Canvas r4 = new android.graphics.Canvas
            r4.<init>(r1)
            android.graphics.Paint r6 = j4.o.f8771b
            r4.drawBitmap(r0, r3, r6)
            r0.recycle()
            r0 = r1
        L_0x02d3:
            j4.h r1 = new j4.h
            android.content.res.Resources r3 = r5.getResources()
            android.graphics.drawable.BitmapDrawable r4 = new android.graphics.drawable.BitmapDrawable
            r4.<init>(r3, r0)
            int r0 = r2.inSampleSize
            r3 = 1
            if (r0 > r3) goto L_0x02ea
            boolean r0 = r2.inScaled
            if (r0 == 0) goto L_0x02e8
            goto L_0x02ea
        L_0x02e8:
            r5 = 0
            goto L_0x02eb
        L_0x02ea:
            r5 = 1
        L_0x02eb:
            r1.<init>(r4, r5)
            return r1
        L_0x02ef:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x02fb:
            throw r1
        L_0x02fc:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x02ff }
        L_0x02ff:
            r0 = move-exception
            r2 = r0
            hb.h0.A(r9, r1)
            throw r2
        L_0x0305:
            throw r10
        L_0x0306:
            throw r10
        L_0x0307:
            j4.w r3 = (j4.w) r3
            boolean r1 = r3.f8794c
            j4.e0 r2 = r3.f8792a
            if (r1 == 0) goto L_0x031d
            j4.s r1 = new j4.s
            dc.l r2 = r2.v()
            r1.<init>(r2)
            dc.i0 r1 = hb.h0.o(r1)
            goto L_0x0321
        L_0x031d:
            dc.l r1 = r2.v()
        L_0x0321:
            dc.h r2 = r1.G0()     // Catch:{ all -> 0x03c5 }
            android.graphics.Movie r2 = android.graphics.Movie.decodeStream(r2)     // Catch:{ all -> 0x03c5 }
            r4 = 0
            hb.h0.A(r1, r4)
            if (r2 == 0) goto L_0x033e
            int r1 = r2.width()
            if (r1 <= 0) goto L_0x033e
            int r1 = r2.height()
            if (r1 <= 0) goto L_0x033e
            r17 = 1
            goto L_0x0340
        L_0x033e:
            r17 = 0
        L_0x0340:
            if (r17 == 0) goto L_0x03b9
            l4.b r1 = new l4.b
            boolean r4 = r2.isOpaque()
            s4.m r3 = r3.f8793b
            if (r4 == 0) goto L_0x0353
            boolean r4 = r3.f14282g
            if (r4 == 0) goto L_0x0353
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.RGB_565
            goto L_0x036b
        L_0x0353:
            android.graphics.Bitmap$Config r4 = r3.f14277b
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r0) goto L_0x0362
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.HARDWARE
            if (r4 != r0) goto L_0x0362
            r17 = 1
            goto L_0x0364
        L_0x0362:
            r17 = 0
        L_0x0364:
            if (r17 == 0) goto L_0x0369
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x036b
        L_0x0369:
            android.graphics.Bitmap$Config r0 = r3.f14277b
        L_0x036b:
            int r4 = r3.f14280e
            r1.<init>(r2, r0, r4)
            s4.p r0 = r3.f14287l
            java.util.Map r0 = r0.f14293h
            java.lang.String r2 = "coil#repeat_count"
            java.lang.Object r0 = r0.get(r2)
            android.support.v4.media.h.y(r0)
            r0 = -1
            r1.f9579x = r0
            s4.p r0 = r3.f14287l
            java.util.Map r0 = r0.f14293h
            java.lang.String r2 = "coil#animation_start_callback"
            java.lang.Object r0 = r0.get(r2)
            android.support.v4.media.h.y(r0)
            s4.p r0 = r3.f14287l
            java.util.Map r0 = r0.f14293h
            java.lang.String r2 = "coil#animation_end_callback"
            java.lang.Object r0 = r0.get(r2)
            android.support.v4.media.h.y(r0)
            s4.p r0 = r3.f14287l
            java.util.Map r0 = r0.f14293h
            java.lang.String r2 = "coil#animated_transformation"
            java.lang.Object r0 = r0.get(r2)
            android.support.v4.media.h.y(r0)
            r0 = 0
            r1.f9580y = r0
            r0 = 1
            r1.f9581z = r0
            r0 = 0
            r1.A = r0
            r1.invalidateSelf()
            j4.h r2 = new j4.h
            r2.<init>(r1, r0)
            return r2
        L_0x03b9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed to decode GIF."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03c5:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x03c8 }
        L_0x03c8:
            r0 = move-exception
            r3 = r0
            hb.h0.A(r1, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.p1.a():j4.h");
    }

    public final Object b() {
        t o10;
        i iVar;
        int i10 = this.f1738h;
        Bundle bundle = null;
        Object obj = this.f1739i;
        switch (i10) {
            case 0:
                return o1.c((h2) obj);
            case 1:
                k0 k0Var = (k0) obj;
                boolean z10 = k0.D;
                k0Var.getClass();
                return new l1(k0Var.f8576a, k0Var.f8596u);
            case 2:
                NavHostFragment navHostFragment = (NavHostFragment) obj;
                Context v10 = navHostFragment.v();
                if (v10 != null) {
                    j1 j1Var = new j1(v10);
                    if (!j.a(navHostFragment, j1Var.f8589n)) {
                        d0 d0Var = j1Var.f8589n;
                        v vVar = j1Var.f8593r;
                        if (!(d0Var == null || (o10 = d0Var.o()) == null)) {
                            o10.c(vVar);
                        }
                        j1Var.f8589n = navHostFragment;
                        navHostFragment.V.a(vVar);
                    }
                    g2 m10 = navHostFragment.m();
                    n0 n0Var = j1Var.f8590o;
                    n0.f8629e.getClass();
                    l0 l0Var = n0.f8630f;
                    int i11 = 0;
                    Class<n0> cls = n0.class;
                    if (!j.a(n0Var, (n0) new u(m10, (b2) l0Var, 0).q(cls))) {
                        if (j1Var.f8582g.isEmpty()) {
                            j1Var.f8590o = (n0) new u(m10, (b2) l0Var, 0).q(cls);
                        } else {
                            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
                        }
                    }
                    Context f02 = navHostFragment.f0();
                    c1 u10 = navHostFragment.u();
                    j.e("childFragmentManager", u10);
                    e eVar = new e(f02, u10);
                    q2 q2Var = j1Var.f8596u;
                    q2Var.a(eVar);
                    Context f03 = navHostFragment.f0();
                    c1 u11 = navHostFragment.u();
                    j.e("childFragmentManager", u11);
                    int i12 = navHostFragment.D;
                    if (i12 == 0 || i12 == -1) {
                        i12 = R.id.nav_host_fragment_container;
                    }
                    q2Var.a(new m(f03, u11, i12));
                    Bundle a10 = navHostFragment.Z.f14540b.a("android-support-nav:fragment:navControllerState");
                    if (a10 != null) {
                        a10.setClassLoader(v10.getClassLoader());
                        j1Var.f8579d = a10.getBundle("android-support-nav:controller:navigatorState");
                        j1Var.f8580e = a10.getParcelableArray("android-support-nav:controller:backStack");
                        LinkedHashMap linkedHashMap = j1Var.f8588m;
                        linkedHashMap.clear();
                        int[] intArray = a10.getIntArray("android-support-nav:controller:backStackDestIds");
                        ArrayList<String> stringArrayList = a10.getStringArrayList("android-support-nav:controller:backStackIds");
                        if (!(intArray == null || stringArrayList == null)) {
                            int length = intArray.length;
                            int i13 = 0;
                            int i14 = 0;
                            while (i13 < length) {
                                j1Var.f8587l.put(Integer.valueOf(intArray[i13]), stringArrayList.get(i14));
                                i13++;
                                i14++;
                            }
                        }
                        ArrayList<String> stringArrayList2 = a10.getStringArrayList("android-support-nav:controller:backStackStates");
                        if (stringArrayList2 != null) {
                            for (String str : stringArrayList2) {
                                Parcelable[] parcelableArray = a10.getParcelableArray("android-support-nav:controller:backStackStates:" + str);
                                if (parcelableArray != null) {
                                    j.e("id", str);
                                    l lVar = new l(parcelableArray.length);
                                    q.m mVar = new q.m((Object[]) parcelableArray);
                                    while (mVar.hasNext()) {
                                        Parcelable parcelable = (Parcelable) mVar.next();
                                        j.d("null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState", parcelable);
                                        lVar.d((j3.u) parcelable);
                                    }
                                    linkedHashMap.put(str, lVar);
                                }
                            }
                        }
                        j1Var.f8581f = a10.getBoolean("android-support-nav:controller:deepLinkHandled");
                    }
                    navHostFragment.Z.f14540b.c("android-support-nav:fragment:navControllerState", new f(3, j1Var));
                    Bundle a11 = navHostFragment.Z.f14540b.a("android-support-nav:fragment:graphId");
                    if (a11 != null) {
                        navHostFragment.f1873f0 = a11.getInt("android-support-nav:fragment:graphId");
                    }
                    navHostFragment.Z.f14540b.c("android-support-nav:fragment:graphId", new f(4, navHostFragment));
                    int i15 = navHostFragment.f1873f0;
                    o oVar = j1Var.B;
                    if (i15 != 0) {
                        j1Var.s(((l1) oVar.getValue()).b(i15), (Bundle) null);
                    } else {
                        Bundle bundle2 = navHostFragment.f1357m;
                        if (bundle2 != null) {
                            i11 = bundle2.getInt("android-support-nav:fragment:graphId");
                        }
                        if (bundle2 != null) {
                            bundle = bundle2.getBundle("android-support-nav:fragment:startDestinationArgs");
                        }
                        if (i11 != 0) {
                            j1Var.s(((l1) oVar.getValue()).b(i11), bundle);
                        }
                    }
                    return j1Var;
                }
                throw new IllegalStateException("NavController cannot be created before the fragment is attached".toString());
            case 3:
                f();
                return la.v.f9814a;
            case 4:
                f();
                return la.v.f9814a;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                return ((d) obj).d();
            case 6:
                if (Build.VERSION.SDK_INT >= 23) {
                    v3.j jVar = (v3.j) obj;
                    if (jVar.f15917i != null && jVar.f15919k) {
                        int i16 = u3.e.f15350a;
                        Context context = jVar.f15916h;
                        j.f("context", context);
                        File noBackupFilesDir = context.getNoBackupFilesDir();
                        j.e("context.noBackupFilesDir", noBackupFilesDir);
                        iVar = new i(jVar.f15916h, new File(noBackupFilesDir, jVar.f15917i).getAbsolutePath(), new com.google.gson.internal.bind.l((Object) null), jVar.f15918j, jVar.f15920l);
                        boolean z11 = ((v3.j) obj).f15922n;
                        int i17 = c.f15348a;
                        iVar.setWriteAheadLoggingEnabled(z11);
                        return iVar;
                    }
                }
                v3.j jVar2 = (v3.j) obj;
                iVar = new i(jVar2.f15916h, jVar2.f15917i, new com.google.gson.internal.bind.l((Object) null), jVar2.f15918j, jVar2.f15920l);
                boolean z112 = ((v3.j) obj).f15922n;
                int i172 = c.f15348a;
                iVar.setWriteAheadLoggingEnabled(z112);
                return iVar;
            case 7:
                return a();
            case 8:
                return a();
            case 9:
                f();
                return la.v.f9814a;
            case 10:
                return d();
            case 11:
                f();
                return la.v.f9814a;
            case 12:
                f();
                return la.v.f9814a;
            case 13:
                return d();
            case 14:
                f();
                return la.v.f9814a;
            case 15:
                f();
                return la.v.f9814a;
            case Constants.IV_SIZE /*16*/:
                f();
                return la.v.f9814a;
            case 17:
                f();
                return la.v.f9814a;
            case 18:
                return d();
            case 19:
                return d();
            case 20:
                return ((q) obj).g0();
            case 21:
                s9.e eVar2 = (s9.e) obj;
                b bVar = eVar2.A;
                u9.b bVar2 = eVar2.f14417j;
                if (bVar2 != null) {
                    q9.e P = bVar2.f15442b.f15440a.P();
                    h0.T1(bVar, P);
                    return P;
                }
                la.d dVar = new la.d();
                j.j(j.class.getName(), dVar);
                throw dVar;
            case 22:
                f();
                return la.v.f9814a;
            case 23:
                HandlerThread handlerThread = new HandlerThread(((p) obj).f17280e);
                handlerThread.start();
                return new Handler(handlerThread.getLooper());
            case 24:
                return obj;
            case 25:
                return c();
            case 26:
                return ((g) obj).f14963d.g();
            case 27:
                return c();
            default:
                f();
                return la.v.f9814a;
        }
    }

    public final List c() {
        int i10 = this.f1738h;
        Object obj = this.f1739i;
        switch (i10) {
            case 25:
                return (List) obj;
            default:
                List<Certificate> a10 = ((m0) obj).a();
                ArrayList arrayList = new ArrayList(s.i(a10));
                for (Certificate certificate : a10) {
                    j.d("null cannot be cast to non-null type java.security.cert.X509Certificate", certificate);
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
        }
    }

    public final n4 d() {
        int i10 = this.f1738h;
        Object obj = this.f1739i;
        switch (i10) {
            case 10:
                return new f6.k(((FollowedGamesViewModel) obj).f3409d);
            case 13:
                return new f6.k(((GamesViewModel) obj).f3430d);
            case 18:
                StreamsViewModel streamsViewModel = (StreamsViewModel) obj;
                q6.f fVar = streamsViewModel.f3507e;
                int i11 = fVar.f13353a;
                e1 e1Var = streamsViewModel.f3508f;
                x xVar = streamsViewModel.f3506d;
                String str = fVar.f13354b;
                if (i11 == 0 && str == null) {
                    return new f6.b(xVar, ((j7.i) e1Var.getValue()).f8841a);
                }
                if (str == null) {
                    str = "";
                }
                return new f6.s(str, xVar, ((j7.i) e1Var.getValue()).f8841a);
            default:
                FollowedStreamsViewModel followedStreamsViewModel = (FollowedStreamsViewModel) obj;
                return new f6.p(followedStreamsViewModel.f3511e, followedStreamsViewModel.f3510d);
        }
    }

    public final void f() {
        boolean z10 = false;
        switch (this.f1738h) {
            case 3:
                ((u1) ((hb.u) this.f1739i)).e((CancellationException) null);
                return;
            case 4:
                ((n3.g) this.f1739i).f11175l.h(la.v.f9814a);
                return;
            case 9:
                ChannelPagerFragment channelPagerFragment = (ChannelPagerFragment) this.f1739i;
                int i10 = ChannelPagerFragment.f3334r0;
                ChannelPagerViewModel s02 = channelPagerFragment.s0();
                Context f02 = channelPagerFragment.f0();
                h0.b1(d1.f7786h, (h) null, 0, new h6.u(channelPagerFragment.r0().f7680a, s02, f02, (pa.e) null), 3);
                return;
            case 11:
                GameMediaFragment gameMediaFragment = (GameMediaFragment) this.f1739i;
                int i11 = GameMediaFragment.f3411t0;
                GamePagerViewModel r02 = gameMediaFragment.r0();
                Context f03 = gameMediaFragment.f0();
                h0.b1(d1.f7786h, (h) null, 0, new q6.j(gameMediaFragment.q0().f13353a, r02, f03, (pa.e) null), 3);
                return;
            case 12:
                GamePagerFragment gamePagerFragment = (GamePagerFragment) this.f1739i;
                int i12 = GamePagerFragment.f3417s0;
                GamePagerViewModel s03 = gamePagerFragment.s0();
                Context f04 = gamePagerFragment.f0();
                h0.b1(d1.f7786h, (h) null, 0, new q6.j(gamePagerFragment.q0().f13353a, s03, f04, (pa.e) null), 3);
                return;
            case 14:
                t6.l lVar = (t6.l) this.f1739i;
                if (!lVar.f14628o0 && lVar.u0().f3546v) {
                    ViewGroup viewGroup = lVar.f14627n0;
                    if (viewGroup != null) {
                        if (viewGroup.getVisibility() == 0) {
                            z10 = true;
                        }
                        if (z10) {
                            lVar.w0();
                            return;
                        } else {
                            lVar.F0();
                            return;
                        }
                    } else {
                        j.l("chatLayout");
                        throw null;
                    }
                } else {
                    return;
                }
            case 15:
                u6.d dVar = (u6.d) this.f1739i;
                ClipPlayerViewModel O0 = dVar.v0();
                Context f05 = dVar.f0();
                Clip clip = dVar.G0;
                if (clip != null) {
                    O0.d(f05, clip.getChannelId());
                    return;
                } else {
                    j.l("clip");
                    throw null;
                }
            case Constants.IV_SIZE /*16*/:
                w6.f fVar = (w6.f) this.f1739i;
                StreamPlayerViewModel Q0 = fVar.v0();
                Context f06 = fVar.f0();
                Stream stream = fVar.G0;
                if (stream != null) {
                    Q0.d(f06, stream.getChannelId());
                    return;
                } else {
                    j.l("stream");
                    throw null;
                }
            case 17:
                x6.h hVar = (x6.h) this.f1739i;
                VideoPlayerViewModel O02 = hVar.v0();
                Context f07 = hVar.f0();
                Video video = hVar.F0;
                if (video != null) {
                    O02.d(f07, video.getChannelId());
                    return;
                } else {
                    j.l("video");
                    throw null;
                }
            case 22:
                if (!((u9.e) this.f1739i).f15446a.f15450k && !((u9.e) this.f1739i).f15446a.f15449j && ((u9.e) this.f1739i).f15446a.f15458s.b() && ((u9.e) this.f1739i).f15446a.f15451l > 500) {
                    ((u9.e) this.f1739i).f15446a.k();
                    return;
                }
                return;
            default:
                wb.v vVar = (wb.v) this.f1739i;
                vVar.getClass();
                try {
                    vVar.F.z(2, 0, false);
                    return;
                } catch (IOException e10) {
                    vVar.e(e10);
                    return;
                }
        }
    }
}
