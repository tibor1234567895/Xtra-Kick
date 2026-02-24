package androidx.media;

import d4.c;

public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(c cVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        Object obj = audioAttributesCompat.f1807a;
        if (cVar.e(1)) {
            obj = cVar.h();
        }
        audioAttributesCompat.f1807a = (AudioAttributesImpl) obj;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, c cVar) {
        cVar.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f1807a;
        cVar.i(1);
        cVar.l(audioAttributesImpl);
    }
}
