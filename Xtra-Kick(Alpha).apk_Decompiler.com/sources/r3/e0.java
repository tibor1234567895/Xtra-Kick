package r3;

import android.os.RemoteException;
import android.util.Log;
import androidx.room.MultiInstanceInvalidationService;
import la.v;
import xa.j;

public final class e0 extends q {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f13676d;

    public e0(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f13676d = multiInstanceInvalidationService;
    }

    public final void b0(int i10, String[] strArr) {
        j.f("tables", strArr);
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f13676d;
        synchronized (multiInstanceInvalidationService.f2280j) {
            String str = (String) multiInstanceInvalidationService.f2279i.get(Integer.valueOf(i10));
            if (str == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
                return;
            }
            int beginBroadcast = multiInstanceInvalidationService.f2280j.beginBroadcast();
            for (int i11 = 0; i11 < beginBroadcast; i11++) {
                try {
                    Object broadcastCookie = multiInstanceInvalidationService.f2280j.getBroadcastCookie(i11);
                    j.d("null cannot be cast to non-null type kotlin.Int", broadcastCookie);
                    int intValue = ((Integer) broadcastCookie).intValue();
                    String str2 = (String) multiInstanceInvalidationService.f2279i.get(Integer.valueOf(intValue));
                    if (i10 != intValue && j.a(str, str2)) {
                        ((o) multiInstanceInvalidationService.f2280j.getBroadcastItem(i11)).F(strArr);
                    }
                } catch (RemoteException e10) {
                    Log.w("ROOM", "Error invoking a remote callback", e10);
                } catch (Throwable th) {
                    multiInstanceInvalidationService.f2280j.finishBroadcast();
                    throw th;
                }
            }
            multiInstanceInvalidationService.f2280j.finishBroadcast();
            v vVar = v.f9814a;
        }
    }

    public final int g0(o oVar, String str) {
        j.f("callback", oVar);
        int i10 = 0;
        if (str == null) {
            return 0;
        }
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f13676d;
        synchronized (multiInstanceInvalidationService.f2280j) {
            int i11 = multiInstanceInvalidationService.f2278h + 1;
            multiInstanceInvalidationService.f2278h = i11;
            if (multiInstanceInvalidationService.f2280j.register(oVar, Integer.valueOf(i11))) {
                multiInstanceInvalidationService.f2279i.put(Integer.valueOf(i11), str);
                i10 = i11;
            } else {
                multiInstanceInvalidationService.f2278h--;
            }
        }
        return i10;
    }

    public final void m0(o oVar, int i10) {
        j.f("callback", oVar);
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f13676d;
        synchronized (multiInstanceInvalidationService.f2280j) {
            multiInstanceInvalidationService.f2280j.unregister(oVar);
            String str = (String) multiInstanceInvalidationService.f2279i.remove(Integer.valueOf(i10));
        }
    }
}
