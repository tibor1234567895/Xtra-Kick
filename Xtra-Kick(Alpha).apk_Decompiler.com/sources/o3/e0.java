package o3;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import androidx.activity.h;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.SwitchPreference;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public final class e0 {

    /* renamed from: e  reason: collision with root package name */
    public static final Class[] f12119e = {Context.class, AttributeSet.class};

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap f12120f = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Context f12121a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f12122b = new Object[2];

    /* renamed from: c  reason: collision with root package name */
    public i0 f12123c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f12124d;

    public e0(Context context, i0 i0Var) {
        this.f12121a = context;
        this.f12123c = i0Var;
        this.f12124d = new String[]{Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
        r0 = new android.view.InflateException(r14.getPositionDescription() + ": Error inflating class " + r12);
        r0.initCause(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0096, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0097, code lost:
        throw r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076 A[ExcHandler: Exception (r13v4 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:2:0x000d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.preference.Preference a(java.lang.String r12, java.lang.String[] r13, android.util.AttributeSet r14) {
        /*
            r11 = this;
            java.util.HashMap r0 = f12120f
            java.lang.Object r1 = r0.get(r12)
            java.lang.reflect.Constructor r1 = (java.lang.reflect.Constructor) r1
            java.lang.String r2 = ": Error inflating class "
            r3 = 1
            if (r1 != 0) goto L_0x006b
            android.content.Context r1 = r11.f12121a     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            r4 = 0
            if (r13 == 0) goto L_0x005b
            int r5 = r13.length     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            if (r5 != 0) goto L_0x001a
            goto L_0x005b
        L_0x001a:
            int r5 = r13.length     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            r6 = 0
            r8 = r6
            r7 = 0
        L_0x001e:
            if (r7 >= r5) goto L_0x003a
            r9 = r13[r7]     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x0076 }
            r10.<init>()     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x0076 }
            r10.append(r9)     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x0076 }
            r10.append(r12)     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x0076 }
            java.lang.String r9 = r10.toString()     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x0076 }
            java.lang.Class r6 = java.lang.Class.forName(r9, r4, r1)     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x0076 }
            goto L_0x003a
        L_0x0036:
            r8 = move-exception
            int r7 = r7 + 1
            goto L_0x001e
        L_0x003a:
            if (r6 != 0) goto L_0x005f
            if (r8 != 0) goto L_0x005a
            android.view.InflateException r13 = new android.view.InflateException     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            r0.<init>()     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            java.lang.String r1 = r14.getPositionDescription()     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            r0.append(r1)     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            r0.append(r2)     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            r0.append(r12)     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            java.lang.String r0 = r0.toString()     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            r13.<init>(r0)     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            throw r13     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
        L_0x005a:
            throw r8     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
        L_0x005b:
            java.lang.Class r6 = java.lang.Class.forName(r12, r4, r1)     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
        L_0x005f:
            java.lang.Class[] r13 = f12119e     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            java.lang.reflect.Constructor r1 = r6.getConstructor(r13)     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            r1.setAccessible(r3)     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            r0.put(r12, r1)     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
        L_0x006b:
            java.lang.Object[] r13 = r11.f12122b     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            r13[r3] = r14     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            java.lang.Object r13 = r1.newInstance(r13)     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            androidx.preference.Preference r13 = (androidx.preference.Preference) r13     // Catch:{ ClassNotFoundException -> 0x0096, Exception -> 0x0076 }
            return r13
        L_0x0076:
            r13 = move-exception
            android.view.InflateException r0 = new android.view.InflateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r14 = r14.getPositionDescription()
            r1.append(r14)
            r1.append(r2)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12)
            r0.initCause(r13)
            throw r0
        L_0x0096:
            r12 = move-exception
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.e0.a(java.lang.String, java.lang.String[], android.util.AttributeSet):androidx.preference.Preference");
    }

    public final Preference b(String str, AttributeSet attributeSet) {
        try {
            if (-1 == str.indexOf(46)) {
                return a(str, this.f12124d, attributeSet);
            }
            return a(str, (String[]) null, attributeSet);
        } catch (InflateException e10) {
            throw e10;
        } catch (ClassNotFoundException e11) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e11);
            throw inflateException;
        } catch (Exception e12) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e12);
            throw inflateException2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a A[Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030 A[SYNTHETIC, Splitter:B:15:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.preference.PreferenceGroup c(android.content.res.XmlResourceParser r6) {
        /*
            r5 = this;
            java.lang.Object[] r0 = r5.f12122b
            monitor-enter(r0)
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r6)     // Catch:{ all -> 0x0080 }
            java.lang.Object[] r2 = r5.f12122b     // Catch:{ all -> 0x0080 }
            android.content.Context r3 = r5.f12121a     // Catch:{ all -> 0x0080 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x0080 }
        L_0x000e:
            int r2 = r6.next()     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            r3 = 2
            if (r2 == r3) goto L_0x0018
            r4 = 1
            if (r2 != r4) goto L_0x000e
        L_0x0018:
            if (r2 != r3) goto L_0x0030
            java.lang.String r2 = r6.getName()     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            androidx.preference.Preference r2 = r5.b(r2, r1)     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            androidx.preference.PreferenceGroup r2 = (androidx.preference.PreferenceGroup) r2     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            o3.i0 r3 = r5.f12123c     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            r2.k(r3)     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            r5.d(r6, r2, r1)     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            return r2
        L_0x002e:
            r1 = move-exception
            goto L_0x004b
        L_0x0030:
            android.view.InflateException r1 = new android.view.InflateException     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            r2.<init>()     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            java.lang.String r3 = r6.getPositionDescription()     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            r2.append(r3)     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            java.lang.String r3 = ": No start tag found!"
            r2.append(r3)     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            java.lang.String r2 = r2.toString()     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            r1.<init>(r2)     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
            throw r1     // Catch:{ InflateException -> 0x007e, XmlPullParserException -> 0x0070, IOException -> 0x002e }
        L_0x004b:
            android.view.InflateException r2 = new android.view.InflateException     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r3.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r6 = r6.getPositionDescription()     // Catch:{ all -> 0x0080 }
            r3.append(r6)     // Catch:{ all -> 0x0080 }
            java.lang.String r6 = ": "
            r3.append(r6)     // Catch:{ all -> 0x0080 }
            java.lang.String r6 = r1.getMessage()     // Catch:{ all -> 0x0080 }
            r3.append(r6)     // Catch:{ all -> 0x0080 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0080 }
            r2.<init>(r6)     // Catch:{ all -> 0x0080 }
            r2.initCause(r1)     // Catch:{ all -> 0x0080 }
            throw r2     // Catch:{ all -> 0x0080 }
        L_0x0070:
            r6 = move-exception
            android.view.InflateException r1 = new android.view.InflateException     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r6.getMessage()     // Catch:{ all -> 0x0080 }
            r1.<init>(r2)     // Catch:{ all -> 0x0080 }
            r1.initCause(r6)     // Catch:{ all -> 0x0080 }
            throw r1     // Catch:{ all -> 0x0080 }
        L_0x007e:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.e0.c(android.content.res.XmlResourceParser):androidx.preference.PreferenceGroup");
    }

    /* JADX INFO: finally extract failed */
    public final void d(XmlResourceParser xmlResourceParser, Preference preference, AttributeSet attributeSet) {
        long j10;
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if ((next == 3 && xmlResourceParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.f1899t = Intent.parseIntent(this.f12121a.getResources(), xmlResourceParser, attributeSet);
                    } catch (IOException e10) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e10);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    Resources resources = this.f12121a.getResources();
                    if (preference.f1901v == null) {
                        preference.f1901v = new Bundle();
                    }
                    resources.parseBundleExtra("extra", attributeSet, preference.f1901v);
                    try {
                        int depth2 = xmlResourceParser.getDepth();
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 == 1 || (next2 == 3 && xmlResourceParser.getDepth() <= depth2)) {
                                break;
                            }
                        }
                    } catch (IOException e11) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e11);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference b10 = b(name, attributeSet);
                    PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
                    if (!preferenceGroup.V.contains(b10)) {
                        if (b10.f1898s != null) {
                            PreferenceGroup preferenceGroup2 = preferenceGroup;
                            while (true) {
                                PreferenceGroup preferenceGroup3 = preferenceGroup2.P;
                                if (preferenceGroup3 == null) {
                                    break;
                                }
                                preferenceGroup2 = preferenceGroup3;
                            }
                            String str = b10.f1898s;
                            if (preferenceGroup2.y(str) != null) {
                                Log.e("PreferenceGroup", "Found duplicated key: \"" + str + "\". This can cause unintended behaviour, please use unique keys for every preference.");
                            }
                        }
                        int i10 = b10.f1893n;
                        if (i10 == Integer.MAX_VALUE) {
                            if (preferenceGroup.W) {
                                int i11 = preferenceGroup.X;
                                preferenceGroup.X = i11 + 1;
                                if (i11 != i10) {
                                    b10.f1893n = i11;
                                    d0 d0Var = b10.N;
                                    if (d0Var != null) {
                                        Handler handler = d0Var.f12116e;
                                        h hVar = d0Var.f12117f;
                                        handler.removeCallbacks(hVar);
                                        handler.post(hVar);
                                    }
                                }
                            }
                            if (b10 instanceof PreferenceGroup) {
                                ((PreferenceGroup) b10).W = preferenceGroup.W;
                            }
                        }
                        int binarySearch = Collections.binarySearch(preferenceGroup.V, b10);
                        if (binarySearch < 0) {
                            binarySearch = (binarySearch * -1) - 1;
                        }
                        boolean w10 = preferenceGroup.w();
                        if (b10.C == w10) {
                            b10.C = !w10;
                            b10.i(b10.w());
                            b10.h();
                        }
                        synchronized (preferenceGroup) {
                            preferenceGroup.V.add(binarySearch, b10);
                        }
                        i0 i0Var = preferenceGroup.f1888i;
                        String str2 = b10.f1898s;
                        if (str2 == null || !preferenceGroup.U.containsKey(str2)) {
                            j10 = i0Var.c();
                        } else {
                            j10 = ((Long) preferenceGroup.U.getOrDefault(str2, (Object) null)).longValue();
                            preferenceGroup.U.remove(str2);
                        }
                        b10.f1889j = j10;
                        b10.f1890k = true;
                        try {
                            b10.k(i0Var);
                            b10.f1890k = false;
                            if (b10.P == null) {
                                b10.P = preferenceGroup;
                                if (preferenceGroup.Y) {
                                    b10.j();
                                }
                                d0 d0Var2 = preferenceGroup.N;
                                if (d0Var2 != null) {
                                    Handler handler2 = d0Var2.f12116e;
                                    h hVar2 = d0Var2.f12117f;
                                    handler2.removeCallbacks(hVar2);
                                    handler2.post(hVar2);
                                }
                            } else {
                                throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
                            }
                        } catch (Throwable th) {
                            b10.f1890k = false;
                            throw th;
                        }
                    }
                    d(xmlResourceParser, b10, attributeSet);
                }
            }
        }
        while (true) {
        }
    }
}
