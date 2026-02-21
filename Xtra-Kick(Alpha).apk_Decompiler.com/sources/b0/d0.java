package b0;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import q.f;

public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final Notification.Builder f2335a;

    /* renamed from: b  reason: collision with root package name */
    public final p f2336b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f2337c = new Bundle();

    /* JADX WARNING: type inference failed for: r6v24, types: [java.lang.Throwable, java.lang.CharSequence, android.app.Notification$BubbleMetadata, android.net.Uri, long[], java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v25 */
    /* JADX WARNING: type inference failed for: r6v27 */
    public d0(p pVar) {
        Notification.Builder builder;
        boolean z10;
        boolean z11;
        boolean z12;
        ? r62;
        ArrayList arrayList;
        int i10;
        Bundle bundle;
        int i11;
        Notification.Action.Builder builder2;
        Bundle bundle2;
        int i12;
        Icon icon;
        int i13;
        p pVar2 = pVar;
        new ArrayList();
        this.f2336b = pVar2;
        Context context = pVar2.f2385a;
        int i14 = Build.VERSION.SDK_INT;
        String str = pVar2.f2402r;
        if (i14 >= 26) {
            builder = y.a(context, str);
        } else {
            builder = new Notification.Builder(pVar2.f2385a);
        }
        this.f2335a = builder;
        Notification notification = pVar2.f2404t;
        ArrayList arrayList2 = null;
        Notification.Builder lights = builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, (RemoteViews) null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean z13 = true;
        if ((notification.flags & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z10);
        if ((notification.flags & 8) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z11);
        if ((notification.flags & 16) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        onlyAlertOnce.setAutoCancel(z12).setDefaults(notification.defaults).setContentTitle(pVar2.f2389e).setContentText(pVar2.f2390f).setContentInfo((CharSequence) null).setContentIntent(pVar2.f2391g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent((PendingIntent) null, (notification.flags & 128) == 0 ? false : z13).setLargeIcon(pVar2.f2392h).setNumber(0).setProgress(pVar2.f2396l, pVar2.f2397m, pVar2.f2398n);
        r.b(r.d(r.c(builder, (CharSequence) null), pVar2.f2394j), 0);
        Iterator it = pVar2.f2386b.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            int i15 = Build.VERSION.SDK_INT;
            if (oVar.f2378b == null && (i13 = oVar.f2381e) != 0) {
                oVar.f2378b = IconCompat.f((Resources) null, "", i13);
            }
            IconCompat iconCompat = oVar.f2378b;
            PendingIntent pendingIntent = oVar.f2383g;
            CharSequence charSequence = oVar.f2382f;
            if (i15 >= 23) {
                if (iconCompat != null) {
                    icon = iconCompat.k((Context) null);
                } else {
                    icon = null;
                }
                builder2 = w.a(icon, charSequence, pendingIntent);
            } else {
                if (iconCompat != null) {
                    i12 = iconCompat.g();
                } else {
                    i12 = 0;
                }
                builder2 = u.e(i12, charSequence, pendingIntent);
            }
            Bundle bundle3 = oVar.f2377a;
            if (bundle3 == null) {
                bundle2 = new Bundle();
            }
            boolean z14 = oVar.f2379c;
            bundle2.putBoolean("android.support.allowGeneratedReplies", z14);
            if (i15 >= 24) {
                x.a(builder2, z14);
            }
            bundle2.putInt("android.support.action.semanticAction", 0);
            if (i15 >= 28) {
                z.b(builder2, 0);
            }
            if (i15 >= 29) {
                a0.c(builder2, false);
            }
            if (i15 >= 31) {
                c0.a(builder2, false);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", oVar.f2380d);
            u.b(builder2, bundle2);
            u.a(this.f2335a, u.d(builder2));
        }
        Bundle bundle4 = pVar2.f2400p;
        if (bundle4 != null) {
            this.f2337c.putAll(bundle4);
        }
        int i16 = Build.VERSION.SDK_INT;
        s.a(this.f2335a, pVar2.f2393i);
        u.i(this.f2335a, false);
        u.g(this.f2335a, pVar2.f2399o);
        u.j(this.f2335a, (String) null);
        u.h(this.f2335a, false);
        v.b(this.f2335a, (String) null);
        v.c(this.f2335a, 0);
        v.f(this.f2335a, pVar2.f2401q);
        v.d(this.f2335a, (Notification) null);
        v.e(this.f2335a, notification.sound, notification.audioAttributes);
        ArrayList arrayList3 = pVar2.f2387c;
        ArrayList<String> arrayList4 = pVar2.f2405u;
        if (i16 < 28) {
            if (arrayList3 != null) {
                ArrayList arrayList5 = new ArrayList(arrayList3.size());
                Iterator it2 = arrayList3.iterator();
                if (!it2.hasNext()) {
                    arrayList2 = arrayList5;
                } else {
                    h.y(it2.next());
                    throw null;
                }
            }
            if (arrayList2 != null) {
                if (arrayList4 == null) {
                    arrayList4 = arrayList2;
                } else {
                    f fVar = new f(arrayList4.size() + arrayList2.size());
                    fVar.addAll(arrayList2);
                    fVar.addAll(arrayList4);
                    arrayList4 = new ArrayList<>(fVar);
                }
            }
        }
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            for (String a10 : arrayList4) {
                v.a(this.f2335a, a10);
            }
        }
        ArrayList arrayList6 = pVar2.f2388d;
        if (arrayList6.size() > 0) {
            if (pVar2.f2400p == null) {
                pVar2.f2400p = new Bundle();
            }
            Bundle bundle5 = pVar2.f2400p.getBundle("android.car.EXTENSIONS");
            bundle5 = bundle5 == null ? new Bundle() : bundle5;
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            int i17 = 0;
            while (i17 < arrayList6.size()) {
                String num = Integer.toString(i17);
                o oVar2 = (o) arrayList6.get(i17);
                Object obj = e0.f2339a;
                Bundle bundle8 = new Bundle();
                if (oVar2.f2378b != null || (i11 = oVar2.f2381e) == 0) {
                    arrayList = arrayList6;
                } else {
                    arrayList = arrayList6;
                    oVar2.f2378b = IconCompat.f((Resources) null, "", i11);
                }
                IconCompat iconCompat2 = oVar2.f2378b;
                if (iconCompat2 != null) {
                    i10 = iconCompat2.g();
                } else {
                    i10 = 0;
                }
                bundle8.putInt("icon", i10);
                bundle8.putCharSequence("title", oVar2.f2382f);
                bundle8.putParcelable("actionIntent", oVar2.f2383g);
                Bundle bundle9 = oVar2.f2377a;
                if (bundle9 == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", oVar2.f2379c);
                bundle8.putBundle("extras", bundle);
                bundle8.putParcelableArray("remoteInputs", (Parcelable[]) null);
                bundle8.putBoolean("showsUserInterface", oVar2.f2380d);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(num, bundle8);
                i17++;
                arrayList6 = arrayList;
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            if (pVar2.f2400p == null) {
                pVar2.f2400p = new Bundle();
            }
            pVar2.f2400p.putBundle("android.car.EXTENSIONS", bundle5);
            this.f2337c.putBundle("android.car.EXTENSIONS", bundle6);
        }
        int i18 = Build.VERSION.SDK_INT;
        if (i18 >= 24) {
            t.a(this.f2335a, pVar2.f2400p);
            r62 = 0;
            x.e(this.f2335a, (CharSequence[]) null);
        } else {
            r62 = 0;
        }
        if (i18 >= 26) {
            y.b(this.f2335a, 0);
            y.e(this.f2335a, r62);
            y.f(this.f2335a, r62);
            y.g(this.f2335a, 0);
            y.d(this.f2335a, 0);
            if (!TextUtils.isEmpty(str)) {
                this.f2335a.setSound(r62).setDefaults(0).setLights(0, 0, 0).setVibrate(r62);
            }
        }
        if (i18 >= 28) {
            Iterator it3 = arrayList3.iterator();
            if (it3.hasNext()) {
                h.y(it3.next());
                throw r62;
            }
        }
        if (i18 >= 29) {
            a0.a(this.f2335a, pVar2.f2403s);
            a0.b(this.f2335a, r62);
        }
    }
}
