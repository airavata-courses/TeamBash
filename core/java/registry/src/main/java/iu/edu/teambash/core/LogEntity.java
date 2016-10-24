package iu.edu.teambash.core;

import javax.persistence.*;

/**
 * Created by murugesm on 9/20/16.
 */
@Entity
@Table(name = "log", schema = "TeamBash", catalog = "")
@NamedQueries({
        @NamedQuery(name = "db.LogEntity.findlogs",
                query = "SELECT u FROM LogEntity u WHERE u.uId = :userid"),
})
public class LogEntity {
    private int lId;
    private int uId;
    private int mId;
    private String startTime;
    private String endTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lID", nullable = false)
    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    @Basic
    @Column(name = "uID", nullable = false)
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "mID", nullable = false)
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    @Basic
    @Column(name = "startTime", nullable = false, length = 20)
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime", nullable = false, length = 20)
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity logEntity = (LogEntity) o;

        if (lId != logEntity.lId) return false;
        if (uId != logEntity.uId) return false;
        if (mId != logEntity.mId) return false;
        if (startTime != null ? !startTime.equals(logEntity.startTime) : logEntity.startTime != null) return false;
        if (endTime != null ? !endTime.equals(logEntity.endTime) : logEntity.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lId;
        result = 31 * result + uId;
        result = 31 * result + mId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }

}
