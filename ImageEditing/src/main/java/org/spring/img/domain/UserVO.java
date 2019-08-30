package org.spring.img.domain;

public class UserVO {
private String userId;
private String userPw;
private String userNm;
private int userPoint;
private boolean useCookie;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserPw() {
	return userPw;
}
public void setUserPw(String userPw) {
	this.userPw = userPw;
}
public String getUserNm() {
	return userNm;
}
public void setUserNm(String userNm) {
	this.userNm = userNm;
}
public int getUserPoint() {
	return userPoint;
}
public void setUserPoint(int userPoint) {
	this.userPoint = userPoint;
}
public boolean isUseCookie() {
	return useCookie;
}
public void setUseCookie(boolean useCookie) {
	this.useCookie = useCookie;
}
@Override
public String toString() {
	return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userNm=" + userNm + ", userPoint=" + userPoint
			+ ", useCookie=" + useCookie + "]";
}
 






}
