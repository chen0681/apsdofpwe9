package com.free.testspring.elastic;

import org.springframework.data.repository.CrudRepository;

public interface SearchUserRepo extends CrudRepository<SearchUserDto, Long> {

}
