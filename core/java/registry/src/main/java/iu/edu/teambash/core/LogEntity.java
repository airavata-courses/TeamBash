package iu.edu.teambash.core;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by murugesm on 9/20/16.
 */
@Entity
@Table(name = "log", schema = "TeamBash", catalog = "")
public class LogEntity {
    private int lId;
    private int uId;
    private int mId;
    private Serializable startTime;
    private Serializable endTime;

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
    @Column(name = "startTime", nullable = false)
    public Serializable getStartTime() {
        return startTime;
    }

    public void setStartTime(Serializable startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime", nullable = false)
    public Serializable getEndTime() {
        return endTime;
    }

    public void setEndTime(Serializable endTime) {
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
