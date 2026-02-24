package c5;

import android.net.Uri;

public final class b {
    private b() {
    }

    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
}
