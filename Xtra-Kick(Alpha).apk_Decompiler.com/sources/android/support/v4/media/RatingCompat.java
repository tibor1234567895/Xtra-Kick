package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a0();

    /* renamed from: h  reason: collision with root package name */
    public final int f311h;

    /* renamed from: i  reason: collision with root package name */
    public final float f312i;

    /* renamed from: j  reason: collision with root package name */
    public Object f313j;

    public RatingCompat(int i10, float f10) {
        this.f311h = i10;
        this.f312i = f10;
    }

    public static RatingCompat u(Object obj) {
        RatingCompat ratingCompat;
        RatingCompat ratingCompat2 = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int b10 = b0.b(rating);
            if (b0.e(rating)) {
                float f10 = 1.0f;
                switch (b10) {
                    case 1:
                        if (!b0.d(rating)) {
                            f10 = 0.0f;
                        }
                        ratingCompat = new RatingCompat(1, f10);
                        break;
                    case 2:
                        if (!b0.f(rating)) {
                            f10 = 0.0f;
                        }
                        ratingCompat = new RatingCompat(2, f10);
                        break;
                    case 3:
                    case 4:
                    case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                        ratingCompat2 = x(b10, b0.c(rating));
                        break;
                    case 6:
                        float a10 = b0.a(rating);
                        if (a10 >= 0.0f && a10 <= 100.0f) {
                            ratingCompat2 = new RatingCompat(6, a10);
                            break;
                        } else {
                            Log.e("Rating", "Invalid percentage-based rating value");
                            break;
                        }
                        break;
                    default:
                        return null;
                }
                ratingCompat2 = ratingCompat;
            } else {
                ratingCompat2 = y(b10);
            }
            ratingCompat2.f313j = obj;
        }
        return ratingCompat2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.RatingCompat x(int r4, float r5) {
        /*
            r0 = 3
            r1 = 0
            java.lang.String r2 = "Rating"
            if (r4 == r0) goto L_0x0029
            r0 = 4
            if (r4 == r0) goto L_0x0026
            r0 = 5
            if (r4 == r0) goto L_0x0023
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid rating style ("
            r5.<init>(r0)
            r5.append(r4)
            java.lang.String r4 = ") for a star rating"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
        L_0x001f:
            android.util.Log.e(r2, r4)
            return r1
        L_0x0023:
            r0 = 1084227584(0x40a00000, float:5.0)
            goto L_0x002b
        L_0x0026:
            r0 = 1082130432(0x40800000, float:4.0)
            goto L_0x002b
        L_0x0029:
            r0 = 1077936128(0x40400000, float:3.0)
        L_0x002b:
            r3 = 0
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x003b
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0035
            goto L_0x003b
        L_0x0035:
            android.support.v4.media.RatingCompat r0 = new android.support.v4.media.RatingCompat
            r0.<init>(r4, r5)
            return r0
        L_0x003b:
            java.lang.String r4 = "Trying to set out of range star-based rating"
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.RatingCompat.x(int, float):android.support.v4.media.RatingCompat");
    }

    public static RatingCompat y(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
            case 6:
                return new RatingCompat(i10, -1.0f);
            default:
                return null;
        }
    }

    public final int describeContents() {
        return this.f311h;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Rating:style=");
        sb2.append(this.f311h);
        sb2.append(" rating=");
        float f10 = this.f312i;
        sb2.append(f10 < 0.0f ? "unrated" : String.valueOf(f10));
        return sb2.toString();
    }

    public final float v() {
        int i10 = this.f311h;
        if ((i10 == 3 || i10 == 4 || i10 == 5) && w()) {
            return this.f312i;
        }
        return -1.0f;
    }

    public final boolean w() {
        return this.f312i >= 0.0f;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f311h);
        parcel.writeFloat(this.f312i);
    }
}
