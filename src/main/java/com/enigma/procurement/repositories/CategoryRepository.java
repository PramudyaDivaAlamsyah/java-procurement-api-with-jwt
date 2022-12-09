package com.enigma.procurement.repositories;

import com.enigma.procurement.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
