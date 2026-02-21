package com.github.andreyasadchy.xtra.ui.settings;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.session.u;
import androidx.activity.h;
import androidx.fragment.app.f0;
import androidx.lifecycle.x1;
import androidx.preference.ListPreference;
import androidx.preference.SwitchPreferenceCompat;
import com.woxthebox.draglistview.R;
import g7.g;
import h6.l;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import la.f;
import o3.d0;
import o3.z;
import xa.j;
import xa.v;

public final class SettingsActivity extends h7.a {
    public static final /* synthetic */ int J = 0;
    public boolean H;
    public u I;

    public static final class a extends z {
        public final void m0(String str) {
            n0(R.xml.buffer_preferences, str);
        }
    }

    public static final class b extends z {
        public final void m0(String str) {
            SwitchPreferenceCompat switchPreferenceCompat;
            n0(R.xml.player_button_preferences, str);
            if (Build.VERSION.SDK_INT < 28 && (switchPreferenceCompat = (SwitchPreferenceCompat) l0("player_audio_compressor_button")) != null && switchPreferenceCompat.D) {
                switchPreferenceCompat.D = false;
                d0 d0Var = switchPreferenceCompat.N;
                if (d0Var != null) {
                    Handler handler = d0Var.f12116e;
                    h hVar = d0Var.f12117f;
                    handler.removeCallbacks(hVar);
                    handler.post(hVar);
                }
            }
        }
    }

    public static final class c extends z {
        public final void m0(String str) {
            n0(R.xml.player_menu_preferences, str);
        }
    }

    public static final class d extends a {

        /* renamed from: s0  reason: collision with root package name */
        public static final /* synthetic */ int f3494s0 = 0;

        /* renamed from: q0  reason: collision with root package name */
        public final x1 f3495q0;

        /* renamed from: r0  reason: collision with root package name */
        public boolean f3496r0;

        static {
            new b(0);
        }

        public d() {
            la.e a10 = f.a(new l(new g(1, this), 22));
            this.f3495q0 = h0.K(this, v.a(SettingsViewModel.class), new m(a10, 22), new n(a10, 22), new o(this, a10, 22));
        }

        public final void N(Bundle bundle) {
            super.N(bundle);
            boolean z10 = false;
            if (bundle != null && bundle.getBoolean("changed")) {
                z10 = true;
            }
            this.f3496r0 = z10;
            if (z10) {
                d0().setResult(-1);
            }
        }

