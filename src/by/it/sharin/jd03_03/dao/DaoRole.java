package by.it.sharin.jd03_03.dao;

import by.it.sharin.jd03_03.beans.Role;

public class DaoRole extends UniversalDAO<Role> {
    public DaoRole() {
        super(new Role(), "roles");
    }
}
