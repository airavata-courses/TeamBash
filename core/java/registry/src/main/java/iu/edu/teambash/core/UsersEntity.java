package iu.edu.teambash.core;

import javax.persistence.*;

/**
 * Created by janakbhalla on 23/10/16.
 */
@Entity
@Table(name = "users", schema = "TeamBash", catalog = "")
public class UsersEntity {

    @Id
    @Column(name = "uid", nullable = false)
    private int uid;


    @Basic
    @Column(name = "uname", nullable = false, length = 30)
    private String uname;

    public UsersEntity(String uname) {
        this.uname = uname;
    }

    public UsersEntity() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (uid != that.uid) return false;
        if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (uname != null ? uname.hashCode() : 0);
        return result;
    }
}
