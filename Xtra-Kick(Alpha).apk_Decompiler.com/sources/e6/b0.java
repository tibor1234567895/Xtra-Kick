package e6;

import a6.f;
import android.database.Cursor;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import hb.f0;
import hb.h0;
import java.util.ArrayList;
import la.v;
import pa.e;
import r3.n0;
import r3.s0;
import ra.i;
import wa.p;

public final class b0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e0 f5082i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(e0 e0Var, e eVar) {
        super(2, eVar);
        this.f5082i = e0Var;
    }

    public final e create(Object obj, e eVar) {
        return new b0(this.f5082i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        s0 s0Var;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i10;
        String string;
        String string2;
        String string3;
        h0.O1(obj);
        f fVar = (f) this.f5082i.f5105a;
        fVar.getClass();
        s0 k10 = s0.k(0, "SELECT * FROM bookmarks");
        n0 n0Var = fVar.f234a;
        n0Var.b();
        Cursor n12 = h0.n1(n0Var, k10);
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
            s0Var = k10;
            try {
                int c016 = h0.c0(n12, "type");
                int c017 = h0.c0(n12, "duration");
                int c018 = h0.c0(n12, "animatedPreviewURL");
                int c019 = h0.c0(n12, "id");
                int i11 = c015;
                ArrayList arrayList = new ArrayList(n12.getCount());
                while (n12.moveToNext()) {
                    String str12 = null;
                    if (n12.isNull(c02)) {
                        str = null;
                    } else {
                        str = n12.getString(c02);
                    }
                    int i12 = n12.getInt(c03);
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
                    int i13 = n12.getInt(c09);
                    if (n12.isNull(c010)) {
                        str7 = null;
                    } else {
                        str7 = n12.getString(c010);
                    }
                    if (n12.isNull(c011)) {
                        str8 = null;
                    } else {
                        str8 = n12.getString(c011);
                    }
                    if (n12.isNull(c012)) {
                        str9 = null;
                    } else {
                        str9 = n12.getString(c012);
                    }
                    if (n12.isNull(c013)) {
                        str10 = null;
                    } else {
                        str10 = n12.getString(c013);
                    }
                    if (n12.isNull(c014)) {
                        i10 = i11;
                        str11 = null;
                    } else {
                        str11 = n12.getString(c014);
                        i10 = i11;
                    }
                    if (n12.isNull(i10)) {
                        string = null;
                    } else {
                        string = n12.getString(i10);
                    }
                    int i14 = c016;
                    int i15 = c02;
                    int i16 = i14;
                    if (n12.isNull(i16)) {
                        string2 = null;
                    } else {
                        string2 = n12.getString(i16);
                    }
                    int i17 = c017;
                    int i18 = i16;
                    int i19 = i17;
                    if (n12.isNull(i19)) {
                        string3 = null;
                    } else {
                        string3 = n12.getString(i19);
                    }
                    int i20 = c018;
                    int i21 = i19;
                    int i22 = i20;
                    if (!n12.isNull(i22)) {
                        str12 = n12.getString(i22);
                    }
                    int i23 = i22;
                    Bookmark bookmark = new Bookmark(str, i12, str2, str3, str4, str5, str6, i13, str7, str8, str9, str10, str11, string, string2, string3, str12);
                    int i24 = i10;
                    int i25 = c019;
                    int i26 = c03;
                    bookmark.setId(n12.getInt(i25));
                    arrayList.add(bookmark);
                    c02 = i15;
                    c016 = i18;
                    c017 = i21;
                    c03 = i26;
                    c018 = i23;
                    i11 = i24;
                    c019 = i25;
                }
                n12.close();
                s0Var.v();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                n12.close();
                s0Var.v();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            s0Var = k10;
            n12.close();
            s0Var.v();
            throw th;
        }
    }
}
