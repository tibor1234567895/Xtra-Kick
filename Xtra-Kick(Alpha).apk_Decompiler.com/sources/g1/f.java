package g1;

import android.media.AudioAttributes;

public final class f {
    private f() {
    }

    public static void a(AudioAttributes.Builder builder, int i10) {
        builder.setSpatializationBehavior(i10);
    }
}
