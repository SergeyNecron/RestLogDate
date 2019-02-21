package ru.restlogdate.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restlogdate.model.LogDate;

import java.util.List;

@Repository
public class LogDateRepository implements LogDateRepositoryStencil {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addLogDate(LogDate logDate) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(logDate);
    }

    @Override
    public void updateLogDate(LogDate logDate) {
        Session session = sessionFactory.getCurrentSession();
        session.update(logDate);
    }

    @Override
    @SuppressWarnings("unchecked")
    public LogDate getLogDate(int thisGuid) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM LogDate WHERE guid = :thisGuid");
        query.setParameter("thisGuid", thisGuid);
        List<LogDate> logDateList = query.list();

        return logDateList.size() == 0 ? null : logDateList.get(0);
    }
}
