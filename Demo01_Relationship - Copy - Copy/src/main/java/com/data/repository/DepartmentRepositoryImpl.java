package com.data.repository;

import com.data.entity.Department;
import com.data.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private SessionFactory sessionFactory;

    private EntityManager entityManager;

    public DepartmentRepositoryImpl(SessionFactory sessionFactory,
                                    EntityManager entityManager) {
        this.sessionFactory = sessionFactory;
        this.entityManager = entityManager;
    }

    @Override
    public List<Department> findAll() {
        Session session = sessionFactory.openSession();

        // hql
        Query<Department> query = session.createQuery("FROM Department");
        // native sql
//        Query<Department> query = session.createSQLQuery("SELECT * FROM department");
        List<Department> departments = query.getResultList();
        return departments;
    }

    @Override
    public int delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // hql
        Query<Department> query = session.createQuery("FROM Department WHERE id = " + id);
        Department department = query.getSingleResult();

        session.delete(department);

        transaction.commit();
        return 0;
    }

    @Override
    public int save(Department detachedDepartment) {
        Employee e1 = new Employee();
        e1.setFullName("Employee 9");
        Employee e2 = new Employee();
        e2.setFullName("Employee 10");

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);

        Department department = new Department();
        department.setDepartmentName("New D 99");

        // set employees to department
        e1.setDepartment(department);
        e2.setDepartment(department);

        department.setEmployees(employees);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(department);
        transaction.commit();

        return 0;
    }

    @Override
    public int update(Department detachedDepartment) {
        Department department = new Department();
        department.setId(6);
        department.setDepartmentName("New 99_b");

        Employee e1 = new Employee();
        e1.setId(7);
        e1.setFullName("Employee 7.x");
        e1.setDepartment(department);

        Employee e2 = new Employee();
        e2.setId(8);
        e2.setFullName("Employee 8.x");
        e2.setDepartment(department);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);

        department.setEmployees(employees);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(department);
        transaction.commit();

        return 0;
    }
}
