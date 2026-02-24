package j0;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.media.h;
import androidx.appcompat.widget.b0;
import d0.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8381a = new a(0);

    private c() {
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [j0.i[], android.database.Cursor] */
    public static h a(Context context, b0 b0Var) {
        Cursor cursor;
        int i10;
        int i11;
        Uri uri;
        int i12;
        boolean z10;
        boolean z11;
        b0 b0Var2 = b0Var;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = (String) b0Var2.f731c;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider != null) {
            String str2 = resolveContentProvider.packageName;
            String str3 = (String) b0Var2.f732d;
            if (str2.equals(str3)) {
                Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
                ArrayList arrayList = new ArrayList();
                for (Signature byteArray : signatureArr) {
                    arrayList.add(byteArray.toByteArray());
                }
                a aVar = f8381a;
                Collections.sort(arrayList, aVar);
                List list = (List) b0Var2.f734f;
                if (list == null) {
                    list = j.b(resources, b0Var2.f730b);
                }
                int i13 = 0;
                while (true) {
                    cursor = 0;
                    if (i13 >= list.size()) {
                        resolveContentProvider = cursor;
                        break;
                    }
                    ArrayList arrayList2 = new ArrayList((Collection) list.get(i13));
                    Collections.sort(arrayList2, aVar);
                    if (arrayList.size() == arrayList2.size()) {
                        int i14 = 0;
                        while (true) {
                            if (i14 >= arrayList.size()) {
                                z11 = true;
                                break;
                            } else if (!Arrays.equals((byte[]) arrayList.get(i14), (byte[]) arrayList2.get(i14))) {
                                break;
                            } else {
                                i14++;
                            }
                        }
                    }
                    z11 = false;
                    if (z11) {
                        break;
                    }
                    i13++;
                }
                if (resolveContentProvider == null) {
                    return new h(1, (i[]) cursor);
                }
                String str4 = resolveContentProvider.authority;
                ArrayList arrayList3 = new ArrayList();
                Uri build = new Uri.Builder().scheme("content").authority(str4).build();
                Uri build2 = new Uri.Builder().scheme("content").authority(str4).appendPath("file").build();
                try {
                    cursor = b.a(context.getContentResolver(), build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{(String) b0Var2.f733e}, (String) null, (Object) null);
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("result_code");
                        arrayList3 = new ArrayList();
                        int columnIndex2 = cursor.getColumnIndex("_id");
                        int columnIndex3 = cursor.getColumnIndex("file_id");
                        int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursor.getColumnIndex("font_weight");
                        int columnIndex6 = cursor.getColumnIndex("font_italic");
                        while (cursor.moveToNext()) {
                            if (columnIndex != -1) {
                                i10 = cursor.getInt(columnIndex);
                            } else {
                                i10 = 0;
                            }
                            if (columnIndex4 != -1) {
                                i11 = cursor.getInt(columnIndex4);
                            } else {
                                i11 = 0;
                            }
                            if (columnIndex3 == -1) {
                                uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                            } else {
                                uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                            }
                            Uri uri2 = uri;
                            if (columnIndex5 != -1) {
                                i12 = cursor.getInt(columnIndex5);
                            } else {
                                i12 = 400;
                            }
                            if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                                z10 = false;
                            } else {
                                z10 = true;
                            }
                            arrayList3.add(new i(uri2, i11, i12, z10, i10));
                        }
                    }
                    return new h(0, (i[]) arrayList3.toArray(new i[0]));
                } finally {
                    if (cursor != 0) {
                        cursor.close();
                    }
                }
            } else {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str3);
            }
        } else {
            throw new PackageManager.NameNotFoundException(h.m("No package found for authority: ", str));
        }
    }
}
