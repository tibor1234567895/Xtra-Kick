package e0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import d0.g;
import d0.h;
import j0.i;
import java.io.IOException;
import java.io.InputStream;

public final class p extends r {
    public static Font g(FontFamily fontFamily, int i10) {
        b.D();
        FontStyle p10 = b.p((i10 & 1) != 0 ? 700 : 400, (i10 & 2) != 0 ? 1 : 0);
        Font l10 = fontFamily.getFont(0);
        int h10 = h(p10, l10.getStyle());
        for (int i11 = 1; i11 < fontFamily.getSize(); i11++) {
            Font m10 = fontFamily.getFont(i11);
            int h11 = h(p10, m10.getStyle());
            if (h11 < h10) {
                l10 = m10;
                h10 = h11;
            }
        }
        return l10;
    }

    public static int h(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    public final Typeface a(Context context, g gVar, Resources resources, int i10) {
        int i11;
        try {
            FontFamily.Builder builder = null;
            for (h hVar : gVar.f4093a) {
                try {
                    b.s();
                    Font.Builder h10 = b.g(resources, hVar.f4099f).setWeight(hVar.f4095b);
                    if (hVar.f4096c) {
                        i11 = 1;
                    } else {
                        i11 = 0;
                    }
                    Font k10 = h10.setSlant(i11).setTtcIndex(hVar.f4098e).setFontVariationSettings(hVar.f4097d).build();
                    if (builder == null) {
                        b.A();
                        builder = b.n(k10);
                    } else {
                        builder.addFont(k10);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily o10 = builder.build();
            b.C();
            return b.e(o10).setStyle(g(o10, i10).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    public final Typeface b(Context context, i[] iVarArr, int i10) {
        ParcelFileDescriptor openFileDescriptor;
        int i11;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (i iVar : iVarArr) {
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(iVar.f8397a, "r", (CancellationSignal) null);
                    if (openFileDescriptor != null) {
                        b.s();
                        Font.Builder h10 = b.j(openFileDescriptor).setWeight(iVar.f8399c);
                        if (iVar.f8400d) {
                            i11 = 1;
                        } else {
                            i11 = 0;
                        }
                        Font k10 = h10.setSlant(i11).setTtcIndex(iVar.f8398b).build();
                        if (builder == null) {
                            b.A();
                            builder = b.n(k10);
                        } else {
                            builder.addFont(k10);
                        }
                    } else if (openFileDescriptor == null) {
                    }
                    openFileDescriptor.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily o10 = builder.build();
            b.C();
            return b.e(o10).setStyle(g(o10, i10).getStyle()).build();
            throw th;
        } catch (Exception unused2) {
            return null;
        }
    }

    public final Typeface c(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    public final Typeface d(Context context, Resources resources, int i10, String str, int i11) {
        try {
            b.s();
            Font k10 = b.g(resources, i10).build();
            b.A();
            FontFamily o10 = b.n(k10).build();
            b.C();
            return b.e(o10).setStyle(k10.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    public final i f(int i10, i[] iVarArr) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
