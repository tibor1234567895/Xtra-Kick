package com.iheartradio.m3u8.data;

public class LocationData {
    private final String mLocation;
    private final LocationType mLocationType;

    public LocationData(LocationType locationType, String str) {
        if (locationType == null) {
            throw new IllegalArgumentException("locationType is null");
        } else if (str != null) {
            this.mLocationType = locationType;
            this.mLocation = str;
        } else {
            throw new IllegalArgumentException("location is null");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationData)) {
            return false;
        }
        LocationData locationData = (LocationData) obj;
        return this.mLocationType == locationData.mLocationType && ObjectUtil.equals(this.mLocation, locationData.mLocation);
    }

    public String getLocation() {
        return this.mLocation;
    }

    public LocationType getLocationType() {
        return this.mLocationType;
    }

    public boolean isPath() {
        return this.mLocationType == LocationType.PATH;
    }

    public boolean isUrl() {
        return this.mLocationType == LocationType.URL;
    }
}
