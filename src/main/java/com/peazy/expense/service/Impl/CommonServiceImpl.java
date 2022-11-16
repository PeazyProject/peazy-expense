package com.peazy.expense.service.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.expense.model.bean.DropDownBean;
import com.peazy.expense.model.entity.CommonCodeConverterEntity;
import com.peazy.expense.repository.CommonCodeConverterRepository;
import com.peazy.expense.service.interfaces.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    CommonCodeConverterRepository commonCodeConverterRepository;

    @Override
    public List<DropDownBean> getDropDownList(String mainCategory, String subCategory)
            throws JsonProcessingException {

        List<CommonCodeConverterEntity> commonCodeConverterEntities = commonCodeConverterRepository
                .findByMainCategoryAndSubCategoryAndIsActivated(mainCategory, subCategory, "Y");

        List<DropDownBean> dropDownList = new ArrayList<>();
        for (CommonCodeConverterEntity entity : commonCodeConverterEntities) {
            DropDownBean dropDownBean = new DropDownBean();
            dropDownBean.setLabel(entity.getCodeKey() + "-" + entity.getCodeDesc());
            dropDownBean.setValue(entity.getCodeKey());
            dropDownList.add(dropDownBean);
        }

        return dropDownList;
    }

}
