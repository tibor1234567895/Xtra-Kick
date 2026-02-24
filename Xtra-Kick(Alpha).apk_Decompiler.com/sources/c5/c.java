package c5;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

public final class c implements f {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f2958b = {"_data"};

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f2959a;

    public c(ContentResolver contentResolver) {
        this.f2959a = contentResolver;
    }

    public final Cursor a(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        return this.f2959a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f2958b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
    }
}
