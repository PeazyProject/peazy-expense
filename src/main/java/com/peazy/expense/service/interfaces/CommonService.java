package com.peazy.expense.service.interfaces;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.expense.model.bean.DropDownBean;

public interface CommonService {
	List<DropDownBean> getDropDownList(String mainCategory, String subCategory)
			throws JsonProcessingException;
}
