package com.bumptech.glide.load;

import b5.e;

public enum ImageHeaderParser$ImageType {
    GIF("GIF"),
    JPEG("JPEG"),
    RAW("RAW"),
    PNG_A("PNG_A"),
    PNG("PNG"),
    WEBP_A("WEBP_A"),
    WEBP("WEBP"),
    ANIMATED_WEBP("ANIMATED_WEBP"),
    AVIF("AVIF"),
    ANIMATED_AVIF("ANIMATED_AVIF"),
    UNKNOWN("UNKNOWN");
    

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3214h;

    /* access modifiers changed from: public */
    ImageHeaderParser$ImageType(String str) {
        this.f3214h = r1;
    }

    public boolean hasAlpha() {
        return this.f3214h;
    }

    public boolean isWebp() {
        int i10 = e.f2626a[ordinal()];
        return i10 == 1 || i10 == 2 || i10 == 3;
    }
}
