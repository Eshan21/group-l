package com.groupl.mysql;

import org.springframework.data.repository.CrudRepository;

import com.groupl.mysql.Blog;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BlogRepository extends CrudRepository<Blog, Integer> {
}

