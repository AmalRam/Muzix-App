package com.stackroute.muzixmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.*;

import com.stackroute.muzixmanager.dto.Bookmark;
import com.stackroute.muzixmanager.entity.BookmarkEntity;
import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.entity.UserEntity;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;



@RunWith(SpringRunner.class)
@WebMvcTest(MuzixServiceController.class)
public class MuzixServiceControllerTest {
	
	
	@Test(priority=1)
	public void updatePlaylistTest() {
		

	String token =" eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODI4NjA5fQ.5qYVDJiQCaEPOM6BsRJZPIkghUQlr3MhVayAdtkSyVc";
		
	HashMap data = new HashMap();
	data.put("muzixId", 700);
	data.put("mbid", " corona");
	data.put("name", "uuu");
	data.put("artist", "uuuu");
	data.put("url", "iiiii");
	data.put("imageUrl", "jjjj");

	 Response res=
	
given().header("Authorization", "Bearer " + token).contentType("application/json").with().body(data).when().post("http://localhost:8082/api/v1/muzixService/updatePlaylist")
.then().statusCode(201).log().body().extract().response();
	
	
	}
	
	
	
	
	
	@Test(priority=2)
	public void deletePlaylistTest() {
		String token =" eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODI4NjA5fQ.5qYVDJiQCaEPOM6BsRJZPIkghUQlr3MhVayAdtkSyVc";
		Response res=given().header("Authorization", "Bearer " + token).contentType("application/json").when().delete("http://localhost:8082/api/v1/muzixService/muzix/deletePlaylist/3/6")
				.then().statusCode(201).log().body().extract().response();
	
	
	}
	

  @Test(priority=3)
	public void getPlaylistTest() {
		
		String token =" eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODI4NjA5fQ.5qYVDJiQCaEPOM6BsRJZPIkghUQlr3MhVayAdtkSyVc";
		Response res=given().header("Authorization", "Bearer " + token).contentType("application/json").when().get("http://localhost:8082/api/v1/muzixService/getPlaylistByUser")
				.then().statusCode(200).log().body().extract().response();
	
	
	}
	
	@Test(priority=4)
	public void bookMarkTest() {
		
		String token =" eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODI4NjA5fQ.5qYVDJiQCaEPOM6BsRJZPIkghUQlr3MhVayAdtkSyVc";
		Response res=given().header("Authorization", "Bearer " + token).contentType("application/json").when().get("http://localhost:8082/api/v1/muzixService/bookmark")
				.then().statusCode(200).log().body().extract().response();
	
	
	}
	
	
	@Test(priority=5)
	public void saveMuzixTest() {
		String token =" eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODI4NjA5fQ.5qYVDJiQCaEPOM6BsRJZPIkghUQlr3MhVayAdtkSyVc";
		HashMap data = new HashMap();
		data.put("muzixId", 11);
		data.put("mbid", " corona");
		data.put("name", "uuu ");
		data.put("artist", "uuuu ");
		data.put("url", "iiiii ");
		data.put("imageUrl", " jjjj");

		 Response res=
		
	given().header("Authorization", "Bearer " + token).contentType("application/json").with().body(data).when().post("http://localhost:8082/api/v1/muzixService/saveMuzix")
	.then().statusCode(201).log().body().extract().response();
	
	
	}
	
	
		
	@Test(priority=6)
	public void suggestedTest() {
		String token =" eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODI4NjA5fQ.5qYVDJiQCaEPOM6BsRJZPIkghUQlr3MhVayAdtkSyVc";	
		  HashMap data = new HashMap(); 
		  data.put("searchHistoryId", 11);
		  data.put("searchData", "BTS "); 
		  data.put("artistName", "uuuu ");
		  data.put("userId", " Amal");
		 
		
		Response res=
				given().header("Authorization", "Bearer " + token).contentType("application/json").with().when().get("http://localhost:8082/api/v1/muzixService/suggested")
				.then().statusCode(200).log().body().extract().response();
	}
	
