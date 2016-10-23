package iu.edu.teambash.db;

import io.dropwizard.hibernate.AbstractDAO;
import iu.edu.teambash.core.LogEntity;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by murugesm on 9/20/16.
 */
public class LogDao extends AbstractDAO<LogEntity> {
    public LogDao(SessionFactory factory) {
        super(factory);
    }

    public LogEntity findById(int id) {
        return get(id);
    }

    public LogEntity create(LogEntity log) {
        return persist(log);

    }

    public List<LogEntity> findLogs(int userid) {

        return list(namedQuery("db.LogEntity.findlogs").setParameter("userid", userid));
    }
}
