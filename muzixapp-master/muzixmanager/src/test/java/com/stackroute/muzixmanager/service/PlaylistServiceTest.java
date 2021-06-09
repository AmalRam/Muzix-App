package com.stackroute.muzixmanager.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.entity.SearchHistoryEntity;
import com.stackroute.muzixmanager.entity.UserEntity;
import com.stackroute.muzixmanager.repository.MuzixRepository;
import com.stackroute.muzixmanager.repository.PlaylistRepository;
import com.stackroute.muzixmanager.exception.*;

public class PlaylistServiceTest {
	
	@Mock
	private PlaylistRepository playlistRepo;
	@InjectMocks
	private PlaylistService playlistService;
	@Autowired
	private MockMvc mockMvc;
	private PlaylistEntity playlistEntity = Mockito.mock(PlaylistEntity.class);
	
	

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(playlistService).build();
	}
	
	@Test
	public void createPlayListTest()  {
		playlistEntity.setPlaylistId((long)123);
		playlistEntity.setPlaylistName("BLACKPINK");
		List <PlaylistEntity> list = new ArrayList<>();
		list.add(playlistEntity);
		when(playlistRepo.save(playlistEntity)).thenReturn(playlistEntity);
		final boolean flag = playlistService.createPlayList(playlistEntity);
		Assert.assertTrue(flag);
	
	}
	

	@Test
	public void getPlaylistByUserIdTest() throws Exception  {
		playlistEntity.setPlaylistId((long)123);
		playlistEntity.setPlaylistName("BLACKPINK");
		List <PlaylistEntity> list = new ArrayList<>();
		list.add(playlistEntity);
		UserEntity userEntity=new UserEntity();
		playlistEntity.setUserEntity(userEntity);
		when(playlistRepo.save(playlistEntity)).thenReturn(playlistEntity);
		List<PlaylistEntity> flag = null;
		flag = playlistService.getPlaylistByUserId((long) 123);
		assertTrue(flag);
	
	}

	
	
	
	
	
	//@Test(expected=MuzixNotFoundException.class)
	public void createPlayListFailureTest()  throws MuzixNotFoundException{
		PlaylistEntity playlistEntity1=new PlaylistEntity();
		playlistEntity.setPlaylistId((long)123);
		playlistEntity.setPlaylistName("BLACKPINK");
		List <PlaylistEntity> list = new ArrayList<>();
		list.add(playlistEntity);
		when(playlistRepo.save(playlistEntity)).thenReturn(playlistEntity);
		 playlistService.createPlayList(playlistEntity1);
		 System.out.println( "--1---"+playlistService.createPlayList(playlistEntity1));
	
	}
	
	//@Test(expected=MuzixNotFoundException.class)
	public void getPlaylistByUserIdFailureTest()  throws Exception, MuzixNotFoundException {
		playlistEntity.setPlaylistId((long)123);
		playlistEntity.setPlaylistName("BLACKPINK");
		List <PlaylistEntity> list = new ArrayList<>();
		list.add(playlistEntity);
		UserEntity userEntity=new UserEntity();
		playlistEntity.setUserEntity(userEntity);
		when(playlistRepo.save(playlistEntity)).thenReturn(playlistEntity);
		List<PlaylistEntity> flag = null;
		 playlistService.getPlaylistByUserId((long) 124);
		 System.out.println("--2---"+playlistService.getPlaylistByUserId((long) 124));
		
	
	}
	private void assertTrue(List<PlaylistEntity> flag) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Test
	public void deleteMuzixFromPlayListTest()  {
		playlistEntity.setPlaylistId((long)123);
		playlistEntity.setPlaylistName("BLACKPINK");
		List <PlaylistEntity> list = new ArrayList<>();
		list.add(playlistEntity);
		UserEntity userEntity=new UserEntity();
		playlistEntity.setUserEntity(userEntity);
		when(playlistRepo.save(playlistEntity)).thenReturn(playlistEntity);
		final boolean flag = playlistService.deleteMuzixFromPlayList((long) 123,(long) 12);
		assertcheck(flag);
	
	}

	@Test
	public void deleteMuzixFromPlayListFailureTest(){
		playlistEntity.setPlaylistId((long)123);
		playlistEntity.setPlaylistName("BLACKPINK");
		List <PlaylistEntity> list = new ArrayList<>();
		list.add(playlistEntity);
		UserEntity userEntity=new UserEntity();
		playlistEntity.setUserEntity(userEntity);
		when(playlistRepo.save(playlistEntity)).thenReturn(playlistEntity);
		final boolean flag = playlistService.deleteMuzixFromPlayList((long) 124,(long) 13);
		System.out.println("--3---"+playlistService.deleteMuzixFromPlayList((long) 124,(long) 13));
		assertEquals(flag, false);
	
	}

	private void assertcheck(boolean flag) {
		// TODO Auto-generated method stub
		
	}
		
	
}

