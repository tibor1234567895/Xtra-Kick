package k1;

import android.net.Uri;
import android.support.v4.media.h;
import android.util.Base64;
import g1.b1;
import j1.a;
import j1.l0;
import java.net.URLDecoder;

public final class f extends c {

    /* renamed from: e  reason: collision with root package name */
    public m f8993e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f8994f;

    /* renamed from: g  reason: collision with root package name */
    public int f8995g;

    /* renamed from: h  reason: collision with root package name */
    public int f8996h;

    public f() {
        super(false);
    }

    public final void close() {
        if (this.f8994f != null) {
            this.f8994f = null;
            s();
        }
        this.f8993e = null;
    }

    public final Uri j() {
        m mVar = this.f8993e;
        if (mVar != null) {
            return mVar.f9022a;
        }
        return null;
    }

    public final int o(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.f8996h;
        if (i12 == 0) {
            return -1;
        }
        int min = Math.min(i11, i12);
        byte[] bArr2 = this.f8994f;
        int i13 = l0.f8453a;
        System.arraycopy(bArr2, this.f8995g, bArr, i10, min);
        this.f8995g += min;
        this.f8996h -= min;
        r(min);
        return min;
    }

    public final long q(m mVar) {
        t();
        this.f8993e = mVar;
        Uri uri = mVar.f9022a;
        String scheme = uri.getScheme();
        boolean equals = "data".equals(scheme);
        a.a("Unsupported scheme: " + scheme, equals);
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int i10 = l0.f8453a;
        String[] split = schemeSpecificPart.split(",", -1);
        if (split.length == 2) {
            String str = split[1];
            if (split[0].contains(";base64")) {
                try {
                    this.f8994f = Base64.decode(str, 0);
                } catch (IllegalArgumentException e10) {
                    throw new b1(h.m("Error while parsing Base64 encoded string: ", str), e10, true, 0);
                }
            } else {
                this.f8994f = l0.z(URLDecoder.decode(str, c9.h.f3033a.name()));
            }
            byte[] bArr = this.f8994f;
            long j10 = mVar.f9027f;
            if (j10 <= ((long) bArr.length)) {
                int i11 = (int) j10;
                this.f8995g = i11;
                int length = bArr.length - i11;
                this.f8996h = length;
                long j11 = mVar.f9028g;
                int i12 = (j11 > -1 ? 1 : (j11 == -1 ? 0 : -1));
                if (i12 != 0) {
                    this.f8996h = (int) Math.min((long) length, j11);
                }
                u(mVar);
                if (i12 != 0) {
                    return j11;
                }
                return (long) this.f8996h;
            }
            this.f8994f = null;
            throw new i(2008);
        }
        throw new b1("Unexpected URI format: " + uri, (Exception) null, true, 0);
    }
}
