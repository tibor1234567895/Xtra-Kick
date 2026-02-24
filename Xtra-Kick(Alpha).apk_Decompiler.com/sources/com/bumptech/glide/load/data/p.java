package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import e5.k;
import java.io.InputStream;
import k5.e0;

public final class p implements g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3240a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Object f3241b;

    public p(ParcelFileDescriptor parcelFileDescriptor) {
        this.f3241b = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public final ParcelFileDescriptor a() {
        return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f3241b).rewind();
    }

    public final void c() {
        switch (this.f3240a) {
            case 0:
            case 1:
                return;
            default:
                ((e0) this.f3241b).e();
                return;
        }
    }

    public final Object e() {
        int i10 = this.f3240a;
        Object obj = this.f3241b;
        switch (i10) {
            case 0:
                return a();
            case 1:
                return obj;
            default:
                e0 e0Var = (e0) obj;
                e0Var.reset();
                return e0Var;
        }
    }

    public p(InputStream inputStream, k kVar) {
        e0 e0Var = new e0(inputStream, kVar);
        this.f3241b = e0Var;
        e0Var.mark(5242880);
    }

    public p(Object obj) {
        this.f3241b = obj;
    }
}
