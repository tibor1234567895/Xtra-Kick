package h3;

import android.media.session.MediaSession;
import android.os.Parcelable;
import android.support.v4.media.d;
import android.support.v4.media.e;
import android.support.v4.media.s;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.f;
import g.r0;

public final class g1 extends d {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l1 f7044c;

    public g1(l1 l1Var) {
        this.f7044c = l1Var;
    }

    public final void a() {
        l1 l1Var = this.f7044c;
        s sVar = l1Var.f7178h;
        if (sVar != null) {
            e eVar = sVar.f344a;
            if (eVar.f327h == null) {
                MediaSession.Token sessionToken = eVar.f321b.getSessionToken();
                MediaSessionCompat$Token mediaSessionCompat$Token = null;
                if (sessionToken != null) {
                    mediaSessionCompat$Token = new MediaSessionCompat$Token(sessionToken, (f) null, (d4.e) null);
                } else {
                    Parcelable.Creator<MediaSessionCompat$Token> creator = MediaSessionCompat$Token.CREATOR;
                }
                eVar.f327h = mediaSessionCompat$Token;
            }
            r0 r0Var = new r0(l1Var, 21, eVar.f327h);
            b0 b0Var = l1Var.f7172b;
            b0Var.S0(r0Var);
            b0Var.f6926e.post(new e1(l1Var, 0));
        }
    }

    public final void b() {
        this.f7044c.f7172b.a();
    }

    public final void c() {
        this.f7044c.f7172b.a();
    }
}
