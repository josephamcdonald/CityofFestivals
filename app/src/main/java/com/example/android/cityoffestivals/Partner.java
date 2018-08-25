package com.example.android.cityoffestivals;

public class Partner {

    /**
     * Partner name.
     */
    private String partnerName;

    /**
     * Partner festival.
     */
    private String partnerFest;

    /**
     * Festival date or range.
     */
    private String festDate;

    /**
     * Music act stage time.
     */
    private String musicTime;

    /**
     * Partner web URL.
     */
    private String partnerUrl;

    /**
     * Partner image resource ID.
     */
    private int partnerImageResId;

    /**
     * Create a new Festival object.
     *
     * @param name       the name of the partner.
     * @param date       the date(s) of the  entity.
     * @param url        the web URL of the festival.
     * @param imageResId the image resource ID of the festival.
     */
    public Partner(String name, String date, String url, int imageResId) {
        partnerName = name;
        festDate = date;
        partnerUrl = url;
        partnerImageResId = imageResId;
    }

    /**
     * Create a new Food Vendor or Sponsor object.
     *
     * @param name       the name of the entity.
     * @param imageResId the image resource ID of the festival.
     * @param fest       the festival associated with entity.
     * @param url        the web URL of the festival.
     */
    public Partner(String name, int imageResId, String fest, String url) {
        partnerName = name;
        partnerImageResId = imageResId;
        partnerFest = fest;
        partnerUrl = url;
    }

    /**
     * Create a new Music Act object.
     *
     * @param name       the name of the entity.
     * @param fest       the festival associated with entity.
     * @param imageResId the image resource ID of the festival.
     * @param time       the stage time entity.
     */
    public Partner(String name, String fest, int imageResId, String time) {
        partnerName = name;
        partnerFest = fest;
        partnerImageResId = imageResId;
        musicTime = time;
    }

    /**
     * Get the Partner name.
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * Get the Partner festival name.
     */
    public String getPartnerFest() {
        return partnerFest;
    }

    /**
     * Get the Festival date or range.
     */
    public String getFestDate() {
        return festDate;
    }

    /**
     * Get the Music Act stage time.
     */
    public String getMusicTime() {
        return musicTime;
    }

    /**
     * Get the Partner web URL.
     */
    public String getPartnerUrl() {
        return partnerUrl;
    }

    /**
     * Get the Partner image resource ID.
     */
    public int getPartnerImageResId() {
        return partnerImageResId;
    }

    /*
     * Is this Partner a festival?
     */
    public boolean isFestival() { return (festDate != null);
    }

    /*
     * Is this Partner a music act?
     */
    public boolean isMusicAct() {
        return (musicTime != null);
    }
}
