package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.woxthebox.draglistview.R;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;
import r0.b;

public final class m4 extends b implements View.OnClickListener {
    public static final /* synthetic */ int E = 0;
    public int A = -1;
    public int B = -1;
    public int C = -1;
    public int D = -1;

    /* renamed from: o  reason: collision with root package name */
    public final int f932o;

    /* renamed from: p  reason: collision with root package name */
    public final int f933p;

    /* renamed from: q  reason: collision with root package name */
    public final LayoutInflater f934q;

    /* renamed from: r  reason: collision with root package name */
    public final SearchView f935r;

    /* renamed from: s  reason: collision with root package name */
    public final SearchableInfo f936s;

    /* renamed from: t  reason: collision with root package name */
    public final Context f937t;

    /* renamed from: u  reason: collision with root package name */
    public final WeakHashMap f938u;

    /* renamed from: v  reason: collision with root package name */
    public final int f939v;

    /* renamed from: w  reason: collision with root package name */
    public int f940w = 1;

    /* renamed from: x  reason: collision with root package name */
    public ColorStateList f941x;

    /* renamed from: y  reason: collision with root package name */
    public int f942y = -1;

    /* renamed from: z  reason: collision with root package name */
    public int f943z = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m4(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context);
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f933p = suggestionRowLayout;
        this.f932o = suggestionRowLayout;
        this.f934q = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f935r = searchView;
        this.f936s = searchableInfo;
        this.f939v = searchView.getSuggestionCommitIconResId();
        this.f937t = context;
        this.f938u = weakHashMap;
    }

    public static String h(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: android.text.SpannableString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r21, android.database.Cursor r22) {
        /*
            r20 = this;
            r1 = r20
            r2 = r22
            java.lang.Object r0 = r21.getTag()
            r3 = r0
            androidx.appcompat.widget.l4 r3 = (androidx.appcompat.widget.l4) r3
            int r0 = r1.D
            r4 = 0
            r5 = -1
            if (r0 == r5) goto L_0x0017
            int r0 = r2.getInt(r0)
            r6 = r0
            goto L_0x0019
        L_0x0017:
            r0 = 0
            r6 = 0
        L_0x0019:
            android.widget.TextView r7 = r3.f919a
            if (r7 == 0) goto L_0x0033
            int r0 = r1.f942y
            java.lang.String r0 = h(r2, r0)
            r7.setText(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x002f
            r0 = 8
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            r7.setVisibility(r0)
        L_0x0033:
            r8 = 1
            r0 = 2
            android.content.Context r9 = r1.f937t
            android.widget.TextView r10 = r3.f920b
            if (r10 == 0) goto L_0x00b6
            int r11 = r1.A
            java.lang.String r11 = h(r2, r11)
            if (r11 == 0) goto L_0x0089
            android.content.res.ColorStateList r12 = r1.f941x
            if (r12 != 0) goto L_0x0062
            android.util.TypedValue r12 = new android.util.TypedValue
            r12.<init>()
            android.content.res.Resources$Theme r13 = r9.getTheme()
            r14 = 2130969826(0x7f0404e2, float:1.7548345E38)
            r13.resolveAttribute(r14, r12, r8)
            android.content.res.Resources r13 = r9.getResources()
            int r12 = r12.resourceId
            android.content.res.ColorStateList r12 = r13.getColorStateList(r12)
            r1.f941x = r12
        L_0x0062:
            android.text.SpannableString r12 = new android.text.SpannableString
            r12.<init>(r11)
            android.text.style.TextAppearanceSpan r15 = new android.text.style.TextAppearanceSpan
            r14 = 0
            r16 = 0
            r17 = 0
            android.content.res.ColorStateList r13 = r1.f941x
            r18 = 0
            r19 = r13
            r13 = r15
            r5 = r15
            r15 = r16
            r16 = r17
            r17 = r19
            r13.<init>(r14, r15, r16, r17, r18)
            int r11 = r11.length()
            r13 = 33
            r12.setSpan(r5, r4, r11, r13)
            goto L_0x008f
        L_0x0089:
            int r5 = r1.f943z
            java.lang.String r12 = h(r2, r5)
        L_0x008f:
            boolean r5 = android.text.TextUtils.isEmpty(r12)
            if (r5 == 0) goto L_0x009e
            if (r7 == 0) goto L_0x00a6
            r7.setSingleLine(r4)
            r7.setMaxLines(r0)
            goto L_0x00a6
        L_0x009e:
            if (r7 == 0) goto L_0x00a6
            r7.setSingleLine(r8)
            r7.setMaxLines(r8)
        L_0x00a6:
            r10.setText(r12)
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x00b2
            r0 = 8
            goto L_0x00b3
        L_0x00b2:
            r0 = 0
        L_0x00b3:
            r10.setVisibility(r0)
        L_0x00b6:
            android.widget.ImageView r5 = r3.f921c
            if (r5 == 0) goto L_0x015a
            int r0 = r1.B
            r10 = -1
            if (r0 != r10) goto L_0x00c2
            r0 = 0
            goto L_0x0147
        L_0x00c2:
            java.lang.String r0 = r2.getString(r0)
            android.graphics.drawable.Drawable r0 = r1.f(r0)
            if (r0 == 0) goto L_0x00ce
            goto L_0x0147
        L_0x00ce:
            android.app.SearchableInfo r0 = r1.f936s
            android.content.ComponentName r0 = r0.getSearchActivity()
            java.lang.String r10 = r0.flattenToShortString()
            java.util.WeakHashMap r11 = r1.f938u
            boolean r12 = r11.containsKey(r10)
            if (r12 == 0) goto L_0x00f3
            java.lang.Object r0 = r11.get(r10)
            android.graphics.drawable.Drawable$ConstantState r0 = (android.graphics.drawable.Drawable.ConstantState) r0
            if (r0 != 0) goto L_0x00ea
            r0 = 0
            goto L_0x013c
        L_0x00ea:
            android.content.res.Resources r10 = r9.getResources()
            android.graphics.drawable.Drawable r0 = r0.newDrawable(r10)
            goto L_0x013c
        L_0x00f3:
            android.content.pm.PackageManager r12 = r9.getPackageManager()
            r13 = 128(0x80, float:1.794E-43)
            android.content.pm.ActivityInfo r13 = r12.getActivityInfo(r0, r13)     // Catch:{ NameNotFoundException -> 0x0124 }
            int r14 = r13.getIconResource()
            if (r14 != 0) goto L_0x0104
            goto L_0x012f
        L_0x0104:
            java.lang.String r15 = r0.getPackageName()
            android.content.pm.ApplicationInfo r13 = r13.applicationInfo
            android.graphics.drawable.Drawable r12 = r12.getDrawable(r15, r14, r13)
            if (r12 != 0) goto L_0x0130
            java.lang.String r12 = "Invalid icon resource "
            java.lang.String r13 = " for "
            java.lang.StringBuilder r12 = android.support.v4.media.h.r(r12, r14, r13)
            java.lang.String r0 = r0.flattenToShortString()
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            goto L_0x012a
        L_0x0124:
            r0 = move-exception
            r12 = r0
            java.lang.String r0 = r12.toString()
        L_0x012a:
            java.lang.String r12 = "SuggestionsAdapter"
            android.util.Log.w(r12, r0)
        L_0x012f:
            r12 = 0
        L_0x0130:
            if (r12 != 0) goto L_0x0134
            r0 = 0
            goto L_0x0138
        L_0x0134:
            android.graphics.drawable.Drawable$ConstantState r0 = r12.getConstantState()
        L_0x0138:
            r11.put(r10, r0)
            r0 = r12
        L_0x013c:
            if (r0 == 0) goto L_0x013f
            goto L_0x0147
        L_0x013f:
            android.content.pm.PackageManager r0 = r9.getPackageManager()
            android.graphics.drawable.Drawable r0 = r0.getDefaultActivityIcon()
        L_0x0147:
            r5.setImageDrawable(r0)
            if (r0 != 0) goto L_0x0151
            r0 = 4
            r5.setVisibility(r0)
            goto L_0x015a
        L_0x0151:
            r5.setVisibility(r4)
            r0.setVisible(r4, r4)
            r0.setVisible(r8, r4)
        L_0x015a:
            android.widget.ImageView r0 = r3.f922d
            if (r0 == 0) goto L_0x0181
            int r5 = r1.C
            r9 = -1
            if (r5 != r9) goto L_0x0165
            r2 = 0
            goto L_0x016d
        L_0x0165:
            java.lang.String r2 = r2.getString(r5)
            android.graphics.drawable.Drawable r2 = r1.f(r2)
        L_0x016d:
            r0.setImageDrawable(r2)
            if (r2 != 0) goto L_0x0178
            r2 = 8
            r0.setVisibility(r2)
            goto L_0x0181
        L_0x0178:
            r0.setVisibility(r4)
            r2.setVisible(r4, r4)
            r2.setVisible(r8, r4)
        L_0x0181:
            int r0 = r1.f940w
            android.widget.ImageView r2 = r3.f923e
            r3 = 2
            if (r0 == r3) goto L_0x0195
            if (r0 != r8) goto L_0x018f
            r0 = r6 & 1
            if (r0 == 0) goto L_0x018f
            goto L_0x0195
        L_0x018f:
            r0 = 8
            r2.setVisibility(r0)
            goto L_0x01a2
        L_0x0195:
            r2.setVisibility(r4)
            java.lang.CharSequence r0 = r7.getText()
            r2.setTag(r0)
            r2.setOnClickListener(r1)
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.m4.a(android.view.View, android.database.Cursor):void");
    }

    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f942y = cursor.getColumnIndex("suggest_text_1");
                this.f943z = cursor.getColumnIndex("suggest_text_2");
                this.A = cursor.getColumnIndex("suggest_text_2_url");
                this.B = cursor.getColumnIndex("suggest_icon_1");
                this.C = cursor.getColumnIndex("suggest_icon_2");
                this.D = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
        }
    }

    public final String c(Cursor cursor) {
        String h10;
        String h11;
        if (cursor == null) {
            return null;
        }
        String h12 = h(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (h12 != null) {
            return h12;
        }
        SearchableInfo searchableInfo = this.f936s;
        if (searchableInfo.shouldRewriteQueryFromData() && (h11 = h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return h11;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (h10 = h(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return h10;
    }

    public final View d(ViewGroup viewGroup) {
        View inflate = this.f934q.inflate(this.f932o, viewGroup, false);
        inflate.setTag(new l4(inflate));
        ((ImageView) inflate.findViewById(R.id.edit_query)).setImageResource(this.f939v);
        return inflate;
    }

    public final Drawable e(Uri uri) {
        int i10;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f937t.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i10 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i10 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i10 != 0) {
                        return resourcesForApplication.getDrawable(i10);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:34|35|36) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a1, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r3);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0090 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable f(java.lang.String r11) {
        /*
            r10 = this;
            java.util.WeakHashMap r0 = r10.f938u
            java.lang.String r1 = "SuggestionsAdapter"
            android.content.Context r2 = r10.f937t
            java.lang.String r3 = "android.resource://"
            r4 = 0
            if (r11 == 0) goto L_0x0115
            boolean r5 = r11.isEmpty()
            if (r5 != 0) goto L_0x0115
            java.lang.String r5 = "0"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x001b
            goto L_0x0115
        L_0x001b:
            int r5 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            r6.<init>(r3)     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            java.lang.String r3 = r2.getPackageName()     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            r6.append(r3)     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            java.lang.String r3 = "/"
            r6.append(r3)     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            r6.append(r5)     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            java.lang.String r3 = r6.toString()     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            java.lang.Object r6 = r0.get(r3)     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            android.graphics.drawable.Drawable$ConstantState r6 = (android.graphics.drawable.Drawable.ConstantState) r6     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            if (r6 != 0) goto L_0x0041
            r6 = r4
            goto L_0x0045
        L_0x0041:
            android.graphics.drawable.Drawable r6 = r6.newDrawable()     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
        L_0x0045:
            if (r6 == 0) goto L_0x0048
            return r6
        L_0x0048:
            java.lang.Object r6 = c0.g.f2717a     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            android.graphics.drawable.Drawable r5 = c0.c.b(r2, r5)     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            if (r5 == 0) goto L_0x0057
            android.graphics.drawable.Drawable$ConstantState r6 = r5.getConstantState()     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
            r0.put(r3, r6)     // Catch:{ NumberFormatException -> 0x0062, NotFoundException -> 0x0058 }
        L_0x0057:
            return r5
        L_0x0058:
            java.lang.String r0 = "Icon resource not found: "
            java.lang.String r11 = r0.concat(r11)
            android.util.Log.w(r1, r11)
            return r4
        L_0x0062:
            java.lang.Object r3 = r0.get(r11)
            android.graphics.drawable.Drawable$ConstantState r3 = (android.graphics.drawable.Drawable.ConstantState) r3
            if (r3 != 0) goto L_0x006c
            r3 = r4
            goto L_0x0070
        L_0x006c:
            android.graphics.drawable.Drawable r3 = r3.newDrawable()
        L_0x0070:
            if (r3 == 0) goto L_0x0073
            return r3
        L_0x0073:
            android.net.Uri r3 = android.net.Uri.parse(r11)
            java.lang.String r5 = "Error closing icon stream for "
            java.lang.String r6 = "Failed to open "
            java.lang.String r7 = "Resource does not exist: "
            java.lang.String r8 = r3.getScheme()     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.String r9 = "android.resource"
            boolean r8 = r9.equals(r8)     // Catch:{ FileNotFoundException -> 0x00ee }
            if (r8 == 0) goto L_0x00a2
            android.graphics.drawable.Drawable r1 = r10.e(r3)     // Catch:{ NotFoundException -> 0x0090 }
            r4 = r1
            goto L_0x010c
        L_0x0090:
            java.io.FileNotFoundException r2 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ee }
            r5.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00ee }
            r5.append(r3)     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00ee }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00ee }
            throw r2     // Catch:{ FileNotFoundException -> 0x00ee }
        L_0x00a2:
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ FileNotFoundException -> 0x00ee }
            java.io.InputStream r2 = r2.openInputStream(r3)     // Catch:{ FileNotFoundException -> 0x00ee }
            if (r2 == 0) goto L_0x00dc
            android.graphics.drawable.Drawable r6 = android.graphics.drawable.Drawable.createFromStream(r2, r4)     // Catch:{ all -> 0x00c6 }
            r2.close()     // Catch:{ IOException -> 0x00b4 }
            goto L_0x00c4
        L_0x00b4:
            r2 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ee }
            r7.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00ee }
            r7.append(r3)     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.String r5 = r7.toString()     // Catch:{ FileNotFoundException -> 0x00ee }
            android.util.Log.e(r1, r5, r2)     // Catch:{ FileNotFoundException -> 0x00ee }
        L_0x00c4:
            r4 = r6
            goto L_0x010c
        L_0x00c6:
            r6 = move-exception
            r2.close()     // Catch:{ IOException -> 0x00cb }
            goto L_0x00db
        L_0x00cb:
            r2 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ee }
            r7.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00ee }
            r7.append(r3)     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.String r5 = r7.toString()     // Catch:{ FileNotFoundException -> 0x00ee }
            android.util.Log.e(r1, r5, r2)     // Catch:{ FileNotFoundException -> 0x00ee }
        L_0x00db:
            throw r6     // Catch:{ FileNotFoundException -> 0x00ee }
        L_0x00dc:
            java.io.FileNotFoundException r2 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ee }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00ee }
            r5.append(r3)     // Catch:{ FileNotFoundException -> 0x00ee }
            java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00ee }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00ee }
            throw r2     // Catch:{ FileNotFoundException -> 0x00ee }
        L_0x00ee:
            r2 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Icon not found: "
            r5.<init>(r6)
            r5.append(r3)
            java.lang.String r3 = ", "
            r5.append(r3)
            java.lang.String r2 = r2.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            android.util.Log.w(r1, r2)
        L_0x010c:
            if (r4 == 0) goto L_0x0115
            android.graphics.drawable.Drawable$ConstantState r1 = r4.getConstantState()
            r0.put(r11, r1)
        L_0x0115:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.m4.f(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final Cursor g(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        fragment.appendQueryParameter("limit", String.valueOf(50));
        Uri build = fragment.build();
        return this.f937t.getContentResolver().query(build, (String[]) null, suggestSelection, strArr, (String) null);
    }

    public final View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View inflate = this.f934q.inflate(this.f933p, viewGroup, false);
            if (inflate != null) {
                ((l4) inflate.getTag()).f919a.setText(e10.toString());
            }
            return inflate;
        }
    }

    public final View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View d10 = d(viewGroup);
            ((l4) d10.getTag()).f919a.setText(e10.toString());
            return d10;
        }
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final void notifyDataSetChanged() {
        Bundle bundle;
        super.notifyDataSetChanged();
        Cursor cursor = this.f13523j;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    public final void notifyDataSetInvalidated() {
        Bundle bundle;
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f13523j;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f935r.r((CharSequence) tag);
        }
    }
}
