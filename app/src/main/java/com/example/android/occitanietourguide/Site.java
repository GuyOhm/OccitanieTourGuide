package com.example.android.occitanietourguide;

/**
 * Represent a site for the user to look at.
 * It contains :
 * - a name
 * - a pic
 * - a description
 * - a uri to access either a map or a webpage
 */

public class Site {

    // string private value for the name
    private String name;

    // int private value for the drawable res id
    private int picResourceId;

    // string private value for the description of a site
    private String description;

    // string private value for the google maps Uri creation or webpage url
    private String uriString;


    /**
     * Construct a new Site object with initial values for name, picResourceId and description
     *
     * @param name          of the site
     * @param picResourceId id of the picture provided with the site
     * @param description   details of the site
     */
    public Site(String name, int picResourceId, String description) {
        this.name = name;
        this.picResourceId = picResourceId;
        this.description = description;
    }

    /**
     * Construct a new Site object with initial values for name, picResourceId, description
     * and uri for geoloc our url to browse
     *
     * @param name          of the site
     * @param picResourceId id of the picture provided with the site
     * @param description   details of the site
     * @param uriString     string value to access a map or a webpage
     */
    public Site(String name, int picResourceId, String description, String uriString) {
        this.name = name;
        this.picResourceId = picResourceId;
        this.description = description;
        this.uriString = uriString;
    }

    /**
     * Get the string value of the name
     *
     * @return name of the current site
     */
    public String getSiteName() {
        return name;
    }

    /**
     * get the int value of the picResourceId
     *
     * @return picResourceId of the current site
     */
    public int getPicResourceId() {
        return picResourceId;
    }

    /**
     * get the string value of the description
     *
     * @return description of the current site
     */
    public String getSiteDescription() {
        return description;
    }

    /**
     * get the string value of the uri
     *
     * @return uri for a map localization or a website url
     */
    public String getUriString() {
        return uriString;
    }

    @Override
    public String toString() {
        return "name : " + name + "\n"
                + "description : " + description;
    }
}
