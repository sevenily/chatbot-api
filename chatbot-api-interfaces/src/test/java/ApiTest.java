import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @ClassName: ApiTest
 * @Description: 单元测试
 * @Author: seven
 * @CreateTime: 2023-02-15 14:22
 * @Version: 1.0
 **/
@SpringBootTest
public class ApiTest {

    @Test
    public void query_zsxq() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        httpGet.setHeader("cookie", "UM_distinctid=184a8789f9ae64-0918d5b9307eed-26021c51-1fa400-184a8789f9bfb0; zsxq_access_token=E8678073-5610-9636-2AFE-5316F780F596_0AF063E36A53EBEC; zsxqsessionid=7b2dffd488d86e1712c45175b14ad844; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22418852485284518%22%2C%22first_id%22%3A%221849e0e56ba133-0424cd5ca338d18-26021c51-2073600-1849e0e56bbfc7%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg0OWUwZTU2YmExMzMtMDQyNGNkNWNhMzM4ZDE4LTI2MDIxYzUxLTIwNzM2MDAtMTg0OWUwZTU2YmJmYzciLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTg4NTI0ODUyODQ1MTgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22418852485284518%22%7D%2C%22%24device_id%22%3A%221849e0e56ba133-0424cd5ca338d18-26021c51-2073600-1849e0e56bbfc7%22%7D; abtest_env=product");
        httpGet.setHeader("content-Type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(httpGet);

        if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
            System.out.println(EntityUtils.toString(response.getEntity()));
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/584154821182844/comments");

        httpPost.setHeader("cookie", "UM_distinctid=184a8789f9ae64-0918d5b9307eed-26021c51-1fa400-184a8789f9bfb0; zsxq_access_token=E8678073-5610-9636-2AFE-5316F780F596_0AF063E36A53EBEC; zsxqsessionid=7b2dffd488d86e1712c45175b14ad844; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22418852485284518%22%2C%22first_id%22%3A%221849e0e56ba133-0424cd5ca338d18-26021c51-2073600-1849e0e56bbfc7%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg0OWUwZTU2YmExMzMtMDQyNGNkNWNhMzM4ZDE4LTI2MDIxYzUxLTIwNzM2MDAtMTg0OWUwZTU2YmJmYzciLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTg4NTI0ODUyODQ1MTgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22418852485284518%22%7D%2C%22%24device_id%22%3A%221849e0e56ba133-0424cd5ca338d18-26021c51-2073600-1849e0e56bbfc7%22%7D; abtest_env=product");
        httpPost.setHeader("content-Type", "application/json; charset=UTF-8");

        String paramJSON = "{\"req_data\":{\"text\":\"1. java 程序语言设计\\n2. spring源码\\n\",\"image_ids\":[],\"mentioned_user_ids\":[]}}";

        StringEntity stringEntity = new StringEntity(paramJSON, ContentType.create("application/json", "utf-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);

        if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
            System.out.println(EntityUtils.toString(response.getEntity()));
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
