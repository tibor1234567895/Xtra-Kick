package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.u4;
import com.woxthebox.draglistview.R;
import f.a;
import java.util.WeakHashMap;
import m.d0;
import m.q;
import m0.c1;
import m0.i0;

public class ListMenuItemView extends LinearLayout implements d0, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: h  reason: collision with root package name */
    public q f559h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f560i;

    /* renamed from: j  reason: collision with root package name */
    public RadioButton f561j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f562k;

    /* renamed from: l  reason: collision with root package name */
    public CheckBox f563l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f564m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f565n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f566o;

    /* renamed from: p  reason: collision with root package name */
    public LinearLayout f567p;

    /* renamed from: q  reason: collision with root package name */
    public final Drawable f568q;

    /* renamed from: r  reason: collision with root package name */
    public final int f569r;

    /* renamed from: s  reason: collision with root package name */
    public final Context f570s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f571t;

    /* renamed from: u  reason: collision with root package name */
    public final Drawable f572u;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f573v;

    /* renamed from: w  reason: collision with root package name */
    public LayoutInflater f574w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f575x;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u4 m10 = u4.m(getContext(), attributeSet, a.f5409s, R.attr.listMenuViewStyle);
        this.f568q = m10.e(5);
        this.f569r = m10.i(1, -1);
        this.f571t = m10.a(7, false);
        this.f570s = context;
        this.f572u = m10.e(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.f573v = obtainStyledAttributes.hasValue(0);
        m10.n();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f574w == null) {
            this.f574w = LayoutInflater.from(getContext());
        }
        return this.f574w;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f565n;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f566o;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f566o.getLayoutParams();
            rect.top = this.f566o.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        if (r0 == false) goto L_0x0059;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(m.q r11) {
        /*
            r10 = this;
            r10.f559h = r11
            boolean r0 = r11.isVisible()
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L_0x000d
            r0 = 0
            goto L_0x000f
        L_0x000d:
            r0 = 8
        L_0x000f:
            r10.setVisibility(r0)
            java.lang.CharSequence r0 = r11.f10003e
            r10.setTitle(r0)
            boolean r0 = r11.isCheckable()
            r10.setCheckable(r0)
            m.o r0 = r11.f10012n
            boolean r3 = r0.o()
            r4 = 1
            if (r3 == 0) goto L_0x0036
            boolean r3 = r0.n()
            if (r3 == 0) goto L_0x0030
            char r3 = r11.f10008j
            goto L_0x0032
        L_0x0030:
            char r3 = r11.f10006h
        L_0x0032:
            if (r3 == 0) goto L_0x0036
            r3 = 1
            goto L_0x0037
        L_0x0036:
            r3 = 0
        L_0x0037:
            r0.n()
            if (r3 == 0) goto L_0x0059
            m.q r0 = r10.f559h
            m.o r3 = r0.f10012n
            boolean r5 = r3.o()
            if (r5 == 0) goto L_0x0055
            boolean r3 = r3.n()
            if (r3 == 0) goto L_0x004f
            char r0 = r0.f10008j
            goto L_0x0051
        L_0x004f:
            char r0 = r0.f10006h
        L_0x0051:
            if (r0 == 0) goto L_0x0055
            r0 = 1
            goto L_0x0056
        L_0x0055:
            r0 = 0
        L_0x0056:
            if (r0 == 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r1 = 8
        L_0x005b:
            if (r1 != 0) goto L_0x010b
            android.widget.TextView r0 = r10.f564m
            m.q r3 = r10.f559h
            m.o r5 = r3.f10012n
            boolean r5 = r5.n()
            if (r5 == 0) goto L_0x006c
            char r5 = r3.f10008j
            goto L_0x006e
        L_0x006c:
            char r5 = r3.f10006h
        L_0x006e:
            if (r5 != 0) goto L_0x0074
            java.lang.String r2 = ""
            goto L_0x0108
        L_0x0074:
            m.o r6 = r3.f10012n
            android.content.Context r7 = r6.f9972a
            android.content.res.Resources r7 = r7.getResources()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            android.content.Context r9 = r6.f9972a
            android.view.ViewConfiguration r9 = android.view.ViewConfiguration.get(r9)
            boolean r9 = r9.hasPermanentMenuKey()
            if (r9 == 0) goto L_0x0097
            r9 = 2131951633(0x7f130011, float:1.9539686E38)
            java.lang.String r9 = r7.getString(r9)
            r8.append(r9)
        L_0x0097:
            boolean r6 = r6.n()
            if (r6 == 0) goto L_0x00a0
            int r3 = r3.f10009k
            goto L_0x00a2
        L_0x00a0:
            int r3 = r3.f10007i
        L_0x00a2:
            r6 = 2131951629(0x7f13000d, float:1.9539678E38)
            java.lang.String r6 = r7.getString(r6)
            r9 = 65536(0x10000, float:9.18355E-41)
            m.q.c(r3, r9, r6, r8)
            r6 = 2131951625(0x7f130009, float:1.953967E38)
            java.lang.String r6 = r7.getString(r6)
            r9 = 4096(0x1000, float:5.74E-42)
            m.q.c(r3, r9, r6, r8)
            r6 = 2131951624(0x7f130008, float:1.9539668E38)
            java.lang.String r6 = r7.getString(r6)
            r9 = 2
            m.q.c(r3, r9, r6, r8)
            r6 = 2131951630(0x7f13000e, float:1.953968E38)
            java.lang.String r6 = r7.getString(r6)
            m.q.c(r3, r4, r6, r8)
            r4 = 2131951632(0x7f130010, float:1.9539684E38)
            java.lang.String r4 = r7.getString(r4)
            r6 = 4
            m.q.c(r3, r6, r4, r8)
            r4 = 2131951628(0x7f13000c, float:1.9539676E38)
            java.lang.String r4 = r7.getString(r4)
            m.q.c(r3, r2, r4, r8)
            if (r5 == r2) goto L_0x00fa
            r2 = 10
            if (r5 == r2) goto L_0x00f6
            r2 = 32
            if (r5 == r2) goto L_0x00f2
            r8.append(r5)
            goto L_0x0104
        L_0x00f2:
            r2 = 2131951631(0x7f13000f, float:1.9539682E38)
            goto L_0x00fd
        L_0x00f6:
            r2 = 2131951627(0x7f13000b, float:1.9539674E38)
            goto L_0x00fd
        L_0x00fa:
            r2 = 2131951626(0x7f13000a, float:1.9539672E38)
        L_0x00fd:
            java.lang.String r2 = r7.getString(r2)
            r8.append(r2)
        L_0x0104:
            java.lang.String r2 = r8.toString()
        L_0x0108:
            r0.setText(r2)
        L_0x010b:
            android.widget.TextView r0 = r10.f564m
            int r0 = r0.getVisibility()
            if (r0 == r1) goto L_0x0118
            android.widget.TextView r0 = r10.f564m
            r0.setVisibility(r1)
        L_0x0118:
            android.graphics.drawable.Drawable r0 = r11.getIcon()
            r10.setIcon(r0)
            boolean r0 = r11.isEnabled()
            r10.setEnabled(r0)
            boolean r0 = r11.hasSubMenu()
            r10.setSubMenuArrowVisible(r0)
            java.lang.CharSequence r11 = r11.f10015q
            r10.setContentDescription(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.b(m.q):void");
    }

    public q getItemData() {
        return this.f559h;
    }

    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = c1.f10054a;
        i0.q(this, this.f568q);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f562k = textView;
        int i10 = this.f569r;
        if (i10 != -1) {
            textView.setTextAppearance(this.f570s, i10);
        }
        this.f564m = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f565n = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f572u);
        }
        this.f566o = (ImageView) findViewById(R.id.group_divider);
        this.f567p = (LinearLayout) findViewById(R.id.content);
    }

    public final void onMeasure(int i10, int i11) {
        if (this.f560i != null && this.f571t) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f560i.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
        boolean z11;
        View view;
        CompoundButton compoundButton;
        if (z10 || this.f561j != null || this.f563l != null) {
            if ((this.f559h.f10022x & 4) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (this.f561j == null) {
                    RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
                    this.f561j = radioButton;
                    LinearLayout linearLayout = this.f567p;
                    if (linearLayout != null) {
                        linearLayout.addView(radioButton, -1);
                    } else {
                        addView(radioButton, -1);
                    }
                }
                compoundButton = this.f561j;
                view = this.f563l;
            } else {
                if (this.f563l == null) {
                    CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
                    this.f563l = checkBox;
                    LinearLayout linearLayout2 = this.f567p;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(checkBox, -1);
                    } else {
                        addView(checkBox, -1);
                    }
                }
                compoundButton = this.f563l;
                view = this.f561j;
            }
            if (z10) {
                compoundButton.setChecked(this.f559h.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox2 = this.f563l;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
            RadioButton radioButton2 = this.f561j;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z10) {
        boolean z11;
        CompoundButton compoundButton;
        if ((this.f559h.f10022x & 4) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (this.f561j == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
                this.f561j = radioButton;
                LinearLayout linearLayout = this.f567p;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f561j;
        } else {
            if (this.f563l == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
                this.f563l = checkBox;
                LinearLayout linearLayout2 = this.f567p;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f563l;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f575x = z10;
        this.f571t = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f566o;
        if (imageView != null) {
            imageView.setVisibility((this.f573v || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f559h.f10012n.getClass();
        boolean z10 = this.f575x;
        if (z10 || this.f571t) {
            ImageView imageView = this.f560i;
            if (imageView != null || drawable != null || this.f571t) {
                if (imageView == null) {
                    ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
                    this.f560i = imageView2;
                    LinearLayout linearLayout = this.f567p;
                    if (linearLayout != null) {
                        linearLayout.addView(imageView2, 0);
                    } else {
                        addView(imageView2, 0);
                    }
                }
                if (drawable != null || this.f571t) {
                    ImageView imageView3 = this.f560i;
                    if (!z10) {
                        drawable = null;
                    }
                    imageView3.setImageDrawable(drawable);
                    if (this.f560i.getVisibility() != 0) {
                        this.f560i.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f560i.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        int i10;
        if (charSequence != null) {
            this.f562k.setText(charSequence);
            if (this.f562k.getVisibility() != 0) {
                textView = this.f562k;
                i10 = 0;
            } else {
                return;
            }
        } else {
            i10 = 8;
            if (this.f562k.getVisibility() != 8) {
                textView = this.f562k;
            } else {
                return;
            }
        }
        textView.setVisibility(i10);
    }
}
