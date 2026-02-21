package com.github.andreyasadchy.xtra.model.chat;

import q0.f;
import xa.j;

public final class Image {
    private int end;
    private final Boolean isAnimated;
    private final boolean isEmote;
    private final boolean isZeroWidth;
    private int start;
    private final String type;
    private final String url1x;
    private final String url2x;
    private final String url3x;
    private final String url4x;

    public Image(String str, String str2, String str3, String str4, String str5, Boolean bool, boolean z10, int i10, int i11, boolean z11) {
        this.url1x = str;
        this.url2x = str2;
        this.url3x = str3;
        this.url4x = str4;
        this.type = str5;
        this.isAnimated = bool;
        this.isZeroWidth = z10;
        this.start = i10;
        this.end = i11;
        this.isEmote = z11;
    }

    public static /* synthetic */ Image copy$default(Image image, String str, String str2, String str3, String str4, String str5, Boolean bool, boolean z10, int i10, int i11, boolean z11, int i12, Object obj) {
        Image image2 = image;
        int i13 = i12;
        return image.copy((i13 & 1) != 0 ? image2.url1x : str, (i13 & 2) != 0 ? image2.url2x : str2, (i13 & 4) != 0 ? image2.url3x : str3, (i13 & 8) != 0 ? image2.url4x : str4, (i13 & 16) != 0 ? image2.type : str5, (i13 & 32) != 0 ? image2.isAnimated : bool, (i13 & 64) != 0 ? image2.isZeroWidth : z10, (i13 & 128) != 0 ? image2.start : i10, (i13 & 256) != 0 ? image2.end : i11, (i13 & 512) != 0 ? image2.isEmote : z11);
    }

    public final String component1() {
        return this.url1x;
    }

    public final boolean component10() {
        return this.isEmote;
    }

    public final String component2() {
        return this.url2x;
    }

    public final String component3() {
        return this.url3x;
    }

    public final String component4() {
        return this.url4x;
    }

    public final String component5() {
        return this.type;
    }

    public final Boolean component6() {
        return this.isAnimated;
    }

    public final boolean component7() {
        return this.isZeroWidth;
    }

    public final int component8() {
        return this.start;
    }

    public final int component9() {
        return this.end;
    }

    public final Image copy(String str, String str2, String str3, String str4, String str5, Boolean bool, boolean z10, int i10, int i11, boolean z11) {
        return new Image(str, str2, str3, str4, str5, bool, z10, i10, i11, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Image)) {
            return false;
        }
        Image image = (Image) obj;
        return j.a(this.url1x, image.url1x) && j.a(this.url2x, image.url2x) && j.a(this.url3x, image.url3x) && j.a(this.url4x, image.url4x) && j.a(this.type, image.type) && j.a(this.isAnimated, image.isAnimated) && this.isZeroWidth == image.isZeroWidth && this.start == image.start && this.end == image.end && this.isEmote == image.isEmote;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl1x() {
        return this.url1x;
    }

    public final String getUrl2x() {
        return this.url2x;
    }

    public final String getUrl3x() {
        return this.url3x;
    }

    public final String getUrl4x() {
        return this.url4x;
    }

    public int hashCode() {
        String str = this.url1x;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url2x;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url3x;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.url4x;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.type;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.isAnimated;
        if (bool != null) {
            i10 = bool.hashCode();
        }
        int i11 = (hashCode5 + i10) * 31;
        boolean z10 = this.isZeroWidth;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i12 = (((((i11 + (z10 ? 1 : 0)) * 31) + this.start) * 31) + this.end) * 31;
        boolean z12 = this.isEmote;
        if (!z12) {
            z11 = z12;
        }
        return i12 + (z11 ? 1 : 0);
    }

    public final Boolean isAnimated() {
        return this.isAnimated;
    }

    public final boolean isEmote() {
        return this.isEmote;
    }

    public final boolean isZeroWidth() {
        return this.isZeroWidth;
    }

    public final void setEnd(int i10) {
        this.end = i10;
    }

    public final void setStart(int i10) {
        this.start = i10;
    }

    public String toString() {
        String str = this.url1x;
        String str2 = this.url2x;
        String str3 = this.url3x;
        String str4 = this.url4x;
        String str5 = this.type;
        Boolean bool = this.isAnimated;
        boolean z10 = this.isZeroWidth;
        int i10 = this.start;
        int i11 = this.end;
        boolean z11 = this.isEmote;
        StringBuilder sb2 = new StringBuilder("Image(url1x=");
        sb2.append(str);
        sb2.append(", url2x=");
        sb2.append(str2);
        sb2.append(", url3x=");
        f.k(sb2, str3, ", url4x=", str4, ", type=");
        sb2.append(str5);
        sb2.append(", isAnimated=");
        sb2.append(bool);
        sb2.append(", isZeroWidth=");
        sb2.append(z10);
        sb2.append(", start=");
        sb2.append(i10);
        sb2.append(", end=");
        sb2.append(i11);
        sb2.append(", isEmote=");
        sb2.append(z11);
        sb2.append(")");
        return sb2.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Image(String str, String str2, String str3, String str4, String str5, Boolean bool, boolean z10, int i10, int i11, boolean z11, int i12, xa.f fVar) {
        this(str, str2, str3, str4, (i12 & 16) != 0 ? null : str5, (i12 & 32) != 0 ? null : bool, (i12 & 64) != 0 ? false : z10, i10, i11, z11);
    }
}
