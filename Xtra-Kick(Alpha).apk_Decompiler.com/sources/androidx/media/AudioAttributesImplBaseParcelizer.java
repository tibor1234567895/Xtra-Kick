package androidx.media;

import d4.c;

public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(c cVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f1810a = cVar.f(audioAttributesImplBase.f1810a, 1);
        audioAttributesImplBase.f1811b = cVar.f(audioAttributesImplBase.f1811b, 2);
        audioAttributesImplBase.f1812c = cVar.f(audioAttributesImplBase.f1812c, 3);
        audioAttributesImplBase.f1813d = cVar.f(audioAttributesImplBase.f1813d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, c cVar) {
        cVar.getClass();
        cVar.j(audioAttributesImplBase.f1810a, 1);
        cVar.j(audioAttributesImplBase.f1811b, 2);
        cVar.j(audioAttributesImplBase.f1812c, 3);
        cVar.j(audioAttributesImplBase.f1813d, 4);
    }
}
