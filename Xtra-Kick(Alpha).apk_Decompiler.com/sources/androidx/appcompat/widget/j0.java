package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.n;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import com.woxthebox.draglistview.R;
import e.a;
import m0.a0;
import m0.c1;
import m0.f;
import m0.i;
import q0.b0;
import q0.d0;
import w0.b;
import w0.c;

public class j0 extends EditText implements a0, d0 {

    /* renamed from: h  reason: collision with root package name */
    public final b0 f884h;

    /* renamed from: i  reason: collision with root package name */
    public final q1 f885i;

    /* renamed from: j  reason: collision with root package name */
    public final n f886j;

    /* renamed from: k  reason: collision with root package name */
    public final b0 f887k;

    /* renamed from: l  reason: collision with root package name */
    public final n f888l;

    /* renamed from: m  reason: collision with root package name */
    public i0 f889m;

    public j0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private i0 getSuperCaller() {
        if (this.f889m == null) {
            this.f889m = new i0(this);
        }
        return this.f889m;
    }

    public final i a(i iVar) {
        return this.f887k.a(this, iVar);
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b0 b0Var = this.f884h;
        if (b0Var != null) {
            b0Var.a();
        }
        q1 q1Var = this.f885i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return q0.a0.e(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        b0 b0Var = this.f884h;
        if (b0Var != null) {
            return b0Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b0 b0Var = this.f884h;
        if (b0Var != null) {
            return b0Var.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f885i.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f885i.e();
    }

    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    public TextClassifier getTextClassifier() {
        n nVar;
        if (Build.VERSION.SDK_INT >= 28 || (nVar = this.f886j) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) nVar.f338j;
        if (textClassifier == null) {
            return i1.a((TextView) nVar.f337i);
        }
        return textClassifier;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        if (r1 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006a, code lost:
        if (r1 != null) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r8) {
        /*
            r7 = this;
            android.view.inputmethod.InputConnection r0 = super.onCreateInputConnection(r8)
            androidx.appcompat.widget.q1 r1 = r7.f885i
            r1.getClass()
            androidx.appcompat.widget.q1.h(r7, r0, r8)
            androidx.appcompat.widget.l0.a(r7, r8, r0)
            if (r0 == 0) goto L_0x0077
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 > r2) goto L_0x0077
            java.lang.String[] r2 = m0.c1.g(r7)
            if (r2 == 0) goto L_0x0077
            java.lang.String r3 = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String r4 = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            r5 = 25
            if (r1 < r5) goto L_0x0029
            r8.contentMimeTypes = r2
            goto L_0x003e
        L_0x0029:
            android.os.Bundle r6 = r8.extras
            if (r6 != 0) goto L_0x0034
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r8.extras = r6
        L_0x0034:
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r4, r2)
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r3, r2)
        L_0x003e:
            p0.c r2 = new p0.c
            r6 = 0
            r2.<init>(r6, r7)
            if (r1 < r5) goto L_0x004d
            p0.d r1 = new p0.d
            r1.<init>(r0, r2)
        L_0x004b:
            r0 = r1
            goto L_0x0077
        L_0x004d:
            java.lang.String[] r6 = p0.b.f12402a
            if (r1 < r5) goto L_0x0059
            java.lang.String[] r1 = r8.contentMimeTypes
            if (r1 == 0) goto L_0x006d
        L_0x0057:
            r6 = r1
            goto L_0x006d
        L_0x0059:
            android.os.Bundle r1 = r8.extras
            if (r1 != 0) goto L_0x005e
            goto L_0x006d
        L_0x005e:
            java.lang.String[] r1 = r1.getStringArray(r4)
            if (r1 != 0) goto L_0x006a
            android.os.Bundle r1 = r8.extras
            java.lang.String[] r1 = r1.getStringArray(r3)
        L_0x006a:
            if (r1 == 0) goto L_0x006d
            goto L_0x0057
        L_0x006d:
            int r1 = r6.length
            if (r1 != 0) goto L_0x0071
            goto L_0x0077
        L_0x0071:
            p0.e r1 = new p0.e
            r1.<init>(r0, r2)
            goto L_0x004b
        L_0x0077:
            android.support.v4.media.n r1 = r7.f888l
            android.view.inputmethod.InputConnection r8 = r1.x(r0, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j0.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        if (i10 < 31 && i10 >= 24 && dragEvent.getLocalState() == null && c1.g(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z10 = u0.a(dragEvent, this, activity);
            }
        }
        if (z10) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public final boolean onTextContextMenuItem(int i10) {
        ClipData clipData;
        int i11 = 0;
        if (Build.VERSION.SDK_INT < 31 && c1.g(this) != null && (i10 == 16908322 || i10 == 16908337)) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager == null) {
                clipData = null;
            } else {
                clipData = clipboardManager.getPrimaryClip();
            }
            if (clipData != null && clipData.getItemCount() > 0) {
                a aVar = new a(clipData, 1);
                if (i10 != 16908322) {
                    i11 = 1;
                }
                ((f) aVar.f4852i).g(i11);
                c1.l(this, ((f) aVar.f4852i).a());
            }
            i11 = 1;
        }
        if (i11 != 0) {
            return true;
        }
        return super.onTextContextMenuItem(i10);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b0 b0Var = this.f884h;
        if (b0Var != null) {
            b0Var.f();
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b0 b0Var = this.f884h;
        if (b0Var != null) {
            b0Var.g(i10);
        }
    }

    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f885i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        q1 q1Var = this.f885i;
        if (q1Var != null) {
            q1Var.b();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(q0.a0.f(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        ((b) ((c) this.f888l.f338j).f16019c).c(z10);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f888l.t(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f884h;
        if (b0Var != null) {
            b0Var.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f884h;
        if (b0Var != null) {
            b0Var.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        q1 q1Var = this.f885i;
        q1Var.l(colorStateList);
        q1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        q1 q1Var = this.f885i;
        q1Var.m(mode);
        q1Var.b();
    }

    public final void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        q1 q1Var = this.f885i;
        if (q1Var != null) {
            q1Var.g(context, i10);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        n nVar;
        if (Build.VERSION.SDK_INT >= 28 || (nVar = this.f886j) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            nVar.f338j = textClassifier;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, R.attr.editTextStyle);
        r4.a(context);
        q4.a(getContext(), this);
        b0 b0Var = new b0(this);
        this.f884h = b0Var;
        b0Var.e(attributeSet, R.attr.editTextStyle);
        q1 q1Var = new q1(this);
        this.f885i = q1Var;
        q1Var.f(attributeSet, R.attr.editTextStyle);
        q1Var.b();
        this.f886j = new n((TextView) this);
        this.f887k = new b0();
        n nVar = new n((EditText) this);
        this.f888l = nVar;
        nVar.v(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener t10 = nVar.t(keyListener);
            if (t10 != keyListener) {
                super.setKeyListener(t10);
                super.setRawInputType(inputType);
                super.setFocusable(isFocusable);
                super.setClickable(isClickable);
                super.setLongClickable(isLongClickable);
            }
        }
    }
}
