package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new m();

    /* renamed from: h  reason: collision with root package name */
    public final int f297h;

    /* renamed from: i  reason: collision with root package name */
    public final MediaDescriptionCompat f298i;

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f297h = parcel.readInt();
        this.f298i = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    public static void u(List list) {
        MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem;
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (Object next : list) {
                if (next != null) {
                    MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) next;
                    mediaBrowserCompat$MediaItem = new MediaBrowserCompat$MediaItem(MediaDescriptionCompat.u(a.a(mediaItem)), a.b(mediaItem));
                } else {
                    mediaBrowserCompat$MediaItem = null;
                }
                arrayList.add(mediaBrowserCompat$MediaItem);
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "MediaItem{mFlags=" + this.f297h + ", mDescription=" + this.f298i + '}';
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f297h);
        this.f298i.writeToParcel(parcel, i10);
    }

    public MediaBrowserCompat$MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        if (mediaDescriptionCompat == null) {
            throw new IllegalArgumentException("description cannot be null");
        } else if (!TextUtils.isEmpty(mediaDescriptionCompat.f299h)) {
            this.f297h = i10;
            this.f298i = mediaDescriptionCompat;
        } else {
            throw new IllegalArgumentException("description must have a non-empty media id");
        }
    }
}
