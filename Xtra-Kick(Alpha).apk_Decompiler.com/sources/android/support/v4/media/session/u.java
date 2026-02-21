package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ClipDescription;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.h;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.r0;
import androidx.lifecycle.b2;
import androidx.lifecycle.e2;
import androidx.lifecycle.f2;
import androidx.lifecycle.g2;
import androidx.lifecycle.h2;
import androidx.lifecycle.w1;
import androidx.viewpager2.widget.ViewPager2;
import b5.n;
import coil.target.GenericViewTarget;
import com.bumptech.glide.load.data.p;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.woxthebox.draglistview.R;
import d2.q;
import d2.v;
import d2.w;
import d2.w0;
import d2.x0;
import d2.y;
import d2.z0;
import d5.o0;
import e1.c0;
import e4.a;
import e5.k;
import f3.d0;
import f3.j0;
import g.y0;
import g1.a0;
import g1.z;
import hb.h0;
import j1.b0;
import j1.l0;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.e0;
import l0.d;
import o1.n0;
import o5.e;
import p0.g;
import p5.c;
import q0.m;
import s4.i;
import u.f;
import v.b;
import v.o;
import w5.l;
import xa.j;
import y5.x;

public final class u implements m, g, d0, c, d, x {

    /* renamed from: l  reason: collision with root package name */
    public static int f425l;

    /* renamed from: m  reason: collision with root package name */
    public static u f426m;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f427h;

    /* renamed from: i  reason: collision with root package name */
    public Object f428i;

    /* renamed from: j  reason: collision with root package name */
    public Object f429j;

    /* renamed from: k  reason: collision with root package name */
    public Object f430k;

