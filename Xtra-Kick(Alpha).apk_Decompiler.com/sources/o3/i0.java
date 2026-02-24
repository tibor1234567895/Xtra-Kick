package o3;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;

public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f12126a;

    /* renamed from: b  reason: collision with root package name */
    public long f12127b = 0;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f12128c;

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences.Editor f12129d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12130e;

    /* renamed from: f  reason: collision with root package name */
    public String f12131f;

    /* renamed from: g  reason: collision with root package name */
    public int f12132g;

    /* renamed from: h  reason: collision with root package name */
    public PreferenceScreen f12133h;

    /* renamed from: i  reason: collision with root package name */
    public h0 f12134i;

    /* renamed from: j  reason: collision with root package name */
    public f0 f12135j;

    /* renamed from: k  reason: collision with root package name */
    public g0 f12136k;

    public i0(Context context) {
        this.f12126a = context;
        this.f12131f = a(context);
        this.f12128c = null;
    }

    public static String a(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public static void f(Context context, int i10, boolean z10) {
        String a10 = a(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("_has_set_default_values", 0);
        if (z10 || !sharedPreferences.getBoolean("_has_set_default_values", false)) {
            i0 i0Var = new i0(context);
            i0Var.f12131f = a10;
            i0Var.f12132g = 0;
            i0Var.f12128c = null;
            i0Var.e(context, i10);
            sharedPreferences.edit().putBoolean("_has_set_default_values", true).apply();
        }
    }

    public final SharedPreferences.Editor b() {
        if (!this.f12130e) {
            return d().edit();
        }
        if (this.f12129d == null) {
            this.f12129d = d().edit();
        }
        return this.f12129d;
    }

    public final long c() {
        long j10;
        synchronized (this) {
            j10 = this.f12127b;
            this.f12127b = 1 + j10;
        }
        return j10;
    }

    public final SharedPreferences d() {
        if (this.f12128c == null) {
            this.f12128c = this.f12126a.getSharedPreferences(this.f12131f, this.f12132g);
        }
        return this.f12128c;
    }

    /* JADX INFO: finally extract failed */
    public final PreferenceScreen e(Context context, int i10) {
        this.f12130e = true;
        e0 e0Var = new e0(context, this);
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            PreferenceGroup c10 = e0Var.c(xml);
            xml.close();
            PreferenceScreen preferenceScreen = (PreferenceScreen) c10;
            preferenceScreen.k(this);
            SharedPreferences.Editor editor = this.f12129d;
            if (editor != null) {
                editor.apply();
            }
            this.f12130e = false;
            return preferenceScreen;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
