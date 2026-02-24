package t6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.woxthebox.draglistview.R;
import e4.a;
import fb.w;
import hb.h0;
import l6.n;
import xa.j;
import z5.l;

public final class d0 extends n {

    /* renamed from: w0  reason: collision with root package name */
    public static final c0 f14580w0 = new c0(0);

    /* renamed from: v0  reason: collision with root package name */
    public l f14581v0;

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        j.f("inflater", layoutInflater2);
        View inflate = layoutInflater2.inflate(R.layout.player_settings, viewGroup, false);
        int i10 = R.id.menuBookmark;
        TextView textView = (TextView) a.a(inflate, R.id.menuBookmark);
        if (textView != null) {
            i10 = R.id.menuChatBar;
            if (((TextView) a.a(inflate, R.id.menuChatBar)) != null) {
                i10 = R.id.menuChatDisconnect;
                TextView textView2 = (TextView) a.a(inflate, R.id.menuChatDisconnect);
                if (textView2 != null) {
                    i10 = R.id.menuChatToggle;
                    TextView textView3 = (TextView) a.a(inflate, R.id.menuChatToggle);
                    if (textView3 != null) {
                        i10 = R.id.menuDownload;
                        TextView textView4 = (TextView) a.a(inflate, R.id.menuDownload);
                        if (textView4 != null) {
                            i10 = R.id.menuMediaPlaylistTags;
                            TextView textView5 = (TextView) a.a(inflate, R.id.menuMediaPlaylistTags);
                            if (textView5 != null) {
                                i10 = R.id.menuMultivariantPlaylistTags;
                                TextView textView6 = (TextView) a.a(inflate, R.id.menuMultivariantPlaylistTags);
                                if (textView6 != null) {
                                    i10 = R.id.menuQuality;
                                    LinearLayout linearLayout = (LinearLayout) a.a(inflate, R.id.menuQuality);
                                    if (linearLayout != null) {
                                        i10 = R.id.menuRatio;
                                        TextView textView7 = (TextView) a.a(inflate, R.id.menuRatio);
                                        if (textView7 != null) {
                                            i10 = R.id.menuReloadEmotes;
                                            TextView textView8 = (TextView) a.a(inflate, R.id.menuReloadEmotes);
                                            if (textView8 != null) {
                                                i10 = R.id.menuRestart;
                                                TextView textView9 = (TextView) a.a(inflate, R.id.menuRestart);
                                                if (textView9 != null) {
                                                    i10 = R.id.menuSpeed;
                                                    LinearLayout linearLayout2 = (LinearLayout) a.a(inflate, R.id.menuSpeed);
                                                    if (linearLayout2 != null) {
                                                        i10 = R.id.menuSubtitles;
                                                        TextView textView10 = (TextView) a.a(inflate, R.id.menuSubtitles);
                                                        if (textView10 != null) {
                                                            i10 = R.id.menuTimer;
                                                            TextView textView11 = (TextView) a.a(inflate, R.id.menuTimer);
                                                            if (textView11 != null) {
                                                                i10 = R.id.menuViewerList;
                                                                TextView textView12 = (TextView) a.a(inflate, R.id.menuViewerList);
                                                                if (textView12 != null) {
                                                                    i10 = R.id.menuVodGames;
                                                                    TextView textView13 = (TextView) a.a(inflate, R.id.menuVodGames);
                                                                    if (textView13 != null) {
                                                                        i10 = R.id.menuVolume;
                                                                        TextView textView14 = (TextView) a.a(inflate, R.id.menuVolume);
                                                                        if (textView14 != null) {
                                                                            i10 = R.id.qualityValue;
                                                                            TextView textView15 = (TextView) a.a(inflate, R.id.qualityValue);
                                                                            if (textView15 != null) {
                                                                                i10 = R.id.speedValue;
                                                                                TextView textView16 = (TextView) a.a(inflate, R.id.speedValue);
                                                                                if (textView16 != null) {
                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) inflate;
                                                                                    this.f14581v0 = new l(nestedScrollView, textView, textView2, textView3, textView4, textView5, textView6, linearLayout, textView7, textView8, textView9, linearLayout2, textView10, textView11, textView12, textView13, textView14, textView15, textView16);
                                                                                    j.e("binding.root", nestedScrollView);
                                                                                    return nestedScrollView;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.f14581v0 = null;
    }

    /* JADX WARNING: type inference failed for: r9v12, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z(android.view.View r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r10 = "view"
            xa.j.f(r10, r9)
            android.os.Bundle r9 = r8.e0()
            z5.l r10 = r8.f14581v0
            xa.j.c(r10)
            androidx.fragment.app.c0 r0 = r8.C
            boolean r0 = r0 instanceof w6.f
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0041
            android.content.Context r0 = r8.f0()
            android.content.SharedPreferences r0 = hb.h0.l1(r0)
            java.lang.String r3 = "player_menu_speed"
            boolean r0 = r0.getBoolean(r3, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = "menuSpeed"
            android.widget.LinearLayout r3 = r10.f17706k
            xa.j.e(r0, r3)
            r3.setVisibility(r2)
            t6.b0 r0 = new t6.b0
            r0.<init>(r8, r2)
            r3.setOnClickListener(r0)
            java.lang.String r0 = "speed"
            java.lang.String r0 = r9.getString(r0)
            r8.r0(r0)
        L_0x0041:
            android.content.Context r0 = r8.f0()
            android.content.SharedPreferences r0 = hb.h0.l1(r0)
            java.lang.String r3 = "player_menu_quality"
            boolean r0 = r0.getBoolean(r3, r2)
            r3 = 0
            if (r0 == 0) goto L_0x0074
            java.lang.String r0 = "menuQuality"
            android.widget.LinearLayout r4 = r10.f17702g
            xa.j.e(r0, r4)
            r4.setVisibility(r2)
            t6.b0 r0 = new t6.b0
            r5 = 6
            r0.<init>(r8, r5)
            r4.setOnClickListener(r0)
            androidx.fragment.app.c0 r0 = r8.C
            boolean r4 = r0 instanceof t6.l
            if (r4 == 0) goto L_0x006e
            t6.l r0 = (t6.l) r0
            goto L_0x006f
        L_0x006e:
            r0 = r3
        L_0x006f:
            if (r0 == 0) goto L_0x0074
            r0.C0()
        L_0x0074:
            androidx.fragment.app.c0 r0 = r8.C
            boolean r0 = r0 instanceof w6.f
            java.lang.String r4 = "chat_disable"
            if (r0 == 0) goto L_0x01f4
            android.content.Context r0 = r8.f0()
            android.content.SharedPreferences r0 = hb.h0.l1(r0)
            java.lang.String r5 = "player_menu_viewer_list"
            boolean r0 = r0.getBoolean(r5, r1)
            if (r0 == 0) goto L_0x009f
            java.lang.String r0 = "menuViewerList"
            android.widget.TextView r5 = r10.f17709n
            xa.j.e(r0, r5)
            r5.setVisibility(r2)
            t6.b0 r0 = new t6.b0
            r6 = 7
            r0.<init>(r8, r6)
            r5.setOnClickListener(r0)
        L_0x009f:
            android.content.Context r0 = r8.f0()
            android.content.SharedPreferences r0 = hb.h0.l1(r0)
            java.lang.String r5 = "player_menu_restart"
            boolean r0 = r0.getBoolean(r5, r2)
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = "menuRestart"
            android.widget.TextView r5 = r10.f17705j
            xa.j.e(r0, r5)
            r5.setVisibility(r2)
            t6.b0 r0 = new t6.b0
            r6 = 8
            r0.<init>(r8, r6)
            r5.setOnClickListener(r0)
        L_0x00c3:
            android.content.Context r0 = r8.f0()
            android.content.SharedPreferences r0 = hb.h0.l1(r0)
            boolean r0 = r0.getBoolean(r4, r2)
            if (r0 != 0) goto L_0x01bc
            androidx.fragment.app.c0 r0 = r8.C
            boolean r5 = r0 instanceof t6.l
            if (r5 == 0) goto L_0x00da
            t6.l r0 = (t6.l) r0
            goto L_0x00db
        L_0x00da:
            r0 = r3
        L_0x00db:
            if (r0 == 0) goto L_0x00e3
            boolean r0 = r0.f14628o0
            if (r0 != 0) goto L_0x00e3
            r0 = 1
            goto L_0x00e4
        L_0x00e3:
            r0 = 0
        L_0x00e4:
            if (r0 == 0) goto L_0x013e
            android.content.Context r0 = r8.f0()
            android.content.SharedPreferences r0 = hb.h0.l1(r0)
            java.lang.String r5 = "player_menu_chat_toggle"
            boolean r0 = r0.getBoolean(r5, r2)
            if (r0 == 0) goto L_0x013e
            java.lang.String r0 = "menuChatToggle"
            android.widget.TextView r5 = r10.f17698c
            xa.j.e(r0, r5)
            r5.setVisibility(r2)
            android.content.Context r0 = r8.f0()
            android.content.SharedPreferences r0 = hb.h0.l1(r0)
            java.lang.String r6 = "key_chat_opened"
            boolean r0 = r0.getBoolean(r6, r1)
            if (r0 == 0) goto L_0x0126
            android.content.Context r0 = r8.f0()
            r6 = 2131951872(0x7f130100, float:1.954017E38)
            java.lang.String r0 = r0.getString(r6)
            r5.setText(r0)
            t6.b0 r0 = new t6.b0
            r6 = 9
            r0.<init>(r8, r6)
            goto L_0x013b
        L_0x0126:
            android.content.Context r0 = r8.f0()
            r6 = 2131952306(0x7f1302b2, float:1.9541051E38)
            java.lang.String r0 = r0.getString(r6)
            r5.setText(r0)
            t6.b0 r0 = new t6.b0
            r6 = 10
            r0.<init>(r8, r6)
        L_0x013b:
            r5.setOnClickListener(r0)
        L_0x013e:
            android.content.Context r0 = r8.f0()
            android.content.SharedPreferences r0 = hb.h0.l1(r0)
            java.lang.String r5 = "player_menu_chat_disconnect"
            boolean r0 = r0.getBoolean(r5, r1)
            if (r0 == 0) goto L_0x01bc
            java.lang.String r0 = "menuChatDisconnect"
            android.widget.TextView r5 = r10.f17697b
            xa.j.e(r0, r5)
            r5.setVisibility(r2)
            androidx.fragment.app.c0 r0 = r8.C
            boolean r6 = r0 instanceof w6.f
            if (r6 == 0) goto L_0x0161
            w6.f r0 = (w6.f) r0
            goto L_0x0162
        L_0x0161:
            r0 = r3
        L_0x0162:
            if (r0 == 0) goto L_0x018b
            i6.e r0 = r0.P0()
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r0 = r0.q0()
            i6.h r0 = r0.f3368y
            boolean r6 = r0 instanceof i6.m
            if (r6 == 0) goto L_0x0175
            i6.m r0 = (i6.m) r0
            goto L_0x0176
        L_0x0175:
            r0 = r3
        L_0x0176:
            if (r0 == 0) goto L_0x0183
            t7.k r0 = r0.f8326f
            if (r0 == 0) goto L_0x0183
            boolean r0 = r0.f14709h
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0184
        L_0x0183:
            r0 = r3
        L_0x0184:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            boolean r0 = xa.j.a(r0, r6)
            goto L_0x018c
        L_0x018b:
            r0 = 0
        L_0x018c:
            if (r0 == 0) goto L_0x01a4
            android.content.Context r0 = r8.f0()
            r6 = 2131951731(0x7f130073, float:1.9539885E38)
            java.lang.String r0 = r0.getString(r6)
            r5.setText(r0)
            t6.b0 r0 = new t6.b0
            r6 = 11
            r0.<init>(r8, r6)
            goto L_0x01b9
        L_0x01a4:
            android.content.Context r0 = r8.f0()
            r6 = 2131951754(0x7f13008a, float:1.9539931E38)
            java.lang.String r0 = r0.getString(r6)
            r5.setText(r0)
            t6.b0 r0 = new t6.b0
            r6 = 12
            r0.<init>(r8, r6)
        L_0x01b9:
            r5.setOnClickListener(r0)
        L_0x01bc:
            android.content.Context r0 = r8.f0()
            android.content.SharedPreferences r0 = hb.h0.l1(r0)
            java.lang.String r5 = "debug_player_menu_playlist_tags"
            boolean r0 = r0.getBoolean(r5, r2)
            if (r0 == 0) goto L_0x01f4
            java.lang.String r0 = "menuMediaPlaylistTags"
            android.widget.TextView r5 = r10.f17700e
            xa.j.e(r0, r5)
            r5.setVisibility(r2)
            t6.b0 r0 = new t6.b0
            r6 = 13
            r0.<init>(r8, r6)
            r5.setOnClickListener(r0)
            java.lang.String r0 = "menuMultivariantPlaylistTags"
            android.widget.TextView r5 = r10.f17701f
            xa.j.e(r0, r5)
            r5.setVisibility(r2)
            t6.b0 r0 = new t6.b0
            r6 = 14
            r0.<init>(r8, r6)
            r5.setOnClickListener(r0)
        L_0x01f4:
            androidx.fragment.app.c0 r0 = r8.C
            boolean r0 = r0 instanceof x6.h
            r5 = 3
            if (r0 == 0) goto L_0x0243
            java.lang.String r0 = "vod_games"
            boolean r9 = r9.getBoolean(r0)
            if (r9 == 0) goto L_0x0206
            r8.s0()
        L_0x0206:
            android.content.Context r9 = r8.f0()
            android.content.SharedPreferences r9 = hb.h0.l1(r9)
            java.lang.String r0 = "player_menu_bookmark"
            boolean r9 = r9.getBoolean(r0, r1)
            if (r9 == 0) goto L_0x0243
            androidx.fragment.app.c0 r9 = r8.C
            boolean r0 = r9 instanceof x6.h
            if (r0 == 0) goto L_0x021f
            x6.h r9 = (x6.h) r9
            goto L_0x0220
        L_0x021f:
            r9 = r3
        L_0x0220:
            if (r9 == 0) goto L_0x0243
            com.github.andreyasadchy.xtra.model.ui.Video r0 = r9.F0
            if (r0 == 0) goto L_0x023d
            java.lang.String r0 = r0.getUuid()
            if (r0 == 0) goto L_0x0243
            com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel r9 = r9.v0()
            hb.f0 r6 = hb.h0.I0(r9)
            x6.j r7 = new x6.j
            r7.<init>(r9, r0, r3)
            hb.h0.b1(r6, r3, r2, r7, r5)
            goto L_0x0243
        L_0x023d:
            java.lang.String r9 = "video"
            xa.j.l(r9)
            throw r3
        L_0x0243:
            androidx.fragment.app.c0 r9 = r8.C
            boolean r9 = r9 instanceof m6.r
            if (r9 == 0) goto L_0x026b
            android.content.Context r9 = r8.f0()
            android.content.SharedPreferences r9 = hb.h0.l1(r9)
            java.lang.String r0 = "player_menu_download"
            boolean r9 = r9.getBoolean(r0, r1)
            if (r9 == 0) goto L_0x026b
            java.lang.String r9 = "menuDownload"
            android.widget.TextView r0 = r10.f17699d
            xa.j.e(r9, r0)
            r0.setVisibility(r2)
            t6.b0 r9 = new t6.b0
            r9.<init>(r8, r1)
            r0.setOnClickListener(r9)
        L_0x026b:
            androidx.fragment.app.c0 r9 = r8.C
            boolean r9 = r9 instanceof u6.d
            if (r9 != 0) goto L_0x0294
            android.content.Context r9 = r8.f0()
            android.content.SharedPreferences r9 = hb.h0.l1(r9)
            java.lang.String r0 = "player_menu_sleep"
            boolean r9 = r9.getBoolean(r0, r1)
            if (r9 == 0) goto L_0x0294
            java.lang.String r9 = "menuTimer"
            android.widget.TextView r0 = r10.f17708m
            xa.j.e(r9, r0)
            r0.setVisibility(r2)
            t6.b0 r9 = new t6.b0
            r6 = 2
            r9.<init>(r8, r6)
            r0.setOnClickListener(r9)
        L_0x0294:
            androidx.fragment.app.c0 r9 = r8.C
            boolean r0 = r9 instanceof t6.l
            if (r0 == 0) goto L_0x029d
            t6.l r9 = (t6.l) r9
            goto L_0x029e
        L_0x029d:
            r9 = r3
        L_0x029e:
            if (r9 == 0) goto L_0x02a6
            boolean r9 = r9.f14628o0
            if (r9 != 0) goto L_0x02a6
            r9 = 1
            goto L_0x02a7
        L_0x02a6:
            r9 = 0
        L_0x02a7:
            if (r9 == 0) goto L_0x02cb
            android.content.Context r9 = r8.f0()
            android.content.SharedPreferences r9 = hb.h0.l1(r9)
            java.lang.String r0 = "player_menu_aspect"
            boolean r9 = r9.getBoolean(r0, r2)
            if (r9 == 0) goto L_0x02cb
            java.lang.String r9 = "menuRatio"
            android.widget.TextView r0 = r10.f17703h
            xa.j.e(r9, r0)
            r0.setVisibility(r2)
            t6.b0 r9 = new t6.b0
            r9.<init>(r8, r5)
            r0.setOnClickListener(r9)
        L_0x02cb:
            android.content.Context r9 = r8.f0()
            android.content.SharedPreferences r9 = hb.h0.l1(r9)
            java.lang.String r0 = "player_menu_volume"
            boolean r9 = r9.getBoolean(r0, r2)
            if (r9 == 0) goto L_0x02ee
            java.lang.String r9 = "menuVolume"
            android.widget.TextView r0 = r10.f17711p
            xa.j.e(r9, r0)
            r0.setVisibility(r2)
            t6.b0 r9 = new t6.b0
            r6 = 4
            r9.<init>(r8, r6)
            r0.setOnClickListener(r9)
        L_0x02ee:
            androidx.fragment.app.c0 r9 = r8.C
            boolean r0 = r9 instanceof t6.l
            if (r0 == 0) goto L_0x02f7
            r3 = r9
            t6.l r3 = (t6.l) r3
        L_0x02f7:
            if (r3 == 0) goto L_0x02fc
            t6.l.E0(r3, r2, r2, r5)
        L_0x02fc:
            androidx.fragment.app.c0 r9 = r8.C
            boolean r0 = r9 instanceof w6.f
            if (r0 != 0) goto L_0x0306
            boolean r9 = r9 instanceof x6.h
            if (r9 == 0) goto L_0x0337
        L_0x0306:
            android.content.Context r9 = r8.f0()
            android.content.SharedPreferences r9 = hb.h0.l1(r9)
            boolean r9 = r9.getBoolean(r4, r2)
            if (r9 != 0) goto L_0x0337
            android.content.Context r9 = r8.f0()
            android.content.SharedPreferences r9 = hb.h0.l1(r9)
            java.lang.String r0 = "player_menu_reload_emotes"
            boolean r9 = r9.getBoolean(r0, r1)
            if (r9 == 0) goto L_0x0337
            java.lang.String r9 = "menuReloadEmotes"
            android.widget.TextView r10 = r10.f17704i
            xa.j.e(r9, r10)
            r10.setVisibility(r2)
            t6.b0 r9 = new t6.b0
            r0 = 5
            r9.<init>(r8, r0)
            r10.setOnClickListener(r9)
        L_0x0337:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.d0.Z(android.view.View, android.os.Bundle):void");
    }

    public final void r0(String str) {
        boolean z10;
        l lVar = this.f14581v0;
        j.c(lVar);
        boolean z11 = false;
        if (str == null || w.h(str)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            LinearLayout linearLayout = lVar.f17706k;
            j.e("menuSpeed", linearLayout);
            if (linearLayout.getVisibility() == 0) {
                z11 = true;
            }
            if (z11) {
                TextView textView = lVar.f17713r;
                j.e("speedValue", textView);
                h0.b2(textView);
                textView.setText(str);
            }
        }
    }

    public final void s0() {
        l lVar = this.f14581v0;
        j.c(lVar);
        if (h0.l1(f0()).getBoolean("player_menu_games", false)) {
            TextView textView = lVar.f17710o;
            j.e("menuVodGames", textView);
            h0.b2(textView);
            textView.setOnClickListener(new b0(this, 15));
        }
    }
}
