/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.base.crud.interfaces;

import java.util.List;

/**
 *
 * @author adm
 */
public interface ICrud<T> {

    public void create(T entity);

    public void edit(T entity);

    public void remove(Long id);

    public T find(Object id);

    public List<T> findAll();
    
    public List<T> findRange(int first, int max);

    public int count();
}
