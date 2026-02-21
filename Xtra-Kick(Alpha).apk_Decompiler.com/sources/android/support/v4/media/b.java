package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.u;
import android.text.TextUtils;
import android.util.Log;
import b0.j;
import c.g;
import com.google.gson.internal.bind.l;
import e1.a0;
import e1.e;
import e1.w;
import e1.x;
import e1.y;
import e1.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f314a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Object f315b;

    /* renamed from: c  reason: collision with root package name */
    public Object f316c;

    public b(l lVar) {
        this.f315b = new WeakReference(lVar);
    }

    public final void a(Runnable runnable) {
        if (Thread.currentThread() == getLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public final void handleMessage(Message message) {
        Message message2 = message;
        int i10 = 0;
        int i11 = this.f314a;
        Object obj = this.f315b;
        switch (i11) {
            case 0:
                WeakReference weakReference = (WeakReference) this.f316c;
                if (weakReference != null && weakReference.get() != null) {
                    WeakReference weakReference2 = (WeakReference) obj;
                    if (weakReference2.get() != null) {
                        Bundle data = message.getData();
                        u.p(data);
                        l lVar = (l) weakReference2.get();
                        Messenger messenger = (Messenger) ((WeakReference) this.f316c).get();
                        try {
                            int i12 = message2.what;
                            if (i12 == 1) {
                                u.p(data.getBundle("data_root_hints"));
                                data.getString("data_media_item_id");
                                MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) data.getParcelable("data_media_session_token");
                            } else if (i12 != 2) {
                                if (i12 != 3) {
                                    Log.w("MediaBrowserCompat", "Unhandled message: " + message2 + "\n  Client version: 1\n  Service version: " + message2.arg1);
                                    return;
                                }
                                Bundle bundle = data.getBundle("data_options");
                                u.p(bundle);
                                u.p(data.getBundle("data_notify_children_changed_options"));
                                String string = data.getString("data_media_item_id");
                                data.getParcelableArrayList("data_media_item_list");
                                e eVar = (e) lVar;
                                if (eVar.f326g == messenger) {
                                    o oVar = (o) eVar.f324e.getOrDefault(string, (Object) null);
                                    if (oVar == null) {
                                        boolean z10 = s.f343b;
                                        return;
                                    }
                                    while (true) {
                                        ArrayList arrayList = oVar.f340b;
                                        if (i10 >= arrayList.size()) {
                                            return;
                                        }
                                        if (e.a((Bundle) arrayList.get(i10), bundle)) {
                                            r rVar = (r) oVar.f339a.get(i10);
                                            return;
                                        }
                                        i10++;
                                    }
                                } else {
                                    return;
                                }
                            }
                            lVar.getClass();
                            return;
                        } catch (BadParcelableException unused) {
                            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                            if (message2.what == 1) {
                                lVar.getClass();
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                Bundle data2 = message.getData();
                switch (message2.what) {
                    case 1:
                        Bundle bundle2 = data2.getBundle("data_root_hints");
                        u.p(bundle2);
                        l lVar2 = (l) obj;
                        String string2 = data2.getString("data_package_name");
                        int i13 = data2.getInt("data_calling_pid");
                        int i14 = data2.getInt("data_calling_uid");
                        l lVar3 = new l(message2.replyTo);
                        a0 a0Var = (a0) lVar2.f4038a;
                        if (string2 == null) {
                            a0Var.getClass();
                        } else {
                            String[] packagesForUid = a0Var.getPackageManager().getPackagesForUid(i14);
                            int length = packagesForUid.length;
                            int i15 = 0;
                            while (true) {
                                if (i15 < length) {
                                    if (packagesForUid[i15].equals(string2)) {
                                        i10 = 1;
                                    } else {
                                        i15++;
                                    }
                                }
                            }
                        }
                        if (i10 != 0) {
                            a0Var.f4892m.a(new w(lVar2, lVar3, string2, i13, i14, bundle2));
                            return;
                        }
                        throw new IllegalArgumentException("Package/uid mismatch: uid=" + i14 + " package=" + string2);
                    case 2:
                        l lVar4 = (l) obj;
                        ((a0) lVar4.f4038a).f4892m.a(new x(lVar4, new l(message2.replyTo), 0));
                        return;
                    case 3:
                        Bundle bundle3 = data2.getBundle("data_options");
                        u.p(bundle3);
                        l lVar5 = (l) obj;
                        String string3 = data2.getString("data_media_item_id");
                        IBinder a10 = j.a(data2, "data_callback_token");
                        ((a0) lVar5.f4038a).f4892m.a(new z(lVar5, new l(message2.replyTo), string3, a10, bundle3));
                        return;
                    case 4:
                        l lVar6 = (l) obj;
                        String string4 = data2.getString("data_media_item_id");
                        IBinder a11 = j.a(data2, "data_callback_token");
                        ((a0) lVar6.f4038a).f4892m.a(new y(lVar6, new l(message2.replyTo), string4, a11, 0));
                        return;
                    case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                        l lVar7 = (l) obj;
                        String string5 = data2.getString("data_media_item_id");
                        g gVar = (g) data2.getParcelable("data_result_receiver");
                        l lVar8 = new l(message2.replyTo);
                        lVar7.getClass();
                        if (!TextUtils.isEmpty(string5) && gVar != null) {
                            ((a0) lVar7.f4038a).f4892m.a(new y(lVar7, lVar8, string5, gVar, 1));
                            return;
                        }
                        return;
                    case 6:
                        Bundle bundle4 = data2.getBundle("data_root_hints");
                        u.p(bundle4);
                        l lVar9 = (l) obj;
                        l lVar10 = new l(message2.replyTo);
                        String string6 = data2.getString("data_package_name");
                        int i16 = data2.getInt("data_calling_pid");
                        ((a0) lVar9.f4038a).f4892m.a(new w(lVar9, lVar10, data2.getInt("data_calling_uid"), string6, i16, bundle4));
                        return;
                    case 7:
                        l lVar11 = (l) obj;
                        ((a0) lVar11.f4038a).f4892m.a(new x(lVar11, new l(message2.replyTo), 1));
                        return;
                    case 8:
                        Bundle bundle5 = data2.getBundle("data_search_extras");
                        u.p(bundle5);
                        l lVar12 = (l) obj;
                        String string7 = data2.getString("data_search_query");
                        g gVar2 = (g) data2.getParcelable("data_result_receiver");
                        l lVar13 = new l(message2.replyTo);
                        lVar12.getClass();
                        if (!TextUtils.isEmpty(string7) && gVar2 != null) {
                            ((a0) lVar12.f4038a).f4892m.a(new z(lVar12, lVar13, string7, bundle5, gVar2, 0));
                            return;
                        }
                        return;
                    case 9:
                        Bundle bundle6 = data2.getBundle("data_custom_action_extras");
                        u.p(bundle6);
                        l lVar14 = (l) obj;
                        String string8 = data2.getString("data_custom_action");
                        g gVar3 = (g) data2.getParcelable("data_result_receiver");
                        l lVar15 = new l(message2.replyTo);
                        lVar14.getClass();
                        if (!TextUtils.isEmpty(string8) && gVar3 != null) {
                            ((a0) lVar14.f4038a).f4892m.a(new z(lVar14, lVar15, string8, bundle6, gVar3, 1));
                            return;
                        }
                        return;
                    default:
                        Log.w("MBServiceCompat", "Unhandled message: " + message2 + "\n  Service version: 2\n  Client version: " + message2.arg1);
                        return;
                }
        }
    }

    public final boolean sendMessageAtTime(Message message, long j10) {
        switch (this.f314a) {
            case 1:
                Bundle data = message.getData();
                data.setClassLoader(s.class.getClassLoader());
                data.putInt("data_calling_uid", Binder.getCallingUid());
                int callingPid = Binder.getCallingPid();
                if (callingPid <= 0) {
                    if (!data.containsKey("data_calling_pid")) {
                        callingPid = -1;
                    }
                    return super.sendMessageAtTime(message, j10);
                }
                data.putInt("data_calling_pid", callingPid);
                return super.sendMessageAtTime(message, j10);
            default:
                return super.sendMessageAtTime(message, j10);
        }
    }

    public b(a0 a0Var) {
        this.f316c = a0Var;
        this.f315b = new l((a0) this.f316c);
    }
}
