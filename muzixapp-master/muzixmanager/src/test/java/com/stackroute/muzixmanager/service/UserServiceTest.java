package com.stackroute.muzixmanager.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.muzixmanager.exception.MuzixAlreadyExistsException;
import com.stackroute.muzixmanager.exception.MuzixNotFoundException;
import com.stackroute.muzixmanager.MuzixManagerApplicationTests;
import com.stackroute.muzixmanager.dto.Muzix;
import com.stackroute.muzixmanager.entity.BookmarkEntity;
import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.entity.SearchHistoryEntity;
import com.stackroute.muzixmanager.entity.UserEntity;
import com.stackroute.muzixmanager.repository.BookmarkRepository;
import com.stackroute.muzixmanager.repository.UserRepository;
import com.stackroute.muzixmanager.service.UserService;
import java.util.Date;

public class UserServiceTest {
	

	@Mock
	private UserRepository userRepository;// DAO Repo layer
	
	@InjectMocks
	private UserService userService; //Injecting mock objects into UserService real object // Impl
	
	
	@Autowired
	private MockMvc mockMvc;
	
	
	transient Optional<UserEntity> options;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(userService).build();
	}
	
	
	@Test
	public void  getUserByUserIdTest()
	{
		BookmarkEntity bookmarkEntity = new BookmarkEntity();
		bookmarkEntity.setBookmarkId((long)1);
		List<BookmarkEntity> bookmarkList= new ArrayList();
		bookmarkList.add(bookmarkEntity);

		
		UserEntity user = Mockito.mock(UserEntity.class);
		user.setUserId("r@0007");
		user.setFirstName("Ramesh");
		user.setLastName("Reddy");
		user.setCreated( new Date ());
		user.setBookmarkEntities(bookmarkList);
	    options=Optional.of(user);
		when(userRepository.findById("r@0007")).thenReturn(options);
	     UserEntity rstUser= userService.getUserByUserId("r@0007");
	     assertEquals(rstUser,user);
	
	
	
	}
	
	@Test
	public void  getUserByInvalidUserIdTest()
	{
		BookmarkEntity bookmarkEntity = new BookmarkEntity();
		bookmarkEntity.setBookmarkId((long)1);
		List<BookmarkEntity> bookmarkList= new ArrayList();
		bookmarkList.add(bookmarkEntity);

		
		UserEntity user = Mockito.mock(UserEntity.class);
		user.setUserId("r@0007");
		user.setFirstName("Ramesh");
		user.setLastName("Reddy");
		user.setCreated( new Date ());
		user.setBookmarkEntities(bookmarkList);
	    options=Optional.of(user);
		when(userRepository.findById("r@0007")).thenReturn(options);
	     UserEntity rstUser= userService.getUserByUserId("amal007");
	     assertEquals(rstUser,null);
	
	}
	
	@Test
	public void getPlaylistsTest() {
		
		PlaylistEntity playlistEntity= new PlaylistEntity();
		playlistEntity.setPlaylistId((long) 1);
		List<PlaylistEntity> playList= new ArrayList();
		playList.add(playlistEntity);

		UserEntity user = Mockito.mock(UserEntity.class);
		user.setUserId("r@0007");
		user.setFirstName("Ramesh");
		user.setLastName("Reddy");
		user.setCreated( new Date ());
		
		user.setPlaylistEntities(playList);
		  options=Optional.of(user);
	//	List <UserEntity> userEntityList= new ArrayList();
 		
	//	when(userRepository.findAll()).thenReturn(userEntityList);
		when(userRepository.findById("r@0007")).thenReturn(options);
		List <PlaylistEntity> rstPlayerList= userService.getPlaylists("r@0007");
		assertEquals(rstPlayerList,user.getPlaylistEntities());
	
	
	}
	
	@Test
	public void getPlaylistsInvalidUserTest() {
		
		PlaylistEntity playlistEntity= new PlaylistEntity();
		playlistEntity.setPlaylistId((long) 1);
		List<PlaylistEntity> playList= new ArrayList();
		playList.add(playlistEntity);

		UserEntity user = Mockito.mock(UserEntity.class);
		user.setUserId("r@0007");
		user.setFirstName("Ramesh");
		user.setLastName("Reddy");
		user.setCreated( new Date ());
		
		user.setPlaylistEntities(playList);
		  options=Optional.of(user);
	//	List <UserEntity> userEntityList= new ArrayList();
 		
	//	when(userRepository.findAll()).thenReturn(userEntityList);
		when(userRepository.findById("r@0007")).thenReturn(options);
		List <PlaylistEntity> rstPlayerList= userService.getPlaylists("amal007");
		assertEquals(rstPlayerList,null);
	
	
	}
	
	
	@Test
	public void getBookmarksTest() {
		
		BookmarkEntity bookmarkEntity = new BookmarkEntity();
		bookmarkEntity.setBookmarkId((long)1);
		List<BookmarkEntity> bookmarkList= new ArrayList();
		bookmarkList.add(bookmarkEntity);

		UserEntity user = Mockito.mock(UserEntity.class);
		user.setUserId("r@0007");
		user.setFirstName("Ramesh");
		user.setLastName("Reddy");
		user.setCreated( new Date ());
		
		user.setBookmarkEntities(bookmarkList);
		  options=Optional.of(user);
	//	List <UserEntity> userEntityList= new ArrayList();
 		
	//	when(userRepository.findAll()).thenReturn(userEntityList);
		when(userRepository.findById("r@0007")).thenReturn(options);
		List <BookmarkEntity> rstBookMarkList= userService.getBookmarks("r@0007");
		assertEquals(rstBookMarkList,user.getBookmarkEntities());
	
	
	}
	
	
	@Test
	public void getBookmarksInvalidUserTest() {
		
		BookmarkEntity bookmarkEntity = new BookmarkEntity();
		bookmarkEntity.setBookmarkId((long)1);
		List<BookmarkEntity> bookmarkList= new ArrayList();
		bookmarkList.add(bookmarkEntity);

		UserEntity user = Mockito.mock(UserEntity.class);
		user.setUserId("r@0007");
		user.setFirstName("Ramesh");
		user.setLastName("Reddy");
		user.setCreated( new Date ());
		
		user.setBookmarkEntities(bookmarkList);
		  options=Optional.of(user);
	//	List <UserEntity> userEntityList= new ArrayList();
 		
	//	when(userRepository.findAll()).thenReturn(userEntityList);
		when(userRepository.findById("r@0007")).thenReturn(options);
		List <BookmarkEntity> rstBookMarkList= userService.getBookmarks("amal0007");
		assertEquals(rstBookMarkList,null);
	
	
	}
	
	
	
}




























