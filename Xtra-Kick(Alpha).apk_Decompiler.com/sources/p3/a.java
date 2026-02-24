package p3;

import java.io.File;

public final class a {
    private a() {
    }

    public static boolean a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            int length = listFiles.length;
            boolean z10 = true;
            for (int i10 = 0; i10 < length; i10++) {
                z10 = a(listFiles[i10]) && z10;
            }
            return z10;
        }
        file.delete();
        return true;
    }
}
