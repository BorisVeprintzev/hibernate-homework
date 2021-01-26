package ru.hh.school.dao;

import org.hibernate.SessionFactory;
import ru.hh.school.entity.Employer;

public class EmployerDao extends GenericDao {

    public EmployerDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * TOD: здесь нужен метод, позволяющий сразу загрузить вакасии, связанные с работодателем и в некоторых случаях
     * избежать org.hibernate.LazyInitializationException
     * Также в запрос должен передаваться параметр employerId
     * <p>
     * https://vladmihalcea.com/the-best-way-to-handle-the-lazyinitializationexception/
     */
    public Employer getEager(int employerId) {
        return getSession()
                .createQuery("Select e From Employer as e join fetch e.vacancies where e.id = :paramName", Employer.class)
                .setParameter("paramName", employerId)
                .getSingleResult();
    }

    public void update(Employer obj) {
        getSession().update(obj);
    }
}
