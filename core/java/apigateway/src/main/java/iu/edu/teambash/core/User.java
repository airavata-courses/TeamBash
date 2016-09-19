package iu.edu.teambash.core;

/**
 * Created by janakbhalla on 15/09/16.
 */

import javax.persistence.*;
import java.security.Principal;

@Entity
@Table(name = "users")
/*@NamedQueries(
        {
                @NamedQuery(
                        uname = "db.User.findByNamePassword",
                        query = "SELECT p FROM User p"
                )
        }
)*/
public class User implements Principal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;
    @Column
    private String uname;

    @Column
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.uname = username;
        this.password = password;
    }

    @Override
    public String getName() {
        return uname;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

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

        User user = (User) o;

        if (getUid() != user.getUid()) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        return getPassword() != null ? getPassword().equals(user.getPassword()) : user.getPassword() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getUid() ^ (getUid() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}