package c5;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

public final class d implements f {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f2960b = {"_data"};

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f2961a;

    public d(ContentResolver contentResolver) {
        this.f2961a = contentResolver;
    }

    public final Cursor a(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        return this.f2961a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f2960b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
    }
}
