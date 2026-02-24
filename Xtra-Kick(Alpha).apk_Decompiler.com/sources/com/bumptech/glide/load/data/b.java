package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import b5.a;
import com.bumptech.glide.j;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class b implements e {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3217h;

    /* renamed from: i  reason: collision with root package name */
    public Object f3218i;

    /* renamed from: j  reason: collision with root package name */
    public final Comparable f3219j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f3220k;

    public /* synthetic */ b(Object obj, Comparable comparable, int i10) {
        this.f3217h = i10;
        this.f3220k = obj;
        this.f3219j = comparable;
    }

    public abstract void b(Object obj);

    public final void c() {
        switch (this.f3217h) {
            case 0:
                Object obj = this.f3218i;
                if (obj != null) {
                    try {
                        b(obj);
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                } else {
                    return;
                }
            default:
                Object obj2 = this.f3218i;
                if (obj2 != null) {
                    try {
                        b(obj2);
                        return;
                    } catch (IOException unused2) {
                        return;
                    }
                } else {
                    return;
                }
        }
    }

    public final void cancel() {
    }

    public final a d() {
        return a.LOCAL;
    }

    public abstract Closeable e(AssetManager assetManager, String str);

    public final void f(j jVar, d dVar) {
        int i10 = this.f3217h;
        Comparable comparable = this.f3219j;
        Object obj = this.f3220k;
        switch (i10) {
            case 0:
                try {
                    Closeable e10 = e((AssetManager) obj, (String) comparable);
                    this.f3218i = e10;
                    dVar.g(e10);
                    return;
                } catch (IOException e11) {
                    Log.isLoggable("AssetPathFetcher", 3);
                    dVar.e(e11);
                    return;
                }
            default:
                try {
                    Object g10 = g((ContentResolver) obj, (Uri) comparable);
                    this.f3218i = g10;
                    dVar.g(g10);
                    return;
                } catch (FileNotFoundException e12) {
                    Log.isLoggable("LocalUriFetcher", 3);
                    dVar.e(e12);
                    return;
                }
        }
    }

    public abstract Object g(ContentResolver contentResolver, Uri uri);
}
