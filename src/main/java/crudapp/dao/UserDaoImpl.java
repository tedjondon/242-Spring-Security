package crudapp.dao;

import crudapp.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserById(int id) {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery(
                "from User where id = :param"
        );
        query.setParameter("param", id);
        return query.getSingleResult();
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "update User set name = :paramName where id = :paramId"
        );
        query.setParameter("paramName", updatedUser.getName());
        query.setParameter("paramId", id);
        query.executeUpdate();
    }

    @Override
    public void deleteUser(int id) {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "delete User where id = :paramId"
        );
        query.setParameter("paramId", id);
        query.executeUpdate();
    }

}
