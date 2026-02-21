package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.fragment.app.c0;
import b7.c;
import b7.i;
import com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment;
import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchFragment;
import com.woxthebox.draglistview.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import l.d;
import l6.f;
import r0.b;
import xa.j;

public class SearchView extends t2 implements d {

    /* renamed from: p0  reason: collision with root package name */
    public static final g4 f641p0 = (Build.VERSION.SDK_INT < 29 ? new g4() : null);
    public final ImageView A;
    public final ImageView B;
    public final ImageView C;
    public final ImageView D;
    public final View E;
    public k4 F;
    public final Rect G = new Rect();
    public final Rect H = new Rect();
    public final int[] I = new int[2];
    public final int[] J = new int[2];
    public final ImageView K;
    public final Drawable L;
    public final int M;
    public final int N;
    public final Intent O;
    public final Intent P;
    public final CharSequence Q;
    public e4 R;
    public View.OnFocusChangeListener S;
    public View.OnClickListener T;
    public boolean U;
    public boolean V;
    public b W;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f642a0;

    /* renamed from: b0  reason: collision with root package name */
    public CharSequence f643b0;

    /* renamed from: c0  reason: collision with root package name */
    public boolean f644c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f645d0;

    /* renamed from: e0  reason: collision with root package name */
    public int f646e0;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f647f0;

    /* renamed from: g0  reason: collision with root package name */
    public String f648g0;

    /* renamed from: h0  reason: collision with root package name */
    public CharSequence f649h0;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f650i0;

    /* renamed from: j0  reason: collision with root package name */
    public int f651j0;

    /* renamed from: k0  reason: collision with root package name */
    public SearchableInfo f652k0;

    /* renamed from: l0  reason: collision with root package name */
    public Bundle f653l0;

    /* renamed from: m0  reason: collision with root package name */
    public final v3 f654m0 = new v3(this, 0);

    /* renamed from: n0  reason: collision with root package name */
    public final v3 f655n0 = new v3(this, 1);

    /* renamed from: o0  reason: collision with root package name */
    public final WeakHashMap f656o0 = new WeakHashMap();

    /* renamed from: w  reason: collision with root package name */
    public final SearchAutoComplete f657w;

    /* renamed from: x  reason: collision with root package name */
    public final View f658x;

    /* renamed from: y  reason: collision with root package name */
    public final View f659y;

    /* renamed from: z  reason: collision with root package name */
    public final View f660z;

    public static class SearchAutoComplete extends a0 {

        /* renamed from: l  reason: collision with root package name */
        public int f661l = getThreshold();

        /* renamed from: m  reason: collision with root package name */
        public SearchView f662m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f663n;

