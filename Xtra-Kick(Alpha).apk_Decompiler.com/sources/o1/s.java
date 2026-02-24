package o1;

import android.media.AudioTrack;

public final class s {
    private s() {
    }

    public static void a(AudioTrack audioTrack, u uVar) {
        audioTrack.setPreferredDevice(uVar == null ? null : uVar.f12039a);
    }
}
