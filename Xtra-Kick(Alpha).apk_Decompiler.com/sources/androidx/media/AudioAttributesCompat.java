package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.util.SparseIntArray;
import d4.e;

public class AudioAttributesCompat implements e {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f1806b = 0;

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributesImpl f1807a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public AudioAttributesCompat() {
    }

    public AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.f1807a = audioAttributesImpl;
    }

    public static int a(int i10, int i11) {
        if ((i10 & 1) == 1) {
            return 7;
        }
        if ((i10 & 4) == 4) {
            return 6;
        }
        switch (i11) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            default:
                return 3;
        }
    }

    public static AudioAttributesCompat f(AudioAttributes audioAttributes) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new AudioAttributesCompat(new AudioAttributesImplApi26(audioAttributes));
        }
        return new AudioAttributesCompat(new AudioAttributesImplApi21(audioAttributes));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesImpl audioAttributesImpl = this.f1807a;
        AudioAttributesImpl audioAttributesImpl2 = ((AudioAttributesCompat) obj).f1807a;
        return audioAttributesImpl == null ? audioAttributesImpl2 == null : audioAttributesImpl.equals(audioAttributesImpl2);
    }

    public final int hashCode() {
        return this.f1807a.hashCode();
    }

    public final String toString() {
        return this.f1807a.toString();
    }
}
