package com.fadimekaplan.services;

import com.fadimekaplan.dto.DTOProduct;
import com.fadimekaplan.dto.DTOProductIU;

public interface IProductService {
	
	DTOProduct getProduct(Integer id);
	DTOProduct createProduct(DTOProductIU dtoproduct);
	DTOProduct updateProduct(Integer id, DTOProductIU dtoProductIU);
	void deleteProduct(Integer id);
}
