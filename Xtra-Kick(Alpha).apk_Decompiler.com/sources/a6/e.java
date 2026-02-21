package a6;

import android.database.Cursor;
import com.github.andreyasadchy.xtra.model.VideoPosition;
import com.github.andreyasadchy.xtra.model.chat.RecentEmote;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.model.offline.Request;
import com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser;
import hb.h0;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import r3.s0;

public final class e implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f228a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s0 f229b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f230c;

    public /* synthetic */ e(Object obj, s0 s0Var, int i10) {
        this.f228a = i10;
        this.f230c = obj;
        this.f229b = s0Var;
    }

    public final ArrayList a() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i10;
        String str9;
        int i11;
        int i12;
        String str10;
        String str11;
        String str12;
        String str13;
        int i13;
        String str14;
        int i14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        Integer num;
        Integer num2;
        String str21;
        String str22;
        Long l10;
        String str23;
        String str24;
        int i15;
        int i16;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        int i17;
        Long l11;
        int i18;
        Long l12;
        int i19;
        Long l13;
        int i20;
        Long l14;
        int i21;
        String str31;
        int i22;
        String str32;
        int i23;
        boolean z10;
        int i24 = this.f228a;
        s0 s0Var = this.f229b;
        Object obj = this.f230c;
        switch (i24) {
            case 0:
                Cursor n12 = h0.n1(((f) obj).f234a, s0Var);
                try {
                    int c02 = h0.c0(n12, "videoId");
                    int c03 = h0.c0(n12, "userId");
                    int c04 = h0.c0(n12, "userLogin");
                    int c05 = h0.c0(n12, "userName");
                    int c06 = h0.c0(n12, "userType");
                    int c07 = h0.c0(n12, "userBroadcasterType");
                    int c08 = h0.c0(n12, "userLogo");
                    int c09 = h0.c0(n12, "gameId");
                    int c010 = h0.c0(n12, "gameName");
                    int c011 = h0.c0(n12, "gameSlug");
                    int c012 = h0.c0(n12, "boxArtUrl");
                    int c013 = h0.c0(n12, "title");
                    int c014 = h0.c0(n12, "createdAt");
                    int c015 = h0.c0(n12, "thumbnail");
                    int c016 = h0.c0(n12, "type");
                    int c017 = h0.c0(n12, "duration");
                    int c018 = h0.c0(n12, "animatedPreviewURL");
                    int c019 = h0.c0(n12, "id");
                    int i25 = c018;
                    ArrayList arrayList = new ArrayList(n12.getCount());
                    while (n12.moveToNext()) {
                        if (n12.isNull(c02)) {
                            str = null;
                        } else {
                            str = n12.getString(c02);
                        }
                        int i26 = n12.getInt(c03);
                        if (n12.isNull(c04)) {
                            str2 = null;
                        } else {
                            str2 = n12.getString(c04);
                        }
                        if (n12.isNull(c05)) {
                            str3 = null;
                        } else {
                            str3 = n12.getString(c05);
                        }
                        if (n12.isNull(c06)) {
                            str4 = null;
                        } else {
                            str4 = n12.getString(c06);
                        }
                        if (n12.isNull(c07)) {
                            str5 = null;
                        } else {
                            str5 = n12.getString(c07);
                        }
                        if (n12.isNull(c08)) {
                            str6 = null;
                        } else {
                            str6 = n12.getString(c08);
                        }
                        int i27 = n12.getInt(c09);
                        if (n12.isNull(c010)) {
                            str7 = null;
                        } else {
                            str7 = n12.getString(c010);
                        }
                        if (n12.isNull(c011)) {
                            i10 = c012;
                            str8 = null;
                        } else {
                            str8 = n12.getString(c011);
                            i10 = c012;
                        }
                        if (n12.isNull(i10)) {
                            i11 = c02;
                            i12 = c013;
                            str9 = null;
                        } else {
                            str9 = n12.getString(i10);
                            i11 = c02;
                            i12 = c013;
                        }
                        if (n12.isNull(i12)) {
                            str10 = null;
                        } else {
                            str10 = n12.getString(i12);
                        }
                        if (n12.isNull(c014)) {
                            str11 = null;
                        } else {
                            str11 = n12.getString(c014);
                        }
                        if (n12.isNull(c015)) {
                            str12 = null;
                        } else {
                            str12 = n12.getString(c015);
                        }
                        if (n12.isNull(c016)) {
                            c013 = i12;
                            i13 = c017;
                            str13 = null;
                        } else {
                            str13 = n12.getString(c016);
                            c013 = i12;
                            i13 = c017;
                        }
                        if (n12.isNull(i13)) {
                            c017 = i13;
                            i14 = i25;
                            str14 = null;
                        } else {
                            str14 = n12.getString(i13);
                            c017 = i13;
                            i14 = i25;
                        }
                        if (n12.isNull(i14)) {
                            i25 = i14;
                            str15 = null;
                        } else {
                            str15 = n12.getString(i14);
                            i25 = i14;
                        }
                        Bookmark bookmark = new Bookmark(str, i26, str2, str3, str4, str5, str6, i27, str7, str8, str9, str10, str11, str12, str13, str14, str15);
                        int i28 = c03;
                        int i29 = c019;
                        int i30 = c04;
                        bookmark.setId(n12.getInt(i29));
                        arrayList.add(bookmark);
                        c02 = i11;
                        c04 = i30;
                        c019 = i29;
                        c012 = i10;
                        c03 = i28;
                    }
                    return arrayList;
                } finally {
                    n12.close();
                }
            case 1:
                Cursor n13 = h0.n1(((o) obj).f250a, s0Var);
                try {
                    int c020 = h0.c0(n13, "name");
                    int c021 = h0.c0(n13, "used_at");
                    ArrayList arrayList2 = new ArrayList(n13.getCount());
                    while (n13.moveToNext()) {
                        if (n13.isNull(c020)) {
                            str16 = null;
                        } else {
                            str16 = n13.getString(c020);
                        }
                        arrayList2.add(new RecentEmote(str16, n13.getLong(c021)));
                    }
                    return arrayList2;
                } finally {
                    n13.close();
                }
            case 2:
                Cursor n14 = h0.n1(((s) obj).f258a, s0Var);
                try {
                    int c022 = h0.c0(n14, "offline_video_id");
                    int c023 = h0.c0(n14, "url");
                    int c024 = h0.c0(n14, "path");
                    int c025 = h0.c0(n14, "video_id");
                    int c026 = h0.c0(n14, "video_type");
                    int c027 = h0.c0(n14, "segment_from");
                    int c028 = h0.c0(n14, "segment_to");
                    ArrayList arrayList3 = new ArrayList(n14.getCount());
                    while (n14.moveToNext()) {
                        int i31 = n14.getInt(c022);
                        if (n14.isNull(c023)) {
                            str17 = null;
                        } else {
                            str17 = n14.getString(c023);
                        }
                        if (n14.isNull(c024)) {
                            str18 = null;
                        } else {
                            str18 = n14.getString(c024);
                        }
                        if (n14.isNull(c025)) {
                            str19 = null;
                        } else {
                            str19 = n14.getString(c025);
                        }
                        if (n14.isNull(c026)) {
                            str20 = null;
                        } else {
                            str20 = n14.getString(c026);
                        }
                        if (n14.isNull(c027)) {
                            num = null;
                        } else {
                            num = Integer.valueOf(n14.getInt(c027));
                        }
                        if (n14.isNull(c028)) {
                            num2 = null;
                        } else {
                            num2 = Integer.valueOf(n14.getInt(c028));
                        }
                        arrayList3.add(new Request(i31, str17, str18, str19, str20, num, num2));
                    }
                    return arrayList3;
                } finally {
                    n14.close();
                    s0Var.v();
                }
            case 3:
                Cursor n15 = h0.n1(((y) obj).f265a, s0Var);
                try {
                    int c029 = h0.c0(n15, "id");
                    int c030 = h0.c0(n15, "position");
                    ArrayList arrayList4 = new ArrayList(n15.getCount());
                    while (n15.moveToNext()) {
                        arrayList4.add(new VideoPosition(n15.getLong(c029), n15.getLong(c030)));
                    }
                    return arrayList4;
                } finally {
                    n15.close();
                }
            case 4:
                Cursor n16 = h0.n1(((c0) obj).f221a, s0Var);
                try {
                    int c031 = h0.c0(n16, "url");
                    int c032 = h0.c0(n16, "source_url");
                    int c033 = h0.c0(n16, "source_start_position");
                    int c034 = h0.c0(n16, "name");
                    int c035 = h0.c0(n16, "channel_id");
                    int c036 = h0.c0(n16, "channel_login");
                    int c037 = h0.c0(n16, "channel_name");
                    int c038 = h0.c0(n16, "channel_logo");
                    int c039 = h0.c0(n16, "thumbnail");
                    int c040 = h0.c0(n16, "gameId");
                    int c041 = h0.c0(n16, "gameName");
                    int c042 = h0.c0(n16, "gameSlug");
                    int c043 = h0.c0(n16, "boxArtUrl");
                    int c044 = h0.c0(n16, "duration");
                    int c045 = h0.c0(n16, "upload_date");
                    int c046 = h0.c0(n16, "download_date");
                    int c047 = h0.c0(n16, "last_watch_position");
                    int c048 = h0.c0(n16, "progress");
                    int c049 = h0.c0(n16, "max_progress");
                    int c050 = h0.c0(n16, "status");
                    int c051 = h0.c0(n16, "type");
                    int c052 = h0.c0(n16, "videoId");
                    int c053 = h0.c0(n16, "id");
                    int c054 = h0.c0(n16, "is_vod");
                    int i32 = c052;
                    ArrayList arrayList5 = new ArrayList(n16.getCount());
                    while (n16.moveToNext()) {
                        if (n16.isNull(c031)) {
                            str21 = null;
                        } else {
                            str21 = n16.getString(c031);
                        }
                        if (n16.isNull(c032)) {
                            str22 = null;
                        } else {
                            str22 = n16.getString(c032);
                        }
                        if (n16.isNull(c033)) {
                            l10 = null;
                        } else {
                            l10 = Long.valueOf(n16.getLong(c033));
                        }
                        if (n16.isNull(c034)) {
                            str23 = null;
                        } else {
                            str23 = n16.getString(c034);
                        }
                        int i33 = n16.getInt(c035);
                        int i34 = c036;
                        if (n16.isNull(i34)) {
                            i15 = c035;
                            i16 = c037;
                            str24 = null;
                        } else {
                            str24 = n16.getString(i34);
                            i15 = c035;
                            i16 = c037;
                        }
                        if (n16.isNull(i16)) {
                            str25 = null;
                        } else {
                            str25 = n16.getString(i16);
                        }
                        if (n16.isNull(c038)) {
                            str26 = null;
                        } else {
                            str26 = n16.getString(c038);
                        }
                        if (n16.isNull(c039)) {
                            str27 = null;
                        } else {
                            str27 = n16.getString(c039);
                        }
                        int i35 = n16.getInt(c040);
                        if (n16.isNull(c041)) {
                            str28 = null;
                        } else {
                            str28 = n16.getString(c041);
                        }
                        if (n16.isNull(c042)) {
                            str29 = null;
                        } else {
                            str29 = n16.getString(c042);
                        }
                        if (n16.isNull(c043)) {
                            c037 = i16;
                            i17 = c044;
                            str30 = null;
                        } else {
                            str30 = n16.getString(c043);
                            c037 = i16;
                            i17 = c044;
                        }
                        if (n16.isNull(i17)) {
                            c044 = i17;
                            i18 = c045;
                            l11 = null;
                        } else {
                            l11 = Long.valueOf(n16.getLong(i17));
                            c044 = i17;
                            i18 = c045;
                        }
                        if (n16.isNull(i18)) {
                            c045 = i18;
                            i19 = c046;
                            l12 = null;
                        } else {
                            l12 = Long.valueOf(n16.getLong(i18));
                            c045 = i18;
                            i19 = c046;
                        }
                        if (n16.isNull(i19)) {
                            c046 = i19;
                            i20 = c047;
                            l13 = null;
                        } else {
                            l13 = Long.valueOf(n16.getLong(i19));
                            c046 = i19;
                            i20 = c047;
                        }
                        if (n16.isNull(i20)) {
                            c047 = i20;
                            i21 = c048;
                            l14 = null;
                        } else {
                            l14 = Long.valueOf(n16.getLong(i20));
                            c047 = i20;
                            i21 = c048;
                        }
                        int i36 = n16.getInt(i21);
                        c048 = i21;
                        int i37 = c049;
                        int i38 = n16.getInt(i37);
                        int i39 = n16.getInt(c050);
                        if (n16.isNull(c051)) {
                            c049 = i37;
                            i22 = i32;
                            str31 = null;
                        } else {
                            str31 = n16.getString(c051);
                            c049 = i37;
                            i22 = i32;
                        }
                        if (n16.isNull(i22)) {
                            i32 = i22;
                            str32 = null;
                        } else {
                            str32 = n16.getString(i22);
                            i32 = i22;
                        }
                        OfflineVideo offlineVideo = new OfflineVideo(str21, str22, l10, str23, i33, str24, str25, str26, str27, i35, str28, str29, str30, l11, l12, l13, l14, i36, i38, i39, str31, str32);
                        int i40 = c038;
                        int i41 = c053;
                        int i42 = c031;
                        offlineVideo.setId(n16.getInt(i41));
                        int i43 = c054;
                        if (n16.getInt(i43) != 0) {
                            i23 = i41;
                            z10 = true;
                        } else {
                            i23 = i41;
                            z10 = false;
                        }
                        offlineVideo.setVod(z10);
                        arrayList5.add(offlineVideo);
                        c054 = i43;
                        c035 = i15;
                        c031 = i42;
                        c038 = i40;
                        c053 = i23;
                        c036 = i34;
                    }
                    return arrayList5;
                } finally {
                    n16.close();
                }
            default:
                Cursor n17 = h0.n1(((e0) obj).f231a, s0Var);
                try {
                    int c055 = h0.c0(n17, "user_id");
                    ArrayList arrayList6 = new ArrayList(n17.getCount());
                    while (n17.moveToNext()) {
                        arrayList6.add(new VodBookmarkIgnoredUser(n17.getInt(c055)));
                    }
                    return arrayList6;
                } finally {
                    n17.close();
                }
        }
    }

    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f228a) {
            case 0:
                return a();
            case 1:
                return a();
            case 2:
                return a();
            case 3:
                return a();
            case 4:
                return a();
            default:
                return a();
        }
    }

    public final void finalize() {
        int i10 = this.f228a;
        s0 s0Var = this.f229b;
        switch (i10) {
            case 0:
                s0Var.v();
                return;
            case 1:
                s0Var.v();
                return;
            case 3:
                s0Var.v();
                return;
            case 4:
                s0Var.v();
                return;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                s0Var.v();
                return;
            default:
                super.finalize();
                return;
        }
    }
}
