package j1;

import org.xmlpull.v1.XmlPullParser;

public final class m0 {
    private m0() {
    }

    public static String a(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            if (xmlPullParser.getAttributeName(i10).equals(str)) {
                return xmlPullParser.getAttributeValue(i10);
            }
        }
        return null;
    }

    public static boolean b(XmlPullParser xmlPullParser, String str) {
        boolean z10;
        if (xmlPullParser.getEventType() == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || !xmlPullParser.getName().equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean c(XmlPullParser xmlPullParser, String str) {
        boolean z10;
        if (xmlPullParser.getEventType() == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || !xmlPullParser.getName().equals(str)) {
            return false;
        }
        return true;
    }
}
