package iu.edu.teambash.core;

import javax.persistence.*;
import java.security.Principal;

/**
 * Created by janakbhalla on 18/09/16.
 */
@Entity
@Table(name = "users", schema = "TeamBash", catalog = "")
@NamedQueries({
        @NamedQuery(name = "db.UsersEntity.findByNamePassword",
                query = "SELECT u FROM UsersEntity u WHERE u.uname = :uname and u.password = :password")
})
public class UsersEntity implements Principal {
    private int uid;
    private String uname;
    private String password;

    public UsersEntity(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

    public UsersEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "uname", nullable = false, length = 30)
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (uid != that.uid) return false;
        if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (uname != null ? uname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    @Transient
    public String getName() {
        return getUname();
    }

    public void setName(String uname) {
    }

    ;
}
