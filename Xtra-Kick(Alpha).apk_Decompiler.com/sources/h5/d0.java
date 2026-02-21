package h5;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import b5.a;
import com.bumptech.glide.j;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import java.io.File;
import java.io.FileNotFoundException;

public final class d0 implements e {

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f7563j = {"_data"};

    /* renamed from: h  reason: collision with root package name */
    public final Context f7564h;

    /* renamed from: i  reason: collision with root package name */
    public final Uri f7565i;

    public d0(Context context, Uri uri) {
        this.f7564h = context;
        this.f7565i = uri;
    }

    public final Class a() {
        return File.class;
    }

    public final void c() {
    }

    public final void cancel() {
    }

    public final a d() {
        return a.LOCAL;
    }

    public final void f(j jVar, d dVar) {
        Cursor query = this.f7564h.getContentResolver().query(this.f7565i, f7563j, (String) null, (String[]) null, (String) null);
        String str = null;
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str = query.getString(query.getColumnIndexOrThrow("_data"));
                }
            } finally {
                query.close();
            }
        }
        if (TextUtils.isEmpty(str)) {
            dVar.e(new FileNotFoundException("Failed to find file path for: " + this.f7565i));
            return;
        }
        dVar.g(new File(str));
    }
}
