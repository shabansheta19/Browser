package com.example.shaban.browser;

/**
 * Created by shaban on 3/6/2018.
 */

public class HistoryDataModel {

    private  String title ="";
    private  String uri ="";

    public HistoryDataModel(String title, String uri) {
        this.title = title;
        this.uri = uri;
    }

    /*********** Set Methods ******************/

    public void setTitle(String CompanyName)
    {
        this.title = CompanyName;
    }

    public void setUri(String Url)
    {
        this.uri = Url;
    }

    /*********** Get Methods ****************/

    public String getTitle()
    {
        return this.title;
    }

    public String getUri()
    {
        return this.uri;
    }
}