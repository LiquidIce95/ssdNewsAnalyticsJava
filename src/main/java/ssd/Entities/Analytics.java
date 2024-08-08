package ssd.Entities;

public interface Analytics {
    String getBias();
    void setBias(String bias);
    int getViews();
    void setViews(int views);
    int getShares();
    void setShares(int shares);
    int getLikes();
    void setLikes(int likes);
    double getEngagementRate();
    void setEngagementRate(double engagementRate);
}
