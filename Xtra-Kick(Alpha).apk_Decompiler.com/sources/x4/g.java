package x4;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f16679a = Charset.forName("US-ASCII");

    static {
        Charset.forName("UTF-8");
    }

    private g() {
    }

    public static void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i10 = 0;
            while (i10 < length) {
                File file2 = listFiles[i10];
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (file2.delete()) {
                    i10++;
                } else {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}
