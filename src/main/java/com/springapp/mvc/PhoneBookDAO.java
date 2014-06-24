package com.springapp.mvc;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class PhoneBookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
     * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
     */
    @Transactional
    public List<PhoneBook> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List PhoneBooks = session.createQuery("from PhoneBook").list();
        return PhoneBooks;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<PhoneBook> searchPhoneBooks(String lineToSearch, String filedToSearch) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PhoneBook.class);
        criteria.add(Restrictions.ilike(filedToSearch, lineToSearch, MatchMode.ANYWHERE));
        return criteria.list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<PhoneBook> searchPhoneBooks(String lineToSearch) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PhoneBook.class)
                .add(Restrictions.disjunction()
                        .add(Restrictions.ilike("name", lineToSearch, MatchMode.ANYWHERE))
                        .add(Restrictions.ilike("lastName", lineToSearch, MatchMode.ANYWHERE))
                        .add(Restrictions.ilike("patronymicName", lineToSearch, MatchMode.ANYWHERE))
                        .add(Restrictions.ilike("officePhoneNum", lineToSearch, MatchMode.ANYWHERE))
                        .add(Restrictions.ilike("homePhoneNum", lineToSearch, MatchMode.ANYWHERE))
                        .add(Restrictions.ilike("cellPhoneNum", lineToSearch, MatchMode.ANYWHERE))
                );
        return criteria.list();
    }
}
