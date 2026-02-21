package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.h;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import com.woxthebox.draglistview.R;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;

class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: h  reason: collision with root package name */
    public final Chip f3928h;

    /* renamed from: i  reason: collision with root package name */
    public final EditText f3929i;

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, this, false);
        this.f3928h = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, this, false);
        EditText editText = textInputLayout.getEditText();
        this.f3929i = editText;
        editText.setVisibility(4);
        editText.addTextChangedListener(new a(this));
        if (Build.VERSION.SDK_INT >= 24) {
            editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
        addView(chip);
        addView(textInputLayout);
        WeakHashMap weakHashMap = c1.f10054a;
        editText.setId(j0.a());
        j0.h((TextView) findViewById(R.id.material_label), editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    public static String a(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        Resources resources = chipTextInputComboView.getResources();
        Parcelable.Creator<h> creator = h.CREATOR;
        try {
            return String.format(resources.getConfiguration().locale, "%02d", new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(charSequence)))});
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final boolean isChecked() {
        return this.f3928h.isChecked();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f3929i.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public final void setChecked(boolean z10) {
        int i10;
        Chip chip = this.f3928h;
        chip.setChecked(z10);
        int i11 = 0;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 4;
        }
        EditText editText = this.f3929i;
        editText.setVisibility(i10);
        if (z10) {
            i11 = 8;
        }
        chip.setVisibility(i11);
        if (isChecked()) {
            editText.requestFocus();
            editText.post(new h(18, editText));
        }
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3928h.setOnClickListener(onClickListener);
    }

    public final void setTag(int i10, Object obj) {
        this.f3928h.setTag(i10, obj);
    }

    public final void toggle() {
        this.f3928h.toggle();
    }
}
