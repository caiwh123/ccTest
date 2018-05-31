package com.bluemobi.util;


import java.util.Comparator;

import com.bluemobi.util.ObjectUtils;

public class ComparatorListUtil implements Comparator{
	   private String sortColumn;
	   @Override
	    public int compare(Object lhs, Object rhs) {
	        Byte s1 = (Byte) ObjectUtils.invokeGet(lhs, sortColumn);
	        Byte s2 =(Byte) ObjectUtils.invokeGet(rhs, sortColumn);

	        
	        return (int)(s1-s2);
	    }
	    
	    
	    public String getSortColumn() {
			return sortColumn;
		}


		public void setSortColumn(String sortColumn) {
			this.sortColumn = sortColumn;
		}

}
