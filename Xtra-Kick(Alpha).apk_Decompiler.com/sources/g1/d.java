package g1;

import android.media.AudioAttributes;

public final class d {
    private d() {
    }

    public static void a(AudioAttributes.Builder builder, int i10) {
        builder.setAllowedCapturePolicy(i10);
    }
}
