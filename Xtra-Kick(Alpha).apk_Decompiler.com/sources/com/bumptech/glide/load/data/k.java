package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.Closeable;
import java.io.InputStream;

public final class k extends b {

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f3231l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(AssetManager assetManager, String str, int i10) {
        super(assetManager, str, 0);
        this.f3231l = i10;
    }

    public final Class a() {
        switch (this.f3231l) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    public final void b(Object obj) {
        switch (this.f3231l) {
            case 0:
                ((AssetFileDescriptor) obj).close();
                return;
            default:
                ((InputStream) obj).close();
                return;
        }
    }

    public final Closeable e(AssetManager assetManager, String str) {
        switch (this.f3231l) {
            case 0:
                return assetManager.openFd(str);
            default:
                return assetManager.open(str);
        }
    }
}
