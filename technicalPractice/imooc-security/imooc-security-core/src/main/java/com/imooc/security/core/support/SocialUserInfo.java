/**
 * 
 */
package com.imooc.security.core.support;

import lombok.Data;

/**
 * 用于展示的用户信息
 * @author Jiahao Wang
 * @date 2021/1/26 8:57
 */
@Data
public class SocialUserInfo {
	
	private String providerId;
	
	private String providerUserId;
	
	private String nickname;
	
	private String headImg;
	
}
