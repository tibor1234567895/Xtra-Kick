package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.Rating;
import android.os.Bundle;
import android.os.Parcelable;
import q.e;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f447a = new Bundle();

    public final void a(String str, Bitmap bitmap) {
        e eVar = MediaMetadataCompat.f308j;
        if (!eVar.containsKey(str) || ((Integer) eVar.getOrDefault(str, (Object) null)).intValue() == 2) {
            this.f447a.putParcelable(str, bitmap);
            return;
        }
        throw new IllegalArgumentException(h.n("The ", str, " key cannot be used to put a Bitmap"));
    }

    public final void b(String str, long j10) {
        e eVar = MediaMetadataCompat.f308j;
        if (!eVar.containsKey(str) || ((Integer) eVar.getOrDefault(str, (Object) null)).intValue() == 0) {
            this.f447a.putLong(str, j10);
            return;
        }
        throw new IllegalArgumentException(h.n("The ", str, " key cannot be used to put a long"));
    }

    public final void c(String str, RatingCompat ratingCompat) {
        Rating rating;
        e eVar = MediaMetadataCompat.f308j;
        Object obj = null;
        if (!eVar.containsKey(str) || ((Integer) eVar.getOrDefault(str, (Object) null)).intValue() == 3) {
            if (ratingCompat.f313j == null) {
                boolean w10 = ratingCompat.w();
                int i10 = ratingCompat.f311h;
                if (w10) {
                    boolean z10 = false;
                    float f10 = ratingCompat.f312i;
                    switch (i10) {
                        case 1:
                            if (i10 == 1 && f10 == 1.0f) {
                                z10 = true;
                            }
                            rating = b0.g(z10);
                            break;
                        case 2:
                            if (i10 == 2 && f10 == 1.0f) {
                                z10 = true;
                            }
                            rating = b0.j(z10);
                            break;
                        case 3:
                        case 4:
                        case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                            rating = b0.i(i10, ratingCompat.v());
                            break;
                        case 6:
                            if (i10 != 6 || !ratingCompat.w()) {
                                f10 = -1.0f;
                            }
                            rating = b0.h(f10);
                            break;
                    }
                } else {
                    rating = b0.k(i10);
                }
                ratingCompat.f313j = rating;
            }
            obj = ratingCompat.f313j;
            this.f447a.putParcelable(str, (Parcelable) obj);
            return;
        }
        throw new IllegalArgumentException(h.n("The ", str, " key cannot be used to put a Rating"));
    }

    public final void d(String str, String str2) {
        e eVar = MediaMetadataCompat.f308j;
        if (!eVar.containsKey(str) || ((Integer) eVar.getOrDefault(str, (Object) null)).intValue() == 1) {
            this.f447a.putCharSequence(str, str2);
            return;
        }
        throw new IllegalArgumentException(h.n("The ", str, " key cannot be used to put a String"));
    }

    public final void e(CharSequence charSequence, String str) {
        e eVar = MediaMetadataCompat.f308j;
        if (!eVar.containsKey(str) || ((Integer) eVar.getOrDefault(str, (Object) null)).intValue() == 1) {
            this.f447a.putCharSequence(str, charSequence);
            return;
        }
        throw new IllegalArgumentException(h.n("The ", str, " key cannot be used to put a CharSequence"));
    }
}
