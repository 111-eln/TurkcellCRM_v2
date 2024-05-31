package com.turkcell.TurkcellCRM.basketService.core.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forResponse();

    ModelMapper forRequest();
}
