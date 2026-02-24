package t7;

import java.util.List;
import xa.j;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final String f14712a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14713b;

    /* renamed from: c  reason: collision with root package name */
    public final String f14714c;

    /* renamed from: d  reason: collision with root package name */
    public final List f14715d;

    /* renamed from: e  reason: collision with root package name */
    public final Long f14716e;

    /* renamed from: f  reason: collision with root package name */
    public final String f14717f;

    public l() {
        this((String) null, (String) null, (String) null, (String) null, 63);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return j.a(this.f14712a, lVar.f14712a) && j.a(this.f14713b, lVar.f14713b) && j.a(this.f14714c, lVar.f14714c) && j.a(this.f14715d, lVar.f14715d) && j.a(this.f14716e, lVar.f14716e) && j.a(this.f14717f, lVar.f14717f);
    }

    public final int hashCode() {
        int i10 = 0;
        String str = this.f14712a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f14713b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f14714c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List list = this.f14715d;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Long l10 = this.f14716e;
        int hashCode5 = (hashCode4 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str4 = this.f14717f;
        if (str4 != null) {
            i10 = str4.hashCode();
        }
        return hashCode5 + i10;
    }

    public final String toString() {
        return "Command(message=" + this.f14712a + ", duration=" + this.f14713b + ", type=" + this.f14714c + ", emotes=" + this.f14715d + ", timestamp=" + this.f14716e + ", fullMsg=" + this.f14717f + ")";
    }

    public l(String str, String str2, String str3, String str4, int i10) {
        str = (i10 & 1) != 0 ? null : str;
        str2 = (i10 & 2) != 0 ? null : str2;
        str3 = (i10 & 4) != 0 ? null : str3;
        str4 = (i10 & 32) != 0 ? null : str4;
        this.f14712a = str;
        this.f14713b = str2;
        this.f14714c = str3;
        this.f14715d = null;
        this.f14716e = null;
        this.f14717f = str4;
    }
}
