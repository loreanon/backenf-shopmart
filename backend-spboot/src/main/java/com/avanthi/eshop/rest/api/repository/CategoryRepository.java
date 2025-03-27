package com.avanthi.eshop.rest.api.repository;

import com.avanthi.eshop.rest.api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
