package o3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.c0;
import androidx.fragment.app.t;
import androidx.preference.DialogPreference;
import g.l;
import g.m;

public abstract class x extends t implements DialogInterface.OnClickListener {
    public int A0;

    /* renamed from: t0  reason: collision with root package name */
    public DialogPreference f12172t0;

    /* renamed from: u0  reason: collision with root package name */
    public CharSequence f12173u0;

    /* renamed from: v0  reason: collision with root package name */
    public CharSequence f12174v0;

    /* renamed from: w0  reason: collision with root package name */
    public CharSequence f12175w0;

    /* renamed from: x0  reason: collision with root package name */
    public CharSequence f12176x0;

    /* renamed from: y0  reason: collision with root package name */
    public int f12177y0;

    /* renamed from: z0  reason: collision with root package name */
    public BitmapDrawable f12178z0;

    public void N(Bundle bundle) {
        BitmapDrawable bitmapDrawable;
        super.N(bundle);
        c0 B = B(true);
        if (B instanceof b) {
            b bVar = (b) B;
            String string = e0().getString("key");
            if (bundle == null) {
                DialogPreference dialogPreference = (DialogPreference) ((z) bVar).l0(string);
                this.f12172t0 = dialogPreference;
                this.f12173u0 = dialogPreference.U;
                this.f12174v0 = dialogPreference.X;
                this.f12175w0 = dialogPreference.Y;
                this.f12176x0 = dialogPreference.V;
                this.f12177y0 = dialogPreference.Z;
                Drawable drawable = dialogPreference.W;
                if (drawable == null || (drawable instanceof BitmapDrawable)) {
                    bitmapDrawable = (BitmapDrawable) drawable;
                } else {
                    Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawable.draw(canvas);
                    bitmapDrawable = new BitmapDrawable(y(), createBitmap);
                }
                this.f12178z0 = bitmapDrawable;
                return;
            }
            this.f12173u0 = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f12174v0 = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f12175w0 = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f12176x0 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f12177y0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f12178z0 = new BitmapDrawable(y(), bitmap);
                return;
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    public void W(Bundle bundle) {
        super.W(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f12173u0);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f12174v0);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f12175w0);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f12176x0);
        bundle.putInt("PreferenceDialogFragment.layout", this.f12177y0);
        BitmapDrawable bitmapDrawable = this.f12178z0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public final Dialog n0(Bundle bundle) {
        this.A0 = -2;
        l title = new l(f0()).setTitle(this.f12173u0);
        title.f6176a.f6083c = this.f12178z0;
        title.b(this.f12174v0, this);
        title.a(this.f12175w0, this);
        f0();
        int i10 = this.f12177y0;
        View view = null;
        if (i10 != 0) {
            LayoutInflater layoutInflater = this.R;
            if (layoutInflater == null) {
                layoutInflater = c0((Bundle) null);
            }
            view = layoutInflater.inflate(i10, (ViewGroup) null);
        }
        if (view != null) {
            s0(view);
            title.setView(view);
        } else {
            title.f6176a.f6086f = this.f12176x0;
        }
        u0(title);
        m create = title.create();
        if (this instanceof f) {
            Window window = create.getWindow();
            if (Build.VERSION.SDK_INT >= 30) {
                w.a(window);
            } else {
                v0();
            }
        }
        return create;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.A0 = i10;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        t0(this.A0 == -1);
    }

    public final DialogPreference r0() {
        if (this.f12172t0 == null) {
            this.f12172t0 = (DialogPreference) ((z) ((b) B(true))).l0(e0().getString("key"));
        }
        return this.f12172t0;
    }

    public void s0(View view) {
        int i10;
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence charSequence = this.f12176x0;
            if (!TextUtils.isEmpty(charSequence)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i10 = 0;
            } else {
                i10 = 8;
            }
            if (findViewById.getVisibility() != i10) {
                findViewById.setVisibility(i10);
            }
        }
    }

    public abstract void t0(boolean z10);

    public void u0(l lVar) {
    }

    public void v0() {
    }
}
