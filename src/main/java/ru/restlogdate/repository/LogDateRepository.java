package ru.restlogdate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restlogdate.model.LogDate;

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
    public LogDate getLogDate(int thisGuid) {
        Session session = sessionFactory.getCurrentSession();
        return (LogDate) session.get(LogDate.class, thisGuid);
    }
}
