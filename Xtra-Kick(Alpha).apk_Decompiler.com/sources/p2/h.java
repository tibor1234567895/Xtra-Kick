package p2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.a0;
import g1.u0;
import g1.y0;
import j1.a;
import java.util.ArrayList;
import java.util.List;

public final class h implements y0 {
    public static final Parcelable.Creator<h> CREATOR = new e();

    /* renamed from: h  reason: collision with root package name */
    public final List f12523h;

    public h(ArrayList arrayList) {
        this.f12523h = arrayList;
        boolean z10 = false;
        if (!arrayList.isEmpty()) {
            long j10 = ((g) arrayList.get(0)).f12521i;
            int i10 = 1;
            while (true) {
                if (i10 >= arrayList.size()) {
                    break;
                } else if (((g) arrayList.get(i10)).f12520h < j10) {
                    z10 = true;
                    break;
                } else {
                    j10 = ((g) arrayList.get(i10)).f12521i;
                    i10++;
                }
            }
        }
        a.b(!z10);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return this.f12523h.equals(((h) obj).f12523h);
    }

    public final /* synthetic */ a0 g() {
        return null;
    }

    public final /* synthetic */ void h(u0 u0Var) {
    }

    public final int hashCode() {
        return this.f12523h.hashCode();
    }

    public final /* synthetic */ byte[] r() {
        return null;
    }

    public final String toString() {
        return "SlowMotion: segments=" + this.f12523h;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.f12523h);
    }
}