        /* renamed from: o  reason: collision with root package name */
        public final j4 f664o = new j4(this);

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 < 600) {
                return (i10 < 640 || i11 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                c4.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            g4 g4Var = SearchView.f641p0;
            g4Var.getClass();
            g4.a();
            Method method = g4Var.f838c;
            if (method != null) {
                try {
                    method.invoke(this, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }

        public final boolean enoughToFilter() {
            return this.f661l <= 0 || super.enoughToFilter();
        }

        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f663n) {
                j4 j4Var = this.f664o;
                removeCallbacks(j4Var);
                post(j4Var);
            }
            return onCreateInputConnection;
        }

        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        public final void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            SearchView searchView = this.f662m;
            searchView.y(searchView.V);
            searchView.post(searchView.f654m0);
            if (searchView.f657w.hasFocus()) {
                searchView.n();
            }
        }

        public final boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f662m.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        public final void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f662m.hasFocus() && getVisibility() == 0) {
                boolean z11 = true;
                this.f663n = true;
                Context context = getContext();
                g4 g4Var = SearchView.f641p0;
                if (context.getResources().getConfiguration().orientation != 2) {
                    z11 = false;
                }
                if (z11) {
                    a();
                }
            }
        }

        public final void performCompletion() {
        }

        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            j4 j4Var = this.f664o;
            if (!z10) {
                this.f663n = false;
                removeCallbacks(j4Var);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f663n = false;
                removeCallbacks(j4Var);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f663n = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f662m = searchView;
        }

        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f661l = i10;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SearchView(android.content.Context r18, android.util.AttributeSet r19) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            r3 = r19
            r0 = 2130969614(0x7f04040e, float:1.7547915E38)
            r6.<init>(r7, r3, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r6.G = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r6.H = r1
            r1 = 2
            int[] r2 = new int[r1]
            r6.I = r2
            int[] r1 = new int[r1]
            r6.J = r1
            androidx.appcompat.widget.v3 r1 = new androidx.appcompat.widget.v3
            r2 = 0
            r1.<init>(r6, r2)
            r6.f654m0 = r1
            androidx.appcompat.widget.v3 r1 = new androidx.appcompat.widget.v3
            r8 = 1
            r1.<init>(r6, r8)
            r6.f655n0 = r1
            java.util.WeakHashMap r1 = new java.util.WeakHashMap
            r1.<init>()
            r6.f656o0 = r1
            androidx.appcompat.widget.y3 r9 = new androidx.appcompat.widget.y3
            r9.<init>(r6)
            androidx.appcompat.widget.z3 r10 = new androidx.appcompat.widget.z3
            r10.<init>(r6)
            androidx.appcompat.widget.a4 r11 = new androidx.appcompat.widget.a4
            r11.<init>(r6)
            androidx.appcompat.widget.b4 r12 = new androidx.appcompat.widget.b4
            r12.<init>(r6, r2)
            androidx.appcompat.widget.v2 r13 = new androidx.appcompat.widget.v2
            r13.<init>(r8, r6)
            androidx.appcompat.widget.u3 r14 = new androidx.appcompat.widget.u3
            r14.<init>(r2, r6)
            int[] r4 = f.a.f5412v
            androidx.appcompat.widget.u4 r15 = new androidx.appcompat.widget.u4
            android.content.res.TypedArray r5 = r7.obtainStyledAttributes(r3, r4, r0, r2)
            r15.<init>(r7, r5)
            r16 = 2130969614(0x7f04040e, float:1.7547915E38)
            r0 = r17
            r1 = r18
            r2 = r4
            r4 = r5
            r5 = r16
            m0.c1.o(r0, r1, r2, r3, r4, r5)
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r18)
            r1 = 17
            r2 = 2131558425(0x7f0d0019, float:1.8742165E38)
            int r1 = r15.i(r1, r2)
            r0.inflate(r1, r6, r8)
            r0 = 2131362414(0x7f0a026e, float:1.8344608E38)
            android.view.View r0 = r6.findViewById(r0)
            androidx.appcompat.widget.SearchView$SearchAutoComplete r0 = (androidx.appcompat.widget.SearchView.SearchAutoComplete) r0
            r6.f657w = r0
            r0.setSearchView(r6)
            r1 = 2131362410(0x7f0a026a, float:1.83446E38)
            android.view.View r1 = r6.findViewById(r1)
            r6.f658x = r1
            r1 = 2131362413(0x7f0a026d, float:1.8344606E38)
            android.view.View r1 = r6.findViewById(r1)
            r6.f659y = r1
            r2 = 2131362499(0x7f0a02c3, float:1.834478E38)
            android.view.View r2 = r6.findViewById(r2)
            r6.f660z = r2
            r3 = 2131362408(0x7f0a0268, float:1.8344596E38)
            android.view.View r3 = r6.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r6.A = r3
            r4 = 2131362411(0x7f0a026b, float:1.8344602E38)
            android.view.View r4 = r6.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r6.B = r4
            r5 = 2131362409(0x7f0a0269, float:1.8344598E38)
            android.view.View r5 = r6.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r6.C = r5
            r7 = 2131362428(0x7f0a027c, float:1.8344636E38)
            android.view.View r7 = r6.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r6.D = r7
            r8 = 2131362412(0x7f0a026c, float:1.8344604E38)
            android.view.View r8 = r6.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r6.K = r8
            r16 = r10
            r10 = 18
            android.graphics.drawable.Drawable r10 = r15.e(r10)
            m0.i0.q(r1, r10)
            r1 = 23
            android.graphics.drawable.Drawable r1 = r15.e(r1)
            m0.i0.q(r2, r1)
            r1 = 21
            android.graphics.drawable.Drawable r2 = r15.e(r1)
            r3.setImageDrawable(r2)
            r2 = 13
            android.graphics.drawable.Drawable r2 = r15.e(r2)
            r4.setImageDrawable(r2)
            r2 = 10
            android.graphics.drawable.Drawable r2 = r15.e(r2)
            r5.setImageDrawable(r2)
            r2 = 26
            android.graphics.drawable.Drawable r2 = r15.e(r2)
            r7.setImageDrawable(r2)
            android.graphics.drawable.Drawable r1 = r15.e(r1)
            r8.setImageDrawable(r1)
            r1 = 20
            android.graphics.drawable.Drawable r1 = r15.e(r1)
            r6.L = r1
            android.content.res.Resources r1 = r17.getResources()
            r2 = 2131951637(0x7f130015, float:1.9539694E38)
            java.lang.String r1 = r1.getString(r2)
            androidx.appcompat.widget.f5.a(r3, r1)
            r1 = 24
            r2 = 2131558424(0x7f0d0018, float:1.8742163E38)
            int r1 = r15.i(r1, r2)
            r6.M = r1
            r1 = 11
            r2 = 0
            int r1 = r15.i(r1, r2)
            r6.N = r1
            r3.setOnClickListener(r9)
            r5.setOnClickListener(r9)
            r4.setOnClickListener(r9)
            r7.setOnClickListener(r9)
            r0.setOnClickListener(r9)
            r0.addTextChangedListener(r14)
            r0.setOnEditorActionListener(r11)
            r0.setOnItemClickListener(r12)
            r0.setOnItemSelectedListener(r13)
            r1 = r16
            r0.setOnKeyListener(r1)
            androidx.appcompat.widget.w3 r1 = new androidx.appcompat.widget.w3
            r1.<init>(r6)
            r0.setOnFocusChangeListener(r1)
            r1 = 16
            r2 = 1
            boolean r1 = r15.a(r1, r2)
            r6.setIconifiedByDefault(r1)
            r1 = -1
            r2 = 2
            int r2 = r15.d(r2, r1)
            if (r2 == r1) goto L_0x0187
            r6.setMaxWidth(r2)
        L_0x0187:
            r2 = 12
            java.lang.CharSequence r2 = r15.k(r2)
            r6.Q = r2
            r2 = 19
            java.lang.CharSequence r2 = r15.k(r2)
            r6.f643b0 = r2
            r2 = 6
            int r2 = r15.h(r2, r1)
            if (r2 == r1) goto L_0x01a1
            r6.setImeOptions(r2)
        L_0x01a1:
            r2 = 5
            int r2 = r15.h(r2, r1)
            if (r2 == r1) goto L_0x01ab
            r6.setInputType(r2)
        L_0x01ab:
            r1 = 1
            boolean r1 = r15.a(r1, r1)
            r6.setFocusable(r1)
            r15.n()
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "android.speech.action.WEB_SEARCH"
            r1.<init>(r2)
            r6.O = r1
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r2)
            java.lang.String r3 = "android.speech.extra.LANGUAGE_MODEL"
            java.lang.String r4 = "web_search"
            r1.putExtra(r3, r4)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r3 = "android.speech.action.RECOGNIZE_SPEECH"
            r1.<init>(r3)
            r6.P = r1
            r1.addFlags(r2)
            int r0 = r0.getDropDownAnchor()
            android.view.View r0 = r6.findViewById(r0)
            r6.E = r0
            if (r0 == 0) goto L_0x01ec
            androidx.appcompat.widget.x3 r1 = new androidx.appcompat.widget.x3
            r2 = 0
            r1.<init>(r2, r6)
            r0.addOnLayoutChangeListener(r1)
        L_0x01ec:
            boolean r0 = r6.U
            r6.y(r0)
            r17.v()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f657w;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public final void a() {
        if (!this.f650i0) {
            this.f650i0 = true;
            SearchAutoComplete searchAutoComplete = this.f657w;
            int imeOptions = searchAutoComplete.getImeOptions();
            this.f651j0 = imeOptions;
            searchAutoComplete.setImeOptions(imeOptions | 33554432);
            searchAutoComplete.setText("");
            setIconified(false);
        }
    }

    public final void clearFocus() {
        this.f645d0 = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f657w;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f645d0 = false;
    }

    public final void e() {
        SearchAutoComplete searchAutoComplete = this.f657w;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f649h0 = "";
        clearFocus();
        y(true);
        searchAutoComplete.setImeOptions(this.f651j0);
        this.f650i0 = false;
    }

    public int getImeOptions() {
        return this.f657w.getImeOptions();
    }

    public int getInputType() {
        return this.f657w.getInputType();
    }

    public int getMaxWidth() {
        return this.f646e0;
    }

    public CharSequence getQuery() {
        return this.f657w.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f643b0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f652k0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.Q : getContext().getText(this.f652k0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.N;
    }

    public int getSuggestionRowLayout() {
        return this.M;
    }

    public b getSuggestionsAdapter() {
        return this.W;
    }

    public final Intent l(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f649h0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f653l0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f652k0.getSearchActivity());
        return intent;
    }

    public final Intent m(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f653l0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void n() {
        int i10 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f657w;
        if (i10 >= 29) {
            c4.a(searchAutoComplete);
            return;
        }
        g4 g4Var = f641p0;
        g4Var.getClass();
        g4.a();
        Method method = g4Var.f836a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused) {
            }
        }
        g4Var.getClass();
        g4.a();
        Method method2 = g4Var.f837b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused2) {
            }
        }
    }

    public final void o() {
        SearchAutoComplete searchAutoComplete = this.f657w;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.U) {
            clearFocus();
            y(true);
        }
    }

    public final void onDetachedFromWindow() {
        removeCallbacks(this.f654m0);
        post(this.f655n0);
        super.onDetachedFromWindow();
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            SearchAutoComplete searchAutoComplete = this.f657w;
            int[] iArr = this.I;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.J;
            getLocationInWindow(iArr2);
            int i14 = iArr[1] - iArr2[1];
            int i15 = iArr[0] - iArr2[0];
            Rect rect = this.G;
            rect.set(i15, i14, searchAutoComplete.getWidth() + i15, searchAutoComplete.getHeight() + i14);
            int i16 = rect.left;
            int i17 = rect.right;
            int i18 = i13 - i11;
            Rect rect2 = this.H;
            rect2.set(i16, 0, i17, i18);
            k4 k4Var = this.F;
            if (k4Var == null) {
                k4 k4Var2 = new k4(rect2, rect, searchAutoComplete);
                this.F = k4Var2;
                setTouchDelegate(k4Var2);
                return;
            }
            k4Var.f914b.set(rect2);
            Rect rect3 = k4Var.f916d;
            rect3.set(rect2);
            int i19 = -k4Var.f917e;
            rect3.inset(i19, i19);
            k4Var.f915c.set(rect);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r0 <= 0) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.V
            if (r0 == 0) goto L_0x0008
            super.onMeasure(r4, r5)
            return
        L_0x0008:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x002a
            if (r0 == 0) goto L_0x0020
            if (r0 == r2) goto L_0x001b
            goto L_0x0037
        L_0x001b:
            int r0 = r3.f646e0
            if (r0 <= 0) goto L_0x0037
            goto L_0x002e
        L_0x0020:
            int r4 = r3.f646e0
            if (r4 <= 0) goto L_0x0025
            goto L_0x0037
        L_0x0025:
            int r4 = r3.getPreferredWidth()
            goto L_0x0037
        L_0x002a:
            int r0 = r3.f646e0
            if (r0 <= 0) goto L_0x002f
        L_0x002e:
            goto L_0x0033
        L_0x002f:
            int r0 = r3.getPreferredWidth()
        L_0x0033:
            int r4 = java.lang.Math.min(r0, r4)
        L_0x0037:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L_0x0049
            if (r0 == 0) goto L_0x0044
            goto L_0x0051
        L_0x0044:
            int r5 = r3.getPreferredHeight()
            goto L_0x0051
        L_0x0049:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L_0x0051:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof i4)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i4 i4Var = (i4) parcelable;
        super.onRestoreInstanceState(i4Var.f14484h);
        y(i4Var.f872j);
        requestLayout();
    }

    public final Parcelable onSaveInstanceState() {
        i4 i4Var = new i4(super.onSaveInstanceState());
        i4Var.f872j = this.V;
        return i4Var;
    }

    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        post(this.f654m0);
    }

    public final void p(int i10) {
        int i11;
        Uri uri;
        String h10;
        Cursor cursor = this.W.f13523j;
        if (cursor != null && cursor.moveToPosition(i10)) {
            Intent intent = null;
            try {
                int i12 = m4.E;
                String h11 = m4.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (h11 == null) {
                    h11 = this.f652k0.getSuggestIntentAction();
                }
                if (h11 == null) {
                    h11 = "android.intent.action.SEARCH";
                }
                String h12 = m4.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (h12 == null) {
                    h12 = this.f652k0.getSuggestIntentData();
                }
                if (!(h12 == null || (h10 = m4.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) == null)) {
                    h12 = h12 + Constants.LIST_SEPARATOR + Uri.encode(h10);
                }
                if (h12 == null) {
                    uri = null;
                } else {
                    uri = Uri.parse(h12);
                }
                intent = l(h11, uri, m4.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), m4.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e10) {
                try {
                    i11 = cursor.getPosition();
                } catch (RuntimeException unused) {
                    i11 = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + i11 + " returned exception.", e10);
            }
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException e11) {
                    Log.e("SearchView", "Failed launch activity: " + intent, e11);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f657w;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void q(int i10) {
        String c10;
        Editable text = this.f657w.getText();
        Cursor cursor = this.W.f13523j;
        if (cursor != null) {
            if (!cursor.moveToPosition(i10) || (c10 = this.W.c(cursor)) == null) {
                setQuery(text);
            } else {
                setQuery(c10);
            }
        }
    }

    public final void r(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final boolean requestFocus(int i10, Rect rect) {
        if (this.f645d0 || !isFocusable()) {
            return false;
        }
        if (this.V) {
            return super.requestFocus(i10, rect);
        }
        boolean requestFocus = this.f657w.requestFocus(i10, rect);
        if (requestFocus) {
            y(false);
        }
        return requestFocus;
    }

    public final void s() {
        i iVar;
        SearchAutoComplete searchAutoComplete = this.f657w;
        Editable text = searchAutoComplete.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            e4 e4Var = this.R;
            if (e4Var != null) {
                String charSequence = text.toString();
                c cVar = (c) e4Var;
                int i10 = cVar.f2649a;
                f fVar = cVar.f2651c;
                switch (i10) {
                    case 0:
                        j.f("query", charSequence);
                        c0 q02 = ((SearchPagerFragment) fVar).q0();
                        if (q02 instanceof i) {
                            iVar = (i) q02;
                        } else {
                            iVar = null;
                        }
                        if (iVar != null) {
                            iVar.k(charSequence);
                            break;
                        }
                        break;
                    default:
                        j.f("query", charSequence);
                        TagSearchFragment.s0((TagSearchFragment) fVar, charSequence);
                        break;
                }
            }
            if (this.f652k0 != null) {
                getContext().startActivity(l("android.intent.action.SEARCH", (Uri) null, (String) null, text.toString()));
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    public void setAppSearchData(Bundle bundle) {
        this.f653l0 = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            o();
            return;
        }
        y(false);
        SearchAutoComplete searchAutoComplete = this.f657w;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.T;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.U != z10) {
            this.U = z10;
            y(z10);
            v();
        }
    }

    public void setImeOptions(int i10) {
        this.f657w.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.f657w.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.f646e0 = i10;
        requestLayout();
    }

    public void setOnCloseListener(d4 d4Var) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.S = onFocusChangeListener;
    }

    public void setOnQueryTextListener(e4 e4Var) {
        this.R = e4Var;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.T = onClickListener;
    }

    public void setOnSuggestionListener(f4 f4Var) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f643b0 = charSequence;
        v();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        int i10;
        this.f644c0 = z10;
        b bVar = this.W;
        if (bVar instanceof m4) {
            m4 m4Var = (m4) bVar;
            if (z10) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            m4Var.f940w = i10;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
        if (getContext().getPackageManager().resolveActivity(r3, 65536) != null) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSearchableInfo(android.app.SearchableInfo r8) {
        /*
            r7 = this;
            r7.f652k0 = r8
            androidx.appcompat.widget.SearchView$SearchAutoComplete r0 = r7.f657w
            r1 = 1
            r2 = 65536(0x10000, float:9.18355E-41)
            r3 = 0
            if (r8 == 0) goto L_0x0068
            int r8 = r8.getSuggestThreshold()
            r0.setThreshold(r8)
            android.app.SearchableInfo r8 = r7.f652k0
            int r8 = r8.getImeOptions()
            r0.setImeOptions(r8)
            android.app.SearchableInfo r8 = r7.f652k0
            int r8 = r8.getInputType()
            r4 = r8 & 15
            if (r4 != r1) goto L_0x0034
            r4 = -65537(0xfffffffffffeffff, float:NaN)
            r8 = r8 & r4
            android.app.SearchableInfo r4 = r7.f652k0
            java.lang.String r4 = r4.getSuggestAuthority()
            if (r4 == 0) goto L_0x0034
            r8 = r8 | r2
            r4 = 524288(0x80000, float:7.34684E-40)
            r8 = r8 | r4
        L_0x0034:
            r0.setInputType(r8)
            r0.b r8 = r7.W
            if (r8 == 0) goto L_0x003e
            r8.b(r3)
        L_0x003e:
            android.app.SearchableInfo r8 = r7.f652k0
            java.lang.String r8 = r8.getSuggestAuthority()
            if (r8 == 0) goto L_0x0065
            androidx.appcompat.widget.m4 r8 = new androidx.appcompat.widget.m4
            android.content.Context r4 = r7.getContext()
            android.app.SearchableInfo r5 = r7.f652k0
            java.util.WeakHashMap r6 = r7.f656o0
            r8.<init>(r4, r7, r5, r6)
            r7.W = r8
            r0.setAdapter(r8)
            r0.b r8 = r7.W
            androidx.appcompat.widget.m4 r8 = (androidx.appcompat.widget.m4) r8
            boolean r4 = r7.f644c0
            if (r4 == 0) goto L_0x0062
            r4 = 2
            goto L_0x0063
        L_0x0062:
            r4 = 1
        L_0x0063:
            r8.f940w = r4
        L_0x0065:
            r7.v()
        L_0x0068:
            android.app.SearchableInfo r8 = r7.f652k0
            if (r8 == 0) goto L_0x0098
            boolean r8 = r8.getVoiceSearchEnabled()
            if (r8 == 0) goto L_0x0098
            android.app.SearchableInfo r8 = r7.f652k0
            boolean r8 = r8.getVoiceSearchLaunchWebSearch()
            if (r8 == 0) goto L_0x007d
            android.content.Intent r3 = r7.O
            goto L_0x0087
        L_0x007d:
            android.app.SearchableInfo r8 = r7.f652k0
            boolean r8 = r8.getVoiceSearchLaunchRecognizer()
            if (r8 == 0) goto L_0x0087
            android.content.Intent r3 = r7.P
        L_0x0087:
            if (r3 == 0) goto L_0x0098
            android.content.Context r8 = r7.getContext()
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            android.content.pm.ResolveInfo r8 = r8.resolveActivity(r3, r2)
            if (r8 == 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r1 = 0
        L_0x0099:
            r7.f647f0 = r1
            if (r1 == 0) goto L_0x00a2
            java.lang.String r8 = "nm"
            r0.setPrivateImeOptions(r8)
        L_0x00a2:
            boolean r8 = r7.V
            r7.y(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.f642a0 = z10;
        y(this.V);
    }

    public void setSuggestionsAdapter(b bVar) {
        this.W = bVar;
        this.f657w.setAdapter(bVar);
    }

    public final void t() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f657w.getText());
        int i10 = 0;
        if (!z11 && (!this.U || this.f650i0)) {
            z10 = false;
        }
        if (!z10) {
            i10 = 8;
        }
        ImageView imageView = this.C;
        imageView.setVisibility(i10);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(z11 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void u() {
        int[] iArr = this.f657w.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f659y.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f660z.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void v() {
        Drawable drawable;
        SpannableStringBuilder queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z10 = this.U;
        SearchAutoComplete searchAutoComplete = this.f657w;
        if (z10 && (drawable = this.L) != null) {
            int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void w() {
        boolean z10;
        int i10 = 0;
        if ((this.f642a0 || this.f647f0) && !this.V) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || !(this.B.getVisibility() == 0 || this.D.getVisibility() == 0)) {
            i10 = 8;
        }
        this.f660z.setVisibility(i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        if (r2.f647f0 == false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x(boolean r3) {
        /*
            r2 = this;
            boolean r0 = r2.f642a0
            if (r0 == 0) goto L_0x0021
            r1 = 0
            if (r0 != 0) goto L_0x000b
            boolean r0 = r2.f647f0
            if (r0 == 0) goto L_0x0011
        L_0x000b:
            boolean r0 = r2.V
            if (r0 != 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 == 0) goto L_0x0021
            boolean r0 = r2.hasFocus()
            if (r0 == 0) goto L_0x0021
            if (r3 != 0) goto L_0x0023
            boolean r3 = r2.f647f0
            if (r3 != 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r1 = 8
        L_0x0023:
            android.widget.ImageView r3 = r2.B
            r3.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.x(boolean):void");
    }

    public final void y(boolean z10) {
        int i10;
        int i11;
        int i12;
        this.V = z10;
        int i13 = 8;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        boolean z11 = !TextUtils.isEmpty(this.f657w.getText());
        this.A.setVisibility(i10);
        x(z11);
        if (z10) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        this.f658x.setVisibility(i11);
        ImageView imageView = this.K;
        if (imageView.getDrawable() == null || this.U) {
            i12 = 8;
        } else {
            i12 = 0;
        }
        imageView.setVisibility(i12);
        t();
        boolean z12 = !z11;
        if (this.f647f0 && !this.V && z12) {
            this.B.setVisibility(8);
            i13 = 0;
        }
        this.D.setVisibility(i13);
        w();
    }
}
