package com.github.andreyasadchy.xtra.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.u;
import android.view.View;
import androidx.activity.b;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.fragment.app.d1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.games.GamePagerFragment;
import com.woxthebox.draglistview.R;
import g.g0;
import hb.h0;
import j3.b1;
import j3.f1;
import j3.h1;
import j3.j1;
import j3.k0;
import j3.v0;
import j3.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import l3.j;
import la.i;
import ma.r;
import ma.z;
import q7.c;
import s6.a;
import s6.d;
import t6.a0;
import t6.l;
import w6.f;
import x6.h;
import xa.v;

public final class MainActivity extends a implements c {
    public static final /* synthetic */ int N = 0;
    public w0 H;
    public final x1 I = new x1(v.a(MainViewModel.class), new d(this, 1), new d(this, 0), new j((Object) null, 4, this));
    public j1 J;
    public l K;
    public final g0 L = new g0(6, this);
    public SharedPreferences M;

    static {
        new s6.c(0);
    }

    public static final void G(MainActivity mainActivity) {
        mainActivity.finish();
        mainActivity.overridePendingTransition(0, 0);
        Intent intent = new Intent(mainActivity, MainActivity.class);
        intent.addFlags(65536);
        mainActivity.startActivity(intent);
        mainActivity.overridePendingTransition(0, 0);
    }

    public final void E() {
        d1 A = A();
        A.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a((c1) A);
        aVar.f1538f = 4099;
        c0 D = A().D(R.id.playerContainer);
        xa.j.c(D);
        aVar.k(D);
        aVar.g();
        this.K = null;
        F().f3433e = false;
        if (getPackageManager().hasSystemFeature("android.software.picture_in_picture") && Build.VERSION.SDK_INT >= 31) {
            b.t();
            setPictureInPictureParams(b.i().setAutoEnterEnabled(false).build());
        }
    }

    public final MainViewModel F() {
        return (MainViewModel) this.I.getValue();
    }

