package s3;

import android.support.v4.media.h;
import java.util.List;
import xa.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f14170a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14171b;

    /* renamed from: c  reason: collision with root package name */
    public final String f14172c;

    /* renamed from: d  reason: collision with root package name */
    public final List f14173d;

    /* renamed from: e  reason: collision with root package name */
    public final List f14174e;

    public d(String str, String str2, String str3, List list, List list2) {
        j.f("columnNames", list);
        j.f("referenceColumnNames", list2);
        this.f14170a = str;
        this.f14171b = str2;
        this.f14172c = str3;
        this.f14173d = list;
        this.f14174e = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (j.a(this.f14170a, dVar.f14170a) && j.a(this.f14171b, dVar.f14171b) && j.a(this.f14172c, dVar.f14172c) && j.a(this.f14173d, dVar.f14173d)) {
            return j.a(this.f14174e, dVar.f14174e);
        }
        return false;
    }

    public final int hashCode() {
        int e10 = h.e(this.f14172c, h.e(this.f14171b, this.f14170a.hashCode() * 31, 31), 31);
        return this.f14174e.hashCode() + ((this.f14173d.hashCode() + e10) * 31);
    }

    public final String toString() {
        return "ForeignKey{referenceTable='" + this.f14170a + "', onDelete='" + this.f14171b + " +', onUpdate='" + this.f14172c + "', columnNames=" + this.f14173d + ", referenceColumnNames=" + this.f14174e + '}';
    }
}
