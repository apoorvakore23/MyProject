package com.niit.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class TestProduct {
public static void main(String[] args) {
	Product p=new Product(102,"Samsung");
	//p.setId(101);
	//p.setName("IPhoone");
	p.setPrice(65000);
	Supplier s1=new Supplier("sup101","tv","mumbai");
	Supplier s2=new Supplier("sup102","tv","mumbai");
	Supplier s3=new Supplier("sup103","tv","mumbai");
 System.out.println("ID:"+p.getId());
 System.out.println("Name:"+p.getName());
 System.out.println("Price:"+p.getPrice());
  
List<Supplier> supplierList=new ArrayList<Supplier>();
supplierList.add(s1);
supplierList.add(s2);
supplierList.add(s3);

p.setSuppliers(supplierList);

List <Supplier> supplier =p.getSuppliers();
for(Supplier s:supplier){	
	System.out.println(s.getAddress());
	System.out.println(s.getId());
	System.out.println(s.getName());
}

 

}
	
}
