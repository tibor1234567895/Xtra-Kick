package c0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

public final class c {
    private c() {
    }

    public static File a(Context context) {
        return context.getCodeCacheDir();
    }

    public static Drawable b(Context context, int i10) {
        return context.getDrawable(i10);
    }

    public static File c(Context context) {
        return context.getNoBackupFilesDir();
    }
}
