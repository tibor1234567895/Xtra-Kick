package com.bumptech.glide.load.data;

import e5.k;
import java.io.InputStream;

public final class n implements f {

    /* renamed from: a  reason: collision with root package name */
    public final k f3239a;

    public n(k kVar) {
        this.f3239a = kVar;
    }

    public final Class a() {
        return InputStream.class;
    }

    public final g b(Object obj) {
        return new p((InputStream) obj, this.f3239a);
    }
}
