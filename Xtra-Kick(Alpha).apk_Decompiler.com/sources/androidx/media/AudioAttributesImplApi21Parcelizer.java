package androidx.media;

import android.media.AudioAttributes;
import d4.c;

public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(c cVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f1808a = (AudioAttributes) cVar.g(audioAttributesImplApi21.f1808a, 1);
        audioAttributesImplApi21.f1809b = cVar.f(audioAttributesImplApi21.f1809b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, c cVar) {
        cVar.getClass();
        cVar.k(audioAttributesImplApi21.f1808a, 1);
        cVar.j(audioAttributesImplApi21.f1809b, 2);
    }
}