        public final void W(Bundle bundle) {
            bundle.putBoolean("changed", this.f3496r0);
            super.W(bundle);
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0038 */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x004f A[Catch:{ Exception -> 0x0064 }] */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0052 A[Catch:{ Exception -> 0x0064 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m0(java.lang.String r8) {
            /*
                r7 = this;
                r0 = 2132148231(0x7f160007, float:1.9938434E38)
                r7.n0(r0, r8)
                androidx.fragment.app.f0 r8 = r7.d0()
                h7.b r0 = new h7.b
                r1 = 0
                r0.<init>(r7, r1)
                java.lang.String r2 = "ui_language"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.ListPreference r2 = (androidx.preference.ListPreference) r2
                if (r2 == 0) goto L_0x0076
                i0.i r3 = g.t.f()
                java.lang.String r4 = "getApplicationLocales()"
                xa.j.e(r4, r3)
                boolean r4 = r3.d()
                if (r4 == 0) goto L_0x002c
                java.lang.String r3 = "auto"
                goto L_0x0066
            L_0x002c:
                java.lang.String r4 = r3.e()     // Catch:{ Exception -> 0x0038 }
                int r4 = r2.y(r4)     // Catch:{ Exception -> 0x0038 }
                r2.C(r4)     // Catch:{ Exception -> 0x0038 }
                goto L_0x006d
            L_0x0038:
                java.lang.String r3 = r3.e()     // Catch:{ Exception -> 0x0064 }
                java.lang.String r4 = "lang.toLanguageTags()"
                xa.j.e(r4, r3)     // Catch:{ Exception -> 0x0064 }
                java.lang.String r4 = "-"
                java.lang.String r3 = fb.y.M(r3, r4, r3)     // Catch:{ Exception -> 0x0064 }
                java.lang.String r4 = "id"
                boolean r4 = xa.j.a(r3, r4)     // Catch:{ Exception -> 0x0064 }
                if (r4 == 0) goto L_0x0052
                java.lang.String r3 = "in"
                goto L_0x005c
            L_0x0052:
                java.lang.String r4 = "pt"
                boolean r4 = xa.j.a(r3, r4)     // Catch:{ Exception -> 0x0064 }
                if (r4 == 0) goto L_0x005c
                java.lang.String r3 = "pt-BR"
            L_0x005c:
                int r3 = r2.y(r3)     // Catch:{ Exception -> 0x0064 }
                r2.C(r3)     // Catch:{ Exception -> 0x0064 }
                goto L_0x006d
            L_0x0064:
                java.lang.String r3 = "en"
            L_0x0066:
                int r3 = r2.y(r3)
                r2.C(r3)
            L_0x006d:
                h3.j3 r3 = new h3.j3
                r4 = 19
                r3.<init>(r4)
                r2.f1891l = r3
            L_0x0076:
                java.lang.String r2 = "ui_cutoutmode"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.ListPreference r2 = (androidx.preference.ListPreference) r2
                r3 = 5
                if (r2 == 0) goto L_0x00a3
                int r4 = android.os.Build.VERSION.SDK_INT
                r5 = 28
                if (r4 < r5) goto L_0x008f
                h3.d3 r4 = new h3.d3
                r4.<init>(r7, r3, r8)
                r2.f1891l = r4
                goto L_0x00a3
            L_0x008f:
                boolean r4 = r2.D
                if (r4 == 0) goto L_0x00a3
                r2.D = r1
                o3.d0 r2 = r2.N
                if (r2 == 0) goto L_0x00a3
                android.os.Handler r4 = r2.f12116e
                androidx.activity.h r2 = r2.f12117f
                r4.removeCallbacks(r2)
                r4.post(r2)
            L_0x00a3:
                java.lang.String r2 = "theme_settings"
                androidx.preference.Preference r2 = r7.l0(r2)
                r4 = 1
                if (r2 == 0) goto L_0x00b3
                h7.b r5 = new h7.b
                r5.<init>(r7, r4)
                r2.f1892m = r5
            L_0x00b3:
                java.lang.String r2 = "ui_rounduserimage"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.SwitchPreferenceCompat r2 = (androidx.preference.SwitchPreferenceCompat) r2
                if (r2 != 0) goto L_0x00be
                goto L_0x00c0
            L_0x00be:
                r2.f1891l = r0
            L_0x00c0:
                java.lang.String r2 = "ui_truncateviewcount"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.SwitchPreferenceCompat r2 = (androidx.preference.SwitchPreferenceCompat) r2
                if (r2 != 0) goto L_0x00cb
                goto L_0x00cd
            L_0x00cb:
                r2.f1891l = r0
            L_0x00cd:
                java.lang.String r2 = "ui_uptime"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.SwitchPreferenceCompat r2 = (androidx.preference.SwitchPreferenceCompat) r2
                if (r2 != 0) goto L_0x00d8
                goto L_0x00da
            L_0x00d8:
                r2.f1891l = r0
            L_0x00da:
                java.lang.String r2 = "ui_tags"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.SwitchPreferenceCompat r2 = (androidx.preference.SwitchPreferenceCompat) r2
                if (r2 != 0) goto L_0x00e5
                goto L_0x00e7
            L_0x00e5:
                r2.f1891l = r0
            L_0x00e7:
                java.lang.String r2 = "ui_broadcasterscount"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.SwitchPreferenceCompat r2 = (androidx.preference.SwitchPreferenceCompat) r2
                if (r2 != 0) goto L_0x00f2
                goto L_0x00f4
            L_0x00f2:
                r2.f1891l = r0
            L_0x00f4:
                java.lang.String r2 = "ui_bookmark_time_left"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.SwitchPreferenceCompat r2 = (androidx.preference.SwitchPreferenceCompat) r2
                if (r2 != 0) goto L_0x00ff
                goto L_0x0101
            L_0x00ff:
                r2.f1891l = r0
            L_0x0101:
                java.lang.String r2 = "ui_scrolltop"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.SwitchPreferenceCompat r2 = (androidx.preference.SwitchPreferenceCompat) r2
                if (r2 != 0) goto L_0x010c
                goto L_0x010e
            L_0x010c:
                r2.f1891l = r0
            L_0x010e:
                java.lang.String r2 = "columnsPortrait"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.ListPreference r2 = (androidx.preference.ListPreference) r2
                if (r2 != 0) goto L_0x0119
                goto L_0x011b
            L_0x0119:
                r2.f1891l = r0
            L_0x011b:
                java.lang.String r2 = "columnsLandscape"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.ListPreference r2 = (androidx.preference.ListPreference) r2
                if (r2 != 0) goto L_0x0126
                goto L_0x0128
            L_0x0126:
                r2.f1891l = r0
            L_0x0128:
                java.lang.String r2 = "compactStreamsV2"
                androidx.preference.Preference r2 = r7.l0(r2)
                androidx.preference.ListPreference r2 = (androidx.preference.ListPreference) r2
                if (r2 != 0) goto L_0x0133
                goto L_0x0135
            L_0x0133:
                r2.f1891l = r0
            L_0x0135:
                java.lang.String r0 = "chatWidth"
                androidx.preference.Preference r0 = r7.l0(r0)
                androidx.preference.SeekBarPreference r0 = (androidx.preference.SeekBarPreference) r0
                if (r0 == 0) goto L_0x0168
                java.lang.Object[] r2 = new java.lang.Object[r4]
                android.content.SharedPreferences r4 = hb.h0.l1(r8)
                java.lang.String r5 = "landscape_chat_width"
                r6 = 30
                int r4 = r4.getInt(r5, r6)
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r2[r1] = r4
                android.content.Context r1 = r0.f1887h
                r4 = 2131952209(0x7f130251, float:1.9540854E38)
                java.lang.String r1 = r1.getString(r4, r2)
                r0.v(r1)
                h3.f0 r1 = new h3.f0
                r2 = 15
                r1.<init>(r7, r8, r0, r2)
                r0.f1891l = r1
            L_0x0168:
                java.lang.String r0 = "player_button_settings"
                androidx.preference.Preference r0 = r7.l0(r0)
                if (r0 == 0) goto L_0x0178
                h7.b r1 = new h7.b
                r2 = 2
                r1.<init>(r7, r2)
                r0.f1892m = r1
            L_0x0178:
                java.lang.String r0 = "player_menu_settings"
                androidx.preference.Preference r0 = r7.l0(r0)
                if (r0 == 0) goto L_0x0188
                h7.b r1 = new h7.b
                r2 = 3
                r1.<init>(r7, r2)
                r0.f1892m = r1
            L_0x0188:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 26
                if (r0 < r1) goto L_0x019a
                android.content.pm.PackageManager r8 = r8.getPackageManager()
                java.lang.String r0 = "android.software.picture_in_picture"
                boolean r8 = r8.hasSystemFeature(r0)
                if (r8 != 0) goto L_0x01c1
            L_0x019a:
                java.lang.String r8 = "player_background_playback"
                androidx.preference.Preference r8 = r7.l0(r8)
                androidx.preference.ListPreference r8 = (androidx.preference.ListPreference) r8
                if (r8 == 0) goto L_0x01c1
                android.content.Context r0 = r8.f1887h
                android.content.res.Resources r1 = r0.getResources()
                r2 = 2130903041(0x7f030001, float:1.7412889E38)
                java.lang.CharSequence[] r1 = r1.getTextArray(r2)
                r8.A(r1)
                android.content.res.Resources r0 = r0.getResources()
                r1 = 2130903042(0x7f030002, float:1.741289E38)
                java.lang.CharSequence[] r0 = r0.getTextArray(r1)
                r8.f1880b0 = r0
            L_0x01c1:
                java.lang.String r8 = "buffer_settings"
                androidx.preference.Preference r8 = r7.l0(r8)
                if (r8 == 0) goto L_0x01d1
                h7.b r0 = new h7.b
                r1 = 4
                r0.<init>(r7, r1)
                r8.f1892m = r0
            L_0x01d1:
                java.lang.String r8 = "clear_video_positions"
                androidx.preference.Preference r8 = r7.l0(r8)
                if (r8 == 0) goto L_0x01e0
                h7.b r0 = new h7.b
                r0.<init>(r7, r3)
                r8.f1892m = r0
            L_0x01e0:
                java.lang.String r8 = "admin_settings"
                androidx.preference.Preference r8 = r7.l0(r8)
                if (r8 == 0) goto L_0x01f0
                h7.b r0 = new h7.b
                r1 = 6
                r0.<init>(r7, r1)
                r8.f1892m = r0
            L_0x01f0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.settings.SettingsActivity.d.m0(java.lang.String):void");
        }
    }

    public static final class e extends z {

        /* renamed from: m0  reason: collision with root package name */
        public static final /* synthetic */ int f3497m0 = 0;

        /* renamed from: l0  reason: collision with root package name */
        public boolean f3498l0;

        public final void N(Bundle bundle) {
            super.N(bundle);
            boolean z10 = false;
            if (bundle != null && bundle.getBoolean("changed")) {
                z10 = true;
            }
            this.f3498l0 = z10;
            if (z10) {
                d0().setResult(-1);
            }
        }

        public final void W(Bundle bundle) {
            bundle.putBoolean("changed", this.f3498l0);
            super.W(bundle);
        }

        public final void m0(String str) {
            n0(R.xml.theme_preferences, str);
            f0 d02 = d0();
            ListPreference listPreference = (ListPreference) l0("theme");
            if (listPreference != null) {
                listPreference.f1891l = new h7.c(this, d02, 0);
            }
            SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) l0("ui_theme_follow_system");
            if (switchPreferenceCompat != null) {
                switchPreferenceCompat.f1891l = new h7.c(this, d02, 1);
            }
            ListPreference listPreference2 = (ListPreference) l0("ui_theme_dark_on");
            if (listPreference2 != null) {
                listPreference2.f1891l = new h7.c(this, d02, 2);
            }
            ListPreference listPreference3 = (ListPreference) l0("ui_theme_dark_off");
            if (listPreference3 != null) {
                listPreference3.f1891l = new h7.c(this, d02, 3);
            }
            SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) l0("ui_statusbar");
            if (switchPreferenceCompat2 != null) {
                switchPreferenceCompat2.f1891l = new h7.c(this, d02, 4);
            }
            SwitchPreferenceCompat switchPreferenceCompat3 = (SwitchPreferenceCompat) l0("ui_navbar");
            if (switchPreferenceCompat3 != null) {
                switchPreferenceCompat3.f1891l = new h7.c(this, d02, 5);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0067, code lost:
        if (r12.getBoolean("changed") == true) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            super.onCreate(r12)
            hb.h0.g(r11)
            android.view.LayoutInflater r0 = r11.getLayoutInflater()
            r1 = 2131558430(0x7f0d001e, float:1.8742176E38)
            r2 = 0
            r3 = 0
            android.view.View r0 = r0.inflate(r1, r2, r3)
            r1 = 2131362438(0x7f0a0286, float:1.8344657E38)
            android.view.View r4 = e4.a.a(r0, r1)
            r7 = r4
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            if (r7 == 0) goto L_0x0094
            r4 = 2131362554(0x7f0a02fa, float:1.8344892E38)
            android.view.View r5 = e4.a.a(r0, r4)
            r8 = r5
            androidx.appcompat.widget.Toolbar r8 = (androidx.appcompat.widget.Toolbar) r8
            if (r8 == 0) goto L_0x0091
            android.support.v4.media.session.u r4 = new android.support.v4.media.session.u
            r6 = r0
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r9 = 26
            r10 = 0
            r5 = r4
            r5.<init>((java.lang.Object) r6, (java.lang.Object) r7, (java.lang.Object) r8, (int) r9, (int) r10)
            r11.I = r4
            android.widget.LinearLayout r0 = r4.y()
            r11.setContentView((android.view.View) r0)
            android.support.v4.media.session.u r0 = r11.I
            if (r0 == 0) goto L_0x008b
            java.lang.Object r0 = r0.f430k
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            g6.a r4 = g6.a.f6840a
            r4.getClass()
            android.graphics.drawable.Drawable r4 = g6.a.a(r11)
            r0.setNavigationIcon((android.graphics.drawable.Drawable) r4)
            i3.i r4 = new i3.i
            r5 = 16
            r4.<init>(r5, r11)
            r0.setNavigationOnClickListener(r4)
            if (r12 == 0) goto L_0x006a
            java.lang.String r0 = "changed"
            boolean r0 = r12.getBoolean(r0)
            r4 = 1
            if (r0 != r4) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r4 = 0
        L_0x006b:
            r11.H = r4
            if (r12 == 0) goto L_0x0071
            if (r4 == 0) goto L_0x008a
        L_0x0071:
            r11.H = r3
            androidx.fragment.app.d1 r12 = r11.A()
            r12.getClass()
            androidx.fragment.app.a r0 = new androidx.fragment.app.a
            r0.<init>((androidx.fragment.app.c1) r12)
            com.github.andreyasadchy.xtra.ui.settings.SettingsActivity$d r12 = new com.github.andreyasadchy.xtra.ui.settings.SettingsActivity$d
            r12.<init>()
            r0.e(r1, r12, r2)
            r0.g()
        L_0x008a:
            return
        L_0x008b:
            java.lang.String r12 = "binding"
            xa.j.l(r12)
            throw r2
        L_0x0091:
            r1 = 2131362554(0x7f0a02fa, float:1.8344892E38)
        L_0x0094:
            android.content.res.Resources r12 = r0.getResources()
            java.lang.String r12 = r12.getResourceName(r1)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.settings.SettingsActivity.onCreate(android.os.Bundle):void");
    }

    public final void onSaveInstanceState(Bundle bundle) {
        j.f("outState", bundle);
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("changed", this.H);
    }
}
