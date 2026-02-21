package p1;

import android.support.v4.media.h;
import java.io.IOException;

public final class d extends IOException {
    public /* synthetic */ d() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i10, int i11) {
        this(i10, "Http request failed", (IOException) null);
        if (i11 == 2) {
        }
    }

    public d(int i10, String str, IOException iOException) {
        super(str + ", status code: " + i10, iOException);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(String str, int i10) {
        super(h.n("Unable to bind a sample queue to TrackGroup with mime type ", str, "."));
        if (i10 != 2) {
        } else {
            super(str);
        }
    }

    public d(Throwable th) {
        super(th);
    }
}
