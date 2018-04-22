package com.example.shaban.browser;

/**
 * Created by shaban on 3/13/2018.
 */

public class DownLoadDataModel {
    private  String downloadFileName ="";
    private String downloadFileUri = "";
    private boolean finished;
    private boolean played; // 0 is stopped , 1 is played
    private int progressBarValue;
    private boolean first;

    public DownLoadDataModel(String downloadFileName,String downloadFileUri) {
        this.downloadFileName = downloadFileName;
        this.downloadFileUri = downloadFileUri;
        this.played = true;
        this.finished = false;
        this.first = true;
    }

    /*********** Set Methods ******************/

    public void setDownloadFileName(String downloadFileName)
    {
        this.downloadFileName = downloadFileName;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public void setProgressBarValue(int progressBarValue) {
        this.progressBarValue = progressBarValue;
    }

    public void setDownloadFileUri(String downloadFileUri) {
        this.downloadFileUri = downloadFileUri;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    /*********** Get Methods ****************/

    public String getDownloadFileName()
    {
        return this.downloadFileName;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isPlayed() {
        return played;
    }

    public int getProgressBarValue() {
        return progressBarValue;
    }

    public String getDownloadFileUri() {
        return downloadFileUri;
    }

    public boolean isFirst() {
        return first;
    }
}
