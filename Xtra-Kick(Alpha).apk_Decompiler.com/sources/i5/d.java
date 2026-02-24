package i5;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public final class d extends c {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, int i10) {
        super(context, ParcelFileDescriptor.class);
        if (i10 != 1) {
        } else {
            super(context, InputStream.class);
        }
    }
}
