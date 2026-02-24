package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import c0.g;
import com.woxthebox.draglistview.R;
import e0.a;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f820a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: b  reason: collision with root package name */
    public final int[] f821b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

    /* renamed from: c  reason: collision with root package name */
    public final int[] f822c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

    /* renamed from: d  reason: collision with root package name */
    public final int[] f823d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: e  reason: collision with root package name */
    public final int[] f824e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

    /* renamed from: f  reason: collision with root package name */
    public final int[] f825f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

    public static boolean a(int[] iArr, int i10) {
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList b(Context context, int i10) {
        int c10 = q4.c(context, R.attr.colorControlHighlight);
        int b10 = q4.b(context, R.attr.colorButtonNormal);
        return new ColorStateList(new int[][]{q4.f1023b, q4.f1025d, q4.f1024c, q4.f1027f}, new int[]{b10, a.b(c10, i10), a.b(c10, i10), i10});
    }

    public static void d(Drawable drawable, int i10, PorterDuff.Mode mode) {
        int[] iArr = i2.f869a;
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = h0.f843b;
        }
        mutate.setColorFilter(h0.c(i10, mode));
    }

    public final ColorStateList c(Context context, int i10) {
        if (i10 == R.drawable.abc_edit_text_material) {
            return g.c(context, R.color.abc_tint_edittext);
        }
        if (i10 == R.drawable.abc_switch_track_mtrl_alpha) {
            return g.c(context, R.color.abc_tint_switch_track);
        }
        if (i10 == R.drawable.abc_switch_thumb_material) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList d10 = q4.d(context, R.attr.colorSwitchThumbNormal);
            if (d10 == null || !d10.isStateful()) {
                iArr[0] = q4.f1023b;
                iArr2[0] = q4.b(context, R.attr.colorSwitchThumbNormal);
                iArr[1] = q4.f1026e;
                iArr2[1] = q4.c(context, R.attr.colorControlActivated);
                iArr[2] = q4.f1027f;
                iArr2[2] = q4.c(context, R.attr.colorSwitchThumbNormal);
            } else {
                int[] iArr3 = q4.f1023b;
                iArr[0] = iArr3;
                iArr2[0] = d10.getColorForState(iArr3, 0);
                iArr[1] = q4.f1026e;
                iArr2[1] = q4.c(context, R.attr.colorControlActivated);
                iArr[2] = q4.f1027f;
                iArr2[2] = d10.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        } else if (i10 == R.drawable.abc_btn_default_mtrl_shape) {
            return b(context, q4.c(context, R.attr.colorButtonNormal));
        } else {
            if (i10 == R.drawable.abc_btn_borderless_material) {
                return b(context, 0);
            }
            if (i10 == R.drawable.abc_btn_colored_material) {
                return b(context, q4.c(context, R.attr.colorAccent));
            }
            if (i10 == R.drawable.abc_spinner_mtrl_am_alpha || i10 == R.drawable.abc_spinner_textfield_background_material) {
                return g.c(context, R.color.abc_tint_spinner);
            }
            if (a(this.f821b, i10)) {
                return q4.d(context, R.attr.colorControlNormal);
            }
            if (a(this.f824e, i10)) {
                return g.c(context, R.color.abc_tint_default);
            }
            if (a(this.f825f, i10)) {
                return g.c(context, R.color.abc_tint_btn_checkable);
            }
            if (i10 == R.drawable.abc_seekbar_thumb_material) {
                return g.c(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
    }
}
