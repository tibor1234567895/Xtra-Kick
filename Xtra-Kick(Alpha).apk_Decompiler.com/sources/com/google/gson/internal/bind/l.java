package com.google.gson.internal.bind;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.view.accessibility.AccessibilityNodeInfo;
import j9.q;
import java.util.ArrayList;
import java.util.List;

public final class l implements q {

    /* renamed from: a  reason: collision with root package name */
    public Object f4038a;

    public /* synthetic */ l(Object obj) {
        this.f4038a = obj;
    }

    public static l b(int i10, int i11, int i12) {
        return new l(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, false, i12));
    }

    public static l c(int i10, int i11, int i12, int i13, boolean z10) {
        return new l(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, false, z10));
    }

    public IBinder a() {
        return ((Messenger) this.f4038a).getBinder();
    }

    public void d(String str, MediaSessionCompat$Token mediaSessionCompat$Token, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extra_service_version", 2);
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", str);
        bundle2.putParcelable("data_media_session_token", mediaSessionCompat$Token);
        bundle2.putBundle("data_root_hints", bundle);
        f(1, bundle2);
    }

    public void e(String str, List list, Bundle bundle, Bundle bundle2) {
        Bundle bundle3 = new Bundle();
        bundle3.putString("data_media_item_id", str);
        bundle3.putBundle("data_options", bundle);
        bundle3.putBundle("data_notify_children_changed_options", bundle2);
        if (list != null) {
            bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
        }
        f(3, bundle3);
    }

    public void f(int i10, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.what = i10;
        obtain.arg1 = 2;
        obtain.setData(bundle);
        ((Messenger) this.f4038a).send(obtain);
    }

    public void g(Object obj) {
        MediaBrowserService.Result result;
        boolean z10 = obj instanceof List;
        ArrayList arrayList = null;
        Object obj2 = this.f4038a;
        if (z10) {
            result = (MediaBrowserService.Result) obj2;
            List<Parcel> list = (List) obj;
            if (list != null) {
                arrayList = new ArrayList(list.size());
                for (Parcel parcel : list) {
                    parcel.setDataPosition(0);
                    arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                    parcel.recycle();
                }
            }
        } else if (obj instanceof Parcel) {
            Parcel parcel2 = (Parcel) obj;
            parcel2.setDataPosition(0);
            ((MediaBrowserService.Result) obj2).sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel2));
            parcel2.recycle();
            return;
        } else {
            result = (MediaBrowserService.Result) obj2;
        }
        result.sendResult(arrayList);
    }
}
