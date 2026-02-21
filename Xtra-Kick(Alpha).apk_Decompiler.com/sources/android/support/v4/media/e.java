package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Process;
import android.support.v4.media.session.MediaSessionCompat$Token;

public class e implements l {

    /* renamed from: a  reason: collision with root package name */
    public final Context f320a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaBrowser f321b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f322c;

    /* renamed from: d  reason: collision with root package name */
    public final b f323d = new b((l) this);

    /* renamed from: e  reason: collision with root package name */
    public final q.e f324e = new q.e();

    /* renamed from: f  reason: collision with root package name */
    public n f325f;

    /* renamed from: g  reason: collision with root package name */
    public Messenger f326g;

    /* renamed from: h  reason: collision with root package name */
    public MediaSessionCompat$Token f327h;

    public e(Context context, ComponentName componentName, d dVar) {
        this.f320a = context;
        Bundle bundle = new Bundle();
        this.f322c = bundle;
        bundle.putInt("extra_client_version", 1);
        bundle.putInt("extra_calling_pid", Process.myPid());
        dVar.f319b = this;
        this.f321b = new MediaBrowser(context, componentName, dVar.f318a, bundle);
    }
}
