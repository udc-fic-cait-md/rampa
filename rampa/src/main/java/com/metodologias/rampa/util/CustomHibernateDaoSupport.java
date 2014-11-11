package com.metodologias.rampa.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * The Class CustomHibernateDaoSupport.
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

    /**
     * Any method name.
     *
     * @param sessionFactory
     *            the session factory
     */
    @Autowired
    public void anyMethodName(final SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}