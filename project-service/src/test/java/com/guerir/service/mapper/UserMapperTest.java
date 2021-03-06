package com.project.service.mapper;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.project.model.User;
import com.project.repository.entity.UserEntity;
import com.project.service.BaseSpringTest;

/**
 * Test user mapping class
 *
 * @author Jay Paulynice (jay.paulynice@gmail.com)
 */
public class UserMapperTest extends BaseSpringTest {
    @Autowired
    private UserMapper mapper;

    /**
     * test not null
     */
    @Test
    public void testMapperNotNull() {
        assertNotNull(mapper);
    }

    /**
     * test map to dto
     */
    @Test
    public void testMapToDto() {
        assertNotNull(mapper.toDto(new UserEntity()));
        assertNull(mapper.toDto(null));
    }

    /**
     * test map to entity
     */
    @Test
    public void testMapToEntity() {
        assertNotNull(mapper.toEntity(new User()));
        assertNull(mapper.toEntity(null));
    }
}