package pb;

import android.support.v4.media.h;
import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import ub.d;
import xa.j;

public final class w {

    /* renamed from: j  reason: collision with root package name */
    public static final v f13009j = new v(0);

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f13010k = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: l  reason: collision with root package name */
    public static final Pattern f13011l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: m  reason: collision with root package name */
    public static final Pattern f13012m = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: n  reason: collision with root package name */
    public static final Pattern f13013n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    public final String f13014a;

    /* renamed from: b  reason: collision with root package name */
    public final String f13015b;

    /* renamed from: c  reason: collision with root package name */
    public final long f13016c;

    /* renamed from: d  reason: collision with root package name */
    public final String f13017d;

    /* renamed from: e  reason: collision with root package name */
    public final String f13018e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f13019f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f13020g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f13021h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f13022i;

    public w(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f13014a = str;
        this.f13015b = str2;
        this.f13016c = j10;
        this.f13017d = str3;
        this.f13018e = str4;
        this.f13019f = z10;
        this.f13020g = z11;
        this.f13021h = z12;
        this.f13022i = z13;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof w) {
            w wVar = (w) obj;
            return j.a(wVar.f13014a, this.f13014a) && j.a(wVar.f13015b, this.f13015b) && wVar.f13016c == this.f13016c && j.a(wVar.f13017d, this.f13017d) && j.a(wVar.f13018e, this.f13018e) && wVar.f13019f == this.f13019f && wVar.f13020g == this.f13020g && wVar.f13021h == this.f13021h && wVar.f13022i == this.f13022i;
        }
    }

    public final int hashCode() {
        int i10;
        int i11;
        int i12;
        int e10 = h.e(this.f13015b, h.e(this.f13014a, 527, 31), 31);
        long j10 = this.f13016c;
        int e11 = h.e(this.f13018e, h.e(this.f13017d, (e10 + ((int) (j10 ^ (j10 >>> 32)))) * 31, 31), 31);
        int i13 = 1231;
        if (this.f13019f) {
            i10 = 1231;
        } else {
            i10 = 1237;
        }
        int i14 = (e11 + i10) * 31;
        if (this.f13020g) {
            i11 = 1231;
        } else {
            i11 = 1237;
        }
        int i15 = (i14 + i11) * 31;
        if (this.f13021h) {
            i12 = 1231;
        } else {
            i12 = 1237;
        }
        int i16 = (i15 + i12) * 31;
        if (!this.f13022i) {
            i13 = 1237;
        }
        return i16 + i13;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f13014a);
        sb2.append('=');
        sb2.append(this.f13015b);
        if (this.f13021h) {
            long j10 = this.f13016c;
            if (j10 == Long.MIN_VALUE) {
                str = "; max-age=0";
            } else {
                sb2.append("; expires=");
                str = ((DateFormat) d.f15468a.get()).format(new Date(j10));
                j.e("STANDARD_DATE_FORMAT.get().format(this)", str);
            }
            sb2.append(str);
        }
        if (!this.f13022i) {
            sb2.append("; domain=");
            sb2.append(this.f13017d);
        }
        sb2.append("; path=");
        sb2.append(this.f13018e);
        if (this.f13019f) {
            sb2.append("; secure");
        }
        if (this.f13020g) {
            sb2.append("; httponly");
        }
        String sb3 = sb2.toString();
        j.e("toString()", sb3);
        return sb3;
    }
}
