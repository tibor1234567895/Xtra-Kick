package u2;

import android.support.v4.media.h;
import d9.r0;
import j1.b0;
import j1.v;
import o2.b;
import o2.j;
import o2.p;
import o2.x;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f15267a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    private n() {
    }

    public static j a(int i10, b0 b0Var) {
        int f10 = b0Var.f();
        if (b0Var.f() == 1684108385) {
            b0Var.H(8);
            String q10 = b0Var.q(f10 - 16);
            return new j("und", q10, q10);
        }
        v.g("MetadataUtil", "Failed to parse comment attribute: " + c.c(i10));
        return null;
    }

    public static b b(b0 b0Var) {
        String str;
        String str2;
        int f10 = b0Var.f();
        if (b0Var.f() == 1684108385) {
            int f11 = b0Var.f() & 16777215;
            if (f11 == 13) {
                str2 = "image/jpeg";
            } else if (f11 == 14) {
                str2 = "image/png";
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str = h.i("Unrecognized cover art flags: ", f11);
            } else {
                b0Var.H(4);
                int i10 = f10 - 16;
                byte[] bArr = new byte[i10];
                b0Var.d(bArr, 0, i10);
                return new b(str2, (String) null, 3, bArr);
            }
        } else {
            str = "Failed to parse cover art attribute";
        }
        v.g("MetadataUtil", str);
        return null;
    }

    public static x c(int i10, b0 b0Var, String str) {
        int f10 = b0Var.f();
        if (b0Var.f() == 1684108385) {
            b0Var.H(8);
            return new x(str, (String) null, r0.n(b0Var.q(f10 - 16)));
        }
        v.g("MetadataUtil", "Failed to parse text attribute: " + c.c(i10));
        return null;
    }

    public static p d(int i10, String str, b0 b0Var, boolean z10, boolean z11) {
        int e10 = e(b0Var);
        if (z11) {
            e10 = Math.min(1, e10);
        }
        if (e10 >= 0) {
            return z10 ? new x(str, (String) null, r0.n(Integer.toString(e10))) : new j("und", str, Integer.toString(e10));
        }
        v.g("MetadataUtil", "Failed to parse uint8 attribute: " + c.c(i10));
        return null;
    }

    public static int e(b0 b0Var) {
        b0Var.H(4);
        if (b0Var.f() == 1684108385) {
            b0Var.H(8);
            return b0Var.v();
        }
        v.g("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
