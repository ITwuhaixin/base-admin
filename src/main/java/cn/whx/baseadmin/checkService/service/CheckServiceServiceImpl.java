package cn.whx.baseadmin.checkService.service;

import cn.whx.baseadmin.util.HttpClientUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

/**
 * @author haixin_wu
 * @description ${DESCRIPTION}
 * @create 2021-05-30
 */
@Service
public class CheckServiceServiceImpl implements CheckServiceService {

    @Value("${service.api_key}")
    private String API_KEY;

    @Value("${service.service101.api_link}")
    private String SERVICE101_API_LINK;

    @Override
    public void service101(List<String> imeis) {
        String apiLink = SERVICE101_API_LINK.replace("PUT_YOUR_API_KEY_HERE", API_KEY);
        if( CollectionUtils.isNotEmpty(imeis) ){
            imeis.forEach(s -> {
                String realUri = apiLink.replace("PUT_YOUR_IMEI_HERE", s);
                //调用http接口
//                String responseString = HttpClientUtil.doGet(realUri);
                System.out.println(realUri);

            });
        }

    }


}
