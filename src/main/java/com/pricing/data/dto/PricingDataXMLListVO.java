package com.pricing.data.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PricingDataXMLListVO implements Serializable
{
    private static final long serialVersionUID = 1L;
     

    private List<PricingDataXMLVO> root = new ArrayList<PricingDataXMLVO>();


	public List<PricingDataXMLVO> getRoot() {
		return root;
	}


	public void setRoot(List<PricingDataXMLVO> root) {
		this.root = root;
	}
    
    
}
