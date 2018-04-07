package com.cf.bbackend.repository;

import com.cf.bbackend.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>  {


}