    public final void H() {
        Bundle bundle;
        int[] iArr;
        int i10;
        h1 h1Var;
        int i11;
        Bundle bundle2;
        boolean z10;
        Bundle bundle3;
        Intent intent;
        j1 j1Var = this.J;
        if (j1Var != null) {
            int i12 = 0;
            if (j1Var.g() == 1) {
                Activity activity = j1Var.f8577b;
                if (activity == null || (intent = activity.getIntent()) == null) {
                    bundle = null;
                } else {
                    bundle = intent.getExtras();
                }
                if (bundle != null) {
                    iArr = bundle.getIntArray("android-support-nav:controller:deepLinkIds");
                } else {
                    iArr = null;
                }
                if (iArr == null) {
                    j3.c1 f10 = j1Var.f();
                    xa.j.c(f10);
                    h1 h1Var2 = f10;
                    do {
                        i10 = h1Var2.f8513o;
                        h1Var = h1Var2.f8507i;
                        if (h1Var != null) {
                            i11 = h1Var.f8558s;
                            h1Var2 = h1Var;
                        } else {
                            return;
                        }
                    } while (i11 == i10);
                    Bundle bundle4 = new Bundle();
                    if (!(activity == null || activity.getIntent() == null || activity.getIntent().getData() == null)) {
                        bundle4.putParcelable("android-support-nav:controller:deepLinkIntent", activity.getIntent());
                        h1 h1Var3 = j1Var.f8578c;
                        xa.j.c(h1Var3);
                        Intent intent2 = activity.getIntent();
                        xa.j.e("activity!!.intent", intent2);
                        b1 f11 = h1Var3.f(new u(intent2));
                        if (f11 != null) {
                            bundle2 = f11.f8496i;
                        } else {
                            bundle2 = null;
                        }
                        if (bundle2 != null) {
                            bundle4.putAll(f11.f8495h.b(f11.f8496i));
                        }
                    }
                    w0 w0Var = new w0(j1Var);
                    int i13 = h1Var.f8513o;
                    List list = (List) w0Var.f8717d;
                    list.clear();
                    list.add(new v0(i13, (Bundle) null));
                    if (((h1) w0Var.f8716c) != null) {
                        w0Var.d();
                    }
                    w0Var.f8718e = bundle4;
                    ((Intent) w0Var.f8715b).putExtra("android-support-nav:controller:deepLinkExtras", bundle4);
                    w0Var.a().b();
                    if (activity != null) {
                        activity.finish();
                    }
                } else if (j1Var.f8581f) {
                    xa.j.c(activity);
                    Intent intent3 = activity.getIntent();
                    Bundle extras = intent3.getExtras();
                    xa.j.c(extras);
                    int[] intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
                    xa.j.c(intArray);
                    ArrayList arrayList = new ArrayList(intArray.length);
                    for (int valueOf : intArray) {
                        arrayList.add(Integer.valueOf(valueOf));
                    }
                    ArrayList parcelableArrayList = extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
                    if (!arrayList.isEmpty()) {
                        int intValue = ((Number) arrayList.remove(r.d(arrayList))).intValue();
                        if (parcelableArrayList != null) {
                            if (!parcelableArrayList.isEmpty()) {
                                Bundle bundle5 = (Bundle) parcelableArrayList.remove(r.d(parcelableArrayList));
                            } else {
                                throw new NoSuchElementException("List is empty.");
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            j3.c1 d10 = k0.d(j1Var.h(), intValue);
                            if (d10 instanceof h1) {
                                h1.f8556v.getClass();
                                intValue = f1.a((h1) d10).f8513o;
                            }
                            j3.c1 f12 = j1Var.f();
                            if (f12 == null || intValue != f12.f8513o) {
                                z10 = false;
                            } else {
                                z10 = true;
                            }
                            if (z10) {
                                w0 w0Var2 = new w0(j1Var);
                                Bundle r10 = h0.r(new i("android-support-nav:controller:deepLinkIntent", intent3));
                                Bundle bundle6 = extras.getBundle("android-support-nav:controller:deepLinkExtras");
                                if (bundle6 != null) {
                                    r10.putAll(bundle6);
                                }
                                w0Var2.f8718e = r10;
                                ((Intent) w0Var2.f8715b).putExtra("android-support-nav:controller:deepLinkExtras", r10);
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    int i14 = i12 + 1;
                                    if (i12 >= 0) {
                                        int intValue2 = ((Number) next).intValue();
                                        if (parcelableArrayList != null) {
                                            bundle3 = (Bundle) parcelableArrayList.get(i12);
                                        } else {
                                            bundle3 = null;
                                        }
                                        ((List) w0Var2.f8717d).add(new v0(intValue2, bundle3));
                                        if (((h1) w0Var2.f8716c) != null) {
                                            w0Var2.d();
                                        }
                                        i12 = i14;
                                    } else {
                                        r.h();
                                        throw null;
                                    }
                                }
                                w0Var2.a().b();
                                activity.finish();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new NoSuchElementException("List is empty.");
                }
            } else if (!j1Var.f8582g.isEmpty()) {
                j3.c1 f13 = j1Var.f();
                xa.j.c(f13);
                if (j1Var.n(f13.f8513o, true, false)) {
                    j1Var.b();
                }
            }
        } else {
            xa.j.l("navController");
            throw null;
        }
    }

    public final void I() {
        l lVar;
        boolean z10;
        if (F().f3433e) {
            l lVar2 = this.K;
            if (lVar2 == null) {
                this.K = (l) A().D(R.id.playerContainer);
                return;
            }
            View secondView = lVar2.u0().getSecondView();
            boolean z11 = false;
            if (secondView != null) {
                if (secondView.getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    z11 = true;
                }
            }
            if (z11) {
                SharedPreferences sharedPreferences = this.M;
                if (sharedPreferences == null) {
                    xa.j.l("prefs");
                    throw null;
                } else if (xa.j.a(sharedPreferences.getString("player_background_playback", "0"), "0") && (lVar = this.K) != null) {
                    lVar.u0().f();
                }
            }
        }
    }

    public final void J(Clip clip) {
        xa.j.f("clip", clip);
        u6.d.I0.getClass();
        u6.d dVar = new u6.d();
        dVar.j0(h0.r(new i("clip", clip)));
        K(dVar);
    }

    public final void K(l lVar) {
        this.K = lVar;
        d1 A = A();
        A.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a((c1) A);
        aVar.e(R.id.playerContainer, lVar, (String) null);
        aVar.g();
        F().f3433e = true;
        if (getPackageManager().hasSystemFeature("android.software.picture_in_picture") && Build.VERSION.SDK_INT >= 31) {
            SharedPreferences sharedPreferences = this.M;
            if (sharedPreferences == null) {
                xa.j.l("prefs");
                throw null;
            } else if (xa.j.a(sharedPreferences.getString("player_background_playback", "0"), "0")) {
                b.t();
                setPictureInPictureParams(b.i().setAutoEnterEnabled(true).build());
            }
        }
    }

    public final void L(Stream stream) {
        xa.j.f("stream", stream);
        f.H0.getClass();
        f fVar = new f();
        fVar.j0(h0.r(new i("stream", stream)));
        K(fVar);
    }

    public final void M(Video video, Double d10) {
        xa.j.f("video", video);
        h.H0.getClass();
        h hVar = new h();
        hVar.j0(h0.r(new i("video", video), new i("offset", d10)));
        K(hVar);
    }

    public final void e() {
        F();
    }

    public final void l() {
        F();
    }

    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
        } else if (i11 != -1) {
            return;
        }
        G(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0222, code lost:
        if (r4 == 0) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0224, code lost:
        r4 = r0.M;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0226, code lost:
        if (r4 == null) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x022c, code lost:
        if (r4.getBoolean("ui_followpager", true) == false) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x022e, code lost:
        r9.k(com.woxthebox.draglistview.R.id.followPagerFragment);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0232, code lost:
        r9.k(com.woxthebox.draglistview.R.id.followMediaFragment);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0236, code lost:
        xa.j.l("prefs");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0239, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01fd, code lost:
        if (r11 >= 2) goto L_0x0204;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r18) {
        /*
            r17 = this;
            r0 = r17
            super.onCreate(r18)
            android.content.SharedPreferences r1 = hb.h0.l1(r17)
            r0.M = r1
            java.lang.String r2 = "first_launch2"
            r3 = 1
            boolean r1 = r1.getBoolean(r2, r3)
            java.lang.String r4 = "2"
            java.lang.String r5 = "editor"
            java.lang.String r6 = "prefs"
            r7 = 0
            r8 = 0
            if (r1 == 0) goto L_0x0073
            r1 = 2132148231(0x7f160007, float:1.9938434E38)
            o3.i0.f(r0, r1, r7)
            r1 = 2132148229(0x7f160005, float:1.993843E38)
            o3.i0.f(r0, r1, r3)
            r1 = 2132148230(0x7f160006, float:1.9938432E38)
            o3.i0.f(r0, r1, r3)
            r1 = 2132148225(0x7f160001, float:1.9938422E38)
            o3.i0.f(r0, r1, r3)
            android.content.SharedPreferences r1 = r0.M
            if (r1 == 0) goto L_0x006f
            android.content.SharedPreferences$Editor r1 = r1.edit()
            xa.j.e(r5, r1)
            r1.putBoolean(r2, r7)
            s7.b r2 = s7.b.f14365a
            r2.getClass()
            r2 = 30
            int r2 = s7.b.a(r0, r2)
            java.lang.String r9 = "landscape_chat_width"
            r1.putInt(r9, r2)
            android.content.res.Resources r2 = r17.getResources()
            r9 = 2131034115(0x7f050003, float:1.7678738E38)
            boolean r2 = r2.getBoolean(r9)
            if (r2 == 0) goto L_0x006b
            java.lang.String r2 = "columnsPortrait"
            r1.putString(r2, r4)
            java.lang.String r2 = "columnsLandscape"
            java.lang.String r9 = "3"
            r1.putString(r2, r9)
        L_0x006b:
            r1.apply()
            goto L_0x0073
        L_0x006f:
            xa.j.l(r6)
            throw r8
        L_0x0073:
            android.content.SharedPreferences r1 = r0.M
            if (r1 == 0) goto L_0x0379
            java.lang.String r2 = "first_launch"
            boolean r1 = r1.getBoolean(r2, r3)
            if (r1 == 0) goto L_0x00a0
            android.content.SharedPreferences r1 = r0.M
            if (r1 == 0) goto L_0x009c
            android.content.SharedPreferences$Editor r1 = r1.edit()
            xa.j.e(r5, r1)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 28
            if (r9 >= r10) goto L_0x0095
            java.lang.String r9 = "chat_image_library"
            r1.putString(r9, r4)
        L_0x0095:
            r1.putBoolean(r2, r7)
            r1.apply()
            goto L_0x00a0
        L_0x009c:
            xa.j.l(r6)
            throw r8
        L_0x00a0:
            android.content.SharedPreferences r1 = r0.M
            if (r1 == 0) goto L_0x0375
            java.lang.String r2 = "first_launch1"
            boolean r1 = r1.getBoolean(r2, r3)
            java.lang.String r4 = "1"
            if (r1 == 0) goto L_0x00e2
            android.content.SharedPreferences r1 = r0.M
            if (r1 == 0) goto L_0x00de
            android.content.SharedPreferences$Editor r1 = r1.edit()
            xa.j.e(r5, r1)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 26
            java.lang.String r11 = "player_background_playback"
            if (r9 < r10) goto L_0x00d4
            android.content.pm.PackageManager r9 = r17.getPackageManager()
            java.lang.String r10 = "android.software.picture_in_picture"
            boolean r9 = r9.hasSystemFeature(r10)
            if (r9 != 0) goto L_0x00ce
            goto L_0x00d4
        L_0x00ce:
            java.lang.String r9 = "0"
            r1.putString(r11, r9)
            goto L_0x00d7
        L_0x00d4:
            r1.putString(r11, r4)
        L_0x00d7:
            r1.putBoolean(r2, r7)
            r1.apply()
            goto L_0x00e2
        L_0x00de:
            xa.j.l(r6)
            throw r8
        L_0x00e2:
            android.content.SharedPreferences r1 = r0.M
            if (r1 == 0) goto L_0x0371
            java.lang.String r2 = "first_launch3"
            boolean r1 = r1.getBoolean(r2, r3)
            if (r1 == 0) goto L_0x0131
            android.content.SharedPreferences r1 = r0.M
            if (r1 == 0) goto L_0x012d
            android.content.SharedPreferences$Editor r1 = r1.edit()
            xa.j.e(r5, r1)
            android.content.SharedPreferences r9 = r0.M
            if (r9 == 0) goto L_0x0129
            java.lang.String r10 = "ui_language"
            java.lang.String r11 = ""
            java.lang.String r9 = r9.getString(r10, r11)
            if (r9 == 0) goto L_0x0110
            boolean r10 = fb.w.h(r9)
            if (r10 == 0) goto L_0x010e
            goto L_0x0110
        L_0x010e:
            r10 = 0
            goto L_0x0111
        L_0x0110:
            r10 = 1
        L_0x0111:
            if (r10 != 0) goto L_0x0122
            java.lang.String r10 = "auto"
            boolean r10 = xa.j.a(r9, r10)
            if (r10 != 0) goto L_0x0122
            i0.i r9 = i0.i.b(r9)
            g.t.w(r9)
        L_0x0122:
            r1.putBoolean(r2, r7)
            r1.apply()
            goto L_0x0131
        L_0x0129:
            xa.j.l(r6)
            throw r8
        L_0x012d:
            xa.j.l(r6)
            throw r8
        L_0x0131:
            android.content.SharedPreferences r1 = r0.M
            if (r1 == 0) goto L_0x036d
            java.lang.String r2 = "first_launch5"
            boolean r1 = r1.getBoolean(r2, r3)
            if (r1 == 0) goto L_0x0153
            android.content.SharedPreferences r1 = r0.M
            if (r1 == 0) goto L_0x014f
            android.content.SharedPreferences$Editor r1 = r1.edit()
            xa.j.e(r5, r1)
            r1.putBoolean(r2, r7)
            r1.apply()
            goto L_0x0153
        L_0x014f:
            xa.j.l(r6)
            throw r8
        L_0x0153:
            hb.h0.g(r17)
            android.view.LayoutInflater r1 = r17.getLayoutInflater()
            r2 = 2131558429(0x7f0d001d, float:1.8742174E38)
            android.view.View r1 = r1.inflate(r2, r8, r7)
            r2 = 2131362275(0x7f0a01e3, float:1.8344326E38)
            android.view.View r5 = e4.a.a(r1, r2)
            r11 = r5
            com.google.android.material.bottomnavigation.BottomNavigationView r11 = (com.google.android.material.bottomnavigation.BottomNavigationView) r11
            if (r11 == 0) goto L_0x0359
            r2 = 2131362276(0x7f0a01e4, float:1.8344328E38)
            android.view.View r5 = e4.a.a(r1, r2)
            r12 = r5
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x0359
            r2 = 2131362277(0x7f0a01e5, float:1.834433E38)
            android.view.View r5 = e4.a.a(r1, r2)
            r13 = r5
            androidx.fragment.app.FragmentContainerView r13 = (androidx.fragment.app.FragmentContainerView) r13
            if (r13 == 0) goto L_0x0359
            r5 = 2131362333(0x7f0a021d, float:1.8344444E38)
            android.view.View r9 = e4.a.a(r1, r5)
            r14 = r9
            android.widget.FrameLayout r14 = (android.widget.FrameLayout) r14
            if (r14 == 0) goto L_0x0356
            j3.w0 r5 = new j3.w0
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            r16 = 4
            r9 = r5
            r10 = r1
            r15 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r0.H = r5
            switch(r16) {
                case 3: goto L_0x01a3;
                default: goto L_0x01a3;
            }
        L_0x01a3:
            r0.setContentView((android.view.View) r1)
            if (r18 != 0) goto L_0x01aa
            r1 = 1
            goto L_0x01ab
        L_0x01aa:
            r1 = 0
        L_0x01ab:
            androidx.fragment.app.d1 r5 = r17.A()
            androidx.fragment.app.c0 r2 = r5.D(r2)
            java.lang.String r5 = "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment"
            xa.j.d(r5, r2)
            androidx.navigation.fragment.NavHostFragment r2 = (androidx.navigation.fragment.NavHostFragment) r2
            j3.j1 r2 = r2.l0()
            r0.J = r2
            java.lang.String r5 = "navController"
            if (r2 == 0) goto L_0x0352
            la.o r9 = r2.B
            java.lang.Object r9 = r9.getValue()
            j3.l1 r9 = (j3.l1) r9
            r10 = 2131820544(0x7f110000, float:1.9273806E38)
            j3.h1 r9 = r9.b(r10)
            com.github.andreyasadchy.xtra.model.Account$Companion r10 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r11 = r10.get(r0)
            boolean r11 = r11 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            r12 = 2131362121(0x7f0a0149, float:1.8344014E38)
            r13 = 2131362120(0x7f0a0148, float:1.8344012E38)
            java.lang.String r14 = "ui_followpager"
            java.lang.String r15 = "ui_startonfollowed"
            if (r11 != 0) goto L_0x0204
            android.content.SharedPreferences r11 = r0.M
            if (r11 == 0) goto L_0x0200
            java.lang.String r11 = r11.getString(r15, r4)
            if (r11 == 0) goto L_0x01fb
            java.lang.Integer r11 = fb.v.d(r11)
            if (r11 == 0) goto L_0x01fb
            int r11 = r11.intValue()
            goto L_0x01fc
        L_0x01fb:
            r11 = 1
        L_0x01fc:
            r7 = 2
            if (r11 < r7) goto L_0x0224
            goto L_0x0204
        L_0x0200:
            xa.j.l(r6)
            throw r8
        L_0x0204:
            com.github.andreyasadchy.xtra.model.Account r7 = r10.get(r0)
            boolean r7 = r7 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r7 == 0) goto L_0x023e
            android.content.SharedPreferences r7 = r0.M
            if (r7 == 0) goto L_0x023a
            java.lang.String r4 = r7.getString(r15, r4)
            if (r4 == 0) goto L_0x0221
            java.lang.Integer r4 = fb.v.d(r4)
            if (r4 == 0) goto L_0x0221
            int r4 = r4.intValue()
            goto L_0x0222
        L_0x0221:
            r4 = 1
        L_0x0222:
            if (r4 != 0) goto L_0x023e
        L_0x0224:
            android.content.SharedPreferences r4 = r0.M
            if (r4 == 0) goto L_0x0236
            boolean r4 = r4.getBoolean(r14, r3)
            if (r4 == 0) goto L_0x0232
            r9.k(r12)
            goto L_0x023e
        L_0x0232:
            r9.k(r13)
            goto L_0x023e
        L_0x0236:
            xa.j.l(r6)
            throw r8
        L_0x023a:
            xa.j.l(r6)
            throw r8
        L_0x023e:
            r2.s(r9, r8)
            j3.w0 r2 = r0.H
            if (r2 == 0) goto L_0x034c
            java.lang.Object r2 = r2.f8715b
            com.google.android.material.bottomnavigation.BottomNavigationView r2 = (com.google.android.material.bottomnavigation.BottomNavigationView) r2
            android.view.Menu r4 = r2.getMenu()
            r7 = 2131362381(0x7f0a024d, float:1.834454E38)
            r9 = 2131951864(0x7f1300f8, float:1.9540155E38)
            r10 = 0
            android.view.MenuItem r4 = r4.add(r10, r7, r10, r9)
            r7 = 2131230989(0x7f08010d, float:1.8078046E38)
            r4.setIcon(r7)
            android.view.Menu r4 = r2.getMenu()
            r7 = 2131362382(0x7f0a024e, float:1.8344543E38)
            r9 = 2131952248(0x7f130278, float:1.9540933E38)
            android.view.MenuItem r4 = r4.add(r10, r7, r10, r9)
            r7 = 2131231002(0x7f08011a, float:1.8078073E38)
            r4.setIcon(r7)
            android.content.SharedPreferences r4 = r0.M
            if (r4 == 0) goto L_0x0348
            boolean r4 = r4.getBoolean(r14, r3)
            r7 = 2131951857(0x7f1300f1, float:1.954014E38)
            if (r4 == 0) goto L_0x0288
            android.view.Menu r4 = r2.getMenu()
            android.view.MenuItem r4 = r4.add(r10, r12, r10, r7)
            goto L_0x0290
        L_0x0288:
            android.view.Menu r4 = r2.getMenu()
            android.view.MenuItem r4 = r4.add(r10, r13, r10, r7)
        L_0x0290:
            r7 = 2131230987(0x7f08010b, float:1.8078042E38)
            r4.setIcon(r7)
            android.content.SharedPreferences r4 = r0.M
            if (r4 == 0) goto L_0x0344
            java.lang.String r6 = "ui_savedpager"
            boolean r4 = r4.getBoolean(r6, r3)
            if (r4 == 0) goto L_0x02aa
            android.view.Menu r4 = r2.getMenu()
            r6 = 2131362393(0x7f0a0259, float:1.8344565E38)
            goto L_0x02b1
        L_0x02aa:
            android.view.Menu r4 = r2.getMenu()
            r6 = 2131362392(0x7f0a0258, float:1.8344563E38)
        L_0x02b1:
            r7 = 2131952281(0x7f130299, float:1.9541E38)
            r9 = 0
            android.view.MenuItem r4 = r4.add(r9, r6, r9, r7)
            r6 = 2131230988(0x7f08010c, float:1.8078044E38)
            r4.setIcon(r6)
            j3.j1 r4 = r0.J
            if (r4 == 0) goto L_0x0340
            int r5 = m3.b.f10568a
            p0.c r5 = new p0.c
            r6 = 23
            r5.<init>(r6, r4)
            r2.setOnItemSelectedListener(r5)
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r2)
            m3.a r6 = new m3.a
            r6.<init>(r5, r4)
            java.util.concurrent.CopyOnWriteArrayList r5 = r4.f8591p
            r5.add(r6)
            ma.l r5 = r4.f8582g
            boolean r7 = r5.isEmpty()
            r7 = r7 ^ r3
            if (r7 == 0) goto L_0x02f5
            java.lang.Object r5 = r5.last()
            j3.r r5 = (j3.r) r5
            j3.c1 r7 = r5.f8661i
            r5.b()
            r6.a(r4, r7)
        L_0x02f5:
            s6.b r4 = new s6.b
            r4.<init>(r0)
            r2.setOnItemSelectedListener(r4)
            s6.b r4 = new s6.b
            r4.<init>(r0)
            r2.setOnItemReselectedListener(r4)
            xa.q r2 = new xa.q
            r2.<init>()
            if (r1 == 0) goto L_0x0313
            boolean r1 = hb.h0.X0(r17)
            if (r1 != 0) goto L_0x0313
            goto L_0x0314
        L_0x0313:
            r3 = 0
        L_0x0314:
            r2.f16814h = r3
            com.github.andreyasadchy.xtra.ui.main.MainViewModel r1 = r17.F()
            androidx.lifecycle.o0 r1 = r1.f3432d
            androidx.lifecycle.u1 r3 = new androidx.lifecycle.u1
            r4 = 8
            r3.<init>(r2, r4, r0)
            androidx.lifecycle.v1 r2 = new androidx.lifecycle.v1
            r4 = 12
            r2.<init>(r4, r3)
            r1.f(r0, r2)
            android.content.IntentFilter r1 = new android.content.IntentFilter
            java.lang.String r2 = "android.net.conn.CONNECTIVITY_CHANGE"
            r1.<init>(r2)
            g.g0 r2 = r0.L
            r0.registerReceiver(r2, r1)
            r17.I()
            r17.getIntent()
            return
        L_0x0340:
            xa.j.l(r5)
            throw r8
        L_0x0344:
            xa.j.l(r6)
            throw r8
        L_0x0348:
            xa.j.l(r6)
            throw r8
        L_0x034c:
            java.lang.String r1 = "binding"
            xa.j.l(r1)
            throw r8
        L_0x0352:
            xa.j.l(r5)
            throw r8
        L_0x0356:
            r2 = 2131362333(0x7f0a021d, float:1.8344444E38)
        L_0x0359:
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getResourceName(r2)
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "Missing required view with ID: "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L_0x036d:
            xa.j.l(r6)
            throw r8
        L_0x0371:
            xa.j.l(r6)
            throw r8
        L_0x0375:
            xa.j.l(r6)
            throw r8
        L_0x0379:
            xa.j.l(r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.main.MainActivity.onCreate(android.os.Bundle):void");
    }

    public final void onDestroy() {
        unregisterReceiver(this.L);
        super.onDestroy();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public final void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        boolean z10;
        c0 c0Var;
        c1 u10;
        List f10;
        xa.j.f("permissions", strArr);
        xa.j.f("grantResults", iArr);
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 0) {
            if (iArr.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                int length = iArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (-1 == iArr[i11]) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 == -1) {
                    c0 D = A().D(R.id.navHostFragment);
                    if (D == null || (u10 = D.u()) == null || (f10 = u10.f1373c.f()) == null) {
                        c0Var = null;
                    } else {
                        c0Var = (c0) z.v(f10, 0);
                    }
                    if (!(c0Var instanceof m6.r)) {
                        if (c0Var instanceof GamePagerFragment) {
                            GamePagerFragment gamePagerFragment = (GamePagerFragment) c0Var;
                            if (gamePagerFragment.r0() instanceof m6.r) {
                                c0Var = gamePagerFragment.r0();
                                xa.j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.download.HasDownloadDialog", c0Var);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    ((m6.r) c0Var).b();
                    return;
                }
            }
            h0.X1(this, R.string.permission_denied);
        }
    }

    public final void onResume() {
        super.onResume();
        I();
    }

    public final void onUserLeaveHint() {
        int i10;
        boolean z10;
        super.onUserLeaveHint();
        if (getPackageManager().hasSystemFeature("android.software.picture_in_picture") && (i10 = Build.VERSION.SDK_INT) < 31 && i10 >= 26) {
            SharedPreferences sharedPreferences = this.M;
            if (sharedPreferences == null) {
                xa.j.l("prefs");
                throw null;
            } else if (xa.j.a(sharedPreferences.getString("player_background_playback", "0"), "0")) {
                l lVar = this.K;
                boolean z11 = false;
                if (lVar != null) {
                    if (lVar.v0().f14607h == a0.NORMAL) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        z11 = true;
                    }
                }
                if (z11) {
                    try {
                        b.t();
                        enterPictureInPictureMode(b.i().build());
                    } catch (IllegalStateException unused) {
                    }
                }
            }
        }
    }

    public final void q() {
        E();
    }
}
