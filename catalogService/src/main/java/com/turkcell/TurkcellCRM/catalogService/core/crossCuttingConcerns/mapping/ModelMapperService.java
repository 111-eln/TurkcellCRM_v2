package com.turkcell.TurkcellCRM.catalogService.core.crossCuttingConcerns.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forResponse();

    ModelMapper forRequest();
}
