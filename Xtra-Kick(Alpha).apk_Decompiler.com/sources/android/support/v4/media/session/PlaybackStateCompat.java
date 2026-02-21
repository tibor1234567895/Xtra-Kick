package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new o0();

    /* renamed from: h  reason: collision with root package name */
    public final int f359h;

    /* renamed from: i  reason: collision with root package name */
    public final long f360i;

    /* renamed from: j  reason: collision with root package name */
    public final long f361j;

    /* renamed from: k  reason: collision with root package name */
    public final float f362k;

    /* renamed from: l  reason: collision with root package name */
    public final long f363l;

    /* renamed from: m  reason: collision with root package name */
    public final int f364m;

    /* renamed from: n  reason: collision with root package name */
    public final CharSequence f365n;

    /* renamed from: o  reason: collision with root package name */
    public final long f366o;

    /* renamed from: p  reason: collision with root package name */
    public final ArrayList f367p;

    /* renamed from: q  reason: collision with root package name */
    public final long f368q;

    /* renamed from: r  reason: collision with root package name */
    public final Bundle f369r;

    /* renamed from: s  reason: collision with root package name */
    public PlaybackState f370s;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new s0();

        /* renamed from: h  reason: collision with root package name */
        public final String f371h;

        /* renamed from: i  reason: collision with root package name */
        public final CharSequence f372i;

        /* renamed from: j  reason: collision with root package name */
        public final int f373j;

        /* renamed from: k  reason: collision with root package name */
        public final Bundle f374k;

        /* renamed from: l  reason: collision with root package name */
        public PlaybackState.CustomAction f375l;

        public CustomAction(Parcel parcel) {
            this.f371h = parcel.readString();
            this.f372i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f373j = parcel.readInt();
            this.f374k = parcel.readBundle(u.class.getClassLoader());
        }

        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + this.f372i + ", mIcon=" + this.f373j + ", mExtras=" + this.f374k;
        }

        public final void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f371h);
            TextUtils.writeToParcel(this.f372i, parcel, i10);
            parcel.writeInt(this.f373j);
            parcel.writeBundle(this.f374k);
        }

        public CustomAction(String str, CharSequence charSequence, int i10, Bundle bundle) {
            this.f371h = str;
            this.f372i = charSequence;
            this.f373j = i10;
            this.f374k = bundle;
        }
    }

    public PlaybackStateCompat(int i10, long j10, long j11, float f10, long j12, int i11, CharSequence charSequence, long j13, ArrayList arrayList, long j14, Bundle bundle) {
        this.f359h = i10;
        this.f360i = j10;
        this.f361j = j11;
        this.f362k = f10;
        this.f363l = j12;
        this.f364m = i11;
        this.f365n = charSequence;
        this.f366o = j13;
        this.f367p = new ArrayList(arrayList);
        this.f368q = j14;
        this.f369r = bundle;
    }

    public static PlaybackStateCompat u(Object obj) {
        ArrayList arrayList;
        CustomAction customAction;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) obj;
        List<PlaybackState.CustomAction> j10 = p0.j(playbackState);
        if (j10 != null) {
            ArrayList arrayList2 = new ArrayList(j10.size());
            for (PlaybackState.CustomAction next : j10) {
                Parcelable.Creator<CustomAction> creator = CustomAction.CREATOR;
                if (next != null) {
                    PlaybackState.CustomAction customAction2 = next;
                    Bundle l10 = p0.l(customAction2);
                    u.p(l10);
                    customAction = new CustomAction(p0.f(customAction2), p0.o(customAction2), p0.m(customAction2), l10);
                    customAction.f375l = customAction2;
                } else {
                    customAction = null;
                }
                arrayList2.add(customAction);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = q0.a(playbackState);
            u.p(bundle);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(p0.r(playbackState), p0.q(playbackState), p0.i(playbackState), p0.p(playbackState), p0.g(playbackState), 0, p0.k(playbackState), p0.n(playbackState), arrayList, p0.h(playbackState), bundle);
        playbackStateCompat.f370s = playbackState;
        return playbackStateCompat;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.f359h + ", position=" + this.f360i + ", buffered position=" + this.f361j + ", speed=" + this.f362k + ", updated=" + this.f366o + ", actions=" + this.f363l + ", error code=" + this.f364m + ", error message=" + this.f365n + ", custom actions=" + this.f367p + ", active item id=" + this.f368q + "}";
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f359h);
        parcel.writeLong(this.f360i);
        parcel.writeFloat(this.f362k);
        parcel.writeLong(this.f366o);
        parcel.writeLong(this.f361j);
        parcel.writeLong(this.f363l);
        TextUtils.writeToParcel(this.f365n, parcel, i10);
        parcel.writeTypedList(this.f367p);
        parcel.writeLong(this.f368q);
        parcel.writeBundle(this.f369r);
        parcel.writeInt(this.f364m);
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f359h = parcel.readInt();
        this.f360i = parcel.readLong();
        this.f362k = parcel.readFloat();
        this.f366o = parcel.readLong();
        this.f361j = parcel.readLong();
        this.f363l = parcel.readLong();
        this.f365n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f367p = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f368q = parcel.readLong();
        this.f369r = parcel.readBundle(u.class.getClassLoader());
        this.f364m = parcel.readInt();
    }
}
