package h3;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.x;
import android.support.v4.media.z;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.media.AudioAttributesCompat;
import d9.r0;
import e1.a;
import e1.c;
import e1.h;
import g1.a2;
import g1.c1;
import g1.d0;
import g1.d1;
import g1.f0;
import g1.f1;
import g1.g1;
import g1.j1;
import g1.k1;
import g1.l1;
import g1.m1;
import g1.o0;
import g1.p0;
import g1.p1;
import g1.s0;
import g1.u0;
import g1.u1;
import g1.v0;
import g1.y;
import h9.e0;
import j1.d;
import j1.l0;
import j1.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class t3 {

    /* renamed from: a  reason: collision with root package name */
    public static final h f7332a = new h((Bundle) null, "androidx.media3.session.MediaLibraryService");

    private t3() {
    }

    public static void A(k1 k1Var, f2 f2Var) {
        int i10 = f2Var.f7024b;
        r0 r0Var = f2Var.f7023a;
        if (i10 != -1) {
            boolean L0 = k1Var.L0(20);
            long j10 = f2Var.f7025c;
            if (L0) {
                k1Var.K0(f2Var.f7024b, j10, r0Var);
            } else if (!r0Var.isEmpty()) {
                k1Var.y0((s0) r0Var.get(0), j10);
            }
        } else if (k1Var.L0(20)) {
            k1Var.C(r0Var);
        } else if (!r0Var.isEmpty()) {
            k1Var.b0((s0) r0Var.get(0));
        }
    }

    public static boolean a(i4 i4Var, i4 i4Var2) {
        j1 j1Var = i4Var.f7117h;
        int i10 = j1Var.f6431i;
        j1 j1Var2 = i4Var2.f7117h;
        return i10 == j1Var2.f6431i && j1Var.f6434l == j1Var2.f6434l && j1Var.f6437o == j1Var2.f6437o && j1Var.f6438p == j1Var2.f6438p;
    }

    public static int b(long j10, long j11) {
        if (j10 == -9223372036854775807L || j11 == -9223372036854775807L) {
            return 0;
        }
        if (j11 == 0) {
            return 100;
        }
        return l0.h((int) ((j10 * 100) / j11), 0, 100);
    }

    public static long c(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j10) {
        long j11 = playbackStateCompat == null ? 0 : playbackStateCompat.f361j;
        long e10 = e(playbackStateCompat, mediaMetadataCompat, j10);
        long f10 = f(mediaMetadataCompat);
        return f10 == -9223372036854775807L ? Math.max(e10, j11) : l0.i(j11, e10, f10);
    }

    public static byte[] d(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static long e(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j10) {
        Long l10;
        long j11;
        PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
        if (playbackStateCompat2 == null) {
            return 0;
        }
        long j12 = playbackStateCompat2.f360i;
        if (playbackStateCompat2.f359h == 3) {
            if (j10 == -9223372036854775807L) {
                l10 = null;
            } else {
                l10 = Long.valueOf(j10);
            }
            if (l10 != null) {
                j11 = l10.longValue();
            } else {
                j11 = SystemClock.elapsedRealtime() - playbackStateCompat2.f366o;
            }
            j12 = Math.max(0, j12 + ((long) (playbackStateCompat2.f362k * ((float) j11))));
        }
        long j13 = j12;
        long f10 = f(mediaMetadataCompat);
        if (f10 == -9223372036854775807L) {
            return Math.max(0, j13);
        }
        return l0.i(j13, 0, f10);
    }

    public static long f(MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null || !mediaMetadataCompat.u("android.media.metadata.DURATION")) {
            return -9223372036854775807L;
        }
        long w10 = mediaMetadataCompat.w("android.media.metadata.DURATION");
        if (w10 <= 0) {
            return -9223372036854775807L;
        }
        return w10;
    }

    public static long g(int i10) {
        switch (i10) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case Constants.MAX_COMPATIBILITY_VERSION:
                return 5;
            case 6:
                return 6;
            default:
                throw new IllegalArgumentException(android.support.v4.media.h.i("Unrecognized FolderType: ", i10));
        }
    }

    public static int h(long j10) {
        if (j10 == 0) {
            return 0;
        }
        if (j10 == 1) {
            return 1;
        }
        if (j10 == 2) {
            return 2;
        }
        if (j10 == 3) {
            return 3;
        }
        if (j10 == 4) {
            return 4;
        }
        if (j10 == 5) {
            return 5;
        }
        return j10 == 6 ? 6 : 0;
    }

    public static MediaDescriptionCompat i(s0 s0Var, Bitmap bitmap) {
        String str;
        boolean z10;
        x xVar = new x();
        if (s0Var.f6556h.equals("")) {
            str = null;
        } else {
            str = s0Var.f6556h;
        }
        xVar.f439a = str;
        if (bitmap != null) {
            xVar.f443e = bitmap;
        }
        v0 v0Var = s0Var.f6559k;
        Bundle bundle = v0Var.O;
        boolean z11 = false;
        Integer num = v0Var.f6665v;
        if (num == null || num.intValue() == -1) {
            z10 = false;
        } else {
            z10 = true;
        }
        Integer num2 = v0Var.N;
        if (num2 != null) {
            z11 = true;
        }
        if (z10 || z11) {
            if (bundle == null) {
                bundle = new Bundle();
            } else {
                bundle = new Bundle(bundle);
            }
            if (z10) {
                num.getClass();
                bundle.putLong("android.media.extra.BT_FOLDER_TYPE", g(num.intValue()));
            }
            if (z11) {
                num2.getClass();
                bundle.putLong("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT", (long) num2.intValue());
            }
        }
        xVar.f440b = v0Var.f6651h;
        CharSequence charSequence = v0Var.f6652i;
        if (charSequence == null) {
            charSequence = v0Var.f6656m;
        }
        xVar.f441c = charSequence;
        xVar.f442d = v0Var.f6657n;
        xVar.f444f = v0Var.f6662s;
        xVar.f446h = s0Var.f6561m.f6506h;
        xVar.f445g = bundle;
        return new MediaDescriptionCompat(xVar.f439a, xVar.f440b, xVar.f441c, xVar.f442d, xVar.f443e, xVar.f444f, xVar.f445g, xVar.f446h);
    }

    public static s0 j(MediaDescriptionCompat mediaDescriptionCompat) {
        mediaDescriptionCompat.getClass();
        f0 f0Var = new f0();
        String str = mediaDescriptionCompat.f299h;
        if (str == null) {
            str = "";
        }
        f0Var.f6358a = str;
        o0 o0Var = new o0();
        o0Var.f6495a = mediaDescriptionCompat.f306o;
        f0Var.f6369l = new p0(o0Var);
        f0Var.f6367j = l(mediaDescriptionCompat, 0);
        return f0Var.a();
    }

    public static s0 k(String str, MediaMetadataCompat mediaMetadataCompat, int i10) {
        String str2;
        f0 f0Var = new f0();
        if (str != null) {
            f0Var.f6358a = str;
        }
        CharSequence charSequence = mediaMetadataCompat.f309h.getCharSequence("android.media.metadata.MEDIA_URI");
        if (charSequence != null) {
            str2 = charSequence.toString();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            o0 o0Var = new o0();
            o0Var.f6495a = Uri.parse(str2);
            f0Var.f6369l = new p0(o0Var);
        }
        f0Var.f6367j = m(mediaMetadataCompat, i10);
        return f0Var.a();
    }

    public static v0 l(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        byte[] bArr;
        if (mediaDescriptionCompat == null) {
            return v0.P;
        }
        u0 u0Var = new u0();
        u0Var.f6596a = mediaDescriptionCompat.f300i;
        u0Var.f6601f = mediaDescriptionCompat.f301j;
        u0Var.f6602g = mediaDescriptionCompat.f302k;
        u0Var.f6607l = mediaDescriptionCompat.f304m;
        u0Var.f6603h = q(RatingCompat.y(i10));
        Bundle bundle = null;
        Bitmap bitmap = mediaDescriptionCompat.f303l;
        if (bitmap != null) {
            try {
                bArr = d(bitmap);
            } catch (IOException e10) {
                v.h("MediaUtils", "Failed to convert iconBitmap to artworkData", e10);
                bArr = null;
            }
            u0Var.b(bArr, 3);
        }
        Bundle bundle2 = mediaDescriptionCompat.f305n;
        if (bundle2 != null) {
            bundle = new Bundle(bundle2);
        }
        if (bundle != null && bundle.containsKey("android.media.extra.BT_FOLDER_TYPE")) {
            u0Var.f6610o = Integer.valueOf(h(bundle.getLong("android.media.extra.BT_FOLDER_TYPE")));
            bundle.remove("android.media.extra.BT_FOLDER_TYPE");
        }
        u0Var.f6611p = Boolean.FALSE;
        if (bundle != null && bundle.containsKey("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")) {
            u0Var.F = Integer.valueOf((int) bundle.getLong("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT"));
            bundle.remove("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
        }
        if (bundle != null && !bundle.isEmpty()) {
            u0Var.G = bundle;
        }
        u0Var.f6612q = Boolean.TRUE;
        return new v0(u0Var);
    }

    public static v0 m(MediaMetadataCompat mediaMetadataCompat, int i10) {
        Bitmap bitmap;
        CharSequence charSequence;
        RatingCompat ratingCompat;
        RatingCompat ratingCompat2;
        String str;
        if (mediaMetadataCompat == null) {
            return v0.P;
        }
        Bundle bundle = mediaMetadataCompat.f309h;
        u0 u0Var = new u0();
        String[] strArr = {"android.media.metadata.DISPLAY_TITLE", "android.media.metadata.TITLE"};
        int i11 = 0;
        int i12 = 0;
        while (true) {
            bitmap = null;
            if (i12 >= 2) {
                charSequence = null;
                break;
            }
            String str2 = strArr[i12];
            if (mediaMetadataCompat.u(str2)) {
                charSequence = mediaMetadataCompat.x(str2);
                break;
            }
            i12++;
        }
        u0Var.f6596a = charSequence;
        u0Var.f6601f = mediaMetadataCompat.x("android.media.metadata.DISPLAY_SUBTITLE");
        u0Var.f6602g = mediaMetadataCompat.x("android.media.metadata.DISPLAY_DESCRIPTION");
        u0Var.f6597b = mediaMetadataCompat.x("android.media.metadata.ARTIST");
        u0Var.f6598c = mediaMetadataCompat.x("android.media.metadata.ALBUM");
        u0Var.f6599d = mediaMetadataCompat.x("android.media.metadata.ALBUM_ARTIST");
        try {
            ratingCompat = RatingCompat.u(bundle.getParcelable("android.media.metadata.RATING"));
        } catch (Exception e10) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e10);
            ratingCompat = null;
        }
        u0Var.f6604i = q(ratingCompat);
        try {
            ratingCompat2 = RatingCompat.u(bundle.getParcelable("android.media.metadata.USER_RATING"));
        } catch (Exception e11) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e11);
            ratingCompat2 = null;
        }
        l1 q10 = q(ratingCompat2);
        if (q10 != null) {
            u0Var.f6603h = q10;
        } else {
            u0Var.f6603h = q(RatingCompat.y(i10));
        }
        if (mediaMetadataCompat.u("android.media.metadata.YEAR")) {
            u0Var.f6613r = Integer.valueOf((int) mediaMetadataCompat.w("android.media.metadata.YEAR"));
        }
        String[] strArr2 = {"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ALBUM_ART_URI"};
        int i13 = 0;
        while (true) {
            if (i13 >= 2) {
                break;
            }
            String str3 = strArr2[i13];
            if (mediaMetadataCompat.u(str3)) {
                CharSequence charSequence2 = bundle.getCharSequence(str3);
                if (charSequence2 != null) {
                    str = charSequence2.toString();
                }
            } else {
                i13++;
            }
        }
        str = null;
        if (str != null) {
            u0Var.f6607l = Uri.parse(str);
        }
        String[] strArr3 = {"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ALBUM_ART"};
        while (true) {
            if (i11 >= 2) {
                break;
            }
            String str4 = strArr3[i11];
            if (mediaMetadataCompat.u(str4)) {
                try {
                    bitmap = (Bitmap) bundle.getParcelable(str4);
                    break;
                } catch (Exception e12) {
                    Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e12);
                }
            } else {
                i11++;
            }
        }
        if (bitmap != null) {
            try {
                u0Var.b(d(bitmap), 3);
            } catch (IOException e13) {
                v.h("MediaUtils", "Failed to convert artworkBitmap to artworkData", e13);
            }
        }
        boolean u10 = mediaMetadataCompat.u("android.media.metadata.BT_FOLDER_TYPE");
        u0Var.f6611p = Boolean.valueOf(u10);
        if (u10) {
            u0Var.f6610o = Integer.valueOf(h(mediaMetadataCompat.w("android.media.metadata.BT_FOLDER_TYPE")));
        }
        if (mediaMetadataCompat.u("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")) {
            u0Var.F = Integer.valueOf((int) mediaMetadataCompat.w("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT"));
        }
        u0Var.f6612q = Boolean.TRUE;
        return new v0(u0Var);
    }

    public static MediaMetadataCompat n(v0 v0Var, String str, Uri uri, long j10, Bitmap bitmap) {
        z zVar = new z();
        zVar.d("android.media.metadata.MEDIA_ID", str);
        CharSequence charSequence = v0Var.f6651h;
        if (charSequence != null) {
            zVar.e(charSequence, "android.media.metadata.TITLE");
            zVar.e(v0Var.f6651h, "android.media.metadata.DISPLAY_TITLE");
        }
        CharSequence charSequence2 = v0Var.f6656m;
        if (charSequence2 != null) {
            zVar.e(charSequence2, "android.media.metadata.DISPLAY_SUBTITLE");
        }
        CharSequence charSequence3 = v0Var.f6657n;
        if (charSequence3 != null) {
            zVar.e(charSequence3, "android.media.metadata.DISPLAY_DESCRIPTION");
        }
        CharSequence charSequence4 = v0Var.f6652i;
        if (charSequence4 != null) {
            zVar.e(charSequence4, "android.media.metadata.ARTIST");
        }
        CharSequence charSequence5 = v0Var.f6653j;
        if (charSequence5 != null) {
            zVar.e(charSequence5, "android.media.metadata.ALBUM");
        }
        CharSequence charSequence6 = v0Var.f6654k;
        if (charSequence6 != null) {
            zVar.e(charSequence6, "android.media.metadata.ALBUM_ARTIST");
        }
        Integer num = v0Var.f6669z;
        if (num != null) {
            zVar.b("android.media.metadata.YEAR", (long) num.intValue());
        }
        if (uri != null) {
            zVar.d("android.media.metadata.MEDIA_URI", uri.toString());
        }
        Uri uri2 = v0Var.f6662s;
        if (uri2 != null) {
            zVar.d("android.media.metadata.DISPLAY_ICON_URI", uri2.toString());
            zVar.d("android.media.metadata.ALBUM_ART_URI", uri2.toString());
        }
        if (bitmap != null) {
            zVar.a("android.media.metadata.DISPLAY_ICON", bitmap);
            zVar.a("android.media.metadata.ALBUM_ART", bitmap);
        }
        Integer num2 = v0Var.f6665v;
        if (!(num2 == null || num2.intValue() == -1)) {
            zVar.b("android.media.metadata.BT_FOLDER_TYPE", g(num2.intValue()));
        }
        if (j10 != -9223372036854775807L) {
            zVar.b("android.media.metadata.DURATION", j10);
        }
        RatingCompat r10 = r(v0Var.f6658o);
        if (r10 != null) {
            zVar.c("android.media.metadata.USER_RATING", r10);
        }
        RatingCompat r11 = r(v0Var.f6659p);
        if (r11 != null) {
            zVar.c("android.media.metadata.RATING", r11);
        }
        Integer num3 = v0Var.N;
        if (num3 != null) {
            zVar.b("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT", (long) num3.intValue());
        }
        return new MediaMetadataCompat(zVar.f447a);
    }

    public static d1 o(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null || playbackStateCompat.f359h != 7) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        CharSequence charSequence = playbackStateCompat.f365n;
        if (!TextUtils.isEmpty(charSequence)) {
            sb2.append(charSequence.toString());
            sb2.append(", ");
        }
        sb2.append("code=");
        sb2.append(playbackStateCompat.f364m);
        String sb3 = sb2.toString();
        d.f8420a.getClass();
        return new d1(sb3, (Throwable) null, 1001, SystemClock.elapsedRealtime());
    }

    public static int p(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            return 2;
        }
        throw new IllegalArgumentException(android.support.v4.media.h.i("Unrecognized RepeatMode: ", i10));
    }

    public static l1 q(RatingCompat ratingCompat) {
        if (ratingCompat == null) {
            return null;
        }
        boolean z10 = false;
        float f10 = ratingCompat.f312i;
        int i10 = ratingCompat.f311h;
        switch (i10) {
            case 1:
                if (!ratingCompat.w()) {
                    return new d0();
                }
                if (i10 == 1 && f10 == 1.0f) {
                    z10 = true;
                }
                return new d0(z10);
            case 2:
                if (!ratingCompat.w()) {
                    return new p1();
                }
                if (i10 == 2 && f10 == 1.0f) {
                    z10 = true;
                }
                return new p1(z10);
            case 3:
                if (ratingCompat.w()) {
                    return new m1(3, ratingCompat.v());
                }
                return new m1(3);
            case 4:
                if (ratingCompat.w()) {
                    return new m1(4, ratingCompat.v());
                }
                return new m1(4);
            case Constants.MAX_COMPATIBILITY_VERSION:
                if (ratingCompat.w()) {
                    return new m1(5, ratingCompat.v());
                }
                return new m1(5);
            case 6:
                if (!ratingCompat.w()) {
                    return new c1();
                }
                if (i10 != 6 || !ratingCompat.w()) {
                    f10 = -1.0f;
                }
                return new c1(f10);
            default:
                return null;
        }
    }

    public static RatingCompat r(l1 l1Var) {
        if (l1Var == null) {
            return null;
        }
        int w10 = w(l1Var);
        if (!l1Var.i()) {
            return RatingCompat.y(w10);
        }
        float f10 = 1.0f;
        switch (w10) {
            case 1:
                if (!((d0) l1Var).f6342k) {
                    f10 = 0.0f;
                }
                return new RatingCompat(1, f10);
            case 2:
                if (!((p1) l1Var).f6513k) {
                    f10 = 0.0f;
                }
                return new RatingCompat(2, f10);
            case 3:
            case 4:
            case Constants.MAX_COMPATIBILITY_VERSION:
                return RatingCompat.x(w10, ((m1) l1Var).f6472k);
            case 6:
                Parcelable.Creator<RatingCompat> creator = RatingCompat.CREATOR;
                float f11 = ((c1) l1Var).f6337j;
                if (f11 >= 0.0f && f11 <= 100.0f) {
                    return new RatingCompat(6, f11);
                }
                Log.e("Rating", "Invalid percentage-based rating value");
                return null;
            default:
                return null;
        }
    }

    public static int s(int i10) {
        if (i10 == -1 || i10 == 0) {
            return 0;
        }
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (!(i10 == 2 || i10 == 3)) {
                throw new IllegalArgumentException(android.support.v4.media.h.i("Unrecognized PlaybackStateCompat.RepeatMode: ", i10));
            }
        }
        return i11;
    }

    public static boolean t(int i10) {
        if (i10 == -1 || i10 == 0) {
            return false;
        }
        if (i10 == 1 || i10 == 2) {
            return true;
        }
        throw new IllegalArgumentException(android.support.v4.media.h.i("Unrecognized ShuffleMode: ", i10));
    }

    public static void u(e0 e0Var) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z10 = false;
        long j10 = 3000;
        while (true) {
            try {
                e0Var.get(j10, TimeUnit.MILLISECONDS);
                if (z10) {
                    Thread.currentThread().interrupt();
                    return;
                }
                return;
            } catch (InterruptedException unused) {
                z10 = true;
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (elapsedRealtime2 < 3000) {
                    j10 = 3000 - elapsedRealtime2;
                } else {
                    throw new TimeoutException();
                }
            } catch (Throwable th) {
                if (1 != 0) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
    }

    public static int v(g1.h hVar) {
        a aVar = new a();
        int i10 = hVar.f6393h;
        c cVar = aVar.f4885a;
        cVar.f4894a.setContentType(i10);
        cVar.f4894a.setFlags(hVar.f6394i);
        cVar.b(hVar.f6395j);
        int c10 = new AudioAttributesCompat(cVar.a()).f1807a.c();
        if (c10 == Integer.MIN_VALUE) {
            return 3;
        }
        return c10;
    }

    public static int w(l1 l1Var) {
        if (l1Var instanceof d0) {
            return 1;
        }
        if (l1Var instanceof p1) {
            return 2;
        }
        if (l1Var instanceof m1) {
            int i10 = ((m1) l1Var).f6471j;
            int i11 = 3;
            if (i10 != 3) {
                i11 = 4;
                if (i10 != 4) {
                    i11 = 5;
                    if (i10 != 5) {
                        return 0;
                    }
                }
            }
            return i11;
        } else if (l1Var instanceof c1) {
            return 6;
        } else {
            return 0;
        }
    }

    public static boolean x(long j10, long j11) {
        return (j10 & j11) != 0;
    }

    public static g1 y(g1 g1Var, g1 g1Var2) {
        if (g1Var == null || g1Var2 == null) {
            return g1.f6382i;
        }
        f1 f1Var = new f1();
        int i10 = 0;
        while (true) {
            y yVar = g1Var.f6385h;
            if (i10 >= yVar.c()) {
                return f1Var.c();
            }
            if (g1Var2.i(yVar.b(i10))) {
                f1Var.a(yVar.b(i10));
            }
            i10++;
        }
    }

    public static Pair z(w3 w3Var, v3 v3Var, w3 w3Var2, v3 v3Var2, g1 g1Var) {
        boolean z10 = v3Var2.f7388h;
        boolean z11 = v3Var2.f7389i;
        if (z10 && g1Var.i(17) && !v3Var.f7388h) {
            u1 u1Var = w3Var.f7421q;
            u3 g10 = android.support.v4.media.h.g(w3Var2, w3Var2);
            g10.f7349j = u1Var;
            w3Var2 = g10.a();
            v3Var2 = new v3(false, z11);
        }
        if (z11 && g1Var.i(30) && !v3Var.f7389i) {
            a2 a2Var = w3Var.J;
            u3 g11 = android.support.v4.media.h.g(w3Var2, w3Var2);
            g11.C = a2Var;
            w3Var2 = g11.a();
            v3Var2 = new v3(v3Var2.f7388h, false);
        }
        return new Pair(w3Var2, v3Var2);
    }
}
