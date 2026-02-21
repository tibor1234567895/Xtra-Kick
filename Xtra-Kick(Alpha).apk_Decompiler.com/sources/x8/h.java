package x8;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f16755a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f16756b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f16757c;

    /* renamed from: d  reason: collision with root package name */
    public int f16758d = -1;

    /* renamed from: e  reason: collision with root package name */
    public View f16759e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16760f = 1;

    /* renamed from: g  reason: collision with root package name */
    public TabLayout f16761g;

    /* renamed from: h  reason: collision with root package name */
    public j f16762h;

    /* renamed from: i  reason: collision with root package name */
    public int f16763i = -1;

    public final void a(String str) {
        if (TextUtils.isEmpty(this.f16757c) && !TextUtils.isEmpty(str)) {
            this.f16762h.setContentDescription(str);
        }
        this.f16756b = str;
        j jVar = this.f16762h;
        if (jVar != null) {
            jVar.e();
        }
    }
}
