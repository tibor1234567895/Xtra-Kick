package androidx.media;

import android.media.AudioAttributes;

public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f1808a;

    /* renamed from: b  reason: collision with root package name */
    public int f1809b = -1;

    public AudioAttributesImplApi21() {
    }

    public final int b() {
        return this.f1808a.getFlags();
    }

    public final int c() {
        int i10 = this.f1809b;
        return i10 != -1 ? i10 : AudioAttributesCompat.a(b(), d());
    }

    public final int d() {
        return this.f1808a.getUsage();
    }

    public final int e() {
        return this.f1808a.getContentType();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f1808a.equals(((AudioAttributesImplApi21) obj).f1808a);
    }

    public final int hashCode() {
        return this.f1808a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f1808a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this.f1808a = audioAttributes;
    }
}
