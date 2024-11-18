package composite_key.controller;

import composite_key.dto.Amazon;
import composite_key.dto.Amazon_Id;

public class Composite_Controller {

	public static void main(String[] args) {

		Amazon_Id id = new Amazon_Id();
		id.setEmail("manish.gmail.com");
		id.setMobNo("1234556");

		Amazon amazon = new Amazon();
		amazon.setAddress("thane");
		amazon.setName("manish");
		amazon.setPass("qshws52");
		amazon.setId(id);

	}

}
