package com.tech.whale.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.whale.community.dto.PostDto;
import com.tech.whale.feed.dto.FeedDto;
import com.tech.whale.search.models.SearchDao;
import com.tech.whale.setting.dto.UserInfoDto;

@Service
public class SearchService {
	@Autowired
	private SearchDao searchDao;
	
	public List<UserInfoDto> getSearchUserService(String keyword) {
		List<UserInfoDto> resultList = new ArrayList<>();
		List<UserInfoDto> userLists = searchDao.selectSearchUserInfo();
		
		if (keyword == null) {
			keyword="";
		}
		// 검색어 공백 제거
	    String cleanedKeyword = keyword.replaceAll("\\s+", "").toLowerCase();

	    // 검색어를 한 글자씩 나누기
	    String[] keywordChars = cleanedKeyword.split("");
	    
	    for (UserInfoDto userList : userLists) {
	        String cleanedUserName = userList.getUser_id().replaceAll("\\s+", "").toLowerCase();
	        String cleanedUserNick = userList.getUser_nickname().replaceAll("\\s+", "").toLowerCase();
	             

	        // 검색어의 각 문자가 포함되는지 체크
	        boolean[] isMatch = new boolean[] { true, true };
	        for (String searchChar : keywordChars) {
	            if (!cleanedUserName.contains(searchChar)) {
	                isMatch[0] = false;
	                break;
	            }
	        }
	        for (String searchChar : keywordChars) {
	            if (!cleanedUserNick.contains(searchChar)) {
	                isMatch[1] = false;
	                break;
	            }
	        }

	        // 모든 문자들이 포함되면 결과 리스트에 추가
	        if (isMatch[0] || isMatch[1]) {
	            resultList.add(userList);
	        }
	    }
	    
	    return resultList;
	}
	
	public List<PostDto> getSearchPostService(String keyword) {
		List<PostDto> resultList = new ArrayList<>();
		List<PostDto> postLists = searchDao.selectSearchPostInfo();
		
		if (keyword == null) {
			keyword="";
		}
		// 검색어 공백 제거
	    String cleanedKeyword = keyword.replaceAll("\\s+", "").toLowerCase();

	    // 검색어를 한 글자씩 나누기
	    String[] keywordChars = cleanedKeyword.split("");
	    
	    for (PostDto postList : postLists) {
	        String cleanedUserName = postList.getUser_id().replaceAll("\\s+", "").toLowerCase();
	        String cleanedUserNick = postList.getUser_nickname().replaceAll("\\s+", "").toLowerCase();
	        String cleanedPostTitle = postList.getPost_title().replaceAll("\\s+", "").toLowerCase();
	        String cleanedPostText = postList.getPost_text().replaceAll("\\s+", "").toLowerCase();
	             

	        // 검색어의 각 문자가 포함되는지 체크
	        boolean[] isMatch = new boolean[] { true, true, true, true };
	        for (String searchChar : keywordChars) {
	            if (!cleanedUserName.contains(searchChar)) {
	                isMatch[0] = false;
	                break;
	            }
	        }
	        for (String searchChar : keywordChars) {
	            if (!cleanedUserNick.contains(searchChar)) {
	                isMatch[1] = false;
	                break;
	            }
	        }
	        
	        for (String searchChar : keywordChars) {
	            if (!cleanedPostTitle.contains(searchChar)) {
	                isMatch[2] = false;
	                break;
	            }
	        }
	        
	        for (String searchChar : keywordChars) {
	            if (!cleanedPostText.contains(searchChar)) {
	                isMatch[3] = false;
	                break;
	            }
	        }

	        // 모든 문자들이 포함되면 결과 리스트에 추가
	        if (isMatch[0] || isMatch[1] || isMatch[2] || isMatch[3]) {
	            resultList.add(postList);
	        }
	    }
	    
	    return resultList;
	}
	
	public List<FeedDto> getSearchFeedService(String keyword) {
		List<FeedDto> resultList = new ArrayList<>();
		List<FeedDto> feedLists = searchDao.selectSearchFeedInfo();
		
		if (keyword == null) {
			keyword="";
		}
		// 검색어 공백 제거
	    String cleanedKeyword = keyword.replaceAll("\\s+", "").toLowerCase();

	    // 검색어를 한 글자씩 나누기
	    String[] keywordChars = cleanedKeyword.split("");
	    
	    for (FeedDto feedList : feedLists) {
	        String cleanedUserName = feedList.getUser_id().replaceAll("\\s+", "").toLowerCase();
	        String cleanedUserNick = feedList.getUser_nickname().replaceAll("\\s+", "").toLowerCase();
	        String cleanedFeedText = feedList.getFeed_text().replaceAll("\\s+", "").toLowerCase();
	             

	        // 검색어의 각 문자가 포함되는지 체크
	        boolean[] isMatch = new boolean[] { true, true, true };
	        for (String searchChar : keywordChars) {
	            if (!cleanedUserName.contains(searchChar)) {
	                isMatch[0] = false;
	                break;
	            }
	        }
	        for (String searchChar : keywordChars) {
	            if (!cleanedUserNick.contains(searchChar)) {
	                isMatch[1] = false;
	                break;
	            }
	        }
	        
	        for (String searchChar : keywordChars) {
	            if (!cleanedFeedText.contains(searchChar)) {
	                isMatch[2] = false;
	                break;
	            }
	        }

	        // 모든 문자들이 포함되면 결과 리스트에 추가
	        if (isMatch[0] || isMatch[1] || isMatch[2]) {
	            resultList.add(feedList);
	        }
	    }
	    
	    return resultList;
	}
}
