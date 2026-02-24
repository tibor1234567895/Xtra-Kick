package com.bumptech.glide.integration.webp;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f3199a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3200b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3201c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3202d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3203e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3204f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3205g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3206h;

    public a(int i10, WebpFrame webpFrame) {
        this.f3199a = i10;
        this.f3200b = webpFrame.getXOffest();
        this.f3201c = webpFrame.getYOffest();
        this.f3202d = webpFrame.getWidth();
        this.f3203e = webpFrame.getHeight();
        this.f3204f = webpFrame.getDurationMs();
        this.f3205g = webpFrame.isBlendWithPreviousFrame();
        this.f3206h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public final String toString() {
        return "frameNumber=" + this.f3199a + ", xOffset=" + this.f3200b + ", yOffset=" + this.f3201c + ", width=" + this.f3202d + ", height=" + this.f3203e + ", duration=" + this.f3204f + ", blendPreviousFrame=" + this.f3205g + ", disposeBackgroundColor=" + this.f3206h;
    }
}
