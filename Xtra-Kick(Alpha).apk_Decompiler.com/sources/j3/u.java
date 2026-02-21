package j3;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.s;
import xa.j;

public final class u implements Parcelable {
    public static final Parcelable.Creator<u> CREATOR = new s();

    /* renamed from: h  reason: collision with root package name */
    public final String f8688h;

    /* renamed from: i  reason: collision with root package name */
    public final int f8689i;

    /* renamed from: j  reason: collision with root package name */
    public final Bundle f8690j;

    /* renamed from: k  reason: collision with root package name */
    public final Bundle f8691k;

    static {
        new t(0);
    }

    public u(Parcel parcel) {
        j.f("inParcel", parcel);
        String readString = parcel.readString();
        j.c(readString);
        this.f8688h = readString;
        this.f8689i = parcel.readInt();
        Class<u> cls = u.class;
        this.f8690j = parcel.readBundle(cls.getClassLoader());
        Bundle readBundle = parcel.readBundle(cls.getClassLoader());
        j.c(readBundle);
        this.f8691k = readBundle;
    }

    public final int describeContents() {
        return 0;
    }

    public final r u(Context context, c1 c1Var, s sVar, n0 n0Var) {
        j.f("context", context);
        j.f("hostLifecycleState", sVar);
        Bundle bundle = this.f8690j;
        if (bundle != null) {
            bundle.setClassLoader(context.getClassLoader());
        } else {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        n nVar = r.f8659t;
        String str = this.f8688h;
        Bundle bundle3 = this.f8691k;
        nVar.getClass();
        return n.a(context, c1Var, bundle2, sVar, n0Var, str, bundle3);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        j.f("parcel", parcel);
        parcel.writeString(this.f8688h);
        parcel.writeInt(this.f8689i);
        parcel.writeBundle(this.f8690j);
        parcel.writeBundle(this.f8691k);
    }

    public u(r rVar) {
        j.f("entry", rVar);
        this.f8688h = rVar.f8665m;
        this.f8689i = rVar.f8661i.f8513o;
        this.f8690j = rVar.b();
        Bundle bundle = new Bundle();
        this.f8691k = bundle;
        rVar.f8668p.c(bundle);
    }
}
