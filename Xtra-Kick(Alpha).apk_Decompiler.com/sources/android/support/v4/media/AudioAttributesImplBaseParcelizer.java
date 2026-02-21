package android.support.v4.media;

import androidx.media.AudioAttributesImplBase;
import d4.c;

public final class AudioAttributesImplBaseParcelizer extends androidx.media.AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(c cVar) {
        return androidx.media.AudioAttributesImplBaseParcelizer.read(cVar);
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, c cVar) {
        androidx.media.AudioAttributesImplBaseParcelizer.write(audioAttributesImplBase, cVar);
    }
}
