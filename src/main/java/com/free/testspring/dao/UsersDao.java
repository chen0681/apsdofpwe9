/**
 * 
 */
package com.free.testspring.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 *
 */
@Repository("usersDao")
public interface UsersDao {

	Long getTestData() ;
}
