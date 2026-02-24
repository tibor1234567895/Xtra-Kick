package androidx.media;

import android.support.v4.media.h;
import java.util.Arrays;

public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public int f1810a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f1811b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1812c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f1813d = -1;

    public final int b() {
        int i10 = this.f1812c;
        int c10 = c();
        if (c10 == 6) {
            i10 |= 4;
        } else if (c10 == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public final int c() {
        int i10 = this.f1813d;
        return i10 != -1 ? i10 : AudioAttributesCompat.a(this.f1812c, this.f1810a);
    }

    public final int d() {
        return this.f1810a;
    }

    public final int e() {
        return this.f1811b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f1811b == audioAttributesImplBase.f1811b && this.f1812c == audioAttributesImplBase.b() && this.f1810a == audioAttributesImplBase.f1810a && this.f1813d == audioAttributesImplBase.f1813d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1811b), Integer.valueOf(this.f1812c), Integer.valueOf(this.f1810a), Integer.valueOf(this.f1813d)});
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f1813d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f1813d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        int i10 = this.f1810a;
        int i11 = AudioAttributesCompat.f1806b;
        switch (i10) {
            case 0:
                str = "USAGE_UNKNOWN";
                break;
            case 1:
                str = "USAGE_MEDIA";
                break;
            case 2:
                str = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                str = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                str = "USAGE_ALARM";
                break;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                str = "USAGE_NOTIFICATION";
                break;
            case 6:
                str = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                str = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                str = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                str = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                str = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                str = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                str = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                str = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                str = "USAGE_GAME";
                break;
            case Constants.IV_SIZE /*16*/:
                str = "USAGE_ASSISTANT";
                break;
            default:
                str = h.i("unknown usage ", i10);
                break;
        }
        sb2.append(str);
        sb2.append(" content=");
        sb2.append(this.f1811b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f1812c).toUpperCase());
        return sb2.toString();
    }
}
