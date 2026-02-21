package f0;

import android.graphics.drawable.Icon;
import android.net.Uri;

public final class j {
    private j() {
    }

    public static Icon a(Uri uri) {
        return Icon.createWithAdaptiveBitmapContentUri(uri);
    }
}
