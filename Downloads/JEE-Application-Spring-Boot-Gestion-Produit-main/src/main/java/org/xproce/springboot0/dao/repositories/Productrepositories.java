package org.xproce.springboot0.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.springboot0.dao.entities.Product;

public interface Productrepositories extends JpaRepository<Product,Long> {

}
