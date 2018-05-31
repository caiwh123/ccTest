package com.bluemobi.util;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;





public class ComparatorList implements Comparator {
	
	private String sortColumn;

    @Override
    public int compare(Object lhs, Object rhs) {
    	

        String s1 = (String) ObjectUtils.invokeGet(lhs, sortColumn);
        String s2 =(String) ObjectUtils.invokeGet(rhs, sortColumn);

		String pj1 = ChineseToEnglish.getPinYinHeadChar(s1);
        String pj2 = ChineseToEnglish.getPinYinHeadChar(s2);
        
        return Collator.getInstance(Locale.CHINESE).compare(pj1, pj2);
    }
    
    
    public String getSortColumn() {
		return sortColumn;
	}


	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}


	public static void main(String[] args) {
    	
    	
	}
}