	@Test(priority=7)
	public void saveSearchTest() {
		String token =" eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODI4NjA5fQ.5qYVDJiQCaEPOM6BsRJZPIkghUQlr3MhVayAdtkSyVc";
		HashMap data = new HashMap();
		data.put("searchHistoryId", 700);
		data.put("userId", " Amal");
		data.put("searchData", "BTS ");
		data.put("artistName", "uuuu ");
	
		Response res=
	
		given().header("Authorization", "Bearer " + token).contentType("application/json").with().body(data).when().post("http://localhost:8082/api/v1/muzixService/saveSearchHistory")
		.then().statusCode(201).log().body().extract().response();
		
	
	}
	
	//@Test(priority=8)
	public void createBookMarkTest() {
		
		
		
		BookmarkEntity bookmark= new BookmarkEntity();
		PlaylistEntity playlistEntity =new PlaylistEntity();
		MuzixEntity muzixEntity=new MuzixEntity();
		UserEntity user = new UserEntity();
		
		playlistEntity.setPlaylistId((long) 12);
		playlistEntity.setPlaylistName("M1");
		playlistEntity.getUserEntity();
		List <PlaylistEntity> playlist1=new ArrayList<>();
		
		

		bookmark.setBookmarkId((long)12);
		bookmark.setMuzix(muzixEntity);
		bookmark.setUserEntity(user);
		List <BookmarkEntity> bookmarklist=new ArrayList<>();
		
		
		
		user.setUserId("amal");
		user.setFirstName("amal");
		user.setLastName("amal");
		user.setPassword("amal");
		user.setPlaylistEntities(playlist1);
		user.setBookmarkEntities(bookmarklist);
		
		
		
		muzixEntity.setMbid("corona");
		muzixEntity.setMuzixId(2);
		muzixEntity.setName("uuu");
		muzixEntity.setUrl("iiiii");
		muzixEntity.setArtist("uuuu");
		muzixEntity.setBookmarkEntity(bookmarklist);
		muzixEntity.setPlaylistEntity(playlist1);
		
		
		
		
		 HashMap data = new HashMap();
		  data.put("bookmarkId", 1);  
		  data.put("userEntity", user);
		  data.put("muzix",muzixEntity);
		
		 
		  String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODkwMTg0fQ.M4xZPoiV8XARSbFXTBzPya1CocmJGGkaW6x-VqFkdvk";  
		given().header("Authorization", "Bearer " + token).contentType("application/json").with().body(data).when().post("http://localhost:8082/api/v1/muzixService/createbookmark")
		.then().statusCode(201).log().body().extract().response();

	
	}
	
	//@Test(priority=9)
	public void saveMuzixsTest() {
		String token =" eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODI4NjA5fQ.5qYVDJiQCaEPOM6BsRJZPIkghUQlr3MhVayAdtkSyVc"; HashMap data = new HashMap();
		  data.put("muzixId", 11); 
		  data.put("mbid", " corona"); 
		  data.put("name", "uuu "); 
		  data.put("artist", "uuuu ");
		  data.put("url", "iiiii");
		  data.put("imageUrl", " jjjj");
		 Response res=
		
	given().header("Authorization", "Bearer " + token).contentType("application/json").with().body(data).when().post("http://localhost:8082/api/v1/muzixService/saveMuzixs")
	.then().statusCode(201).log().body().extract().response();
	
	
	}

	@Test(priority=10)
		public void getMuzixListTest() {
		String token =" eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODI4NjA5fQ.5qYVDJiQCaEPOM6BsRJZPIkghUQlr3MhVayAdtkSyVc"; HashMap data = new HashMap();
			  data.put("muzixId", 11); 
			  data.put("mbid", " corona"); 
			  data.put("name", "uuu "); 
			  data.put("artist", "uuuu ");
			  data.put("url", "iiiii");
			  data.put("imageUrl", "jjjj");
			Response res=
			
		given().header("Authorization", "Bearer " + token).contentType("application/json").with().body(data).when().post("http://localhost:8082/api/v1/muzixService/muzix")
		.then().statusCode(201).log().body().extract().response();
		
		}
	
	@Test(priority=11)
	public void deletePlaylistFailureTest() {
		String token =" eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFsIiwiaWF0IjoxNjEzODI4NjA5fQ.5qYVDJiQCaEPOM6BsRJZPIkghUQlr3MhVayAdtkSyVc";
		Response res=given().header("Authorization", "Bearer " + token).contentType("application/json").when().delete("http://localhost:8082/api/v1/muzixService/muzix/deletePlaylist/3/6")
				.then().statusCode(409).log().body().extract().response();
	
	
	}
}
