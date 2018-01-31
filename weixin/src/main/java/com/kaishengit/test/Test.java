package com.kaishengit.test;

import java.util.Map;

import com.google.common.collect.Maps;
import com.kaishengit.util.HttpClientUtil;

public class Test {

	public static void main(String[] args) {
		Map<String,String> maps = Maps.newHashMap();
		maps.put("name","jack");
		String res = HttpClientUtil.HttpCilentPost("http://localhost:8080/validate", "UTF-8", maps);
		System.out.println(res);
		
		/*// 创建一个客户端对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// 创建post请求对象
		HttpPost post = new HttpPost("http://localhost:8080/validate");
		
		List<NameValuePair> pairsList = new ArrayList<>();
		pairsList.add(new BasicNameValuePair("name","jack"));
		try {
			
			post.setEntity(new UrlEncodedFormEntity(pairsList));
			// 发起post请求，并接收响应数据
			HttpResponse resp = httpClient.execute(post);
			
			int code = resp.getStatusLine().getStatusCode();
			if(code == 200) {
				InputStream in = resp.getEntity().getContent();
				String result = IOUtils.toString(in,"UTF-8");
				System.out.println(result);
			} else {
				System.out.println("请求异常");
			}
			
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
		
		
//		String res = HttpClientUtil.HttpClientGet("http://www.163.com", "GBK");
//		System.out.println(res);
		
		/*// 创建一个客户端对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建get请求对象
		HttpGet get = new HttpGet("http://www.kaishengit.com");
		try {
			// 发起请求并接收相应数据
			HttpResponse resp = httpClient.execute(get);
			// 获取相应的状态码
			int code = resp.getStatusLine().getStatusCode();
			if(code == 200) {
				InputStream in = resp.getEntity().getContent();
				String result = IOUtils.toString(in, "UTF-8");
				System.out.println(result);	
				
			} else {
				System.out.println("请求异常");
			}
			
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
		
	}
	
}
