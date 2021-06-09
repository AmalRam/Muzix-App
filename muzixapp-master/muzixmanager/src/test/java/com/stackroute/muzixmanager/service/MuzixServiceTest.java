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

import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.entity.PlaylistEntity;
import com.stackroute.muzixmanager.entity.UserEntity;
import com.stackroute.muzixmanager.repository.BookmarkRepository;
import com.stackroute.muzixmanager.repository.MuzixRepository;
import com.stackroute.muzixmanager.service.BookmarkService;
import java.util.Date;


public class MuzixServiceTest {
        @Mock
		private MuzixRepository muzixRepo;
		@InjectMocks
		private MuzixService muzixService;
		@Autowired
		private MockMvc mockMvc;
		private MuzixEntity muzixEntity =Mockito.mock(MuzixEntity.class);
		transient Optional<MuzixEntity> options;
		

		@Before
		public void setupMock() {
			MockitoAnnotations.initMocks(this);
			mockMvc= MockMvcBuilders.standaloneSetup(muzixService).build();
		}
		
		@Test
		public void saveMuzixTest()  {
			muzixEntity.setMuzixId((int)14);
			muzixEntity.setMbid("BLACKPINK");
			muzixEntity.setName("Ice Cream (with Selena Gomez)");
			muzixEntity.setArtist("gokul");
			muzixEntity.setUrl("Ice Cream (with Selena Gomez)");
			muzixEntity.setImageUrl("gokul");
			muzixService.saveMuzix(muzixEntity);
			when(muzixRepo.save(muzixEntity)).thenReturn(muzixEntity);
			final boolean flag = muzixService.saveMuzix(muzixEntity);
			assertTrue(flag);
		
		}
		
		
		@Test 
		public void saveMuzixsTest() {
			
			muzixEntity.setMuzixId((int)14);
			muzixEntity.setMbid("BLACKPINK");
			muzixEntity.setName("Ice Cream (with Selena Gomez)");
			muzixEntity.setArtist("gokul");
			muzixEntity.setUrl("Ice Cream (with Selena Gomez)");
			muzixEntity.setImageUrl("gokul");
			muzixService.saveMuzix(muzixEntity);
			List <MuzixEntity> list = new ArrayList<>();
			list.add(muzixEntity);
			muzixService.saveMuzixs(list);
			when(muzixRepo.save(muzixEntity)).thenReturn(muzixEntity);  
			final boolean flag = muzixService.saveMuzixs(list);
			assertTrue(flag);
		}
		
		@Test 		
		public void getMuzixByMusixIdTest() {
					
					muzixEntity.setMuzixId((int)14);
					muzixEntity.setMbid("BLACKPINK");
					muzixEntity.setName("Ice Cream (with Selena Gomez)");
					muzixEntity.setArtist("gokul");
					muzixEntity.setUrl("Ice Cream (with Selena Gomez)");
					muzixEntity.setImageUrl("gokul");
					muzixService.saveMuzix(muzixEntity);
					options=Optional.of(muzixEntity);
					muzixService.getMuzixByMusixId(14);
					when(muzixRepo.findById(14)).thenReturn(options);  
					MuzixEntity m1= muzixService.getMuzixByMusixId(14);
					assertEquals(muzixEntity,m1);
				
	   }
		
		
		
}