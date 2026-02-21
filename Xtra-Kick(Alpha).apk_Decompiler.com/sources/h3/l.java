package h3;

import a2.g;
import android.app.NotificationManager;
import android.content.Context;
import com.woxthebox.draglistview.R;
import f3.a;

public final class l implements q1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f7162a;

    /* renamed from: b  reason: collision with root package name */
    public final a f7163b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7164c;

    /* renamed from: d  reason: collision with root package name */
    public final int f7165d;

    /* renamed from: e  reason: collision with root package name */
    public final NotificationManager f7166e;

    /* renamed from: f  reason: collision with root package name */
    public k f7167f;

    /* renamed from: g  reason: collision with root package name */
    public final int f7168g = R.drawable.media3_notification_small_icon;

    public l(g gVar) {
        Context context = gVar.f29a;
        this.f7162a = context;
        this.f7163b = (a) gVar.f32d;
        this.f7164c = (String) gVar.f33e;
        this.f7165d = gVar.f30b;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        j1.a.f(notificationManager);
        this.f7166e = notificationManager;
    }
}
