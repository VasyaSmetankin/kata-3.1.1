package org.smetankin.kata3112.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.smetankin.kata3112.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка сохранения пользователя", e);
        }
    }

    @Override
    public User getUserById(Long id) {
        try {
            return entityManager.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка получения пользователя", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return entityManager.createQuery("FROM User", User.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка получения списка пользователей", e);
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            entityManager.merge(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка обновления пользователя", e);
        }
    }

    @Override
    public void deleteUser(Long id) {
        try {
            User user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка удаления пользователя", e);
        }
    }
}
