package com.peazy.expense.service.interfaces;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.expense.model.entity.SupplierUserEntity;

public interface SupplierUserService {
	public List<SupplierUserEntity> getUsers() throws JsonProcessingException;
}
