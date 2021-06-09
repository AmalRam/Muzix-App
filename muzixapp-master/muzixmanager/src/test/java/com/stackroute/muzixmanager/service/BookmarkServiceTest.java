package com.stackroute.muzixmanager.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.muzixmanager.exception.MuzixAlreadyExistsException;
import com.stackroute.muzixmanager.exception.MuzixNotFoundException;
import com.stackroute.muzixmanager.MuzixManagerApplicationTests;
import com.stackroute.muzixmanager.dto.Muzix;

import com.stackroute.muzixmanager.entity.BookmarkEntity;
import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.entity.UserEntity;
import com.stackroute.muzixmanager.repository.BookmarkRepository;
import com.stackroute.muzixmanager.service.BookmarkService;
import java.util.Date;


public class BookmarkServiceTest {
	@Mock
	private transient BookmarkRepository bookmarkRepo;
	@InjectMocks
	private BookmarkService muzixManagerSBookmarkService;
	@Autowired
	private MockMvc mockMvc;
	transient Optional<BookmarkEntity> options;


	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(muzixManagerSBookmarkService).build();
	}
	
	@Test
	public void createBookMarkTest() throws MuzixAlreadyExistsException {
		
		BookmarkEntity createbookmark = Mockito.mock(BookmarkEntity.class);
		
		createbookmark.setBookmarkId((long) 25);	
		UserEntity entity = new UserEntity();
		createbookmark.setUserEntity(entity);
		MuzixEntity muzix = new MuzixEntity();	
		createbookmark.setMuzix(muzix);

		options=Optional.of(createbookmark);
		when(bookmarkRepo.findById((long) 25)).thenReturn(options);
		
		final boolean flag = muzixManagerSBookmarkService.createBookMark(createbookmark);
		assertTrue(flag);
	}
	
	@Test
	public void deleteBookmarkTest() throws MuzixNotFoundException {
			
		BookmarkEntity bookmark = Mockito.mock(BookmarkEntity.class);
		bookmark.setBookmarkId((long) 25);
		UserEntity user = new UserEntity();
		bookmark.setUserEntity(user);
		MuzixEntity muzix = new MuzixEntity();
		bookmark.setMuzix(muzix);
		
		options=Optional.of(bookmark);
		when(bookmarkRepo.findById((long) 25)).thenReturn(options);
		doNothing().when(bookmarkRepo).deleteById((long) 25);
		final boolean flag = muzixManagerSBookmarkService.deleteBookmark((long) 25);
		assertTrue(flag);
	}
	
	@Test
	public void getBookmarksByUserIdTest() {
		
		BookmarkEntity getBookmark = Mockito.mock(BookmarkEntity.class);
		getBookmark.setBookmarkId((long) 25);	
		UserEntity entity = new UserEntity();
		getBookmark.setUserEntity(entity);
		MuzixEntity muzix = new MuzixEntity();	
		getBookmark.setMuzix(muzix);
		
		final List<BookmarkEntity> getBookmarks = new ArrayList<>(25);
		when(bookmarkRepo.findAll()).thenReturn(getBookmarks);
		final List<BookmarkEntity> newList = muzixManagerSBookmarkService.getBookmarksByUserId((long) 25);
		assertEquals(newList, getBookmarks);
	
}

	
}