package com.github.andreyasadchy.xtra.model.chat;

import android.support.v4.media.h;
import q0.f;
import xa.j;

public final class KickBadge {
    private final int count;
    private final String setId;
    private final String title;
    private final String type;
    private final String url;
    private final String version;

    public KickBadge(String str, String str2, String str3, String str4, int i10, String str5) {
        j.f("setId", str);
        j.f("version", str2);
        this.setId = str;
        this.version = str2;
        this.type = str3;
        this.title = str4;
        this.count = i10;
        this.url = str5;
    }

    public static /* synthetic */ KickBadge copy$default(KickBadge kickBadge, String str, String str2, String str3, String str4, int i10, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = kickBadge.setId;
        }
        if ((i11 & 2) != 0) {
            str2 = kickBadge.version;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = kickBadge.type;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = kickBadge.title;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            i10 = kickBadge.count;
        }
        int i12 = i10;
        if ((i11 & 32) != 0) {
            str5 = kickBadge.url;
        }
        return kickBadge.copy(str, str6, str7, str8, i12, str5);
    }

    public final String component1() {
        return this.setId;
    }

    public final String component2() {
        return this.version;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.title;
    }

    public final int component5() {
        return this.count;
    }

    public final String component6() {
        return this.url;
    }

    public final KickBadge copy(String str, String str2, String str3, String str4, int i10, String str5) {
        j.f("setId", str);
        j.f("version", str2);
        return new KickBadge(str, str2, str3, str4, i10, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KickBadge)) {
            return false;
        }
        KickBadge kickBadge = (KickBadge) obj;
        return j.a(this.setId, kickBadge.setId) && j.a(this.version, kickBadge.version) && j.a(this.type, kickBadge.type) && j.a(this.title, kickBadge.title) && this.count == kickBadge.count && j.a(this.url, kickBadge.url);
    }

    public final int getCount() {
        return this.count;
    }

    public final String getSetId() {
        return this.setId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int i10;
        int i11;
        int e10 = h.e(this.version, this.setId.hashCode() * 31, 31);
        String str = this.type;
        int i12 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i13 = (e10 + i10) * 31;
        String str2 = this.title;
        if (str2 == null) {
            i11 = 0;
        } else {
            i11 = str2.hashCode();
        }
        int i14 = (((i13 + i11) * 31) + this.count) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i12 = str3.hashCode();
        }
        return i14 + i12;
    }

    public String toString() {
        String str = this.setId;
        String str2 = this.version;
        String str3 = this.type;
        String str4 = this.title;
        int i10 = this.count;
        String str5 = this.url;
        StringBuilder sb2 = new StringBuilder("KickBadge(setId=");
        sb2.append(str);
        sb2.append(", version=");
        sb2.append(str2);
        sb2.append(", type=");
        f.k(sb2, str3, ", title=", str4, ", count=");
        sb2.append(i10);
        sb2.append(", url=");
        sb2.append(str5);
        sb2.append(")");
        return sb2.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KickBadge(String str, String str2, String str3, String str4, int i10, String str5, int i11, xa.f fVar) {
        this(str, str2, str3, str4, (i11 & 16) != 0 ? 0 : i10, str5);
    }
}
