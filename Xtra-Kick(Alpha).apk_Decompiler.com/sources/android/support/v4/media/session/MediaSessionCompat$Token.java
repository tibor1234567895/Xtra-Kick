package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import d4.e;

@SuppressLint({"BanParcelableUsage"})
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new m0();

    /* renamed from: h  reason: collision with root package name */
    public final Object f350h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public final Object f351i;

    /* renamed from: j  reason: collision with root package name */
    public f f352j;

    /* renamed from: k  reason: collision with root package name */
    public e f353k;

    public MediaSessionCompat$Token(Object obj, f fVar, e eVar) {
        this.f351i = obj;
        this.f352j = fVar;
        this.f353k = eVar;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionCompat$Token)) {
            return false;
        }
        Object obj2 = this.f351i;
        Object obj3 = ((MediaSessionCompat$Token) obj).f351i;
        if (obj2 == null) {
            return obj3 == null;
        }
        if (obj3 == null) {
            return false;
        }
        return obj2.equals(obj3);
    }

    public final int hashCode() {
        Object obj = this.f351i;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final f u() {
        f fVar;
        synchronized (this.f350h) {
            fVar = this.f352j;
        }
        return fVar;
    }

    public final void v(f fVar) {
        synchronized (this.f350h) {
            this.f352j = fVar;
        }
    }

    public final void w(e eVar) {
        synchronized (this.f350h) {
            this.f353k = eVar;
        }
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable((Parcelable) this.f351i, i10);
    }
}
