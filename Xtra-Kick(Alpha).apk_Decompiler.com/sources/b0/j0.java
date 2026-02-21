package b0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import b.a;
import b.b;
import b.c;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class j0 implements Handler.Callback, ServiceConnection {

    /* renamed from: h  reason: collision with root package name */
    public final Context f2364h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f2365i;

    /* renamed from: j  reason: collision with root package name */
    public final HashMap f2366j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    public HashSet f2367k = new HashSet();

    public j0(Context context) {
        this.f2364h = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.f2365i = new Handler(handlerThread.getLooper(), this);
    }

    public final void a(i0 i0Var) {
        boolean z10;
        boolean isLoggable = Log.isLoggable("NotifManCompat", 3);
        ComponentName componentName = i0Var.f2359a;
        ArrayDeque arrayDeque = i0Var.f2362d;
        if (isLoggable) {
            Objects.toString(componentName);
            arrayDeque.size();
        }
        if (!arrayDeque.isEmpty()) {
            if (i0Var.f2360b) {
                z10 = true;
            } else {
                Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
                Context context = this.f2364h;
                boolean bindService = context.bindService(component, this, 33);
                i0Var.f2360b = bindService;
                if (bindService) {
                    i0Var.f2363e = 0;
                } else {
                    Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                    context.unbindService(this);
                }
                z10 = i0Var.f2360b;
            }
            if (!z10 || i0Var.f2361c == null) {
                b(i0Var);
                return;
            }
            while (true) {
                k0 k0Var = (k0) arrayDeque.peek();
                if (k0Var == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        k0Var.toString();
                    }
                    c cVar = i0Var.f2361c;
                    g0 g0Var = (g0) k0Var;
                    ((a) cVar).f0(g0Var.f2353a, g0Var.f2354b, g0Var.f2355c, g0Var.f2356d);
                    arrayDeque.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Objects.toString(componentName);
                    }
                } catch (RemoteException e10) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e10);
                }
            }
            if (!arrayDeque.isEmpty()) {
                b(i0Var);
            }
        }
    }

    public final void b(i0 i0Var) {
        Handler handler = this.f2365i;
        ComponentName componentName = i0Var.f2359a;
        if (!handler.hasMessages(3, componentName)) {
            int i10 = i0Var.f2363e + 1;
            i0Var.f2363e = i10;
            if (i10 > 6) {
                StringBuilder sb2 = new StringBuilder("Giving up on delivering ");
                ArrayDeque arrayDeque = i0Var.f2362d;
                sb2.append(arrayDeque.size());
                sb2.append(" tasks to ");
                sb2.append(componentName);
                sb2.append(" after ");
                sb2.append(i0Var.f2363e);
                sb2.append(" retries");
                Log.w("NotifManCompat", sb2.toString());
                arrayDeque.clear();
                return;
            }
            Log.isLoggable("NotifManCompat", 3);
            handler.sendMessageDelayed(handler.obtainMessage(3, componentName), (long) ((1 << (i10 - 1)) * 1000));
        }
    }

    public final boolean handleMessage(Message message) {
        HashSet hashSet;
        int i10 = message.what;
        c cVar = null;
        if (i10 == 0) {
            k0 k0Var = (k0) message.obj;
            String string = Settings.Secure.getString(this.f2364h.getContentResolver(), "enabled_notification_listeners");
            synchronized (l0.f2370c) {
                if (string != null) {
                    try {
                        if (!string.equals(l0.f2371d)) {
                            String[] split = string.split(Constants.EXT_TAG_END, -1);
                            HashSet hashSet2 = new HashSet(split.length);
                            for (String unflattenFromString : split) {
                                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                                if (unflattenFromString2 != null) {
                                    hashSet2.add(unflattenFromString2.getPackageName());
                                }
                            }
                            l0.f2372e = hashSet2;
                            l0.f2371d = string;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                hashSet = l0.f2372e;
            }
            if (!hashSet.equals(this.f2367k)) {
                this.f2367k = hashSet;
                List<ResolveInfo> queryIntentServices = this.f2364h.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet hashSet3 = new HashSet();
                for (ResolveInfo next : queryIntentServices) {
                    if (hashSet.contains(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet3.add(componentName);
                        }
                    }
                }
                Iterator it = hashSet3.iterator();
                while (it.hasNext()) {
                    ComponentName componentName2 = (ComponentName) it.next();
                    if (!this.f2366j.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Objects.toString(componentName2);
                        }
                        this.f2366j.put(componentName2, new i0(componentName2));
                    }
                }
                Iterator it2 = this.f2366j.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!hashSet3.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Objects.toString(entry.getKey());
                        }
                        i0 i0Var = (i0) entry.getValue();
                        if (i0Var.f2360b) {
                            this.f2364h.unbindService(this);
                            i0Var.f2360b = false;
                        }
                        i0Var.f2361c = null;
                        it2.remove();
                    }
                }
            }
            for (i0 i0Var2 : this.f2366j.values()) {
                i0Var2.f2362d.add(k0Var);
                a(i0Var2);
            }
            return true;
        } else if (i10 == 1) {
            h0 h0Var = (h0) message.obj;
            ComponentName componentName3 = h0Var.f2357a;
            IBinder iBinder = h0Var.f2358b;
            i0 i0Var3 = (i0) this.f2366j.get(componentName3);
            if (i0Var3 != null) {
                int i11 = b.f2333c;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(c.f2334a);
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                        cVar = new a(iBinder);
                    } else {
                        cVar = (c) queryLocalInterface;
                    }
                }
                i0Var3.f2361c = cVar;
                i0Var3.f2363e = 0;
                a(i0Var3);
            }
            return true;
        } else if (i10 == 2) {
            i0 i0Var4 = (i0) this.f2366j.get((ComponentName) message.obj);
            if (i0Var4 != null) {
                if (i0Var4.f2360b) {
                    this.f2364h.unbindService(this);
                    i0Var4.f2360b = false;
                }
                i0Var4.f2361c = null;
            }
            return true;
        } else if (i10 != 3) {
            return false;
        } else {
            i0 i0Var5 = (i0) this.f2366j.get((ComponentName) message.obj);
            if (i0Var5 != null) {
                a(i0Var5);
            }
            return true;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Objects.toString(componentName);
        }
        this.f2365i.obtainMessage(1, new h0(componentName, iBinder)).sendToTarget();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Objects.toString(componentName);
        }
        this.f2365i.obtainMessage(2, componentName).sendToTarget();
    }
}
