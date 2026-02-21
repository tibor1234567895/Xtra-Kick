package androidx.media;

import android.media.AudioAttributes;
import d4.c;

public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(c cVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f1808a = (AudioAttributes) cVar.g(audioAttributesImplApi26.f1808a, 1);
        audioAttributesImplApi26.f1809b = cVar.f(audioAttributesImplApi26.f1809b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, c cVar) {
        cVar.getClass();
        cVar.k(audioAttributesImplApi26.f1808a, 1);
        cVar.j(audioAttributesImplApi26.f1809b, 2);
    }
}
