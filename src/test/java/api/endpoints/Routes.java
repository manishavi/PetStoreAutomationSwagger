package api.endpoints;


/*
 * 
 * Swagger URI ----> https://petstore.swagger.io
 * 
 * 
	Create user(Post) : https://petstore.swagger.io/v2/user
	Get user (Get): https://petstore.swagger.io/v2/user/{username}
	Update user (Put) : https://petstore. swagger. io/v2/user/{username} 
	Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
	
*/
	
public class Routes {	
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User module
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String put_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//pet module
	public static String p_post_url = base_url+"/pet";
	public static String p_get_url = base_url+"/pet/{petId}";
	public static String p_put_url = base_url+"/pet";
	public static String p_delete_url = base_url+"/pet/{petId}";
	

	//store module
	public static String s_post_url = base_url+"/store/order";
	public static String s_get_url = base_url+"/store/order/{orderId}";
	public static String s_Invt_get_url = base_url+"/store/inventory";
	public static String s_delete_url = base_url+"/store/order/{orderId}";
}
