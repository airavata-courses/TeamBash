package iu.edu.teambash.core;

import javax.persistence.*;

/**
 * Created by murugesm on 9/20/16.
 */
@Entity
@Table(name = "microservices", schema = "TeamBash", catalog = "")
public class MicroservicesEntity
{
    private int mId;
    private String mName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mID", nullable = false)
    public int getmId()
    {
        return mId;
    }

    public void setmId(int mId)
    {
        this.mId = mId;
    }

    @Basic
    @Column(name = "mName", nullable = false, length = 30)
    public String getmName()
    {
        return mName;
    }

    public void setmName(String mName)
    {
        this.mName = mName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MicroservicesEntity that = (MicroservicesEntity) o;

        if (mId != that.mId) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = mId;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        return result;
    }
}
