package com.stackroute.muzixmanager.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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

import com.stackroute.muzixmanager.exception.*;
import com.stackroute.muzixmanager.entity.SearchHistoryEntity;
import com.stackroute.muzixmanager.entity.UserEntity;
import com.stackroute.muzixmanager.repository.SearchHistoryRepository;
import com.stackroute.muzixmanager.service.SearchHistoryService;

public class SearchHistoryServiceTest {

	
	@Mock
	private SearchHistoryRepository searchHistoryRepo;
	@InjectMocks
	private SearchHistoryService searchHistoryService;
	@Autowired
	private MockMvc mockMvc;
	
	transient Optional<SearchHistoryEntity> options;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(searchHistoryService).build();
	}
	
	@Test
	public void saveSearchHistoryTest()  {
		SearchHistoryEntity searchHistoryEntity = Mockito.mock(SearchHistoryEntity.class);
		searchHistoryEntity.setSearchHistoryId((long)14);
		searchHistoryEntity.setArtistName("BLACKPINK");
		searchHistoryEntity.setSearchData("Ice Cream (with Selena Gomez)");
		searchHistoryEntity.setUserId("gokul");
		searchHistoryService.saveSearchHistory(searchHistoryEntity);
		
		options=Optional.of(searchHistoryEntity);

		when(searchHistoryRepo.save(searchHistoryEntity)).thenReturn(searchHistoryEntity);
		final boolean flag = searchHistoryService.saveSearchHistory(searchHistoryEntity);
		assertTrue(flag);
	
	}
	
	
	
	
	
	
	
	
	// @Test
	 public void getSearchHistoryTest() { 	 
		 
	  SearchHistoryEntity searchHistoryEntity =Mockito.mock(SearchHistoryEntity.class);
	  searchHistoryEntity.setSearchHistoryId((long)1);
	  searchHistoryEntity.setArtistName("BLACKPINK");
	  searchHistoryEntity.setSearchData("Ice Cream (with Selena Gomez)");
	  searchHistoryEntity.setUserId("gokul");
	  List <SearchHistoryEntity> searchHistoryList= new ArrayList<>();
	  searchHistoryList.add(searchHistoryEntity);
	  options=Optional.of(searchHistoryEntity);
	  
	//  when(searchHistoryRepo.save(searchHistoryEntity)).thenReturn(searchHistoryEntity);
	  when(searchHistoryRepo.findById((long) 1)).thenReturn(options);
	//  when(searchHistoryRepo.findAll()).thenReturn(searchHistoryList);
	  final SearchHistoryEntity  result = searchHistoryService.getSearchHistory("gokul");
	  assertEquals(result,searchHistoryEntity); 
	
	 }
	 
}