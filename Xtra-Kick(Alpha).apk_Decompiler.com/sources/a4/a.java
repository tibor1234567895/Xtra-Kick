package a4;

import android.content.Context;
import android.content.LocusId;
import android.media.session.MediaSession;
import android.os.Bundle;

public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ LocusId g(Object obj) {
        return (LocusId) obj;
    }

    public static /* synthetic */ MediaSession i(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str, bundle);
    }
}