    public u(PendingIntent pendingIntent, ComponentName componentName, Context context, Bundle bundle, String str) {
        this.f427h = 1;
        this.f430k = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            if (pendingIntent == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
            }
            int i10 = Build.VERSION.SDK_INT;
            this.f428i = i10 >= 29 ? new f0(context, str, bundle) : i10 >= 28 ? new e0(context, str, bundle) : i10 >= 22 ? new c0(context, str, bundle) : new a0(context, str, bundle);
            K(new v(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
            ((z) this.f428i).s(pendingIntent);
            this.f429j = new u(context, this);
            if (f425l == 0) {
                f425l = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("tag must not be null or empty");
    }

    public static PlaybackStateCompat A(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        long j10;
        PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
        MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
        if (playbackStateCompat2 == null) {
            return playbackStateCompat2;
        }
        long j11 = -1;
        long j12 = playbackStateCompat2.f360i;
        if (j12 == -1) {
            return playbackStateCompat2;
        }
        int i10 = playbackStateCompat2.f359h;
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            return playbackStateCompat2;
        }
        long j13 = playbackStateCompat2.f366o;
        if (j13 <= 0) {
            return playbackStateCompat2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j14 = ((long) (playbackStateCompat2.f362k * ((float) (elapsedRealtime - j13)))) + j12;
        if (mediaMetadataCompat2 != null && mediaMetadataCompat2.u("android.media.metadata.DURATION")) {
            j11 = mediaMetadataCompat2.w("android.media.metadata.DURATION");
        }
        if (j11 >= 0 && j14 > j11) {
            j10 = j11;
        } else if (j14 < 0) {
            j10 = 0;
        } else {
            j10 = j14;
        }
        ArrayList arrayList = new ArrayList();
        long j15 = playbackStateCompat2.f361j;
        long j16 = playbackStateCompat2.f363l;
        int i11 = playbackStateCompat2.f364m;
        CharSequence charSequence = playbackStateCompat2.f365n;
        ArrayList arrayList2 = playbackStateCompat2.f367p;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        return new PlaybackStateCompat(playbackStateCompat2.f359h, j10, j15, playbackStateCompat2.f362k, j16, i11, charSequence, elapsedRealtime, arrayList, playbackStateCompat2.f368q, playbackStateCompat2.f369r);
    }

    public static u C(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_saved, viewGroup, false);
        int i10 = R.id.nothingHere;
        TextView textView = (TextView) a.a(inflate, R.id.nothingHere);
        if (textView != null) {
            i10 = R.id.recyclerView;
            GridRecyclerView gridRecyclerView = (GridRecyclerView) a.a(inflate, R.id.recyclerView);
            if (gridRecyclerView != null) {
                return new u((Object) (ConstraintLayout) inflate, (Object) textView, (Object) gridRecyclerView, 28, 0);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public static boolean E(i iVar, Bitmap.Config config) {
        if (!h0.V0(config)) {
            return true;
        }
        if (!iVar.f14264p) {
            return false;
        }
        u4.a aVar = iVar.f14251c;
        if (!(aVar instanceof GenericViewTarget)) {
            return true;
        }
        ((GenericViewTarget) aVar).k();
        throw null;
    }

    public static Bundle O(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        p(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public static void Q(Bundle bundle, String str) {
        if (str != null) {
            if (!str.equals("android.support.v4.media.session.action.FOLLOW") && !str.equals("android.support.v4.media.session.action.UNFOLLOW")) {
                return;
            }
            if (bundle == null || !bundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")) {
                throw new IllegalArgumentException(h.n("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ", str, "."));
            }
        }
    }

    public static u l(View view) {
        int i10 = R.id.tabLayout;
        TabLayout tabLayout = (TabLayout) a.a(view, R.id.tabLayout);
        if (tabLayout != null) {
            i10 = R.id.viewPager;
            ViewPager2 viewPager2 = (ViewPager2) a.a(view, R.id.viewPager);
            if (viewPager2 != null) {
                return new u((Object) (LinearLayout) view, (Object) tabLayout, (Object) viewPager2, 27, 0);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static u m(View view) {
        int i10 = R.id.noStorageDetected;
        TextView textView = (TextView) a.a(view, R.id.noStorageDetected);
        if (textView != null) {
            i10 = R.id.radioGroup;
            RadioGroup radioGroup = (RadioGroup) a.a(view, R.id.radioGroup);
            if (radioGroup != null) {
                return new u((Object) (LinearLayout) view, (Object) textView, (Object) radioGroup, 29, 0);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static void p(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(u.class.getClassLoader());
        }
    }

    public final q B() {
        MediaController.TransportControls transportControls = ((m) ((k) this.f428i)).f403a.getTransportControls();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            return new t(transportControls);
        }
        if (i10 >= 24) {
            return new s(transportControls);
        }
        if (i10 >= 23) {
            return new r(transportControls);
        }
        return new q(transportControls);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r0.f4274d != r11) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
        if (r0.f4274d != r11) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0066, code lost:
        r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(k1.h r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, d2.y r15) {
        /*
            r7 = this;
            d2.p r6 = new d2.p
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f430k = r6
            java.lang.Object r8 = r7.f429j
            d2.v r8 = (d2.v) r8
            if (r8 == 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.Object r8 = r7.f428i
            d2.a0 r8 = (d2.a0) r8
            d2.v[] r8 = r8.f(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L_0x0025
            r8 = r8[r13]
            r7.f429j = r8
            goto L_0x00bb
        L_0x0025:
            int r10 = r8.length
            r0 = 0
        L_0x0027:
            if (r0 >= r10) goto L_0x0071
            r1 = r8[r0]
            boolean r2 = r1.h(r6)     // Catch:{ EOFException -> 0x0058, all -> 0x0043 }
            if (r2 == 0) goto L_0x0036
            r7.f429j = r1     // Catch:{ EOFException -> 0x0058, all -> 0x0043 }
            r6.f4276f = r13
            goto L_0x0071
        L_0x0036:
            java.lang.Object r1 = r7.f429j
            d2.v r1 = (d2.v) r1
            if (r1 != 0) goto L_0x0068
            long r1 = r6.f4274d
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0066
            goto L_0x0068
        L_0x0043:
            r8 = move-exception
            java.lang.Object r9 = r7.f429j
            d2.v r9 = (d2.v) r9
            if (r9 != 0) goto L_0x0052
            long r9 = r6.f4274d
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r14 = 0
        L_0x0052:
            j1.a.e(r14)
            r6.f4276f = r13
            throw r8
        L_0x0058:
            java.lang.Object r1 = r7.f429j
            d2.v r1 = (d2.v) r1
            if (r1 != 0) goto L_0x0068
            long r1 = r6.f4274d
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r1 = 0
            goto L_0x0069
        L_0x0068:
            r1 = 1
        L_0x0069:
            j1.a.e(r1)
            r6.f4276f = r13
            int r0 = r0 + 1
            goto L_0x0027
        L_0x0071:
            java.lang.Object r10 = r7.f429j
            d2.v r10 = (d2.v) r10
            if (r10 != 0) goto L_0x00bb
            h2.d r10 = new h2.d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "None of the available extractors ("
            r11.<init>(r12)
            int r12 = j1.l0.f8453a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
        L_0x0087:
            int r14 = r8.length
            if (r13 >= r14) goto L_0x00a4
            r14 = r8[r13]
            java.lang.Class r14 = r14.getClass()
            java.lang.String r14 = r14.getSimpleName()
            r12.append(r14)
            int r14 = r8.length
            int r14 = r14 + -1
            if (r13 >= r14) goto L_0x00a1
            java.lang.String r14 = ", "
            r12.append(r14)
        L_0x00a1:
            int r13 = r13 + 1
            goto L_0x0087
        L_0x00a4:
            java.lang.String r8 = r12.toString()
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r9.getClass()
            r10.<init>(r8)
            throw r10
        L_0x00bb:
            java.lang.Object r8 = r7.f429j
            d2.v r8 = (d2.v) r8
            r8.e(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.u.D(k1.h, android.net.Uri, java.util.Map, long, long, d2.y):void");
    }

    public final boolean F(int i10, f fVar, o oVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        b bVar = (b) this.f429j;
        int[] iArr = fVar.f15113q0;
        bVar.f15487a = iArr[0];
        boolean z14 = true;
        bVar.f15488b = iArr[1];
        bVar.f15489c = fVar.q();
        ((b) this.f429j).f15490d = fVar.l();
        b bVar2 = (b) this.f429j;
        bVar2.f15495i = false;
        bVar2.f15496j = i10;
        if (bVar2.f15487a == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (bVar2.f15488b == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z10 || fVar.X <= 0.0f) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z11 || fVar.X <= 0.0f) {
            z13 = false;
        } else {
            z13 = true;
        }
        int[] iArr2 = fVar.f15117u;
        if (z12 && iArr2[0] == 4) {
            bVar2.f15487a = 1;
        }
        if (z13 && iArr2[1] == 4) {
            bVar2.f15488b = 1;
        }
        oVar.b(fVar, bVar2);
        fVar.N(((b) this.f429j).f15491e);
        fVar.K(((b) this.f429j).f15492f);
        Object obj = this.f429j;
        b bVar3 = (b) obj;
        fVar.F = bVar3.f15494h;
        int i11 = bVar3.f15493g;
        fVar.f15083b0 = i11;
        if (i11 <= 0) {
            z14 = false;
        }
        fVar.F = z14;
        b bVar4 = (b) obj;
        bVar4.f15496j = 0;
        return bVar4.f15495i;
    }

    public final boolean G() {
        Iterator it = ((CopyOnWriteArrayList) this.f429j).iterator();
        while (it.hasNext()) {
            if (((r0) it.next()).f1555a.o()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final s4.m H(s4.i r20, t4.g r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r5 = r21
            java.util.List r2 = r1.f14259k
            boolean r2 = r2.isEmpty()
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x001d
            android.graphics.Bitmap$Config[] r2 = w4.e.f16080a
            android.graphics.Bitmap$Config r6 = r1.f14255g
            boolean r2 = ma.p.g(r2, r6)
            if (r2 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r2 = 0
            goto L_0x001e
        L_0x001d:
            r2 = 1
        L_0x001e:
            if (r2 == 0) goto L_0x0042
            android.graphics.Bitmap$Config r2 = r1.f14255g
            boolean r2 = hb.h0.V0(r2)
            if (r2 != 0) goto L_0x0029
            goto L_0x003b
        L_0x0029:
            android.graphics.Bitmap$Config r2 = r1.f14255g
            boolean r2 = E(r1, r2)
            if (r2 == 0) goto L_0x003d
            java.lang.Object r2 = r0.f430k
            w4.i r2 = (w4.i) r2
            boolean r2 = r2.b(r5)
            if (r2 == 0) goto L_0x003d
        L_0x003b:
            r2 = 1
            goto L_0x003e
        L_0x003d:
            r2 = 0
        L_0x003e:
            if (r2 == 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            android.graphics.Bitmap$Config r2 = r1.f14255g
            goto L_0x004a
        L_0x0048:
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
        L_0x004a:
            r6 = r2
            java.lang.Object r2 = r0.f429j
            w4.o r2 = (w4.o) r2
            boolean r2 = r2.f16101k
            if (r2 == 0) goto L_0x0058
            int r2 = r1.L
            r16 = r2
            goto L_0x005b
        L_0x0058:
            r2 = 4
            r16 = 4
        L_0x005b:
            t4.c r2 = r5.f14548a
            t4.b r7 = t4.b.f14543a
            boolean r2 = xa.j.a(r2, r7)
            if (r2 != 0) goto L_0x0072
            t4.c r2 = r5.f14549b
            boolean r2 = xa.j.a(r2, r7)
            if (r2 == 0) goto L_0x006e
            goto L_0x0072
        L_0x006e:
            int r2 = r1.M
            r7 = r2
            goto L_0x0074
        L_0x0072:
            r2 = 2
            r7 = 2
        L_0x0074:
            boolean r2 = r1.f14265q
            if (r2 == 0) goto L_0x0086
            java.util.List r2 = r1.f14259k
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0086
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ALPHA_8
            if (r6 == r2) goto L_0x0086
            r8 = 1
            goto L_0x0087
        L_0x0086:
            r8 = 0
        L_0x0087:
            s4.m r17 = new s4.m
            android.content.Context r2 = r1.f14249a
            android.graphics.ColorSpace r4 = r1.f14256h
            boolean r9 = w4.c.a(r20)
            boolean r10 = r1.f14266r
            java.lang.String r11 = r1.f14254f
            pb.p0 r12 = r1.f14261m
            s4.t r13 = r1.f14262n
            s4.p r14 = r1.f14273y
            int r15 = r1.J
            int r3 = r1.K
            r1 = r17
            r18 = r3
            r3 = r6
            r5 = r21
            r6 = r7
            r7 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.u.H(s4.i, t4.g):s4.m");
    }

    public final void I() {
        switch (this.f427h) {
            case 1:
                ((z) this.f428i).a();
                return;
            default:
                v vVar = (v) this.f429j;
                if (vVar != null) {
                    vVar.a();
                    this.f429j = null;
                }
                this.f430k = null;
                return;
        }
    }

    public final void J(MediaDescriptionCompat mediaDescriptionCompat) {
        m mVar = (m) ((k) this.f428i);
        if ((mVar.f403a.getFlags() & 4) != 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
            mVar.f403a.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, (ResultReceiver) null);
            return;
        }
        throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }

    public final void K(y yVar, Handler handler) {
        if (yVar == null) {
            ((z) this.f428i).k((y) null, (Handler) null);
        } else {
            ((z) this.f428i).k(yVar, handler);
        }
    }

    public final void L(PlaybackStateCompat playbackStateCompat) {
        ((z) this.f428i).j(playbackStateCompat);
    }

    public final void M(ArrayList arrayList) {
        if (arrayList != null) {
            HashSet hashSet = new HashSet();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem = (MediaSessionCompat$QueueItem) it.next();
                if (mediaSessionCompat$QueueItem != null) {
                    long j10 = mediaSessionCompat$QueueItem.f347i;
                    if (hashSet.contains(Long.valueOf(j10))) {
                        Log.e("MediaSessionCompat", h.k("Found duplicate queue id: ", j10), new IllegalArgumentException("id of each queue item should be unique"));
                    }
                    hashSet.add(Long.valueOf(j10));
                } else {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
            }
        }
        ((z) this.f428i).l(arrayList);
    }

    public final void N(u.g gVar, int i10, int i11, int i12) {
        int i13 = gVar.f15085c0;
        int i14 = gVar.f15087d0;
        gVar.f15085c0 = 0;
        gVar.f15087d0 = 0;
        gVar.N(i11);
        gVar.K(i12);
        if (i13 < 0) {
            i13 = 0;
        }
        gVar.f15085c0 = i13;
        if (i14 < 0) {
            i14 = 0;
        }
        gVar.f15087d0 = i14;
        u.g gVar2 = (u.g) this.f430k;
        gVar2.f15125u0 = i10;
        gVar2.Q();
    }

    public final void P(u.g gVar) {
        ((ArrayList) this.f428i).clear();
        int size = gVar.f15168r0.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = (f) gVar.f15168r0.get(i10);
            int[] iArr = fVar.f15113q0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                ((ArrayList) this.f428i).add(fVar);
            }
        }
        gVar.f15124t0.f15499a = true;
    }

    public final ga.a a(Activity activity) {
        activity.getClass();
        this.f430k = activity;
        return this;
    }

    public final void b(j1.h0 h0Var, y yVar, j0 j0Var) {
        this.f429j = h0Var;
        j0Var.a();
        j0Var.b();
        x0 d10 = yVar.d(j0Var.f5630d, 5);
        this.f430k = d10;
        d10.a((a0) this.f428i);
    }

    public final void c(b0 b0Var) {
        long j10;
        long j11;
        j1.a.f((j1.h0) this.f429j);
        int i10 = l0.f8453a;
        j1.h0 h0Var = (j1.h0) this.f429j;
        synchronized (h0Var) {
            long j12 = h0Var.f8437c;
            if (j12 != -9223372036854775807L) {
                j10 = j12 + h0Var.f8436b;
            } else {
                j10 = h0Var.c();
            }
            j11 = j10;
        }
        long d10 = ((j1.h0) this.f429j).d();
        if (j11 != -9223372036854775807L && d10 != -9223372036854775807L) {
            a0 a0Var = (a0) this.f428i;
            if (d10 != a0Var.f6280w) {
                a0Var.getClass();
                z zVar = new z(a0Var);
                zVar.f6758o = d10;
                a0 a0Var2 = new a0(zVar);
                this.f428i = a0Var2;
                ((x0) this.f430k).a(a0Var2);
            }
            int i11 = b0Var.f8416c - b0Var.f8415b;
            ((x0) this.f430k).d(i11, b0Var);
            ((x0) this.f430k).e(j11, 1, i11, 0, (w0) null);
        }
    }

    public final o0 d(o0 o0Var, n nVar) {
        Drawable drawable = (Drawable) o0Var.get();
        if (drawable instanceof BitmapDrawable) {
            return ((c) this.f429j).d(k5.d.c(((BitmapDrawable) drawable).getBitmap(), (e5.c) this.f428i), nVar);
        }
        if (drawable instanceof e) {
            return ((c) this.f430k).d(o0Var, nVar);
        }
        return null;
    }

    public final boolean e(Object obj) {
        if (obj instanceof x5.e) {
            ((x5.e) obj).c().f16681a = true;
        }
        ((x5.f) this.f429j).a(obj);
        return ((d) this.f430k).e(obj);
    }

    public final Object f() {
        return null;
    }

    public final Uri g() {
        return (Uri) this.f428i;
    }

    public final ClipDescription getDescription() {
        return (ClipDescription) this.f429j;
    }

    public final void h() {
    }

    public final Uri i() {
        return (Uri) this.f430k;
    }

    public final Object j() {
        Object j10 = ((d) this.f430k).j();
        if (j10 == null) {
            j10 = ((x5.d) this.f428i).f();
            if (Log.isLoggable("FactoryPools", 2)) {
                j10.getClass().toString();
            }
        }
        if (j10 instanceof x5.e) {
            ((x5.e) j10).c().f16681a = false;
        }
        return j10;
    }

    public final void k(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        m mVar = (m) ((k) this.f428i);
        if ((mVar.f403a.getFlags() & 4) != 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat);
            bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", i10);
            mVar.f403a.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, (ResultReceiver) null);
            return;
        }
        throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }

    public final Bitmap n(BitmapFactory.Options options) {
        switch (this.f427h) {
            case 20:
                return BitmapFactory.decodeStream(new j4.n(w5.a.c((ByteBuffer) this.f428i)), (Rect) null, options);
            case 21:
                e0 e0Var = (e0) ((p) this.f428i).f3241b;
                e0Var.reset();
                return BitmapFactory.decodeStream(e0Var, (Rect) null, options);
            default:
                return BitmapFactory.decodeFileDescriptor(((p) this.f430k).a().getFileDescriptor(), (Rect) null, options);
        }
    }

    public final void o(KeyEvent keyEvent) {
        if (keyEvent != null) {
            ((m) ((k) this.f428i)).f403a.dispatchMediaButtonEvent(keyEvent);
            return;
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public final w1 q(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return r(cls, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final w1 r(Class cls, String str) {
        w1 w1Var;
        f2 f2Var;
        j.f("key", str);
        g2 g2Var = (g2) this.f428i;
        g2Var.getClass();
        w1 w1Var2 = (w1) g2Var.f1696a.get(str);
        if (cls.isInstance(w1Var2)) {
            b2 b2Var = (b2) this.f429j;
            if (b2Var instanceof f2) {
                f2Var = (f2) b2Var;
            } else {
                f2Var = null;
            }
            if (f2Var != null) {
                j.c(w1Var2);
                f2Var.c(w1Var2);
            }
            j.d("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get", w1Var2);
            return w1Var2;
        }
        b1.f fVar = new b1.f((b1.c) this.f430k);
        fVar.b(e2.f1678c, str);
        try {
            w1Var = ((b2) this.f429j).b(cls, fVar);
        } catch (AbstractMethodError unused) {
            w1Var = ((b2) this.f429j).a(cls);
        }
        g2 g2Var2 = (g2) this.f428i;
        g2Var2.getClass();
        j.f("viewModel", w1Var);
        w1 w1Var3 = (w1) g2Var2.f1696a.put(str, w1Var);
        if (w1Var3 != null) {
            w1Var3.b();
        }
        return w1Var;
    }

    public final c0 s() {
        return ((z) this.f428i).u();
    }

    public final long t() {
        Object obj = this.f430k;
        if (((w) obj) != null) {
            return ((w) obj).p();
        }
        return -1;
    }

    public final String toString() {
        switch (this.f427h) {
            case 4:
                String str = "[ ";
                if (((s.j) this.f428i) != null) {
                    for (int i10 = 0; i10 < 9; i10++) {
                        StringBuilder q10 = h.q(str);
                        q10.append(((s.j) this.f428i).f13966o[i10]);
                        q10.append(" ");
                        str = q10.toString();
                    }
                }
                return str + "] " + ((s.j) this.f428i);
            case 14:
                StringBuilder sb2 = new StringBuilder("NavDeepLinkRequest{");
                if (((Uri) this.f428i) != null) {
                    sb2.append(" uri=");
                    sb2.append(String.valueOf((Uri) this.f428i));
                }
                if (((String) this.f429j) != null) {
                    sb2.append(" action=");
                    sb2.append((String) this.f429j);
                }
                if (((String) this.f430k) != null) {
                    sb2.append(" mimetype=");
                    sb2.append((String) this.f430k);
                }
                sb2.append(" }");
                String sb3 = sb2.toString();
                j.e("sb.toString()", sb3);
                return sb3;
            default:
                return super.toString();
        }
    }

    public final v u(Object... objArr) {
        Constructor constructor;
        Object obj;
        synchronized (((AtomicBoolean) this.f429j)) {
            if (((AtomicBoolean) this.f429j).get()) {
                obj = this.f430k;
            } else {
                try {
                    constructor = ((i1.c) ((q) this.f428i)).h();
                } catch (ClassNotFoundException unused) {
                    ((AtomicBoolean) this.f429j).set(true);
                    obj = this.f430k;
                } catch (Exception e10) {
                    throw new RuntimeException("Error instantiating extension", e10);
                }
            }
            constructor = (Constructor) obj;
        }
        if (constructor == null) {
            return null;
        }
        try {
            return (v) constructor.newInstance(objArr);
        } catch (Exception e11) {
            throw new IllegalStateException("Unexpected error creating extractor", e11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bumptech.glide.load.ImageHeaderParser$ImageType v() {
        /*
            r9 = this;
            int r0 = r9.f427h
            switch(r0) {
                case 20: goto L_0x001e;
                case 21: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x002f
        L_0x0006:
            java.lang.Object r0 = r9.f430k
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r9.f428i
            com.bumptech.glide.load.data.p r1 = (com.bumptech.glide.load.data.p) r1
            java.lang.Object r1 = r1.f3241b
            k5.e0 r1 = (k5.e0) r1
            r1.reset()
            java.lang.Object r2 = r9.f429j
            e5.k r2 = (e5.k) r2
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = b5.i.c(r2, r1, r0)
            return r0
        L_0x001e:
            java.lang.Object r0 = r9.f429j
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r9.f428i
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.nio.ByteBuffer r1 = w5.a.c(r1)
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = b5.i.d(r0, r1)
            return r0
        L_0x002f:
            java.lang.Object r0 = r9.f429j
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r9.f430k
            com.bumptech.glide.load.data.p r1 = (com.bumptech.glide.load.data.p) r1
            java.lang.Object r2 = r9.f428i
            e5.k r2 = (e5.k) r2
            int r3 = r0.size()
            r4 = 0
        L_0x0040:
            if (r4 >= r3) goto L_0x0079
            java.lang.Object r5 = r0.get(r4)
            b5.f r5 = (b5.f) r5
            k5.e0 r6 = new k5.e0     // Catch:{ all -> 0x006e }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x006e }
            android.os.ParcelFileDescriptor r8 = r1.a()     // Catch:{ all -> 0x006e }
            java.io.FileDescriptor r8 = r8.getFileDescriptor()     // Catch:{ all -> 0x006e }
            r7.<init>(r8)     // Catch:{ all -> 0x006e }
            r6.<init>(r7, r2)     // Catch:{ all -> 0x006e }
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = r5.c(r6)     // Catch:{ all -> 0x006c }
            r6.e()
            r1.a()
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser$ImageType.UNKNOWN
            if (r5 == r6) goto L_0x0069
            goto L_0x007b
        L_0x0069:
            int r4 = r4 + 1
            goto L_0x0040
        L_0x006c:
            r0 = move-exception
            goto L_0x0070
        L_0x006e:
            r0 = move-exception
            r6 = 0
        L_0x0070:
            if (r6 == 0) goto L_0x0075
            r6.e()
        L_0x0075:
            r1.a()
            throw r0
        L_0x0079:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser$ImageType.UNKNOWN
        L_0x007b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.u.v():com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    public final PlaybackStateCompat w() {
        m mVar = (m) ((k) this.f428i);
        MediaSessionCompat$Token mediaSessionCompat$Token = mVar.f407e;
        if (mediaSessionCompat$Token.u() != null) {
            try {
                return mediaSessionCompat$Token.u().b();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e10);
            }
        }
        PlaybackState playbackState = mVar.f403a.getPlaybackState();
        if (playbackState != null) {
            return PlaybackStateCompat.u(playbackState);
        }
        return null;
    }

    public final int x() {
        MediaSessionCompat$Token mediaSessionCompat$Token = ((m) ((k) this.f428i)).f407e;
        if (mediaSessionCompat$Token.u() != null) {
            try {
                return mediaSessionCompat$Token.u().h();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e10);
            }
        }
        return -1;
    }

    public final LinearLayout y() {
        switch (this.f427h) {
            case 26:
                return (LinearLayout) this.f428i;
            default:
                return (LinearLayout) this.f428i;
        }
    }

    public final int z() {
        MediaSessionCompat$Token mediaSessionCompat$Token = ((m) ((k) this.f428i)).f407e;
        if (mediaSessionCompat$Token.u() != null) {
            try {
                return mediaSessionCompat$Token.u().A();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e10);
            }
        }
        return -1;
    }

    public u(Context context, LocationManager locationManager) {
        this.f427h = 3;
        this.f430k = new y0();
        this.f428i = context;
        this.f429j = locationManager;
    }

    public u(Context context, u uVar) {
        this.f427h = 0;
        this.f430k = new ConcurrentHashMap();
        if (uVar != null) {
            MediaSessionCompat$Token h10 = ((z) uVar.f428i).h();
            this.f429j = h10;
            this.f428i = Build.VERSION.SDK_INT >= 29 ? new n(context, h10) : new m(context, h10);
            return;
        }
        throw new IllegalArgumentException("session must not be null");
    }

    public u(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.f427h = 0;
        this.f430k = new ConcurrentHashMap();
        if (mediaSessionCompat$Token != null) {
            this.f429j = mediaSessionCompat$Token;
            this.f428i = new m(context, mediaSessionCompat$Token);
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public u(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this(pendingIntent, componentName, context, bundle, str);
        this.f427h = 1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public u(Intent intent) {
        this((Object) intent.getData(), (Object) intent.getAction(), (Object) intent.getType(), 14, 0);
        this.f427h = 14;
    }

    public u(Uri uri, h9.e0 e0Var) {
        this.f427h = 13;
        this.f428i = null;
        this.f429j = uri;
        this.f430k = e0Var;
    }

    public u(ParcelFileDescriptor parcelFileDescriptor, List list, k kVar) {
        this.f427h = 22;
        w5.n.b(kVar);
        this.f428i = kVar;
        w5.n.b(list);
        this.f429j = list;
        this.f430k = new p(parcelFileDescriptor);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public u(g2 g2Var, b2 b2Var) {
        this(g2Var, b2Var, 0);
        this.f427h = 8;
        j.f("store", g2Var);
        j.f("factory", b2Var);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(g2 g2Var, b2 b2Var, int i10) {
        this(g2Var, b2Var, (b1.c) b1.a.f2409b);
        this.f427h = 8;
    }

    public u(g2 g2Var, b2 b2Var, b1.c cVar) {
        this.f427h = 8;
        j.f("store", g2Var);
        j.f("factory", b2Var);
        j.f("defaultCreationExtras", cVar);
        this.f428i = g2Var;
        this.f429j = b2Var;
        this.f430k = cVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public u(h2 h2Var, b2 b2Var) {
        this(h2Var.m(), b2Var, h2Var instanceof androidx.lifecycle.m ? ((androidx.lifecycle.m) h2Var).i() : b1.a.f2409b);
        this.f427h = 8;
        j.f("owner", h2Var);
    }

    public u(d2.a0 a0Var) {
        this.f427h = 10;
        this.f428i = a0Var;
    }

    public u(d5.w wVar, s5.g gVar, d5.b0 b0Var) {
        this.f427h = 19;
        this.f430k = wVar;
        this.f429j = gVar;
        this.f428i = b0Var;
    }

    public u(k kVar, l lVar, List list) {
        this.f427h = 21;
        w5.n.b(kVar);
        this.f429j = kVar;
        w5.n.b(list);
        this.f430k = list;
        this.f428i = new p(lVar, kVar);
    }

    public u(i1.c cVar) {
        this.f427h = 11;
        this.f428i = cVar;
        this.f429j = new AtomicBoolean(false);
    }

    public u(i4.m mVar, w4.o oVar) {
        Object obj;
        this.f427h = 17;
        this.f428i = mVar;
        this.f429j = oVar;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            boolean z10 = w4.a.f16073a;
        } else if (!w4.a.f16073a) {
            obj = (i10 == 26 || i10 == 27) ? new w4.l() : new z0(true);
            this.f430k = obj;
        }
        obj = new z0(false);
        this.f430k = obj;
    }

    public /* synthetic */ u(Object obj, Object obj2, Object obj3, int i10) {
        this.f427h = i10;
        this.f430k = obj;
        this.f428i = obj2;
        this.f429j = obj3;
    }

    public /* synthetic */ u(Object obj, Object obj2, Object obj3, int i10, int i11) {
        this.f427h = i10;
        this.f428i = obj;
        this.f429j = obj2;
        this.f430k = obj3;
    }

    public u(Runnable runnable) {
        this.f427h = 6;
        this.f429j = new CopyOnWriteArrayList();
        this.f430k = new HashMap();
        this.f428i = runnable;
    }

    public u(String str) {
        this.f427h = 12;
        z zVar = new z();
        zVar.f6754k = str;
        this.f428i = new a0(zVar);
    }

    public u(s.h hVar, s.h hVar2) {
        this.f427h = 4;
        this.f430k = hVar;
        this.f429j = hVar2;
    }

    public u(u.g gVar) {
        this.f427h = 5;
        this.f428i = new ArrayList();
        this.f429j = new b();
        this.f430k = gVar;
    }

    public u(y5.h hVar, y5.c cVar) {
        this.f427h = 25;
        this.f428i = hVar;
        this.f429j = cVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(y5.h hVar, y5.c cVar, int i10) {
        this(hVar, cVar);
        this.f427h = 25;
    }

    public u(byte[] bArr, h9.e0 e0Var) {
        this.f427h = 13;
        this.f428i = bArr;
        this.f429j = null;
        this.f430k = e0Var;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public u(h1.c[] cVarArr) {
        this(cVarArr, new o1.l0(), new n0());
        this.f427h = 9;
    }

    public u(h1.c[] cVarArr, o1.l0 l0Var, n0 n0Var) {
        this.f427h = 9;
        h1.c[] cVarArr2 = new h1.c[(cVarArr.length + 2)];
        this.f428i = cVarArr2;
        System.arraycopy(cVarArr, 0, cVarArr2, 0, cVarArr.length);
        this.f429j = l0Var;
        this.f430k = n0Var;
        h1.c[] cVarArr3 = (h1.c[]) this.f428i;
        cVarArr3[cVarArr.length] = l0Var;
        cVarArr3[cVarArr.length + 1] = n0Var;
    }
}
