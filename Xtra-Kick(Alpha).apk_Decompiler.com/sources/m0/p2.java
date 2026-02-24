package m0;

import android.view.WindowInsets;

public final class p2 {
    private p2() {
    }

    public static int a(int i10) {
        int i11;
        int i12 = 0;
        for (int i13 = 1; i13 <= 256; i13 <<= 1) {
            if ((i10 & i13) != 0) {
                if (i13 == 1) {
                    i11 = WindowInsets.Type.statusBars();
                } else if (i13 == 2) {
                    i11 = WindowInsets.Type.navigationBars();
                } else if (i13 == 4) {
                    i11 = WindowInsets.Type.captionBar();
                } else if (i13 == 8) {
                    i11 = WindowInsets.Type.ime();
                } else if (i13 == 16) {
                    i11 = WindowInsets.Type.systemGestures();
                } else if (i13 == 32) {
                    i11 = WindowInsets.Type.mandatorySystemGestures();
                } else if (i13 == 64) {
                    i11 = WindowInsets.Type.tappableElement();
                } else if (i13 == 128) {
                    i11 = WindowInsets.Type.displayCutout();
                }
                i12 |= i11;
            }
        }
        return i12;
    }
}
