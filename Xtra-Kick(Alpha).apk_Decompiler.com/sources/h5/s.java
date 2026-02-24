package h5;

import android.os.ParcelFileDescriptor;
import java.io.File;

public final class s implements u {
    public final Class a() {
        return ParcelFileDescriptor.class;
    }

    public final Object b(File file) {
        return ParcelFileDescriptor.open(file, 268435456);
    }

    public final void c(Object obj) {
        ((ParcelFileDescriptor) obj).close();
    }
}
