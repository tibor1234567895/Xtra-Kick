package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;

@SuppressLint({"BanParcelableUsage"})
final class MediaSessionCompat$ResultReceiverWrapper implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$ResultReceiverWrapper> CREATOR = new l0();

    /* renamed from: h  reason: collision with root package name */
    public final ResultReceiver f349h;

    public MediaSessionCompat$ResultReceiverWrapper(Parcel parcel) {
        this.f349h = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        this.f349h.writeToParcel(parcel, i10);
    }
}
