
package ac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class actionllll  {

   private String Name;
   private String Age;
   private String Country;
   private String Title;
   private String AuthorID;
   public String execute() {
      String ret = "error";
      Connection conn = null;

      try {
         String URL = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_phtushusousuo";
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(URL, "kzzl1z1wk2", "4zhhwj2m4lhky320mj4kz1y1xhx0m54iyl125xxk");
         String sql = "SELECT * FROM author WHERE";
         sql+=" Name = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, Name);
         ResultSet rs = ps.executeQuery();
         while (rs.next()) {
        	 AuthorID = rs.getString(1);
        	 Name = rs.getString(2);
        	 Age = rs.getString(3);
        	 Country=rs.getString(4);
        	 System.out.println(AuthorID);
         }
         String sql1 = "SELECT Title FROM book WHERE";
         sql1+=" AuthorID = ?";
         PreparedStatement qs = conn.prepareStatement(sql1);
         qs.setString(1, AuthorID);
         System.out.println(AuthorID);
         ResultSet ks = qs.executeQuery();
         while (ks.next()) {
        	 Title = ks.getString(1); 
        	 System.out.println(Title);
              ret = "success";
         }
      }
      catch (Exception e) {
        ret = "error";
     } 
      finally {
         if (conn != null) {
            try {
               conn.close();
            } 
            catch (Exception e) {
            }
         }
      }
      ret = "success";
      return ret;
   }

   public String getName() {
      return Name;
   }

   public void setName(String Name) {
      this.Name = Name;
   }

   public String getTitle() {
      return Title;
   }

   public void setTitle(String Title) {
      this.Title = Title;
    }

   public String getAuthorID() {
      return AuthorID;
 }

   public void setAuthorID(String AuthorID) {
      this.AuthorID = AuthorID;
   }
   public String getAge() {
	      return Age;
	   }

	   public void setAge(String Age) {
	      this.Age = Age;
	   }
	   public String getCountry() {
		      return Country;
		   }

		   public void setCountry(String Country) {
		      this.Country = Country;
		   }
}