package com.bluemobi.util.SortUtils;

import java.util.Collections;
import java.util.List;

import com.bluemobi.util.ComparatorList;
import com.bluemobi.util.ComparatorListUtil;




public class SortUtils {
	
	@SuppressWarnings("unchecked")
	public static void sortObjectByColumn(List  list,	String sortColumn){
		ComparatorList comp = new ComparatorList();
		comp.setSortColumn(sortColumn);
		Collections.sort(list, comp);
	
	}
	@SuppressWarnings("unchecked")
	public static void sortObjectByIntgerColumn(List  list,	String sortColumn){
		ComparatorListUtil comp = new ComparatorListUtil();
		comp.setSortColumn(sortColumn);
		Collections.sort(list, comp);
	
	}
	
   public static void main(String[] args) {
	/*   List<Brand> list=new ArrayList<Brand>();
       Brand brand1=new Brand();
       brand1.setName("宝马");
       Brand brand2=new Brand();
       brand2.setName("奥迪");
       Brand brand3=new Brand();
       brand3.setName("凯迪");
       Brand brand4=new Brand();
       brand4.setName("baa");
       list.add(brand1);
       list.add(brand2);
       list.add(brand3);
       list.add(brand4);
       SortUtils.sortObjectByColumn(list, "name");
       for(Brand b:list){
			System.out.println(b.getName());
			
		}*/
    }

}
