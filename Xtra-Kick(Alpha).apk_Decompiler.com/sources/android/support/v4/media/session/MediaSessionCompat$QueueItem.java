package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new j0();

    /* renamed from: h  reason: collision with root package name */
    public final MediaDescriptionCompat f346h;

    /* renamed from: i  reason: collision with root package name */
    public final long f347i;

    /* renamed from: j  reason: collision with root package name */
    public MediaSession.QueueItem f348j;

    public MediaSessionCompat$QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j10) {
        if (mediaDescriptionCompat == null) {
            throw new IllegalArgumentException("Description cannot be null");
        } else if (j10 != -1) {
            this.f346h = mediaDescriptionCompat;
            this.f347i = j10;
            this.f348j = queueItem;
        } else {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }
    }

    public static ArrayList u(List list) {
        MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Object next : list) {
            if (next != null) {
                MediaSession.QueueItem queueItem = (MediaSession.QueueItem) next;
                mediaSessionCompat$QueueItem = new MediaSessionCompat$QueueItem(queueItem, MediaDescriptionCompat.u(k0.b(queueItem)), k0.c(queueItem));
            } else {
                mediaSessionCompat$QueueItem = null;
            }
            arrayList.add(mediaSessionCompat$QueueItem);
        }
        return arrayList;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "MediaSession.QueueItem {Description=" + this.f346h + ", Id=" + this.f347i + " }";
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        this.f346h.writeToParcel(parcel, i10);
        parcel.writeLong(this.f347i);
    }

    public MediaSessionCompat$QueueItem(Parcel parcel) {
        this.f346h = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.f347i = parcel.readLong();
    }
}
