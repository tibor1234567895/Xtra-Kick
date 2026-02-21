package l;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import androidx.appcompat.widget.i2;
import androidx.appcompat.widget.u4;
import f.a;
import java.io.IOException;
import m0.d;
import org.xmlpull.v1.XmlPullParserException;

public final class l extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    public static final Class[] f9482e;

    /* renamed from: f  reason: collision with root package name */
    public static final Class[] f9483f;

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f9484a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f9485b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f9486c;

    /* renamed from: d  reason: collision with root package name */
    public Object f9487d;

    static {
        Class[] clsArr = {Context.class};
        f9482e = clsArr;
        f9483f = clsArr;
    }

    public l(Context context) {
        super(context);
        this.f9486c = context;
        Object[] objArr = {context};
        this.f9484a = objArr;
        this.f9485b = objArr;
    }

    public static Object a(Context context) {
        return (!(context instanceof Activity) && (context instanceof ContextWrapper)) ? a(((ContextWrapper) context).getBaseContext()) : context;
    }

    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) {
        int i10;
        char c10;
        char c11;
        int i11;
        boolean z10;
        d dVar;
        ColorStateList colorStateList;
        AttributeSet attributeSet2 = attributeSet;
        k kVar = new k(this, menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            i10 = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlResourceParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
                XmlResourceParser xmlResourceParser2 = xmlResourceParser;
            }
        }
        boolean z11 = false;
        boolean z12 = false;
        String str = null;
        while (!z11) {
            if (eventType != 1) {
                Menu menu2 = kVar.f9456a;
                if (eventType != i10) {
                    if (eventType == 3) {
                        String name2 = xmlResourceParser.getName();
                        if (z12 && name2.equals(str)) {
                            XmlResourceParser xmlResourceParser3 = xmlResourceParser;
                            z12 = false;
                            str = null;
                            eventType = xmlResourceParser.next();
                            i10 = 2;
                        } else if (name2.equals("group")) {
                            kVar.f9457b = 0;
                            kVar.f9458c = 0;
                            kVar.f9459d = 0;
                            kVar.f9460e = 0;
                            kVar.f9461f = true;
                            kVar.f9462g = true;
                        } else if (name2.equals("item")) {
                            if (!kVar.f9463h) {
                                d dVar2 = kVar.f9481z;
                                if (dVar2 == null || !dVar2.a()) {
                                    kVar.f9463h = true;
                                    kVar.b(menu2.add(kVar.f9457b, kVar.f9464i, kVar.f9465j, kVar.f9466k));
                                } else {
                                    kVar.f9463h = true;
                                    kVar.b(menu2.addSubMenu(kVar.f9457b, kVar.f9464i, kVar.f9465j, kVar.f9466k).getItem());
                                }
                            }
                        } else if (name2.equals("menu")) {
                            XmlResourceParser xmlResourceParser4 = xmlResourceParser;
                            z11 = true;
                            eventType = xmlResourceParser.next();
                            i10 = 2;
                        }
                    }
                } else if (!z12) {
                    String name3 = xmlResourceParser.getName();
                    boolean equals = name3.equals("group");
                    l lVar = kVar.E;
                    if (equals) {
                        TypedArray obtainStyledAttributes = lVar.f9486c.obtainStyledAttributes(attributeSet2, a.f5407q);
                        kVar.f9457b = obtainStyledAttributes.getResourceId(1, 0);
                        kVar.f9458c = obtainStyledAttributes.getInt(3, 0);
                        kVar.f9459d = obtainStyledAttributes.getInt(4, 0);
                        kVar.f9460e = obtainStyledAttributes.getInt(5, 0);
                        kVar.f9461f = obtainStyledAttributes.getBoolean(2, true);
                        kVar.f9462g = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            Context context = lVar.f9486c;
                            u4 u4Var = new u4(context, context.obtainStyledAttributes(attributeSet2, a.f5408r));
                            kVar.f9464i = u4Var.i(2, 0);
                            kVar.f9465j = (u4Var.h(5, kVar.f9458c) & -65536) | (u4Var.h(6, kVar.f9459d) & 65535);
                            kVar.f9466k = u4Var.k(7);
                            kVar.f9467l = u4Var.k(8);
                            kVar.f9468m = u4Var.i(0, 0);
                            String j10 = u4Var.j(9);
                            if (j10 == null) {
                                c10 = 0;
                            } else {
                                c10 = j10.charAt(0);
                            }
                            kVar.f9469n = c10;
                            kVar.f9470o = u4Var.h(16, 4096);
                            String j11 = u4Var.j(10);
                            if (j11 == null) {
                                c11 = 0;
                            } else {
                                c11 = j11.charAt(0);
                            }
                            kVar.f9471p = c11;
                            kVar.f9472q = u4Var.h(20, 4096);
                            if (u4Var.l(11)) {
                                i11 = u4Var.a(11, false);
                            } else {
                                i11 = kVar.f9460e;
                            }
                            kVar.f9473r = i11;
                            kVar.f9474s = u4Var.a(3, false);
                            kVar.f9475t = u4Var.a(4, kVar.f9461f);
                            kVar.f9476u = u4Var.a(1, kVar.f9462g);
                            kVar.f9477v = u4Var.h(21, -1);
                            kVar.f9480y = u4Var.j(12);
                            kVar.f9478w = u4Var.i(13, 0);
                            kVar.f9479x = u4Var.j(15);
                            String j12 = u4Var.j(14);
                            if (j12 != null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10 && kVar.f9478w == 0 && kVar.f9479x == null) {
                                dVar = (d) kVar.a(j12, f9483f, lVar.f9485b);
                            } else {
                                if (z10) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                dVar = null;
                            }
                            kVar.f9481z = dVar;
                            kVar.A = u4Var.k(17);
                            kVar.B = u4Var.k(22);
                            if (u4Var.l(19)) {
                                kVar.D = i2.d(u4Var.h(19, -1), kVar.D);
                                colorStateList = null;
                            } else {
                                colorStateList = null;
                                kVar.D = null;
                            }
                            if (u4Var.l(18)) {
                                kVar.C = u4Var.b(18);
                            } else {
                                kVar.C = colorStateList;
                            }
                            u4Var.n();
                            kVar.f9463h = false;
                            XmlResourceParser xmlResourceParser5 = xmlResourceParser;
                        } else if (name3.equals("menu")) {
                            kVar.f9463h = true;
                            SubMenu addSubMenu = menu2.addSubMenu(kVar.f9457b, kVar.f9464i, kVar.f9465j, kVar.f9466k);
                            kVar.b(addSubMenu.getItem());
                            b(xmlResourceParser, attributeSet2, addSubMenu);
                        } else {
                            XmlResourceParser xmlResourceParser6 = xmlResourceParser;
                            str = name3;
                            z12 = true;
                        }
                        eventType = xmlResourceParser.next();
                        i10 = 2;
                    }
                }
                XmlResourceParser xmlResourceParser7 = xmlResourceParser;
                eventType = xmlResourceParser.next();
                i10 = 2;
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public final void inflate(int i10, Menu menu) {
        if (!(menu instanceof g0.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f9486c.getResources().getLayout(i10);
            b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            xmlResourceParser.close();
        } catch (XmlPullParserException e10) {
            throw new InflateException("Error inflating menu XML", e10);
        } catch (IOException e11) {
            throw new InflateException("Error inflating menu XML", e11);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
