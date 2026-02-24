package android.support.v4.media;

import androidx.media.AudioAttributesCompat;
import d4.c;

public final class AudioAttributesCompatParcelizer extends androidx.media.AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(c cVar) {
        return androidx.media.AudioAttributesCompatParcelizer.read(cVar);
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, c cVar) {
        androidx.media.AudioAttributesCompatParcelizer.write(audioAttributesCompat, cVar);
    }
}
