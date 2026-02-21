package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new t();

    /* renamed from: h  reason: collision with root package name */
    public final String f299h;

    /* renamed from: i  reason: collision with root package name */
    public final CharSequence f300i;

    /* renamed from: j  reason: collision with root package name */
    public final CharSequence f301j;

    /* renamed from: k  reason: collision with root package name */
    public final CharSequence f302k;

    /* renamed from: l  reason: collision with root package name */
    public final Bitmap f303l;

    /* renamed from: m  reason: collision with root package name */
    public final Uri f304m;

    /* renamed from: n  reason: collision with root package name */
    public final Bundle f305n;

    /* renamed from: o  reason: collision with root package name */
    public final Uri f306o;

    /* renamed from: p  reason: collision with root package name */
    public MediaDescription f307p;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f299h = str;
        this.f300i = charSequence;
        this.f301j = charSequence2;
        this.f302k = charSequence3;
        this.f303l = bitmap;
        this.f304m = uri;
        this.f305n = bundle;
        this.f306o = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat u(java.lang.Object r12) {
        /*
            r0 = 0
            if (r12 == 0) goto L_0x0088
            int r1 = android.os.Build.VERSION.SDK_INT
            android.support.v4.media.x r2 = new android.support.v4.media.x
            r2.<init>()
            android.media.MediaDescription r12 = (android.media.MediaDescription) r12
            java.lang.String r3 = android.support.v4.media.u.g(r12)
            r2.f439a = r3
            java.lang.CharSequence r3 = android.support.v4.media.u.i(r12)
            r2.f440b = r3
            java.lang.CharSequence r3 = android.support.v4.media.u.h(r12)
            r2.f441c = r3
            java.lang.CharSequence r3 = android.support.v4.media.u.c(r12)
            r2.f442d = r3
            android.graphics.Bitmap r3 = android.support.v4.media.u.e(r12)
            r2.f443e = r3
            android.net.Uri r3 = android.support.v4.media.u.f(r12)
            r2.f444f = r3
            android.os.Bundle r3 = android.support.v4.media.u.d(r12)
            if (r3 == 0) goto L_0x003a
            android.os.Bundle r3 = android.support.v4.media.session.u.O(r3)
        L_0x003a:
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L_0x0045
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x0046
        L_0x0045:
            r5 = r0
        L_0x0046:
            if (r5 == 0) goto L_0x005e
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L_0x0058
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L_0x0058
            goto L_0x005f
        L_0x0058:
            r3.remove(r4)
            r3.remove(r6)
        L_0x005e:
            r0 = r3
        L_0x005f:
            r2.f445g = r0
            if (r5 == 0) goto L_0x0066
            r2.f446h = r5
            goto L_0x0070
        L_0x0066:
            r0 = 23
            if (r1 < r0) goto L_0x0070
            android.net.Uri r0 = android.support.v4.media.w.a(r12)
            r2.f446h = r0
        L_0x0070:
            android.support.v4.media.MediaDescriptionCompat r0 = new android.support.v4.media.MediaDescriptionCompat
            java.lang.String r4 = r2.f439a
            java.lang.CharSequence r5 = r2.f440b
            java.lang.CharSequence r6 = r2.f441c
            java.lang.CharSequence r7 = r2.f442d
            android.graphics.Bitmap r8 = r2.f443e
            android.net.Uri r9 = r2.f444f
            android.os.Bundle r10 = r2.f445g
            android.net.Uri r11 = r2.f446h
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r0.f307p = r12
        L_0x0088:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.u(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.f300i + ", " + this.f301j + ", " + this.f302k;
    }

    public final MediaDescription v() {
        MediaDescription mediaDescription = this.f307p;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        int i10 = Build.VERSION.SDK_INT;
        MediaDescription.Builder b10 = u.b();
        u.n(b10, this.f299h);
        u.p(b10, this.f300i);
        u.o(b10, this.f301j);
        u.j(b10, this.f302k);
        u.l(b10, this.f303l);
        u.m(b10, this.f304m);
        Uri uri = this.f306o;
        Bundle bundle = this.f305n;
        if (i10 < 23 && uri != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            } else {
                bundle = new Bundle(bundle);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", uri);
        }
        u.k(b10, bundle);
        if (i10 >= 23) {
            w.b(b10, uri);
        }
        MediaDescription a10 = u.a(b10);
        this.f307p = a10;
        return a10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        v().writeToParcel(parcel, i10);
    }
}
