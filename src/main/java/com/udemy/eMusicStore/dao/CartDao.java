package com.udemy.eMusicStore.dao;

import com.udemy.eMusicStore.model.Cart;

/**
 * @author sandeep.chauhan
 *
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update ( String cartId, Cart cart);

    void delete (String cartId);
}

