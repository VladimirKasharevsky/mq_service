package ru.sber.interview.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sber.interview.model.Manager;

import java.util.List;

@Repository
public interface ManagerRepo extends CrudRepository<Manager, Integer> {

    List<Manager> findByManagerLogin(String managerLogin);
}
