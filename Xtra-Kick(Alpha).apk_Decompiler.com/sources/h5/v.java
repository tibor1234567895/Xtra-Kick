package h5;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class v implements u {
    public final Class a() {
        return InputStream.class;
    }

    public final Object b(File file) {
        return new FileInputStream(file);
    }

    public final void c(Object obj) {
        ((InputStream) obj).close();
    }
}
