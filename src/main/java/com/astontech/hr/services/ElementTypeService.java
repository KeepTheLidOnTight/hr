package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;

public interface ElementTypeService {
    Iterable<ElementType> listAllElementType();

    ElementType getElementTypeById(Integer id);

    ElementType saveElement(ElementType elementType);

    Iterable<ElementType> elementTypeList(Iterable<ElementType> elementTypeIterable);

    void deleteElementType(Integer id);
}
