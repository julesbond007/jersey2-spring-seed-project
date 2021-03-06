package com.project.service;

import com.project.model.User;

/**
 * @author Jay Paulynice (jay.paulynice@gmail.com)
 */
public interface UserService {
    /**
     * Get user by id
     *
     * @param userId the user id
     * @return the user details
     */
    public User getUser(final Long userId);
}