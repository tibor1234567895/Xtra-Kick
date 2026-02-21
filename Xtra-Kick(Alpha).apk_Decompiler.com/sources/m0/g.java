package m0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.h;
import android.view.ContentInfo;
import java.util.Locale;

public final class g implements f, h {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10075h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final ClipData f10076i;

    /* renamed from: j  reason: collision with root package name */
    public final int f10077j;

    /* renamed from: k  reason: collision with root package name */
    public int f10078k;

    /* renamed from: l  reason: collision with root package name */
    public Uri f10079l;

    /* renamed from: m  reason: collision with root package name */
    public Bundle f10080m;

    public g(ClipData clipData, int i10) {
        this.f10076i = clipData;
        this.f10077j = i10;
    }

    public final i a() {
        return new i(new g(this));
    }

    public final int b() {
        return this.f10078k;
    }

    public final void c(Bundle bundle) {
        this.f10080m = bundle;
    }

    public final ClipData d() {
        return this.f10076i;
    }

    public final void e(Uri uri) {
        this.f10079l = uri;
    }

    public final void g(int i10) {
        this.f10078k = i10;
    }

    public final ContentInfo s() {
        return null;
    }

    public final String toString() {
        String str;
        String str2;
        String str3;
        switch (this.f10075h) {
            case 1:
                StringBuilder sb2 = new StringBuilder("ContentInfoCompat{clip=");
                sb2.append(this.f10076i.getDescription());
                sb2.append(", source=");
                int i10 = this.f10077j;
                if (i10 == 0) {
                    str = "SOURCE_APP";
                } else if (i10 == 1) {
                    str = "SOURCE_CLIPBOARD";
                } else if (i10 == 2) {
                    str = "SOURCE_INPUT_METHOD";
                } else if (i10 == 3) {
                    str = "SOURCE_DRAG_AND_DROP";
                } else if (i10 == 4) {
                    str = "SOURCE_AUTOFILL";
                } else if (i10 != 5) {
                    str = String.valueOf(i10);
                } else {
                    str = "SOURCE_PROCESS_TEXT";
                }
                sb2.append(str);
                sb2.append(", flags=");
                int i11 = this.f10078k;
                if ((i11 & 1) != 0) {
                    str2 = "FLAG_CONVERT_TO_PLAIN_TEXT";
                } else {
                    str2 = String.valueOf(i11);
                }
                sb2.append(str2);
                String str4 = "";
                if (this.f10079l == null) {
                    str3 = str4;
                } else {
                    str3 = ", hasLinkUri(" + this.f10079l.toString().length() + ")";
                }
                sb2.append(str3);
                if (this.f10080m != null) {
                    str4 = ", hasExtras";
                }
                return h.p(sb2, str4, "}");
            default:
                return super.toString();
        }
    }

    public final int z() {
        return this.f10077j;
    }

    public g(g gVar) {
        ClipData clipData = gVar.f10076i;
        clipData.getClass();
        this.f10076i = clipData;
        int i10 = gVar.f10077j;
        if (i10 < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{"source", 0, 5}));
        } else if (i10 <= 5) {
            this.f10077j = i10;
            int i11 = gVar.f10078k;
            if ((i11 & 1) == i11) {
                this.f10078k = i11;
                this.f10079l = gVar.f10079l;
                this.f10080m = gVar.f10080m;
                return;
            }
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i11) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{"source", 0, 5}));
        }
    }
}
