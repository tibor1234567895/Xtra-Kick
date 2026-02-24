package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.u;
import c.g;
import java.util.ArrayList;

class MediaBrowserCompat$SearchResultReceiver extends g {
    public final void u(int i10, Bundle bundle) {
        if (bundle != null) {
            bundle = u.O(bundle);
        }
        if (i10 != 0 || bundle == null || !bundle.containsKey("search_results")) {
            throw null;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
        parcelableArray.getClass();
        ArrayList arrayList = new ArrayList(parcelableArray.length);
        for (Parcelable parcelable : parcelableArray) {
            arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
        }
        throw null;
    }
}
